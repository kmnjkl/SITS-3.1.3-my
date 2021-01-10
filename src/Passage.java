import java.util.List;

public class Passage {
    public String text;
    public List<Link> links;
    public String name;
    public int pid;
    public Position position;

    public int dK, dA, dR;

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

    public void passageProcessing() {
//        1. get character parameters deltas from passage name
//          change character parameters
//          print character parameters
//        2. get clean text
//          print clean text and links
        
        this.getCharacterParametersDeltas();
    }

    private void getCharacterParametersDeltas() {
        int paramsDeltasBeginIndex = name.indexOf(":") + 1;
        String paramsDeltasString = name.substring(paramsDeltasBeginIndex);
        String[] paramsDeltasStringArray = paramsDeltasString.split(" ");
        for (int i = 0; )
    }

    public String getCleanTextFromPassageText() {
        StringBuilder sbtext = new StringBuilder(this.text);
        int i_start = sbtext.indexOf("[[");
        int i_end = sbtext.indexOf("]]");
//        String d_char_params_text = new String;
        while (i_start >= 0 && i_end >= 0) {
//            delete link
            sbtext.delete(i_start, i_end+2);
//            find next link
            i_start = sbtext.indexOf("[[");
            i_end = sbtext.indexOf("]]");
        }
//        delete all empty lines and return clean text
        return sbtext.toString().replaceAll("(?m)^[ \t]*\r?\n", "");
    }

    public int getPassagePidByLinkNumber(int link_n) {
        return this.links.get(link_n-1).pid;
    }

    public boolean isLast() {
        return links == null || links.isEmpty() || this.name.equals("end") || this.name.equals("last");
    }

    public void printPassage(Character player) {
        String clean_text = this.getCleanTextFromPassageText();
        player.K += this.dK;
        player.A += this.dA;
        player.R += this.dR;
        System.out.println("\n//=====-=====-=====-=====-=====-=====-=====-=====-=====-=====\\\\");
        System.out.println( "-----" + "\t\t----\t\t" + "-----"
                + "\n|\tКарьера:\t"    + player.K + ((dK == 0) ? "\t\t==" : ((dK > 0) ? "\t\t↑ (" : "\t\t↓ (") + dK + ")") + "\t\t\t"
                + "\n|\tАктивы:\t\t"   + player.A + ((dA == 0) ? "\t\t==" : ((dA > 0) ? "\t\t↑ (" : "\t\t↓ (") + dA + ")") + "\t\t\t"
                + "\n|\tРепутация:\t"  + player.R + ((dR == 0) ? "\t\t==" : ((dR > 0) ? "\t\t↑ (" : "\t\t↓ (") + dR + ")") + "\t\t\t"
                + "\n-----"  + "\t\t----\t\t" + "-----");
        System.out.println(clean_text);
        if (this.links != null) {
            for (int i = 1; i <= this.links.size(); i++) {
                System.out.println(i + "\t" + links.get(i - 1).name);
            }
        }
        System.out.println("\\\\=====-=====-=====-=====-=====-=====-=====-=====-=====-=====//");
    }
}
