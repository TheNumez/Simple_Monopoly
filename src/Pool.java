import javax.swing.*;

public abstract class Pool
{
    public String name;
    public int id;

    public Pool(int id, String name)
    {
        this.name=name;
        this.id=id;

    }

    public String getName()
    {
        return name;
    }
    public int getId()
    {
        return id;
    }

    public void action(Player player)
    {

    }



}
