package catclicker;

/**
 * @author Miguel López
 */
public class Main {

    public Main(){
        createGUI();
    }
    
    private void createGUI(){
        MyFrame v = new MyFrame("");
        v.setContentPane(new MainPanel());
        v.setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main();
    }
}
