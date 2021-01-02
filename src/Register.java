// Filip Garica figa6281

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Register {
    private List<Dog> dogsList = new ArrayList<>();
    private List<Owner> ownersList = new ArrayList<>();


    public void addDog(Dog dog) {
        dogsList.add(dog);
    }

    public void addOwner(Owner owner) {
        ownersList.add(owner);
    }


    public List<Dog> getDogsList() {
        return dogsList;
    }

    public List<Owner> getOwnersList() {
        return ownersList;
    }

    public void setOwnerList(List<Owner> ownerList){
        this.ownersList = ownerList;
    }

    public List<Dog> findDogsByTailLength(double minTailLength) {
        if (dogsList.isEmpty()) {
            throw new RuntimeException("Error no dogs in register");
        }
        var dogs = new ArrayList<Dog>();
        for (Dog dog : dogsList) {
            if (dog.getTailLength() > minTailLength) {
                dogs.add(dog);
            }
        }
        return dogs;
    }

    public Dog findDogByName(String dogName) {
        Dog result = null;
        for (Dog dog : dogsList) {
            if (dog.getName().equals(dogName)) {
                result = dog;
            }
        }
        return result;
    }

    public Owner findOwnerByName(String ownerName) {
        for (Owner owner : ownersList) {
            if (owner.getName().equals(ownerName)) {
                return owner;
            }
        }
        return null;
    }

    public void listOwners() {
        if (getOwnersList().isEmpty()) {
            System.out.println("Error: no owners in register");
        } else {
            for (Owner owner : getOwnersList()) {
                System.out.print(owner.getName() + " ");
                ArrayList<String> dogsName = new ArrayList<>();
                for (Dog dog : owner.getDogsAssignedToOwnerArr()) {
                    dogsName.add(dog.getName());
                }
                System.out.println(dogsName);
            }
        }
    }

    public void listDogs() {
        if (getDogsList().isEmpty()) {
            System.out.println("Error: no dogs in register");
        } else {
            double minTailLength = Input.userInputDouble("Smallest tail length to display?> ");
            try {
                var dogsByTailLength = findDogsByTailLength(minTailLength);
                if (dogsByTailLength.isEmpty()) {
                    System.out.println("No dog matches requirements");
                } else {
                    System.out.println("The following dogs has such a large tail:");
                    for (Dog dog : dogsByTailLength) {
                        System.out.println(dog);
                    }
                }
            } catch (RuntimeException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public void removeDog(String dogName){
        var dogToRemove = findDogByName(dogName);

        if(dogToRemove != null) {
            getDogsList().remove(dogToRemove);
                if (dogToRemove.getOwner() != null) {
                    Owner owner = dogToRemove.getOwner();
                    int indexOfDogToRemove = 0;
                    Dog[] dogsOwnedArr = owner.getDogsAssignedToOwnerArr();
                    for (int i = 0; i < dogsOwnedArr.length; i++) {
                        if (dogsOwnedArr[i].equals(dogToRemove)) {
                            indexOfDogToRemove = i;
                        }
                    }
                    Dog[] arrNew = new Dog[dogsOwnedArr.length - 1];
                    for (int i = 0, k = 0; i < dogsOwnedArr.length; i++) {

                        if (i == indexOfDogToRemove) {
                            continue;
                        }
                        arrNew[k] = dogsOwnedArr[i];
                        k++;
                    }
                    owner.setDogsAssignedToOwner(arrNew);
                }

        }
        else {
            System.out.println("Error: no such dog");

        }


    }
    public void removeOwner(String nameOwner){
        List<Owner> listOfOwners = getOwnersList();
        Owner ownerToRemove = null;
        for (Owner owner : listOfOwners) {
            if (owner.getName().equals(nameOwner)) {
                ownerToRemove = owner;
                Dog[] dogArr = owner.getDogsAssignedToOwnerArr();
                if (dogArr.length != 0) {
                    for (Dog doggo : dogArr) {
                        System.out.println("deleting dog " + doggo.getName());
                        removeDog(doggo.getName());
                    }
                } else {
                    System.out.println("Owner has no dogs");
                }
            }
        }
        if(ownerToRemove != null) {
            listOfOwners.remove(ownerToRemove);
        }  else{
            System.out.println("Error: no owner in register");
        }
    }
}
