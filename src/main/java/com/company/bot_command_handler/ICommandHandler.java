package com.company.bot_command_handler;

import java.util.HashMap;
import java.util.List;

public interface ICommandHandler {

    ReplyMessage executeCommand(String msg, Long chatId);

    void addProcessingCommand(HashMap<String, ICommandHandler> handlerMap);
}
