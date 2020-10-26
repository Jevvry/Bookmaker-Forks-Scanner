package com.company.bot_command_handler;

import com.company.betting_math.ForksFinder;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.HashMap;

public class GetForksHandler implements ICommandHandler {
    private ForksFinder finder;
    private HashMap<Long, Integer> idToPage;
    private HashMap<String, Integer> commandOffset;

    public GetForksHandler(ForksFinder forksFinder) {
        finder = forksFinder;
        idToPage = new HashMap<>();
        commandOffset = new HashMap<>();
        commandOffset.put("Next", 1);
        commandOffset.put("Previous", -1);
    }

    @Override
    public ReplyMessage executeCommand(String msg, Long chatId) {
        if (!finder.isForkInit()) {
            finder.findForksOneOffice();
        }
        int nextPage = getNextPage(chatId, msg);
        String fork = finder.getForkPerIndex(nextPage);
        ReplyMessage replyMessage = new ReplyMessage(fork);
        replyMessage.addRows(getKeyboard());
        return replyMessage;
    }

    @Override
    public void addProcessingCommand(HashMap<String, ICommandHandler> handlerMap) {
        handlerMap.put("/get", this);
        handlerMap.put("Next", this);
        handlerMap.put("Previous", this);
    }

    public Integer getNextPage(Long chatId, String msg) {
        Integer nextPage = 0;
        if (!idToPage.containsKey(chatId)) {
            idToPage.put(chatId, 0);
        } else {
            nextPage = idToPage.get(chatId);

            nextPage = (nextPage + commandOffset.get(msg)) % finder.getForksCount();
            idToPage.put(chatId, nextPage);
        }
        if (nextPage < 0)
            nextPage = 0;
        return nextPage;
    }

    private ArrayList<KeyboardRow> getKeyboard() {
        ArrayList<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add("Previous");
        row.add("Next");
        keyboardRows.add(row);
        return keyboardRows;
    }
}
