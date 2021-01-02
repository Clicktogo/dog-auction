// Filip Garica figa6281

import java.util.*;

public class Assignment {


    /*
     * Allt eftersom du skriver dina metoder fyller du i deras namn i konstanterna
     * nedan. Testprogrammet använder dessa konstanter för att hitta dina metoder,
     * så det är viktigt att namnen stämmer.
     */
    public static final String REGISTER_NEW_DOG_METHOD = "registerNewDog"; // U7.1
    public static final String LIST_DOGS_METHOD = "listDogs"; // U7.2 och U8.4
    public static final String FIND_DOG_METHOD = "findDogsByName"; // U7.3 - hjälpmetod tänkt att användas i de följande stegen
    public static final String INCREASE_AGE_METHOD = "increaseAge"; // U7.4
    public static final String REMOVE_DOG_METHOD = "removeDog"; // U7.5, U8.6 och U9.6
    public static final String SORT_DOGS_METHOD = "sortDogsList"; // U7.6
    public static final String REGISTER_NEW_OWNER_METHOD = "registerNewOwner"; // U8.1
    public static final String FIND_OWNER_METHOD = "findOwnerByName"; // U8.2 - hjälpmetod tänkt att användas i de följande stegen
    public static final String GIVE_DOG_METHOD = "giveDog"; // U8.3 och framåt
    public static final String LIST_OWNERS_METHOD = "listOwners"; // U8.4
    public static final String OWNER_OF_DOG_METHOD = "doesOwnerOwnDog"; // U8.5, obs! metoden ska ligga i Owner-klassen
    public static final String REMOVE_OWNER_METHOD = "removeOwner"; // U8.7 och U9.6
    public static final String START_AUCTION_METHOD = ""; // U9.1 och framåt
    public static final String FIND_AUCTION_METHOD = ""; // U9.2 - hjälpmetod tänkt att användas i de följande stegen
    public static final String MAKE_BID_METHOD = ""; // U9.3 och framåt
    public static final String LIST_BIDS_METHOD = ""; // U9.4 och framåt
    public static final String LIST_AUCTIONS_METHOD = ""; // U9.5 och framåt
    public static final String CLOSE_AUCTION_METHOD = ""; // U9.6

    /********************************************************************************
     * Här nedanför skriver du dina metoder. Du kommer att kunna lämna in samma
     * fil(er) i samtliga inlämningar, så du behöver inte börja om för varje ny
     * metod.
     ********************************************************************************/

    private static Register register = new Register();
    private static Owner owner = new Owner();


    public static void registerNewDog() {
        String name = Input.userInputString("Name?> ");
        String breed = Input.userInputString("Breed?> ");
        int age = Input.userInputInt("Age?> ");
        int weight = Input.userInputInt("Weight?> ");


        var dog = new Dog(name, breed, age, weight);
        register.addDog(dog);

        System.out.println(name + " added to the register");
    }

    public static void listDogs() {
        register.listDogs();
    }


    public void increaseAge(){
        String name = Input.userInputString("Enter the name of the dog?> ");
        var dog = register.findDogByName(name); // Dog dog = register.findDogsByName(name);
        if(dog != null){
            dog.addAge();
            System.out.println(name + " is now one year older");
        } else {
            System.out.println("Error: no such dog");
        }
    }


    public static Dog findDogByName(String dogName){
        return register.findDogByName(dogName);
    }

    public void removeDog(){
        String dogName = Input.userInputString("Enter the name of the dog?>");
        register.removeDog(dogName);

    }


    public static void registerNewOwner(){
        String name = Input.userInputString("Name?>");
        Owner owner = new Owner(name);
        register.addOwner(owner);
        System.out.println(owner + "added to the register");
    }

    public static Owner findOwnerByName(String ownerName){
        return register.findOwnerByName(ownerName);
    }

    // Kommentera vilken källa du använder och hur den fungerar.
    public Dog sortDogsList(){


    return null;
    }

    public static void giveDog(){
        Dog dog = findDogByName(Input.userInputString("Enter the name of the dog?>"));
        if(dog == null){
            System.out.println("Error: no dog with that name");
            return;
        }

        if(dog.getOwner() != null) {
            System.out.println("Error: dog already has an owner");
            return;
        }

        Owner owner = findOwnerByName(Input.userInputString("Enter the name of the new owner?>"));
        if(owner == null){
            System.out.println("Error: no such owner");
            return;
        }

            dog.setOwner(owner);
            System.out.println(owner.getName() + " now owns " + dog.getName());

    }

