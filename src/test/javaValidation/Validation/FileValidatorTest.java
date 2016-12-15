package javaValidation.Validation;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by student on 12/14/16.
 */
public class FileValidatorTest {
    private FileValidator fileValidator;
    private String[] args;

    @Before
    public void setup(){
        fileValidator = new FileValidator();
        args = new String[1];
        args[0] = "/home/student/Documents/Smalltest.java";
    }
    @Test
    public void runValidation() throws Exception {
        String output = fileValidator.runValidation(args);

        assertEquals("outputs don't match", output, "public class Test {<br /><br />}<br />");
    }

}