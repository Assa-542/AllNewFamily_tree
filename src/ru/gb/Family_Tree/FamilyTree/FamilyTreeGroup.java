package ru.gb.Family_Tree.FamilyTree;

import ru.gb.Family_Tree.FamilyTree.Comporator.ComparatorIndexId;
import ru.gb.Family_Tree.FamilyTree.Iterator.FamilyTreeIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTreeGroup implements Iterable<FamilyTree>{

    private List<FamilyTree> familyTreeList;

    public FamilyTreeGroup() {
        this.familyTreeList = new ArrayList<>();
    }

    public List<FamilyTree> getFamilyTreeList() {
        return familyTreeList;
    }

    public void setFamilyTreeList(List<FamilyTree> familyTreeList) {
        this.familyTreeList = familyTreeList;
    }

    public void sortFamilyTreeById() {
        sortFamilyTreeById(familyTreeList);
    }

    public void sortFamilyTreeById(List<FamilyTree> familyTrees) {
        familyTrees.sort(new ComparatorIndexId<>());
    }

    public void sortFamilyTreesEntitiesById() {
        sortFamilyTreesEntitiesById(familyTreeList);
    }

    public void sortFamilyTreesEntitiesById(List<FamilyTree> familyTrees) {
        for (FamilyTree familyTree : familyTrees) {
            familyTree.sortEntitiesById();
        }
    }

    public void sortFamilyTreesEntitiesByBirthDay() {
        sortFamilyTreesEntitiesByBirthDay(familyTreeList);
    }

    public void sortFamilyTreesEntitiesByBirthDay(List<FamilyTree> familyTrees) {
        for (FamilyTree familyTree : familyTrees) {
            familyTree.sortEntitiesByBirthDay();
        }
    }

    public void sortFamilyTreesEntitiesByLastName() {
        sortFamilyTreesEntitiesByLastName(familyTreeList);

    }

    public void sortFamilyTreesEntitiesByLastName(List<FamilyTree> familyTrees) {
        for (FamilyTree familyTree : familyTrees) {
            familyTree.sortEntitiesByLastName();
        }
    }

    @Override
    public Iterator<FamilyTree> iterator() {
        return new FamilyTreeIterator(familyTreeList);
    }
}