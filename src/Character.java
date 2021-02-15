public class Character {
    public String name;
    public CharacterParameter[] parameters;

    public Character(String name, CharacterParameter[] parameters) {
        this.name = name;
        this.parameters = parameters;
    }

    public Character(CharacterParameter[] parameters) {
        this.parameters = parameters;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParamsText() {
        return null;
    }
}