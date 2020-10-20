package com.company;

import com.company.bot_command_handler.CommandHandler;
import org.checkerframework.checker.units.qual.A;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class ForksBot extends TelegramLongPollingBot {

    private final CommandHandler handler = new CommandHandler();

    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            ArrayList<SendMessage> messages = getMessagesFromCommand(update,
                    handler.executeCommand(update.getMessage().getText()));
            try {
                for (SendMessage sendMessage : messages) {
                    execute(sendMessage);
                }
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    private ArrayList<SendMessage> getMessagesFromCommand(Update update, List<String> msg) {
        ArrayList<SendMessage> messages = new ArrayList<>();
        for (String message : msg) {
            SendMessage sendMessage = new SendMessage()
                    .setChatId(update.getMessage().getChatId())
                    .setText(message);
            messages.add(sendMessage);
        }
        return messages;
    }

    public String getBotUsername() {
        return "ForksScannerBot";
    }

    public String getBotToken() {
        return "";
    }
}
