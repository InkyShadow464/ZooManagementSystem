public abstract class Animal {
    private String name;
    private int age;
    private String colour;
    private int weight;

    public Animal(String name, int age, String colour, int weight){
        this.name = name;
        this.age = age;
        this.colour = colour;
        this.weight = weight;
    }

    // Base makeSound - overridden by each subclass
    public abstract String makeSound();

    // setters
    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setColour(String colour){
        this.colour = colour;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    // getters

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getColour(){
        return colour;
    }

    public int getWeight() {
        return weight;
    }

}
