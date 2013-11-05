import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.MouseInfo;
import greenfoot.World;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Point;

/**
 * DropDownList
 * <p>
 * List of items where there is always one item selected and shown. Clicking on it will display the other items in the list and are able to be selected.<p>
 * When expanded to display items, is removed from and added back to World to bring to front.<p>
 * <p>
 * Action listener: hasChanged()
 * 
 * @author Taylor Born
 * @version March 2011 - April 2013
 */
public class DropDownList<E>  extends WindowComponent
{
    static Font font = new Font("Times-Roman", Font.PLAIN, 12);

    private ArrayList<E> items = new ArrayList<E>();
    private int index = -1;
    private Point lastMouse = new Point(-25, -25);
    private boolean selecting = false;
    private boolean changed = false;

    /**
     * Create a new DropDownList.
     * @param items The contents of the DropDownList.
     * @param index The initial selected item index.
     */
    public DropDownList(ArrayList<E> items, int index)
    {
        this.items = items;
        this.index = index;
    }
    
    public void setLocation(int x, int y)
    {
        if (selecting)
            super.setLocation(x, y - 6 + getImage().getHeight() / 2);
        else
            super.setLocation(x, y);
    }
    public void act() 
    {
        super.act();
        
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (Greenfoot.mouseMoved(null) || Greenfoot.mouseDragged(null))
            lastMouse = new Point(mouse.getX(), mouse.getY());
        
        Point offsetMouse = new Point((int)lastMouse.getX() - (getX() - (getImage().getWidth() / 2)), (int)lastMouse.getY() - (getY() - (getImage().getHeight() / 2)));
        
        boolean clicked = Greenfoot.mouseClicked(null);
        
        if (Greenfoot.mouseClicked(this))
        {
            if (offsetMouse.getY() <= 12)
            {
                toggleSelecting();
                clicked = false;
            }
        }
        else if (clicked && selecting)
        {
            toggleSelecting();
            act();
            return;
        }
        
        int height = 12;
        if (selecting)
            height += items.size() * 12;
        
        int width = 0;
        
        Graphics2D g = (new GreenfootImage(1, 1)).getAwtImage().createGraphics();
        g.setFont(font);
        FontMetrics fm = g.getFontMetrics();
        for (E e : items)
        {
            String s = e.toString();
            int w = fm.charsWidth(s.toCharArray(), 0, s.length());
            if (w > width)
                width = w;
        }
        g.dispose();
        
        width += 4;
        
        GreenfootImage pic = new GreenfootImage(width + 1, height + 1);
        pic.setFont(font);
        
        pic.setColor(Color.WHITE);
        pic.fill();
        pic.setColor(Color.BLACK);
        pic.drawRect(0, 0, width, 12);
        if (selecting)
            pic.setColor(Color.GRAY);
        if (index > -1 && index < items.size())
            pic.drawString(items.get(index).toString(), 2, 11);
        
        if (selecting)
            for (int i = 0; i < items.size(); i++)
            {
                if (mouseOverThis() && offsetMouse.getY() > 12 * (i + 1) && offsetMouse.getY() <= 12 * (i + 2))
                {
                    if (clicked)
                    {
                        setIndex(i);
                        toggleSelecting();
                        act();
                        return;
                    }
                    pic.setColor(Color.CYAN);
                    pic.fillRect(0, 12 * (i + 1), width, 12);
                }
                pic.setColor(Color.BLACK);
                pic.drawRect(0, 12 * (i + 1), width, 12);
                pic.drawString(items.get(i).toString(), 2, (i + 1) * 12 + 11);
            }
        
        setImage(pic);
    }
    private void toggleSelecting()
    {
        selecting = !selecting;
        if (selecting)
        {
            int x = getX();
            int y = getY();
            World w = getWorld();
            removeFromWorld();
            w.addObject(this, x, y - 6 + ((items.size() + 1) * 12) / 2);
//             super.setLocation(getX(), getY() - 6 + ((items.size() + 1) * 12) / 2);
        }
        else
            super.setLocation(getX(), getY() - getImage().getHeight() / 2 + 6);
    }
    
    /**
     * @return String for the item that is selected. Null if none selected.
     */
    public E getSelected()
    {
        if (index == -1)
            return null;
        return items.get(index);
    }
    
    /**
     * @return The index of the item that is selected. -1 if none selected.
     */
    public int getIndex()
    {
        return index;
    }
    
    /**
     * Set the selected item from its list.
     * @param i The index from list to be selected item.
     */
    public void setIndex(int i)
    {
        if (index != i)
        {
            changed = true;
            index = i;
        }
    }
    
    /**
     * @return The contents in this list.
     */
    public ArrayList<E> getList()
    {
        return items;
    }
    
    /**
     * The action listener for this DropDownList.
     * @return Whether a new item has been selected.
     */
    public boolean hasChanged()
    {
        boolean c = changed;
        changed = false;
        return c;
    }
    
    /**
     * When considered in Container cells, treat height always like when not expanded.
     */
    public int getGUIHeight()
    {
        return 13;
    }
}