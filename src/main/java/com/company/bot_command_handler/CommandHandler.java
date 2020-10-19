package com.company.bot_command_handler;

import com.company.betting_math.ForksFinder;
import com.company.bettings_parser.MarathonBet;

import java.util.*;

public class CommandHandler {
    private Map<String, IHandler> handlerMap;
    private ForksFinder forksFinder;

    public CommandHandler() {
        MarathonBet marathonBet = new MarathonBet();
        forksFinder = new ForksFinder(marathonBet.betOffice);
    }

    public List<String> executeCommand(String commandId) {
        if (commandId.equals("/get")) {
            if (!forksFinder.isForkInit())
                forksFinder.findForksOneOffice();
            return forksFinder.getForks();
        } else if (commandId.equals("/update")) {
            forksFinder.findForksOneOffice();
            return forksFinder.getForks();
        } else {
            return Collections.singletonList("Не известная комманда");
        }
    }
}
