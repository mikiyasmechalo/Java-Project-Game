package Project;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<String> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
        System.out.println(item + " added to your inventory.");
    }

    public boolean hasItem(String item) {
        return items.contains(item);
    }

    public void useItem(String item) {
        if (items.contains(item)) {
            items.remove(item);
            System.out.println("You used the " + item + ".");
        } else {
            System.out.println("You don't have the " + item + " in your inventory.");
        }
    }

    public void viewInventory() {
        System.out.println("Your Inventory: " + items);
    }
}
