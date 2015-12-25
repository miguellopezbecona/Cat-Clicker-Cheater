package catclicker;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Miguel López
 */
public class Action extends Thread {
    private static final String INIT_YEAR = "80";
    private static final String FINAL_YEAR = "79";
    private static Robot bot;
    private static Random rand;
        
    public static void changeTime(String date){
        // Only works for Windows
        try {
            Runtime.getRuntime().exec("cmd /C date " + date); // dd-MM-yy
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private static void simulateClick(int x, int y){
        bot.mouseMove(x, y);
        bot.mousePress(InputEvent.BUTTON1_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_MASK);
    }
    
    private static void simulateClicks(){
        simulateClick(683, 430); // Init
        simulateClick(811, 333); // X
        simulateClick(775, 280); // Doge
        simulateClick(775, 315); // SWAG
        simulateClick(775, 350); // Smoke Weed
        simulateClick(570, 390); // Doritos
        simulateClick(570, 355); // Wow
        
        simulateClick(775, 385); // Gaben
        simulateClick(375, 660); // Upgrades
        /*simulateClick(375, 630);
        simulateClick(375, 600);
        simulateClick(375, 570);
        simulateClick(375, 540);
        simulateClick(375, 510);
        */
        
        simulateClick(765, 157); // Save
        simulateClick(873, 70); // Reload
        
        simulateClick(765, 750); // Close to Windows app bar
    }
    
    private static int getRand(){
        return rand.nextInt(2) + 1;
    }
    
    private void initializations(){
        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //midX = (int) screenSize.getWidth() / 2
        //midY = (int) screenSize.getHeight() / 2;
        
        rand = new Random();
        try {
            bot = new Robot();
        } catch (AWTException ex) {
            ex.printStackTrace();
            System.exit(-1);
        }
    }
    
    @Override
    public void run(){
        initializations();
        
        while(true) {
            changeTime("01-01-" + INIT_YEAR);
            simulateClicks();
            try {
                Thread.sleep(1200);
            } catch (InterruptedException ex) { }
            
            changeTime("01-01-" + FINAL_YEAR);
            simulateClicks();
            try {
                Thread.sleep(1200);
            } catch (InterruptedException ex) { }
        }
    }
}
