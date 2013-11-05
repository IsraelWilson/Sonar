import greenfoot.Greenfoot;
import greenfoot.MouseInfo;
import greenfoot.GreenfootImage;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Point;

/**
 * ListBox
 * <p>
 * Collection of Objects that is displayed in a list of rows. Acts very much like an ArrayList.<p>
 * The collection's contents are shown via the Object's toString() method.<p>
 * Scrollable when list is longer than height.<p>
 * Implements single and multi selecting.<p>
 * When has focus, can use "up" and "down" arrow keys to move selection index (when selection count equals 1) up and down through the list.<p>
 * <p>
 * Action listener: hasChanged()
 * 
 * @author Taylor Born
 * @version February 2011 - April 2013
 */
public class ListBox<E>  extends WindowComponent
{
    // Size of this ListBox.
    private Point size;
    
    // Height of scrollBar.
    private int scrollBar = 40;
    
    // Y position of where mouse pressed on scrollBar, used as reference for when dragged.
    private int mouseY;
    
    private int textHeight = 14;
    private ArrayList<E> objs = new ArrayList<E>();
    private ScrollingListener scroller = initializeScroller();
    private int scroll;
    private ArrayList<Integer> index = new ArrayList<Integer>();
    private boolean allowMultipleSelect = false;
    private boolean dragging;
    private Point lastMouse = new Point(-25, -25);
    private boolean changed;
    private Color backColor = Color.WHITE;
    private Color textColor = Color.BLACK;
    private Color hoverColor = new Color(185, 211, 225);
    private Color selectColor = Color.YELLOW;
    private Color scrollColor = Color.RED;

    /**
     * Create a new ListBox.
     * @param size The width and height of the ListBox.
     * @param objs The list of Objects to display in the ListBox.
     */
    public ListBox(Point size, ArrayList<E> objs)
    {
        this.size = size;
        this.objs = objs;
        draw();
    }
    
    /**
     * Update the ListBox's image.
     */
    private void draw()
    {
        GreenfootImage pic = new GreenfootImage((int)size.getX(), (int)size.getY());
        pic.setColor(backColor);
        pic.fill();
        
        // Draw items.
        for (int i = scroll / textHeight; i < objs.size() && i - scroll / textHeight < size.getY() / textHeight + 1; i++)
        {
            // If selected.
            if (index.contains(i))
            {
                pic.setColor(selectColor);
                pic.fillRect(0, textHeight * i - scroll, (int)size.getX() - 10, textHeight);
            }
            // If hovered over.
            else if (mouseOverThis() && !dragging && lastMouse.getX() < getX() + size.getX() / 2 - 10 && lastMouse.getY() > getY() - size.getY() / 2 + textHeight * i - scroll && lastMouse.getY() <= getY() - size.getY() / 2 + textHeight * i - scroll + textHeight)
            {
                pic.setColor(hoverColor);
                pic.fillRect(0, textHeight * i - scroll, (int)size.getX() - 10, textHeight);
            }
            pic.setColor(textColor);
            pic.drawRect(0, textHeight * i - scroll, (int)size.getX() - 10, textHeight);
            pic.drawString(objs.get(i).toString(), 4, textHeight * i - scroll + textHeight - 2);
        }
        
        // Scroll bar.
        int n = scroller.getScroll();
        if (objs.size() > size.getY() / textHeight)
        {
            if (mouseOverThis() && getWorld() != null)
            {
                scroll += n;
                if (scroll < 0)
                    scroll = 0;
                else if (scroll + size.getY() > objs.size() * textHeight)
                    scroll = objs.size() * textHeight - (int)size.getY();
            }
            pic.setColor(scrollColor);
            pic.fillRect((int)size.getX() - 9, (int)(scroll / (double)(objs.size() * textHeight - size.getY()) * (size.getY() - scrollBar)), 9, scrollBar);
        }
        
        pic.setColor(textColor);
        pic.drawRect(0, 0, (int)size.getX() - 1, (int)size.getY() - 1);
        setImage(pic);
    }
    
