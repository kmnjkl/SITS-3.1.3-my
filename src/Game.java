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

//        initialize character
        Character player = new Character();
        player.getName(sc);

//        set start passage pid and set start passage as current passage
        Passage currentPassage = passages_obj.getStartPassage();
//        print start passage
        currentPassage.printPassage(player);
//        start quest
        while(!currentPassage.isLast()) {
//            get player's choice from scanner
            int next_link = sc.nextInt();
//            set chosen passage as currentPassage
            currentPassage = passages_obj.getPassageByPid(currentPassage.getPassagePidByLinkNumber(next_link));
//            print current passage
            currentPassage.printPassage(player);
        }
//        end of the game
//        print some information
        System.out.println("\n\n---------------------------------------------------------------\n" + passages_obj.name + "\n\nGitHub: https://github.com/lkjuhkmnop/SITS-3.1.3-my\n\nMade using " + passages_obj.creator + " " + passages_obj.creator_version + ", https://twinery.org/" + "\nIFID: " + passages_obj.ifid);
    }
}
