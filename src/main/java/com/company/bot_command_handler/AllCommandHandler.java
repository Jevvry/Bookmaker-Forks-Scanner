package com.company.bot_command_handler;

import com.company.betting_math.ForksFinder;
import com.company.bettings_parser.MarathonBet;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.*;

public class AllCommandHandler {
    private HashMap<String, ICommandHandler> handlerMap;
    private ForksFinder forksFinder;

    public AllCommandHandler() {
        MarathonBet marathonBet = new MarathonBet();
        forksFinder = new ForksFinder(marathonBet.betOffice);
        handlerMap = new HashMap<>();
        GetForksHandler getForksHandler = new GetForksHandler(forksFinder);
        getForksHandler.addProcessingCommand(handlerMap);
    }

    public ReplyMessage executeCommand(Update update) {
        String message = update.getMessage().getText();
        Long chatId = update.getMessage().getChatId();
        if (handlerMap.containsKey(message)) {
            ICommandHandler handler = handlerMap.get(message);
            return handler.executeCommand(message, chatId);
        } else {
            return new ReplyMessage("Не известная комманда: " + message);
        }
    }
}
