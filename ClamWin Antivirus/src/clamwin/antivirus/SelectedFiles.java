/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clamwin.antivirus;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class SelectedFiles extends javax.swing.JFrame {
    
    private BufferedImage closeImage = null;
    private BufferedImage minimizeImage = null;
    private BufferedImage driveImage = null;
    private File[] drives;

    /**
     * Creates new form SelectedFiles
     */
    public SelectedFiles() {
        initComponents();
        iconSet();
        getAndScaleCloseButtonImage();
        getAndScaleMinimizeButtonImage();
        getAndScaleDriveImage();
        cursorChange();
        drivers();
    }
    
    private void iconSet(){
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/mainIcon.png")));
    }
        
    //scaling the image according to the jlabel
    private void getAndScaleCloseButtonImage(){
        
        try {

            closeImage = ImageIO.read(this.getClass().getResource("/images/closeButton.png"));
            
	} catch (IOException e) {
            
            e.printStackTrace();
            
	}
        
	//buffered image scaled
	Image closeBtnDimensions = closeImage.getScaledInstance(lbl_btn_selectedFiles_close.getWidth(), lbl_btn_selectedFiles_close.getHeight(),Image.SCALE_SMOOTH);
	ImageIcon closeIcon = new ImageIcon(closeBtnDimensions);
				
	//icon set
	lbl_btn_selectedFiles_close.setIcon(closeIcon);
        
    }
    
    //scaling the image according to the jlabel
    private void getAndScaleMinimizeButtonImage(){
        
        try {

            minimizeImage = ImageIO.read(this.getClass().getResource("/images/minimize.png"));
            
	} catch (IOException e) {
            
            e.printStackTrace();
            
	}
        
	//buffered image scaled
	Image minimizeBtnDimensions = minimizeImage.getScaledInstance(lbl_btn_selectedFiles_minimize.getWidth(), lbl_btn_selectedFiles_minimize.getHeight(),Image.SCALE_SMOOTH);
	ImageIcon MinimizeIcon = new ImageIcon(minimizeBtnDimensions);
				
	//icon set
	lbl_btn_selectedFiles_minimize.setIcon(MinimizeIcon);
        
    }
    
    //scaling the image according to the jlabel
    private void getAndScaleDriveImage(){
        
        try {

            driveImage = ImageIO.read(this.getClass().getResource("/images/otherDrives.png"));
            
	} catch (IOException e) {
            
            e.printStackTrace();
            
	}
        
	//buffered image scaled
	Image driveDimensions = driveImage.getScaledInstance(40, 30,Image.SCALE_SMOOTH);
	ImageIcon driveIcon = new ImageIcon(driveDimensions);
				
	//icon set
	lblicon_selectedFiles_drive0.setIcon(driveIcon);
        lblicon_selectedFiles_drive1.setIcon(driveIcon);
        lblicon_selectedFiles_drive2.setIcon(driveIcon);
        lblicon_selectedFiles_drive3.setIcon(driveIcon);
        lblicon_selectedFiles_drive4.setIcon(driveIcon);
        lblicon_selectedFiles_drive5.setIcon(driveIcon);
        
    }
    
    //change cursor to hand
    private void cursorChange(){
        lbl_btn_selectedFiles_close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lbl_btn_selectedFiles_minimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
    
    //drives pane
    private void drivers(){
 
        panel_selectedFiles_drive0.setVisible(false);
        panel_selectedFiles_drive1.setVisible(false);
        panel_selectedFiles_drive2.setVisible(false);
        panel_selectedFiles_drive3.setVisible(false);
        panel_selectedFiles_drive4.setVisible(false);
        panel_selectedFiles_drive5.setVisible(false);
        
        drives = File.listRoots();
        
            if (drives.length > 0) {
                
                int i = 0;
                
                if(drives.length > 6){
                    
                    //success message
                    JOptionPane scanSuccessOptionPane = new JOptionPane("The maximum drives that are visible is 6, you can still scan an invisible drive by choosing from the file browser !", JOptionPane.INFORMATION_MESSAGE);

                    JDialog scanSuccessDialog = scanSuccessOptionPane.createDialog(null, "ClamWin Free Antivirus");
                    scanSuccessDialog.setModal(true);
                    scanSuccessDialog.setVisible(true);
                    
                }
                
                for (File drive : drives) {
                    
                    if(i==0){
                        
                        panel_selectedFiles_drive0.setVisible(true);
                        panel_selectedFiles_drive0.setToolTipText("Scan files in the " + drive.toString() + " drive");
                        lbl_selectedFiles_drive0.setText(drive.toString());
                        
                    }else if(i==1){
                        
                        panel_selectedFiles_drive1.setVisible(true);
                        panel_selectedFiles_drive1.setToolTipText("Scan files in the " + drive.toString() + " drive");
                        lbl_selectedFiles_drive1.setText(drive.toString());
                        
                    }else if(i==2){
                        
                        panel_selectedFiles_drive2.setVisible(true);
                        panel_selectedFiles_drive2.setToolTipText("Scan files in the " + drive.toString() + " drive");
                        lbl_selectedFiles_drive2.setText(drive.toString());
                        
                    }else if(i==3){
                        
                        panel_selectedFiles_drive3.setVisible(true);
                        panel_selectedFiles_drive3.setToolTipText("Scan files in the " + drive.toString() + " drive");
                        lbl_selectedFiles_drive3.setText(drive.toString());
                        
                    }else if(i==4){
                        
                        panel_selectedFiles_drive4.setVisible(true);
                        panel_selectedFiles_drive4.setToolTipText("Scan files in the " + drive.toString() + " drive");
                        lbl_selectedFiles_drive4.setText(drive.toString());
                        
                    }else if(i==5){
                        
                        panel_selectedFiles_drive5.setVisible(true);
                        panel_selectedFiles_drive5.setToolTipText("Scan files in the " + drive.toString() + " drive");
                        lbl_selectedFiles_drive5.setText(drive.toString());
                        
                    }

                    i++;
                    
                }
            }              
    }
    
        
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_selectedFiles_top = new javax.swing.JPanel();
        lbl_selectedFiles_titile = new javax.swing.JLabel();
        lbl_btn_selectedFiles_minimize = new javax.swing.JLabel();
        lbl_btn_selectedFiles_close = new javax.swing.JLabel();
        panel_selectedFiles_bottom_main = new javax.swing.JPanel();
        panel_selectedFiles_bottom_inside = new javax.swing.JPanel();
        panel_selectedFiles_inside_mid = new javax.swing.JPanel();
        panel_selectedFiles_drive5 = new javax.swing.JPanel();
        lbl_selectedFiles_drive5 = new javax.swing.JLabel();
        panel_selectedFiles_drive5_inside = new javax.swing.JPanel();
        lblicon_selectedFiles_drive5 = new javax.swing.JLabel();
        panel_selectedFiles_drive4 = new javax.swing.JPanel();
        lbl_selectedFiles_drive4 = new javax.swing.JLabel();
        panel_selectedFiles_drive4_inside = new javax.swing.JPanel();
        lblicon_selectedFiles_drive4 = new javax.swing.JLabel();
        panel_selectedFiles_drive3 = new javax.swing.JPanel();
        lbl_selectedFiles_drive3 = new javax.swing.JLabel();
        panel_selectedFiles_drive3_inside = new javax.swing.JPanel();
        lblicon_selectedFiles_drive3 = new javax.swing.JLabel();
        panel_selectedFiles_drive2 = new javax.swing.JPanel();
        lbl_selectedFiles_drive2 = new javax.swing.JLabel();
        panel_selectedFiles_drive2_inside = new javax.swing.JPanel();
        lblicon_selectedFiles_drive2 = new javax.swing.JLabel();
        panel_selectedFiles_drive1 = new javax.swing.JPanel();
        lbl_selectedFiles_drive1 = new javax.swing.JLabel();
        panel_selectedFiles_drive1_inside = new javax.swing.JPanel();
        lblicon_selectedFiles_drive1 = new javax.swing.JLabel();
        panel_selectedFiles_drive0 = new javax.swing.JPanel();
        panel_selectedFiles_drive0_inside = new javax.swing.JPanel();
        lblicon_selectedFiles_drive0 = new javax.swing.JLabel();
        lbl_selectedFiles_drive0 = new javax.swing.JLabel();
        btn_selectedFiles_scan = new java.awt.Button();
        btn_selectedFiles_back = new java.awt.Button();
        textField_selectedFiles = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_selectedFiles_top.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_selectedFiles_titile.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lbl_selectedFiles_titile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_selectedFiles_titile.setText("ClamWin Scan");
        lbl_selectedFiles_titile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panel_selectedFiles_top.add(lbl_selectedFiles_titile, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 670, 20));

        lbl_btn_selectedFiles_minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_btn_selectedFiles_minimizeMouseClicked(evt);
            }
        });
        panel_selectedFiles_top.add(lbl_btn_selectedFiles_minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 20, 10));

        lbl_btn_selectedFiles_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_btn_selectedFiles_closeMouseClicked(evt);
            }
        });
        panel_selectedFiles_top.add(lbl_btn_selectedFiles_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 20, 20));

        getContentPane().add(panel_selectedFiles_top, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 20));

        panel_selectedFiles_bottom_main.setBackground(new java.awt.Color(64, 55, 110));
        panel_selectedFiles_bottom_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_selectedFiles_bottom_inside.setBackground(new java.awt.Color(107, 91, 170));
        panel_selectedFiles_bottom_inside.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_selectedFiles_inside_mid.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_selectedFiles_drive5.setBackground(new java.awt.Color(0, 136, 65));
        panel_selectedFiles_drive5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_selectedFiles_drive5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_selectedFiles_drive5MouseClicked(evt);
            }
        });
        panel_selectedFiles_drive5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_selectedFiles_drive5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_selectedFiles_drive5.setForeground(new java.awt.Color(255, 255, 255));
        lbl_selectedFiles_drive5.setText("jLabel1");
        panel_selectedFiles_drive5.add(lbl_selectedFiles_drive5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 2, -1, 50));

        panel_selectedFiles_drive5_inside.setBackground(new java.awt.Color(0, 91, 50));
        panel_selectedFiles_drive5_inside.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblicon_selectedFiles_drive5.setText("jLabel1");
        panel_selectedFiles_drive5_inside.add(lblicon_selectedFiles_drive5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 30));

        panel_selectedFiles_drive5.add(panel_selectedFiles_drive5_inside, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 50));

        panel_selectedFiles_inside_mid.add(panel_selectedFiles_drive5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 320, 50));

        panel_selectedFiles_drive4.setBackground(new java.awt.Color(0, 136, 65));
        panel_selectedFiles_drive4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_selectedFiles_drive4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_selectedFiles_drive4MouseClicked(evt);
            }
        });
        panel_selectedFiles_drive4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_selectedFiles_drive4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_selectedFiles_drive4.setForeground(new java.awt.Color(255, 255, 255));
        lbl_selectedFiles_drive4.setText("jLabel1");
        panel_selectedFiles_drive4.add(lbl_selectedFiles_drive4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 2, -1, 50));

        panel_selectedFiles_drive4_inside.setBackground(new java.awt.Color(0, 91, 50));
        panel_selectedFiles_drive4_inside.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblicon_selectedFiles_drive4.setText("jLabel1");
        panel_selectedFiles_drive4_inside.add(lblicon_selectedFiles_drive4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 30));

        panel_selectedFiles_drive4.add(panel_selectedFiles_drive4_inside, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 50));

        panel_selectedFiles_inside_mid.add(panel_selectedFiles_drive4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 300, 50));

        panel_selectedFiles_drive3.setBackground(new java.awt.Color(0, 136, 65));
        panel_selectedFiles_drive3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_selectedFiles_drive3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_selectedFiles_drive3MouseClicked(evt);
            }
        });
        panel_selectedFiles_drive3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_selectedFiles_drive3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_selectedFiles_drive3.setForeground(new java.awt.Color(255, 255, 255));
        lbl_selectedFiles_drive3.setText("jLabel1");
        panel_selectedFiles_drive3.add(lbl_selectedFiles_drive3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 2, -1, 50));

        panel_selectedFiles_drive3_inside.setBackground(new java.awt.Color(0, 91, 50));
        panel_selectedFiles_drive3_inside.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblicon_selectedFiles_drive3.setText("jLabel1");
        panel_selectedFiles_drive3_inside.add(lblicon_selectedFiles_drive3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 30));

        panel_selectedFiles_drive3.add(panel_selectedFiles_drive3_inside, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 50));

        panel_selectedFiles_inside_mid.add(panel_selectedFiles_drive3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 320, 50));

        panel_selectedFiles_drive2.setBackground(new java.awt.Color(0, 136, 65));
        panel_selectedFiles_drive2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_selectedFiles_drive2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_selectedFiles_drive2MouseClicked(evt);
            }
        });
        panel_selectedFiles_drive2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_selectedFiles_drive2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_selectedFiles_drive2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_selectedFiles_drive2.setText("jLabel1");
        panel_selectedFiles_drive2.add(lbl_selectedFiles_drive2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 2, -1, 50));

        panel_selectedFiles_drive2_inside.setBackground(new java.awt.Color(0, 91, 50));
        panel_selectedFiles_drive2_inside.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblicon_selectedFiles_drive2.setText("jLabel1");
        panel_selectedFiles_drive2_inside.add(lblicon_selectedFiles_drive2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 30));

        panel_selectedFiles_drive2.add(panel_selectedFiles_drive2_inside, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 50));

        panel_selectedFiles_inside_mid.add(panel_selectedFiles_drive2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 300, 50));

        panel_selectedFiles_drive1.setBackground(new java.awt.Color(0, 136, 65));
        panel_selectedFiles_drive1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_selectedFiles_drive1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_selectedFiles_drive1MouseClicked(evt);
            }
        });
        panel_selectedFiles_drive1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_selectedFiles_drive1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_selectedFiles_drive1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_selectedFiles_drive1.setText("jLabel1");
        panel_selectedFiles_drive1.add(lbl_selectedFiles_drive1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 2, -1, 50));

        panel_selectedFiles_drive1_inside.setBackground(new java.awt.Color(0, 91, 50));
        panel_selectedFiles_drive1_inside.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblicon_selectedFiles_drive1.setText("jLabel1");
        panel_selectedFiles_drive1_inside.add(lblicon_selectedFiles_drive1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 30));

        panel_selectedFiles_drive1.add(panel_selectedFiles_drive1_inside, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 50));

        panel_selectedFiles_inside_mid.add(panel_selectedFiles_drive1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 320, 50));

        panel_selectedFiles_drive0.setBackground(new java.awt.Color(0, 136, 65));
        panel_selectedFiles_drive0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_selectedFiles_drive0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_selectedFiles_drive0MouseClicked(evt);
            }
        });
        panel_selectedFiles_drive0.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_selectedFiles_drive0_inside.setBackground(new java.awt.Color(0, 91, 50));
        panel_selectedFiles_drive0_inside.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblicon_selectedFiles_drive0.setText("jLabel1");
        panel_selectedFiles_drive0_inside.add(lblicon_selectedFiles_drive0, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 30));

        panel_selectedFiles_drive0.add(panel_selectedFiles_drive0_inside, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 50));

        lbl_selectedFiles_drive0.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_selectedFiles_drive0.setForeground(new java.awt.Color(255, 255, 255));
        lbl_selectedFiles_drive0.setText("jLabel1");
        panel_selectedFiles_drive0.add(lbl_selectedFiles_drive0, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 2, -1, 50));

        panel_selectedFiles_inside_mid.add(panel_selectedFiles_drive0, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 300, 50));

        panel_selectedFiles_bottom_inside.add(panel_selectedFiles_inside_mid, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 710, 270));

        btn_selectedFiles_scan.setBackground(new java.awt.Color(173, 159, 175));
        btn_selectedFiles_scan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_selectedFiles_scan.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_selectedFiles_scan.setForeground(new java.awt.Color(240, 102, 58));
        btn_selectedFiles_scan.setLabel("Scan");
        btn_selectedFiles_scan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selectedFiles_scanActionPerformed(evt);
            }
        });
        panel_selectedFiles_bottom_inside.add(btn_selectedFiles_scan, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, 120, 40));

        btn_selectedFiles_back.setBackground(new java.awt.Color(173, 159, 175));
        btn_selectedFiles_back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_selectedFiles_back.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_selectedFiles_back.setForeground(new java.awt.Color(102, 0, 153));
        btn_selectedFiles_back.setLabel("Back");
        btn_selectedFiles_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selectedFiles_backActionPerformed(evt);
            }
        });
        panel_selectedFiles_bottom_inside.add(btn_selectedFiles_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 120, 40));

        textField_selectedFiles.setEditable(false);
        textField_selectedFiles.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        textField_selectedFiles.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textField_selectedFiles.setText("C:\\");
            textField_selectedFiles.setToolTipText("The selected files in the path will be scanned");
            panel_selectedFiles_bottom_inside.add(textField_selectedFiles, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 710, 40));

            panel_selectedFiles_bottom_main.add(panel_selectedFiles_bottom_inside, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 35, 780, 430));

            getContentPane().add(panel_selectedFiles_bottom_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 780, 500));

            pack();
            setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents
    
            
    //minimize button mouse click action
    private void lbl_btn_selectedFiles_minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btn_selectedFiles_minimizeMouseClicked
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_lbl_btn_selectedFiles_minimizeMouseClicked

    //close button mouse click action
    private void lbl_btn_selectedFiles_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btn_selectedFiles_closeMouseClicked
        this.dispose();
    }//GEN-LAST:event_lbl_btn_selectedFiles_closeMouseClicked

    //back button mouse click action
    private void btn_selectedFiles_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selectedFiles_backActionPerformed
        
        Scan s1 = new Scan();
        s1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_selectedFiles_backActionPerformed

    //scan button mouse click action
    private void btn_selectedFiles_scanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selectedFiles_scanActionPerformed
        
        SelectedScanStatus scs = new SelectedScanStatus(); 
        
        scs.setVisible(true);
        
        this.dispose();
        
    }//GEN-LAST:event_btn_selectedFiles_scanActionPerformed

    //drive clicks
    
    private void panel_selectedFiles_drive0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_selectedFiles_drive0MouseClicked
        
        selectedFilesFileChooser.setCurrentDirectory(drives[0]);
        selectedFilesFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
        int result = selectedFilesFileChooser.showOpenDialog(this);
        
        if (result == selectedFilesFileChooser.APPROVE_OPTION) {
            
            File chosenFile = selectedFilesFileChooser.getSelectedFile();
            textField_selectedFiles.setText(chosenFile.getAbsolutePath());
            
        }else{
            textField_selectedFiles.setText(drives[0].toString());
        }
        
    }//GEN-LAST:event_panel_selectedFiles_drive0MouseClicked

    private void panel_selectedFiles_drive1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_selectedFiles_drive1MouseClicked
                
        selectedFilesFileChooser.setCurrentDirectory(drives[1]);
        selectedFilesFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
        int result = selectedFilesFileChooser.showOpenDialog(this);
        
        if (result == selectedFilesFileChooser.APPROVE_OPTION) {
            
            File chosenFile = selectedFilesFileChooser.getSelectedFile();
            textField_selectedFiles.setText(chosenFile.getAbsolutePath());
            
        }else{
            textField_selectedFiles.setText(drives[1].toString());
        }
        
    }//GEN-LAST:event_panel_selectedFiles_drive1MouseClicked

    private void panel_selectedFiles_drive2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_selectedFiles_drive2MouseClicked
                
        selectedFilesFileChooser.setCurrentDirectory(drives[2]);
        selectedFilesFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
        int result = selectedFilesFileChooser.showOpenDialog(this);
        
        if (result == selectedFilesFileChooser.APPROVE_OPTION) {
            
            File chosenFile = selectedFilesFileChooser.getSelectedFile();
            textField_selectedFiles.setText(chosenFile.getAbsolutePath());
            
        }else{
            textField_selectedFiles.setText(drives[2].toString());
        }
        
    }//GEN-LAST:event_panel_selectedFiles_drive2MouseClicked

    private void panel_selectedFiles_drive3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_selectedFiles_drive3MouseClicked
        
        selectedFilesFileChooser.setCurrentDirectory(drives[3]);
        selectedFilesFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
        int result = selectedFilesFileChooser.showOpenDialog(this);
        
        if (result == selectedFilesFileChooser.APPROVE_OPTION) {
            
            File chosenFile = selectedFilesFileChooser.getSelectedFile();
            textField_selectedFiles.setText(chosenFile.getAbsolutePath());
            
        }else{
            textField_selectedFiles.setText(drives[3].toString());
        }
    }//GEN-LAST:event_panel_selectedFiles_drive3MouseClicked

    private void panel_selectedFiles_drive4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_selectedFiles_drive4MouseClicked
        
        selectedFilesFileChooser.setCurrentDirectory(drives[4]);
        selectedFilesFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
        int result = selectedFilesFileChooser.showOpenDialog(this);
        
        if (result == selectedFilesFileChooser.APPROVE_OPTION) {
            
            File chosenFile = selectedFilesFileChooser.getSelectedFile();
            textField_selectedFiles.setText(chosenFile.getAbsolutePath());
            
        }else{
            textField_selectedFiles.setText(drives[4].toString());
        }
        
    }//GEN-LAST:event_panel_selectedFiles_drive4MouseClicked

    private void panel_selectedFiles_drive5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_selectedFiles_drive5MouseClicked
        
        selectedFilesFileChooser.setCurrentDirectory(drives[5]);
        selectedFilesFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
        int result = selectedFilesFileChooser.showOpenDialog(this);
        
        if (result == selectedFilesFileChooser.APPROVE_OPTION) {
            
            File chosenFile = selectedFilesFileChooser.getSelectedFile();
            textField_selectedFiles.setText(chosenFile.getAbsolutePath());
            
        }else{
            textField_selectedFiles.setText(drives[5].toString());
        }
    }//GEN-LAST:event_panel_selectedFiles_drive5MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SelectedFiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectedFiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectedFiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectedFiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectedFiles().setVisible(true);
                
            }
        });
    }
    
    JFileChooser selectedFilesFileChooser = new JFileChooser();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btn_selectedFiles_back;
    private java.awt.Button btn_selectedFiles_scan;
    private javax.swing.JLabel lbl_btn_selectedFiles_close;
    private javax.swing.JLabel lbl_btn_selectedFiles_minimize;
    private javax.swing.JLabel lbl_selectedFiles_drive0;
    private javax.swing.JLabel lbl_selectedFiles_drive1;
    private javax.swing.JLabel lbl_selectedFiles_drive2;
    private javax.swing.JLabel lbl_selectedFiles_drive3;
    private javax.swing.JLabel lbl_selectedFiles_drive4;
    private javax.swing.JLabel lbl_selectedFiles_drive5;
    private javax.swing.JLabel lbl_selectedFiles_titile;
    private javax.swing.JLabel lblicon_selectedFiles_drive0;
    private javax.swing.JLabel lblicon_selectedFiles_drive1;
    private javax.swing.JLabel lblicon_selectedFiles_drive2;
    private javax.swing.JLabel lblicon_selectedFiles_drive3;
    private javax.swing.JLabel lblicon_selectedFiles_drive4;
    private javax.swing.JLabel lblicon_selectedFiles_drive5;
    private javax.swing.JPanel panel_selectedFiles_bottom_inside;
    private javax.swing.JPanel panel_selectedFiles_bottom_main;
    private javax.swing.JPanel panel_selectedFiles_drive0;
    private javax.swing.JPanel panel_selectedFiles_drive0_inside;
    private javax.swing.JPanel panel_selectedFiles_drive1;
    private javax.swing.JPanel panel_selectedFiles_drive1_inside;
    private javax.swing.JPanel panel_selectedFiles_drive2;
    private javax.swing.JPanel panel_selectedFiles_drive2_inside;
    private javax.swing.JPanel panel_selectedFiles_drive3;
    private javax.swing.JPanel panel_selectedFiles_drive3_inside;
    private javax.swing.JPanel panel_selectedFiles_drive4;
    private javax.swing.JPanel panel_selectedFiles_drive4_inside;
    private javax.swing.JPanel panel_selectedFiles_drive5;
    private javax.swing.JPanel panel_selectedFiles_drive5_inside;
    private javax.swing.JPanel panel_selectedFiles_inside_mid;
    private javax.swing.JPanel panel_selectedFiles_top;
    private javax.swing.JTextField textField_selectedFiles;
    // End of variables declaration//GEN-END:variables
}
