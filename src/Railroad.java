import javax.swing.*;

public class Railroad extends Pool {
    public int price;
    public int rent;
    public Player owner;

    public Railroad(int id, String name, int price, int rent) {
        super(id, name);
        this.price = price;
        this.rent = rent;
        this.owner = null;
    }

    public void setOwner(Player player) {
        this.owner = player;
    }

    public int getPrice() {
        return price;
    }

    public int getRent() {
        return rent;
    }

    public Player getOwner() {
        return owner;
    }

    public boolean isAvailable() {
        return getOwner() == null;
    }

    public void action(Player player)
    {
        JOptionPane.showMessageDialog(null, "You have landed on " + getName() + ".");
        if (this.isAvailable())
        {
            int purchase = JOptionPane.showConfirmDialog(null, "Do you want to buy " + getName() + " for " + price + "?");
            if (purchase == JOptionPane.YES_OPTION)
            {
                JOptionPane.showMessageDialog(null, "You have successfully purchased "+getName()+ " by "+player.getName());
                player.subtractAmount(200);
                Main.b.deposit(200);
                player.propertiesOwned.add(this);
                this.owner = player;

            }
        }
        else
        {
            Player owner = this.getOwner();
            int rent = this.getRent();
            JOptionPane.showMessageDialog(null, player.getName() + " pays " + owner.getName() + " rent of " + rent);
            player.payOtherPlayer(owner, rent);


        }

    }
}