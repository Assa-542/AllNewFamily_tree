package ru.gb.Family_Tree.human.Comparator;

import ru.gb.Family_Tree.FamilyTree.Entity;

import java.util.Comparator;

public class ComparatorByBirthDay<T extends Entity> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        if (o1.getBirthDay() == null) {
            return -1;
        }
        return o1.getBirthDay().compareTo(o2.getBirthDay());
    }
}