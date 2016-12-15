package javaValidation.Validation;


import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * This class finds validation errors that span multiple lines
 *
 * @author Mitchell Hanson
 */
public class MultiLineValidator {
    private final Logger log = Logger.getLogger(this.getClass());
    private String filePath = null;
    private List<String> multiLineErrors = new ArrayList<>();

    MultiLineValidator(String path) {
        filePath = path;
    }

    /**
     * kicks off the multi-line validation
     */
    public void runMultiLineValidation() {
        multiLineErrors.add(lineCount());
        multiLineErrors.add(javadocErrors());
    }

    /**\
     * Counts the lines in a file
     * @return number of lines in a file
     */
    private String lineCount() {
        int count = 0;
        try (BufferedReader input = new BufferedReader(new FileReader(filePath))) {
            while (input.ready()) {
                input.readLine();
                count ++;
            }
        } catch (FileNotFoundException fnfe) {
            log.error("Failed to read input file");
        } catch (Exception exception) {
            log.error("General Error");
        }


        return "line count = " + count;
    }

    private String javadocErrors() {
        return "javadoc Errors";
    }
}
