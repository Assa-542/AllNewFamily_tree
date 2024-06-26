package ru.gb.Family_Tree.Impl;

import ru.gb.Family_Tree.api.Externalizable;
import ru.gb.Family_Tree.model.FamilyTree.FamilyTree;
import ru.gb.Family_Tree.model.FamilyTree.Service;
import ru.gb.Family_Tree.model.human.Human;

import java.io.*;
import java.util.List;

public class FileHandler implements Externalizable {

    public final static String OUTPUT_DIR_DEFAULT = "family_tree.txt";

    private String outputDir;
    private Service service;

    public FileHandler() {
        this(OUTPUT_DIR_DEFAULT, null);
    }

    public FileHandler(Service service) {
        this(OUTPUT_DIR_DEFAULT, service);
    }

    public FileHandler(String outputDir, Service service) {
        this.outputDir = outputDir;
        this.service = service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public void writeAllExternal(List<FamilyTree<Human>> familyTreeList) {
        File file = new File(outputDir);
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(familyTreeList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("FamilyTree write to file. Length = " + file.length());
    }

    @Override
    public void updateExternal(FamilyTree<Human> familyTree) {
        List<FamilyTree<Human>> familyTreeList = readExternal();
        familyTreeList.add(familyTree);
        writeAllExternal(familyTreeList);
    }

    @Override
    public List<FamilyTree<Human>> readExternal() {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(outputDir))) {
            // Чтобы можно было добавлять новые FamilyTree нужно не присвоить вычитываемый объект, а именно добавлять к новому List
            List<FamilyTree<Human>> familyTrees = (List<FamilyTree<Human>>) in.readObject();
            for (FamilyTree<Human> familyTree : familyTrees) {
                for (Human entity : familyTree.getEntities()) {
                    service.addHumanToLastTree(entity);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File path '" + outputDir + "' NotFound!");
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("FamilyTree read from file.");
        return service.getFamilyTreeGroup().getFamilyTreeList();
    }
}