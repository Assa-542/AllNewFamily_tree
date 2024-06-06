package ru.gb.Family_Tree.builder;

import ru.gb.Family_Tree.human.Human;

public class HumanBuilder {

    private long id;

    public Human build(Human human) {
        if (human.getId() == -1) {
            human.setId(id++);
        }
        return human;
    }
}