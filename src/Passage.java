import java.util.List;

public class Passage {
    public String text;
    public List<Link> links;
    public String name;
    public int pid;
    public Position position;

    @Override
    public String toString() {
        return "Passage{" +
                "\n\ttext='" + text + '\'' +
                ",\n\t links=" + links +
                ",\n\t name='" + name + '\'' +
                ",\n\t pid=" + pid +
                ",\n\t position=" + position +
                "}\n";
    }
}
