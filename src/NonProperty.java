import javax.swing.*;
import java.util.Random;

public class NonProperty extends Pool {
    public int id;
    public String name;

    public NonProperty(int id, String name) {
        super(id, name);
    }

    public void action(Player player) {
        Random rand = new Random();
        int randomNum = rand.nextInt(2) + 1;
        switch (randomNum) {
            case 1:
                JOptionPane.showMessageDialog(null, "You landed on a chance square, you get $200!");
                player.addAmount(200);
                Main.b.withdraw(player, 200);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "You landed on a chance square, you lose $200!");
                player.subtractAmount(200);
                Main.b.deposit( 200);
                break;
        }
    }
}