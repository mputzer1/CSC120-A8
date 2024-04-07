import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * The faeries class that implements the contract interface
 */
public class Faerie implements Contract {
    
    ArrayList<String> bag = new ArrayList<String>();
    int x = 0;
    int y = 0;
    int z = 0;
    double faerieSize = 5.5;
    Scanner scan = new Scanner(System.in);

    /**
     * Allows the faerie to grab items and add them to their bag
     * @param item the name of the item the faerie adds to their bag
     */
    public void grab(String item) {
        bag.add(item);
        System.out.println("The faerie added the " + item + " to their bag.");
    }

    /**
     * Allows the faerie to remove items from their bag
     * @param item the name of the item the faerie removes from their bag
     * @return item the name of removed item
     */
    public String drop(String item) {
        if (!bag.contains(item)) {
            throw new RuntimeException("You must grab this item first!");
        }
        bag.remove(item);
        System.out.println("The faerie removed the " + item + " from their bag.");
        return item;
    }

    /**
     * Allows the faerie to examine an item
     * @param item the item the faerie examines
     */
    public void examine(String item) {
        System.out.println("The faerie is examining the " + item + ".");
        System.out.println("Should the faerie add this to their bag? (y/n)");
        String shouldGrab = scan.nextLine();
        if (shouldGrab.contains("y")) {
            grab(item);
        }
    }

    /**
     * Allows the faerie to use an item. If the faerie uses a wand, spellcasting() is called.
     * @param item the item the faerie uses
     */
    public void use(String item) {
        if (!bag.contains(item)) {
            throw new RuntimeException("You have to grab this item before you can use it!");
        }
        if (item.contains("wand")) {
            spellcasting();
        }
        System.out.println("The faerie used the " + item + ".");
    }

    /**
     * Allows the faerie to cast a random spell.
     */
    public void spellcasting() {
        System.out.println("The faerie will cast a spell!");
        String[] spells = {
        "shapeshifting spell", 
        "aging spell", 
        "invisible spell.", 
        "explosion spell",
        "wisdom spell"}; 
        Random random = new Random();
        String randomSpell;
        randomSpell = spells[random.nextInt(spells.length)];
        System.out.println("The faerie just cast the "+ randomSpell + ".");
    }

    /**
     * Allows the faerie to change their x or z coordinates for location
     * @param direction the direction the faerie will go
     * @return boolean indicates whether faerie was able to change locations
     */
    public boolean walk(String direction) {
        if (direction == "right") {
            x += 1;
            System.out.println("The faerie's new location is (" + x + "," + y + "," + z + ").");
            return true;
        }
        if (direction == "left") {
            x -= 1;
            System.out.println("The faerie's new location is (" + x + "," + y + "," + z + ").");
            return true;
        }
        if (direction == "forward") {
            z += 1;
            System.out.println("The faerie's new location is (" + x + "," + y + "," + z + ").");
            return true;
        }
        if (direction == "backward") {
            z -= 1;
            System.out.println("The faerie's new location is (" + x + "," + y + "," + z + ").");
            return true;
        }
        throw new RuntimeException("You did not input a valid direction!");
    }

    /**
     * Allows the faerie to change their x, y, and z coordinates
     * @param x allows the faerie to move right or left
     * @param y allows faerie to move up or down
     * @param z allows faerie to move forward or backward
     * @return boolean indicates if faerie was able to move
     */
    public boolean fly(int x, int y, int z) {
       if (!(y > 0)) {
        throw new RuntimeException("You have not flown! You must enter a number greater than 0 for y!");
       }
        x += x;
        y += y;
        z += z;
        System.out.println("The faerie has flown! Their new location is (" + x + "," + y + "," + z + ").");
        return true;
    }

    /**
     * Shrinks the faerie's size by 0.5 feet.
     * @return faerieSize
     */
    public Number shrink() {
        faerieSize -= 0.5;
        System.out.println("The faerie has shrunk by 0.5 feet and is now " + faerieSize + " feet tall.");
        return faerieSize;
    }

    /**
     * Grows the faerie's size by 0.5 feet.
     * @return faerieSize
     */
    public Number grow() {
        faerieSize += 0.5;
        System.out.println("The faerie has grown by 0.5 feet and is now " + faerieSize + " feet tall.");
        return faerieSize;
    }

    /**
     * Allows the faerie to rest.
     */
    public void rest() {
        System.out.println("The faerie is resting.");
    }

    /**
     * Allows certain methods such as grow, shrink, walk, fly, grab, and drop to be undone.
     */
    public void undo() {
        System.out.println("Which method(s) will the faerie undo?");
        String undoneMethod = scan.nextLine();
        if (undoneMethod.contains("grow")) {
            System.out.println("The faerie will shrink!");
            shrink();
        }
        if (undoneMethod.contains("shrink")) {
            grow();
        }
        if (undoneMethod.contains("walk") || undoneMethod.contains("fly")) {
            x = 0;
            y = 0;
            z = 0;
            System.out.println("The faerie's new location is (" + x + "," + y + "," + z + ").");
        }
        if (undoneMethod.contains("grab")) {
            System.out.println("What will the faerie drop?");
            String item = scan.nextLine();
            drop(item);
        }
        if (undoneMethod.contains("drop")) {
            System.out.println("What will the faerie grab?");
            String item = scan.nextLine();
            grab(item);
        }
    }
    
    /**
     * Allows the methods for the class to be tested
     * @param args
     */
    public static void main(String[] args) {
        Faerie Tinkerbell = new Faerie();
        Tinkerbell.grab("wand");
        Tinkerbell.drop("wand");
        //Tinkerbell.drop("wand");
        Tinkerbell.examine("Cat");
        Tinkerbell.grab("wand");
        Tinkerbell.use("wand");
        Tinkerbell.walk("right");
        //Tinkerbell.walk("r");
        //Tinkerbell.fly(2, 0, 3);
        Tinkerbell.fly(2, 4, 5);
        Tinkerbell.fly(6,7,8);
        Tinkerbell.shrink();
        Tinkerbell.grow();
        Tinkerbell.rest();
        Tinkerbell.undo();
    }
}
