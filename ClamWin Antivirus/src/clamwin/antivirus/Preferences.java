/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clamwin.antivirus;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.border.Border;
import java.io.File;
import java.util.Calendar;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.Timer;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author HP
 */

/**
 * 
 * References: 
 *  https://www.codejava.net/java-se/swing/show-simple-open-file-dialog-using-jfilechooser
 *  https://stackoverflow.com/questions/34138950/using-a-jfile-chooser-to-get-path-of-a-exe-file
 */
public class Preferences extends javax.swing.JFrame {
    
    private BufferedImage closeImage = null;
    private BufferedImage minimizeImage = null;
    private BufferedImage lineImage = null;
    private BufferedImage folderImage = null;
    private BufferedImage upFilterImage = null;
    private BufferedImage downFilterImage = null;
    private BufferedImage editFilterImage = null;
    private BufferedImage addFilterImage = null;
    private BufferedImage deleteFilterImage = null;
    
    

    /**
     * Creates new form Preferences
     */
    public Preferences() {
        initComponents();
        iconSet();
        getAndScaleCloseButtonImage();
        getAndScaleMinimizeButtonImage();
        getAndScaleLineImage();
        getAndScaleFolderImage();
        getAndScaleImagesinFilter();
        getAndScaleInternetUpdatesImages();
        getAndScaleScheduledScansImages();
        getAndScalefileLocationImages();
        getAndScaleEmailAlertsImages();
        getAndScaleEmailScanningImages();
        getAndScaleLimitsImages();
        getAndScaleReports();
        getAndScaleProxyImages();
        getAndScaleAdvancedImages();
        spinnerSetUpPreferences();
        cursorChange();
        
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
	Image closeBtnDimensions = closeImage.getScaledInstance(lbl_btn_preferences_close.getWidth(), lbl_btn_preferences_close.getHeight(),Image.SCALE_SMOOTH);
	ImageIcon closeIcon = new ImageIcon(closeBtnDimensions);
				
	//icon set
	lbl_btn_preferences_close.setIcon(closeIcon);
        
    }
    
    //scaling the image according to the jlabel
    private void getAndScaleMinimizeButtonImage(){
        
        try {

            minimizeImage = ImageIO.read(this.getClass().getResource("/images/minimize.png"));
            
	} catch (IOException e) {
            
            e.printStackTrace();
            
	}
        
	//buffered image scaled
	Image minimizeBtnDimensions = minimizeImage.getScaledInstance(lbl_btn_preferences_minimize.getWidth(), lbl_btn_preferences_minimize.getHeight(),Image.SCALE_SMOOTH);
	ImageIcon MinimizeIcon = new ImageIcon(minimizeBtnDimensions);
				
	//icon set
	lbl_btn_preferences_minimize.setIcon(MinimizeIcon);
        
    }
    
    //scalling the line image
    private void getAndScaleLineImage(){
        
        try {

            lineImage = ImageIO.read(this.getClass().getResource("/images/minimize.png"));
            
	} catch (IOException e) {
            
            e.printStackTrace();
            
	}
        
	//buffered image scaled
	Image lineDimensions = lineImage.getScaledInstance(preferences_general_lblicon_line.getWidth(), preferences_general_lblicon_line.getHeight(),Image.SCALE_SMOOTH);
	ImageIcon lineIcon = new ImageIcon(lineDimensions);
				
	//icon set
	preferences_general_lblicon_line.setIcon(lineIcon);
        
        
    }
    
