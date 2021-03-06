import greenfoot.World;


public abstract class Window extends GUI
{
    public static final int BEGINNING = 0, CENTER = 1, END = 2;

    private int justifyHorizontal = CENTER, justifyVertical = CENTER;

    /**
     * Called within Container to set this WindowComponent's location within World to be within a cell of grid/table structure.<p>
     * @param leftSide The x-coordinate of the left side of the cell assigned to.
     * @param xRange The width in pixels of the cell assigned to.
     * @param topSide The y-coordinate of the top side of the cell assigned to.
     * @param yRange The height in pixels of the cell assigned to.
     * @see addToWorldInContainerCell(World, int, int, int, int)
     */
    public void setLocationInContainerCell(int leftSide, int xRange, int topSide, int yRange)
    {
        setLocation(leftSide + getJustifyX(xRange), topSide + getJustifyY(yRange));
    }
    
    /**
     * Called within Container to add this WindowComponent to the World within a cell of grid/table structure.<p>
     * @param leftSide The x-coordinate of the left side of the cell assigned to.
     * @param xRange The width in pixels of the cell assigned to.
     * @param topSide The y-coordinate of the top side of the cell assigned to.
     * @param yRange The height in pixels of the cell assigned to.
     * @see setLocationInContainerCell(World, int, int, int, int)
     */
    public void addToWorldInContainerCell(World world, int leftSide, int xRange, int topSide, int yRange)
    {
        world.addObject(this, leftSide + getJustifyX(xRange), topSide + getJustifyY(yRange));
    }
    
    private int getJustifyX(int range)
    {
        switch (justifyHorizontal)
        {
            case BEGINNING: return getGUIWidth() / 2;
            case END:       return range - getGUIWidth() / 2;
            default:        return range / 2;
        }
    }
    private int getJustifyY(int yRange)
    {
        switch (justifyVertical)
        {
            case BEGINNING: return getGUIHeight() / 2;
            case END:       return yRange - getGUIHeight() / 2;
            default:        return yRange / 2;
        }
    }
    
    public void justifyHorizontally(int j)
    {
        justifyHorizontal = j;
    }
    public void justifyVertically(int j)
    {
        justifyVertical = j;
    }
}