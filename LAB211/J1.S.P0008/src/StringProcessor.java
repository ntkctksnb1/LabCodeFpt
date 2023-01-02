
import java.util.Map;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DELL
 */
public class StringProcessor {

    private Map<String, Integer> letters;
    private Map<Character, Integer> characters;
    private String content;

    public StringProcessor(String content) {
        this.content = content;
    }

    public StringProcessor() {
    }

    public Map<String, Integer> getLetters() {
        return letters;
    }

    public Map<Character, Integer> getCharacters() {
        return characters;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void countLetters() {
        StringTokenizer stk = new StringTokenizer(content);
        String nextLetters;

        while (stk.hasMoreTokens()) {
            nextLetters = stk.nextToken().toLowerCase();
            if (letters.containsKey(nextLetters)) {
                int newValue = letters.get(nextLetters) + 1;
                letters.replace(nextLetters, newValue);
            } else {
                letters.put(nextLetters, 1);
            }

        }
    }
}
