package ru.gb.Family_Tree.model.FamilyTree;

import ru.gb.Family_Tree.model.Api.BuildId;
import ru.gb.Family_Tree.model.human.Gender;

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