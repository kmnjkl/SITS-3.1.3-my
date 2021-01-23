public class CharacterParameter {
    public String name;
    public int startValue;
    public int minValue, maxValue;
    public String minValPassageName, maxValPassageName;

    public CharacterParameter(String name, int startValue, int minValue, String minValPassageName, int maxValue, String maxValPassageName) {
        this.name = name;
        this.startValue = startValue;
        this.minValue = minValue;
        this.minValPassageName = minValPassageName;
        this.maxValue = maxValue;
        this.maxValPassageName = maxValPassageName;
    }
}
