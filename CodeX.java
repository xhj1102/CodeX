/*
 * The CodeX API.
 */
package codex;

/**
 *
 * @author xhj
 */
public class CodeX {

    /** 
     * Provides a method to code your text into two string.
     * @param text the original text given.
     * @param key the encoding key to do the code.
     */
    public static String[] doCoding(String text, int key) {
        String[] output = new String[2];
        
        int lengthOfText = text.length();
        String output1 = "";
        String output2 = "";
        for (int i = 1; i <= lengthOfText; i++) {
            char temp = text.charAt(i - 1);
            int operator = (int) temp;
            operator -= 32;
            operator = operator * lengthOfText;
            operator += key;
            int howMany = operator / 95 + 32;
            output2 = output2 + (char) howMany;
            operator = operator % 95 + 32;
            output1 = output1 + (char) operator;
            /* System.out.println(operator); */ // For test's use.
        }
        output[0] = output1;
        output[1] = output2;
        
        return output;
    }

    /** 
     * Provides a method to decode your strings back into text..
     * @param code the first code encrypted.
     * @param code2 the second code encrypted.
     * @param key the encoding key to do the code.
     */
    public static String doDecoding(String code, String code2, int key) {
        int lengthOfCode = code.length();
        String output = "";
        String output2 = "";
        for (int i = 1; i <= lengthOfCode; i++) {
            char temp = code.charAt(i - 1);
            char temp2 = code2.charAt(i - 1);
            int operator = (int) temp;
            int howMany = (int) temp2;
            operator -= 32;
            operator += 95 * (howMany - 32);
            operator -= key;
            operator /= lengthOfCode;
            operator += 32;
            output = output + (char) operator;
        }
        return output;
    }
}
