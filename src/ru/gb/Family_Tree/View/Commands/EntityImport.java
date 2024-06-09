package ru.gb.Family_Tree.View.Commands;

import ru.gb.Family_Tree.View.ConsoleUI;

public class EntityImport extends Command {

    public EntityImport(ConsoleUI consoleUI) {
        super("Импортировать список (прочитать из файла)", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().importList();
    }
}