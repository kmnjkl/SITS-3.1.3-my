import java.util.List;

public class Passages {
    //    json attributes (json file received from Twine using Twineson)
    private List<Passage> passages;
    private String name;
    private int startnode;
    private String creator, creator_version, ifid;

    //    constants with headings that can be used in the info passage
    private final String INFO_CHAR_PARAMS_HEADING = "character_parameters";
    private final String INFO_CREDITS_HEADING = "credits";

    //    fields which are need for the story to be happening
//    current passage which should be processed in current stage of the story
    private Passage currentPassage;
    private String credits;
    public CharacterParameter[] charParamsArray;

    public void go(Character player, String playerInput) {

    }

//    initialize the story
//    set some fields, get some information about the quest (from json)
    public void init() {
//        set start passage as current passage
//        we can find start passage by it's pid specified in json attributes (from Twineson)
        this.currentPassage = this.getPassageByPid(this.startnode);

//        get parameters from info passage
//        get info passage by name
        Passage infoPassage = this.getPassageByName("info");
//        get info text from passage
        String infoText = infoPassage.text;
//        split info text around ';' to get separate statements with quest's info
        String[] infoStatements = infoText.split(";");
//        searching for possible statements (headings surrounded by '@')
        for (String statementText : infoStatements) {
//            split the statement into heading and content
            String[] statementParts = statementText.trim().split("@");
//            check if we can use this statement (check heading)
            if (statementParts[0].equals(this.INFO_CHAR_PARAMS_HEADING)) {
//                if statement contains info about character parameters
                this.setCharParamsFromInfoContent(statementParts[1]);
            } else if (statementParts[0].equals(this.INFO_CREDITS_HEADING)) {
//                if statement contains info about credits of this quest
                this.setCreditsFromInfoContent(statementParts[1]);
            }
        }
    }

    //    set credits info defined for this quest in the info passage
//    string with information from the info passage was received in init() method
    private void setCreditsFromInfoContent(String infoContent) {
        this.credits = infoContent.trim();
    }

    //    set character parameters defined for this quest is the info passage
//    string with parameters from the info passage was received in init() method
    private void setCharParamsFromInfoContent(String infoContent) {
//        split string into separate parameters
        String[] parameters = infoContent.split(",");
        this.charParamsArray = new CharacterParameter[parameters.length];
        int i = 0;
        for (String param : parameters) {
//            split each parameter into it's name and other info about it (surrounded by '[' and ']')
            String[] paramParts = param.split("[\\[\\]]");
//            split parameter info into start value, min value with appropriate passage, max value with appropriate passage
//            [0] - start value, [1] - min value with appropriate passage, [2] - max value with appropriate passage
            String[] paramInfoParts = paramParts[1].split("\\|");
//            split min and max info into values and appropriate passages names
            String[] minValueParts = paramInfoParts[1].split("=");
            String[] maxValueParts = paramInfoParts[2].split("=");
            this.charParamsArray[i] = new CharacterParameter(paramParts[0], Integer.parseInt(paramInfoParts[0]), Integer.parseInt(minValueParts[0]), minValueParts[1], Integer.parseInt(maxValueParts[0]), maxValueParts[1]);
            i++;
        }
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

    //    method searches for matches of passages (in field passages:List<Passage>) pids and specified int number (pid)
    public Passage getPassageByPid(int pid) {
        for (Passage passage : this.passages) {
            if (passage.pid == pid) {
                return passage;
            }
        }
        return null;
    }

    public Passage getPassageByName(String name) {
        for (Passage passage : this.passages) {
            if (passage.name.equals(name)) {
                return passage;
            }
        }
        return null;
    }
}
