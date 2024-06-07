package ru.gb.Family_Tree.builder;

import ru.gb.Family_Tree.api.BuildId;

public class EntityBuilder {

    private long id;

    public void build(BuildId entity) {
        if (entity.getId() == -1) {
            entity.setId(id++);
        }
    }
}