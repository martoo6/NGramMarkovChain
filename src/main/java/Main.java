import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Main {

    static HashMap<String, List<String>> dictionary = new HashMap();

    public static void main(String[] args){
        try (Stream<String> stream = Files.lines(Paths.get("textos.txt"))) {

            stream.forEach((line) -> {
                final String[] words = line.replaceAll("-", "")
                        .replaceAll("\\.", "")
                        .replaceAll(",", "")
                        .split("\\s+");
                for (int i=0; i < words.length-1; i++) {
                    String w = StringUtils.stripAccents(words[i].toLowerCase().replaceAll("[^\\w]", ""));
                    if (!dictionary.containsKey(w)) {
                        dictionary.put(w, new ArrayList<>());
                    }
                    dictionary.get(w).add(words[i+1].toLowerCase());
                }
            });


            printPhrase("ella", 10);
            printPhrase("el", 10);
            printPhrase("cuando", 10);
            printPhrase("quien", 10);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void printPhrase(String word, int size){
        System.out.println(word.concat(" ").concat(getPhrase(word, size)));
    }

    static Random rnd = new Random();

    static String getPhrase(String word, int size) {
        if(size == 0) {
            return ".";
        } else {
            final List<String> nextWords = dictionary.get(word);
            if (nextWords != null) {
                final String nextWord = nextWords.get(rnd.nextInt(nextWords.size()));
                return nextWord.concat(" ").concat(getPhrase(nextWord, size - 1));
            } else {
                return ".";
            }
        }
    }
}
