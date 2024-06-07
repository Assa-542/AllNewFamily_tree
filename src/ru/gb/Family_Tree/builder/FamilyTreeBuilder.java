package ru.gb.Family_Tree.builder;

import ru.gb.Family_Tree.api.BuildId;
import ru.gb.Family_Tree.FamilyTree.FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTreeBuilder<T extends BuildId> {

    private long treeId;
    private EntityBuilder entityBuilder;

    public FamilyTreeBuilder() {
        this.entityBuilder = new EntityBuilder();
    }

    public FamilyTreeBuilder(EntityBuilder humanBuilder) {
        this.entityBuilder = humanBuilder;
    }

    public FamilyTree build() {
        return new FamilyTree(treeId++);
    }

    public FamilyTree build(T entity) {
        List<T> entities = new ArrayList<>();
        entityBuilder.build(entity);
        entities.add(entity);
        return new FamilyTree(treeId++, entities);
    }

    public FamilyTree build(List<T> entities) {
        return new FamilyTree(treeId++, entities);
    }

    public EntityBuilder getEntityBuilder() {
        return entityBuilder;
    }
}