package catclicker;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miguel López
 */
public class Cheater extends Thread {
    private static final String INIT_YEAR = "80";
    private static final String FINAL_YEAR = "79";
    private Robot bot;
    
    private final int numIterations;
    private final Point reloadPoint;
    private final List<Point> flashPoints;
    
    public Cheater(int i, Rectangle r, Rectangle f){
        numIterations = i;
        reloadPoint = new Point((int) r.getCenterX(), (int) r.getCenterY());
        flashPoints = new ArrayList<>();
        
        try {
            bot = new Robot();
        } catch (AWTException ex) {
            ex.printStackTrace();
            System.exit(-1);
        }
        
        /*** Calculates points from observations over the flash layout ***/
        
        // Flash initial button: center of flash
        flashPoints.add(new Point((int) f.getCenterX(), (int) f.getCenterY()));
        
        // References
        int[] offset = new int[2];
        offset[0] = (int) f.getX();
        offset[1] = (int) f.getY();
        
        int[] flashFrame = new int[2];
        flashFrame[0] = (int) f.getWidth();
        flashFrame[1] = (int) f.getHeight();
        
        Point p;
        
        // "x" to close welcome message        
        p = getPointFromReferences(650, 250, offset, flashFrame);
        flashPoints.add(p);
        
        // John Cena upgrade
        p = getPointFromReferences(150, 625, offset, flashFrame);
        flashPoints.add(p);
        
        // Doritos upgrade
        p = getPointFromReferences(150, 325, offset, flashFrame);
        flashPoints.add(p);
        
        // Uses doge
        p = getPointFromReferences(605, 180, offset, flashFrame);
        flashPoints.add(p);
        
        // Uses SWAG
        p = getPointFromReferences(370, 275, offset, flashFrame);
        flashPoints.add(p);
        
        // Uses doritos
        p = getPointFromReferences(370, 305, offset, flashFrame);
        flashPoints.add(p);
        
        // Uses wow
        p = getPointFromReferences(605, 265, offset, flashFrame);
        flashPoints.add(p);
        
        // Saves
        p = getPointFromReferences(590, 43, offset, flashFrame);
        flashPoints.add(p);
    }
    
    private Point getPointFromReferences(int xRef, int yRef, int[] offset, int[] frame){
        final int MAX_X_REF = 1000; // Reference is a 1000x700 image
        final int MAX_Y_REF = 700;
        
        int x = offset[0] + (frame[0]*xRef / MAX_X_REF);
        int y = offset[1] + (frame[1]*yRef / MAX_Y_REF);
        return new Point(x, y);
    }
    
    public static void changeTime(String date){
        // This only works for Windows
        try {
            Runtime.getRuntime().exec("cmd /C date " + date); // dd-MM-yy
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    // Just for avoiding writing too many lines for sleeping
    public static void oneLinerSleep(int milisecs){
        try {
            Thread.sleep(milisecs); // Sleep after welcome click
        } catch (InterruptedException ex) {
        }
    }
    
    private void simulateClick(int x, int y){
        bot.mouseMove(x, y);
        bot.mousePress(InputEvent.BUTTON1_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_MASK);
    }
    
    private void simulateClick(Point p){
        simulateClick((int) p.getX(), (int) p.getY());
    }
    
    // Clicks in all points
    private void simulateClicks(){
        simulateClick(flashPoints.get(0));
        oneLinerSleep(300);
                 
        //for(Point p : flashPoints){
        for(int i=1;i<flashPoints.size();i++){
            Point p = flashPoints.get(i);
            simulateClick(p);
            oneLinerSleep(100);
        }
        simulateClick(reloadPoint);
    }
        
    @Override
    public void run(){
        for(int i=0;i<numIterations;i++) {
            changeTime("01-01-" + INIT_YEAR);
            simulateClicks();
            oneLinerSleep(1500);
            
            changeTime("31-12-" + FINAL_YEAR);
            simulateClicks();
            oneLinerSleep(1500);
        }
        
        Cheater.changeTime(MainPanel.currentDate);
    }
}
