import java.util.List;

public class Passages {
    public List<Passage> passages;
    public String name;
    public int startnode;
    public String creator, creator_version, ifid;

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

    public Passage getStartPassage() {
        return this.getPassageByPid(this.startnode);
    }
}
