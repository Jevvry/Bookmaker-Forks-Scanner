package com.company.bot_command_handler;

public interface IHandler {
    void updateState(String msg);

    String executeCommand(String msg);
}
