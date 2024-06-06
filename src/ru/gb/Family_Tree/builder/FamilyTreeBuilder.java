package ru.gb.Family_Tree.builder;

import ru.gb.Family_Tree.FamilyTree.FamilyTree;
import ru.gb.Family_Tree.human.Human;

import java.util.ArrayList;
import java.util.List;

public class FamilyTreeBuilder {

    private long treeId;
    private HumanBuilder humanBuilder;

    public FamilyTreeBuilder() {
        this.humanBuilder = new HumanBuilder();
    }

    public FamilyTreeBuilder(HumanBuilder humanBuilder) {
        this.humanBuilder = humanBuilder;
    }

    public FamilyTree build() {
        return new FamilyTree(treeId++);
    }

    public FamilyTree build(Human human) {
        List<Human> humans = new ArrayList<>();
        humans.add(humanBuilder.build(human));
        return new FamilyTree(treeId++, humans);
    }

    public FamilyTree build(List<Human> humans) {
        return new FamilyTree(treeId++, humans);
    }

    public HumanBuilder getHumanBuilder() {
        return humanBuilder;
    }
}