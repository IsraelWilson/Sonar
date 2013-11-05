import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;
import java.util.Collections;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Color;
import java.awt.Point;

/**
 * GUI_DemoWorld
 * 
 * @author Taylor Born
 * @version November 2010 - March 2013
 */
public class GUI_DemoWorld extends World
{
    private Button btnClick;
    private SwitchButton btnAction;
    private ListBox<String> myList;
    private Label lblCounter;
    private Label lblWords;
    private SwitchButton btnEn;
    private TextBox txtB;
    
    private Menu myMenu;
    private DropDownList<String> mySelectList;
    private Slider mySlider;
    
    private Palette colors = new Palette();
    private FontWindow fonts = new FontWindow();
    private InputWindow inputW = new InputWindow("Enter some text:", 13);
    private ConfirmWindow confirmW = new ConfirmWindow("Are you sure?");
    private TextWindow textW = new TextWindow("Text Editor", 200, 150, "");
    private SelectionWindow<String> selectW = new SelectionWindow("Select something:", new ArrayList<String>(){{ add("Option A"); add("Option B"); add("Option C"); }}, 0);
    private MessageWindow messageW = new MessageWindow("This is an important message.");
    
    public GUI_DemoWorld()
    {
        super(600, 400, 1);
        
        setPaintOrder(GUI_Component.class);
        
        // Initialize Button with text "Click this" and with size 100 x 23
        btnClick = new Button("Click this", new Point(100, 23));
        // Add it to the world
        addObject(btnClick, 61, 32);
        
        // Create an ArrayList of Strings
        ArrayList<String> strs = new ArrayList<String>(){{add("Add Counter"); add("Add Word");}};
        // Initialize SwitchButton with ArrayList of Strings, with size 100 x 23, and text starting index of 1
        btnAction = new SwitchButton(strs, new Point(100, 23), 0);
        // Add it to the world
        addObject(btnAction, 192, 32);
        
        // Add a label
        addObject(new Label("To"), 126, 36);
        
        // Add a label
        addObject(new Label("A Listbox that holds a list of Strings."), 115, 185);
        addObject(new Label("Selectable and Scrollable"), 115, 198);
        
        // Create an ArrayList of Strings
        ArrayList<String> strs2 = new ArrayList<String>(){{add("Fruit"); add("Breads"); add("Meats"); add("Dairy"); add("Sweets"); add("Vegetables"); add("Nuts"); add("Cakes"); add("Pies"); add("Fast Food"); add("Peanut Butter"); add("Water"); add("Root Beer");}};
        
        // Initialize ListBox with size and ArrayList of String
        myList = new ListBox(new Point(130, 78), strs2);
        // Add it to the world
        addObject(myList, 115, 248);
        
        // Add a label
        addObject(new Label("(Click this button to change action of other button)"), 394, 36);
        
        // Add a label
        addObject(new Label("Label for my labels below:"), 100, 94);
        
        // Initialize Label with String
        lblCounter = new Label("0");
        // Add it to the world
        addObject(lblCounter, 100, 114);
        
        // Initialize Label with String
        lblWords = new Label("Random Words");
        // Add it to the world
        addObject(lblWords, 100, 134);
        
        btnEn = new SwitchButton(new ArrayList<String>(){{add("Enable Buttons"); add("Disable Buttons");}}, new Point(100, 23), 1);
        addObject(btnEn, 61, 61);
        
        addObject(new Label("A TextBox:"), 444, 185);
        addObject(new Label("Click on it to give it focus"), 444, 198);
        txtB = new TextBox(new Point(250, 100), "A TextBox that is word-wrapped, scrollable, typeable, sizeable, selectable, and can copy/cut/paste (ctrl+c, ctrl+x, ctrl+v). Must have focus in order to edit.\n\nYou can use the enter key to make new lines.\n\nClick somewhere to move the blinking cursor there. Can press the arrow keys to also move it.\n\nCan select text by:\n1. Click and drag.\n2. Shift + click.\n3. Shift + arrow keys.\n4. ctrl+a\n\nWorks with different Fonts and sizes. Try out the TextWindow from the menu in the top left corner that has access for changing text Color and the font family, size, and style.\n\nBelow you can use the DropDownList to change the size of this TextBox. The TextBox also auto scrolls while you type to stay with the blinking cursor.", new Font("Times-Roman", Font.PLAIN, 14));
        addObject(txtB, 444, 256);
        
        addObject(new Label("ListBoxes and TextBoxes offer methods that allow you to use & change what's in them"), 300, 390);
        
        setUpMenu();
        
        addObject(new Label("TextBox Size:"), 390, 334);
        mySelectList = new DropDownList(new ArrayList<String>(){{add("Large (250 X 100)"); add("Medium (140 X 75)"); add("Small (100 X 50)"); }}, 0);
        addObject(mySelectList, 492, 329);
        
        mySlider = new Slider(255, 0, 255, 0, 1);
        addObject(mySlider, 160, 330);
        
        TextBox tbPassword = new TextBox(new Point(100, 18), "");
        tbPassword.setMaxLength(12);
        tbPassword.setAsPassword(true);
        tbPassword.setMessage("Password");
        addObject(tbPassword, 530, 80);
        
        Greenfoot.start();
    }
    public void act()
    {
        listenToMenu(myMenu.getItemPressed());
        
        if (mySlider.hasChanged())
        {
            GreenfootImage p = new GreenfootImage(getWidth(), getHeight());
            p.setColor(Color.WHITE);
            p.fill();
            p.setColor(new Color(0, 255, 0, (int)mySlider.getValue()));
            p.fill();
            setBackground(p);
        }
        
        // Listen for if the Button is clicked
        if (btnClick.wasClicked())
        {
            // Do something
            
            // Add 1 to the number already in my lblCounter
            if (btnAction.getText().equals("Add Counter"))
                lblCounter.setText("" + (Integer.parseInt(lblCounter.getText()) + 1));
            else
            {
                // Check if label's String is long and should be reseted
                if (lblWords.getText().length() > 25)
                    lblWords.setText("");
                // Add a random word from the ListBox to the Label
                lblWords.setText(lblWords.getText() + " " + myList.get(Greenfoot.getRandomNumber(myList.size())));
            }
        }
        
        // Listen for if the SwitchButton is clicked
        if (btnAction.wasClicked())
        {
            // Do something
        }
        if (btnEn.wasClicked())
        {
            btnClick.setEnable(btnEn.getIndex() != 0);
            btnAction.setEnable(btnEn.getIndex() != 0);
        }
        
        if (mySelectList.hasChanged())
        {
            switch (mySelectList.getIndex())
            {
                case 0: txtB.setSize(new Point(250, 100)); break;
                case 1: txtB.setSize(new Point(140, 75)); break;
                case 2: txtB.setSize(new Point(100, 50));
            }
        }
    }
    
