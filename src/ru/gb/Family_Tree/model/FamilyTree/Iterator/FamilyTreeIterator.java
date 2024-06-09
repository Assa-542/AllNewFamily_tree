package ru.gb.Family_Tree.model.FamilyTree.Iterator;

import ru.gb.Family_Tree.model.FamilyTree.FamilyTree;
import ru.gb.Family_Tree.model.FamilyTree.Entity;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<T extends Entity<T>> implements Iterator<FamilyTree<T>> {

    private int index;
    private List<FamilyTree<T>> familyTreeList;

    public FamilyTreeIterator(List<FamilyTree<T>> familyTreeList) {
        this.familyTreeList = familyTreeList;
    }

    @Override
    public boolean hasNext() {
        return familyTreeList.size() > index;
    }

    @Override
    public FamilyTree<T> next() {
        return familyTreeList.get(index++);
    }
}