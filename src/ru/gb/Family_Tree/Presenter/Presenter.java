package ru.gb.Family_Tree.Presenter;

import ru.gb.Family_Tree.Impl.FileHandler;
import ru.gb.Family_Tree.model.FamilyTree.Service;
import ru.gb.Family_Tree.model.human.Gender;
import ru.gb.Family_Tree.model.human.Human;
import ru.gb.Family_Tree.View.View;

import java.time.LocalDate;

public class Presenter {

    private View view;
    private Service service;

    public Presenter (View view) {
        this.view = view;
        this.service = new Service(new FileHandler());
    }

    public void addEntity(String name, String patronymic, String lastName, Gender gender, LocalDate birthDay, LocalDate deathDay) {
        service.addHumanToLastTree(name, patronymic, lastName, gender, birthDay, deathDay);
    }

    public void addParent(long idChild, long idParent) {
        service.addParent(idChild, idParent);
    }

    public Human findHumanById(long id) {
        return (Human) service.findEntityById(id);
    }

    public void sortByLastName() {
        service.sortFamilyTreesEntitiesByLastName();
    }

    public void sortByBirthDay() {
        service.sortFamilyTreesEntitiesByBirthDay();
    }

    public void sortById() {
        service.sortFamilyTreesEntitiesById();
    }

    public void getEntityListInfo() {
        view.printAnswer(service.getFamilyTreeGroup().getInfo());
    }

    public void exportList() {
        service.exportList();
    }

    public void importList() {
        service.importList();
    }
}