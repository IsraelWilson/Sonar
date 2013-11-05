import greenfoot.GreenfootImage;
import java.util.HashMap;

public final class BitFont
{
    private static HashMap<Character, GreenfootImage> map = new HashMap<Character, GreenfootImage>();
    static {
        map.put('0', new GreenfootImage("-BitFont/0.png"));
        map.put('1', new GreenfootImage("-BitFont/1.png"));
        map.put('2', new GreenfootImage("-BitFont/2.png"));
        map.put('3', new GreenfootImage("-BitFont/3.png"));
        map.put('4', new GreenfootImage("-BitFont/4.png"));
        map.put('5', new GreenfootImage("-BitFont/5.png"));
        map.put('6', new GreenfootImage("-BitFont/6.png"));
        map.put('7', new GreenfootImage("-BitFont/7.png"));
        map.put('8', new GreenfootImage("-BitFont/8.png"));
        map.put('9', new GreenfootImage("-BitFont/9.png"));
        map.put('A', new GreenfootImage("-BitFont/A.png"));
        map.put('B', new GreenfootImage("-BitFont/B.png"));
        map.put('C', new GreenfootImage("-BitFont/C.png"));
        map.put('D', new GreenfootImage("-BitFont/D.png"));
        map.put('E', new GreenfootImage("-BitFont/E.png"));
        map.put('F', new GreenfootImage("-BitFont/F.png"));
        map.put('G', new GreenfootImage("-BitFont/G.png"));
        map.put('H', new GreenfootImage("-BitFont/H.png"));
        map.put('I', new GreenfootImage("-BitFont/I.png"));
        map.put('J', new GreenfootImage("-BitFont/J.png"));
        map.put('K', new GreenfootImage("-BitFont/K.png"));
        map.put('L', new GreenfootImage("-BitFont/L.png"));
        map.put('M', new GreenfootImage("-BitFont/M.png"));
        map.put('N', new GreenfootImage("-BitFont/N.png"));
        map.put('O', new GreenfootImage("-BitFont/O.png"));
        map.put('P', new GreenfootImage("-BitFont/P.png"));
        map.put('Q', new GreenfootImage("-BitFont/Q.png"));
        map.put('R', new GreenfootImage("-BitFont/R.png"));
        map.put('S', new GreenfootImage("-BitFont/S.png"));
        map.put('T', new GreenfootImage("-BitFont/T.png"));
        map.put('U', new GreenfootImage("-BitFont/U.png"));
        map.put('V', new GreenfootImage("-BitFont/V.png"));
        map.put('W', new GreenfootImage("-BitFont/W.png"));
        map.put('X', new GreenfootImage("-BitFont/X.png"));
        map.put('Y', new GreenfootImage("-BitFont/Y.png"));
        map.put('Z', new GreenfootImage("-BitFont/Z.png"));
        map.put('-', new GreenfootImage("-BitFont/-.png"));
        map.put(':', new GreenfootImage("-BitFont/(0).png"));
        map.put('.', new GreenfootImage("-BitFont/(01).png"));
        for(GreenfootImage img: map.values()) img.scale(img.getWidth()* 1, img.getHeight()* 1);
    }
    
    private BitFont() {
    }
    
    public static GreenfootImage getImage(char str) {
        return map.get(str);
    }
    
    public static void drawStringOn(GreenfootImage img, String str, int x, int y) {
        for(char c: str.toCharArray()) {
            if(c !=' ') {
                GreenfootImage i = getImage(c);
                img.drawImage(i, x, y);
                x += i.getWidth();
            }
            else x += 8;
        }
    }
}