    public void listOwners(){
        register.listOwners();
    }

    public void removeOwner(){
        String nameOwner = Input.userInputString("Enter the name from the user: ");
        register.removeOwner(nameOwner);
    }




    /*
     * Metoderna nedan är till för att testprogrammet ska sätta upp och kontrollera
     * olika saker. De är INTE tänkta att användas i din egen kod. Du måste fylla i
     * den saknade koden i metoderna allteftersom de behövs av testprogrammet.
     */

    /*
     * Byt ut koden i nedanstående metod så att den väntar på att användaren trycker
     * på return. Du gör detta genom att anropa nextLine-metoden på din scanner.
     *
     * Om du inte du gjort övningen till F6 där man ska skriva en egen klass för att
     * hantera inmatning så gör den. Den är ett bra exempel på en klass med
     * funktionalitet, och kommer att göra inlämningsuppgifterna enklare eftersom du
     * inte kommer att drabbas av några vanliga fel.
     *
     * Behövs från U7.5, eventuellt tidigare
     */
    public void waitForUserInput() {
        Input.inputFromUser();
        // Ersätt raden nedan med NAMNPÅSCANNER.nextLine() eller motsvarande anrop på din egen klass
        //throw new RuntimeException("Assignment.waitForUserInput är inte implementerad");
    }

    /*
     * Byt ut koden i nedanstående metod så att hunden läggs in i listan av hundar.
     * Kravet i uppgiften är formulerat så att en ArrayList ska användas, men det är
     * okej att använda andra klasser ur Javas Collection-api om du känner till dem.
     *
     * Behövs från U7.2
     */
    public void addDog(Dog d) {
        register.addDog(d);
        // Ersätt raden nedan med NAMNPÅLISTAN.add(d); eller motsvarande anrop
        //throw new RuntimeException("Assignment.addDog(Dog) är inte implementerad");
    }

    /*
     * Byt ut koden i nedanstående metod så att listan på hundar returneras.
     *
     * Kravet i uppgiften är formulerat så att en ArrayList ska användas, men det är
     * okej att använda andra list-klasser ur Javas Collection-api om du känner till
     * det, och föredrar en annan klass därifrån. Returtypen List gör att det går
     * att skicka tillbaka vilken listtyp som helst.
     *
     * Denna metod är ENBART till för testprogrammet i steg U7.1 till U9.7. Den ska
     * nästan säkert INTE finnas i det slutgiltiga fullständiga programmet, så
     * använd den inte i din egen kod.
     *
     * Behövs från U7.1
     */
    public List<Dog> getDogs() {
        return register.getDogsList();
        // Ersätt raden nedan med return NAMNPÅLISTAN; eller motsvarande anrop
        //throw new RuntimeException("Assignment.getDogs är inte implementerad");

    }

    /*
     * Byt ut koden i nedanstående metod så att ägaren läggs in i listan av ägare.
     * Uppgiften har inget specifikt krav på vilken typ av samling du ska använda
     * för detta, utan det får du bestämma själv. Det kan vara en array, en
     * ArrayList, en annan av Javas samlingsklasser, eller något du skrivit själv.
     *
     * Kravet i uppgiften är formulerat så att en ArrayList ska användas, men det är
     * okej att använda andra klasser ur Javas Collection-api om du känner till det,
     *
     * Behövs från U8.2
     */
	public void addOwner(Owner o) {
		// Ersätt raden nedan med NAMNPÅLISTAN.add(o); eller motsvarande anrop
		register.getOwnersList().add(o);
	}

    /*
     * Byt ut koden i nedanstående metod så att ägaren läggs in i listan av ägare.
     * Uppgiften har inget specifikt krav på vilken typ av samling du ska använda
     * för detta, utan det får du bestämma själv. Det kan vara en array, en
     * ArrayList, en annan av Javas samlingsklasser, eller något du skrivit själv.
     *
     * Kravet i uppgiften är formulerat så att en ArrayList ska användas, men det är
     * okej att använda andra klasser ur Javas Collection-api om du känner till dem.
     *
     * Behövs från U8.1
     */
	public Collection<Owner> getOwners() {
		// Ersätt raden nedan med return NAMNPÅSAMLINGEN; eller motsvarande anrop
		return register.getOwnersList();
	}

    /*
     * Om du använder en array för att spara ägarna kan nedanstående variant
     * användas istället
     */
//	public Collection<Owner> getOwners() {
//		return Arrays.asList(NAMNET_PÅ_ARRAYEN);
//	}

}
