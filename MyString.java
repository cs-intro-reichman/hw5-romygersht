/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        String Hello = "Hello";
        String empty = "";
        String sub1 = "spa";
        String sub2 = "hel";
        String sub3 = "abc";
        String sub4 = "pass";
        String sub5 = "sap";
        String space = "space";
        String silent = "silent";
        String ch = "a";
        

        System.out.println(countChar(hello, 'h')); //1
        System.out.println(countChar(hello, 'l')); //2
        System.out.println(countChar(hello, 'z')); //0

        System.out.println(countChar(Hello, 'h')); //0
        System.out.println(countChar(empty, 'h')); //0 

        System.out.println(subsetOf(empty, hello)); //true
        System.out.println(subsetOf(sub1, space)); //true 
        System.out.println(subsetOf(ch, silent)); //false
        System.out.println(subsetOf(sub4, space)); //false
        System.out.println(subsetOf(sub5, space)); //true


        System.out.println(spacedString(hello)); // h e l l o
        System.out.println(spacedString(silent)); //expected: s i l e n t
        System.out.println(spacedString(ch));// expected: a
        System.out.println(spacedString(empty)); //expected: " "

       System.out.println(randomStringOfLetters(5)); //expected: 5 letters string
       System.out.println(randomStringOfLetters(10)); //expected: 10 letters string
       System.out.println(randomStringOfLetters(0)); //expected: 0 letters string

       System.out.println(remove(space, sub1)); //expected: ce
       System.out.println(remove(hello, sub2)); //expected: lo
       System.out.println(remove(sub3, sub3)); //expected: " "
       System.out.println(remove(hello, empty)); //expected: hello
       System.out.println(remove(sub3, ch)); //expected: bc
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        int count= 0;
        if (str.equals("")) {
            return 0;
        }
        for (int i=0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++; 
            }
        }

        return count; 
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
     /*    if (str1.equals("")) {
            return true;
        }*/
        if (str1.length() > str2.length()) {
            return false;
        }
        for(int i=0; i<str1.length(); i++)
        {
            if (countChar(str1, str1.charAt(i))> countChar(str2, str2.charAt(i))) {
                        return false;
                    }

       } 
            return true;
    }
    

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        String newString = "";
        if (str == "") {
            return "";
        }
        for (int i =0; i < str.length(); i++) {
            if (i!=str.length()-1) {
            newString = newString + str.charAt(i)+" "; 
            }
            else {
                newString = newString + str.charAt(i); 
            }
        }
        return newString;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
  
        StringBuilder str = new StringBuilder();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        if (n == 0) {
            return "";
        }
        else {
            for (int j = 0; j < n; j++) {

                 int randomIndex = (int) (Math.random() * alphabet.length());
                 str.append(alphabet.charAt(randomIndex));
               
            }
        }
        return str.toString().toLowerCase();
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit" 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
        if (str2.isEmpty()) {
            return str1;
        }
        StringBuilder result = new StringBuilder();
        boolean[] letters = new boolean[256];
    
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            int count1 = countChar(str1, c);
            int count2 = countChar(str2, c);
    
            if (count1 > count2 && !letters[c]) {
                result.append(String.valueOf(c).repeat(count1 - count2));
                letters[c] = true;
            }
        }
    
        return result.toString();
    }

    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         // Generate a random index between 0 and str.length()
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result;
    }    
}
    

