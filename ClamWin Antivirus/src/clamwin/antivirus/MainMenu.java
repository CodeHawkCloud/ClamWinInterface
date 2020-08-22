/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clamwin.antivirus;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author HP
 */

/*
references : https://stackoverflow.com/questions/10967451/open-a-link-in-browser-with-java-button
*/
public class MainMenu extends javax.swing.JFrame {
    
    private BufferedImage closeImage = null;
    private BufferedImage minimizeImage = null;  
    private BufferedImage scanImage = null;
    private BufferedImage updateImage = null;
    private BufferedImage preferencesImage = null;
    

    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
        iconSet();
        getAndScaleCloseButtonImage();
        getAndScaleMinimizeButtonImage();
        getAndScaleMenuImages();
        cursorChange();
        setBorders();
        
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
	Image closeBtnDimensions = closeImage.getScaledInstance(lbl_btn_mainMenu_close.getWidth(), lbl_btn_mainMenu_close.getHeight(),Image.SCALE_SMOOTH);
	ImageIcon closeIcon = new ImageIcon(closeBtnDimensions);
				
	//icon set
	lbl_btn_mainMenu_close.setIcon(closeIcon);
        
    }
    
    //scaling the image according to the jlabel
    private void getAndScaleMinimizeButtonImage(){
        
        try {

            minimizeImage = ImageIO.read(this.getClass().getResource("/images/minimize.png"));
            
	} catch (IOException e) {
            
            e.printStackTrace();
            
	}
        
	//buffered image scaled
	Image minimizeBtnDimensions = minimizeImage.getScaledInstance(lbl_btn_mainMenu_minimize.getWidth(), lbl_btn_mainMenu_minimize.getHeight(),Image.SCALE_SMOOTH);
	ImageIcon MinimizeIcon = new ImageIcon(minimizeBtnDimensions);
				
	//icon set
	lbl_btn_mainMenu_minimize.setIcon(MinimizeIcon);
        
    } 
    
    //change cursor to hand
    private void cursorChange(){
        lbl_btn_mainMenu_close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lbl_btn_mainMenu_minimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_mainMenu_bottom_inside_top_help.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_mainMenu_bottom_inside_top_reports.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
    
    //scaling the 3 images in the options in the main menu
    private void getAndScaleMenuImages(){
        
        //read image files
        try {

            scanImage = ImageIO.read(this.getClass().getResource("/images/shield.png"));
            updateImage = ImageIO.read(this.getClass().getResource("/images/update.png"));
            preferencesImage = ImageIO.read(this.getClass().getResource("/images/settings.png"));
            
	} catch (IOException e) {
            
            e.printStackTrace();
            
	}
       
        //getting dimension of the jlabels
	Image scanImgDimensions = scanImage.getScaledInstance(lbl_icon_mainMenu_bottom_inside_bottom_scanMain.getWidth(), lbl_icon_mainMenu_bottom_inside_bottom_scanMain.getHeight(),Image.SCALE_SMOOTH);
	ImageIcon scanIcon = new ImageIcon(scanImgDimensions);
        
        Image updateImgDimensions = updateImage.getScaledInstance(lbl_icon_mainMenu_bottom_inside_bottom_updateMain.getWidth(), lbl_icon_mainMenu_bottom_inside_bottom_updateMain.getHeight(),Image.SCALE_SMOOTH);
	ImageIcon updateIcon = new ImageIcon(updateImgDimensions);
        
        Image preferencesImgDimensions = preferencesImage.getScaledInstance(lbl_icon_mainMenu_bottom_inside_bottom_preferencesMain.getWidth(), lbl_icon_mainMenu_bottom_inside_bottom_preferencesMain.getHeight(),Image.SCALE_SMOOTH);
	ImageIcon preferencesIcon = new ImageIcon(preferencesImgDimensions);
		
        //setting images
	lbl_icon_mainMenu_bottom_inside_bottom_scanMain.setIcon(scanIcon);
        lbl_icon_mainMenu_bottom_inside_bottom_updateMain.setIcon(updateIcon);
        lbl_icon_mainMenu_bottom_inside_bottom_preferencesMain.setIcon(preferencesIcon);
             
    }
    
    private void setBorders(){
        
        panel_mainMenu_bottom_inside_top_reports.setBorder(border);
        panel_mainMenu_bottom_inside_top_help.setBorder(border);
        panel_mainMenu_bottom_inside_top.setBorder(border2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_mainMenu_top = new javax.swing.JPanel();
        lbl_btn_mainMenu_close = new javax.swing.JLabel();
        lbl_btn_mainMenu_minimize = new javax.swing.JLabel();
        lbl_mainMenu_title = new javax.swing.JLabel();
        panel_mainMenu_bottom_main = new javax.swing.JPanel();
        panel_mainMenu_bottom_inside_top = new javax.swing.JPanel();
        lbl_mainMenu_bottom_inside_top_clamwin = new javax.swing.JLabel();
        panel_mainMenu_bottom_inside_top_help = new javax.swing.JPanel();
        lbl_mainMenu_bottom_inside_top_help = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        panel_mainMenu_bottom_inside_top_reports = new javax.swing.JPanel();
        lbl_mainMenu_bottom_inside_bottom_top_reports = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        panel_mainMenu_bottom_inside_bottom = new javax.swing.JPanel();
        panel_mainMenu_bottom_inside_bottom_scanMain = new javax.swing.JPanel();
        panel_mainMenu_bottom_inside_bottom_scanInside = new javax.swing.JPanel();
        lbl_icon_mainMenu_bottom_inside_bottom_scanMain = new javax.swing.JLabel();
        lbl_mainMenu_bottom_inside_bottom_scan = new javax.swing.JLabel();
        panel_mainMenu_bottom_inside_bottom_updateMain = new javax.swing.JPanel();
        panel_mainMenu_bottom_inside_bottom_updateInside = new javax.swing.JPanel();
        lbl_icon_mainMenu_bottom_inside_bottom_updateMain = new javax.swing.JLabel();
        lbl_mainMenu_bottom_inside_bottom_update = new javax.swing.JLabel();
        panel_mainMenu_bottom_inside_bottom_preferencesMain = new javax.swing.JPanel();
        panel_mainMenu_bottom_inside_bottom_preferencesInside = new javax.swing.JPanel();
        lbl_icon_mainMenu_bottom_inside_bottom_preferencesMain = new javax.swing.JLabel();
        lbl_mainMenu_bottom_inside_bottom_preferences = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("MainMenu"); // NOI18N
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(780, 520));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_mainMenu_top.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_btn_mainMenu_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_btn_mainMenu_closeMouseClicked(evt);
            }
        });
        panel_mainMenu_top.add(lbl_btn_mainMenu_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 20, 20));

        lbl_btn_mainMenu_minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_btn_mainMenu_minimizeMouseClicked(evt);
            }
        });
        panel_mainMenu_top.add(lbl_btn_mainMenu_minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 20, 10));

        lbl_mainMenu_title.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lbl_mainMenu_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_mainMenu_title.setText("ClamWin Free Antivirus");
        lbl_mainMenu_title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panel_mainMenu_top.add(lbl_mainMenu_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 670, 20));

        getContentPane().add(panel_mainMenu_top, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 20));

        panel_mainMenu_bottom_main.setBackground(new java.awt.Color(64, 55, 110));
        panel_mainMenu_bottom_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_mainMenu_bottom_inside_top.setBackground(new java.awt.Color(107, 91, 170));
        panel_mainMenu_bottom_inside_top.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_mainMenu_bottom_inside_top_clamwin.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        lbl_mainMenu_bottom_inside_top_clamwin.setText("ClamWin");
        panel_mainMenu_bottom_inside_top.add(lbl_mainMenu_bottom_inside_top_clamwin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 130, 55));

        panel_mainMenu_bottom_inside_top_help.setBackground(new java.awt.Color(107, 91, 170));
        panel_mainMenu_bottom_inside_top_help.setToolTipText("Visit ClamWin help site");
        panel_mainMenu_bottom_inside_top_help.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_mainMenu_bottom_inside_top_help.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_mainMenu_bottom_inside_top_helpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_mainMenu_bottom_inside_top_helpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_mainMenu_bottom_inside_top_helpMouseExited(evt);
            }
        });
        panel_mainMenu_bottom_inside_top_help.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_mainMenu_bottom_inside_top_help.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lbl_mainMenu_bottom_inside_top_help.setForeground(new java.awt.Color(255, 255, 255));
        lbl_mainMenu_bottom_inside_top_help.setText("Help");
        lbl_mainMenu_bottom_inside_top_help.setToolTipText(null);
        panel_mainMenu_bottom_inside_top_help.add(lbl_mainMenu_bottom_inside_top_help, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 55));

        jPanel2.setBackground(new java.awt.Color(107, 91, 170));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Help");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 55));

        panel_mainMenu_bottom_inside_top_help.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 150, 55));

        panel_mainMenu_bottom_inside_top.add(panel_mainMenu_bottom_inside_top_help, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 150, 55));

        panel_mainMenu_bottom_inside_top_reports.setBackground(new java.awt.Color(107, 91, 170));
        panel_mainMenu_bottom_inside_top_reports.setToolTipText("View Reports");
        panel_mainMenu_bottom_inside_top_reports.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_mainMenu_bottom_inside_top_reports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_mainMenu_bottom_inside_top_reportsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_mainMenu_bottom_inside_top_reportsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_mainMenu_bottom_inside_top_reportsMouseExited(evt);
            }
        });
        panel_mainMenu_bottom_inside_top_reports.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_mainMenu_bottom_inside_bottom_top_reports.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lbl_mainMenu_bottom_inside_bottom_top_reports.setForeground(new java.awt.Color(255, 255, 255));
        lbl_mainMenu_bottom_inside_bottom_top_reports.setText("Reports");
        lbl_mainMenu_bottom_inside_bottom_top_reports.setToolTipText(null);
        panel_mainMenu_bottom_inside_top_reports.add(lbl_mainMenu_bottom_inside_bottom_top_reports, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 55));

        jPanel4.setBackground(new java.awt.Color(107, 91, 170));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Help");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 55));

        panel_mainMenu_bottom_inside_top_reports.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 150, 55));

        panel_mainMenu_bottom_inside_top.add(panel_mainMenu_bottom_inside_top_reports, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 150, 55));

        panel_mainMenu_bottom_main.add(panel_mainMenu_bottom_inside_top, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 55));

        panel_mainMenu_bottom_inside_bottom.setBackground(new java.awt.Color(107, 91, 170));
        panel_mainMenu_bottom_inside_bottom.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_mainMenu_bottom_inside_bottom_scanMain.setBackground(new java.awt.Color(255, 165, 0));
        panel_mainMenu_bottom_inside_bottom_scanMain.setToolTipText("Scan for computer viruses");
        panel_mainMenu_bottom_inside_bottom_scanMain.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_mainMenu_bottom_inside_bottom_scanMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_mainMenu_bottom_inside_bottom_scanMainMouseClicked(evt);
            }
        });
        panel_mainMenu_bottom_inside_bottom_scanMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_mainMenu_bottom_inside_bottom_scanInside.setBackground(new java.awt.Color(255, 140, 0));
        panel_mainMenu_bottom_inside_bottom_scanInside.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel_mainMenu_bottom_inside_bottom_scanInside.add(lbl_icon_mainMenu_bottom_inside_bottom_scanMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 70, 70));

        panel_mainMenu_bottom_inside_bottom_scanMain.add(panel_mainMenu_bottom_inside_bottom_scanInside, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 194, 185));

        lbl_mainMenu_bottom_inside_bottom_scan.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        lbl_mainMenu_bottom_inside_bottom_scan.setForeground(new java.awt.Color(255, 255, 255));
        lbl_mainMenu_bottom_inside_bottom_scan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_mainMenu_bottom_inside_bottom_scan.setText("Scan");
        panel_mainMenu_bottom_inside_bottom_scanMain.add(lbl_mainMenu_bottom_inside_bottom_scan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 189, 170, 40));

        panel_mainMenu_bottom_inside_bottom.add(panel_mainMenu_bottom_inside_bottom_scanMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 194, 236));

        panel_mainMenu_bottom_inside_bottom_updateMain.setBackground(new java.awt.Color(42, 161, 72));
        panel_mainMenu_bottom_inside_bottom_updateMain.setToolTipText("Update virus database");
        panel_mainMenu_bottom_inside_bottom_updateMain.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_mainMenu_bottom_inside_bottom_updateMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_mainMenu_bottom_inside_bottom_updateMainMouseClicked(evt);
            }
        });
        panel_mainMenu_bottom_inside_bottom_updateMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_mainMenu_bottom_inside_bottom_updateInside.setBackground(new java.awt.Color(7, 106, 46));
        panel_mainMenu_bottom_inside_bottom_updateInside.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel_mainMenu_bottom_inside_bottom_updateInside.add(lbl_icon_mainMenu_bottom_inside_bottom_updateMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 70, 70));

        panel_mainMenu_bottom_inside_bottom_updateMain.add(panel_mainMenu_bottom_inside_bottom_updateInside, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 194, 185));

        lbl_mainMenu_bottom_inside_bottom_update.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        lbl_mainMenu_bottom_inside_bottom_update.setForeground(new java.awt.Color(255, 255, 255));
        lbl_mainMenu_bottom_inside_bottom_update.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_mainMenu_bottom_inside_bottom_update.setText("Update");
        panel_mainMenu_bottom_inside_bottom_updateMain.add(lbl_mainMenu_bottom_inside_bottom_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 189, 170, 40));

        panel_mainMenu_bottom_inside_bottom.add(panel_mainMenu_bottom_inside_bottom_updateMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 194, 236));

        panel_mainMenu_bottom_inside_bottom_preferencesMain.setBackground(new java.awt.Color(219, 89, 89));
        panel_mainMenu_bottom_inside_bottom_preferencesMain.setToolTipText("Customize ClamWin as per your preferences");
        panel_mainMenu_bottom_inside_bottom_preferencesMain.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_mainMenu_bottom_inside_bottom_preferencesMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_mainMenu_bottom_inside_bottom_preferencesMainMouseClicked(evt);
            }
        });
        panel_mainMenu_bottom_inside_bottom_preferencesMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_mainMenu_bottom_inside_bottom_preferencesInside.setBackground(new java.awt.Color(221, 9, 9));
        panel_mainMenu_bottom_inside_bottom_preferencesInside.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel_mainMenu_bottom_inside_bottom_preferencesInside.add(lbl_icon_mainMenu_bottom_inside_bottom_preferencesMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 70, 70));

        panel_mainMenu_bottom_inside_bottom_preferencesMain.add(panel_mainMenu_bottom_inside_bottom_preferencesInside, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 194, 185));

        lbl_mainMenu_bottom_inside_bottom_preferences.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        lbl_mainMenu_bottom_inside_bottom_preferences.setForeground(new java.awt.Color(255, 255, 255));
        lbl_mainMenu_bottom_inside_bottom_preferences.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_mainMenu_bottom_inside_bottom_preferences.setText("Preferences");
        panel_mainMenu_bottom_inside_bottom_preferencesMain.add(lbl_mainMenu_bottom_inside_bottom_preferences, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 189, 170, 40));

        panel_mainMenu_bottom_inside_bottom.add(panel_mainMenu_bottom_inside_bottom_preferencesMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 194, 236));

        panel_mainMenu_bottom_main.add(panel_mainMenu_bottom_inside_bottom, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 780, 390));

        getContentPane().add(panel_mainMenu_bottom_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 780, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //close button function
    private void lbl_btn_mainMenu_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btn_mainMenu_closeMouseClicked
        this.dispose();

    }//GEN-LAST:event_lbl_btn_mainMenu_closeMouseClicked

    //minimize button function
    private void lbl_btn_mainMenu_minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btn_mainMenu_minimizeMouseClicked
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_lbl_btn_mainMenu_minimizeMouseClicked

    //scan option select function
    private void panel_mainMenu_bottom_inside_bottom_scanMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_mainMenu_bottom_inside_bottom_scanMainMouseClicked
        
        Scan s1 = new Scan();
        s1.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_panel_mainMenu_bottom_inside_bottom_scanMainMouseClicked

    //update option select function
    private void panel_mainMenu_bottom_inside_bottom_updateMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_mainMenu_bottom_inside_bottom_updateMainMouseClicked

        boolean internetStatus = true;
        
        //try and get to google.com to see if internet is available
        try {
			
            InetAddress internetTesting = InetAddress.getByName("www.google.com");  
	    
	}catch (Exception e) {
            
	    	internetStatus  = false;
	}
        
        //check for internet connection
        if(internetStatus){
            
            UpdateScanStatus u1 = new UpdateScanStatus();
            u1.setVisible(true);
            this.dispose();
            
        }else{
            
            JOptionPane internetNotAvailableOptionPane = new JOptionPane("An internet connection is required to update the database, please try again later !", JOptionPane.INFORMATION_MESSAGE);
                  
            JDialog internetNotAvailableDialog = internetNotAvailableOptionPane.createDialog(null, "No Internet Connection");
            internetNotAvailableDialog.setModal(true);
            internetNotAvailableDialog.setVisible(true);
            
        
        }

             
    }//GEN-LAST:event_panel_mainMenu_bottom_inside_bottom_updateMainMouseClicked

    //preferences option select function
    private void panel_mainMenu_bottom_inside_bottom_preferencesMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_mainMenu_bottom_inside_bottom_preferencesMainMouseClicked
        
        Preferences p1 = new Preferences();
        p1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_panel_mainMenu_bottom_inside_bottom_preferencesMainMouseClicked

    private void panel_mainMenu_bottom_inside_top_reportsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_mainMenu_bottom_inside_top_reportsMouseEntered
        panel_mainMenu_bottom_inside_top_reports.setBackground(new Color(102,0,204));
    }//GEN-LAST:event_panel_mainMenu_bottom_inside_top_reportsMouseEntered

    private void panel_mainMenu_bottom_inside_top_reportsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_mainMenu_bottom_inside_top_reportsMouseExited
        panel_mainMenu_bottom_inside_top_reports.setBackground(new Color(107,91,170));
    }//GEN-LAST:event_panel_mainMenu_bottom_inside_top_reportsMouseExited

    private void panel_mainMenu_bottom_inside_top_helpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_mainMenu_bottom_inside_top_helpMouseEntered
        panel_mainMenu_bottom_inside_top_help.setBackground(new Color(102,0,204));
    }//GEN-LAST:event_panel_mainMenu_bottom_inside_top_helpMouseEntered

    private void panel_mainMenu_bottom_inside_top_helpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_mainMenu_bottom_inside_top_helpMouseExited
        panel_mainMenu_bottom_inside_top_help.setBackground(new Color(107,91,170));
    }//GEN-LAST:event_panel_mainMenu_bottom_inside_top_helpMouseExited

    //help button action
    private void panel_mainMenu_bottom_inside_top_helpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_mainMenu_bottom_inside_top_helpMouseClicked
        
        boolean internetStatus = true;
        
        //try and get to google.com to see if internet is available
        try {
			
            InetAddress internetTesting = InetAddress.getByName("www.google.com");  
	    
	}catch (Exception e) {
            
	    	internetStatus  = false;
	}
        
        //if internet is avialable redirect to ClamWin help
        if(internetStatus){
            
            boolean openStatus = true;
            try {
                
                Desktop.getDesktop().browse(new URL("http://www.clamwin.com/content/category/3/7/27/").toURI());
                
            } catch (Exception e) {
            
                openStatus = false;
            
            }
          
            if(openStatus == false){
                
                JOptionPane siteOpenOptionPane = new JOptionPane("Please try again later !", JOptionPane.INFORMATION_MESSAGE);
                  
                JDialog siteOpenDialog = siteOpenOptionPane.createDialog(null, "Unable to connect to ClamWin help at the moment");
                siteOpenDialog.setModal(true);
                siteOpenDialog.setVisible(true);
                
            }
            
        }else{
            
            JOptionPane internetNotAvailableOptionPane = new JOptionPane("Please connect to the internet and try again !", JOptionPane.INFORMATION_MESSAGE);
                  
            JDialog internetNotAvailableDialog = internetNotAvailableOptionPane.createDialog(null, "No Internet Connection");
            internetNotAvailableDialog.setModal(true);
            internetNotAvailableDialog.setVisible(true);
            
        }
		
	
    }//GEN-LAST:event_panel_mainMenu_bottom_inside_top_helpMouseClicked

    //reports button action
    private void panel_mainMenu_bottom_inside_top_reportsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_mainMenu_bottom_inside_top_reportsMouseClicked
        
        Reports r1 = new Reports();
        r1.setVisible(true);
        
        this.dispose();
        
    }//GEN-LAST:event_panel_mainMenu_bottom_inside_top_reportsMouseClicked

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    //border
    Border border = BorderFactory.createMatteBorder(2,2,0,0,new Color(64,55,110));
    Border border2 = BorderFactory.createMatteBorder(2,0,0,0,new Color(64,55,110));
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbl_btn_mainMenu_close;
    private javax.swing.JLabel lbl_btn_mainMenu_minimize;
    private javax.swing.JLabel lbl_icon_mainMenu_bottom_inside_bottom_preferencesMain;
    private javax.swing.JLabel lbl_icon_mainMenu_bottom_inside_bottom_scanMain;
    private javax.swing.JLabel lbl_icon_mainMenu_bottom_inside_bottom_updateMain;
    private javax.swing.JLabel lbl_mainMenu_bottom_inside_bottom_preferences;
    private javax.swing.JLabel lbl_mainMenu_bottom_inside_bottom_scan;
    private javax.swing.JLabel lbl_mainMenu_bottom_inside_bottom_top_reports;
    private javax.swing.JLabel lbl_mainMenu_bottom_inside_bottom_update;
    private javax.swing.JLabel lbl_mainMenu_bottom_inside_top_clamwin;
    private javax.swing.JLabel lbl_mainMenu_bottom_inside_top_help;
    private javax.swing.JLabel lbl_mainMenu_title;
    private javax.swing.JPanel panel_mainMenu_bottom_inside_bottom;
    private javax.swing.JPanel panel_mainMenu_bottom_inside_bottom_preferencesInside;
    private javax.swing.JPanel panel_mainMenu_bottom_inside_bottom_preferencesMain;
    private javax.swing.JPanel panel_mainMenu_bottom_inside_bottom_scanInside;
    private javax.swing.JPanel panel_mainMenu_bottom_inside_bottom_scanMain;
    private javax.swing.JPanel panel_mainMenu_bottom_inside_bottom_updateInside;
    private javax.swing.JPanel panel_mainMenu_bottom_inside_bottom_updateMain;
    private javax.swing.JPanel panel_mainMenu_bottom_inside_top;
    private javax.swing.JPanel panel_mainMenu_bottom_inside_top_help;
    private javax.swing.JPanel panel_mainMenu_bottom_inside_top_reports;
    private javax.swing.JPanel panel_mainMenu_bottom_main;
    private javax.swing.JPanel panel_mainMenu_top;
    // End of variables declaration//GEN-END:variables
}
