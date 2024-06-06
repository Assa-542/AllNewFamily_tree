package ru.gb.Family_Tree.api;

import ru.gb.Family_Tree.FamilyTree.FamilyTree;

import java.io.Serializable;
import java.util.List;

public interface Externalizable extends Serializable {

    void writeAllExternal(List<FamilyTree> familyTreeList);

    void updateExternal(FamilyTree familyTreeList);

    List<FamilyTree> readExternal();
}
