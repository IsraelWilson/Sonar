import greenfoot.Greenfoot;
import java.awt.Point;

/**
 * ConfirmWindow
 * <p>
 * A Window containing a confirm and cancel Button.<p>
 * When one of these is clicked, the ConfirmWindow closes.<p>
 * If the confirm Button had been clicked, the action listener method isConfirmed() will return true.<p>
 * <p>
 * Action listener: isConfirmed()
 * 
 * @author Taylor Born
 * @version February 2013 - April 2013
 */
public class ConfirmWindow extends Window
{
    private Button confirmBtn = new Button("Confirm", new Point(50, 23));
    private Button cancelBtn = new Button("Cancel", new Point(50, 23));
    private boolean confirmed;

    /**
     * New ConfirmWindow with the given prompt as its title.
     * @param prompt What title is to be displayed for this Window.
     */
    public ConfirmWindow(String prompt)
    {
        super(prompt, 100, 40, true, true);
        confirmBtn.setAcceptByEnterKey(true);
        Container c = new Container(new Point(2, 1));
        c.addComponent(confirmBtn);
        c.addComponent(cancelBtn);
        addContainer(c);
    }
    
    /**
     * Act.<p>
     * Listen for when the confirm and cancel Buttons are clicked, which case the ConfirmWindow will close.<p>
     * If the confirm Button was clicked, the action listener method isConfirmed() will return true.
     */
    public void act()
    {
        super.act();
        if (confirmBtn.wasClicked() || Greenfoot.isKeyDown("enter"))
        {
            confirmed = true;
            toggleShow();
        }
        if (cancelBtn.wasClicked())
            toggleShow();
    }
    
//     public void setTitle(String t)
//     {
//         resizeWidthForTitle(t, 175);
//     }
    public void toggleShow(String t)
    {
        setTitle(t);
        toggleShow();
    }
    
    /**
     * Action listener for this ConfirmWindow.
     * @return Whether or not the confirm Button had been pressed.
     */
    public boolean isConfirmed()
    {
        boolean c = confirmed;
        confirmed = false;
        return c;
    }
    
    /**
     * Reset confirmation.
     */
    protected void initializeOpen()
    {
        super.initializeOpen();
        confirmed = false;
    }
}