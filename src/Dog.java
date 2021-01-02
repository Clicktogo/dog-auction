// Filip Garica figa6281

public class Dog {

    private static Register register = new Register();

    private String name;
    private String breed;
    private int age;
    private int weight;
    private Owner owner; //= null;

    private final double tax = 3.7;


 public Dog(String name, String breed, int age, int weight) {

        if (age < 0){
            throw new IllegalArgumentException("age to low");
        }

        this.name = name.toLowerCase();
        this.breed = breed.toLowerCase();
        this.age = age;
        this.weight = weight;
        //double tailLengt = getTailLength();


    }

    public void addAge(){ //todo incrementAge
        age++;
    }


    public String getName() {
        return this.name;
    }

    public String getBreed() {
        return this.breed;
    }

    public int getAge() {  //void?
        return this.age;
    }

    public int getWeight() {
        return this.weight;
    }

    public double getTailLength() {
        if (breed.equals("tax") || breed.equals("dachshund")) {
            return tax;
        } else {
            return (double) (age * weight) / 10;
        }

    }

   /* public void setOwner(Owner owner) {
        if(owner != null){ // if owner not found return nothing.
            return;
        }
        this.owner = owner;
        this.owner.addToOwner(this);  // is it "this" because its this as in the dog in this constructor?
    }*/

    public void setOwner(Owner owner) {
        if(this.owner == null){
            this.owner = owner;
            this.owner.addDogToOwner(this);
        } else {
            throw new RuntimeException("Error: the dog already has an owner");
        }
    }

    public Owner getOwner() {
        return owner;
    }


    /*public void assignOwner(Owner owner){
        setOwner(owner);
        this.owner.addDogToOwner(this);
    }*/

   /* public int compareDogName(Dog otherDog){
     int compareFirstCharUnicode = this.name.compareTo(otherDog.name);
     //if (compareFirstCharUnicode )
    }*/

   /* public String toString() {
        return name + "\n" + breed + "\n" + age + "\n" + weight + "\n" + getTailLength();
    }*/
    @Override
    public String toString() {
        String ownerName = "";
        if(this.owner != null){
            ownerName = ", owned by " + owner.getName();
        }
        return "* " + name + " (" + breed + ", " + age + " years, " + weight + " kilo, " + getTailLength() +" cm tail " + ownerName + ")";
    }



    /*@Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }*/

   /* @Override
    public String toString() {
        return ("name:"+ name +
                " breed: "+ breed +
                " age: "+ age +
                " weight : " + weight +
                "tail lengt" + getTailLength());*/
    //}


}


