import javax.swing.*;

public class Tax extends Pool {
    public int penaltyAmount;


    public Tax(int id, String name, int penaltyAmount)
    {
        super(id, name);
        this.penaltyAmount = penaltyAmount;
    }

    public int getPenaltyAmount() {
        return penaltyAmount;
    }

    public void action(Player player) {
        JOptionPane.showMessageDialog(null, "You have to pay a penalty of " + getPenaltyAmount() + ".");
        player.subtractAmount(getPenaltyAmount());
        Main.b.deposit(getPenaltyAmount());
    }
}