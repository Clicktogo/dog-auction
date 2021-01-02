import java.util.Arrays;


public class Testdog {

    public static void main(String[] args){

        /*int[] numbers = { 4, 5, 8, 2, 2, 4 };

       *//* Assignment assignment = new Assignment();
        Register register = new Register();*//*
        InsertionSort sort = new InsertionSort();
        //Assignment.registerNewOwner();

        sort.sort(numbers);
        System.out.println(Arrays.toString(numbers));*/


        /*   Assignment assignment = new Assignment();

            assignment.registerNewOwner();
            assignment.registerNewDog();
            assignment.giveDog();

*/


            // Dogs
            Dog fido = new Dog("Fido", "Border Collie", 1, 10);
            Dog floyd = new Dog("Floyd", "h", 4, 4);
            Dog ellie = new Dog("Ellie", "t", 4, 6);

            // Owners
            Owner kim = new Owner("Kim");
            Owner filip = new Owner("Filip");
            Owner katta = new Owner("katta");

            Register register = new Register();
            Owner owner = new Owner();

            //Register dogs and owners
            System.out.println("--------------------------------------------");
            register.addDog(fido);
            register.addDog(floyd);
            register.addDog(ellie);
            register.addOwner(kim);
            register.addOwner(filip);
            System.out.println(":: I've registered dogs and owners ::");

            // Set owners on dogs
            System.out.println("--------------------------------------------");
            fido.setOwner(kim);
            kim.addDogToOwner(floyd);
            System.out.println(":: Kim's doggos ::");
            System.out.println(Arrays.toString(kim.getDogsAssignedToOwnerArr()));
            System.out.println(":: List current owners ::");
            register.listOwners();

            // Remove dogs and make sure they were removed
            System.out.println("--------------------------------------------");
            System.out.println(":: Removing Floyd the dog ::");
            register.removeDog(floyd.getName());
            System.out.println(":: Listing Kim's doggos ::");
            System.out.println(Arrays.toString(kim.getDogsAssignedToOwnerArr()));

            // Remove owners (and thereby also the dogs from the registry)
            System.out.println("--------------------------------------------");
            System.out.println(":: Removing Filip the owner ::");
            register.removeOwner(kim.getName());
            System.out.println(register.getOwnersList());

            // remove owner that does not exist

            register.removeOwner(katta.getName());



    }
}
