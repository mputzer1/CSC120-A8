import java.util.ArrayList;
import java.util.Scanner;

public class Faerie implements Contract {
    
    ArrayList<String> bag = new ArrayList<String>();
    int x = 0;
    int y = 0;
    int z = 0;
    double faerieSize = 5.5;

    public void grab(String item) {
        bag.add(item);
        System.out.println("The faerie added the " + item + " to their bag.");
    }

    public String drop(String item) {
        if (!bag.contains(item)) {
            throw new RuntimeException("You must grab this item first!");
        }
        bag.remove(item);
        System.out.println("The faerie removed the " + item + " from their bag.");
        return item;
    }

    public void examine(String item) {
        System.out.println("The faerie is examining the " + item + ".");
    }

    public void use(String item) {
        if (!bag.contains(item)) {
            throw new RuntimeException("You have to grab this item before you can use it!");
        }
        System.out.println("The faerie used the " + item + ".");
    }

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

    public Number shrink() {
        faerieSize -= 0.5;
        System.out.println("The faerie has shrunk by 0.5 feet and is now " + faerieSize + " feet tall.");
        return faerieSize;
    }

    public Number grow() {
        faerieSize += 0.5;
        System.out.println("The faerie has grown by 0.5 feet and is now " + faerieSize + " feet tall.");
        return faerieSize;
    }

    public void rest() {
        System.out.println("The faerie is resting.");
    }

    public void undo() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Which method will the faerie undo?");
        String undoneMethod = myObj.nextLine();
        if (undoneMethod == "grow") {
            System.out.println("The faerie will shrink!");
            shrink();
        }
        if (undoneMethod == "shrink") {
            grow();
        }
        if (undoneMethod == "walk" || undoneMethod == "fly") {
            x = 0;
            y = 0;
            z = 0;
            System.out.println("The faerie's new location is (" + x + "," + y + "," + z + ").");
        }
        if (undoneMethod == "grab") {
            String item = myObj.nextLine();
            drop(item);
        }
        if (undoneMethod == "drop") {
            String item = myObj.nextLine();
            grab(item);
        }
        myObj.close();  
    }
    
class Main {
    public static void main(String[] args) {
        Faerie Tinkerbell = new Faerie();
        Tinkerbell.grab("wand");
        Tinkerbell.drop("wand");
        //Tinkerbell.drop("wand");
        Tinkerbell.examine("Cat");
        Tinkerbell.grab("Stick");
        Tinkerbell.use("Stick");
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
    
}
