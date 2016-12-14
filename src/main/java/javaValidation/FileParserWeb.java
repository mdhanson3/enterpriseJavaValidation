package javaValidation;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class FileParserWeb {
    private final Logger log = Logger.getLogger(this.getClass());
    private String filePath;
    private List<String> fileContents;

    public FileParserWeb(String path) {
        filePath = path;
        fileContents = new ArrayList();
    }

    /**
     * Generates an List of Strings for its filePath.
     */
    public void runFileParser() {
        try (BufferedReader input = new BufferedReader(new FileReader(filePath))) {
            while (input.ready()) {
                fileContents.add(input.readLine());
            }
        } catch (java.io.FileNotFoundException fnfe) {
            log.error("Failed to read input file");
        } catch (Exception exception) {
            log.error("General Error");
        }
    }

    /**
     * returns fileContetns List
     *
     * @return List of strings that corresponds to each line of the class's file
     */
    public List getFileContents() {
        return fileContents;
    }
}