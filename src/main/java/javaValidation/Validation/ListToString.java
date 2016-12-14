package javaValidation.Validation;

import java.util.List;

/**
 * Created by student on 12/14/16.
 */
public class ListToString {

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
