import java.util.List;
import java.util.Scanner;

public class Passages {
    public List<Passage> passages;
    public String name;
    public int startnode;
    public String creator, creator_version, ifid;

    private Passage currentPassage;

    public void init() {
//        set start passage as current passage
        this.currentPassage = this.getStartPassage();

//        info passage
    }

    public void go(Scanner sc, Character player) {
//        change and print player parameters
//        print current passage
//        get link number, change current passage
        currentPassage.printPassage();
    }

    @Override
    public String toString() {
        return "Passages{" +
                "passages=" + passages +
                ",\n name='" + name + '\'' +
                ",\n startnode='" + startnode + '\'' +
                ",\n creator='" + creator + '\'' +
                ",\n creator_version='" + creator_version + '\'' +
                ",\n ifid='" + ifid + '\'' +
                '}';
    }

    public Passage getPassageByPid(int pid) {
        for (Passage passage: this.passages) {
            if (passage.pid == pid) {
                return passage;
            }
        }
        return null;
    }

    public int getPassagePidByName(String name) {
        for (Passage passage: this.passages) {
            if (passage.name.equals(name)) {
                return passage.pid;
            }
        }
        return -1;
    }

    private Passage getStartPassage() {
        return this.getPassageByPid(this.startnode);
    }
}
