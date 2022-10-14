import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class Main {
    
    public static void main(String[] args){
        System.out.println("isPalindrome(123321)");
        System.out.println(isPalindrome("123321"));   

        System.out.println("removeRepeats(abcaaadcdcdcdcdcdcde)");
        System.out.println(removeRepeats("abcaaadcdcdcdcdcdcde"));
        
        System.out.println("checkAnagram(abcabc, bacbac)");
        System.out.println(checkAnagram("abcabc", "bacbac"));

        System.out.println("compareLexographic(Orange, Orange)");
        System.out.println(compareLexographic("Orange", "Orange"));
        
        System.out.println("compareLexographicNoCapitals(orange, Orange)");
        System.out.println(compareLexographicNoCapitals("orange", "Orange"));

        System.out.println("uniteStrings(abc, dfg)");
        System.out.println(uniteStrings("abc", "dfg"));

        System.out.println("compareStringCharArray(abc, charArray");
        char[] charArray = new char[] {'a', 'b', 'c'};
        System.out.println(compareStringCharArray("abc", charArray));

        System.out.println("strEndsWith(abcdefgijkl, gijkl)");
        System.out.println(strEndsWith("abcdefgijkl", "gijkl"));

        System.out.println("compareTwoStrings(string, string)");
        System.out.println(compareTwoStrings("string", "string"));

        System.out.println("getLength(string)");
        System.out.println(getLength("string"));

        System.out.println("doLowerCase(String str1)");
        System.out.println(doLowerCase("GTEEEE"));
    
        System.out.println("doUpperCase(String str1)");
        System.out.println(doUpperCase("gteeeee"));
        
        System.out.println("findFirstNonRepeatingCharacter(String str1)");
        System.out.println(findFirstNonRepeatingCharacter("stringtrins"));
        
        System.out.println("startEndSymbols(String str1)");
        System.out.println(startEndSymbols("dobabaod"));
        
        System.out.println("times3Characters(String str1)");
        System.out.println(times3Characters("tttaaaabbbrrrgggggg"));
        
        System.out.println("sumNumbersFromAString(String str1)");
        System.out.println(sumNumbersFromAString("553531kgjddj392"));
        
        
        
    
        
        
    }
    //check palindrome
    public static boolean isPalindrome(String str){
        String potentialPalindrome = "";
 
        for (int i = str.length() - 1; i >= 0; i--) {
            potentialPalindrome = potentialPalindrome + str.charAt(i);
        }
 
        return str.equals(potentialPalindrome);
    }
    //return string with no repeated letters
    public static String removeRepeats(String str){
        String noRepeats = "";
        char[] charNoRepeats;
 
        for (int i = 0; i < str.length(); i++) {
            charNoRepeats = noRepeats.toCharArray();
            if (!checkLetter(str.charAt(i), charNoRepeats)){
                noRepeats = noRepeats + str.charAt(i);
            }
        }
 
        return noRepeats;
    }
    public static boolean checkLetter(char c, char[] noRepeats){
        for ( char ch : noRepeats) {
            if (ch == c) {
                return true;
            }
        }
        return false;
    }
    //check if two strings are anagrams
    public static boolean checkAnagram(String str1, String str2){
        char[] charStr1 = str1.toCharArray();
        char[] charStr2 = str2.toCharArray();
        int chInt = 0;

        HashMap chars1 = new HashMap();
        HashMap chars2 = new HashMap();

        for ( char ch : charStr1) {
            
            if(chars1.get(ch) == null){
                chars1.put(ch, 1);
            }
            
            else { 
                chInt = (int) chars1.get(ch);
                chars1.replace(ch, chInt + 1 );
            }
        }
        for ( char ch : charStr2) {
            
            if(chars2.get(ch) == null){
                chars2.put(ch, 1);
            }
            else { 
                chInt = (int) chars2.get(ch);
                chars2.replace(ch, chInt + 1);
            }
        }
        return chars1.equals(chars2);
    }

    //lexographic comparison of 2 strings
    public static String compareLexographic(String str1, String str2){
        if (str1.compareTo(str2) > 0){
            return "first is bigger than second";
        }
        else if (str1.compareTo(str2) == 0) {
            return "the strings are equal";
        }
        else {
            return "second is bigger than first";
        }
    }

    //lexographic comparison of 2 strings but no capitals
    public static String compareLexographicNoCapitals(String str1, String str2){
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        if (str1.compareTo(str2) > 0){
            return "first is bigger than second";
        }
        else if (str1.compareTo(str2) == 0) {
            return "the strings are equal";
        }
        else {
            return "second is bigger than first";
        }
    }

    // unite 1 string to the end of the other
    public static String uniteStrings(String str1, String str2){
        return str2 + str1;
    }

    //compare string to a char array
    public static boolean compareStringCharArray(String str1, char[] charArray){
        
        return str1.equals(String.valueOf(charArray));
    }

    //If one string is an end of the other
    public static boolean strEndsWith(String str1, String str2){
        return str1.endsWith(str2);
    }

    //check if two strings have same data
    public static boolean compareTwoStrings(String str1, String str2){
        return str1.equals(str2);
    }

    //string get length
    public static int getLength(String str1){
        return str1.length();
    }

    //slide 2
    //tolowercase
    public static String doLowerCase(String str1){
        return str1.toLowerCase();
    }

    //touppercase
    public static String doUpperCase(String str1){
        return str1.toUpperCase();
    }

    //find second most frequent char
    public static Character findSecondMostFrequentChar(String str1){
        char[] charStr1 = str1.toCharArray();
        int chInt = 0;
        Integer firstMost = 0;
        Character firstMostChar = '[';
        Integer secondMost = 0;
        Character secondMostChar = ']';
        Map <Character, Integer> chars1 = new HashMap <Character, Integer>();

        for ( char ch : charStr1) {
            
            if(chars1.get(ch) == null){
                chars1.put(ch, 1);
            }
            
            else { 
                chInt = (int) chars1.get(ch);
                chars1.replace(ch, chInt + 1 );
            }
        }

        for (Map.Entry< Character, Integer > entry : chars1.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (value > firstMost) {
                secondMost = firstMost;
                firstMost = value;
                secondMostChar = firstMostChar;
                firstMostChar = key;
            }
            else if (value > secondMost) {
                secondMost = value;
                secondMostChar = key;
            }
        }

        return secondMostChar;
    }

    //find first unrepeated character
    public static char findFirstNonRepeatingCharacter(String str1){
        str1 = removeRepeats(str1);
        return str1.toCharArray()[0];
    }

    //if first 2 symbols are also in the end
    public static boolean startEndSymbols(String str1){
        if (str1.toCharArray()[0] == str1.toCharArray()[str1.length()-1]){
            if (str1.toCharArray()[1] == str1.toCharArray()[str1.length()-2]){
                return true;
            }
        }
        if (str1.toCharArray()[0] == str1.toCharArray()[str1.length()-2]){
            if (str1.toCharArray()[1] == str1.toCharArray()[str1.length()-1]){
                return true;
            }
        }
        return false;
    }

    //find characters that appear 3 times
    public static String times3Characters(String str1){
        char[] charStr1 = str1.toCharArray();
        String answer = "";
        int chInt = 0;
        Map <Character, Integer> chars1 = new HashMap <Character, Integer>();

        for ( char ch : charStr1) {
            
            if(chars1.get(ch) == null){
                chars1.put(ch, 1);
            }
            
            else { 
                chInt = (int) chars1.get(ch);
                chars1.replace(ch, chInt + 1 );
            }
        }
        for (Map.Entry< Character, Integer > entry : chars1.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (value == 3){
                answer = answer + "" + key;
            }
        }

        return answer;
    }

    //sum numbers from a string
    public static int sumNumbersFromAString(String str1){
        char[] charArray = str1.toCharArray();
        int answer = 0;
        for ( char ch : charArray) {
           if(Character.isDigit(ch)){
            System.out.println(Integer.parseInt(String.valueOf(ch)));
            answer = answer + Integer.parseInt(String.valueOf(ch));
           }
        }

        return answer;
    }
}

