package ru.gb.Family_Tree.human.Iterator;

import ru.gb.Family_Tree.human.Human;

import java.util.Iterator;
import java.util.List;

public class EntityIterator<T> implements Iterator<T> {

    private int index;
    private List<T> entities;

    public EntityIterator(List<T> entities) {
        this.entities = entities;
    }

    @Override
    public boolean hasNext() {
        return entities.size() > index;
    }

    @Override
    public T next() {
        return entities.get(index++);
    }
}