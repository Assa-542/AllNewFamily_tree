package ru.gb.Family_Tree.View;

import static ru.gb.Family_Tree.model.Api.Constants.DD_MM_YYYY_MATCHER;
import static ru.gb.Family_Tree.model.Api.Constants.D_MATCHER;

public class Validator {

    public boolean isValidLocalData(String dateStr) {
        return dateStr.matches(DD_MM_YYYY_MATCHER);
    }

    public boolean isNotValidDigit(String checkIndexStr) {
        return checkIndexStr == null || checkIndexStr.isBlank() || !checkIndexStr.matches(D_MATCHER);
    }

    public boolean isNotValidIndex(int checkIndex, int size) {
        return checkIndex < 1 || checkIndex > size;
    }
}