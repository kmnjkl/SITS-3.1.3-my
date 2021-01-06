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

    public String getCleanTextFromPassageText() {
        StringBuilder sbtext = new StringBuilder(this.text);
        int i_start = sbtext.lastIndexOf("[[");
        int i_end = sbtext.lastIndexOf("]]");
        while (i_start >= 0 && i_end >= 0) {
            sbtext.delete(i_start, i_end+2);
            i_start = sbtext.lastIndexOf("[[");
            i_end = sbtext.lastIndexOf("]]");
        }
        return sbtext.toString().replaceAll("(?m)^[ \t]*\r?\n", "");
    }

    public int getPassagePidByLinkNumber(int link_n) {
        return this.links.get(link_n-1).pid;
    }

    public boolean isLast() {
        return links.isEmpty() || this.name.equals("end") || this.name.equals("last");
    }

    public void printPassage() {
        System.out.println(this.getCleanTextFromPassageText());
        for (int i=1; i <= links.size(); i++) {
            System.out.println(i + "\t" + links.get(i-1).name);
        }
    }
}
