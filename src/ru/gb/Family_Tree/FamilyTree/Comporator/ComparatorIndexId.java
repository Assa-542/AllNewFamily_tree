package ru.gb.Family_Tree.FamilyTree.Comporator;

import ru.gb.Family_Tree.api.IndexId;

import java.util.Comparator;

public class ComparatorIndexId implements Comparator<IndexId> {

    @Override
    public int compare(IndexId o1, IndexId o2) {
        return Integer.compare(o1.getIndexId(), o2.getIndexId());
    }
}