    //scaling the folder image
    private void getAndScaleFolderImage() {

        try {

            folderImage = ImageIO.read(this.getClass().getResource("/images/browse.png"));

        } catch (IOException e) {

            e.printStackTrace();

        }

        //buffered image scaled
        Image browseBtnDimensions = folderImage.getScaledInstance(preferences_general_lblicon_browse.getWidth(), preferences_general_lblicon_browse.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon browseIcon = new ImageIcon(browseBtnDimensions);

        //icon set
        preferences_general_lblicon_browse.setIcon(browseIcon);

    }
    
    //scaling the folder image
    private void getAndScaleImagesinFilter() {

        try {

            upFilterImage = ImageIO.read(this.getClass().getResource("/images/up.png"));

        } catch (IOException e) {

            e.printStackTrace();

        }
        
        try {

            downFilterImage = ImageIO.read(this.getClass().getResource("/images/down.png"));

        } catch (IOException e) {

            e.printStackTrace();

        }
                
                
        try {

            editFilterImage = ImageIO.read(this.getClass().getResource("/images/edit.png"));

        } catch (IOException e) {

            e.printStackTrace();

        }
                        
                        
        try {

            addFilterImage = ImageIO.read(this.getClass().getResource("/images/add.png"));

        } catch (IOException e) {

            e.printStackTrace();

        }
                                
        try {

            deleteFilterImage = ImageIO.read(this.getClass().getResource("/images/delete.png"));

        } catch (IOException e) {

            e.printStackTrace();

        }

        //buffered image scaled up top
        Image upTopBtnDimensions = upFilterImage.getScaledInstance(preferences_filters_lblicon_up_top.getWidth(), preferences_filters_lblicon_up_top.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon upTopIcon = new ImageIcon(upTopBtnDimensions);
        
        //icon set
        preferences_filters_lblicon_up_top.setIcon(upTopIcon);
        
        //buffered image scaled down top
        Image downTopBtnDimensions = downFilterImage.getScaledInstance(preferences_filters_lblicon_down_top.getWidth(), preferences_filters_lblicon_down_top.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon downTopIcon = new ImageIcon(downTopBtnDimensions);
        
        //icon set
        preferences_filters_lblicon_down_top.setIcon(downTopIcon);
        
        //buffered image scaled edit top
        Image editTopBtnDimensions = editFilterImage.getScaledInstance(preferences_filters_lblicon_edit_top.getWidth(), preferences_filters_lblicon_edit_top.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon editTopIcon = new ImageIcon(editTopBtnDimensions);
        
        //icon set
        preferences_filters_lblicon_edit_top.setIcon(editTopIcon);
        
        //buffered image scaled add top
        Image addTopBtnDimensions = addFilterImage.getScaledInstance(preferences_filters_lblicon_add_top.getWidth(), preferences_filters_lblicon_add_top.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon addTopIcon = new ImageIcon(addTopBtnDimensions);
        
        //icon set
        preferences_filters_lblicon_add_top.setIcon(addTopIcon);
        
        //buffered image scaled delete top
        Image deleteTopBtnDimensions = deleteFilterImage.getScaledInstance(preferences_filters_lblicon_delete_top.getWidth(), preferences_filters_lblicon_delete_top.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon deleteTopIcon = new ImageIcon(deleteTopBtnDimensions);
       
        //icon set
        preferences_filters_lblicon_delete_top.setIcon(deleteTopIcon);
        
        //buffered image scaled up bottom
        Image upBottomBtnDimensions = upFilterImage.getScaledInstance(preferences_filters_lblicon_up_bottom.getWidth(), preferences_filters_lblicon_up_bottom.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon upBottomIcon = new ImageIcon(upBottomBtnDimensions);
        
        //icon set
        preferences_filters_lblicon_up_bottom.setIcon(upBottomIcon);
        
        //buffered image scaled down bottom
        Image downBottomBtnDimensions = downFilterImage.getScaledInstance(preferences_filters_lblicon_down_bottom.getWidth(), preferences_filters_lblicon_down_bottom.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon downBottomIcon = new ImageIcon(downBottomBtnDimensions);
        
        //icon set
        preferences_filters_lblicon_down_bottom.setIcon(downBottomIcon);
        
        //buffered image scaled edit bottom
        Image editBottomBtnDimensions = editFilterImage.getScaledInstance(preferences_filters_lblicon_edit_bottom.getWidth(), preferences_filters_lblicon_edit_bottom.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon editBottomIcon = new ImageIcon(editBottomBtnDimensions);
        
        //icon set
        preferences_filters_lblicon_edit_bottom.setIcon(editBottomIcon);
        
        //buffered image scaled add bottom
        Image addBottomDimensions = addFilterImage.getScaledInstance(preferences_filters_lblicon_add_bottom.getWidth(), preferences_filters_lblicon_add_bottom.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon addBottomIcon = new ImageIcon(addBottomDimensions);
        
        //icon set
        preferences_filters_lblicon_add_bottom.setIcon(addBottomIcon);
        
        //buffered image scaled delete bottom
        Image deleteBottomDimensions = deleteFilterImage.getScaledInstance(preferences_filters_lblicon_delete_bottom.getWidth(), preferences_filters_lblicon_delete_bottom.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon deleteBottomIcon = new ImageIcon(deleteBottomDimensions);
       
        //icon set
        preferences_filters_lblicon_delete_bottom.setIcon(deleteBottomIcon);
        
        //buffered image scaled line
        Image lineDimensions = lineImage.getScaledInstance(preferences_filters_lbl_line.getWidth(), preferences_filters_lbl_line.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon lineIcon = new ImageIcon(lineDimensions);
       
        //icon set
        preferences_filters_lbl_line.setIcon(lineIcon);       

    }
    
    private void getAndScaleInternetUpdatesImages(){
        
        //buffered image scaled line
        Image lineInternetDimensions = lineImage.getScaledInstance(preferences_internetUpdates_lbl_line.getWidth(), preferences_internetUpdates_lbl_line.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon lineInternetIcon = new ImageIcon(lineInternetDimensions);
       
        //icon set
        preferences_internetUpdates_lbl_line.setIcon(lineInternetIcon); 
    }
    
    private void getAndScaleScheduledScansImages(){
        
        //buffered image scaled edit
        Image editSSDimensions = editFilterImage.getScaledInstance(preferences_scheduledScans_lblicon_edit.getWidth(), preferences_scheduledScans_lblicon_edit.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon editSSIcon = new ImageIcon(editSSDimensions);
        
        //icon set
        preferences_scheduledScans_lblicon_edit.setIcon(editSSIcon);
        
        //buffered image scaled add
        Image addSSDimensions = addFilterImage.getScaledInstance(preferences_scheduledScans_lblicon_add.getWidth(), preferences_scheduledScans_lblicon_add.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon addSSIcon = new ImageIcon(addSSDimensions);
        
        //icon set
        preferences_scheduledScans_lblicon_add.setIcon(addSSIcon);
        
        //buffered image scaled delete
        Image deleteSSDimensions = deleteFilterImage.getScaledInstance(preferences_scheduledScans_lblicon_delete.getWidth(), preferences_scheduledScans_lblicon_delete.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon deleteSSIcon = new ImageIcon(deleteSSDimensions);
       
        //icon set
        preferences_scheduledScans_lblicon_delete.setIcon(deleteSSIcon);
        
        //buffered image scaled line
        Image lineSSDimensions = lineImage.getScaledInstance(preferences_scheduledScans_lbl_line.getWidth(), preferences_scheduledScans_lbl_line.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon lineSSIcon = new ImageIcon(lineSSDimensions);
       
        //icon set
        preferences_scheduledScans_lbl_line.setIcon(lineSSIcon);
        
        
    }
    
    private void getAndScalefileLocationImages(){
        
        //buffered image scaled file
        Image fileFLDimensions = folderImage.getScaledInstance(preferences_fileLocations_lblicon_scanLocationBrowse.getWidth(), preferences_fileLocations_lblicon_scanLocationBrowse.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon fileFLicon = new ImageIcon(fileFLDimensions);
       
        //icon set
        preferences_fileLocations_lblicon_scanLocationBrowse.setIcon(fileFLicon);
        preferences_fileLocations_lblicon_freshLocationBrowse.setIcon(fileFLicon);
        preferences_fileLocations_lblicon_databaseLocationBrowse.setIcon(fileFLicon);
        
        //buffered image file
        Image lineFLDimensions = lineImage.getScaledInstance(preferences_fileLocations_lbl_line.getWidth(), preferences_fileLocations_lbl_line.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon lineFLicon = new ImageIcon(lineFLDimensions);
       
        //icon set
        preferences_fileLocations_lbl_line.setIcon(lineFLicon);
        
        
    }
    
    private void getAndScaleEmailAlertsImages(){
        
        //buffered image file
        Image lineEADimensions = lineImage.getScaledInstance(preferences_emailAlerts_lbl_line.getWidth(), preferences_emailAlerts_lbl_line.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon lineEAicon = new ImageIcon(lineEADimensions);
       
        //icon set
        preferences_emailAlerts_lbl_line.setIcon(lineEAicon);
        
    }
    
    private void getAndScaleEmailScanningImages(){
        
        //buffered image file
        Image lineESDimensions = lineImage.getScaledInstance(preferences_emailScan_lbl_line.getWidth(), preferences_emailScan_lbl_line.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon lineESicon = new ImageIcon(lineESDimensions);
       
        //icon set
        preferences_emailScan_lbl_line.setIcon(lineESicon);
        
    }
    
    private void getAndScaleLimitsImages(){
        
        //buffered image file
        Image lineLDimensions = lineImage.getScaledInstance(preferences_limits_lbl_line.getWidth(), preferences_limits_lbl_line.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon lineLicon = new ImageIcon(lineLDimensions);
       
        //icon set
        preferences_limits_lbl_line.setIcon(lineLicon);
        
    }
    
    private void getAndScaleReports(){
        
        //buffered image file
        Image fileR1Dimensions = folderImage.getScaledInstance(preferences_reports_lblicon_scanReport.getWidth(), preferences_reports_lblicon_scanReport.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon fileR1icon = new ImageIcon(fileR1Dimensions);
       
        //icon set
        preferences_reports_lblicon_scanReport.setIcon(fileR1icon);
        
        //buffered image file
        Image fileR2Dimensions = folderImage.getScaledInstance(preferences_reports_lblicon_databaseReport.getWidth(), preferences_reports_lblicon_databaseReport.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon fileR2icon = new ImageIcon(fileR2Dimensions);
       
        //icon set
        preferences_reports_lblicon_databaseReport.setIcon(fileR2icon);
        
        //buffered image file
        Image lineRDimensions = lineImage.getScaledInstance(preferences_reports_lbl_line.getWidth(), preferences_reports_lbl_line.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon lineRicon = new ImageIcon(lineRDimensions);
       
        //icon set
        preferences_reports_lbl_line.setIcon(lineRicon);
        
    }
    
    private void getAndScaleProxyImages(){
        
        //buffered image file
        Image linePDimensions = lineImage.getScaledInstance(preferences_proxy_lbl_line.getWidth(), preferences_proxy_lbl_line.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon linePicon = new ImageIcon(linePDimensions);
       
        //icon set
        preferences_proxy_lbl_line.setIcon(linePicon);
        
    }
            
    private void getAndScaleAdvancedImages(){
        
        //buffered image file
        Image lineADimensions = lineImage.getScaledInstance(preferences_advanced_lbl_line.getWidth(), preferences_advanced_lbl_line.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon lineAicon = new ImageIcon(lineADimensions);
       
        //icon set
        preferences_advanced_lbl_line.setIcon(lineAicon);
        
    }
    
    private void spinnerSetUpPreferences(){
        
        SpinnerDateModel spinnerModel = new SpinnerDateModel();
        spinnerModel.setCalendarField(Calendar.MINUTE);
        
        preferences_internetUpdates_spinner_time.setModel(spinnerModel);
        preferences_internetUpdates_spinner_time.setEditor(new JSpinner.DateEditor(preferences_internetUpdates_spinner_time , "hh:mm:ss"));
           
    }
        
    //change cursor to hand
    private void cursorChange(){
        lbl_btn_preferences_close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lbl_btn_preferences_minimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
    

  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panel_preferences_top = new javax.swing.JPanel();
        lbl_preferences_titile = new javax.swing.JLabel();
        lbl_btn_preferences_minimize = new javax.swing.JLabel();
        lbl_btn_preferences_close = new javax.swing.JLabel();
        panel_preferences_left = new javax.swing.JPanel();
        panel_preferences_left_filters = new javax.swing.JPanel();
        lbl_preferences_left_filters = new javax.swing.JLabel();
        panel_preferences_left_advanced = new javax.swing.JPanel();
        lbl_preferences_left_advanced = new javax.swing.JLabel();
        panel_preferences_left_proxy = new javax.swing.JPanel();
        lbl_preferences_left_proxy = new javax.swing.JLabel();
        panel_preferences_left_reports = new javax.swing.JPanel();
        lbl_preferences_left_reports = new javax.swing.JLabel();
        panel_preferences_left_limits = new javax.swing.JPanel();
        lbl_preferences_left_limits = new javax.swing.JLabel();
        panel_preferences_left_emailScanning = new javax.swing.JPanel();
        lbl_preferences_left_emailScanning = new javax.swing.JLabel();
        panel_preferences_left_fileLocations = new javax.swing.JPanel();
        lbl_preferences_left_fileLocations = new javax.swing.JLabel();
        panel_preferences_left_emailAlerts = new javax.swing.JPanel();
        lbl_preferences_left_emailAlerts = new javax.swing.JLabel();
        panel_preferences_left_InternetUpdates = new javax.swing.JPanel();
        lbl_preferences_left_internetUpdates = new javax.swing.JLabel();
        panel_preferences_left_mainMenu = new javax.swing.JPanel();
        lbl_preferences_left_mainMenu = new javax.swing.JLabel();
        panel_preferences_left_scheduledScans = new javax.swing.JPanel();
        lbl_preferences_left_scheduledScans = new javax.swing.JLabel();
        panel_preferences_left_general = new javax.swing.JPanel();
        lbl_preferences_left_general = new javax.swing.JLabel();
        panel_preferences_right = new javax.swing.JPanel();
        card_preferences_general = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        preferences_general_lbl_info = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        preferences_general_lbl_heading1 = new javax.swing.JLabel();
        preferences_general_btn_save = new java.awt.Button();
        preferences_general_lblicon_line = new javax.swing.JLabel();
        preferences_general_cb_subDirectories = new javax.swing.JLabel();
        preferences_general_cb_unload = new javax.swing.JCheckBox();
        preferences_general_cb_displayInfected = new javax.swing.JCheckBox();
        preferences_general_cb_displayProgress = new javax.swing.JCheckBox();
        preferences_general_rb_folder = new javax.swing.JRadioButton();
        preferences_general_rb_remove = new javax.swing.JRadioButton();
        preferences_general_rb_report = new javax.swing.JRadioButton();
        preferences_general_cb_subdirectories = new javax.swing.JCheckBox();
        preferences_general_textfield1 = new javax.swing.JTextField();
        preferences_general_lblicon_browse = new javax.swing.JLabel();
        card_preferences_filters = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        preferences_filters_lbl_info = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        preferences_filters_lbl_heading1 = new javax.swing.JLabel();
        preferences_filters_btn_save = new java.awt.Button();
        preferences_filters_lbl_line = new javax.swing.JLabel();
        preferences_filters_lbl_heading2 = new javax.swing.JLabel();
        preferences_filters_lblicon_up_top = new javax.swing.JLabel();
        preferences_filters_lblicon_down_top = new javax.swing.JLabel();
        preferences_filters_lblicon_edit_top = new javax.swing.JLabel();
        preferences_filters_lblicon_add_top = new javax.swing.JLabel();
        preferences_filters_lblicon_delete_top = new javax.swing.JLabel();
        preferences_filters_lblicon_down_scroll = new javax.swing.JScrollPane();
        preferences_filters_lblicon_up_bottom = new javax.swing.JLabel();
        preferences_filters_lblicon_delete_bottom = new javax.swing.JLabel();
        preferences_filters_lblicon_add_bottom = new javax.swing.JLabel();
        preferences_filters_lblicon_edit_bottom = new javax.swing.JLabel();
        preferences_filters_lblicon_down_bottom = new javax.swing.JLabel();
        preferences_filters_lblicon_up_scroll = new javax.swing.JScrollPane();
        card_preferences_internetUpdates = new javax.swing.JPanel();
        preferences_internetUpdates_panel_top = new javax.swing.JPanel();
        preferences_internetUpdates_lbl_info = new javax.swing.JLabel();
        preferences_internetUpdates_panel_bottom = new javax.swing.JPanel();
        preferences_internetUpdates_lbl_heading1 = new javax.swing.JLabel();
        preferences_internetUpdatesl_btn_save = new java.awt.Button();
        preferences_internetUpdates_lbl_line = new javax.swing.JLabel();
        preferences_internetUpdates_lbl_heading2 = new javax.swing.JLabel();
        preferences_internetUpdates_cb_notify = new javax.swing.JCheckBox();
        preferences_internetUpdates_cb_automaticUpdates = new javax.swing.JCheckBox();
        preferences_internetUpdates_cb_warning = new javax.swing.JCheckBox();
        preferences_internetUpdates_cb_updateOnLogon = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        preferences_internetUpdates_lbl_downloadSite = new javax.swing.JLabel();
        preferences_internetUpdates_lbl_frequency = new javax.swing.JLabel();
        preferences_internetUpdates_textField_downloadSite = new javax.swing.JTextField();
        preferences_internetUpdates_lbl_day = new javax.swing.JLabel();
        preferences_internetUpdates_spinner_time = new javax.swing.JSpinner();
        preferences_internetUpdates_dropDown_frequency = new javax.swing.JComboBox();
        preferences_internetUpdates_dropDown_day = new javax.swing.JComboBox();
        card_preferences_scheduledScans = new javax.swing.JPanel();
        preferences_scheduledScans_panel_top = new javax.swing.JPanel();
        preferences_scheduledScans_lbl_info = new javax.swing.JLabel();
        preferences_scheduledScans_panel_bottom = new javax.swing.JPanel();
        preferences_scheduledScans_lbl_heading1 = new javax.swing.JLabel();
        preferences_schedulesScans_btn_save = new java.awt.Button();
        preferences_scheduledScans_lbl_line = new javax.swing.JLabel();
        preferences_scheduledScans_lblicon_edit = new javax.swing.JLabel();
        preferences_scheduledScans_lblicon_add = new javax.swing.JLabel();
        preferences_scheduledScans_lblicon_delete = new javax.swing.JLabel();
        preferences_scheduledScans_btn_activate = new java.awt.Button();
        preferences_scheduledScans_btn_deactivate = new java.awt.Button();
        preferences_scheduledScans_scrollPane = new javax.swing.JScrollPane();
        card_preferences_fileLocations = new javax.swing.JPanel();
        preferences_fileLocations_panel_info = new javax.swing.JPanel();
        preferences_fileLocations_lbl_info = new javax.swing.JLabel();
        preferences_fileLocations_panel_bottom = new javax.swing.JPanel();
        preferences_fileLocations_lbl_heaading1 = new javax.swing.JLabel();
        preferences_fileLocations_btn_save = new java.awt.Button();
        preferences_fileLocations_lbl_line = new javax.swing.JLabel();
        preferences_fileLocations_textField_databaseLocation = new javax.swing.JTextField();
        preferences_fileLocations_textField_scanLocation = new javax.swing.JTextField();
        preferences_fileLocations_textField_freshLocation = new javax.swing.JTextField();
        preferences_fileLocations_lbl_heaading2 = new javax.swing.JLabel();
        preferences_fileLocations_lbl_heaading3 = new javax.swing.JLabel();
        preferences_fileLocations_lblicon_databaseLocationBrowse = new javax.swing.JLabel();
        preferences_fileLocations_lblicon_freshLocationBrowse = new javax.swing.JLabel();
        preferences_fileLocations_lblicon_scanLocationBrowse = new javax.swing.JLabel();
        card_preferences_emailAlerts = new javax.swing.JPanel();
        preferences_emailAlerts_panel_top = new javax.swing.JPanel();
        preferences_emailAlerts_lbl_info = new javax.swing.JLabel();
        preferences_emailAlerts_lbl_bottom = new javax.swing.JPanel();
        preferences_emailAlerts_lbl_heading1 = new javax.swing.JLabel();
        preferences_emailAlerts_btn_save = new java.awt.Button();
        preferences_emailAlerts_lbl_line = new javax.swing.JLabel();
        preferences_emailAlerts_cb_email = new javax.swing.JCheckBox();
        preferences_emailAlerts_lbl_heading2 = new javax.swing.JLabel();
        preferences_emailAlerts_btn_sendTestEmail = new java.awt.Button();
        preferences_emailAlerts_lbl_subject = new javax.swing.JLabel();
        preferences_emailAlerts_lbl_from = new javax.swing.JLabel();
        preferences_emailAlerts_lbl_to = new javax.swing.JLabel();
        preferences_emailAlerts_lbl_password = new javax.swing.JLabel();
        preferences_emailAlerts_lbl_username = new javax.swing.JLabel();
        preferences_emailAlerts_lbl_port = new javax.swing.JLabel();
        preferences_emailAlerts_lbl_mailServer = new javax.swing.JLabel();
        preferences_emailAlerts_textField_subject = new javax.swing.JTextField();
        preferences_emailAlerts_textField_port = new javax.swing.JTextField();
        preferences_emailAlerts_textField_username = new javax.swing.JTextField();
        preferences_emailAlerts_textField_to = new javax.swing.JTextField();
        preferences_emailAlerts_textField_from = new javax.swing.JTextField();
        preferences_emailAlerts_textField_mailServer = new javax.swing.JTextField();
        preferences_emailAlerts_textField_password = new javax.swing.JPasswordField();
        card_preferences_emailScanning = new javax.swing.JPanel();
        preferences_emailScan_panel_top = new javax.swing.JPanel();
        preferences_emailScan_lbl_info = new javax.swing.JLabel();
        preferences_emailScan_panel_bottom = new javax.swing.JPanel();
        preferences_emailScan_lbl_heading1 = new javax.swing.JLabel();
        preferences_emailScan_btn_save = new java.awt.Button();
        preferences_emailScan_lbl_line = new javax.swing.JLabel();
        preferences_internetUpdates_cb_automaticUpdates1 = new javax.swing.JCheckBox();
        preferences_internetUpdates_cb_automaticUpdates2 = new javax.swing.JCheckBox();
        preferences_internetUpdates_cb_automaticUpdates3 = new javax.swing.JCheckBox();
        card_preferences_limits = new javax.swing.JPanel();
        preferences_limits_panel_top = new javax.swing.JPanel();
        preferences_limits_lbl_info = new javax.swing.JLabel();
        preferences_limits_panel_bottom = new javax.swing.JPanel();
        preferences_limits_lbl_heading1 = new javax.swing.JLabel();
        preferences_limits_btn_save = new java.awt.Button();
        preferences_limits_lbl_line = new javax.swing.JLabel();
        preferences_limits_cb_extractFromArchives = new javax.swing.JCheckBox();
        preferences_limits_lbl_heading2 = new javax.swing.JLabel();
        preferences_limits_lbl_doNotExtractMoreThan1 = new javax.swing.JLabel();
        preferences_limits_lbl_doNotScanMoreThan = new javax.swing.JLabel();
        preferences_limits_lbl_megabytes2 = new javax.swing.JLabel();
        preferences_limits_lbl_doNotExtractMoreThan2 = new javax.swing.JLabel();
        preferences_limits_lbl_doNotExtractMoreThan3 = new javax.swing.JLabel();
        preferences_limits_lbl_files = new javax.swing.JLabel();
        preferences_limits_lbl_subArchives = new javax.swing.JLabel();
        preferences_limits_lbl_megabytes1 = new javax.swing.JLabel();
        preferences_limits_spinner2 = new javax.swing.JSpinner();
        preferences_limits_spinner1 = new javax.swing.JSpinner();
        preferences_limits_spinner3 = new javax.swing.JSpinner();
        preferences_limits_spinner4 = new javax.swing.JSpinner();
        card_preferences_reports = new javax.swing.JPanel();
        preferences_reports_panel_top = new javax.swing.JPanel();
        preferences_reports_lbl_info = new javax.swing.JLabel();
        preferences_reports_panel_bottom = new javax.swing.JPanel();
        preferences_reports_lbl_heading1 = new javax.swing.JLabel();
        preferences_reports_btn_save = new java.awt.Button();
        preferences_reports_lbl_line = new javax.swing.JLabel();
        preferences_reports_lbl_heading2 = new javax.swing.JLabel();
        preferences_reports_textField_databaseReport = new javax.swing.JTextField();
        preferences_reports_lblicon_databaseReport = new javax.swing.JLabel();
        preferences_reports_textField_scanReport = new javax.swing.JTextField();
        preferences_reports_lblicon_scanReport = new javax.swing.JLabel();
        preferences_reports_cb_popUpNotification = new javax.swing.JCheckBox();
        card_preferences_proxy = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        preferences_proxy_panel_top = new javax.swing.JLabel();
        preferences_proxy_panel_bottom = new javax.swing.JPanel();
        preferences_proxy_lbl_heading1 = new javax.swing.JLabel();
        preferences_proxy_btn_save = new java.awt.Button();
        preferences_proxy_lbl_line = new javax.swing.JLabel();
        preferences_proxy_lbl_heading2 = new javax.swing.JLabel();
        preferences_proxy_lbl_proxyServer = new javax.swing.JLabel();
        preferences_proxy_textField_proxyServer = new javax.swing.JTextField();
        preferences_proxy_lbl_port = new javax.swing.JLabel();
        preferences_proxy_textField_port = new javax.swing.JTextField();
        preferences_proxy_lbl_username = new javax.swing.JLabel();
        preferences_proxy_textField_username = new javax.swing.JTextField();
        preferences_proxy_lbl_password = new javax.swing.JLabel();
        preferences_proxy_textField_password = new javax.swing.JPasswordField();
        card_preferences_advanced = new javax.swing.JPanel();
        preferences_advanced_panel_top = new javax.swing.JPanel();
        preferences_advanced_lbl_info = new javax.swing.JLabel();
        preferences_advanced_panel_bottom = new javax.swing.JPanel();
        preferences_advanced_btn_save = new java.awt.Button();
        preferences_advanced_lbl_line = new javax.swing.JLabel();
        preferences_advanced_cb_extractAttachments = new javax.swing.JCheckBox();
        preferences_advanced_lbl_megaBytes = new javax.swing.JLabel();
        preferences_advanced_textField_additional = new javax.swing.JTextField();
        preferences_advanced_lbl_scannerPriority = new javax.swing.JLabel();
        preferences_advanced_lbl_additional = new javax.swing.JLabel();
        preferences_advanced_lbl_logFileSize = new javax.swing.JLabel();
        preferences_advanced_combo_scanningPriority = new javax.swing.JComboBox();
        preferences_advanced_spinner_logFileSize = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_preferences_top.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_preferences_titile.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lbl_preferences_titile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_preferences_titile.setText("ClamWin Preferences");
        lbl_preferences_titile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panel_preferences_top.add(lbl_preferences_titile, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 670, 20));

        lbl_btn_preferences_minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_btn_preferences_minimizeMouseClicked(evt);
            }
        });
        panel_preferences_top.add(lbl_btn_preferences_minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 20, 10));

        lbl_btn_preferences_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_btn_preferences_closeMouseClicked(evt);
            }
        });
        panel_preferences_top.add(lbl_btn_preferences_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 20, 20));

        getContentPane().add(panel_preferences_top, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 20));

        panel_preferences_left.setBackground(new java.awt.Color(64, 55, 110));
        panel_preferences_left.setPreferredSize(new java.awt.Dimension(195, 500));
        panel_preferences_left.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_preferences_left_filters.setBackground(new java.awt.Color(107, 91, 170));
        panel_preferences_left_filters.setToolTipText(null);
        panel_preferences_left_filters.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_preferences_left_filters.setPreferredSize(new java.awt.Dimension(195, 37));
        panel_preferences_left_filters.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_preferences_left_filtersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_preferences_left_filtersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_preferences_left_filtersMouseExited(evt);
            }
        });
        panel_preferences_left_filters.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_preferences_left_filters.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        lbl_preferences_left_filters.setForeground(new java.awt.Color(255, 255, 255));
        lbl_preferences_left_filters.setText("Filters");
        panel_preferences_left_filters.add(lbl_preferences_left_filters, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        panel_preferences_left.add(panel_preferences_left_filters, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 84, 195, 34));

        panel_preferences_left_advanced.setBackground(new java.awt.Color(107, 91, 170));
        panel_preferences_left_advanced.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_preferences_left_advanced.setPreferredSize(new java.awt.Dimension(195, 37));
        panel_preferences_left_advanced.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_preferences_left_advancedMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_preferences_left_advancedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_preferences_left_advancedMouseExited(evt);
            }
        });
        panel_preferences_left_advanced.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_preferences_left_advanced.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        lbl_preferences_left_advanced.setForeground(new java.awt.Color(255, 255, 255));
        lbl_preferences_left_advanced.setText("Advanced");
        panel_preferences_left_advanced.add(lbl_preferences_left_advanced, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        panel_preferences_left.add(panel_preferences_left_advanced, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 195, 34));

        panel_preferences_left_proxy.setBackground(new java.awt.Color(107, 91, 170));
        panel_preferences_left_proxy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_preferences_left_proxy.setPreferredSize(new java.awt.Dimension(195, 37));
        panel_preferences_left_proxy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_preferences_left_proxyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_preferences_left_proxyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_preferences_left_proxyMouseExited(evt);
            }
        });
        panel_preferences_left_proxy.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_preferences_left_proxy.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        lbl_preferences_left_proxy.setForeground(new java.awt.Color(255, 255, 255));
        lbl_preferences_left_proxy.setText("Proxy");
        panel_preferences_left_proxy.add(lbl_preferences_left_proxy, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        panel_preferences_left.add(panel_preferences_left_proxy, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 356, 195, 34));

        panel_preferences_left_reports.setBackground(new java.awt.Color(107, 91, 170));
        panel_preferences_left_reports.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_preferences_left_reports.setPreferredSize(new java.awt.Dimension(195, 37));
        panel_preferences_left_reports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_preferences_left_reportsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_preferences_left_reportsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_preferences_left_reportsMouseExited(evt);
            }
        });
        panel_preferences_left_reports.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_preferences_left_reports.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        lbl_preferences_left_reports.setForeground(new java.awt.Color(255, 255, 255));
        lbl_preferences_left_reports.setText("Reports");
        panel_preferences_left_reports.add(lbl_preferences_left_reports, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        panel_preferences_left.add(panel_preferences_left_reports, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 322, 195, 34));

        panel_preferences_left_limits.setBackground(new java.awt.Color(107, 91, 170));
        panel_preferences_left_limits.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_preferences_left_limits.setPreferredSize(new java.awt.Dimension(195, 37));
        panel_preferences_left_limits.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_preferences_left_limitsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_preferences_left_limitsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_preferences_left_limitsMouseExited(evt);
            }
        });
        panel_preferences_left_limits.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_preferences_left_limits.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        lbl_preferences_left_limits.setForeground(new java.awt.Color(255, 255, 255));
        lbl_preferences_left_limits.setText("Limits");
        panel_preferences_left_limits.add(lbl_preferences_left_limits, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        panel_preferences_left.add(panel_preferences_left_limits, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 288, 195, 34));

        panel_preferences_left_emailScanning.setBackground(new java.awt.Color(107, 91, 170));
        panel_preferences_left_emailScanning.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_preferences_left_emailScanning.setPreferredSize(new java.awt.Dimension(195, 37));
        panel_preferences_left_emailScanning.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_preferences_left_emailScanningMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_preferences_left_emailScanningMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_preferences_left_emailScanningMouseExited(evt);
            }
        });
        panel_preferences_left_emailScanning.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_preferences_left_emailScanning.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        lbl_preferences_left_emailScanning.setForeground(new java.awt.Color(255, 255, 255));
        lbl_preferences_left_emailScanning.setText("Email Scanning");
        panel_preferences_left_emailScanning.add(lbl_preferences_left_emailScanning, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        panel_preferences_left.add(panel_preferences_left_emailScanning, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 254, 195, 34));

