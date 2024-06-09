package ru.gb.Family_Tree.View.Commands;

import ru.gb.Family_Tree.View.ConsoleUI;

public class EntitySortById extends Command{

    public EntitySortById(ConsoleUI consoleUI) {
        super("Сортировка по индексу", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortById();
    }
}
