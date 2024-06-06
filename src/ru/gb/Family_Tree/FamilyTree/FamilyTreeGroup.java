package ru.gb.Family_Tree.FamilyTree;


import ru.gb.Family_Tree.FamilyTree.Comporator.ComparatorIndexId;
import ru.gb.Family_Tree.FamilyTree.Iterator.FamilyTreeIterator;
import ru.gb.Family_Tree.human.Comparator.HumanComparatorByBirthDay;
import ru.gb.Family_Tree.human.Comparator.HumanComparatorByLastName;

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
        familyTrees.sort(new ComparatorIndexId());
    }

    public void sortFamilyTreesHumansById() {
        sortFamilyTreesHumansById(familyTreeList);
    }

    public void sortFamilyTreesHumansById(List<FamilyTree> familyTrees) {
        for (FamilyTree familyTree : familyTrees) {
            familyTree.getHumans().sort(new ComparatorIndexId());
        }
    }

    public void sortFamilyTreesHumansByBirthDay() {
        sortFamilyTreesHumansByBirthDay(familyTreeList);
    }

    public void sortFamilyTreesHumansByBirthDay(List<FamilyTree> familyTrees) {
        for (FamilyTree familyTree : familyTrees) {
            familyTree.getHumans().sort(new HumanComparatorByBirthDay());
        }
    }

    public void sortFamilyTreesHumansByLastName() {
        sortFamilyTreesHumansByLastName(familyTreeList);

    }

    public void sortFamilyTreesHumansByLastName(List<FamilyTree> familyTrees) {
        for (FamilyTree familyTree : familyTrees) {
            familyTree.getHumans().sort(new HumanComparatorByLastName());
        }
    }

    @Override
    public Iterator<FamilyTree> iterator() {
        return new FamilyTreeIterator(familyTreeList);
    }
}
