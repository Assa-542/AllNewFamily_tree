//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import ru.gb.Family_Tree.api.Externalizable;
import ru.gb.Family_Tree.FamilyTree.FamilyTree;
import ru.gb.Family_Tree.FamilyTree.Service;
import ru.gb.Family_Tree.FamilyTree.Comporator.ComparatorIndexId;
import ru.gb.Family_Tree.human.Gender;
import ru.gb.Family_Tree.human.Human;
import ru.gb.Family_Tree.Impl.FileHandler;
import ru.gb.Family_Tree.FamilyTree.Entity;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        testData();
    }

    public static void testData() {
        Service service = new Service();

        Human father0 = new Human("Антон", "Юрьевич", "Степанов", Gender.MALE, LocalDate.of(1945, 10, 24));
        Human mother0 = new Human("Марина", "Ильинична", "Степанова", Gender.FEMALE, LocalDate.of(1950, 2, 6));
        mother0.setSpouse(father0);

        Human father1 = new Human("Иван", "Степанович", "", Gender.MALE, LocalDate.of(1955, 2, 21));
        Human father2 = new Human("Петрович", "Афанасьев", "Петров", Gender.MALE, LocalDate.of(1980, 10, 31));
        Human father3 = new Human("Сергей", "Сидорович", "Сергеевич", Gender.MALE, LocalDate.of(1977, 3, 21));
        Human father4 = new Human("Дима", "Ярославович", "Ярый", Gender.MALE, LocalDate.of(1980, 3, 12));

        Human mother1 = new Human("Агата", "Петровна", "Иванова", Gender.FEMALE, LocalDate.of(1964, 3, 2));
        Human mother2 = new Human("Марина", "Степановна", "Петрова", Gender.FEMALE, LocalDate.of(1983, 11, 19));
        Human mother3 = new Human("Кристина", "Николаевна", "Сидорова", Gender.FEMALE, LocalDate.of(1983, 12, 21));
        Human mother4 = new Human("Валентина", "Антоновна", "Ярая", Gender.FEMALE, LocalDate.of(1985, 8, 8));

        father1.setFather(father0);
        father1.setMother(mother0);

        mother2.setFather(father0);
        mother2.setMother(mother0);

        mother1.setSpouse(father1);
        mother2.setSpouse(father2);
        mother3.setSpouse(father3);
        mother4.setSpouse(father4);

        Human child1 = new Human("Митрофан", "Иванович", "Иванов", Gender.MALE, LocalDate.of(1996, 1, 11), mother1, father1);
        Human child2 = new Human("Петр", "Петрович", "Петров", Gender.MALE, LocalDate.of(1998, 2, 12), mother2, null);
        child2.setFather(father2);
        Human child3 = new Human("Сидр", "Сидорович", "Сидоров", Gender.MALE, LocalDate.of(1999, 10, 13), null, father3);
        child3.setMother(mother3);
        Human child4 = new Human("Ярослав", "Логвинов", "Ярый", Gender.MALE, LocalDate.of(2001, 4, 14));
        child4.setMother(mother4);
        child4.setFather(father4);

        Human child5 = new Human("Манна", "Николаевна", "Иванова", Gender.FEMALE, LocalDate.of(1999, 11, 15), mother1, father1);
        Human child6 = new Human("Каролина", "Ярославич", "Петрова", Gender.FEMALE, LocalDate.of(2001, 5, 16), mother2, null);
        child6.setFather(father2);
        Human child7 = new Human("Катя", "Сидоровна", "Сидорова", Gender.FEMALE, LocalDate.of(2003, 4, 17), null, father3);
        child7.setMother(mother3);
        Human child8 = new Human("Ника", "Ярославовна", "Рая", Gender.FEMALE, LocalDate.of(2002, 1, 18));
        child8.setMother(mother4);
        child8.setFather(father4);

        List<Human> humans = List.of(father0, mother0,
                father1, father2, father3, father4,
                mother1, mother2, mother3, mother4,
                child1, child2, child3, child4, child5, child6, child7, child8);

        for (Human human : humans) {
            service.addHumanToLastTree(human);
        }

        Externalizable ext = (Externalizable) new FileHandler();
        // Записываем объект List<FamilyTree> в файл
        ext.writeAllExternal(service.getFamilyTreeGroup().getFamilyTreeList());

        // Получаем объект из файла
        List<FamilyTree> familyTreeList = ext.readExternal();

        System.out.println("=========================SORT BY LAST NAME=============================");
        service.sortFamilyTreesEntitiesByLastName(familyTreeList);
        System.out.println(familyTreeList.toString());
        System.out.println("==================================================================\n");

        Human father9 = new Human("Владимир", "Ильич", "Левин", Gender.MALE, LocalDate.of(1953, 10, 11));
        Human mother9 = new Human("Мария", "Вячеславовна", "Левин", Gender.FEMALE, LocalDate.of(1955, 7, 15));
        mother9.setSpouse(father9);

        Human child9 = new Human("Митрофан", "Иванович", "Иванов", Gender.MALE, LocalDate.of(1986, 1, 11), mother9, father9);
        Human child10 = new Human("Петр", "Петрович", "Петров", Gender.MALE, LocalDate.of(1988, 2, 12), mother9, father9);

        List<Human> humans2 = List.of(mother9, child9, child10);

        service.addHumanToNewTree(father9);
        for (Human human : humans2) {
            service.addHumanToLastTree(human);
        }

        // Обновляем объект List<FamilyTree> и перезаписываем в файл
        ext.updateExternal(service.addHumanToLastTree(child10));

        // Получаем объект из файла
        List<FamilyTree> familyTreeList2 = ext.readExternal();

        System.out.println("=========================SORT BY DATE=============================");
        service.sortFamilyTreesEntitiesByBirthDay(familyTreeList2);
        System.out.println(familyTreeList2.toString());
        System.out.println("==================================================================\n");
        Collections.reverse(familyTreeList2);
        System.out.println("=========================SORT FAMILY TREE BY ID=============================");
        Collections.sort(familyTreeList2, new ComparatorIndexId<Entity>());
        System.out.println(familyTreeList2.toString());
        System.out.println("==================================================================\n");

        for (FamilyTree familyTree : familyTreeList2) {
            Collections.reverse(familyTree.getEntities());
        }

        System.out.println(familyTreeList2.toString());
        System.out.println("=========================SORT HUMANS BY ID=============================");
        service.sortFamilyTreesEntitiesById(familyTreeList2);
        System.out.println(familyTreeList2.toString());
        System.out.println("==================================================================\n");
    }
}