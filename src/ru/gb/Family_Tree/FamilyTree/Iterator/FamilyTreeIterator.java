package ru.gb.Family_Tree.FamilyTree.Iterator;

import ru.gb.Family_Tree.FamilyTree.FamilyTree;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<FamilyTree> {

    private int index;
    private List<FamilyTree> familyTreeList;

    public FamilyTreeIterator(List<FamilyTree> familyTreeList) {
        this.familyTreeList = familyTreeList;
    }

    @Override
    public boolean hasNext() {
        return familyTreeList.size() > index;
    }

    @Override
    public FamilyTree next() {
        return familyTreeList.get(index++);
    }
}