    public void setUpMenu()
    {
        ArrayList<String> menuStr = new ArrayList<String>(){{add("Window Examples"); add("Options"); }};
        myMenu = new Menu(menuStr, new Point(0, 0));
        myMenu.addItems("Window Examples/", new ArrayList<String>(){{ add("Palette"); add("ConfirmWindow"); add("InputWindow"); add("FontWindow"); add("TextWindow"); add("SelectionWindow"); add("MessageWindow"); }});
        
        myMenu.addItems("Options/", new ArrayList<String>(){{ add("ListBox"); add("Slider"); }});
        myMenu.addToggleItem("Options/ListBox/Multiple Selecting", false);
        myMenu.addItem("Options/Slider/Increment");
        myMenu.addItemsAsSet("Options/Slider/Increment/", new ArrayList<String>(){{add("1"); add("5"); add("15"); }}, 0);
        
        addObject(myMenu, 330, 78);
    }
    
    public void listenToMenu(String s)
    {
        if (s != null)
        {
            if (s.startsWith("Window Examples/"))
            {
                s = s.substring(s.indexOf("/") + 1);
                if (s.equals("Palette"))
                {
                    if (colors.inWorld())
                        colors.toggleShow();
                    colors.toggleShow();
                }
                else if (s.equals("ConfirmWindow"))
                {
                    if (confirmW.inWorld())
                        confirmW.toggleShow();
                    confirmW.toggleShow();
                }
                else if (s.equals("InputWindow"))
                {
                    if (inputW.inWorld())
                        inputW.toggleShow();
                    inputW.toggleShow();
                }
                else if (s.equals("FontWindow"))
                {
                    if (fonts.inWorld())
                        fonts.toggleShow();
                    fonts.toggleShow();
                }
                else if (s.equals("TextWindow"))
                {
                    if (textW.inWorld())
                        textW.toggleShow();
                    textW.toggleShow();
                }
                else if (s.equals("SelectionWindow"))
                {
                    if (selectW.inWorld())
                        selectW.toggleShow();
                    selectW.toggleShow();
                }
                else if (s.equals("MessageWindow"))
                {
                    if (messageW.inWorld())
                        messageW.toggleShow();
                    messageW.toggleShow();
                }
            }
            else if (s.startsWith("Options/"))
            {
                s = s.substring(s.indexOf("/") + 1);
                if (s.startsWith("Slider/"))
                {
                    s = s.substring(s.indexOf("/") + 1);
                    if (s.startsWith("Increment/"))
                    {
                        s = s.substring(s.indexOf("/") + 1);
                        mySlider.setIncrement(Integer.parseInt(s));
                        mySlider.setValue(mySlider.getValue() - (mySlider.getValue() % mySlider.getIncrement()));
                    }
                }
                else if (s.equals("ListBox/Multiple Selecting"))
                {
                    myList.setMultipleSelecting(!myList.multipleSelectingIsEnabled());
                }
            }
        }
    }
}