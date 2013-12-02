import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer extends Actor
{
    private static int time;
    private static int waveNum;
    /**
     * Act - do whatever the Timer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Timer(){
        time = 100;
        waveNum = 0;
    }
    
    public void act() 
    {
        // Add your action code here.
        SonarWorld sw = (SonarWorld)getWorld();
        
        
        if( time % 30 == 0 && time > 0 ){
            sw.addObject( new SoundWave( 1, waveNum ), sw.getLSquare() + 75, 200 );
            waveNum++;
        }
        
        time--;
        
    }
    
    public int getTime(){        
        return time;
    }
    
    public void setTime( int num ){
        time = num;
    }
    
    public int getWaveNum(){
        return waveNum;
    }
    
    public void setWaveNum( int num ){
        waveNum = num;
    }
    
}
