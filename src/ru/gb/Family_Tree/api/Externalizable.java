package ru.gb.Family_Tree.api;

import ru.gb.Family_Tree.model.FamilyTree.FamilyTree;
import ru.gb.Family_Tree.model.human.Human;

import java.io.Serializable;
import java.util.List;

public interface Externalizable extends Serializable {

    void writeAllExternal(List<FamilyTree<Human>> familyTreeList);

    void updateExternal(FamilyTree<Human> familyTreeList);


    List<FamilyTree<Human>> readExternal();
}