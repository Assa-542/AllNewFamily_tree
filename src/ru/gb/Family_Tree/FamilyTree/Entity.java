package ru.gb.Family_Tree.FamilyTree;

import ru.gb.Family_Tree.api.BuildId;
import ru.gb.Family_Tree.human.Gender;

import java.time.LocalDate;
import java.util.List;

public interface Entity<T> extends BuildId {

    String getName();
    String getLastName();
    Gender getGender();
    LocalDate getBirthDay();
    LocalDate getDeathDay();
    T getMother();
    T getFather();
    List<T> getChildren();
    boolean isParent(T human);
}