    /**
     * Act.
     */
    public void act()
    {
        super.act();
        
        if (index.size() == 1 && hasFocus())
        {
            String s = Greenfoot.getKey();
            if (s != null)
            {
                if (s.equals("up") && index.get(0) > 0)
                {
                    int i = index.get(0);
                    deselect();
                    setIndex(i - 1);
                }
                if (s.equals("down") && index.get(0) < objs.size() - 1)
                {
                    int i = index.get(0);
                    deselect();
                    setIndex(i + 1);
                }
            }
        }
        
        int topOfScrollBar = (int)(scroll / (double)(objs.size() * textHeight - size.getY()) * (size.getY() - scrollBar));
        
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (objs.size() > size.getY() / textHeight && Greenfoot.mousePressed(this) && mouse.getX() - (getX() - size.getX() / 2) > size.getX() - 10 && mouse.getX() - (getX() - size.getX() / 2) < size.getX() && mouse.getY() - (getY() - size.getY() / 2) > topOfScrollBar && mouse.getY() - (getY() - size.getY() / 2) < topOfScrollBar + scrollBar)
        {
            dragging = true;
            mouseY = (mouse.getY() - (getY() - (int)size.getY() / 2)) - topOfScrollBar;
        }
        if (Greenfoot.mouseClicked(null) || Greenfoot.mouseDragEnded(null))
            dragging = false;
        if (dragging && Greenfoot.mouseDragged(null))
        {
            topOfScrollBar = (mouse.getY() - (getY() - (int)size.getY() / 2)) - mouseY;
            if (topOfScrollBar < 0)
                topOfScrollBar = 0;
            else if (mouse.getY() - (getY() - (int)size.getY() / 2) + (scrollBar - mouseY) > size.getY())
                topOfScrollBar = (int)size.getY() - scrollBar;
            scroll = (int)(topOfScrollBar / (double)(size.getY() - scrollBar) * (objs.size() * textHeight - size.getY()));
        }
        
        if (Greenfoot.mouseDragged(null) || Greenfoot.mouseMoved(null))
            lastMouse = new Point(mouse.getX(), mouse.getY());
        
        if (Greenfoot.mousePressed(this) && mouse.getX() - (getX() - size.getX() / 2) < size.getX() - 10)// && mouse.getX() - (getX() - size.getX() / 2) > 0 && mouse.getY() - (getY() - size.getY() / 2) > 0 && mouse.getY() - (getY() - size.getY() / 2) < size.getY())
        {
            for (int i = 0; i < objs.size(); i++)
                if (mouse.getY() - (getY() - size.getY() / 2) > textHeight * i - scroll && mouse.getY() - (getY() - size.getY() / 2) <= textHeight * i - scroll + textHeight)
                {
                    if (Greenfoot.isKeyDown("shift") && allowMultipleSelect)
                    {
                        if (index.contains(i))
                            index.remove(new Integer(i));
                        else
                            index.add(i);
                    }
                    else
                    {
                        index = new ArrayList<Integer>();
                        index.add(i);
                    }
                    setIndexInView(i);
                    changed = true;
                }
        }
        draw();
    }
    
    /**
     * Get the indexes of what is selected. Meant to be used when multiple selecting is enabled, otherwise getOneIndex() is more appropriate.
     * @return The indexes of what is selected.
     * @see getOneIndex()
     */
    public ArrayList<Integer> getIndexes()
    {
        return index;
    }
    
    /**
     * Get the index of what is selected. Meant to be used when multiple selecting is disabled, otherwise getIndexes() is more appropriate.
     * @return The index of what is selected. -1 if none selected.
     * @see getIndexes()
     */
    public int getOneIndex()
    {
        if (index.size() == 0)
            return -1;
        else
            return index.get(0);
    }
    
    /**
     * Deselect selection.
     */
    public void deselect()
    {
        index.clear();
    }
    
    /**
     * Action listener for when selection has been altered.
     * @return Whethor or not selection has been altered since last call.
     */
    public boolean hasChanged()
    {
        boolean c = changed;
        changed = false;
        return c;
    }
    
    /**
     * Set which item to be selected.
     * @param index The index of the item to be selected.
     * @see addIndex(int)
     */
    public void setIndex(int index)
    {
        if (this.index.size() != 1 || this.index.get(0) != index)
            changed = true;
        this.index.clear();
        if (index > -1 && index < objs.size())
        {
            this.index.add(index);
            setIndexInView(index);
        }
    }
    
    /**
     * Cause the Object at the given index to be selected. Meant to be used when multiple selecting is enabled.
     * @param index The index of the Object to be selected.
     * @see setIndex(int)
     */
    public void addIndex(int index)
    {
        if (allowMultipleSelect && index > -1 && index < objs.size())
            if (!this.index.contains(index))
            {
                this.index.add(index);
                setIndexInView(index);
            }
    }
    
    /**
     * Ajust scroll amount to set the Object determined by the given index, to be in view.
     * @param index Index for Object to be set to be in view.
     */
    private void setIndexInView(int index)
    {
        if (index > -1 && index < objs.size())
            if (index * textHeight < scroll)
                scroll = index * textHeight;
            else if ((index + 1) * textHeight > scroll + size.getY())
                scroll = (index + 1) * textHeight - (int)size.getY();
    }
    
    /**
     * Determine if there are any Objects selected.
     * @return Whether there are any Objects selected.
     */
    public boolean hasSelection()
    {
        return index.size() > 0;
    }
    
    /**
     * Toggle the Object at the given index to be selected or not be selected.
     * @param index The index of Object to toggle selection.
     */
    public void toggleSelect(int index)
    {
        if (index < 0 || index > objs.size() - 1)
            return;
        if (this.index.contains(index))
            this.index.remove(new Integer(index));
        else
        {
            this.index.add(index);
            setIndexInView(index);
        }
    }
    
