import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Player {
    // Class attributes initialization
    public String name;
    private int balance;
    public int numRailroadsOwned;
    public int numUtilitiesOwned;
    public int position;
    public int id;
    public ArrayList<Pool> propertiesOwned;

    // Constructor for the Player class
    public Player(String name, int id) {
        position = 0;
        this.id = id;
        this.name = name;
        balance = 10000;
        numRailroadsOwned = 0;
        numUtilitiesOwned = 0;
        this.propertiesOwned = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void addAmount(int amount) {
        this.balance += amount;
    }

    public void subtractAmount(int amount) {
        this.balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public void payOtherPlayer(Player player, int payment) {
        balance -= payment;
        player.balance += payment;
    }

    public boolean isPropertyOwner(Pool property) {
        return propertiesOwned.contains(property);
    }

    public ArrayList<Pool> getPropertiesOwned() {
        return propertiesOwned;
    }

    // Method responsible for moving the player
    public void move() {
        Random rand = new Random();
        int die1 = rand.nextInt(6) + 1;
        int die2 = rand.nextInt(6) + 1;
        int sum = die1 + die2;
        JOptionPane.showMessageDialog(null, "You rolled " + sum + " on the dice.");
        if (position + sum < 35) {
            position = position + sum;
        } else {
            position = (position + sum) - 35;
            JOptionPane.showMessageDialog(null, "You passed start. $200 added to your account.");
            balance += 200;
            Main.b.withdraw(this, 200);
        }
    }
}
