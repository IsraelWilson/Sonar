import java.awt.Point;

/**
 * MessageWindow
 * 
 * @author Taylor Born
 * @version March 2013
 */
public class MessageWindow extends Window
{
    private Button okayBtn = new Button("Okay", new Point(50, 23));

    public MessageWindow(String message)
    {
        super(message, 50, 40, true, false);
        okayBtn.setAcceptByEnterKey(true);
        
        Container c = new Container(new Point(1, 1));
        c.addComponent(okayBtn);
        addContainer(c);
    }
    
    public void act()
    {
        super.act();
        if (okayBtn.wasClicked())
            toggleShow();
    }
}