package javaValidation.Validation;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * This class takes an array of file path arguments and runs various validation processes on each.  It produces output files
 * of meta data and marked-up code showing any errors.
 *
 * Created by student on 2/9/16.
 * @author Mitchell Hanson
 */
public class FileValidator {
    private final Logger log = Logger.getLogger(this.getClass());
    private final int MINIMUM_REQUIRED_NUMBER_OF_ARGUMENTS = 1;
    private String fileName;


    /**
     * Searches for errors in java code and creates highlighted html output
     *
     * @param arguments String array of one element containing file path to validate
     * @return an html string that shows validated code
     */
    public String runValidation(String[] arguments) {
        // Check number of args
        if (!numberOfArgumentsPassed(arguments)) {
            return "";
        }

        fileName = arguments[0];

        // Create and run fileParser
        FileParser myFileParser = new FileParser(fileName);

        try {
            myFileParser.runFileParser();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create fileInformation object and run its main method
        FileInformation myFileInformation = new FileInformation(myFileParser.getFileContents());
        myFileInformation.runFileInformation();

        // Create validation objects using file provided by command line arg
        SingleLineValidator mySingleLineValidator = new SingleLineValidator(myFileInformation);
        MultiLineValidator myMultiLineValidator = new MultiLineValidator(fileName);

        // Run both objects' validation methods
        mySingleLineValidator.runSingleLineValidation();
        myMultiLineValidator.runMultiLineValidation();

        // Insert HTML elements into the file contents
        TextTransform myTextTransformer = new TextTransform();
        myTextTransformer.convertSpacesToHtmlNbs(myFileInformation.getOriginalFileContents());
        myTextTransformer.augmentContentsWithUnderlines(myFileInformation.getOriginalFileContents(), mySingleLineValidator.getSingleLineErrors());

        ListToString listToString = new ListToString();
        String fileContentsAsString = listToString.convertListToString(myFileInformation.getOriginalFileContents());

        return fileContentsAsString;

    }

    /**
     * Checks that the number of arguments passed to the application is correct
     *
     * @param arguments arguments passed to the application
     * @return returns true if the number of arguments passed is correct
     */
    private boolean numberOfArgumentsPassed(String[] arguments) {
        if (arguments.length == MINIMUM_REQUIRED_NUMBER_OF_ARGUMENTS) {
            return true;
        } else {
            log.error("This program requires " + MINIMUM_REQUIRED_NUMBER_OF_ARGUMENTS + " arguments to run. Exiting application");
            return false;
        }
    }
}
