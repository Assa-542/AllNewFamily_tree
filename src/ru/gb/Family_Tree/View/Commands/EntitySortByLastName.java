package ru.gb.Family_Tree.View.Commands;

import ru.gb.Family_Tree.View.ConsoleUI;

public class EntitySortByLastName extends Command {

    public EntitySortByLastName(ConsoleUI consoleUI) {
        super("Сортировка по фамилии", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByLastName();
    }
}
