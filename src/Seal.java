public class Seal extends Animal implements Swimmable{

    private String skillLevel;

    public Seal(String name, int age, String colour, int weight, int skillinput){
        super(name, age, colour, weight);
        this.skillLevel = convertSkillLevel(skillinput);
    }

    // function to convert skill input into a readable string for skill level
    private String convertSkillLevel(int skillInput) {
        switch (skillInput) {
            case 1: return "Novice";
            case 2: return "Intermediate";
            case 3: return "Expert";
            default: return "Unknown";
        }
    }

    // Swimmable interface methods
    @Override
    public void swim() {
        System.out.println(getName() + " is gliding gracefully through the water!");
    }

    @Override
    public void checkFinHealth() {
        System.out.println("Checking fin health for " + getName() + " (skill level: " + getSkillLevel() + ") - Fins look Healthy!");
    }

    @Override
    public double getSwimSpeed() {
        // return different swim speeds based on skill level
        switch (skillLevel) {
            case "Expert": return 30.0;
            case "Intermediate": return 20.0;
            case "Novice": return 10.0;
            default: return 0.0;
        }
    }

    @Override
    public String makeSound() {
        return "Arf! I am " + getName() + ", a " + getAge() + " year old seal.";
    }

    // setters
    public void setSkillLevel(int skillInput) {
        this.skillLevel = convertSkillLevel(skillInput);
    }

    // overloaded version of method for when data is loaded from a file
    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    // getters
    public String getSkillLevel(){
        return skillLevel;
    }
}
