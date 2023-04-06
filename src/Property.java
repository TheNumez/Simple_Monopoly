import javax.swing.*;

public class Property extends Pool {
    public int housePrice;
    public int rent;
    public int price;
    public Player owner;
    public int numHouses;

    public Property(int id, String name, int price) {
        super(id, name); // call to the parent class with arguments
        this.price = price;
        this.housePrice = 100;
        this.owner = null;
        rent = price / 10;
        this.numHouses = 0;
    }

    public int getPrice() {
        return price;
    }

    public int getRent() {
        if (numHouses == 0) {
            return rent;
        } else {
            return rent * numHouses;
        }
    }

    public Player getOwner() {
        return owner;
    }

    public boolean isAvailable() {
        return getOwner() == null;
    }

    public void setOwner(Player p) {
        this.owner = p;
    }

    public boolean canBuy(Player p) {
        return p.getBalance() >= price;
    }

    public boolean isOwnedBy(Player p) {
        return getOwner() == p;
    }

    // @Override to override a method with the same name and parameters in the parent class
    @Override
    public void action(Player p) {
        // Display a message that the player landed on the property
        JOptionPane.showMessageDialog(null, "You landed on " + getName() + ".");
        // Check if the player is the owner of the property
        if (p.isPropertyOwner(this)) {
            String choice;
            int quantity;
            housePrice = 100;
            choice = JOptionPane.showInputDialog(null, "How many houses do you want to buy? House price: " + housePrice);
            quantity = Integer.parseInt(choice);
            if (quantity == 0) {
                JOptionPane.showMessageDialog(null, "No houses were bought.");
            } else if (numHouses + quantity <= 5) {
                p.subtractAmount(quantity * housePrice);
                numHouses += quantity;
                JOptionPane.showMessageDialog(null, "You have successfully bought " + quantity + " houses in " + getName() + ".");
            } else if (quantity > 5) {
                JOptionPane.showMessageDialog(null, "You cannot buy that many houses. Maximum is 5.");
            }
        }
        // If the player is not the owner, but the property is available for purchase
        else if (this.isAvailable()) {
            int purchase = JOptionPane.showConfirmDialog(null, "Do you want to buy " + getName() + " for " + price + "?");
            if (purchase == JOptionPane.YES_OPTION) {
                // If the player wants to buy, subtract the amount from their balance, add the property to their list of properties, and set them as the owner
                p.subtractAmount(price);
                Main.b.deposit(price);
                p.propertiesOwned.add(this);
                this.owner = p;
            }
        }
        // If the player is not the owner and the property is occupied by another player, charge player
            else
            {
                Player owner = this.getOwner();
                int rent = this.getRent();
                JOptionPane.showMessageDialog(null, "Player " + p.getName() + " pays rent of " + rent + " to owner " + owner.getName());
                    // take rent amount from player and give it to the owner of the property:
                p.payOtherPlayer(owner, rent);
                int purchase2 = JOptionPane.showConfirmDialog(null, "Do you want to buy the property " + getName() + " from player: " + owner.getName() + " for " + getPrice() + "?");
                if (purchase2 == JOptionPane.YES_OPTION)
                {
                    p.payOtherPlayer(owner, rent);
                    // set the player as the new owner of the property
                    this.owner = p;
                    // add the property to the player's list of owned properties
                    p.propertiesOwned.add(this);
                    // remove the property from the previous owner's list of owned properties
                    owner.propertiesOwned.remove(this);
                    // display information about the successful purchase of the property
                    JOptionPane.showMessageDialog(null,"Property " + getName() + " purchased successfully");
                }

            }

        }

}
