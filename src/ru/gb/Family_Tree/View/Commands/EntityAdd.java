package ru.gb.Family_Tree.View.Commands;

import ru.gb.Family_Tree.View.ConsoleUI;

public class EntityAdd extends Command {

    public EntityAdd(ConsoleUI consoleUI) {
        super("Добавить человека", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addEntity();
    }
}