import java.util.Scanner;

public class Character {
    public String name;
    public CharacterParameter[] parameters;

    public Character(String name, CharacterParameter[] parameters) {
        this.name = name;
        this.parameters = parameters;
    }

    public void getName(Scanner sc) {
        System.out.println("Введите ваше имя: ");
        this.name = sc.next();
    }
}