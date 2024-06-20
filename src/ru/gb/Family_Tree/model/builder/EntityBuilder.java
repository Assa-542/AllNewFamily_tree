package ru.gb.Family_Tree.model.builder;

public class EntityBuilder {

    private long id;

    public void build(BuildId entity) {
        if (entity.getId() == -1) {
            entity.setId(id++);
        }
    }
}