import java.util.List;

public class Passages {
    public List<Passage> passages;
    public String name, startnode, creator, creator_version, ifid;

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
}
