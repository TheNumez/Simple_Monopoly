import javax.swing.*;

public class Board {
    public Pool[] properties;
    public static final int numFields = 35;
    public static final int startMoney = 200;

    //static board with 35 fields
    public Board() {
    //declaration of each field separately, assignment of type and appropriate attributes for each separately.
        properties = new Pool[numFields];
        properties[0] = new Property(0, "Start", 0);
        properties[1] = new Property(1, "Mediterranean Avenue", 60);
        properties[2] = new NonProperty(2, "Community Chest");
        properties[3] = new Property(3, "Baltic Avenue", 60);
        properties[4] = new Tax(4, "Income Tax", 200);
        properties[5] = new Railroad(5, "Reading Railroad", 200, 200);
        properties[6] = new Property(6, "Oriental Avenue", 100);
        properties[7] = new Property(7, "Vermont Avenue", 100);
        properties[8] = new Property(8, "Connecticut Avenue", 120);
        properties[9] = new Property(9, "St. Charles Place", 140);
        properties[10] = new Tax(10, "Electric Company", 150);
        properties[11] = new Property(11, "States Avenue", 140);
        properties[12] = new Property(12, "Virginia Avenue", 160);
        properties[13] = new Railroad(13, "Pennsylvania Railroad", 200, 200);
        properties[14] = new Property(14, "St. James Place", 180);
        properties[15] = new NonProperty(15, "Community Chest");
        properties[16] = new Property(16, "Tennessee Avenue", 180);
        properties[17] = new Property(17, "New York Avenue", 200);
        properties[18] = new NonProperty(18, "Free Parking");
        properties[19] = new Property(19, "Kentucky Avenue", 220);
        properties[20] = new Property(20, "Indiana Avenue", 220);
        properties[21] = new Property(21, "Illinois Avenue", 240);
        properties[22] = new Railroad(22, "B&O Railroad", 200, 200);
        properties[23] = new Property(23, "Atlantic Avenue", 260);
        properties[24] = new Property(24, "Ventnor Avenue", 260);
        properties[25] = new Tax(25, "Water Works", 150);
        properties[26] = new Property(26, "Marvin Gardens", 280);
        properties[27] = new Property(27, "Pacific Avenue", 300);
        properties[28] = new Property(28, "North Carolina Avenue", 300);
        properties[29] = new NonProperty(29, "Community Chest");
        properties[30] = new Property(30, "Pennsylvania Avenue", 320);
        properties[31] = new Railroad(31, "Short Line", 200, 200);
        properties[32] = new Property(32, "Park Place", 350);
        properties[33] = new Tax(33, "Luxury Tax", 100);
        properties[34] = new Property(34, "Boardwalk", 400);
    }

    public void turn(Player a) {
        properties[a.getPosition()].action(a); //responsible for triggering the action method for a specified position
    }
}