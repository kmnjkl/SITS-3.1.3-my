import java.util.Scanner;

public class Character {
    public int K;
    public int A;
    public int R;
    public String name;

    public Character(String name) {
        K = 1;
        A = 100;
        R = 50;
        this.name = name;
    }

    public Character() {
        K = 1;
        A = 100;
        R = 50;
    }

    public void changeParams(int dK, int dA, int dR) {
        this.K += dK;
        this.A += dA;
        this.R += dR;
    }

    public void getName(Scanner sc) {
        System.out.println("Введите ваше имя: ");
        this.name = sc.next();
    }
}