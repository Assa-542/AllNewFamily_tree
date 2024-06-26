package ru.gb.Family_Tree.model.human;

public enum Gender {

    MALE("муж"), FEMALE("жен");

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

    public static Gender getGenderByValue(String val) {
        for (Gender value : Gender.values()) {
            if (value.getGenderValue().equals(val)) {
                return value;
            }
        }
        return null;
    }
}