        panel_preferences_left_fileLocations.setBackground(new java.awt.Color(107, 91, 170));
        panel_preferences_left_fileLocations.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_preferences_left_fileLocations.setPreferredSize(new java.awt.Dimension(195, 37));
        panel_preferences_left_fileLocations.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_preferences_left_fileLocationsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_preferences_left_fileLocationsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_preferences_left_fileLocationsMouseExited(evt);
            }
        });
        panel_preferences_left_fileLocations.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_preferences_left_fileLocations.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        lbl_preferences_left_fileLocations.setForeground(new java.awt.Color(255, 255, 255));
        lbl_preferences_left_fileLocations.setText("File Locations");
        panel_preferences_left_fileLocations.add(lbl_preferences_left_fileLocations, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        panel_preferences_left.add(panel_preferences_left_fileLocations, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 186, 195, 34));

        panel_preferences_left_emailAlerts.setBackground(new java.awt.Color(107, 91, 170));
        panel_preferences_left_emailAlerts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_preferences_left_emailAlerts.setPreferredSize(new java.awt.Dimension(195, 37));
        panel_preferences_left_emailAlerts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_preferences_left_emailAlertsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_preferences_left_emailAlertsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_preferences_left_emailAlertsMouseExited(evt);
            }
        });
        panel_preferences_left_emailAlerts.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_preferences_left_emailAlerts.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        lbl_preferences_left_emailAlerts.setForeground(new java.awt.Color(255, 255, 255));
        lbl_preferences_left_emailAlerts.setText("Email Alerts");
        panel_preferences_left_emailAlerts.add(lbl_preferences_left_emailAlerts, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        panel_preferences_left.add(panel_preferences_left_emailAlerts, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 195, 34));

        panel_preferences_left_InternetUpdates.setBackground(new java.awt.Color(107, 91, 170));
        panel_preferences_left_InternetUpdates.setToolTipText(null);
        panel_preferences_left_InternetUpdates.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_preferences_left_InternetUpdates.setPreferredSize(new java.awt.Dimension(195, 37));
        panel_preferences_left_InternetUpdates.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_preferences_left_InternetUpdatesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_preferences_left_InternetUpdatesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_preferences_left_InternetUpdatesMouseExited(evt);
            }
        });
        panel_preferences_left_InternetUpdates.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_preferences_left_internetUpdates.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        lbl_preferences_left_internetUpdates.setForeground(new java.awt.Color(255, 255, 255));
        lbl_preferences_left_internetUpdates.setText("Internet Updates");
        panel_preferences_left_InternetUpdates.add(lbl_preferences_left_internetUpdates, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        panel_preferences_left.add(panel_preferences_left_InternetUpdates, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 118, 195, 34));

        panel_preferences_left_mainMenu.setBackground(new java.awt.Color(107, 91, 170));
        panel_preferences_left_mainMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_preferences_left_mainMenu.setPreferredSize(new java.awt.Dimension(195, 37));
        panel_preferences_left_mainMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_preferences_left_mainMenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_preferences_left_mainMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_preferences_left_mainMenuMouseExited(evt);
            }
        });
        panel_preferences_left_mainMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_preferences_left_mainMenu.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        lbl_preferences_left_mainMenu.setForeground(new java.awt.Color(255, 255, 255));
        lbl_preferences_left_mainMenu.setText("Main Menu");
        panel_preferences_left_mainMenu.add(lbl_preferences_left_mainMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        panel_preferences_left.add(panel_preferences_left_mainMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 424, 195, 34));

        panel_preferences_left_scheduledScans.setBackground(new java.awt.Color(107, 91, 170));
        panel_preferences_left_scheduledScans.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_preferences_left_scheduledScans.setPreferredSize(new java.awt.Dimension(195, 37));
        panel_preferences_left_scheduledScans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_preferences_left_scheduledScansMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_preferences_left_scheduledScansMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_preferences_left_scheduledScansMouseExited(evt);
            }
        });
        panel_preferences_left_scheduledScans.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_preferences_left_scheduledScans.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        lbl_preferences_left_scheduledScans.setForeground(new java.awt.Color(255, 255, 255));
        lbl_preferences_left_scheduledScans.setText("Scheduled Scans");
        panel_preferences_left_scheduledScans.add(lbl_preferences_left_scheduledScans, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        panel_preferences_left.add(panel_preferences_left_scheduledScans, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 152, 195, 34));

        panel_preferences_left_general.setBackground(new java.awt.Color(107, 91, 170));
        panel_preferences_left_general.setBorder(border);
        panel_preferences_left_general.setToolTipText(null);
        panel_preferences_left_general.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_preferences_left_general.setPreferredSize(new java.awt.Dimension(195, 37));
        panel_preferences_left_general.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_preferences_left_generalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_preferences_left_generalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_preferences_left_generalMouseExited(evt);
            }
        });
        panel_preferences_left_general.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_preferences_left_general.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        lbl_preferences_left_general.setForeground(new java.awt.Color(255, 255, 255));
        lbl_preferences_left_general.setText("General");
        panel_preferences_left_general.add(lbl_preferences_left_general, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        panel_preferences_left.add(panel_preferences_left_general, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 195, 34));

        getContentPane().add(panel_preferences_left, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, 500));

        panel_preferences_right.setBackground(new java.awt.Color(0, 102, 51));
        panel_preferences_right.setPreferredSize(new java.awt.Dimension(585, 500));
        panel_preferences_right.setLayout(new java.awt.CardLayout());

        card_preferences_general.setBackground(new java.awt.Color(64, 55, 110));
        card_preferences_general.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(107, 87, 146));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        preferences_general_lbl_info.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        preferences_general_lbl_info.setForeground(new java.awt.Color(255, 255, 255));
        preferences_general_lbl_info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        preferences_general_lbl_info.setText("<html><div style='text-align:center'> The General preferences allows you to customize the scanning and allows you  to specify ClamWin on how to deal with the infected files</div></html>");
        preferences_general_lbl_info.setToolTipText("");
        preferences_general_lbl_info.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(preferences_general_lbl_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 550, 80));

        card_preferences_general.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 585, 80));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        preferences_general_lbl_heading1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        preferences_general_lbl_heading1.setText("Scanning Options");
        jPanel2.add(preferences_general_lbl_heading1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        preferences_general_btn_save.setBackground(new java.awt.Color(173, 159, 175));
        preferences_general_btn_save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        preferences_general_btn_save.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        preferences_general_btn_save.setForeground(new java.awt.Color(22, 89, 45));
        preferences_general_btn_save.setLabel("Save Changes");
        preferences_general_btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_general_btn_saveActionPerformed(evt);
            }
        });
        jPanel2.add(preferences_general_btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 130, 40));

        preferences_general_lblicon_line.setText("line");
        jPanel2.add(preferences_general_lblicon_line, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 450, 10));

        preferences_general_cb_subDirectories.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        preferences_general_cb_subDirectories.setText("Infected Files");
        jPanel2.add(preferences_general_cb_subDirectories, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        preferences_general_cb_unload.setBackground(new java.awt.Color(204, 204, 204));
        preferences_general_cb_unload.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        preferences_general_cb_unload.setText("Unload infected files from computer memory");
        preferences_general_cb_unload.setToolTipText("Select if you wih to unload infeted files fromt the memory so that they can be removed or quarantied");
        preferences_general_cb_unload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_general_cb_unloadActionPerformed(evt);
            }
        });
        jPanel2.add(preferences_general_cb_unload, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 300, -1));

        preferences_general_cb_displayInfected.setBackground(new java.awt.Color(204, 204, 204));
        preferences_general_cb_displayInfected.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        preferences_general_cb_displayInfected.setText("Display infected files only");
        preferences_general_cb_displayInfected.setToolTipText("Select if you wish to have the infected files only in the scaning status window");
        preferences_general_cb_displayInfected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_general_cb_displayInfectedActionPerformed(evt);
            }
        });
        jPanel2.add(preferences_general_cb_displayInfected, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 250, -1));

        preferences_general_cb_displayProgress.setBackground(new java.awt.Color(204, 204, 204));
        preferences_general_cb_displayProgress.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        preferences_general_cb_displayProgress.setSelected(true);
        preferences_general_cb_displayProgress.setText("Display progress indicator");
        preferences_general_cb_displayProgress.setToolTipText("Select if you wish to display the progrss of the scan");
        preferences_general_cb_displayProgress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_general_cb_displayProgressActionPerformed(evt);
            }
        });
        jPanel2.add(preferences_general_cb_displayProgress, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 250, -1));

        preferences_general_rb_folder.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(preferences_general_rb_folder);
        preferences_general_rb_folder.setText("Move to quarantine folder");
        preferences_general_rb_folder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_general_rb_folderActionPerformed(evt);
            }
        });
        jPanel2.add(preferences_general_rb_folder, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        preferences_general_rb_remove.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(preferences_general_rb_remove);
        preferences_general_rb_remove.setText("Remove (Use with care)");
        preferences_general_rb_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_general_rb_removeActionPerformed(evt);
            }
        });
        jPanel2.add(preferences_general_rb_remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        preferences_general_rb_report.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(preferences_general_rb_report);
        preferences_general_rb_report.setSelected(true);
        preferences_general_rb_report.setText("Report Only");
        preferences_general_rb_report.setToolTipText("");
        preferences_general_rb_report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_general_rb_reportActionPerformed(evt);
            }
        });
        jPanel2.add(preferences_general_rb_report, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        preferences_general_cb_subdirectories.setBackground(new java.awt.Color(204, 204, 204));
        preferences_general_cb_subdirectories.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        preferences_general_cb_subdirectories.setSelected(true);
        preferences_general_cb_subdirectories.setText("Scan in subdirectries");
        preferences_general_cb_subdirectories.setToolTipText("Select if you wish to scan subdirectories recursively");
        preferences_general_cb_subdirectories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_general_cb_subdirectoriesActionPerformed(evt);
            }
        });
        jPanel2.add(preferences_general_cb_subdirectories, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 250, -1));

        preferences_general_textfield1.setEditable(false);
        preferences_general_textfield1.setEnabled(false);
        jPanel2.add(preferences_general_textfield1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 260, 30));

        preferences_general_lblicon_browse.setText("jLabel1");
        preferences_general_lblicon_browse.setToolTipText("Browse to select the quarantine folder");
        preferences_general_lblicon_browse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        preferences_general_lblicon_browse.setEnabled(false);
        preferences_general_lblicon_browse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                preferences_general_lblicon_browseMouseClicked(evt);
            }
        });
        jPanel2.add(preferences_general_lblicon_browse, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, 30, 30));

        card_preferences_general.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 585, 360));

        panel_preferences_right.add(card_preferences_general, "general");

        card_preferences_filters.setBackground(new java.awt.Color(64, 55, 110));
        card_preferences_filters.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(107, 87, 146));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        preferences_filters_lbl_info.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        preferences_filters_lbl_info.setForeground(new java.awt.Color(255, 255, 255));
        preferences_filters_lbl_info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        preferences_filters_lbl_info.setText("<html><div style='text-align:center'> Filtering allows you to specify filename patterns to include / exclude in the scanning process.<br>\n(include pattern with angle brackets for regular expressions)</div></html>");
        preferences_filters_lbl_info.setToolTipText("");
        preferences_filters_lbl_info.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel5.add(preferences_filters_lbl_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 550, 80));

        card_preferences_filters.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 585, 80));

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        preferences_filters_lbl_heading1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        preferences_filters_lbl_heading1.setText("Exclude matching filenames");
        jPanel6.add(preferences_filters_lbl_heading1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        preferences_filters_btn_save.setBackground(new java.awt.Color(173, 159, 175));
        preferences_filters_btn_save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        preferences_filters_btn_save.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        preferences_filters_btn_save.setForeground(new java.awt.Color(22, 89, 45));
        preferences_filters_btn_save.setLabel("Save Changes");
        preferences_filters_btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_filters_btn_saveActionPerformed(evt);
            }
        });
        jPanel6.add(preferences_filters_btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 130, 40));

        preferences_filters_lbl_line.setText("line");
        jPanel6.add(preferences_filters_lbl_line, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 450, 10));

        preferences_filters_lbl_heading2.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        preferences_filters_lbl_heading2.setText("Scan only matching file names");
        jPanel6.add(preferences_filters_lbl_heading2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        preferences_filters_lblicon_up_top.setText("jLabel1");
        preferences_filters_lblicon_up_top.setToolTipText("Move up");
        preferences_filters_lblicon_up_top.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        preferences_filters_lblicon_up_top.setEnabled(false);
        preferences_filters_lblicon_up_top.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                preferences_filters_lblicon_up_topMouseClicked(evt);
            }
        });
        jPanel6.add(preferences_filters_lblicon_up_top, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 30, 30));

        preferences_filters_lblicon_down_top.setText("jLabel2");
        preferences_filters_lblicon_down_top.setToolTipText("Move down");
        preferences_filters_lblicon_down_top.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        preferences_filters_lblicon_down_top.setEnabled(false);
        preferences_filters_lblicon_down_top.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                preferences_filters_lblicon_down_topMouseClicked(evt);
            }
        });
        jPanel6.add(preferences_filters_lblicon_down_top, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 30, 30));

        preferences_filters_lblicon_edit_top.setText("j1");
        preferences_filters_lblicon_edit_top.setToolTipText("Edit Item");
        preferences_filters_lblicon_edit_top.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        preferences_filters_lblicon_edit_top.setEnabled(false);
        preferences_filters_lblicon_edit_top.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                preferences_filters_lblicon_edit_topMouseClicked(evt);
            }
        });
        jPanel6.add(preferences_filters_lblicon_edit_top, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 30, 30));

        preferences_filters_lblicon_add_top.setText("j2");
        preferences_filters_lblicon_add_top.setToolTipText("Add new Item");
        preferences_filters_lblicon_add_top.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        preferences_filters_lblicon_add_top.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                preferences_filters_lblicon_add_topMouseClicked(evt);
            }
        });
        jPanel6.add(preferences_filters_lblicon_add_top, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 30, 30));

        preferences_filters_lblicon_delete_top.setText("jLabel5");
        preferences_filters_lblicon_delete_top.setToolTipText("Delete Item");
        preferences_filters_lblicon_delete_top.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        preferences_filters_lblicon_delete_top.setEnabled(false);
        preferences_filters_lblicon_delete_top.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                preferences_filters_lblicon_delete_topMouseClicked(evt);
            }
        });
        jPanel6.add(preferences_filters_lblicon_delete_top, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 30, 30));
        jPanel6.add(preferences_filters_lblicon_down_scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 210, 80));

        preferences_filters_lblicon_up_bottom.setText("jLabel1");
        preferences_filters_lblicon_up_bottom.setToolTipText("Move up");
        preferences_filters_lblicon_up_bottom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        preferences_filters_lblicon_up_bottom.setEnabled(false);
        preferences_filters_lblicon_up_bottom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                preferences_filters_lblicon_up_bottomMouseClicked(evt);
            }
        });
        jPanel6.add(preferences_filters_lblicon_up_bottom, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 30, 30));

        preferences_filters_lblicon_delete_bottom.setText("jLabel1");
        preferences_filters_lblicon_delete_bottom.setToolTipText("Delete Item");
        preferences_filters_lblicon_delete_bottom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        preferences_filters_lblicon_delete_bottom.setEnabled(false);
        preferences_filters_lblicon_delete_bottom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                preferences_filters_lblicon_delete_bottomMouseClicked(evt);
            }
        });
        jPanel6.add(preferences_filters_lblicon_delete_bottom, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 30, 30));

        preferences_filters_lblicon_add_bottom.setText("jLabel1");
        preferences_filters_lblicon_add_bottom.setToolTipText("Add new Item");
        preferences_filters_lblicon_add_bottom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        preferences_filters_lblicon_add_bottom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                preferences_filters_lblicon_add_bottomMouseClicked(evt);
            }
        });
        jPanel6.add(preferences_filters_lblicon_add_bottom, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 30, 30));

        preferences_filters_lblicon_edit_bottom.setText("jLabel1");
        preferences_filters_lblicon_edit_bottom.setToolTipText("Edit Item");
        preferences_filters_lblicon_edit_bottom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        preferences_filters_lblicon_edit_bottom.setEnabled(false);
        preferences_filters_lblicon_edit_bottom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                preferences_filters_lblicon_edit_bottomMouseClicked(evt);
            }
        });
        jPanel6.add(preferences_filters_lblicon_edit_bottom, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 30, 30));

        preferences_filters_lblicon_down_bottom.setText("jLabel1");
        preferences_filters_lblicon_down_bottom.setToolTipText("Move down");
        preferences_filters_lblicon_down_bottom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        preferences_filters_lblicon_down_bottom.setEnabled(false);
        preferences_filters_lblicon_down_bottom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                preferences_filters_lblicon_down_bottomMouseClicked(evt);
            }
        });
        jPanel6.add(preferences_filters_lblicon_down_bottom, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 30, 30));
        jPanel6.add(preferences_filters_lblicon_up_scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 210, 80));

        card_preferences_filters.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 585, 360));

        panel_preferences_right.add(card_preferences_filters, "filters");

        card_preferences_internetUpdates.setBackground(new java.awt.Color(64, 55, 110));
        card_preferences_internetUpdates.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        preferences_internetUpdates_panel_top.setBackground(new java.awt.Color(107, 87, 146));
        preferences_internetUpdates_panel_top.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        preferences_internetUpdates_lbl_info.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        preferences_internetUpdates_lbl_info.setForeground(new java.awt.Color(255, 255, 255));
        preferences_internetUpdates_lbl_info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        preferences_internetUpdates_lbl_info.setText("<html><div style='text-align:center'> Internet Update allows you to configure virus database update settings</div></html>");
        preferences_internetUpdates_lbl_info.setToolTipText("");
        preferences_internetUpdates_lbl_info.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        preferences_internetUpdates_panel_top.add(preferences_internetUpdates_lbl_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 550, 80));

        card_preferences_internetUpdates.add(preferences_internetUpdates_panel_top, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 585, 80));

        preferences_internetUpdates_panel_bottom.setBackground(new java.awt.Color(204, 204, 204));
        preferences_internetUpdates_panel_bottom.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        preferences_internetUpdates_lbl_heading1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        preferences_internetUpdates_lbl_heading1.setText("Automatic Updates");
        preferences_internetUpdates_panel_bottom.add(preferences_internetUpdates_lbl_heading1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        preferences_internetUpdatesl_btn_save.setBackground(new java.awt.Color(173, 159, 175));
        preferences_internetUpdatesl_btn_save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        preferences_internetUpdatesl_btn_save.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        preferences_internetUpdatesl_btn_save.setForeground(new java.awt.Color(22, 89, 45));
        preferences_internetUpdatesl_btn_save.setLabel("Save Changes");
        preferences_internetUpdatesl_btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_internetUpdatesl_btn_saveActionPerformed(evt);
            }
        });
        preferences_internetUpdates_panel_bottom.add(preferences_internetUpdatesl_btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 130, 40));

        preferences_internetUpdates_lbl_line.setText("line");
        preferences_internetUpdates_panel_bottom.add(preferences_internetUpdates_lbl_line, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 420, 10));

        preferences_internetUpdates_lbl_heading2.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        preferences_internetUpdates_lbl_heading2.setText("Other Update Preferences");
        preferences_internetUpdates_panel_bottom.add(preferences_internetUpdates_lbl_heading2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        preferences_internetUpdates_cb_notify.setBackground(new java.awt.Color(204, 204, 204));
        preferences_internetUpdates_cb_notify.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        preferences_internetUpdates_cb_notify.setSelected(true);
        preferences_internetUpdates_cb_notify.setText("<html>Notify about ClamWin releases <br> (No personal information is transmitted during this check)</html>");
        preferences_internetUpdates_cb_notify.setToolTipText("Select to receive notifications of ClamWin releases");
        preferences_internetUpdates_cb_notify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_internetUpdates_cb_notifyActionPerformed(evt);
            }
        });
        preferences_internetUpdates_panel_bottom.add(preferences_internetUpdates_cb_notify, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 450, 40));

        preferences_internetUpdates_cb_automaticUpdates.setBackground(new java.awt.Color(204, 204, 204));
        preferences_internetUpdates_cb_automaticUpdates.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        preferences_internetUpdates_cb_automaticUpdates.setSelected(true);
        preferences_internetUpdates_cb_automaticUpdates.setText("Enable automatic virus database updates");
        preferences_internetUpdates_cb_automaticUpdates.setToolTipText("Select to enable automatic downloads");
        preferences_internetUpdates_cb_automaticUpdates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_internetUpdates_cb_automaticUpdatesActionPerformed(evt);
            }
        });
        preferences_internetUpdates_panel_bottom.add(preferences_internetUpdates_cb_automaticUpdates, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 340, -1));

        preferences_internetUpdates_cb_warning.setBackground(new java.awt.Color(204, 204, 204));
        preferences_internetUpdates_cb_warning.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        preferences_internetUpdates_cb_warning.setText("Select to receive a reminder if virus database is out of date");
        preferences_internetUpdates_cb_warning.setToolTipText("A reminder will be displayed if database is older than 5 days");
        preferences_internetUpdates_cb_warning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_internetUpdates_cb_warningActionPerformed(evt);
            }
        });
        preferences_internetUpdates_panel_bottom.add(preferences_internetUpdates_cb_warning, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 390, -1));

        preferences_internetUpdates_cb_updateOnLogon.setBackground(new java.awt.Color(204, 204, 204));
        preferences_internetUpdates_cb_updateOnLogon.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        preferences_internetUpdates_cb_updateOnLogon.setText("Update virus database on logon");
        preferences_internetUpdates_cb_updateOnLogon.setToolTipText("Select to update the database on login");
        preferences_internetUpdates_cb_updateOnLogon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_internetUpdates_cb_updateOnLogonActionPerformed(evt);
            }
        });
        preferences_internetUpdates_panel_bottom.add(preferences_internetUpdates_cb_updateOnLogon, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 250, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Time");
        preferences_internetUpdates_panel_bottom.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 40, 20));

        preferences_internetUpdates_lbl_downloadSite.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        preferences_internetUpdates_lbl_downloadSite.setText("Download Site");
        preferences_internetUpdates_lbl_downloadSite.setToolTipText("Specify download site of the database");
        preferences_internetUpdates_panel_bottom.add(preferences_internetUpdates_lbl_downloadSite, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        preferences_internetUpdates_lbl_frequency.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        preferences_internetUpdates_lbl_frequency.setText("Update Frequency");
        preferences_internetUpdates_panel_bottom.add(preferences_internetUpdates_lbl_frequency, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, 20));

        preferences_internetUpdates_textField_downloadSite.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        preferences_internetUpdates_textField_downloadSite.setText("database.clamav.net");
        preferences_internetUpdates_panel_bottom.add(preferences_internetUpdates_textField_downloadSite, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 260, -1));

        preferences_internetUpdates_lbl_day.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        preferences_internetUpdates_lbl_day.setText("Day of the week");
        preferences_internetUpdates_panel_bottom.add(preferences_internetUpdates_lbl_day, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, 20));

        preferences_internetUpdates_spinner_time.setModel(new javax.swing.SpinnerNumberModel());
        preferences_internetUpdates_panel_bottom.add(preferences_internetUpdates_spinner_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 90, -1));

        preferences_internetUpdates_dropDown_frequency.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hourly", "Daily", "Workdays", "Weekly" }));
        preferences_internetUpdates_dropDown_frequency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_internetUpdates_dropDown_frequencyActionPerformed(evt);
            }
        });
        preferences_internetUpdates_panel_bottom.add(preferences_internetUpdates_dropDown_frequency, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 120, 20));

        preferences_internetUpdates_dropDown_day.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));
        preferences_internetUpdates_dropDown_day.setEnabled(false);
        preferences_internetUpdates_panel_bottom.add(preferences_internetUpdates_dropDown_day, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 120, -1));

        card_preferences_internetUpdates.add(preferences_internetUpdates_panel_bottom, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 585, 360));

        panel_preferences_right.add(card_preferences_internetUpdates, "internetUpdates");

        card_preferences_scheduledScans.setBackground(new java.awt.Color(64, 55, 110));
        card_preferences_scheduledScans.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        preferences_scheduledScans_panel_top.setBackground(new java.awt.Color(107, 87, 146));
        preferences_scheduledScans_panel_top.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        preferences_scheduledScans_lbl_info.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        preferences_scheduledScans_lbl_info.setForeground(new java.awt.Color(255, 255, 255));
        preferences_scheduledScans_lbl_info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        preferences_scheduledScans_lbl_info.setText("<html><div style='text-align:center'>Scheduled scans allow you to configure scan frequencies for a particular path</div></html>");
        preferences_scheduledScans_lbl_info.setToolTipText("");
        preferences_scheduledScans_lbl_info.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        preferences_scheduledScans_panel_top.add(preferences_scheduledScans_lbl_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 550, 80));

        card_preferences_scheduledScans.add(preferences_scheduledScans_panel_top, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 585, 80));

        preferences_scheduledScans_panel_bottom.setBackground(new java.awt.Color(204, 204, 204));
        preferences_scheduledScans_panel_bottom.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        preferences_scheduledScans_lbl_heading1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        preferences_scheduledScans_lbl_heading1.setText("Scheduled Scans");
        preferences_scheduledScans_panel_bottom.add(preferences_scheduledScans_lbl_heading1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        preferences_schedulesScans_btn_save.setBackground(new java.awt.Color(173, 159, 175));
        preferences_schedulesScans_btn_save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        preferences_schedulesScans_btn_save.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        preferences_schedulesScans_btn_save.setForeground(new java.awt.Color(22, 89, 45));
        preferences_schedulesScans_btn_save.setLabel("Save Changes");
        preferences_schedulesScans_btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_schedulesScans_btn_saveActionPerformed(evt);
            }
        });
        preferences_scheduledScans_panel_bottom.add(preferences_schedulesScans_btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 130, 40));

        preferences_scheduledScans_lbl_line.setText("line");
        preferences_scheduledScans_panel_bottom.add(preferences_scheduledScans_lbl_line, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 460, 10));

        preferences_scheduledScans_lblicon_edit.setText("jLabel2");
        preferences_scheduledScans_lblicon_edit.setToolTipText("Edit a scheduled scan");
        preferences_scheduledScans_lblicon_edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        preferences_scheduledScans_lblicon_edit.setEnabled(false);
        preferences_scheduledScans_lblicon_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                preferences_scheduledScans_lblicon_editMouseClicked(evt);
            }
        });
        preferences_scheduledScans_panel_bottom.add(preferences_scheduledScans_lblicon_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 30, 30));

        preferences_scheduledScans_lblicon_add.setText("jLabel3");
        preferences_scheduledScans_lblicon_add.setToolTipText("Add a new scheduled scan");
        preferences_scheduledScans_lblicon_add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        preferences_scheduledScans_lblicon_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                preferences_scheduledScans_lblicon_addMouseClicked(evt);
            }
        });
        preferences_scheduledScans_panel_bottom.add(preferences_scheduledScans_lblicon_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 40, 30));

        preferences_scheduledScans_lblicon_delete.setText("jLabel4");
        preferences_scheduledScans_lblicon_delete.setToolTipText("Remove new scheduled scan");
        preferences_scheduledScans_lblicon_delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        preferences_scheduledScans_lblicon_delete.setEnabled(false);
        preferences_scheduledScans_lblicon_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                preferences_scheduledScans_lblicon_deleteMouseClicked(evt);
            }
        });
        preferences_scheduledScans_panel_bottom.add(preferences_scheduledScans_lblicon_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 30, 30));

        preferences_scheduledScans_btn_activate.setBackground(new java.awt.Color(187, 176, 189));
        preferences_scheduledScans_btn_activate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        preferences_scheduledScans_btn_activate.setEnabled(false);
        preferences_scheduledScans_btn_activate.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        preferences_scheduledScans_btn_activate.setForeground(new java.awt.Color(28, 111, 56));
        preferences_scheduledScans_btn_activate.setLabel("Activate");
        preferences_scheduledScans_btn_activate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_scheduledScans_btn_activateActionPerformed(evt);
            }
        });
        preferences_scheduledScans_panel_bottom.add(preferences_scheduledScans_btn_activate, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 66, 90, 30));

        preferences_scheduledScans_btn_deactivate.setBackground(new java.awt.Color(187, 176, 189));
        preferences_scheduledScans_btn_deactivate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        preferences_scheduledScans_btn_deactivate.setEnabled(false);
        preferences_scheduledScans_btn_deactivate.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        preferences_scheduledScans_btn_deactivate.setForeground(new java.awt.Color(253, 0, 0));
        preferences_scheduledScans_btn_deactivate.setLabel("Deactivate");
        preferences_scheduledScans_btn_deactivate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_scheduledScans_btn_deactivateActionPerformed(evt);
            }
        });
        preferences_scheduledScans_panel_bottom.add(preferences_scheduledScans_btn_deactivate, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 66, -1, 30));
        preferences_scheduledScans_panel_bottom.add(preferences_scheduledScans_scrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 460, 160));

        card_preferences_scheduledScans.add(preferences_scheduledScans_panel_bottom, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 585, 360));

        panel_preferences_right.add(card_preferences_scheduledScans, "scheduledScans");

        card_preferences_fileLocations.setBackground(new java.awt.Color(64, 55, 110));
        card_preferences_fileLocations.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        preferences_fileLocations_panel_info.setBackground(new java.awt.Color(107, 87, 146));
        preferences_fileLocations_panel_info.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        preferences_fileLocations_lbl_info.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        preferences_fileLocations_lbl_info.setForeground(new java.awt.Color(255, 255, 255));
        preferences_fileLocations_lbl_info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        preferences_fileLocations_lbl_info.setText("<html><div style='text-align:center'> File locations allow you to specify ClamScan, ClamFresh and Virus Database locations</div></html>");
        preferences_fileLocations_lbl_info.setToolTipText("");
        preferences_fileLocations_lbl_info.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        preferences_fileLocations_panel_info.add(preferences_fileLocations_lbl_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 550, 80));

        card_preferences_fileLocations.add(preferences_fileLocations_panel_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 585, 80));

        preferences_fileLocations_panel_bottom.setBackground(new java.awt.Color(204, 204, 204));
        preferences_fileLocations_panel_bottom.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        preferences_fileLocations_lbl_heaading1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        preferences_fileLocations_lbl_heaading1.setText("ClamScan Location");
        preferences_fileLocations_panel_bottom.add(preferences_fileLocations_lbl_heaading1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        preferences_fileLocations_btn_save.setBackground(new java.awt.Color(173, 159, 175));
        preferences_fileLocations_btn_save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        preferences_fileLocations_btn_save.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        preferences_fileLocations_btn_save.setForeground(new java.awt.Color(22, 89, 45));
        preferences_fileLocations_btn_save.setLabel("Save Changes");
        preferences_fileLocations_btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_fileLocations_btn_saveActionPerformed(evt);
            }
        });
        preferences_fileLocations_panel_bottom.add(preferences_fileLocations_btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 130, 40));

        preferences_fileLocations_lbl_line.setText("line");
        preferences_fileLocations_panel_bottom.add(preferences_fileLocations_lbl_line, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 420, 10));

        preferences_fileLocations_textField_databaseLocation.setEditable(false);
        preferences_fileLocations_textField_databaseLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_fileLocations_textField_databaseLocationActionPerformed(evt);
            }
        });
        preferences_fileLocations_panel_bottom.add(preferences_fileLocations_textField_databaseLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 370, 30));

        preferences_fileLocations_textField_scanLocation.setEditable(false);
        preferences_fileLocations_panel_bottom.add(preferences_fileLocations_textField_scanLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 370, 30));

        preferences_fileLocations_textField_freshLocation.setEditable(false);
        preferences_fileLocations_panel_bottom.add(preferences_fileLocations_textField_freshLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 370, 30));

        preferences_fileLocations_lbl_heaading2.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        preferences_fileLocations_lbl_heaading2.setText("FreshClam Location");
        preferences_fileLocations_panel_bottom.add(preferences_fileLocations_lbl_heaading2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        preferences_fileLocations_lbl_heaading3.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        preferences_fileLocations_lbl_heaading3.setText("Virus Database Folder");
        preferences_fileLocations_panel_bottom.add(preferences_fileLocations_lbl_heaading3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, -1));

        preferences_fileLocations_lblicon_databaseLocationBrowse.setText("jLabel2");
        preferences_fileLocations_lblicon_databaseLocationBrowse.setToolTipText("Browse for location");
        preferences_fileLocations_lblicon_databaseLocationBrowse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        preferences_fileLocations_lblicon_databaseLocationBrowse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                preferences_fileLocations_lblicon_databaseLocationBrowseMouseClicked(evt);
            }
        });
        preferences_fileLocations_panel_bottom.add(preferences_fileLocations_lblicon_databaseLocationBrowse, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, 30, 30));

        preferences_fileLocations_lblicon_freshLocationBrowse.setText("jLabel2");
        preferences_fileLocations_lblicon_freshLocationBrowse.setToolTipText("Browse for location");
        preferences_fileLocations_lblicon_freshLocationBrowse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        preferences_fileLocations_lblicon_freshLocationBrowse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                preferences_fileLocations_lblicon_freshLocationBrowseMouseClicked(evt);
            }
        });
        preferences_fileLocations_panel_bottom.add(preferences_fileLocations_lblicon_freshLocationBrowse, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 30, 30));

        preferences_fileLocations_lblicon_scanLocationBrowse.setText("jLabel2");
        preferences_fileLocations_lblicon_scanLocationBrowse.setToolTipText("Browse for location");
        preferences_fileLocations_lblicon_scanLocationBrowse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        preferences_fileLocations_lblicon_scanLocationBrowse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                preferences_fileLocations_lblicon_scanLocationBrowseMouseClicked(evt);
            }
        });
        preferences_fileLocations_panel_bottom.add(preferences_fileLocations_lblicon_scanLocationBrowse, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 30, 30));

        card_preferences_fileLocations.add(preferences_fileLocations_panel_bottom, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 585, 360));

        panel_preferences_right.add(card_preferences_fileLocations, "fileLocations");

        card_preferences_emailAlerts.setBackground(new java.awt.Color(64, 55, 110));
        card_preferences_emailAlerts.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        preferences_emailAlerts_panel_top.setBackground(new java.awt.Color(107, 87, 146));
        preferences_emailAlerts_panel_top.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        preferences_emailAlerts_lbl_info.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        preferences_emailAlerts_lbl_info.setForeground(new java.awt.Color(255, 255, 255));
        preferences_emailAlerts_lbl_info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        preferences_emailAlerts_lbl_info.setText("<html><div style='text-align:center'> Email alerts allow you to choose whether or not to inform you via email if a virus is detected</div></html>");
        preferences_emailAlerts_lbl_info.setToolTipText("");
        preferences_emailAlerts_lbl_info.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        preferences_emailAlerts_panel_top.add(preferences_emailAlerts_lbl_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 550, 80));

        card_preferences_emailAlerts.add(preferences_emailAlerts_panel_top, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 585, 80));

        preferences_emailAlerts_lbl_bottom.setBackground(new java.awt.Color(204, 204, 204));
        preferences_emailAlerts_lbl_bottom.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        preferences_emailAlerts_lbl_heading1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        preferences_emailAlerts_lbl_heading1.setText("SMTP Connection details");
        preferences_emailAlerts_lbl_bottom.add(preferences_emailAlerts_lbl_heading1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, 30));

        preferences_emailAlerts_btn_save.setBackground(new java.awt.Color(173, 159, 175));
        preferences_emailAlerts_btn_save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        preferences_emailAlerts_btn_save.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        preferences_emailAlerts_btn_save.setForeground(new java.awt.Color(22, 89, 45));
        preferences_emailAlerts_btn_save.setLabel("Save Changes");
        preferences_emailAlerts_btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_emailAlerts_btn_saveActionPerformed(evt);
            }
        });
        preferences_emailAlerts_lbl_bottom.add(preferences_emailAlerts_btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 130, 40));

        preferences_emailAlerts_lbl_line.setText("line");
        preferences_emailAlerts_lbl_bottom.add(preferences_emailAlerts_lbl_line, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 420, 10));

        preferences_emailAlerts_cb_email.setBackground(new java.awt.Color(204, 204, 204));
        preferences_emailAlerts_cb_email.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        preferences_emailAlerts_cb_email.setSelected(true);
        preferences_emailAlerts_cb_email.setText("Send email alert on virus detection");
        preferences_emailAlerts_cb_email.setToolTipText("Select to have an email delivered on virus detection");
        preferences_emailAlerts_cb_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_emailAlerts_cb_emailActionPerformed(evt);
            }
        });
        preferences_emailAlerts_lbl_bottom.add(preferences_emailAlerts_cb_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 340, -1));

        preferences_emailAlerts_lbl_heading2.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        preferences_emailAlerts_lbl_heading2.setText("Email Message Details");
        preferences_emailAlerts_lbl_bottom.add(preferences_emailAlerts_lbl_heading2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        preferences_emailAlerts_btn_sendTestEmail.setBackground(new java.awt.Color(173, 159, 175));
        preferences_emailAlerts_btn_sendTestEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        preferences_emailAlerts_btn_sendTestEmail.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        preferences_emailAlerts_btn_sendTestEmail.setForeground(new java.awt.Color(151, 103, 12));
        preferences_emailAlerts_btn_sendTestEmail.setLabel("Send Test Email");
        preferences_emailAlerts_btn_sendTestEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_emailAlerts_btn_sendTestEmailActionPerformed(evt);
            }
        });
        preferences_emailAlerts_lbl_bottom.add(preferences_emailAlerts_btn_sendTestEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 140, 40));

        preferences_emailAlerts_lbl_subject.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        preferences_emailAlerts_lbl_subject.setText("Subject");
        preferences_emailAlerts_lbl_bottom.add(preferences_emailAlerts_lbl_subject, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, 20));

        preferences_emailAlerts_lbl_from.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        preferences_emailAlerts_lbl_from.setText("From");
        preferences_emailAlerts_lbl_bottom.add(preferences_emailAlerts_lbl_from, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, 20));

        preferences_emailAlerts_lbl_to.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        preferences_emailAlerts_lbl_to.setText("To");
        preferences_emailAlerts_lbl_bottom.add(preferences_emailAlerts_lbl_to, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, -1, 20));

        preferences_emailAlerts_lbl_password.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        preferences_emailAlerts_lbl_password.setText("Password");
        preferences_emailAlerts_lbl_bottom.add(preferences_emailAlerts_lbl_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, 20));

        preferences_emailAlerts_lbl_username.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        preferences_emailAlerts_lbl_username.setText("Username");
        preferences_emailAlerts_lbl_bottom.add(preferences_emailAlerts_lbl_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, 20));

        preferences_emailAlerts_lbl_port.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        preferences_emailAlerts_lbl_port.setText("Port");
        preferences_emailAlerts_lbl_bottom.add(preferences_emailAlerts_lbl_port, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 30, 20));

        preferences_emailAlerts_lbl_mailServer.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        preferences_emailAlerts_lbl_mailServer.setText("Mail Server");
        preferences_emailAlerts_lbl_bottom.add(preferences_emailAlerts_lbl_mailServer, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, 20));

        preferences_emailAlerts_textField_subject.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        preferences_emailAlerts_textField_subject.setToolTipText("Subject of the email alert");
        preferences_emailAlerts_lbl_bottom.add(preferences_emailAlerts_textField_subject, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 330, -1));

        preferences_emailAlerts_textField_port.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        preferences_emailAlerts_textField_port.setToolTipText("SMTP port number (0-65535)");
        preferences_emailAlerts_lbl_bottom.add(preferences_emailAlerts_textField_port, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 60, -1));

        preferences_emailAlerts_textField_username.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        preferences_emailAlerts_textField_username.setToolTipText("Mail server account name (Optional)");
        preferences_emailAlerts_textField_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_emailAlerts_textField_usernameActionPerformed(evt);
            }
        });
        preferences_emailAlerts_lbl_bottom.add(preferences_emailAlerts_textField_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 330, -1));

        preferences_emailAlerts_textField_to.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        preferences_emailAlerts_textField_to.setToolTipText("Recipient of the email notifiction (recipient@domain.com)");
        preferences_emailAlerts_textField_to.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_emailAlerts_textField_toActionPerformed(evt);
            }
        });
        preferences_emailAlerts_lbl_bottom.add(preferences_emailAlerts_textField_to, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 330, -1));

        preferences_emailAlerts_textField_from.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        preferences_emailAlerts_textField_from.setToolTipText("Source of email notification (sender@domain.com)");
        preferences_emailAlerts_lbl_bottom.add(preferences_emailAlerts_textField_from, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 330, -1));

        preferences_emailAlerts_textField_mailServer.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        preferences_emailAlerts_textField_mailServer.setToolTipText("SMTP server domain name or IP address");
        preferences_emailAlerts_lbl_bottom.add(preferences_emailAlerts_textField_mailServer, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 230, -1));

        preferences_emailAlerts_textField_password.setToolTipText("Mail server account password (Optional)");
        preferences_emailAlerts_lbl_bottom.add(preferences_emailAlerts_textField_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 140, 330, -1));

        card_preferences_emailAlerts.add(preferences_emailAlerts_lbl_bottom, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 585, 360));

        panel_preferences_right.add(card_preferences_emailAlerts, "emailAlerts");

        card_preferences_emailScanning.setBackground(new java.awt.Color(64, 55, 110));
        card_preferences_emailScanning.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        preferences_emailScan_panel_top.setBackground(new java.awt.Color(107, 87, 146));
        preferences_emailScan_panel_top.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        preferences_emailScan_lbl_info.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        preferences_emailScan_lbl_info.setForeground(new java.awt.Color(255, 255, 255));
        preferences_emailScan_lbl_info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        preferences_emailScan_lbl_info.setText("<html><div style='text-align:center'>Email Scanning allows you to configure scanning of your emails</div></html>");
        preferences_emailScan_lbl_info.setToolTipText("");
        preferences_emailScan_lbl_info.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        preferences_emailScan_panel_top.add(preferences_emailScan_lbl_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 550, 80));

        card_preferences_emailScanning.add(preferences_emailScan_panel_top, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 585, 80));

        preferences_emailScan_panel_bottom.setBackground(new java.awt.Color(204, 204, 204));
        preferences_emailScan_panel_bottom.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        preferences_emailScan_lbl_heading1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        preferences_emailScan_lbl_heading1.setText("Microsoft Outlook");
        preferences_emailScan_panel_bottom.add(preferences_emailScan_lbl_heading1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        preferences_emailScan_btn_save.setBackground(new java.awt.Color(173, 159, 175));
        preferences_emailScan_btn_save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        preferences_emailScan_btn_save.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        preferences_emailScan_btn_save.setForeground(new java.awt.Color(22, 89, 45));
        preferences_emailScan_btn_save.setLabel("Save Changes");
        preferences_emailScan_btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_emailScan_btn_saveActionPerformed(evt);
            }
        });
        preferences_emailScan_panel_bottom.add(preferences_emailScan_btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 130, 40));

        preferences_emailScan_lbl_line.setText("line");
        preferences_emailScan_panel_bottom.add(preferences_emailScan_lbl_line, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 410, 10));

        preferences_internetUpdates_cb_automaticUpdates1.setBackground(new java.awt.Color(204, 204, 204));
        preferences_internetUpdates_cb_automaticUpdates1.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        preferences_internetUpdates_cb_automaticUpdates1.setText("Display splash screen on startup");
        preferences_internetUpdates_cb_automaticUpdates1.setToolTipText("Select to display splash screen when starting up");
        preferences_internetUpdates_cb_automaticUpdates1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_internetUpdates_cb_automaticUpdates1ActionPerformed(evt);
            }
        });
        preferences_emailScan_panel_bottom.add(preferences_internetUpdates_cb_automaticUpdates1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 340, -1));

        preferences_internetUpdates_cb_automaticUpdates2.setBackground(new java.awt.Color(204, 204, 204));
        preferences_internetUpdates_cb_automaticUpdates2.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        preferences_internetUpdates_cb_automaticUpdates2.setText("Scan outgoing email messages");
        preferences_internetUpdates_cb_automaticUpdates2.setToolTipText("Select to scan your outgoing email messages");
        preferences_internetUpdates_cb_automaticUpdates2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_internetUpdates_cb_automaticUpdates2ActionPerformed(evt);
            }
        });
        preferences_emailScan_panel_bottom.add(preferences_internetUpdates_cb_automaticUpdates2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 340, -1));

        preferences_internetUpdates_cb_automaticUpdates3.setBackground(new java.awt.Color(204, 204, 204));
        preferences_internetUpdates_cb_automaticUpdates3.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        preferences_internetUpdates_cb_automaticUpdates3.setText("Scan incoming email messages");
        preferences_internetUpdates_cb_automaticUpdates3.setToolTipText("Select to scan your incoming email messages");
        preferences_internetUpdates_cb_automaticUpdates3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_internetUpdates_cb_automaticUpdates3ActionPerformed(evt);
            }
        });
        preferences_emailScan_panel_bottom.add(preferences_internetUpdates_cb_automaticUpdates3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 340, -1));

        card_preferences_emailScanning.add(preferences_emailScan_panel_bottom, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 585, 360));

        panel_preferences_right.add(card_preferences_emailScanning, "emailScanning");

        card_preferences_limits.setBackground(new java.awt.Color(64, 55, 110));
        card_preferences_limits.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        preferences_limits_panel_top.setBackground(new java.awt.Color(107, 87, 146));
        preferences_limits_panel_top.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        preferences_limits_lbl_info.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        preferences_limits_lbl_info.setForeground(new java.awt.Color(255, 255, 255));
        preferences_limits_lbl_info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        preferences_limits_lbl_info.setText("<html><div style='text-align:center'> Limits allow you to set the maximum file size that can be scanned</div></html>");
        preferences_limits_lbl_info.setToolTipText("");
        preferences_limits_lbl_info.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        preferences_limits_panel_top.add(preferences_limits_lbl_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 550, 80));

        card_preferences_limits.add(preferences_limits_panel_top, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 585, 80));

        preferences_limits_panel_bottom.setBackground(new java.awt.Color(204, 204, 204));
        preferences_limits_panel_bottom.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        preferences_limits_lbl_heading1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        preferences_limits_lbl_heading1.setText("All Files");
        preferences_limits_panel_bottom.add(preferences_limits_lbl_heading1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        preferences_limits_btn_save.setBackground(new java.awt.Color(173, 159, 175));
        preferences_limits_btn_save.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        preferences_limits_btn_save.setForeground(new java.awt.Color(22, 89, 45));
        preferences_limits_btn_save.setLabel("Save Changes");
        preferences_limits_btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_limits_btn_saveActionPerformed(evt);
            }
        });
        preferences_limits_panel_bottom.add(preferences_limits_btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 130, 40));

        preferences_limits_lbl_line.setText("line");
        preferences_limits_panel_bottom.add(preferences_limits_lbl_line, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 430, 10));

        preferences_limits_cb_extractFromArchives.setBackground(new java.awt.Color(204, 204, 204));
        preferences_limits_cb_extractFromArchives.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        preferences_limits_cb_extractFromArchives.setSelected(true);
        preferences_limits_cb_extractFromArchives.setText("Extract files from archives");
        preferences_limits_cb_extractFromArchives.setToolTipText("Select to include archives in the scan");
        preferences_limits_cb_extractFromArchives.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_limits_cb_extractFromArchivesActionPerformed(evt);
            }
        });
        preferences_limits_panel_bottom.add(preferences_limits_cb_extractFromArchives, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 340, -1));

        preferences_limits_lbl_heading2.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        preferences_limits_lbl_heading2.setText("Archives");
        preferences_limits_panel_bottom.add(preferences_limits_lbl_heading2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        preferences_limits_lbl_doNotExtractMoreThan1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        preferences_limits_lbl_doNotExtractMoreThan1.setText("Do not extract more than");
        preferences_limits_panel_bottom.add(preferences_limits_lbl_doNotExtractMoreThan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 170, -1));

        preferences_limits_lbl_doNotScanMoreThan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        preferences_limits_lbl_doNotScanMoreThan.setText("Do not scan files larger than");
        preferences_limits_panel_bottom.add(preferences_limits_lbl_doNotScanMoreThan, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 190, -1));

        preferences_limits_lbl_megabytes2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        preferences_limits_lbl_megabytes2.setText("Megabytes");
        preferences_limits_panel_bottom.add(preferences_limits_lbl_megabytes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 70, -1));

        preferences_limits_lbl_doNotExtractMoreThan2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        preferences_limits_lbl_doNotExtractMoreThan2.setText("Do not extract more than");
        preferences_limits_panel_bottom.add(preferences_limits_lbl_doNotExtractMoreThan2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 197, 160, 20));

        preferences_limits_lbl_doNotExtractMoreThan3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        preferences_limits_lbl_doNotExtractMoreThan3.setText("Do not extract more than");
        preferences_limits_panel_bottom.add(preferences_limits_lbl_doNotExtractMoreThan3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 160, -1));

        preferences_limits_lbl_files.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        preferences_limits_lbl_files.setText("Files");
        preferences_limits_panel_bottom.add(preferences_limits_lbl_files, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 70, 20));

        preferences_limits_lbl_subArchives.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        preferences_limits_lbl_subArchives.setText("Sub-Archives");
        preferences_limits_panel_bottom.add(preferences_limits_lbl_subArchives, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 90, -1));

        preferences_limits_lbl_megabytes1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        preferences_limits_lbl_megabytes1.setText("Megabytes");
        preferences_limits_panel_bottom.add(preferences_limits_lbl_megabytes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 70, -1));

        preferences_limits_spinner2.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        preferences_limits_panel_bottom.add(preferences_limits_spinner2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 90, 30));

        preferences_limits_spinner1.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        preferences_limits_panel_bottom.add(preferences_limits_spinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 60, 90, 30));

        preferences_limits_spinner3.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        preferences_limits_panel_bottom.add(preferences_limits_spinner3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 90, 30));

        preferences_limits_spinner4.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        preferences_limits_panel_bottom.add(preferences_limits_spinner4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 90, 30));

        card_preferences_limits.add(preferences_limits_panel_bottom, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 585, 360));

        panel_preferences_right.add(card_preferences_limits, "limits");

        card_preferences_reports.setBackground(new java.awt.Color(64, 55, 110));
        card_preferences_reports.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        preferences_reports_panel_top.setBackground(new java.awt.Color(107, 87, 146));
        preferences_reports_panel_top.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        preferences_reports_lbl_info.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        preferences_reports_lbl_info.setForeground(new java.awt.Color(255, 255, 255));
        preferences_reports_lbl_info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        preferences_reports_lbl_info.setText("<html><div style='text-align:center'> Reports allow you to specify scan report file location and database update file location</div></html>");
        preferences_reports_lbl_info.setToolTipText("");
        preferences_reports_lbl_info.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        preferences_reports_panel_top.add(preferences_reports_lbl_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 550, 80));

        card_preferences_reports.add(preferences_reports_panel_top, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 585, 80));

        preferences_reports_panel_bottom.setBackground(new java.awt.Color(204, 204, 204));
        preferences_reports_panel_bottom.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        preferences_reports_lbl_heading1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        preferences_reports_lbl_heading1.setText("Scan Report File");
        preferences_reports_panel_bottom.add(preferences_reports_lbl_heading1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        preferences_reports_btn_save.setBackground(new java.awt.Color(173, 159, 175));
        preferences_reports_btn_save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        preferences_reports_btn_save.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        preferences_reports_btn_save.setForeground(new java.awt.Color(22, 89, 45));
        preferences_reports_btn_save.setLabel("Save Changes");
        preferences_reports_btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_reports_btn_saveActionPerformed(evt);
            }
        });
        preferences_reports_panel_bottom.add(preferences_reports_btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 130, 40));

        preferences_reports_lbl_line.setText("line");
        preferences_reports_panel_bottom.add(preferences_reports_lbl_line, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 420, 10));

        preferences_reports_lbl_heading2.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        preferences_reports_lbl_heading2.setText("Virus Database Update Report File");
        preferences_reports_panel_bottom.add(preferences_reports_lbl_heading2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        preferences_reports_textField_databaseReport.setEditable(false);
        preferences_reports_textField_databaseReport.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        preferences_reports_panel_bottom.add(preferences_reports_textField_databaseReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 370, 30));

        preferences_reports_lblicon_databaseReport.setText("jLabel2");
        preferences_reports_lblicon_databaseReport.setToolTipText("Browse for location to store database report file");
        preferences_reports_lblicon_databaseReport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        preferences_reports_lblicon_databaseReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                preferences_reports_lblicon_databaseReportMouseClicked(evt);
            }
        });
        preferences_reports_panel_bottom.add(preferences_reports_lblicon_databaseReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 30, 30));

        preferences_reports_textField_scanReport.setEditable(false);
        preferences_reports_textField_scanReport.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        preferences_reports_panel_bottom.add(preferences_reports_textField_scanReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 80, 370, 30));

        preferences_reports_lblicon_scanReport.setText("jLabel2");
        preferences_reports_lblicon_scanReport.setToolTipText("Browse for location to store scan report file");
        preferences_reports_lblicon_scanReport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        preferences_reports_lblicon_scanReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                preferences_reports_lblicon_scanReportMouseClicked(evt);
            }
        });
        preferences_reports_panel_bottom.add(preferences_reports_lblicon_scanReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 30, 30));

        preferences_reports_cb_popUpNotification.setBackground(new java.awt.Color(204, 204, 204));
        preferences_reports_cb_popUpNotification.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        preferences_reports_cb_popUpNotification.setText("Display pop up notification messages in task bar");
        preferences_reports_cb_popUpNotification.setToolTipText("Select to display notification in the task bar");
        preferences_reports_cb_popUpNotification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_reports_cb_popUpNotificationActionPerformed(evt);
            }
        });
        preferences_reports_panel_bottom.add(preferences_reports_cb_popUpNotification, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 380, -1));

        card_preferences_reports.add(preferences_reports_panel_bottom, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 585, 360));

        panel_preferences_right.add(card_preferences_reports, "reports");

        card_preferences_proxy.setBackground(new java.awt.Color(64, 55, 110));
        card_preferences_proxy.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel21.setBackground(new java.awt.Color(107, 87, 146));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        preferences_proxy_panel_top.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        preferences_proxy_panel_top.setForeground(new java.awt.Color(255, 255, 255));
        preferences_proxy_panel_top.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        preferences_proxy_panel_top.setText("<html><div style='text-align:center'> Proxy allows you configure connection to a proxy server<br>\n(Leave blank if you do not connect to a proxy server)</div></html>");
        preferences_proxy_panel_top.setToolTipText("");
        preferences_proxy_panel_top.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel21.add(preferences_proxy_panel_top, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 550, 80));

        card_preferences_proxy.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 585, 80));

        preferences_proxy_panel_bottom.setBackground(new java.awt.Color(204, 204, 204));
        preferences_proxy_panel_bottom.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        preferences_proxy_lbl_heading1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        preferences_proxy_lbl_heading1.setText("Proxy Server Name and Port");
        preferences_proxy_panel_bottom.add(preferences_proxy_lbl_heading1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        preferences_proxy_btn_save.setBackground(new java.awt.Color(173, 159, 175));
        preferences_proxy_btn_save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        preferences_proxy_btn_save.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        preferences_proxy_btn_save.setForeground(new java.awt.Color(22, 89, 45));
        preferences_proxy_btn_save.setLabel("Save Changes");
        preferences_proxy_btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_proxy_btn_saveActionPerformed(evt);
            }
        });
        preferences_proxy_panel_bottom.add(preferences_proxy_btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 130, 40));

        preferences_proxy_lbl_line.setText("line");
        preferences_proxy_panel_bottom.add(preferences_proxy_lbl_line, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 410, 10));

        preferences_proxy_lbl_heading2.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        preferences_proxy_lbl_heading2.setText("Username and Password");
        preferences_proxy_panel_bottom.add(preferences_proxy_lbl_heading2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, -1));

        preferences_proxy_lbl_proxyServer.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        preferences_proxy_lbl_proxyServer.setText("Proxy Server");
        preferences_proxy_panel_bottom.add(preferences_proxy_lbl_proxyServer, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, -1, 30));

        preferences_proxy_textField_proxyServer.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        preferences_proxy_textField_proxyServer.setToolTipText("Proxy Server domain name or IP address");
        preferences_proxy_panel_bottom.add(preferences_proxy_textField_proxyServer, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 230, 30));

        preferences_proxy_lbl_port.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        preferences_proxy_lbl_port.setText("Port");
        preferences_proxy_panel_bottom.add(preferences_proxy_lbl_port, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 30, 30));

        preferences_proxy_textField_port.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        preferences_proxy_textField_port.setToolTipText("Proxy Server port number (0-65535)");
        preferences_proxy_panel_bottom.add(preferences_proxy_textField_port, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 60, 30));

        preferences_proxy_lbl_username.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        preferences_proxy_lbl_username.setText("Username");
        preferences_proxy_panel_bottom.add(preferences_proxy_lbl_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, -1, 30));

        preferences_proxy_textField_username.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        preferences_proxy_textField_username.setToolTipText("Proxy Server account name (Optional)");
        preferences_proxy_textField_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_proxy_textField_usernameActionPerformed(evt);
            }
        });
        preferences_proxy_panel_bottom.add(preferences_proxy_textField_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 330, 30));

        preferences_proxy_lbl_password.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        preferences_proxy_lbl_password.setText("Password");
        preferences_proxy_panel_bottom.add(preferences_proxy_lbl_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, 30));

        preferences_proxy_textField_password.setToolTipText("Proxy Server account password (Optional)");
        preferences_proxy_panel_bottom.add(preferences_proxy_textField_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 200, 330, 30));

        card_preferences_proxy.add(preferences_proxy_panel_bottom, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 585, 360));

        panel_preferences_right.add(card_preferences_proxy, "proxy");

        card_preferences_advanced.setBackground(new java.awt.Color(64, 55, 110));
        card_preferences_advanced.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        preferences_advanced_panel_top.setBackground(new java.awt.Color(107, 87, 146));
        preferences_advanced_panel_top.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        preferences_advanced_lbl_info.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        preferences_advanced_lbl_info.setForeground(new java.awt.Color(255, 255, 255));
        preferences_advanced_lbl_info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        preferences_advanced_lbl_info.setText("<html><div style='text-align:center'> Allows you to configure advanced features on ClamWin</div></html>");
        preferences_advanced_lbl_info.setToolTipText("");
        preferences_advanced_lbl_info.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        preferences_advanced_panel_top.add(preferences_advanced_lbl_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 550, 80));

        card_preferences_advanced.add(preferences_advanced_panel_top, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 585, 80));

        preferences_advanced_panel_bottom.setBackground(new java.awt.Color(204, 204, 204));
        preferences_advanced_panel_bottom.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        preferences_advanced_btn_save.setBackground(new java.awt.Color(173, 159, 175));
        preferences_advanced_btn_save.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        preferences_advanced_btn_save.setForeground(new java.awt.Color(22, 89, 45));
        preferences_advanced_btn_save.setLabel("Save Changes");
        preferences_advanced_btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_advanced_btn_saveActionPerformed(evt);
            }
        });
        preferences_advanced_panel_bottom.add(preferences_advanced_btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 130, 40));

        preferences_advanced_lbl_line.setText("line");
        preferences_advanced_panel_bottom.add(preferences_advanced_lbl_line, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 420, 10));

        preferences_advanced_cb_extractAttachments.setBackground(new java.awt.Color(204, 204, 204));
        preferences_advanced_cb_extractAttachments.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        preferences_advanced_cb_extractAttachments.setText("Extract attachments and macros from MS documents ");
        preferences_advanced_cb_extractAttachments.setToolTipText("Select to display splash screen when starting up");
        preferences_advanced_cb_extractAttachments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_advanced_cb_extractAttachmentsActionPerformed(evt);
            }
        });
        preferences_advanced_panel_bottom.add(preferences_advanced_cb_extractAttachments, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 420, -1));

        preferences_advanced_lbl_megaBytes.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        preferences_advanced_lbl_megaBytes.setText("MegaBytes");
        preferences_advanced_panel_bottom.add(preferences_advanced_lbl_megaBytes, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 70, 30));

        preferences_advanced_textField_additional.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        preferences_advanced_textField_additional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferences_advanced_textField_additionalActionPerformed(evt);
            }
        });
        preferences_advanced_panel_bottom.add(preferences_advanced_textField_additional, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 420, 30));

        preferences_advanced_lbl_scannerPriority.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        preferences_advanced_lbl_scannerPriority.setText("Scanner Priority");
        preferences_advanced_panel_bottom.add(preferences_advanced_lbl_scannerPriority, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 140, 30));

        preferences_advanced_lbl_additional.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        preferences_advanced_lbl_additional.setText("Additional Clamscan Command Line Parameters");
        preferences_advanced_panel_bottom.add(preferences_advanced_lbl_additional, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 330, 30));

        preferences_advanced_lbl_logFileSize.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        preferences_advanced_lbl_logFileSize.setText("Limit Log file size to");
        preferences_advanced_panel_bottom.add(preferences_advanced_lbl_logFileSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 140, 30));

        preferences_advanced_combo_scanningPriority.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Low", "Normal" }));
        preferences_advanced_combo_scanningPriority.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        preferences_advanced_panel_bottom.add(preferences_advanced_combo_scanningPriority, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 160, 30));

        preferences_advanced_spinner_logFileSize.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        preferences_advanced_spinner_logFileSize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        preferences_advanced_spinner_logFileSize.setValue(1);
        preferences_advanced_panel_bottom.add(preferences_advanced_spinner_logFileSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 80, 30));

        card_preferences_advanced.add(preferences_advanced_panel_bottom, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 585, 360));

        panel_preferences_right.add(card_preferences_advanced, "advanced");

        getContentPane().add(panel_preferences_right, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 20, -1, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_btn_preferences_minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btn_preferences_minimizeMouseClicked
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_lbl_btn_preferences_minimizeMouseClicked

    private void lbl_btn_preferences_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btn_preferences_closeMouseClicked
        this.dispose();
    }//GEN-LAST:event_lbl_btn_preferences_closeMouseClicked

    //save buttons of the tabs
    //general tab save button
    private void preferences_general_btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_general_btn_saveActionPerformed
                
        int userReply;
        
        userReply = JOptionPane.showConfirmDialog(null,"Are you sure you want to save the changes you made?", "Save Changes", JOptionPane.YES_NO_OPTION);
        
        if(userReply == JOptionPane.YES_OPTION){
            
            /*saving block of code*/
            JOptionPane savingSuccessOptionPane = new JOptionPane("Changes saved successfully !", JOptionPane.INFORMATION_MESSAGE);
                  
            JDialog savingSuccessDialog = savingSuccessOptionPane.createDialog(null, "ClamWin Free Antivirus");
            savingSuccessDialog.setModal(true);
            savingSuccessDialog.setVisible(true);
            
        }else{
            
            
        }
    }//GEN-LAST:event_preferences_general_btn_saveActionPerformed

    //filters tab save button
    private void preferences_filters_btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_filters_btn_saveActionPerformed
         
        int userReply;
        
        userReply = JOptionPane.showConfirmDialog(null,"Are you sure you want to save the changes you made?", "Save Changes", JOptionPane.YES_NO_OPTION);
        
        if(userReply == JOptionPane.YES_OPTION){
            
            /*saving block of code*/
            JOptionPane savingSuccessOptionPane = new JOptionPane("Changes saved successfully !", JOptionPane.INFORMATION_MESSAGE);
                  
            JDialog savingSuccessDialog = savingSuccessOptionPane.createDialog(null, "ClamWin Free Antivirus");
            savingSuccessDialog.setModal(true);
            savingSuccessDialog.setVisible(true);
            
        }else{
            
            
        }
    }//GEN-LAST:event_preferences_filters_btn_saveActionPerformed

    //internetUpdates save button
    private void preferences_internetUpdatesl_btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_internetUpdatesl_btn_saveActionPerformed
                
        int userReply;
        
        userReply = JOptionPane.showConfirmDialog(null,"Are you sure you want to save the changes you made?", "Save Changes", JOptionPane.YES_NO_OPTION);
        
        if(userReply == JOptionPane.YES_OPTION){
            
            /*saving block of code*/
            JOptionPane savingSuccessOptionPane = new JOptionPane("Changes saved successfully !", JOptionPane.INFORMATION_MESSAGE);
                  
            JDialog savingSuccessDialog = savingSuccessOptionPane.createDialog(null, "ClamWin Free Antivirus");
            savingSuccessDialog.setModal(true);
            savingSuccessDialog.setVisible(true);
            
        }else{
            
            
        }
    }//GEN-LAST:event_preferences_internetUpdatesl_btn_saveActionPerformed

    //scheduledScan save button
    private void preferences_schedulesScans_btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_schedulesScans_btn_saveActionPerformed
        
        int userReply;
        
        userReply = JOptionPane.showConfirmDialog(null,"Are you sure you want to save the changes you made?", "Save Changes", JOptionPane.YES_NO_OPTION);
        
        if(userReply == JOptionPane.YES_OPTION){
            
            /*saving block of code*/
            JOptionPane savingSuccessOptionPane = new JOptionPane("Changes saved successfully !", JOptionPane.INFORMATION_MESSAGE);
                  
            JDialog savingSuccessDialog = savingSuccessOptionPane.createDialog(null, "ClamWin Free Antivirus");
            savingSuccessDialog.setModal(true);
            savingSuccessDialog.setVisible(true);
            
        }else{
            
            
        }
    }//GEN-LAST:event_preferences_schedulesScans_btn_saveActionPerformed

    //file locations save button
    private void preferences_fileLocations_btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_fileLocations_btn_saveActionPerformed
        
        int userReply;
        
        userReply = JOptionPane.showConfirmDialog(null,"Are you sure you want to save the changes you made?", "Save Changes", JOptionPane.YES_NO_OPTION);
        
        if(userReply == JOptionPane.YES_OPTION){
            
            /*saving block of code*/
            JOptionPane savingSuccessOptionPane = new JOptionPane("Changes saved successfully !", JOptionPane.INFORMATION_MESSAGE);
                  
            JDialog savingSuccessDialog = savingSuccessOptionPane.createDialog(null, "ClamWin Free Antivirus");
            savingSuccessDialog.setModal(true);
            savingSuccessDialog.setVisible(true);
            
        }else{
            
            
        }
    }//GEN-LAST:event_preferences_fileLocations_btn_saveActionPerformed

    //email alerts save button
    private void preferences_emailAlerts_btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_emailAlerts_btn_saveActionPerformed
        
        int userReply;
        
        userReply = JOptionPane.showConfirmDialog(null,"Are you sure you want to save the changes you made?", "Save Changes", JOptionPane.YES_NO_OPTION);
        
        if(userReply == JOptionPane.YES_OPTION){
            
            /*saving block of code*/
            JOptionPane savingSuccessOptionPane = new JOptionPane("Changes saved successfully !", JOptionPane.INFORMATION_MESSAGE);
                  
            JDialog savingSuccessDialog = savingSuccessOptionPane.createDialog(null, "ClamWin Free Antivirus");
            savingSuccessDialog.setModal(true);
            savingSuccessDialog.setVisible(true);
            
        }else{
            
            
        }
    }//GEN-LAST:event_preferences_emailAlerts_btn_saveActionPerformed

    //email scan save button
    private void preferences_emailScan_btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_emailScan_btn_saveActionPerformed
        
        int userReply;
        
        userReply = JOptionPane.showConfirmDialog(null,"Are you sure you want to save the changes you made?", "Save Changes", JOptionPane.YES_NO_OPTION);
        
        if(userReply == JOptionPane.YES_OPTION){
            
            /*saving block of code*/
            JOptionPane savingSuccessOptionPane = new JOptionPane("Changes saved successfully !", JOptionPane.INFORMATION_MESSAGE);
                  
            JDialog savingSuccessDialog = savingSuccessOptionPane.createDialog(null, "ClamWin Free Antivirus");
            savingSuccessDialog.setModal(true);
            savingSuccessDialog.setVisible(true);
            
        }else{
            
            
        }
    }//GEN-LAST:event_preferences_emailScan_btn_saveActionPerformed

    //limts save button
    private void preferences_limits_btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_limits_btn_saveActionPerformed
        
        int userReply;
        
        userReply = JOptionPane.showConfirmDialog(null,"Are you sure you want to save the changes you made?", "Save Changes", JOptionPane.YES_NO_OPTION);
        
        if(userReply == JOptionPane.YES_OPTION){
            
            /*saving block of code*/
            JOptionPane savingSuccessOptionPane = new JOptionPane("Changes saved successfully !", JOptionPane.INFORMATION_MESSAGE);
                  
            JDialog savingSuccessDialog = savingSuccessOptionPane.createDialog(null, "ClamWin Free Antivirus");
            savingSuccessDialog.setModal(true);
            savingSuccessDialog.setVisible(true);
            
        }else{
            
            
        }
    }//GEN-LAST:event_preferences_limits_btn_saveActionPerformed

    //reports save button
    private void preferences_reports_btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_reports_btn_saveActionPerformed
        
        int userReply;
        
        userReply = JOptionPane.showConfirmDialog(null,"Are you sure you want to save the changes you made?", "Save Changes", JOptionPane.YES_NO_OPTION);
        
        if(userReply == JOptionPane.YES_OPTION){
            
            /*saving block of code*/
            JOptionPane savingSuccessOptionPane = new JOptionPane("Changes saved successfully !", JOptionPane.INFORMATION_MESSAGE);
                  
            JDialog savingSuccessDialog = savingSuccessOptionPane.createDialog(null, "ClamWin Free Antivirus");
            savingSuccessDialog.setModal(true);
            savingSuccessDialog.setVisible(true);
            
        }else{
            
            
        }
    }//GEN-LAST:event_preferences_reports_btn_saveActionPerformed

    //proxy save button
    private void preferences_proxy_btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_proxy_btn_saveActionPerformed
        
        int userReply;
        
        userReply = JOptionPane.showConfirmDialog(null,"Are you sure you want to save the changes you made?", "Save Changes", JOptionPane.YES_NO_OPTION);
        
        if(userReply == JOptionPane.YES_OPTION){
            
            /*saving block of code*/
            JOptionPane savingSuccessOptionPane = new JOptionPane("Changes saved successfully !", JOptionPane.INFORMATION_MESSAGE);
                  
            JDialog savingSuccessDialog = savingSuccessOptionPane.createDialog(null, "ClamWin Free Antivirus");
            savingSuccessDialog.setModal(true);
            savingSuccessDialog.setVisible(true);
            
        }else{
            
            
        }
    }//GEN-LAST:event_preferences_proxy_btn_saveActionPerformed

    //advanced save button
    private void preferences_advanced_btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_advanced_btn_saveActionPerformed
        
        int userReply;
        
        userReply = JOptionPane.showConfirmDialog(null,"Are you sure you want to save the changes you made?", "Save Changes", JOptionPane.YES_NO_OPTION);
        
        if(userReply == JOptionPane.YES_OPTION){
            
            /*saving block of code*/
            JOptionPane savingSuccessOptionPane = new JOptionPane("Changes saved successfully !", JOptionPane.INFORMATION_MESSAGE);
                  
            JDialog savingSuccessDialog = savingSuccessOptionPane.createDialog(null, "ClamWin Free Antivirus");
            savingSuccessDialog.setModal(true);
            savingSuccessDialog.setVisible(true);
            
        }else{
            
            
        }
    }//GEN-LAST:event_preferences_advanced_btn_saveActionPerformed

    /* start of left panel button cliks */
    
    //general button click
    private void panel_preferences_left_generalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_generalMouseClicked
        
        panel_preferences_left_general.setBorder(border);
        panel_preferences_left_filters.setBorder(null);
        panel_preferences_left_InternetUpdates.setBorder(null);
        panel_preferences_left_scheduledScans.setBorder(null);
        panel_preferences_left_fileLocations.setBorder(null);
        panel_preferences_left_emailAlerts.setBorder(null);
        panel_preferences_left_emailScanning.setBorder(null);
        panel_preferences_left_limits.setBorder(null);
        panel_preferences_left_reports.setBorder(null);
        panel_preferences_left_proxy.setBorder(null);
        panel_preferences_left_advanced.setBorder(null);
        panel_preferences_left_mainMenu.setBorder(null);
        
        CardLayout cardPanel = (CardLayout)panel_preferences_right.getLayout();
        cardPanel.show(panel_preferences_right, "general");
        
    }//GEN-LAST:event_panel_preferences_left_generalMouseClicked

    //filers button click
    private void panel_preferences_left_filtersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_filtersMouseClicked
        
        panel_preferences_left_general.setBorder(null);
        panel_preferences_left_filters.setBorder(border);
        panel_preferences_left_InternetUpdates.setBorder(null);
        panel_preferences_left_scheduledScans.setBorder(null);
        panel_preferences_left_fileLocations.setBorder(null);
        panel_preferences_left_emailAlerts.setBorder(null);
        panel_preferences_left_emailScanning.setBorder(null);
        panel_preferences_left_limits.setBorder(null);
        panel_preferences_left_reports.setBorder(null);
        panel_preferences_left_proxy.setBorder(null);
        panel_preferences_left_advanced.setBorder(null);
        panel_preferences_left_mainMenu.setBorder(null);
        
        CardLayout cardPanel = (CardLayout)panel_preferences_right.getLayout();
        cardPanel.show(panel_preferences_right, "filters");
    }//GEN-LAST:event_panel_preferences_left_filtersMouseClicked

    //internetUpdates click
    private void panel_preferences_left_InternetUpdatesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_InternetUpdatesMouseClicked
        
        panel_preferences_left_general.setBorder(null);
        panel_preferences_left_filters.setBorder(null);
        panel_preferences_left_InternetUpdates.setBorder(border);
        panel_preferences_left_scheduledScans.setBorder(null);
        panel_preferences_left_fileLocations.setBorder(null);
        panel_preferences_left_emailAlerts.setBorder(null);
        panel_preferences_left_emailScanning.setBorder(null);
        panel_preferences_left_limits.setBorder(null);
        panel_preferences_left_reports.setBorder(null);
        panel_preferences_left_proxy.setBorder(null);
        panel_preferences_left_advanced.setBorder(null);
        panel_preferences_left_mainMenu.setBorder(null);
        
        CardLayout cardPanel = (CardLayout)panel_preferences_right.getLayout();
        cardPanel.show(panel_preferences_right, "internetUpdates");
    }//GEN-LAST:event_panel_preferences_left_InternetUpdatesMouseClicked

    //scheduledScans button click
    private void panel_preferences_left_scheduledScansMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_scheduledScansMouseClicked
        
        panel_preferences_left_general.setBorder(null);
        panel_preferences_left_filters.setBorder(null);
        panel_preferences_left_InternetUpdates.setBorder(null);
        panel_preferences_left_scheduledScans.setBorder(border);
        panel_preferences_left_fileLocations.setBorder(null);
        panel_preferences_left_emailAlerts.setBorder(null);
        panel_preferences_left_emailScanning.setBorder(null);
        panel_preferences_left_limits.setBorder(null);
        panel_preferences_left_reports.setBorder(null);
        panel_preferences_left_proxy.setBorder(null);
        panel_preferences_left_advanced.setBorder(null);
        panel_preferences_left_mainMenu.setBorder(null);
        
        CardLayout cardPanel = (CardLayout)panel_preferences_right.getLayout();
        cardPanel.show(panel_preferences_right, "scheduledScans");
    }//GEN-LAST:event_panel_preferences_left_scheduledScansMouseClicked

    //fileLocations button click
    private void panel_preferences_left_fileLocationsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_fileLocationsMouseClicked
        
        panel_preferences_left_general.setBorder(null);
        panel_preferences_left_filters.setBorder(null);
        panel_preferences_left_InternetUpdates.setBorder(null);
        panel_preferences_left_scheduledScans.setBorder(null);
        panel_preferences_left_fileLocations.setBorder(border);
        panel_preferences_left_emailAlerts.setBorder(null);
        panel_preferences_left_emailScanning.setBorder(null);
        panel_preferences_left_limits.setBorder(null);
        panel_preferences_left_reports.setBorder(null);
        panel_preferences_left_proxy.setBorder(null);
        panel_preferences_left_advanced.setBorder(null);
        panel_preferences_left_mainMenu.setBorder(null);
        
        CardLayout cardPanel = (CardLayout)panel_preferences_right.getLayout();
        cardPanel.show(panel_preferences_right, "fileLocations");
    }//GEN-LAST:event_panel_preferences_left_fileLocationsMouseClicked

    //emailAlerts button click
    private void panel_preferences_left_emailAlertsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_emailAlertsMouseClicked
        
        panel_preferences_left_general.setBorder(null);
        panel_preferences_left_filters.setBorder(null);
        panel_preferences_left_InternetUpdates.setBorder(null);
        panel_preferences_left_scheduledScans.setBorder(null);
        panel_preferences_left_fileLocations.setBorder(null);
        panel_preferences_left_emailAlerts.setBorder(border);
        panel_preferences_left_emailScanning.setBorder(null);
        panel_preferences_left_limits.setBorder(null);
        panel_preferences_left_reports.setBorder(null);
        panel_preferences_left_proxy.setBorder(null);
        panel_preferences_left_advanced.setBorder(null);
        panel_preferences_left_mainMenu.setBorder(null);
        
        CardLayout cardPanel = (CardLayout)panel_preferences_right.getLayout();
        cardPanel.show(panel_preferences_right, "emailAlerts");
    }//GEN-LAST:event_panel_preferences_left_emailAlertsMouseClicked

    //emailScanning button click
    private void panel_preferences_left_emailScanningMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_emailScanningMouseClicked
        
        panel_preferences_left_general.setBorder(null);
        panel_preferences_left_filters.setBorder(null);
        panel_preferences_left_InternetUpdates.setBorder(null);
        panel_preferences_left_scheduledScans.setBorder(null);
        panel_preferences_left_fileLocations.setBorder(null);
        panel_preferences_left_emailAlerts.setBorder(null);
        panel_preferences_left_emailScanning.setBorder(border);
        panel_preferences_left_limits.setBorder(null);
        panel_preferences_left_reports.setBorder(null);
        panel_preferences_left_proxy.setBorder(null);
        panel_preferences_left_advanced.setBorder(null);
        panel_preferences_left_mainMenu.setBorder(null);
        
        CardLayout cardPanel = (CardLayout)panel_preferences_right.getLayout();
        cardPanel.show(panel_preferences_right, "emailScanning");
    }//GEN-LAST:event_panel_preferences_left_emailScanningMouseClicked

    //limits button click
    private void panel_preferences_left_limitsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_limitsMouseClicked
        
        panel_preferences_left_general.setBorder(null);
        panel_preferences_left_filters.setBorder(null);
        panel_preferences_left_InternetUpdates.setBorder(null);
        panel_preferences_left_scheduledScans.setBorder(null);
        panel_preferences_left_fileLocations.setBorder(null);
        panel_preferences_left_emailAlerts.setBorder(null);
        panel_preferences_left_emailScanning.setBorder(null);
        panel_preferences_left_limits.setBorder(border);
        panel_preferences_left_reports.setBorder(null);
        panel_preferences_left_proxy.setBorder(null);
        panel_preferences_left_advanced.setBorder(null);
        panel_preferences_left_mainMenu.setBorder(null);
        
        CardLayout cardPanel = (CardLayout)panel_preferences_right.getLayout();
        cardPanel.show(panel_preferences_right, "limits");
    }//GEN-LAST:event_panel_preferences_left_limitsMouseClicked

    //reports button click
    private void panel_preferences_left_reportsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_reportsMouseClicked
        
        panel_preferences_left_general.setBorder(null);
        panel_preferences_left_filters.setBorder(null);
        panel_preferences_left_InternetUpdates.setBorder(null);
        panel_preferences_left_scheduledScans.setBorder(null);
        panel_preferences_left_fileLocations.setBorder(null);
        panel_preferences_left_emailAlerts.setBorder(null);
        panel_preferences_left_emailScanning.setBorder(null);
        panel_preferences_left_limits.setBorder(null);
        panel_preferences_left_reports.setBorder(border);
        panel_preferences_left_proxy.setBorder(null);
        panel_preferences_left_advanced.setBorder(null);
        panel_preferences_left_mainMenu.setBorder(null);
        
        CardLayout cardPanel = (CardLayout)panel_preferences_right.getLayout();
        cardPanel.show(panel_preferences_right, "reports");
    }//GEN-LAST:event_panel_preferences_left_reportsMouseClicked

    //proxy button click
    private void panel_preferences_left_proxyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_proxyMouseClicked
        
        panel_preferences_left_general.setBorder(null);
        panel_preferences_left_filters.setBorder(null);
        panel_preferences_left_InternetUpdates.setBorder(null);
        panel_preferences_left_scheduledScans.setBorder(null);
        panel_preferences_left_fileLocations.setBorder(null);
        panel_preferences_left_emailAlerts.setBorder(null);
        panel_preferences_left_emailScanning.setBorder(null);
        panel_preferences_left_limits.setBorder(null);
        panel_preferences_left_reports.setBorder(null);
        panel_preferences_left_proxy.setBorder(border);
        panel_preferences_left_advanced.setBorder(null);
        panel_preferences_left_mainMenu.setBorder(null);
        
        CardLayout cardPanel = (CardLayout)panel_preferences_right.getLayout();
        cardPanel.show(panel_preferences_right, "proxy");
    }//GEN-LAST:event_panel_preferences_left_proxyMouseClicked

    //advanced button click
    private void panel_preferences_left_advancedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_advancedMouseClicked
        
        panel_preferences_left_general.setBorder(null);
        panel_preferences_left_filters.setBorder(null);
        panel_preferences_left_InternetUpdates.setBorder(null);
        panel_preferences_left_scheduledScans.setBorder(null);
        panel_preferences_left_fileLocations.setBorder(null);
        panel_preferences_left_emailAlerts.setBorder(null);
        panel_preferences_left_emailScanning.setBorder(null);
        panel_preferences_left_limits.setBorder(null);
        panel_preferences_left_reports.setBorder(null);
        panel_preferences_left_proxy.setBorder(null);
        panel_preferences_left_advanced.setBorder(border);
        panel_preferences_left_mainMenu.setBorder(null);
        
        CardLayout cardPanel = (CardLayout)panel_preferences_right.getLayout();
        cardPanel.show(panel_preferences_right, "advanced");
    }//GEN-LAST:event_panel_preferences_left_advancedMouseClicked

    //main menu button click
    private void panel_preferences_left_mainMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_mainMenuMouseClicked
        
        panel_preferences_left_general.setBorder(null);
        panel_preferences_left_filters.setBorder(null);
        panel_preferences_left_InternetUpdates.setBorder(null);
        panel_preferences_left_scheduledScans.setBorder(null);
        panel_preferences_left_fileLocations.setBorder(null);
        panel_preferences_left_emailAlerts.setBorder(null);
        panel_preferences_left_emailScanning.setBorder(null);
        panel_preferences_left_limits.setBorder(null);
        panel_preferences_left_reports.setBorder(null);
        panel_preferences_left_proxy.setBorder(null);
        panel_preferences_left_advanced.setBorder(null);
        panel_preferences_left_mainMenu.setBorder(border);
                
        MainMenu m1 = new MainMenu();
        m1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_panel_preferences_left_mainMenuMouseClicked
    /*end of left panel button clicks*/
    
    /*start of mouse entered and exited of the left panels*/
    
    //general mouse entered and exit
    private void panel_preferences_left_generalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_generalMouseEntered
        
        panel_preferences_left_general.setBackground(new Color(158,148,195));
        
    }//GEN-LAST:event_panel_preferences_left_generalMouseEntered

    private void panel_preferences_left_generalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_generalMouseExited
        panel_preferences_left_general.setBackground(new Color(107,91,170));
    }//GEN-LAST:event_panel_preferences_left_generalMouseExited
    
    //filters mouse entered and exit
    private void panel_preferences_left_filtersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_filtersMouseEntered

        panel_preferences_left_filters.setBackground(new Color(158,148,195));
    }//GEN-LAST:event_panel_preferences_left_filtersMouseEntered

    private void panel_preferences_left_filtersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_filtersMouseExited
        panel_preferences_left_filters.setBackground(new Color(107,91,170));
    }//GEN-LAST:event_panel_preferences_left_filtersMouseExited

    //InternetUpdates mouse entered and exit
    private void panel_preferences_left_InternetUpdatesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_InternetUpdatesMouseEntered
        panel_preferences_left_InternetUpdates.setBackground(new Color(158,148,195));
    }//GEN-LAST:event_panel_preferences_left_InternetUpdatesMouseEntered

    private void panel_preferences_left_InternetUpdatesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_InternetUpdatesMouseExited
        panel_preferences_left_InternetUpdates.setBackground(new Color(107,91,170));
    }//GEN-LAST:event_panel_preferences_left_InternetUpdatesMouseExited

    //scheduledScans mouse entered and exit
    private void panel_preferences_left_scheduledScansMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_scheduledScansMouseEntered
        panel_preferences_left_scheduledScans.setBackground(new Color(158,148,195));
    }//GEN-LAST:event_panel_preferences_left_scheduledScansMouseEntered

    private void panel_preferences_left_scheduledScansMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_scheduledScansMouseExited
        panel_preferences_left_scheduledScans.setBackground(new Color(107,91,170));
    }//GEN-LAST:event_panel_preferences_left_scheduledScansMouseExited

    //fileLocations mouse entered and exit
    private void panel_preferences_left_fileLocationsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_fileLocationsMouseEntered
        panel_preferences_left_fileLocations.setBackground(new Color(158,148,195));
    }//GEN-LAST:event_panel_preferences_left_fileLocationsMouseEntered

    private void panel_preferences_left_fileLocationsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_fileLocationsMouseExited
        panel_preferences_left_fileLocations.setBackground(new Color(107,91,170));
    }//GEN-LAST:event_panel_preferences_left_fileLocationsMouseExited

    //emailAlerts mouse entered and exit
    private void panel_preferences_left_emailAlertsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_emailAlertsMouseEntered
        panel_preferences_left_emailAlerts.setBackground(new Color(158,148,195));
    }//GEN-LAST:event_panel_preferences_left_emailAlertsMouseEntered

    private void panel_preferences_left_emailAlertsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_emailAlertsMouseExited
        panel_preferences_left_emailAlerts.setBackground(new Color(107,91,170));
    }//GEN-LAST:event_panel_preferences_left_emailAlertsMouseExited

    //emailScanning mouse entered and exit
    private void panel_preferences_left_emailScanningMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_emailScanningMouseEntered
        panel_preferences_left_emailScanning.setBackground(new Color(158,148,195));
    }//GEN-LAST:event_panel_preferences_left_emailScanningMouseEntered

    private void panel_preferences_left_emailScanningMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_emailScanningMouseExited
        panel_preferences_left_emailScanning.setBackground(new Color(107,91,170));
    }//GEN-LAST:event_panel_preferences_left_emailScanningMouseExited

    //limits mouse entered and exit
    private void panel_preferences_left_limitsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_limitsMouseEntered
        panel_preferences_left_limits.setBackground(new Color(158,148,195));
    }//GEN-LAST:event_panel_preferences_left_limitsMouseEntered

    private void panel_preferences_left_limitsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_limitsMouseExited
        panel_preferences_left_limits.setBackground(new Color(107,91,170));
    }//GEN-LAST:event_panel_preferences_left_limitsMouseExited

    //reports mouse entered and exit
    private void panel_preferences_left_reportsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_reportsMouseEntered
        panel_preferences_left_reports.setBackground(new Color(158,148,195));
    }//GEN-LAST:event_panel_preferences_left_reportsMouseEntered

    private void panel_preferences_left_reportsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_reportsMouseExited
        panel_preferences_left_reports.setBackground(new Color(107,91,170));
    }//GEN-LAST:event_panel_preferences_left_reportsMouseExited

    //proxy mouse entered and exit
    private void panel_preferences_left_proxyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_proxyMouseEntered
        panel_preferences_left_proxy.setBackground(new Color(158,148,195));
    }//GEN-LAST:event_panel_preferences_left_proxyMouseEntered

    private void panel_preferences_left_proxyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_proxyMouseExited
        panel_preferences_left_proxy.setBackground(new Color(107,91,170));
    }//GEN-LAST:event_panel_preferences_left_proxyMouseExited

    //advanced mouse entered and exit
    private void panel_preferences_left_advancedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_advancedMouseEntered
        panel_preferences_left_advanced.setBackground(new Color(158,148,195));
    }//GEN-LAST:event_panel_preferences_left_advancedMouseEntered

    private void panel_preferences_left_advancedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_advancedMouseExited
        panel_preferences_left_advanced.setBackground(new Color(107,91,170));
    }//GEN-LAST:event_panel_preferences_left_advancedMouseExited

    //mainMenu mouse entered and exit
    private void panel_preferences_left_mainMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_mainMenuMouseEntered
        panel_preferences_left_mainMenu.setBackground(new Color(158,148,195));
    }//GEN-LAST:event_panel_preferences_left_mainMenuMouseEntered

    private void panel_preferences_left_mainMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_preferences_left_mainMenuMouseExited
        panel_preferences_left_mainMenu.setBackground(new Color(107,91,170));
    }//GEN-LAST:event_panel_preferences_left_mainMenuMouseExited

    //general
    private void preferences_general_cb_unloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_general_cb_unloadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preferences_general_cb_unloadActionPerformed

    private void preferences_general_cb_displayInfectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_general_cb_displayInfectedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preferences_general_cb_displayInfectedActionPerformed

    private void preferences_general_cb_displayProgressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_general_cb_displayProgressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preferences_general_cb_displayProgressActionPerformed

    private void preferences_general_rb_folderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_general_rb_folderActionPerformed
        preferences_general_textfield1.setEnabled(true);
        preferences_general_lblicon_browse.setEnabled(true);
    }//GEN-LAST:event_preferences_general_rb_folderActionPerformed

    private void preferences_general_cb_subdirectoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_general_cb_subdirectoriesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preferences_general_cb_subdirectoriesActionPerformed

    private void preferences_general_rb_reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_general_rb_reportActionPerformed
        preferences_general_textfield1.setEnabled(false);
        preferences_general_lblicon_browse.setEnabled(false);
    }//GEN-LAST:event_preferences_general_rb_reportActionPerformed

    private void preferences_general_rb_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_general_rb_removeActionPerformed
        preferences_general_textfield1.setEnabled(false);
        preferences_general_lblicon_browse.setEnabled(false);
    }//GEN-LAST:event_preferences_general_rb_removeActionPerformed

    private void preferences_general_lblicon_browseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_preferences_general_lblicon_browseMouseClicked
        
        preferencesGeneralFileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        preferencesGeneralFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = preferencesGeneralFileChooser.showOpenDialog(this);
        
        if (result == preferencesGeneralFileChooser.APPROVE_OPTION) {
            File chosenFile = preferencesGeneralFileChooser.getSelectedFile();
            preferences_general_textfield1.setText(chosenFile.getAbsolutePath());
        }
        
    }//GEN-LAST:event_preferences_general_lblicon_browseMouseClicked

    //internetUpdates
    private void preferences_internetUpdates_cb_notifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_internetUpdates_cb_notifyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preferences_internetUpdates_cb_notifyActionPerformed

    private void preferences_internetUpdates_cb_automaticUpdatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_internetUpdates_cb_automaticUpdatesActionPerformed
        
        if(preferences_internetUpdates_cb_automaticUpdates.isSelected()){
            
            preferences_internetUpdates_textField_downloadSite.setEnabled(true);
            preferences_internetUpdates_dropDown_frequency.setEnabled(true);
            preferences_internetUpdates_spinner_time.setEnabled(true);
        }else{
            
            preferences_internetUpdates_textField_downloadSite.setEnabled(false);
            preferences_internetUpdates_dropDown_frequency.setEnabled(false);
            preferences_internetUpdates_spinner_time.setEnabled(false);
            preferences_internetUpdates_dropDown_day.setEnabled(false);
        }
    }//GEN-LAST:event_preferences_internetUpdates_cb_automaticUpdatesActionPerformed

    private void preferences_internetUpdates_cb_warningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_internetUpdates_cb_warningActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preferences_internetUpdates_cb_warningActionPerformed

    private void preferences_internetUpdates_cb_updateOnLogonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_internetUpdates_cb_updateOnLogonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preferences_internetUpdates_cb_updateOnLogonActionPerformed

    //filters
    private void preferences_filters_lblicon_up_topMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_preferences_filters_lblicon_up_topMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_preferences_filters_lblicon_up_topMouseClicked

    private void preferences_filters_lblicon_down_topMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_preferences_filters_lblicon_down_topMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_preferences_filters_lblicon_down_topMouseClicked

    private void preferences_filters_lblicon_edit_topMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_preferences_filters_lblicon_edit_topMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_preferences_filters_lblicon_edit_topMouseClicked

    private void preferences_filters_lblicon_add_topMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_preferences_filters_lblicon_add_topMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_preferences_filters_lblicon_add_topMouseClicked

    private void preferences_filters_lblicon_delete_topMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_preferences_filters_lblicon_delete_topMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_preferences_filters_lblicon_delete_topMouseClicked

    private void preferences_filters_lblicon_up_bottomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_preferences_filters_lblicon_up_bottomMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_preferences_filters_lblicon_up_bottomMouseClicked

    private void preferences_filters_lblicon_down_bottomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_preferences_filters_lblicon_down_bottomMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_preferences_filters_lblicon_down_bottomMouseClicked

    private void preferences_filters_lblicon_edit_bottomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_preferences_filters_lblicon_edit_bottomMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_preferences_filters_lblicon_edit_bottomMouseClicked

    private void preferences_filters_lblicon_add_bottomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_preferences_filters_lblicon_add_bottomMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_preferences_filters_lblicon_add_bottomMouseClicked

    private void preferences_filters_lblicon_delete_bottomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_preferences_filters_lblicon_delete_bottomMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_preferences_filters_lblicon_delete_bottomMouseClicked

    //scaheduled scans
    private void preferences_scheduledScans_btn_activateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_scheduledScans_btn_activateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preferences_scheduledScans_btn_activateActionPerformed

    private void preferences_scheduledScans_btn_deactivateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_scheduledScans_btn_deactivateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preferences_scheduledScans_btn_deactivateActionPerformed

    private void preferences_scheduledScans_lblicon_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_preferences_scheduledScans_lblicon_editMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_preferences_scheduledScans_lblicon_editMouseClicked

    private void preferences_scheduledScans_lblicon_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_preferences_scheduledScans_lblicon_addMouseClicked
        
        PreferencesScheduledAddNew pAddNew = new PreferencesScheduledAddNew();
        pAddNew.setVisible(true);
        
        
    }//GEN-LAST:event_preferences_scheduledScans_lblicon_addMouseClicked

    private void preferences_scheduledScans_lblicon_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_preferences_scheduledScans_lblicon_deleteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_preferences_scheduledScans_lblicon_deleteMouseClicked

    //file Locations
    private void preferences_fileLocations_textField_databaseLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_fileLocations_textField_databaseLocationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preferences_fileLocations_textField_databaseLocationActionPerformed

    //clamScan Loation
    private void preferences_fileLocations_lblicon_scanLocationBrowseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_preferences_fileLocations_lblicon_scanLocationBrowseMouseClicked
        
        preferencesFileLocationFileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileFilter filter = new FileNameExtensionFilter(".exe","exe");
        preferencesFileLocationFileChooser.setFileFilter(filter);
        int result = preferencesFileLocationFileChooser.showOpenDialog(this);
        
        if (result == preferencesFileLocationFileChooser.APPROVE_OPTION) {
            File chosenFile = preferencesFileLocationFileChooser.getSelectedFile();
            preferences_fileLocations_textField_scanLocation.setText(chosenFile.getAbsolutePath());
        }
        
    }//GEN-LAST:event_preferences_fileLocations_lblicon_scanLocationBrowseMouseClicked

    //freshClam Location
    private void preferences_fileLocations_lblicon_freshLocationBrowseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_preferences_fileLocations_lblicon_freshLocationBrowseMouseClicked
        
        preferencesFileLocationFileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileFilter filter = new FileNameExtensionFilter(".exe","exe");
        preferencesFileLocationFileChooser.setFileFilter(filter);
        int result = preferencesFileLocationFileChooser.showOpenDialog(this);
        
        if (result == preferencesFileLocationFileChooser.APPROVE_OPTION) {
            File chosenFile = preferencesFileLocationFileChooser.getSelectedFile();
            preferences_fileLocations_textField_freshLocation.setText(chosenFile.getAbsolutePath());
        }
    }//GEN-LAST:event_preferences_fileLocations_lblicon_freshLocationBrowseMouseClicked

    //database Location
    private void preferences_fileLocations_lblicon_databaseLocationBrowseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_preferences_fileLocations_lblicon_databaseLocationBrowseMouseClicked
        
        preferencesFileLocationFileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileFilter filter = new FileNameExtensionFilter("db","db");
        preferencesFileLocationFileChooser.setFileFilter(filter);
        int result = preferencesFileLocationFileChooser.showOpenDialog(this);
        
        if (result == preferencesFileLocationFileChooser.APPROVE_OPTION) {
            File chosenFile = preferencesFileLocationFileChooser.getSelectedFile();
            preferences_fileLocations_textField_databaseLocation.setText(chosenFile.getAbsolutePath());
        }
        
    }//GEN-LAST:event_preferences_fileLocations_lblicon_databaseLocationBrowseMouseClicked

    //email alerts
    private void preferences_emailAlerts_cb_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_emailAlerts_cb_emailActionPerformed
        if(preferences_emailAlerts_cb_email.isSelected()){
            
            preferences_emailAlerts_textField_mailServer.setEnabled(true);
            preferences_emailAlerts_textField_port.setEnabled(true);
            preferences_emailAlerts_textField_username.setEnabled(true);
            preferences_emailAlerts_textField_password.setEnabled(true);
            preferences_emailAlerts_textField_from.setEnabled(true);
            preferences_emailAlerts_textField_to.setEnabled(true);
            preferences_emailAlerts_textField_subject.setEnabled(true);
            preferences_emailAlerts_btn_sendTestEmail.setEnabled(true);
            
            
        }else{
            
            preferences_emailAlerts_textField_mailServer.setEnabled(false);
            preferences_emailAlerts_textField_port.setEnabled(false);
            preferences_emailAlerts_textField_username.setEnabled(false);
            preferences_emailAlerts_textField_password.setEnabled(false);
            preferences_emailAlerts_textField_from.setEnabled(false);
            preferences_emailAlerts_textField_to.setEnabled(false);
            preferences_emailAlerts_textField_subject.setEnabled(false);
            preferences_emailAlerts_btn_sendTestEmail.setEnabled(false);      
            
        }
    }//GEN-LAST:event_preferences_emailAlerts_cb_emailActionPerformed

    //test email button click
    private void preferences_emailAlerts_btn_sendTestEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_emailAlerts_btn_sendTestEmailActionPerformed
        
        //setting the sending test mail dialog box
        JOptionPane sendingOptionPane = new JOptionPane("Sending Test Email...", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
                  
        JDialog sendingDialog = sendingOptionPane.createDialog(null, "ClamWin Free Antivirus");
        sendingDialog.setModal(true);
                
        Timer t1 = new Timer(2000, new ActionListener() {
                    
            public void actionPerformed(ActionEvent e) {
                sendingDialog.setVisible(false);
            }
        });
        
        if(preferences_emailAlerts_textField_from.getText().isEmpty() || preferences_emailAlerts_textField_to.getText().isEmpty() || preferences_emailAlerts_textField_subject.getText().isEmpty()){
            
                //sending test mail dialog box
                t1.start();
                
                sendingDialog.setVisible(true);
                
                t1.stop();
           
                //test fail dialog box
                JOptionPane SendingFailOptionPane = new JOptionPane("Test Email Failed, please retry again !", JOptionPane.INFORMATION_MESSAGE);
                  
                JDialog sendingFailDialog = SendingFailOptionPane.createDialog(null, "ClamWin Free Antivirus");
                sendingFailDialog.setModal(true);
                sendingFailDialog.setVisible(true);
       
        }else{
            
                //sending test mail dialog box
                t1.start();
                
                sendingDialog.setVisible(true);
                
                t1.stop();
           
                //test successful dialog box
                JOptionPane SendingSuccessOptionPane = new JOptionPane("Test Email Successful !", JOptionPane.INFORMATION_MESSAGE);
                  
                JDialog sendingSuccessDialog = SendingSuccessOptionPane.createDialog(null, "ClamWin Free Antivirus");
                sendingSuccessDialog.setModal(true);
                sendingSuccessDialog.setVisible(true);
            
            
        }
    }//GEN-LAST:event_preferences_emailAlerts_btn_sendTestEmailActionPerformed

    private void preferences_emailAlerts_textField_toActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_emailAlerts_textField_toActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preferences_emailAlerts_textField_toActionPerformed

    private void preferences_emailAlerts_textField_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_emailAlerts_textField_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preferences_emailAlerts_textField_usernameActionPerformed

    //email scanning
    private void preferences_internetUpdates_cb_automaticUpdates1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_internetUpdates_cb_automaticUpdates1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preferences_internetUpdates_cb_automaticUpdates1ActionPerformed

    private void preferences_internetUpdates_cb_automaticUpdates2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_internetUpdates_cb_automaticUpdates2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preferences_internetUpdates_cb_automaticUpdates2ActionPerformed

    private void preferences_internetUpdates_cb_automaticUpdates3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_internetUpdates_cb_automaticUpdates3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preferences_internetUpdates_cb_automaticUpdates3ActionPerformed

    //limits
    //extarct from archives check box
    private void preferences_limits_cb_extractFromArchivesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_limits_cb_extractFromArchivesActionPerformed
       
        if(preferences_limits_cb_extractFromArchives.isSelected()){
           
           preferences_limits_spinner2.setEnabled(true);
           preferences_limits_spinner3.setEnabled(true);
           preferences_limits_spinner4.setEnabled(true);
           
       }else{
           
           preferences_limits_spinner2.setEnabled(false);
           preferences_limits_spinner3.setEnabled(false);
           preferences_limits_spinner4.setEnabled(false);
           
       }
    }//GEN-LAST:event_preferences_limits_cb_extractFromArchivesActionPerformed

    private void preferences_reports_cb_popUpNotificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_reports_cb_popUpNotificationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preferences_reports_cb_popUpNotificationActionPerformed

    private void preferences_proxy_textField_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_proxy_textField_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preferences_proxy_textField_usernameActionPerformed

    private void preferences_advanced_cb_extractAttachmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_advanced_cb_extractAttachmentsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preferences_advanced_cb_extractAttachmentsActionPerformed

    private void preferences_advanced_textField_additionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_advanced_textField_additionalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preferences_advanced_textField_additionalActionPerformed

    //internetUpdates continue
    private void preferences_internetUpdates_dropDown_frequencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferences_internetUpdates_dropDown_frequencyActionPerformed
        if(preferences_internetUpdates_dropDown_frequency.getSelectedItem().equals("Weekly")){
            
            preferences_internetUpdates_dropDown_day.setEnabled(true);
            
        }else{
            
            preferences_internetUpdates_dropDown_day.setEnabled(false);
            
        }
    }//GEN-LAST:event_preferences_internetUpdates_dropDown_frequencyActionPerformed

    //reports continue
    //scan report loction
    private void preferences_reports_lblicon_scanReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_preferences_reports_lblicon_scanReportMouseClicked
                
        preferencesReportsFileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileFilter filter = new FileNameExtensionFilter(".txt","txt");
        preferencesReportsFileChooser.setFileFilter(filter);
        int result = preferencesReportsFileChooser.showOpenDialog(this);
        
        if (result == preferencesReportsFileChooser.APPROVE_OPTION) {
            File chosenFile = preferencesReportsFileChooser.getSelectedFile();
            preferences_reports_textField_scanReport.setText(chosenFile.getAbsolutePath());
        }
        
    }//GEN-LAST:event_preferences_reports_lblicon_scanReportMouseClicked

    //database report location
    private void preferences_reports_lblicon_databaseReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_preferences_reports_lblicon_databaseReportMouseClicked
        
        preferencesReportsFileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileFilter filter = new FileNameExtensionFilter(".txt","txt");
        preferencesReportsFileChooser.setFileFilter(filter);
        int result = preferencesReportsFileChooser.showOpenDialog(this);
        
        if (result == preferencesReportsFileChooser.APPROVE_OPTION) {
            File chosenFile = preferencesReportsFileChooser.getSelectedFile();
            preferences_reports_textField_databaseReport.setText(chosenFile.getAbsolutePath());
        }
    }//GEN-LAST:event_preferences_reports_lblicon_databaseReportMouseClicked

    
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
            java.util.logging.Logger.getLogger(Preferences.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Preferences.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Preferences.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Preferences.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Preferences().setVisible(true);
               
            }
        });    
    }
    
    //boder	
    Border border = BorderFactory.createMatteBorder(100,0,0,0,new Color(158,148,195));
    JFileChooser preferencesGeneralFileChooser = new JFileChooser();
    JFileChooser preferencesFileLocationFileChooser = new JFileChooser();
    JFileChooser preferencesReportsFileChooser = new JFileChooser();
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel card_preferences_advanced;
    private javax.swing.JPanel card_preferences_emailAlerts;
    private javax.swing.JPanel card_preferences_emailScanning;
    private javax.swing.JPanel card_preferences_fileLocations;
    private javax.swing.JPanel card_preferences_filters;
    private javax.swing.JPanel card_preferences_general;
    private javax.swing.JPanel card_preferences_internetUpdates;
    private javax.swing.JPanel card_preferences_limits;
    private javax.swing.JPanel card_preferences_proxy;
    private javax.swing.JPanel card_preferences_reports;
    private javax.swing.JPanel card_preferences_scheduledScans;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lbl_btn_preferences_close;
    private javax.swing.JLabel lbl_btn_preferences_minimize;
    private javax.swing.JLabel lbl_preferences_left_advanced;
    private javax.swing.JLabel lbl_preferences_left_emailAlerts;
    private javax.swing.JLabel lbl_preferences_left_emailScanning;
    private javax.swing.JLabel lbl_preferences_left_fileLocations;
    private javax.swing.JLabel lbl_preferences_left_filters;
    private javax.swing.JLabel lbl_preferences_left_general;
    private javax.swing.JLabel lbl_preferences_left_internetUpdates;
    private javax.swing.JLabel lbl_preferences_left_limits;
    private javax.swing.JLabel lbl_preferences_left_mainMenu;
    private javax.swing.JLabel lbl_preferences_left_proxy;
    private javax.swing.JLabel lbl_preferences_left_reports;
    private javax.swing.JLabel lbl_preferences_left_scheduledScans;
    private javax.swing.JLabel lbl_preferences_titile;
    private javax.swing.JPanel panel_preferences_left;
    private javax.swing.JPanel panel_preferences_left_InternetUpdates;
    private javax.swing.JPanel panel_preferences_left_advanced;
    private javax.swing.JPanel panel_preferences_left_emailAlerts;
    private javax.swing.JPanel panel_preferences_left_emailScanning;
    private javax.swing.JPanel panel_preferences_left_fileLocations;
    private javax.swing.JPanel panel_preferences_left_filters;
    private javax.swing.JPanel panel_preferences_left_general;
    private javax.swing.JPanel panel_preferences_left_limits;
    private javax.swing.JPanel panel_preferences_left_mainMenu;
    private javax.swing.JPanel panel_preferences_left_proxy;
    private javax.swing.JPanel panel_preferences_left_reports;
    private javax.swing.JPanel panel_preferences_left_scheduledScans;
    private javax.swing.JPanel panel_preferences_right;
    private javax.swing.JPanel panel_preferences_top;
    private java.awt.Button preferences_advanced_btn_save;
    private javax.swing.JCheckBox preferences_advanced_cb_extractAttachments;
    private javax.swing.JComboBox preferences_advanced_combo_scanningPriority;
    private javax.swing.JLabel preferences_advanced_lbl_additional;
    private javax.swing.JLabel preferences_advanced_lbl_info;
    private javax.swing.JLabel preferences_advanced_lbl_line;
    private javax.swing.JLabel preferences_advanced_lbl_logFileSize;
    private javax.swing.JLabel preferences_advanced_lbl_megaBytes;
    private javax.swing.JLabel preferences_advanced_lbl_scannerPriority;
    private javax.swing.JPanel preferences_advanced_panel_bottom;
    private javax.swing.JPanel preferences_advanced_panel_top;
    private javax.swing.JSpinner preferences_advanced_spinner_logFileSize;
    private javax.swing.JTextField preferences_advanced_textField_additional;
    private java.awt.Button preferences_emailAlerts_btn_save;
    private java.awt.Button preferences_emailAlerts_btn_sendTestEmail;
    private javax.swing.JCheckBox preferences_emailAlerts_cb_email;
    private javax.swing.JPanel preferences_emailAlerts_lbl_bottom;
    private javax.swing.JLabel preferences_emailAlerts_lbl_from;
    private javax.swing.JLabel preferences_emailAlerts_lbl_heading1;
    private javax.swing.JLabel preferences_emailAlerts_lbl_heading2;
    private javax.swing.JLabel preferences_emailAlerts_lbl_info;
    private javax.swing.JLabel preferences_emailAlerts_lbl_line;
    private javax.swing.JLabel preferences_emailAlerts_lbl_mailServer;
    private javax.swing.JLabel preferences_emailAlerts_lbl_password;
    private javax.swing.JLabel preferences_emailAlerts_lbl_port;
    private javax.swing.JLabel preferences_emailAlerts_lbl_subject;
    private javax.swing.JLabel preferences_emailAlerts_lbl_to;
    private javax.swing.JLabel preferences_emailAlerts_lbl_username;
    private javax.swing.JPanel preferences_emailAlerts_panel_top;
    private javax.swing.JTextField preferences_emailAlerts_textField_from;
    private javax.swing.JTextField preferences_emailAlerts_textField_mailServer;
    private javax.swing.JPasswordField preferences_emailAlerts_textField_password;
    private javax.swing.JTextField preferences_emailAlerts_textField_port;
    private javax.swing.JTextField preferences_emailAlerts_textField_subject;
    private javax.swing.JTextField preferences_emailAlerts_textField_to;
    private javax.swing.JTextField preferences_emailAlerts_textField_username;
    private java.awt.Button preferences_emailScan_btn_save;
    private javax.swing.JLabel preferences_emailScan_lbl_heading1;
    private javax.swing.JLabel preferences_emailScan_lbl_info;
    private javax.swing.JLabel preferences_emailScan_lbl_line;
    private javax.swing.JPanel preferences_emailScan_panel_bottom;
    private javax.swing.JPanel preferences_emailScan_panel_top;
    private java.awt.Button preferences_fileLocations_btn_save;
    private javax.swing.JLabel preferences_fileLocations_lbl_heaading1;
    private javax.swing.JLabel preferences_fileLocations_lbl_heaading2;
    private javax.swing.JLabel preferences_fileLocations_lbl_heaading3;
    private javax.swing.JLabel preferences_fileLocations_lbl_info;
    private javax.swing.JLabel preferences_fileLocations_lbl_line;
    private javax.swing.JLabel preferences_fileLocations_lblicon_databaseLocationBrowse;
    private javax.swing.JLabel preferences_fileLocations_lblicon_freshLocationBrowse;
    private javax.swing.JLabel preferences_fileLocations_lblicon_scanLocationBrowse;
    private javax.swing.JPanel preferences_fileLocations_panel_bottom;
    private javax.swing.JPanel preferences_fileLocations_panel_info;
    private javax.swing.JTextField preferences_fileLocations_textField_databaseLocation;
    private javax.swing.JTextField preferences_fileLocations_textField_freshLocation;
    private javax.swing.JTextField preferences_fileLocations_textField_scanLocation;
    private java.awt.Button preferences_filters_btn_save;
    private javax.swing.JLabel preferences_filters_lbl_heading1;
    private javax.swing.JLabel preferences_filters_lbl_heading2;
    private javax.swing.JLabel preferences_filters_lbl_info;
    private javax.swing.JLabel preferences_filters_lbl_line;
    private javax.swing.JLabel preferences_filters_lblicon_add_bottom;
    private javax.swing.JLabel preferences_filters_lblicon_add_top;
    private javax.swing.JLabel preferences_filters_lblicon_delete_bottom;
    private javax.swing.JLabel preferences_filters_lblicon_delete_top;
    private javax.swing.JLabel preferences_filters_lblicon_down_bottom;
    private javax.swing.JScrollPane preferences_filters_lblicon_down_scroll;
    private javax.swing.JLabel preferences_filters_lblicon_down_top;
    private javax.swing.JLabel preferences_filters_lblicon_edit_bottom;
    private javax.swing.JLabel preferences_filters_lblicon_edit_top;
    private javax.swing.JLabel preferences_filters_lblicon_up_bottom;
    private javax.swing.JScrollPane preferences_filters_lblicon_up_scroll;
    private javax.swing.JLabel preferences_filters_lblicon_up_top;
    private java.awt.Button preferences_general_btn_save;
    private javax.swing.JCheckBox preferences_general_cb_displayInfected;
    private javax.swing.JCheckBox preferences_general_cb_displayProgress;
    private javax.swing.JLabel preferences_general_cb_subDirectories;
    private javax.swing.JCheckBox preferences_general_cb_subdirectories;
    private javax.swing.JCheckBox preferences_general_cb_unload;
    private javax.swing.JLabel preferences_general_lbl_heading1;
    private javax.swing.JLabel preferences_general_lbl_info;
    private javax.swing.JLabel preferences_general_lblicon_browse;
    private javax.swing.JLabel preferences_general_lblicon_line;
    private javax.swing.JRadioButton preferences_general_rb_folder;
    private javax.swing.JRadioButton preferences_general_rb_remove;
    private javax.swing.JRadioButton preferences_general_rb_report;
    private javax.swing.JTextField preferences_general_textfield1;
    private javax.swing.JCheckBox preferences_internetUpdates_cb_automaticUpdates;
    private javax.swing.JCheckBox preferences_internetUpdates_cb_automaticUpdates1;
    private javax.swing.JCheckBox preferences_internetUpdates_cb_automaticUpdates2;
    private javax.swing.JCheckBox preferences_internetUpdates_cb_automaticUpdates3;
    private javax.swing.JCheckBox preferences_internetUpdates_cb_notify;
    private javax.swing.JCheckBox preferences_internetUpdates_cb_updateOnLogon;
    private javax.swing.JCheckBox preferences_internetUpdates_cb_warning;
    private javax.swing.JComboBox preferences_internetUpdates_dropDown_day;
    private javax.swing.JComboBox preferences_internetUpdates_dropDown_frequency;
    private javax.swing.JLabel preferences_internetUpdates_lbl_day;
    private javax.swing.JLabel preferences_internetUpdates_lbl_downloadSite;
    private javax.swing.JLabel preferences_internetUpdates_lbl_frequency;
    private javax.swing.JLabel preferences_internetUpdates_lbl_heading1;
    private javax.swing.JLabel preferences_internetUpdates_lbl_heading2;
    private javax.swing.JLabel preferences_internetUpdates_lbl_info;
    private javax.swing.JLabel preferences_internetUpdates_lbl_line;
    private javax.swing.JPanel preferences_internetUpdates_panel_bottom;
    private javax.swing.JPanel preferences_internetUpdates_panel_top;
    private javax.swing.JSpinner preferences_internetUpdates_spinner_time;
    private javax.swing.JTextField preferences_internetUpdates_textField_downloadSite;
    private java.awt.Button preferences_internetUpdatesl_btn_save;
    private java.awt.Button preferences_limits_btn_save;
    private javax.swing.JCheckBox preferences_limits_cb_extractFromArchives;
    private javax.swing.JLabel preferences_limits_lbl_doNotExtractMoreThan1;
    private javax.swing.JLabel preferences_limits_lbl_doNotExtractMoreThan2;
    private javax.swing.JLabel preferences_limits_lbl_doNotExtractMoreThan3;
    private javax.swing.JLabel preferences_limits_lbl_doNotScanMoreThan;
    private javax.swing.JLabel preferences_limits_lbl_files;
    private javax.swing.JLabel preferences_limits_lbl_heading1;
    private javax.swing.JLabel preferences_limits_lbl_heading2;
    private javax.swing.JLabel preferences_limits_lbl_info;
    private javax.swing.JLabel preferences_limits_lbl_line;
    private javax.swing.JLabel preferences_limits_lbl_megabytes1;
    private javax.swing.JLabel preferences_limits_lbl_megabytes2;
    private javax.swing.JLabel preferences_limits_lbl_subArchives;
    private javax.swing.JPanel preferences_limits_panel_bottom;
    private javax.swing.JPanel preferences_limits_panel_top;
    private javax.swing.JSpinner preferences_limits_spinner1;
    private javax.swing.JSpinner preferences_limits_spinner2;
    private javax.swing.JSpinner preferences_limits_spinner3;
    private javax.swing.JSpinner preferences_limits_spinner4;
    private java.awt.Button preferences_proxy_btn_save;
    private javax.swing.JLabel preferences_proxy_lbl_heading1;
    private javax.swing.JLabel preferences_proxy_lbl_heading2;
    private javax.swing.JLabel preferences_proxy_lbl_line;
    private javax.swing.JLabel preferences_proxy_lbl_password;
    private javax.swing.JLabel preferences_proxy_lbl_port;
    private javax.swing.JLabel preferences_proxy_lbl_proxyServer;
    private javax.swing.JLabel preferences_proxy_lbl_username;
    private javax.swing.JPanel preferences_proxy_panel_bottom;
    private javax.swing.JLabel preferences_proxy_panel_top;
    private javax.swing.JPasswordField preferences_proxy_textField_password;
    private javax.swing.JTextField preferences_proxy_textField_port;
    private javax.swing.JTextField preferences_proxy_textField_proxyServer;
    private javax.swing.JTextField preferences_proxy_textField_username;
    private java.awt.Button preferences_reports_btn_save;
    private javax.swing.JCheckBox preferences_reports_cb_popUpNotification;
    private javax.swing.JLabel preferences_reports_lbl_heading1;
    private javax.swing.JLabel preferences_reports_lbl_heading2;
    private javax.swing.JLabel preferences_reports_lbl_info;
    private javax.swing.JLabel preferences_reports_lbl_line;
    private javax.swing.JLabel preferences_reports_lblicon_databaseReport;
    private javax.swing.JLabel preferences_reports_lblicon_scanReport;
    private javax.swing.JPanel preferences_reports_panel_bottom;
    private javax.swing.JPanel preferences_reports_panel_top;
    private javax.swing.JTextField preferences_reports_textField_databaseReport;
    private javax.swing.JTextField preferences_reports_textField_scanReport;
    private java.awt.Button preferences_scheduledScans_btn_activate;
    private java.awt.Button preferences_scheduledScans_btn_deactivate;
    private javax.swing.JLabel preferences_scheduledScans_lbl_heading1;
    private javax.swing.JLabel preferences_scheduledScans_lbl_info;
    private javax.swing.JLabel preferences_scheduledScans_lbl_line;
    private javax.swing.JLabel preferences_scheduledScans_lblicon_add;
    private javax.swing.JLabel preferences_scheduledScans_lblicon_delete;
    private javax.swing.JLabel preferences_scheduledScans_lblicon_edit;
    private javax.swing.JPanel preferences_scheduledScans_panel_bottom;
    private javax.swing.JPanel preferences_scheduledScans_panel_top;
    private javax.swing.JScrollPane preferences_scheduledScans_scrollPane;
    private java.awt.Button preferences_schedulesScans_btn_save;
    // End of variables declaration//GEN-END:variables
}

