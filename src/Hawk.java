public class Hawk extends Animal implements Flyable{

    private int wingSpan;

    public Hawk(String name, int age, String colour, int weight, int wingSpan){
        super(name, age, colour, weight);
        this.wingSpan = wingSpan;
    }

    // Flyable interface methods
    @Override
    public void fly() {
        System.out.println(getName() + " is soaring through the sky!");
    }

    @Override
    public void checkWingHealth() {
        System.out.println("Checking wing health for " + getName() + " (Wingspan: " + getWingSpan() + "cm) - All good!");
    }

    @Override
    public double getMaxAltitude() {
        return getWingSpan() * 12.5; // calculation is an example
    }

    @Override
    public String makeSound() {
        return "Screech! I am " + getName() + ", a " + getAge() + " year old hawk.";
    }

    // setters
    public void setWingSpan(int WingSpan){
        this.wingSpan = WingSpan;
    }

    // getters
    public int getWingSpan(){
        return wingSpan;
    }
}
