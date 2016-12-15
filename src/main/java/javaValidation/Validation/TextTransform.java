package javaValidation.Validation;

import java.util.List;

/**
 * This class adds html text to strings to format the output
 *
 * @author Mitchell Hanson
 */
public class TextTransform {
    private final String OPENING_SPAN = "<span class=\"";
    private final String OPENING_SPAN_CLOSE = " highlighted\">";
    private final String CLOSING_SPAN = "</span>";

    /**
     * Converts spaces to non-breaking spaces
     * @param contents string of contents
     */
    public void convertSpacesToHtmlNbs(List<String> contents) {

        for (int lineNumber = 0; lineNumber < contents.size(); lineNumber ++) {
            String lineText = contents.get(lineNumber);
            lineText = lineText.replace(" ","\u00A0");
            contents.set(lineNumber, lineText);
        }
    }

    /**
     * Add underline spans where dictated by an error list
     * @param contents List of strings representing a file
     * @param errorList list of SingleLineErrors
     * @return updated contents
     */
    public List<String> augmentContentsWithUnderlines(List<String> contents, List<SingleLineError> errorList) {
        for(SingleLineError error : errorList) {
            if (error.isCanBeUnderlined()) {
                transformConstant(error, contents);
            }

        }

        return contents;
    }

    /**
     * Adds html to mark up constants
     * @param error an error
     * @param contents list of strings representing file contents
     */
    private void transformConstant(SingleLineError error, List<String> contents) {

        // Get indices to underline
        int openingSpanIndex = error.getOpeningUnderlineIndex();
        int closingSpanIndex = error.getClosingUnderlineIndex();

        // Get line contents to update
        String lineText = contents.get(error.getLineNumber() - 1);

        // Split string into three pieces to insert underline html into
        String start = lineText.substring(0, openingSpanIndex);
        String middle = lineText.substring(openingSpanIndex, closingSpanIndex);
        String end = lineText.substring(closingSpanIndex);

        String newLineText = start + OPENING_SPAN + error.getErrorType() + OPENING_SPAN_CLOSE + middle + CLOSING_SPAN + end;

        if (!error.getErrorType().equals("LineLength")) {
            contents.set(error.getLineNumber() -1, newLineText);
        }
    }

}
