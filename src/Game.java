import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        initialize mapper to parse json with passages from Twine (Twineson)
        ObjectMapper mapper = new ObjectMapper();
//        parse json
        Passages story = mapper.readValue(new File("C://Java\\Projects\\SITS-3.1.3-my\\res", "passages.json"), Passages.class);
//        initialize the story
        story.init();
//        initialize character
        System.out.println("Введите ваше имя: ");
        String name = sc.next();
        Character player = new Character(name, story.charParamsArray);
    }

    public static void consolePrint(String text) {
        System.out.print(text);
    }

    public static void charParamsPrint(Character player) {
        System.out.print(player.getParamsText());
    }
}
