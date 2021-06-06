package utils;

import java.util.HashSet;
import java.util.Hashtable;

public class StringUtils {

    // Interview Question #1
    public static boolean isUnique(String word){
        HashSet<Character> set = new HashSet<>();
        char arr[] = word.toCharArray();
        for (char ch : arr){
            if (set.contains(ch)){
                return false;
            } else {
                set.add(ch);
            }
        }
        return true;
    }

    // Interview Question #2
    public static boolean isPermutation(String word1, String word2){
        if (word1.length() != word2.length()){
            return false;
        }

        Hashtable<Character, Integer> table = new Hashtable<>();
        char arr[] = word1.toCharArray();
        for (char ch: arr){
            if (!table.contains(ch)){
                table.put(ch,1);
            } else {
                int current = table.get(ch);
                table.put(ch,current++);
            }
        }

        char arr2[] = word2.toCharArray();
        for (char ch: arr2){
            if (!table.containsKey(ch) || table.get(ch) == 0){
                return false;
            } else {
                int current = table.get(ch);
                table.put(ch,current--);
            }
        }
        return true;
    }

    // Interview Question #3
    public static String urlIfy(String sentence){
        int shift = sentence.length() - trueLength(sentence);

        if (shift == 0){
            return sentence;
        }

        char chars[] = sentence.toCharArray();

        for (int i = sentence.length() - shift; i >= 0; i--){
            if (sentence.charAt(i) != ' '){
                chars[i + shift] = sentence.charAt(i);
            } else {
                chars[i-2] = '0';
                chars[i-1] = '2';
                chars[i] = '%';
                i -= 2;
            }
        }
        return String.valueOf(chars);
    }

    public static int countSpaces(String sentence){
        int spaces = 0;
        for (int i = 0; i < sentence.length(); i++){
            if (sentence.charAt(i) == ' '){
                spaces++;
            }
        }
        return spaces;
    }

    public static int trueLength(String sentence){
        for (int i = sentence.length() - 1; i >= 0; i--){
            if (sentence.charAt(i) != ' '){
                return i + 1;
            }
        }
        return sentence.length();
    }
}