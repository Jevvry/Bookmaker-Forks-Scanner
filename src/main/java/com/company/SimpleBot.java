package com.company;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SimpleBot extends TelegramLongPollingBot {

	private final RequestFactory factory = new RequestFactory();

	public void onUpdateReceived(Update update) {
		if (update.hasMessage() && update.getMessage().hasText()) {
			SendMessage sendMessage = new SendMessage()
					.setChatId(update.getMessage().getChatId())
					.setText(factory.getJoke(update.getMessage().getText()));
			try {
				execute(sendMessage);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}
	}

	public String getBotUsername() {
		return "ForksScannerBot";
	}

	public String getBotToken() {
		return "";
	}
}
