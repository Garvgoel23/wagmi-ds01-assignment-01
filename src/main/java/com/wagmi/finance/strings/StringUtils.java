
package main.java.com.wagmi.finance.strings;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/*
 TODO[Student]: String utilities
 - Read `StringUtilsTest` to understand expectations.
 - Ensure `sanitizeDescription` handles null/empty, collapses whitespace, and removes non-alphanumerics.
 - Ensure `matchesDatePattern` strictly validates YYYY-MM-DD with leap years and correct ranges.
 - Note: Keep behavior consistent with tests; refactor for readability if desired.
*/

public final class StringUtils {
    private StringUtils() {
    }

    public static String sanitizeDescription(String input) {
        // stub: trim, collapse spaces, remove invalid chars
        if (input == null ){
            throw new NullPointerException("Input string cannot be null.");}
        if(input.isEmpty()) {
            return "";
        }
        StringBuilder ans=new StringBuilder();
        boolean previousCharWasSpace = false;
        for(int i=0;i<input.length();i++){
            if(Character.isLetterOrDigit(input.charAt(i))){
                ans.append(input.charAt(i));
                previousCharWasSpace = false;
            }
            else{
                if (!previousCharWasSpace) {
                    // Append a single space character
                    ans.append(' ');
                    previousCharWasSpace = true;
                }
            }
        }
        return ans.toString().trim();
    }

    public static boolean matchesDatePattern(String input) {
        // stub: check pattern YYYY-MM-DD
        if(input==null||input.length()!=10)
        {
            return false;
        }

        if (!input.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            return false;
        }
        int yy=Integer.parseInt(input.substring(0, 4));
        if(yy<=0)
        {
            return false;
        }
        try {
            LocalDate.parse(input);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }

    }
}
