package ru.gb.Family_Tree.View.Commands;

import ru.gb.Family_Tree.View.ConsoleUI;

public class FinishCommand extends Command {

    public FinishCommand(ConsoleUI consoleUI) {
        super("Выход", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().finish();
    }
}