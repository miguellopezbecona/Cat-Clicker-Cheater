package catclicker;

import java.awt.Rectangle;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * 
 * @author Miguel López
 */
public class MainPanel extends javax.swing.JPanel {
    private Rectangle reloadRect;
    private Rectangle flashRect;
    private Thread t;
    public static String currentDate;
    
    private static String getCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
        return dateFormat.format(new Date());
    }
    
    
    public MainPanel() {
        reloadRect = new Rectangle(-1, -1);
        flashRect = new Rectangle(-1, -1);
        
        initComponents();
        currentDate = getCurrentDate();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exitButton = new javax.swing.JButton();
        captureReloadButton = new javax.swing.JButton();
        captureReloadLabel = new javax.swing.JLabel();
        captureFlashFrameButton = new javax.swing.JButton();
        captureFlashLabel = new javax.swing.JLabel();
        durationLabel = new javax.swing.JLabel();
        durationField = new javax.swing.JTextField();
        goButton = new javax.swing.JButton();

        exitButton.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        captureReloadButton.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        captureReloadButton.setText("Capture reload");
        captureReloadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                captureReloadButtonActionPerformed(evt);
            }
        });

        captureReloadLabel.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        captureReloadLabel.setText("Not set");

        captureFlashFrameButton.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        captureFlashFrameButton.setText("Capture flash frame");
        captureFlashFrameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                captureFlashFrameButtonActionPerformed(evt);
            }
        });

        captureFlashLabel.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        captureFlashLabel.setText("Not set");

        durationLabel.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        durationLabel.setText("Iterations:");

        goButton.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        goButton.setText("Go!");
        goButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(goButton)
                .addGap(18, 18, 18)
                .addComponent(exitButton)
                .addGap(45, 45, 45))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(captureFlashFrameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(captureReloadButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(durationLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(captureReloadLabel)
                    .addComponent(captureFlashLabel)
                    .addComponent(durationField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(captureReloadButton)
                    .addComponent(captureReloadLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(captureFlashFrameButton)
                    .addComponent(captureFlashLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(durationLabel)
                    .addComponent(durationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitButton)
                    .addComponent(goButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        //if(!goButton.isEnabled())
          //  Cheater.changeTime(currentDate);
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void captureReloadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_captureReloadButtonActionPerformed
        new RectCapturer(reloadRect, captureReloadLabel);
    }//GEN-LAST:event_captureReloadButtonActionPerformed

    private void captureFlashFrameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_captureFlashFrameButtonActionPerformed
        new RectCapturer(flashRect, captureFlashLabel);
    }//GEN-LAST:event_captureFlashFrameButtonActionPerformed

    private void goButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goButtonActionPerformed
        int iterations = 0;
        
        try {
            iterations = Integer.valueOf(durationField.getText());
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Bad input in number of iterations.",
                "Error", JOptionPane.ERROR_MESSAGE);
            return; 
        }
        
        if(reloadRect.getX() == -1){
            JOptionPane.showMessageDialog(this, "Reload rectangle not set.",
                "Error", JOptionPane.ERROR_MESSAGE);
            return; 
        }
        if(flashRect.getX() == -1){
            JOptionPane.showMessageDialog(this, "Flash rectangle not set.",
                "Error", JOptionPane.ERROR_MESSAGE);
            return; 
        }
        
        t = new Cheater(iterations, reloadRect, flashRect);
        t.start();
    }//GEN-LAST:event_goButtonActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton captureFlashFrameButton;
    private javax.swing.JLabel captureFlashLabel;
    private javax.swing.JButton captureReloadButton;
    private javax.swing.JLabel captureReloadLabel;
    private javax.swing.JTextField durationField;
    private javax.swing.JLabel durationLabel;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton goButton;
    // End of variables declaration//GEN-END:variables

}