    /**
     * Swap two Objects in position. If Objects are selected, they will remain selected after the swap.
     * @param indexA Index of Object to swap position.
     * @param indexB Index of Object to swap position.
     */
    public void swap(int indexA, int indexB)
    {
        if (indexA < 0 || indexA > objs.size() - 1 || indexB < 0 || indexB > objs.size() - 1)
            return;
        boolean a = index.contains(indexA);
        boolean b = index.contains(indexB);
        E s = objs.get(indexA);
        objs.set(indexA, objs.get(indexB));
        objs.set(indexB, s);
        index.remove(new Integer(indexA));
        index.remove(new Integer(indexB));
        if (a)
            index.add(indexB);
        if (b)
            index.add(indexA);
    }
    
    /**
     * Get the selected Object. Meant to be used when multiple selecting is disabled, otherwise getSelection() is more appropriate.
     * @return The selected Object. Null if none selected.
     * @see getSelection()
     */
    public E getOneSelection()
    {
        if (index.size() == 0)
            return null;
        return objs.get(index.get(0));
    }
    
    /**
     * Get all selected Object. Meant to be used when multiple selecting is enabled, otherwise getOneSelection() is more appropriate.
     * @return The selected Objects. Null if none selected.
     * @see getOneSelection()
     */
    public ArrayList<E> getSelection()
    {
        ArrayList<E> s = new ArrayList<E>();
        for (int i = 0; i < objs.size(); i++)
            if (index.contains(i))
                s.add(objs.get(i));
        return s;
    }
    
    /**
     * Get the Object in the ListBox at the given index.
     * @param index The index for what Object in the ListBox to get.
     * @return The Object at the index of the ListBox. Null if invalid index.
     */
    public E get(int index)
    {
        // Check to see if valid index
        if (index > -1 && index < objs.size())
            return objs.get(index);
        return null;
    }
    
    /**
     * Get the contents of the ListBox.
     * @return The contents of the ListBox.
     */
    public ArrayList<E> getList()
    {
        return objs;
    }
    
    /**
     * Determine whethor or not the given Object is contained within the list.
     * @param The Object in question.
     * @return Whethor or not the given Object is contained within the list.
     */
    public boolean contains(E s)
    {
        return objs.contains(s);
    }
    
    /**
     * Determine the index for where the given Object lies within the list.
     * @param The Object in question.
     * @return The index for where the given Object lies within the list.
     */
    public int indexOf(E s)
    {
        return objs.indexOf(s);
    }
    
    /**
     * Set the contents to the given list.
     * @param list New list of Objects.
     */
    public void setList(ArrayList<E> list)
    {
        deselect();
        objs = list;
        scroll = 0;
    }
    
    /**
     * Add an Object to the ListBox, making it selected and in view.
     * @param s The Object to be added.
     */
    public void add(E s)
    {
        changed = true;
        objs.add(s);
        index = new ArrayList<Integer>();
        index.add(objs.size() - 1);
        setIndexInView(objs.size() - 1);
    }
    
    /**
     * Insert an Object to the ListBox at the given position, making it selected and in view.
     * @param s The Object to be inserted.
     * @param index The position to insert String.
     */
    public void add(E s, int index)
    {
        changed = true;
        objs.add(index, s);
        this.index = new ArrayList<Integer>();
        this.index.add(index);
        setIndexInView(index);
    }
    
    /**
     * Remove what is selected.
     */
    public void removeSelected()
    {
        ArrayList<E> objsD = new ArrayList<E>();
        for (Integer i : index)
            objsD.add(objs.get(i));
        for (E s : objsD)
            objs.remove(s);
        index = new ArrayList<Integer>();
    }
    
    /**
     * Get the number of Objects in the ListBox's collection.
     * @return The number of Objects in the ListBox's collection.
     */
    public int size()
    {
        return objs.size();
    }
    
    /**
     * Remove everything from the ListBox.
     */
    public void clear()
    {
        objs.clear();
        index.clear();
    }
    
    /**
     * Change the Object at a given index.
     * @param index The index in the ListBox to change.
     * @param obj The Object to set to at the given index.
     */
    public void set(int index, E obj)
    {
        if (index < objs.size())
            objs.set(index, obj);
    }
    
    /**
     * Determine if the ListBox is set to allow multiple selecting of Objects.
     * @return If the ListBox is set to allow multiple selecting of Objects.
     */
    public boolean multipleSelectingIsEnabled()
    {
        return allowMultipleSelect;
    }
    
    /**
     * Change if the ListBox is set to allow multiple selecting of Objects.
     * @param enable If the ListBox will be set to allow multiple selecting of Objects.
     */
    public void setMultipleSelecting(boolean enable)
    {
        allowMultipleSelect = enable;
    }
    
    /**
     * 
     */
    public void setColorScheme(Color back, Color text, Color hover, Color select, Color scroll)
    {
        backColor = back;
        textColor = text;
        hoverColor = hover;
        selectColor = select;
        scrollColor = scroll;
        draw();
    }
}