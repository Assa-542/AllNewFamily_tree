package ru.gb.Family_Tree.View.Commands;

import ru.gb.Family_Tree.View.ConsoleUI;

public class EntityAddParent extends Command {

    public EntityAddParent(ConsoleUI consoleUI) {
        super("Добавить родителя", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addParent();
    }
}
