package ru.gb.Family_Tree.human;

public enum Gender {

    MALE("муж."), FEMALE("жен.");

    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGenderValue() {
        return gender;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "gender='" + gender + '\'' +
                '}';
    }
}