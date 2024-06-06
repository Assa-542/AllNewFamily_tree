package ru.gb.Family_Tree.human.Comparator;

import ru.gb.Family_Tree.human.Human;

import java.util.Comparator;

public class HumanComparatorByLastName implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        if (o1.getLastName() == null) {
            return -1;
        }
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
