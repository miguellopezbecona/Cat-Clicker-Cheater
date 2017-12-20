package catclicker;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

// Getting a Rectangle of interest on the screen
public class RectCapturer extends JFrame {
    private Rectangle captureRect; // Current captured rectangle
    private final BufferedImage screen;
    
    private Rectangle reference; // Object from other JPanel to be setted
    private JLabel labelReference; // Object from other JPanel to be setted
    
    public RectCapturer(Rectangle r, JLabel l) {
        reference = r;
        labelReference = l;
        
        // Disposed on close, without affecting main frame
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        // For getting mouse location
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException ex) {
            ex.printStackTrace();
        }
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screen = robot.createScreenCapture(new Rectangle(screenSize));
        
        // Adjusts frame size
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, (int)(screen.getWidth()), Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, (int)(screen.getHeight())-100, Short.MAX_VALUE)
        );
        
        // Inserts buffered image as an icon
        final JLabel screenLabel = new JLabel(new ImageIcon(screen));
        
        // Adds a screen scroll
        JScrollPane screenScroll = new JScrollPane(screenLabel);

        // Creates JPanel with center layout
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(screenScroll, BorderLayout.CENTER);

        final JLabel selectionLabel = new JLabel("Please, drag the desired rectangle in the screen shot.");
        panel.add(selectionLabel, BorderLayout.NORTH);

        repaint(screen, screen); // Paints initial screen
        screenLabel.repaint();

        // Edits stuff when clicking or dragging the cursor
        screenLabel.addMouseMotionListener(new MouseMotionAdapter() {
            Point start = new Point();

            @Override
            public void mouseMoved(MouseEvent me) {
                start = me.getPoint();
                repaint(screen, screen);
                selectionLabel.setText("Start Point: " + start);
                screenLabel.repaint();
            }

            @Override
            public void mouseDragged(MouseEvent me) {
                Point end = me.getPoint();
                captureRect = new Rectangle(start,
                        new Dimension(end.x-start.x, end.y-start.y));
                repaint(screen, screen);
                screenLabel.repaint();
                selectionLabel.setText("Rectangle: " + captureRect);
                
                confirmButton.setEnabled(true);
            }
        });
        
        // Creates button to confirm capture
        confirmButton = new javax.swing.JButton();
        confirmButton.setText("Confirm");
        confirmButton.setEnabled(false);
        //confirmButton.setVisible(false);

        // Action for button and hotkey
        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmButtonActionPerformed(e);
            }
        };
        action.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, 0));
        //confirmButton.addActionListener(action);

        // manually register the accelerator in the button's component input map
        confirmButton.getActionMap().put("pressed", action);
        confirmButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put((KeyStroke) action.getValue(Action.ACCELERATOR_KEY), "pressed");
        
        // Adds button to panel
        panel.add(confirmButton, BorderLayout.SOUTH);
        
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {
                int keyCode = event.getKeyCode(); // Obtiene el código de la tecla pulsada  

                switch(keyCode){
	            case KeyEvent.VK_ENTER:
                        confirmButtonActionPerformed(null);
                    break;
                }
            }
        });
        
        pack();
        setContentPane(panel);
        setVisible(true);
    }


    public void repaint(BufferedImage orig, BufferedImage copy) {
        Graphics2D g = copy.createGraphics();
        g.drawImage(orig,0,0, null);
        if (captureRect!=null) {
            g.setColor(Color.RED);
            g.draw(captureRect);
            g.setColor(new Color(255,255,255,150));
            g.fill(captureRect);
        }
        g.dispose();
    }
    
    
    private javax.swing.JButton confirmButton;
    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        //System.out.println("Rectangle of interest: " + captureRect);
        //System.out.println(captureRect.getCenterX() + " " + captureRect.getCenterY());
        
        reference.setBounds(captureRect); //reference = captureRect
        labelReference.setText("Set!");
        
        setVisible(false);
        dispose(); // Bye bye
    }                                              
    
}