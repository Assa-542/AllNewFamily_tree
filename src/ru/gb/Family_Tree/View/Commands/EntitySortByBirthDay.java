package ru.gb.Family_Tree.View.Commands;

import ru.gb.Family_Tree.View.ConsoleUI;

public class EntitySortByBirthDay extends Command{

    public EntitySortByBirthDay(ConsoleUI consoleUI) {
        super("Сортировка по дате рождения", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByBirthDay();
    }
}