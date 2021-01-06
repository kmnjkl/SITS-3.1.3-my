import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        initialize mapper to parse json with passages from Twine
        ObjectMapper mapper = new ObjectMapper();
//        parse json
        Passages passages_obj = mapper.readValue(new File("C://Java\\Projects\\SITS-3.1.3-my\\res", "passages.json"), Passages.class);
        System.out.println("\n" + passages_obj.name + "\n---------------------------------------------------------------");
//        set start passage pid and set start passage as current passage
        Passage currentPassage = passages_obj.getStartPassage();
        currentPassage.printPassage();
        while(!currentPassage.isLast()) {
            int next_link = sc.nextInt();
            currentPassage = passages_obj.getPassageByPid(currentPassage.getPassagePidByLinkNumber(next_link));
            currentPassage.printPassage();
        }
        System.out.println("\n\n---------------------------------------------------------------\n" + passages_obj.name + "\n\nGitHub: https://github.com/lkjuhkmnop/SITS-3.1.3-my\n\nMade using " + passages_obj.creator + " " + passages_obj.creator_version + ", https://twinery.org/" + "\nIFID: " + passages_obj.ifid);
    }
}
