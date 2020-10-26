package com.company.bot_command_handler;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;

public class ReplyMessage {
    public ReplyKeyboardMarkup replyKeyboardMarkup;
    public String message;

    public ReplyMessage(String message) {
        replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        this.message = message;
    }

    public void addRows(List<KeyboardRow> rows) {
        replyKeyboardMarkup.setKeyboard(rows);
    }

}
