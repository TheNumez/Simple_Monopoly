import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.io.PrintWriter;

public class Main {
    public static Bank b = new Bank(); // ability to refer to the bank everywhere
    public static void main(String[] args) {
// initialization of variables:
        String s;
        int id = 0;
        char ch;
        ArrayList<Player> players = new ArrayList<Player>();
        Board board = new Board();

        // infinite loop that will execute until it is ended by break
        while (true) {
            String choice = JOptionPane.showInputDialog(null,
                    "Enter choice:\n" +
                            "1 - Add player\n"
                            + "2 - Start game");
            // if user chooses option 1, an object of class Player will be created and added to the list of players
            if (choice.equals("1")) {
                String name = JOptionPane.showInputDialog(null, "Enter player name:");
                Player p = new Player(name, id++);
                players.add(p);
            }
            // if user chooses option 2, it will be checked if there is enough players to start the game
            else if (choice.equals("2")) {
                if (players.size() < 2) {
                    JOptionPane.showMessageDialog(null, "Minimum number of players required to start the game is 2!");
                } else {
                    JOptionPane.showMessageDialog(null, "Starting the game...");
                    break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid choice");
            }
        }

        int turn = 0;
        // another infinite loop that will execute until it is ended by break
        while (true) {
            int w22;
            // displaying dialog box and getting user choice
            String w2= JOptionPane.showInputDialog(null,"[1] continue playing, [2] save game state");
            w22=Integer.parseInt(w2);
            // if user chooses option 1, another turn will be executed
            if (w22 == 1) {
                JOptionPane.showMessageDialog(null, "Current balance of player " + players.get(turn).getName() + " = " + players.get(turn).getBalance());
                JOptionPane.showMessageDialog(null, "Turn of player: " + players.get(turn).getName() + ", roll the dice.");
                players.get(turn).move();
                board.turn(players.get(turn)); // invokes methods of the fields
                if (turn == players.size() - 1) {
                    turn = 0;
                } else {
                    turn++;
                }
            }
            //// if user chooses option 2, game state will be saved to a text file called game_state.txt
            if (w22 == 2) {
                try {
                    PrintWriter writer = new PrintWriter("game_state.txt", "UTF-8");

                    for (Player p : players) {
                        writer.println(p.getName() + ": " + p.getBalance());
                    }

                    for (Player p : players) {
                        writer.println(p.getName() + " owns:");
                        for (Pool f : p.getPropertiesOwned()) {
                            writer.println("- " + f.getName());
                        }
                    }
                    System.out.println("Game state successfully saved. You can find it in the file game_state.txt.");
                    writer.close();
                } catch (IOException e) {

                }
            }
        }

    }
}