import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ObjectMapper mapper = new ObjectMapper();
        Passages passages_obj = mapper.readValue(new File("C://Java\\Projects\\SITS-3.1.3-my\\src", "res/passages.json"), Passages.class);
        Passage start_passage = getPassageByPid(passages_obj, 1);
        System.out.println(getCleanTextFromText(start_passage.text));
        int next = sc.nextInt();
        System.out.println(getCleanTextFromText(getPassageByPid(passages_obj, start_passage.links.get(next-1).pid).text));
    }

    private static Passage getPassageByPid(Passages passages_obj, int pid) {
        for (Passage passage: passages_obj.passages) {
            if (passage.pid == pid) {
                return passage;
            }
        }
        return null;
    }

    private static String getCleanTextFromText(String text) {
        StringBuilder sbtext = new StringBuilder(text);
        int i_start = sbtext.lastIndexOf("[[");
        int i_end = sbtext.lastIndexOf("]]");
        while (i_start >= 0 && i_end >= 0) {
            sbtext.delete(i_start, i_end+2);
            i_start = sbtext.lastIndexOf("[[");
            i_end = sbtext.lastIndexOf("]]");
        }
        return sbtext.toString();
    }

}
