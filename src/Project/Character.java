package Project;

public class Character {
    private final String name;
    private int health;
    private boolean hasAmulet;

    public Character(String name, int health) {
        this.name = name;
        this.health = health;
        this.hasAmulet = false;
    }

    public void equipAmulet() {
        hasAmulet = true;
        System.out.println("The Amulet of Courage shields your heart from fear!");
    }

    public void takeDamage(int damage) {
        if (hasAmulet) {
            System.out.println("The amulet absorbs some of the damage.");
            damage -= 5; // Amulet reduces damage.
        }
        health -= Math.max(0, damage);
        if(health < 0) health = 0;
        System.out.println(name + " took " + damage + " damage. Current health: " + health);
    }

    public void takeHealing(int heal) {
        health += heal;
        if (health > 100) health = 100;
        System.out.println(name + " healed " + heal + " health. Current health: " + health);
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public void resetStats(){
        health = 100;
        hasAmulet = false;
    }
}
