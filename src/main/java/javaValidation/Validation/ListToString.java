package javaValidation.Validation;

import java.util.List;

/**
 * This class appends each item in a list to a string
 *
 * @author Mitchell Hanson
 */
public class ListToString {

    /**
     * Transforms a list into a single string
     *
     * @param list list of strings
     * @return string of all list items appended together
     */
    public String convertListToString(List<String> list) {
        String fileString = "";

        if(!list.isEmpty()) {
            for(int index = 0; index < list.size(); index ++) {
                fileString += list.get(index) + "<br />";
            }
        }

        return fileString;
    }
}
