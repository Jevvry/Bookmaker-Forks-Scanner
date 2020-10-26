package com.company;

import com.company.bot_command_handler.AllCommandHandler;
import com.company.bot_command_handler.ReplyMessage;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;

public class ForksBot extends TelegramLongPollingBot {

    private final AllCommandHandler handler = new AllCommandHandler();

    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage sendMessage = buildSendMessage(update, handler.executeCommand(update));
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    private SendMessage buildSendMessage(Update update, ReplyMessage msg) {

        return new SendMessage()
                .setChatId(update.getMessage().getChatId())
                .setText(msg.message)
                .setReplyMarkup(msg.replyKeyboardMarkup);

    }

    public String getBotUsername() {
        return "ForksScannerBot";
    }

    public String getBotToken() {
        return "";
    }
}
