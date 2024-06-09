package ru.gb.Family_Tree.model.FamilyTree.Comporator;

import ru.gb.Family_Tree.model.FamilyTree.Entity;
import ru.gb.Family_Tree.model.Api.IndexId;

import java.util.Comparator;

public class ComparatorIndexId<T extends Entity> implements Comparator<IndexId> {

    @Override
    public int compare(IndexId o1, IndexId o2) {
        return Integer.compare(o1.getIndexId(), o2.getIndexId());
    }
}