package ru.gb.Family_Tree.View.Commands;

import ru.gb.Family_Tree.View.ConsoleUI;

public class EntityGetList extends Command{

    public EntityGetList(ConsoleUI consoleUI) {
        super("Получить список людей", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getEntityListInfo();
    }
}