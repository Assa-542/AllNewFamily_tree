package ru.gb.Family_Tree.View.Commands;

import ru.gb.Family_Tree.View.ConsoleUI;

public class EntityExport extends Command {

    public EntityExport(ConsoleUI consoleUI) {
        super("Экспортировать список (записать в файл)", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().exportList();
    }
}
