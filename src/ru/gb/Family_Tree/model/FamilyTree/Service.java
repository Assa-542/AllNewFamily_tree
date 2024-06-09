package ru.gb.Family_Tree.model.FamilyTree;

import ru.gb.Family_Tree.api.Externalizable;
import ru.gb.Family_Tree.Impl.FileHandler;
import ru.gb.Family_Tree.model.builder.FamilyTreeBuilder;
import ru.gb.Family_Tree.model.human.Gender;
import ru.gb.Family_Tree.model.human.Human;

import java.util.List;
import java.time.LocalDate;

import static ru.gb.Family_Tree.model.human.Gender.FEMALE;
import static ru.gb.Family_Tree.model.human.Gender.MALE;

public class Service {

    private FamilyTreeGroup<Human> familyTreeGroup;
    private FamilyTreeBuilder familyTreeBuilder;
    private Externalizable external;

    public Service() {
        this.familyTreeGroup = new FamilyTreeGroup();
        this.familyTreeBuilder = new FamilyTreeBuilder();
        this.external = new FileHandler();
    }

    public FamilyTreeGroup getFamilyTreeGroup() {
        return familyTreeGroup;
    }

    public FamilyTree addHumanToNewTree(Human human) {
        return addHumanByTree(human, true);
    }

    public FamilyTree addHumanToLastTree(Human human) {
        return addHumanByTree(human, familyTreeGroup.getFamilyTreeList().size() == 0);
    }

    public FamilyTree addHumanToLastTree(String name, String patronymic, String lastName, Gender gender, LocalDate birthDay, LocalDate deathDay) {
        Human human = new Human(name, patronymic, lastName, gender, birthDay, deathDay);
        return addHumanByTree(human, familyTreeGroup.getFamilyTreeList().size() == 0);
    }

    public FamilyTree addHumanByTree(Human entity, boolean isNewTree) {
        List<FamilyTree<Human>> familyTreeList = familyTreeGroup.getFamilyTreeList();
        FamilyTree tree;
        if (isNewTree) {
            tree = familyTreeBuilder.build(entity);
            familyTreeList.add(tree);
        } else {
            tree = familyTreeList.get(familyTreeList.size() - 1);
            familyTreeBuilder.getEntityBuilder().build(entity);
            familyTreeList.get(tree.getIndexId()).addEntity(entity);
        }
        return tree;
    }

    public void addParent(long idChild, long idParent) {
        Human child = (Human) findEntityById(idChild);
        Human parent = (Human) findEntityById(idParent);

        if (MALE.equals(parent.getGender())) {
            child.setFather(parent);
        } else if (FEMALE.equals(parent.getGender())){
            child.setMother(parent);
        }
    }

    public Entity findEntityById(long id) {
        return familyTreeGroup.findEntityById(id);
    }

    public void sortFamilyTreeById() {
        familyTreeGroup.sortFamilyTreeById();
    }

    public void sortFamilyTreeById(List<FamilyTree<Human>> familyTrees) {
        familyTreeGroup.sortFamilyTreeById(familyTrees);
    }

    public void sortFamilyTreesEntitiesById() {
        familyTreeGroup.sortFamilyTreesEntitiesById();
    }

    public void sortFamilyTreesEntitiesById(List<FamilyTree<Human>> familyTrees) {
        familyTreeGroup.sortFamilyTreesEntitiesById(familyTrees);
    }

    public void sortFamilyTreesEntitiesByBirthDay() {
        familyTreeGroup.sortFamilyTreesEntitiesByBirthDay();
    }

    public void sortFamilyTreesEntitiesByBirthDay(List<FamilyTree<Human>> familyTrees) {
        familyTreeGroup.sortFamilyTreesEntitiesByBirthDay(familyTrees);
    }

    public void sortFamilyTreesEntitiesByLastName() {
        familyTreeGroup.sortFamilyTreesEntitiesByLastName();
    }

    public void sortFamilyTreesEntitiesByLastName(List<FamilyTree<Human>> familyTrees) {
        familyTreeGroup.sortFamilyTreesEntitiesByLastName(familyTrees);
    }

    public void exportList() {
        external.writeAllExternal(getFamilyTreeGroup().getFamilyTreeList());
    }

    public void importList() {
        List<FamilyTree> familyTreeList = external.readExternal();
        getFamilyTreeGroup().getFamilyTreeList().addAll(familyTreeList);
    }
}