package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String letters, String word) {
        ArrayList<String> lettersList = new ArrayList<>(List.of(letters.toLowerCase().split("")));
        ArrayList<String> wordList = new ArrayList<>(List.of(word.toLowerCase().split("")));
        List<String> result = new ArrayList<>(lettersList);
        int i = 0;
        if ("".equals(letters)) {
            return false;
        }
        result.retainAll(wordList);
        System.out.println(result);
        for (String w : wordList) {
            if (result.contains(w)) {
                i = i + 1;
            }
        }
        return i == result.size();
    }
}
//END
