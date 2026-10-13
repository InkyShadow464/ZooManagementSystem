public class Dog extends Animal{

    private String breed;

    public Dog(String name, int age, String colour, int weight, String breed){
        super(name, age, colour, weight);
        this.breed = breed;
    }

    @Override
    public String makeSound() {
        return "Woof! I am " + getName() + ", a " + getAge() + " year old " + getBreed() + "." ;
    }

    // setters
    public void setBreed(String breed){
        this.breed = breed;
    }

    // getters
    public String getBreed(){
        return breed;
    }
}
