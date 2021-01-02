// Filip Garica figa6281


import java.util.Arrays;

public class Owner {

    private Register register = new Register();

    private String name;
    private Dog[] dogsAssignedToOwner = new Dog[0];

    public Owner(String name) {
        this.name = name.toLowerCase();
    }

    public Owner() {
        return;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Dog findOwnedDog(Dog doggo){
        for(Dog dog : dogsAssignedToOwner){
            if(dog.equals(doggo)){
                return doggo;
            }
        }
        return null;
    }

    public void addDogToOwner(Dog newDog) {

        if(findOwnedDog(newDog) == null) {
            Dog[] intermediateArr =
                    Arrays.copyOf(dogsAssignedToOwner, dogsAssignedToOwner.length + 1);

            intermediateArr[dogsAssignedToOwner.length] = newDog;
            dogsAssignedToOwner = intermediateArr;


            if(newDog.getOwner() == null) {
                newDog.setOwner(this);
            }
        }
    }

    public Dog[] getDogsAssignedToOwnerArr(){
        return dogsAssignedToOwner;
    }


   /* public boolean doesOwnerOwnDog(Dog doggo) {
        for (Dog dog : register.getDogsList()) {
            if (doggo.getOwner().equals(this)) {
                return true;
            }

        }
        return false;
    }*/

    public boolean doesOwnerOwnDog(Dog doggo){
        for(Dog dog : dogsAssignedToOwner){
            if(doggo.getOwner().equals(this)){
                return true;
            }
        }
        return false;
    }

    public void setDogsAssignedToOwner(Dog[] dogsAssignedToOwner) {
        this.dogsAssignedToOwner = dogsAssignedToOwner;
    }

    @Override
    public String toString() {
        return "Owner" + " name: " + name + ", my doggos: " + Arrays.toString(dogsAssignedToOwner) + " ";
    }


}
