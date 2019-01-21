/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.view;

import id.uniondev.creams.controller.CustomerController;
import id.uniondev.creams.controller.EmployeeController;
import id.uniondev.creams.controller.CustomerCreditController;
import id.uniondev.creams.controller.CreditRestockKuotaController;
import id.uniondev.creams.database.CreamsDatabase;
import id.uniondev.creams.entity.CreditRestockKuota;
import id.uniondev.creams.entity.Customer;
import id.uniondev.creams.entity.Employee;
import id.uniondev.creams.entity.CustomerCredit;
import id.uniondev.creams.error.CreditRestockKuotaException;
import id.uniondev.creams.error.CustomerCreditException;
import id.uniondev.creams.error.CustomerException;
import id.uniondev.creams.error.EmployeeException;
import id.uniondev.creams.event.CreditRestockKuotaListener;
import id.uniondev.creams.event.CustomerListener;
import id.uniondev.creams.event.EmployeeListener;
import id.uniondev.creams.model.CustomerModel;
import id.uniondev.creams.model.CustomerTableModel;
import id.uniondev.creams.model.EmployeeModel;
import id.uniondev.creams.model.EmployeeTableModel;
import id.uniondev.creams.model.CustomerCreditModel;
import id.uniondev.creams.model.CustomerCreditTableModel;
import id.uniondev.creams.service.CustomerDao;
import id.uniondev.creams.service.EmployeeDao;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import id.uniondev.creams.event.CustomerCreditListener;
import id.uniondev.creams.model.CreditRestockKuotaModel;
import id.uniondev.creams.model.CreditRestockKuotaTableModel;
import id.uniondev.creams.service.CreditRestockKuotaDao;
import id.uniondev.creams.service.CustomerCreditDao;

/**
 *
 * @author UnionDev
 */
public class MainFrame extends javax.swing.JFrame implements EmployeeListener, CustomerListener, CustomerCreditListener, CreditRestockKuotaListener, ListSelectionListener {

    /**
     * Creates new form MainFrame
     */
    private Color sidemenu_entered = new Color(142,36,171);
    private Color sidemenu_exited = new Color(92,0,122);
    private Color sidemenu_pressed = new Color(153,0,153);
    private Color sidemenu_active_color = new Color(153,0,153);
    private int sidemenu_active;
    
    private EmployeeTableModel employeeTableModel;
    private CustomerTableModel customerTableModel;
    private CustomerCreditTableModel customerCreditTableModel;
    private CreditRestockKuotaTableModel creditRestockKuotaTableModel;
    
    private EmployeeModel employeeModel;
    private CustomerModel customerModel;
    private CustomerCreditModel customerCreditModel;
    private CreditRestockKuotaModel creditRestockKuotaModel;
    
    private EmployeeController employeeController;
    private CustomerController customerController;
    private CustomerCreditController customerCreditController;
    private CreditRestockKuotaController creditRestockKuotaController;
    
    public MainFrame() {
        employeeTableModel = new EmployeeTableModel();
        employeeModel = new EmployeeModel();
        employeeModel.setListener(this);
        employeeController = new EmployeeController();
        employeeController.setModel(employeeModel);
        
        customerTableModel = new CustomerTableModel();
        customerModel = new CustomerModel();
        customerModel.setListener(this);
        customerController = new CustomerController();
        customerController.setModel(customerModel);
        
        customerCreditTableModel = new CustomerCreditTableModel();
        customerCreditModel = new CustomerCreditModel();
        customerCreditModel.setListener(this);
        customerCreditController = new CustomerCreditController();
        customerCreditController.setModel(customerCreditModel);
        
        creditRestockKuotaTableModel = new CreditRestockKuotaTableModel();
        creditRestockKuotaModel = new CreditRestockKuotaModel();
        creditRestockKuotaModel.setListener(this);
        creditRestockKuotaController = new CreditRestockKuotaController();
        creditRestockKuotaController.setModel(creditRestockKuotaModel);
        
        initComponents();
        
        tblEmployee.getSelectionModel().addListSelectionListener(this);
        tblEmployee.setModel(employeeTableModel);
        
        tblCustomer.getSelectionModel().addListSelectionListener(this);
        tblCustomer.setModel(customerTableModel);
        
        tblCustomerCredit.getSelectionModel().addListSelectionListener(this);
        tblCustomerCredit.setModel(customerCreditTableModel);
        
        tblRestockKuotaPulsa.getSelectionModel().addListSelectionListener(this);
        tblRestockKuotaPulsa.setModel(creditRestockKuotaTableModel);
    }

    public JTable getTblCustomerCredit() {
        return tblCustomerCredit;
    }
    
    public JComboBox getCbBesarPulsaHome() {
        return cbBesarPulsaHome;
    }

    public JComboBox getCbProviderPulsaHome() {
        return cbProviderPulsaHome;
    }

    public JTextField getTxtFormNomorPulsaHome() {
        return txtFormNomorPulsaHome;
    }

    public JTextField getTxtIsiPulsaHome() {
        return txtIsiPulsaHome;
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
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        backGround = new javax.swing.JPanel();
        headView = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblHeaderName = new javax.swing.JLabel();
        panelView = new javax.swing.JPanel();
        panelHomeView = new javax.swing.JPanel();
        btnFormSubmitPulsaHome = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        txtFormNomorPulsaHome = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cbProviderPulsaHome = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        cbBesarPulsaHome = new javax.swing.JComboBox();
        txtIsiPulsaHome = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        panelPulsaView = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblCustomerCredit = new javax.swing.JTable();
        jScrollBar5 = new javax.swing.JScrollBar();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblRestockKuotaPulsa = new javax.swing.JTable();
        btnReStockKuotaPulsa = new javax.swing.JButton();
        cbProviderPulsa = new javax.swing.JComboBox();
        cbBesarPulsa = new javax.swing.JComboBox();
        panelKartuView = new javax.swing.JPanel();
        btnReStock = new javax.swing.JButton();
        btnStock = new javax.swing.JButton();
        panelReStockView = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        cbJenisReStock = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        cbProviderReStock = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        txtJumlahNomorReStock = new javax.swing.JTextField();
        btnNextReStock = new javax.swing.JButton();
        btnSubmitReStock = new javax.swing.JButton();
        panelReStockPerdanaView = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblReStockPerdana = new javax.swing.JTable();
        btnSaveReStockPerdana = new javax.swing.JButton();
        btnBackReStockPerdana = new javax.swing.JButton();
        btnSubmitReStockPerdana = new javax.swing.JButton();
        jScrollBar1 = new javax.swing.JScrollBar();
        panelReStockKuotaView = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollBar2 = new javax.swing.JScrollBar();
        btnBackReStockKuota = new javax.swing.JButton();
        btnSaveReStockKuota = new javax.swing.JButton();
        btnSubmitReStockKuota = new javax.swing.JButton();
        paneFormlReStockKuota = new javax.swing.JPanel();
        btnRestockKuotaSave = new javax.swing.JButton();
        txtRestockKuotaBalance_current = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtRestockKuotaProviderName = new javax.swing.JTextField();
        txtRestockKuotaType = new javax.swing.JTextField();
        panelStockView = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblStock = new javax.swing.JTable();
        jScrollBar3 = new javax.swing.JScrollBar();
        jButton9 = new javax.swing.JButton();
        cbFilterProviderStock = new javax.swing.JComboBox();
        cbFilterJenisStock = new javax.swing.JComboBox();
        btnEditStock = new javax.swing.JButton();
        btnDeleteStock = new javax.swing.JButton();
        panelTagihanView = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        cbJenisTagihan = new javax.swing.JComboBox();
        jScrollBar4 = new javax.swing.JScrollBar();
        btnEditTagihan = new javax.swing.JButton();
        btnDeleteTagihan = new javax.swing.JButton();
        btnCreateTagihan = new javax.swing.JButton();
        txtSisaKuota = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        btnReStockKuotaTagihan = new javax.swing.JButton();
        panelPendapatanView = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtPulsaPendapatan = new javax.swing.JTextField();
        txtKartuKuotaPendapatan = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtKartuPerdanaPendapatan = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtPLNPendapatan = new javax.swing.JTextField();
        txtPDAMPendapatan = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtPengeluaranPendapatan = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jTextField9 = new javax.swing.JTextField();
        txtTotalPendapatan = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        panelManageView = new javax.swing.JPanel();
        btnEmployeeView = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnCustomerView = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        panelManageEmployeeView = new javax.swing.JPanel();
        lblHeaderEmployee = new javax.swing.JLabel();
        btnFormEmployeeDelete = new javax.swing.JButton();
        spEmployee = new javax.swing.JScrollPane();
        tblEmployee = new javax.swing.JTable();
        btnFormEmployee = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        panelFormEmployeeView = new javax.swing.JPanel();
        lblHeaderFormEmployee = new javax.swing.JLabel();
        lblFormIdEmployee = new javax.swing.JLabel();
        txtId_Employee = new javax.swing.JTextField();
        lblFormPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        lblEmployee_name = new javax.swing.JLabel();
        txtEmployee_name = new javax.swing.JTextField();
        lblRole = new javax.swing.JLabel();
        txtRole = new javax.swing.JTextField();
        btnBacktoManageEmployee = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        lblFormUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        btnFormEmployeeCreate = new javax.swing.JButton();
        btnFormEmployeeUpdate = new javax.swing.JButton();
        btnFormEmployeeReset = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        panelManageCustomerView = new javax.swing.JPanel();
        lblHeaderCustomer = new javax.swing.JLabel();
        btnFormCustomerDelete = new javax.swing.JButton();
        spCustomer = new javax.swing.JScrollPane();
        tblCustomer = new javax.swing.JTable();
        btnFormCustomer = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        panelFormCustomerView = new javax.swing.JPanel();
        lblHeaderFormEmployee1 = new javax.swing.JLabel();
        lblFormIdEmployee1 = new javax.swing.JLabel();
        txtId_customer = new javax.swing.JTextField();
        lblEmployee_name1 = new javax.swing.JLabel();
        txtCustomer_name = new javax.swing.JTextField();
        lblRole1 = new javax.swing.JLabel();
        txtCustomerPhoneNumber = new javax.swing.JTextField();
        btnBacktoManageCustomer = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        btnFormCustomerCreate = new javax.swing.JButton();
        btnFormCustomerUpdate = new javax.swing.JButton();
        btnFormCustomerReset = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        txtCustomerStatus = new javax.swing.JTextField();
        lblRole2 = new javax.swing.JLabel();
        sidePane = new javax.swing.JPanel();
        lblAppName = new javax.swing.JLabel();
        btnHomeMenu = new javax.swing.JPanel();
        icoHome = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnKartuMenu = new javax.swing.JPanel();
        icoKartu = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnPlnPdamMenu = new javax.swing.JPanel();
        icoPLNPDAM = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnPulsaMenu = new javax.swing.JPanel();
        icoKuota = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnPendapatanMenu = new javax.swing.JPanel();
        icoPendapatan = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAboutMenu = new javax.swing.JPanel();
        icoAbout = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnManageMenu = new javax.swing.JPanel();
        icoManage = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnLogoutMenu = new javax.swing.JPanel();
        icoLogout = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        seperatorMenu = new javax.swing.JSeparator();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Creams - Your Management App");
        setLocationByPlatform(true);

        backGround.setBackground(new java.awt.Color(0, 0, 0));
        backGround.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headView.setBackground(new java.awt.Color(40, 53, 148));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("WELCOME");

        lblHeaderName.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblHeaderName.setForeground(new java.awt.Color(255, 255, 255));
        lblHeaderName.setText("-");

        javax.swing.GroupLayout headViewLayout = new javax.swing.GroupLayout(headView);
        headView.setLayout(headViewLayout);
        headViewLayout.setHorizontalGroup(
            headViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headViewLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblHeaderName)
                .addContainerGap(632, Short.MAX_VALUE))
        );
        headViewLayout.setVerticalGroup(
            headViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headViewLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(headViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHeaderName))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        backGround.add(headView, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 770, 90));

        panelView.setBackground(new java.awt.Color(102, 102, 102));
        panelView.setLayout(new java.awt.CardLayout());

        panelHomeView.setBackground(new java.awt.Color(0, 0, 0));

        btnFormSubmitPulsaHome.setText("SAVE");
        btnFormSubmitPulsaHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormSubmitPulsaHomeActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(240, 240, 240));
        jLabel8.setText("PULSA");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Masukan Nomor : ");

        txtFormNomorPulsaHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFormNomorPulsaHomeActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(240, 240, 240));
        jLabel12.setText("Provider :");

        cbProviderPulsaHome.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cbProviderPulsaHome.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--PROVIDER--", "TELKOMSEL", "TRI", "XL", "AXIS", "INDOSAT", "SMARTFREN" }));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(240, 240, 240));
        jLabel18.setText("Besar Pulsa :");

        cbBesarPulsaHome.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cbBesarPulsaHome.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--BESAR--", "5", "10", "20", "25", "50", "100" }));
        cbBesarPulsaHome.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbBesarPulsaHomePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cbBesarPulsaHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbBesarPulsaHomeMouseClicked(evt);
            }
        });

        txtIsiPulsaHome.setEditable(false);

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Rp.");

        javax.swing.GroupLayout panelHomeViewLayout = new javax.swing.GroupLayout(panelHomeView);
        panelHomeView.setLayout(panelHomeViewLayout);
        panelHomeViewLayout.setHorizontalGroup(
            panelHomeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHomeViewLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelHomeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHomeViewLayout.createSequentialGroup()
                        .addGroup(panelHomeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFormNomorPulsaHome, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(cbProviderPulsaHome, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel18)
                            .addGroup(panelHomeViewLayout.createSequentialGroup()
                                .addComponent(cbBesarPulsaHome, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIsiPulsaHome, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnFormSubmitPulsaHome, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 385, Short.MAX_VALUE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelHomeViewLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addContainerGap())))
        );
        panelHomeViewLayout.setVerticalGroup(
            panelHomeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHomeViewLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbProviderPulsaHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFormNomorPulsaHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelHomeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbBesarPulsaHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIsiPulsaHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(30, 30, 30)
                .addComponent(btnFormSubmitPulsaHome)
                .addGap(63, 63, 63))
        );

        panelView.add(panelHomeView, "card2");

        panelPulsaView.setBackground(new java.awt.Color(0, 0, 0));

        tblCustomerCredit.setBackground(new java.awt.Color(0, 0, 0));
        tblCustomerCredit.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tblCustomerCredit.setForeground(new java.awt.Color(240, 240, 240));
        tblCustomerCredit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "PROVIDER", "NOMOR", "BESAR PULSA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblCustomerCredit);

        tblRestockKuotaPulsa.setBackground(new java.awt.Color(0, 0, 0));
        tblRestockKuotaPulsa.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tblRestockKuotaPulsa.setForeground(new java.awt.Color(240, 240, 240));
        tblRestockKuotaPulsa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"TELKOMSEL", null},
                {"TRI", null},
                {"INDOSAT", null},
                {"XL", null},
                {"AXIS", null},
                {"SMARTFREN", null}
            },
            new String [] {
                "PROVIDER", "KUOTA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tblRestockKuotaPulsa);

        btnReStockKuotaPulsa.setText("RE STOCK KUOTA");
        btnReStockKuotaPulsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReStockKuotaPulsaActionPerformed(evt);
            }
        });

        cbProviderPulsa.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cbProviderPulsa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--PROVIDER--", "TELKOMSEL", "TRI", "XL", "AXIS", "INDOSAT", "SMARTFREN", " " }));

        cbBesarPulsa.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cbBesarPulsa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--BESAR--", "5", "10", "20", "25", "50", "100" }));

        javax.swing.GroupLayout panelPulsaViewLayout = new javax.swing.GroupLayout(panelPulsaView);
        panelPulsaView.setLayout(panelPulsaViewLayout);
        panelPulsaViewLayout.setHorizontalGroup(
            panelPulsaViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPulsaViewLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelPulsaViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPulsaViewLayout.createSequentialGroup()
                        .addComponent(cbProviderPulsa, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbBesarPulsa, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelPulsaViewLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollBar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addGroup(panelPulsaViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnReStockKuotaPulsa, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                        .addGap(30, 30, 30))))
        );
        panelPulsaViewLayout.setVerticalGroup(
            panelPulsaViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPulsaViewLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelPulsaViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbProviderPulsa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbBesarPulsa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPulsaViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollBar5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(panelPulsaViewLayout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(btnReStockKuotaPulsa)))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        panelView.add(panelPulsaView, "card5");

        panelKartuView.setBackground(new java.awt.Color(0, 0, 0));

        btnReStock.setBackground(new java.awt.Color(0, 0, 0));
        btnReStock.setForeground(new java.awt.Color(240, 240, 240));
        btnReStock.setText("RE-STOCK");
        btnReStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReStockMouseClicked(evt);
            }
        });
        btnReStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReStockActionPerformed(evt);
            }
        });

        btnStock.setBackground(new java.awt.Color(0, 0, 0));
        btnStock.setForeground(new java.awt.Color(240, 240, 240));
        btnStock.setText("STOCK");
        btnStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStockMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelKartuViewLayout = new javax.swing.GroupLayout(panelKartuView);
        panelKartuView.setLayout(panelKartuViewLayout);
        panelKartuViewLayout.setHorizontalGroup(
            panelKartuViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKartuViewLayout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(btnReStock, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(btnStock, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
        );
        panelKartuViewLayout.setVerticalGroup(
            panelKartuViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKartuViewLayout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addGroup(panelKartuViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReStock, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStock, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(216, Short.MAX_VALUE))
        );

        panelView.add(panelKartuView, "card3");

        panelReStockView.setBackground(new java.awt.Color(0, 0, 0));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(240, 240, 240));
        jLabel11.setText("PROVIDER");

        cbJenisReStock.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        cbJenisReStock.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--JENIS--", "PERDANA", "KUOTA" }));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(240, 240, 240));
        jLabel16.setText("JENIS");

        cbProviderReStock.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        cbProviderReStock.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--PROVIDER--", "TELKOMSEL", "TRI", "XL", "AXIS", "INDOSAT", "SMARTFREN" }));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(240, 240, 240));
        jLabel17.setText("TOTAL NOMOR YANG AKAN DIMASUKKAN : ");

        txtJumlahNomorReStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJumlahNomorReStockActionPerformed(evt);
            }
        });

        btnNextReStock.setText("NEXT");

        btnSubmitReStock.setText("STOCK");
        btnSubmitReStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitReStockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelReStockViewLayout = new javax.swing.GroupLayout(panelReStockView);
        panelReStockView.setLayout(panelReStockViewLayout);
        panelReStockViewLayout.setHorizontalGroup(
            panelReStockViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReStockViewLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(panelReStockViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelReStockViewLayout.createSequentialGroup()
                        .addGroup(panelReStockViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtJumlahNomorReStock, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(cbProviderReStock, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel11)
                            .addComponent(cbJenisReStock, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(433, Short.MAX_VALUE))
                    .addGroup(panelReStockViewLayout.createSequentialGroup()
                        .addComponent(btnNextReStock, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSubmitReStock, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))))
        );
        panelReStockViewLayout.setVerticalGroup(
            panelReStockViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReStockViewLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbProviderReStock, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbJenisReStock, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabel17)
                .addGap(5, 5, 5)
                .addComponent(txtJumlahNomorReStock, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(panelReStockViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNextReStock)
                    .addComponent(btnSubmitReStock))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        panelView.add(panelReStockView, "card7");

        panelReStockPerdanaView.setBackground(new java.awt.Color(0, 0, 0));

        tblReStockPerdana.setBackground(new java.awt.Color(0, 0, 0));
        tblReStockPerdana.setForeground(new java.awt.Color(240, 240, 240));
        tblReStockPerdana.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "NOMOR", "HARGA", "MASA AKTIF"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblReStockPerdana);

        btnSaveReStockPerdana.setText("SAVE");
        btnSaveReStockPerdana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveReStockPerdanaActionPerformed(evt);
            }
        });

        btnBackReStockPerdana.setText("BACK");
        btnBackReStockPerdana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackReStockPerdanaActionPerformed(evt);
            }
        });

        btnSubmitReStockPerdana.setText("STOCK");
        btnSubmitReStockPerdana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitReStockPerdanaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelReStockPerdanaViewLayout = new javax.swing.GroupLayout(panelReStockPerdanaView);
        panelReStockPerdanaView.setLayout(panelReStockPerdanaViewLayout);
        panelReStockPerdanaViewLayout.setHorizontalGroup(
            panelReStockPerdanaViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReStockPerdanaViewLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 64, Short.MAX_VALUE))
            .addGroup(panelReStockPerdanaViewLayout.createSequentialGroup()
                .addGap(247, 247, 247)
                .addComponent(btnBackReStockPerdana, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnSaveReStockPerdana, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelReStockPerdanaViewLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSubmitReStockPerdana, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        panelReStockPerdanaViewLayout.setVerticalGroup(
            panelReStockPerdanaViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReStockPerdanaViewLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelReStockPerdanaViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelReStockPerdanaViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveReStockPerdana)
                    .addComponent(btnBackReStockPerdana))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(btnSubmitReStockPerdana)
                .addContainerGap())
        );

        panelView.add(panelReStockPerdanaView, "card8");

        panelReStockKuotaView.setBackground(new java.awt.Color(0, 0, 0));

        jTable1.setBackground(new java.awt.Color(0, 0, 0));
        jTable1.setForeground(new java.awt.Color(240, 240, 240));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NOMOR", "KUOTA", "HARGA", "MASA AKTIF"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnBackReStockKuota.setText("BACK");

        btnSaveReStockKuota.setText("SAVE");

        btnSubmitReStockKuota.setText("STOCK");
        btnSubmitReStockKuota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitReStockKuotaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelReStockKuotaViewLayout = new javax.swing.GroupLayout(panelReStockKuotaView);
        panelReStockKuotaView.setLayout(panelReStockKuotaViewLayout);
        panelReStockKuotaViewLayout.setHorizontalGroup(
            panelReStockKuotaViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReStockKuotaViewLayout.createSequentialGroup()
                .addGap(247, 247, 247)
                .addComponent(btnBackReStockKuota, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnSaveReStockKuota, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelReStockKuotaViewLayout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(panelReStockKuotaViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSubmitReStockKuota, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelReStockKuotaViewLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61))
        );
        panelReStockKuotaViewLayout.setVerticalGroup(
            panelReStockKuotaViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReStockKuotaViewLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelReStockKuotaViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelReStockKuotaViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBackReStockKuota)
                    .addComponent(btnSaveReStockKuota))
                .addGap(14, 14, 14)
                .addComponent(btnSubmitReStockKuota)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelView.add(panelReStockKuotaView, "card9");

        paneFormlReStockKuota.setBackground(new java.awt.Color(0, 0, 0));

        btnRestockKuotaSave.setText("SAVE");
        btnRestockKuotaSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRestockKuotaSaveMouseClicked(evt);
            }
        });

        txtRestockKuotaBalance_current.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("KARTU PROVIDER");

        txtRestockKuotaProviderName.setEditable(false);
        txtRestockKuotaProviderName.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtRestockKuotaProviderName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRestockKuotaProviderNameActionPerformed(evt);
            }
        });

        txtRestockKuotaType.setEditable(false);
        txtRestockKuotaType.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        javax.swing.GroupLayout paneFormlReStockKuotaLayout = new javax.swing.GroupLayout(paneFormlReStockKuota);
        paneFormlReStockKuota.setLayout(paneFormlReStockKuotaLayout);
        paneFormlReStockKuotaLayout.setHorizontalGroup(
            paneFormlReStockKuotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneFormlReStockKuotaLayout.createSequentialGroup()
                .addContainerGap(322, Short.MAX_VALUE)
                .addGroup(paneFormlReStockKuotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtRestockKuotaType)
                    .addGroup(paneFormlReStockKuotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnRestockKuotaSave, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addGroup(paneFormlReStockKuotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtRestockKuotaBalance_current, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                            .addComponent(txtRestockKuotaProviderName, javax.swing.GroupLayout.Alignment.LEADING))))
                .addGap(231, 231, 231))
        );
        paneFormlReStockKuotaLayout.setVerticalGroup(
            paneFormlReStockKuotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneFormlReStockKuotaLayout.createSequentialGroup()
                .addContainerGap(172, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRestockKuotaProviderName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRestockKuotaBalance_current, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtRestockKuotaType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRestockKuotaSave)
                .addGap(150, 150, 150))
        );

        panelView.add(paneFormlReStockKuota, "card11");

        panelStockView.setBackground(new java.awt.Color(0, 0, 0));

        tblStock.setBackground(new java.awt.Color(0, 0, 0));
        tblStock.setForeground(new java.awt.Color(240, 240, 240));
        tblStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "PROVIDER", "JENIS", "NOMOR", "KUOTA", "HARGA", "MASA AKTIF"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblStock);

        jButton9.setText("RE-STOCK");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        cbFilterProviderStock.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cbFilterProviderStock.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--PROVIDER--", "TELKOMSEL", "TRI", "XL", "AXIS", "INDOSAT", "SMARTFREN" }));

        cbFilterJenisStock.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cbFilterJenisStock.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--JENIS--", "PERDANA", "KUOTA" }));

        btnEditStock.setText("EDIT");

        btnDeleteStock.setText("DELETE");

        javax.swing.GroupLayout panelStockViewLayout = new javax.swing.GroupLayout(panelStockView);
        panelStockView.setLayout(panelStockViewLayout);
        panelStockViewLayout.setHorizontalGroup(
            panelStockViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStockViewLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelStockViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelStockViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelStockViewLayout.createSequentialGroup()
                            .addComponent(btnEditStock, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnDeleteStock, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelStockViewLayout.createSequentialGroup()
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelStockViewLayout.createSequentialGroup()
                        .addComponent(cbFilterProviderStock, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbFilterJenisStock, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        panelStockViewLayout.setVerticalGroup(
            panelStockViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelStockViewLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelStockViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbFilterProviderStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFilterJenisStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelStockViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                    .addComponent(jScrollBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(panelStockViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelStockViewLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton9))
                    .addGroup(panelStockViewLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(panelStockViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEditStock)
                            .addComponent(btnDeleteStock))))
                .addGap(15, 15, 15))
        );

        panelView.add(panelStockView, "card10");

        panelTagihanView.setBackground(new java.awt.Color(0, 0, 0));

        jTable4.setBackground(new java.awt.Color(0, 0, 0));
        jTable4.setForeground(new java.awt.Color(240, 240, 240));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        cbJenisTagihan.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cbJenisTagihan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--JENIS--", "PLN", "PDAM" }));

        btnEditTagihan.setText("EDIT");

        btnDeleteTagihan.setText("HAPUS");

        btnCreateTagihan.setText("TAMBAH");

        txtSisaKuota.setBackground(new java.awt.Color(0, 0, 0));
        txtSisaKuota.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtSisaKuota.setForeground(new java.awt.Color(240, 240, 240));

        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(240, 240, 240));
        jLabel51.setText("Sisa Kuota : Rp ");

        btnReStockKuotaTagihan.setText("RE-STOCK KUOTA");
        btnReStockKuotaTagihan.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                btnReStockKuotaTagihanAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        btnReStockKuotaTagihan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReStockKuotaTagihanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTagihanViewLayout = new javax.swing.GroupLayout(panelTagihanView);
        panelTagihanView.setLayout(panelTagihanViewLayout);
        panelTagihanViewLayout.setHorizontalGroup(
            panelTagihanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTagihanViewLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(panelTagihanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTagihanViewLayout.createSequentialGroup()
                        .addComponent(jLabel51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSisaKuota)
                        .addGap(18, 18, 18)
                        .addComponent(btnReStockKuotaTagihan)
                        .addGap(94, 94, 94)
                        .addComponent(btnEditTagihan, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteTagihan, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCreateTagihan)
                        .addGap(42, 42, 42))
                    .addGroup(panelTagihanViewLayout.createSequentialGroup()
                        .addGroup(panelTagihanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTagihanViewLayout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollBar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbJenisTagihan, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(25, Short.MAX_VALUE))))
        );
        panelTagihanViewLayout.setVerticalGroup(
            panelTagihanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTagihanViewLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(cbJenisTagihan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTagihanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollBar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTagihanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTagihanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnReStockKuotaTagihan)
                        .addComponent(jLabel51)
                        .addComponent(txtSisaKuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTagihanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCreateTagihan)
                        .addComponent(btnDeleteTagihan)
                        .addComponent(btnEditTagihan)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        panelView.add(panelTagihanView, "card4");

        panelPendapatanView.setBackground(new java.awt.Color(0, 0, 0));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(240, 240, 240));
        jLabel23.setText("PULSA");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(240, 240, 240));
        jLabel24.setText("KARTU KUOTA");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(240, 240, 240));
        jLabel25.setText("KARTU PERDANA");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(240, 240, 240));
        jLabel26.setText("PLN");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(240, 240, 240));
        jLabel27.setText("PDAM");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(240, 240, 240));
        jLabel37.setText("PENGELUARAN*");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(240, 240, 240));
        jLabel39.setText(":");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(240, 240, 240));
        jLabel29.setText(":");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(240, 240, 240));
        jLabel28.setText(":");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(240, 240, 240));
        jLabel30.setText(":");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(240, 240, 240));
        jLabel31.setText(":");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(240, 240, 240));
        jLabel32.setText(":");

        txtPulsaPendapatan.setBackground(new java.awt.Color(0, 0, 0));
        txtPulsaPendapatan.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtPulsaPendapatan.setForeground(new java.awt.Color(240, 240, 240));
        txtPulsaPendapatan.setText("-----");
        txtPulsaPendapatan.setBorder(null);
        txtPulsaPendapatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPulsaPendapatanActionPerformed(evt);
            }
        });

        txtKartuKuotaPendapatan.setBackground(new java.awt.Color(0, 0, 0));
        txtKartuKuotaPendapatan.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtKartuKuotaPendapatan.setForeground(new java.awt.Color(240, 240, 240));
        txtKartuKuotaPendapatan.setText("-----");
        txtKartuKuotaPendapatan.setBorder(null);

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(240, 240, 240));
        jLabel33.setText("Rp");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(240, 240, 240));
        jLabel34.setText("Rp");

        txtKartuPerdanaPendapatan.setBackground(new java.awt.Color(0, 0, 0));
        txtKartuPerdanaPendapatan.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtKartuPerdanaPendapatan.setForeground(new java.awt.Color(240, 240, 240));
        txtKartuPerdanaPendapatan.setText("-----");
        txtKartuPerdanaPendapatan.setBorder(null);

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(240, 240, 240));
        jLabel35.setText("Rp");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(240, 240, 240));
        jLabel36.setText("Rp");

        txtPLNPendapatan.setBackground(new java.awt.Color(0, 0, 0));
        txtPLNPendapatan.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtPLNPendapatan.setForeground(new java.awt.Color(240, 240, 240));
        txtPLNPendapatan.setText("-----");
        txtPLNPendapatan.setBorder(null);

        txtPDAMPendapatan.setBackground(new java.awt.Color(0, 0, 0));
        txtPDAMPendapatan.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtPDAMPendapatan.setForeground(new java.awt.Color(240, 240, 240));
        txtPDAMPendapatan.setText("-----");
        txtPDAMPendapatan.setBorder(null);

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(240, 240, 240));
        jLabel38.setText("Rp");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(240, 240, 240));
        jLabel40.setText("Rp");

        txtPengeluaranPendapatan.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jTextField9.setBackground(new java.awt.Color(0, 0, 0));
        jTextField9.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(240, 240, 240));
        jTextField9.setBorder(null);

        txtTotalPendapatan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTotalPendapatan.setForeground(new java.awt.Color(240, 240, 240));
        txtTotalPendapatan.setText("Rp");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(240, 240, 240));
        jLabel41.setText("TOTAL");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(240, 240, 240));
        jLabel42.setText(":");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(240, 240, 240));
        jLabel14.setText("*Ketik total pengeluaran");

        javax.swing.GroupLayout panelPendapatanViewLayout = new javax.swing.GroupLayout(panelPendapatanView);
        panelPendapatanView.setLayout(panelPendapatanViewLayout);
        panelPendapatanViewLayout.setHorizontalGroup(
            panelPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPendapatanViewLayout.createSequentialGroup()
                .addGroup(panelPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPendapatanViewLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelPendapatanViewLayout.createSequentialGroup()
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalPendapatan, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelPendapatanViewLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(panelPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPendapatanViewLayout.createSequentialGroup()
                                .addGroup(panelPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(206, 206, 206)
                                .addGroup(panelPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addGroup(panelPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelPendapatanViewLayout.createSequentialGroup()
                                        .addGroup(panelPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtKartuKuotaPendapatan, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPDAMPendapatan)
                                            .addComponent(txtPLNPendapatan, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtKartuPerdanaPendapatan, javax.swing.GroupLayout.Alignment.LEADING)))
                                    .addGroup(panelPendapatanViewLayout.createSequentialGroup()
                                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPulsaPendapatan, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))))
                            .addGroup(panelPendapatanViewLayout.createSequentialGroup()
                                .addGroup(panelPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addGroup(panelPendapatanViewLayout.createSequentialGroup()
                                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(206, 206, 206)
                                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(44, 44, 44)
                                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPengeluaranPendapatan, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 117, Short.MAX_VALUE)))))
                .addGap(24, 24, 24))
        );
        panelPendapatanViewLayout.setVerticalGroup(
            panelPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPendapatanViewLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(panelPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(txtPulsaPendapatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel31)
                        .addComponent(jLabel34)
                        .addComponent(txtKartuKuotaPendapatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel30)
                        .addComponent(jLabel35)
                        .addComponent(txtKartuPerdanaPendapatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(16, 16, 16)
                .addGroup(panelPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel28)
                    .addComponent(jLabel36)
                    .addComponent(txtPLNPendapatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(panelPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel38)
                    .addComponent(jLabel29)
                    .addComponent(txtPDAMPendapatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jLabel40)
                    .addComponent(jLabel39)
                    .addComponent(txtPengeluaranPendapatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(panelPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jLabel42)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalPendapatan))
                .addGap(44, 44, 44)
                .addComponent(jLabel14)
                .addGap(25, 25, 25))
        );

        panelView.add(panelPendapatanView, "card6");

        panelManageView.setBackground(new java.awt.Color(0, 0, 0));

        btnEmployeeView.setBackground(new java.awt.Color(153, 0, 153));
        btnEmployeeView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmployeeView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEmployeeViewMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEmployeeViewMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEmployeeViewMouseExited(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Employee");

        javax.swing.GroupLayout btnEmployeeViewLayout = new javax.swing.GroupLayout(btnEmployeeView);
        btnEmployeeView.setLayout(btnEmployeeViewLayout);
        btnEmployeeViewLayout.setHorizontalGroup(
            btnEmployeeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEmployeeViewLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        btnEmployeeViewLayout.setVerticalGroup(
            btnEmployeeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnEmployeeViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnCustomerView.setBackground(new java.awt.Color(153, 0, 153));
        btnCustomerView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCustomerView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCustomerViewMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCustomerViewMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCustomerViewMouseExited(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Customer");

        javax.swing.GroupLayout btnCustomerViewLayout = new javax.swing.GroupLayout(btnCustomerView);
        btnCustomerView.setLayout(btnCustomerViewLayout);
        btnCustomerViewLayout.setHorizontalGroup(
            btnCustomerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCustomerViewLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel47)
                .addGap(51, 51, 51))
        );
        btnCustomerViewLayout.setVerticalGroup(
            btnCustomerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCustomerViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelManageViewLayout = new javax.swing.GroupLayout(panelManageView);
        panelManageView.setLayout(panelManageViewLayout);
        panelManageViewLayout.setHorizontalGroup(
            panelManageViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelManageViewLayout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(btnEmployeeView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btnCustomerView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(221, 221, 221))
        );
        panelManageViewLayout.setVerticalGroup(
            panelManageViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelManageViewLayout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addGroup(panelManageViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCustomerView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmployeeView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(204, Short.MAX_VALUE))
        );

        panelView.add(panelManageView, "card12");

        panelManageEmployeeView.setBackground(new java.awt.Color(0, 0, 0));

        lblHeaderEmployee.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblHeaderEmployee.setForeground(new java.awt.Color(240, 240, 240));
        lblHeaderEmployee.setText("DATA EMPLOYEE");

        btnFormEmployeeDelete.setText("Delete");
        btnFormEmployeeDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFormEmployeeDeleteMouseClicked(evt);
            }
        });
        btnFormEmployeeDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormEmployeeDeleteActionPerformed(evt);
            }
        });

        tblEmployee.setBackground(new java.awt.Color(0, 0, 0));
        tblEmployee.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tblEmployee.setForeground(new java.awt.Color(240, 240, 240));
        tblEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        spEmployee.setViewportView(tblEmployee);

        btnFormEmployee.setBackground(new java.awt.Color(153, 0, 153));
        btnFormEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFormEmployeeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFormEmployeeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFormEmployeeMouseExited(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Form");

        javax.swing.GroupLayout btnFormEmployeeLayout = new javax.swing.GroupLayout(btnFormEmployee);
        btnFormEmployee.setLayout(btnFormEmployeeLayout);
        btnFormEmployeeLayout.setHorizontalGroup(
            btnFormEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnFormEmployeeLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel21)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        btnFormEmployeeLayout.setVerticalGroup(
            btnFormEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelManageEmployeeViewLayout = new javax.swing.GroupLayout(panelManageEmployeeView);
        panelManageEmployeeView.setLayout(panelManageEmployeeViewLayout);
        panelManageEmployeeViewLayout.setHorizontalGroup(
            panelManageEmployeeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelManageEmployeeViewLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panelManageEmployeeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFormEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHeaderEmployee)
                    .addComponent(btnFormEmployeeDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        panelManageEmployeeViewLayout.setVerticalGroup(
            panelManageEmployeeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelManageEmployeeViewLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(lblHeaderEmployee)
                .addGap(18, 18, 18)
                .addComponent(btnFormEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFormEmployeeDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        panelView.add(panelManageEmployeeView, "card11");

        panelFormEmployeeView.setBackground(new java.awt.Color(0, 0, 0));

        lblHeaderFormEmployee.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblHeaderFormEmployee.setForeground(new java.awt.Color(240, 240, 240));
        lblHeaderFormEmployee.setText("FORM EMPLOYEE");

        lblFormIdEmployee.setForeground(new java.awt.Color(255, 255, 255));
        lblFormIdEmployee.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFormIdEmployee.setText("ID");

        txtId_Employee.setEditable(false);

        lblFormPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblFormPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFormPassword.setText("Password");

        lblEmployee_name.setForeground(new java.awt.Color(255, 255, 255));
        lblEmployee_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmployee_name.setText("Full Name");

        lblRole.setForeground(new java.awt.Color(255, 255, 255));
        lblRole.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRole.setText("Role");

        btnBacktoManageEmployee.setBackground(new java.awt.Color(153, 0, 153));
        btnBacktoManageEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBacktoManageEmployeeMouseClicked(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Back");

        javax.swing.GroupLayout btnBacktoManageEmployeeLayout = new javax.swing.GroupLayout(btnBacktoManageEmployee);
        btnBacktoManageEmployee.setLayout(btnBacktoManageEmployeeLayout);
        btnBacktoManageEmployeeLayout.setHorizontalGroup(
            btnBacktoManageEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBacktoManageEmployeeLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(29, 29, 29))
        );
        btnBacktoManageEmployeeLayout.setVerticalGroup(
            btnBacktoManageEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnBacktoManageEmployeeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblFormUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblFormUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFormUsername.setText("Username");

        btnFormEmployeeCreate.setText("Create");
        btnFormEmployeeCreate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFormEmployeeCreateMouseClicked(evt);
            }
        });
        btnFormEmployeeCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormEmployeeCreateActionPerformed(evt);
            }
        });

        btnFormEmployeeUpdate.setText("Update");
        btnFormEmployeeUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFormEmployeeUpdateMouseClicked(evt);
            }
        });
        btnFormEmployeeUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormEmployeeUpdateActionPerformed(evt);
            }
        });

        btnFormEmployeeReset.setText("Reset");
        btnFormEmployeeReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormEmployeeResetActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout panelFormEmployeeViewLayout = new javax.swing.GroupLayout(panelFormEmployeeView);
        panelFormEmployeeView.setLayout(panelFormEmployeeViewLayout);
        panelFormEmployeeViewLayout.setHorizontalGroup(
            panelFormEmployeeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormEmployeeViewLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(panelFormEmployeeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormEmployeeViewLayout.createSequentialGroup()
                        .addGroup(panelFormEmployeeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBacktoManageEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHeaderFormEmployee))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelFormEmployeeViewLayout.createSequentialGroup()
                        .addGroup(panelFormEmployeeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFormEmployeeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblFormPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblEmployee_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblRole, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblFormUsername))
                            .addComponent(lblFormIdEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelFormEmployeeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId_Employee)
                            .addComponent(txtEmployee_name)
                            .addComponent(txtUsername)
                            .addComponent(txtPassword)
                            .addComponent(txtRole)
                            .addGroup(panelFormEmployeeViewLayout.createSequentialGroup()
                                .addComponent(btnFormEmployeeReset, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(262, 262, 262)
                                .addComponent(btnFormEmployeeCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFormEmployeeUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)))))
                .addGap(59, 59, 59))
        );
        panelFormEmployeeViewLayout.setVerticalGroup(
            panelFormEmployeeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormEmployeeViewLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblHeaderFormEmployee)
                .addGap(26, 26, 26)
                .addComponent(btnBacktoManageEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(panelFormEmployeeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId_Employee, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFormIdEmployee))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormEmployeeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFormUsername))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormEmployeeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFormPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormEmployeeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmployee_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmployee_name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormEmployeeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRole))
                .addGap(27, 27, 27)
                .addGroup(panelFormEmployeeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormEmployeeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnFormEmployeeCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFormEmployeeUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFormEmployeeReset, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        panelView.add(panelFormEmployeeView, "card13");

        panelManageCustomerView.setBackground(new java.awt.Color(0, 0, 0));

        lblHeaderCustomer.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblHeaderCustomer.setForeground(new java.awt.Color(240, 240, 240));
        lblHeaderCustomer.setText("DATA CUSTOMER");

        btnFormCustomerDelete.setText("Delete");
        btnFormCustomerDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFormCustomerDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFormCustomerDeleteMouseClicked(evt);
            }
        });
        btnFormCustomerDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormCustomerDeleteActionPerformed(evt);
            }
        });

        tblCustomer.setBackground(new java.awt.Color(0, 0, 0));
        tblCustomer.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tblCustomer.setForeground(new java.awt.Color(240, 240, 240));
        tblCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        spCustomer.setViewportView(tblCustomer);

        btnFormCustomer.setBackground(new java.awt.Color(153, 0, 153));
        btnFormCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFormCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFormCustomerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFormCustomerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFormCustomerMouseExited(evt);
            }
        });

        jLabel53.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Form");

        javax.swing.GroupLayout btnFormCustomerLayout = new javax.swing.GroupLayout(btnFormCustomer);
        btnFormCustomer.setLayout(btnFormCustomerLayout);
        btnFormCustomerLayout.setHorizontalGroup(
            btnFormCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnFormCustomerLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel53)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        btnFormCustomerLayout.setVerticalGroup(
            btnFormCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel53, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelManageCustomerViewLayout = new javax.swing.GroupLayout(panelManageCustomerView);
        panelManageCustomerView.setLayout(panelManageCustomerViewLayout);
        panelManageCustomerViewLayout.setHorizontalGroup(
            panelManageCustomerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelManageCustomerViewLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panelManageCustomerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFormCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHeaderCustomer)
                    .addComponent(btnFormCustomerDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        panelManageCustomerViewLayout.setVerticalGroup(
            panelManageCustomerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelManageCustomerViewLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(lblHeaderCustomer)
                .addGap(18, 18, 18)
                .addComponent(btnFormCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFormCustomerDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        panelView.add(panelManageCustomerView, "card11");

        panelFormCustomerView.setBackground(new java.awt.Color(0, 0, 0));

        lblHeaderFormEmployee1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblHeaderFormEmployee1.setForeground(new java.awt.Color(240, 240, 240));
        lblHeaderFormEmployee1.setText("FORM CUSTOMER");

        lblFormIdEmployee1.setForeground(new java.awt.Color(255, 255, 255));
        lblFormIdEmployee1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFormIdEmployee1.setText("ID");

        txtId_customer.setEditable(false);

        lblEmployee_name1.setForeground(new java.awt.Color(255, 255, 255));
        lblEmployee_name1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmployee_name1.setText("Full Name");

        lblRole1.setForeground(new java.awt.Color(255, 255, 255));
        lblRole1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRole1.setText("Phone Num.");

        btnBacktoManageCustomer.setBackground(new java.awt.Color(153, 0, 153));
        btnBacktoManageCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBacktoManageCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBacktoManageCustomerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBacktoManageCustomerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBacktoManageCustomerMouseExited(evt);
            }
        });

        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Back");

        javax.swing.GroupLayout btnBacktoManageCustomerLayout = new javax.swing.GroupLayout(btnBacktoManageCustomer);
        btnBacktoManageCustomer.setLayout(btnBacktoManageCustomerLayout);
        btnBacktoManageCustomerLayout.setHorizontalGroup(
            btnBacktoManageCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBacktoManageCustomerLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel54)
                .addGap(29, 29, 29))
        );
        btnBacktoManageCustomerLayout.setVerticalGroup(
            btnBacktoManageCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnBacktoManageCustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel54)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnFormCustomerCreate.setText("Create");
        btnFormCustomerCreate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFormCustomerCreateMouseClicked(evt);
            }
        });
        btnFormCustomerCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormCustomerCreateActionPerformed(evt);
            }
        });

        btnFormCustomerUpdate.setText("Update");
        btnFormCustomerUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFormCustomerUpdateMouseClicked(evt);
            }
        });
        btnFormCustomerUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormCustomerUpdateActionPerformed(evt);
            }
        });

        btnFormCustomerReset.setText("Reset");
        btnFormCustomerReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormCustomerResetActionPerformed(evt);
            }
        });

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lblRole2.setForeground(new java.awt.Color(255, 255, 255));
        lblRole2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRole2.setText("Status");

        javax.swing.GroupLayout panelFormCustomerViewLayout = new javax.swing.GroupLayout(panelFormCustomerView);
        panelFormCustomerView.setLayout(panelFormCustomerViewLayout);
        panelFormCustomerViewLayout.setHorizontalGroup(
            panelFormCustomerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormCustomerViewLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(panelFormCustomerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormCustomerViewLayout.createSequentialGroup()
                        .addGroup(panelFormCustomerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBacktoManageCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHeaderFormEmployee1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelFormCustomerViewLayout.createSequentialGroup()
                        .addGroup(panelFormCustomerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFormCustomerViewLayout.createSequentialGroup()
                                .addComponent(lblFormIdEmployee1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormCustomerViewLayout.createSequentialGroup()
                                .addGroup(panelFormCustomerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(panelFormCustomerViewLayout.createSequentialGroup()
                                        .addComponent(lblEmployee_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10))
                                    .addComponent(lblRole1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblRole2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)))
                        .addGroup(panelFormCustomerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId_customer)
                            .addGroup(panelFormCustomerViewLayout.createSequentialGroup()
                                .addComponent(btnFormCustomerReset, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(262, 262, 262)
                                .addComponent(btnFormCustomerCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFormCustomerUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                            .addComponent(txtCustomerPhoneNumber)
                            .addComponent(txtCustomer_name, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCustomerStatus, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(32, 32, 32))
        );
        panelFormCustomerViewLayout.setVerticalGroup(
            panelFormCustomerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormCustomerViewLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblHeaderFormEmployee1)
                .addGap(26, 26, 26)
                .addComponent(btnBacktoManageCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(panelFormCustomerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId_customer, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFormIdEmployee1))
                .addGap(18, 18, 18)
                .addGroup(panelFormCustomerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCustomer_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmployee_name1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormCustomerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCustomerPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRole1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormCustomerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCustomerStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRole2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(panelFormCustomerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormCustomerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnFormCustomerCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFormCustomerUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFormCustomerReset, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        panelView.add(panelFormCustomerView, "card13");

        backGround.add(panelView, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 770, 450));

        sidePane.setBackground(new java.awt.Color(92, 0, 122));
        sidePane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAppName.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        lblAppName.setForeground(new java.awt.Color(255, 255, 255));
        lblAppName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/id/uniondev/creams/asset/creams_logo.png"))); // NOI18N
        sidePane.add(lblAppName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 120));

        btnHomeMenu.setBackground(new java.awt.Color(92, 0, 122));
        btnHomeMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHomeMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomeMenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHomeMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHomeMenuMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnHomeMenuMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnHomeMenuMouseReleased(evt);
            }
        });

        icoHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/id/uniondev/creams/asset/icons8_Home_15px.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("HOME");

        javax.swing.GroupLayout btnHomeMenuLayout = new javax.swing.GroupLayout(btnHomeMenu);
        btnHomeMenu.setLayout(btnHomeMenuLayout);
        btnHomeMenuLayout.setHorizontalGroup(
            btnHomeMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnHomeMenuLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(icoHome)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(110, Short.MAX_VALUE))
        );
        btnHomeMenuLayout.setVerticalGroup(
            btnHomeMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnHomeMenuLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(btnHomeMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icoHome)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        sidePane.add(btnHomeMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 200, -1));

        btnKartuMenu.setBackground(new java.awt.Color(92, 0, 122));
        btnKartuMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKartuMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKartuMenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnKartuMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnKartuMenuMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnKartuMenuMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnKartuMenuMouseReleased(evt);
            }
        });

        icoKartu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/id/uniondev/creams/asset/icons8_Discover_15px.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("KARTU");

        javax.swing.GroupLayout btnKartuMenuLayout = new javax.swing.GroupLayout(btnKartuMenu);
        btnKartuMenu.setLayout(btnKartuMenuLayout);
        btnKartuMenuLayout.setHorizontalGroup(
            btnKartuMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnKartuMenuLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(icoKartu)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(104, Short.MAX_VALUE))
        );
        btnKartuMenuLayout.setVerticalGroup(
            btnKartuMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnKartuMenuLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(btnKartuMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icoKartu)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        sidePane.add(btnKartuMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 200, -1));

        btnPlnPdamMenu.setBackground(new java.awt.Color(92, 0, 122));
        btnPlnPdamMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPlnPdamMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPlnPdamMenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPlnPdamMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPlnPdamMenuMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPlnPdamMenuMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnPlnPdamMenuMouseReleased(evt);
            }
        });

        icoPLNPDAM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/id/uniondev/creams/asset/icons8_Discover_15px.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("PLN / PDAM");

        javax.swing.GroupLayout btnPlnPdamMenuLayout = new javax.swing.GroupLayout(btnPlnPdamMenu);
        btnPlnPdamMenu.setLayout(btnPlnPdamMenuLayout);
        btnPlnPdamMenuLayout.setHorizontalGroup(
            btnPlnPdamMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPlnPdamMenuLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(icoPLNPDAM)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        btnPlnPdamMenuLayout.setVerticalGroup(
            btnPlnPdamMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPlnPdamMenuLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(btnPlnPdamMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(icoPLNPDAM))
                .addGap(12, 12, 12))
        );

        sidePane.add(btnPlnPdamMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 200, -1));

        btnPulsaMenu.setBackground(new java.awt.Color(92, 0, 122));
        btnPulsaMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPulsaMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPulsaMenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPulsaMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPulsaMenuMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPulsaMenuMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnPulsaMenuMouseReleased(evt);
            }
        });

        icoKuota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/id/uniondev/creams/asset/icons8_Discover_15px.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("PULSA");

        javax.swing.GroupLayout btnPulsaMenuLayout = new javax.swing.GroupLayout(btnPulsaMenu);
        btnPulsaMenu.setLayout(btnPulsaMenuLayout);
        btnPulsaMenuLayout.setHorizontalGroup(
            btnPulsaMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPulsaMenuLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(icoKuota)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(106, Short.MAX_VALUE))
        );
        btnPulsaMenuLayout.setVerticalGroup(
            btnPulsaMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPulsaMenuLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(btnPulsaMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(icoKuota)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        sidePane.add(btnPulsaMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 200, -1));

        btnPendapatanMenu.setBackground(new java.awt.Color(92, 0, 122));
        btnPendapatanMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPendapatanMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPendapatanMenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPendapatanMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPendapatanMenuMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPendapatanMenuMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnPendapatanMenuMouseReleased(evt);
            }
        });

        icoPendapatan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/id/uniondev/creams/asset/icons8_Discover_15px.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("PENDAPATAN");

        javax.swing.GroupLayout btnPendapatanMenuLayout = new javax.swing.GroupLayout(btnPendapatanMenu);
        btnPendapatanMenu.setLayout(btnPendapatanMenuLayout);
        btnPendapatanMenuLayout.setHorizontalGroup(
            btnPendapatanMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPendapatanMenuLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(icoPendapatan)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        btnPendapatanMenuLayout.setVerticalGroup(
            btnPendapatanMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPendapatanMenuLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(btnPendapatanMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(icoPendapatan)
                    .addComponent(jLabel5))
                .addContainerGap())
        );

        sidePane.add(btnPendapatanMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 200, -1));

        btnAboutMenu.setBackground(new java.awt.Color(92, 0, 122));
        btnAboutMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAboutMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAboutMenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAboutMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAboutMenuMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAboutMenuMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnAboutMenuMouseReleased(evt);
            }
        });

        icoAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/id/uniondev/creams/asset/icons8_Desktop_15px.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(240, 240, 240));
        jLabel10.setText("ABOUT");

        javax.swing.GroupLayout btnAboutMenuLayout = new javax.swing.GroupLayout(btnAboutMenu);
        btnAboutMenu.setLayout(btnAboutMenuLayout);
        btnAboutMenuLayout.setHorizontalGroup(
            btnAboutMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAboutMenuLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(icoAbout)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addContainerGap(101, Short.MAX_VALUE))
        );
        btnAboutMenuLayout.setVerticalGroup(
            btnAboutMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAboutMenuLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(btnAboutMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icoAbout)
                    .addComponent(jLabel10))
                .addContainerGap())
        );

        sidePane.add(btnAboutMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 200, -1));

        btnManageMenu.setBackground(new java.awt.Color(92, 0, 122));
        btnManageMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnManageMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnManageMenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnManageMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnManageMenuMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnManageMenuMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnManageMenuMouseReleased(evt);
            }
        });

        icoManage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/id/uniondev/creams/asset/icons8_Discover_15px.png"))); // NOI18N

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(240, 240, 240));
        jLabel19.setText("MANAGE");

        javax.swing.GroupLayout btnManageMenuLayout = new javax.swing.GroupLayout(btnManageMenu);
        btnManageMenu.setLayout(btnManageMenuLayout);
        btnManageMenuLayout.setHorizontalGroup(
            btnManageMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnManageMenuLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(icoManage)
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addContainerGap(89, Short.MAX_VALUE))
        );
        btnManageMenuLayout.setVerticalGroup(
            btnManageMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnManageMenuLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(btnManageMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icoManage)
                    .addComponent(jLabel19))
                .addContainerGap())
        );

        sidePane.add(btnManageMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, -1, -1));

        btnLogoutMenu.setBackground(new java.awt.Color(92, 0, 122));
        btnLogoutMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogoutMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogoutMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogoutMenuMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnLogoutMenuMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnLogoutMenuMouseReleased(evt);
            }
        });

        icoLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/id/uniondev/creams/asset/icons8_Import_15px.png"))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(240, 240, 240));
        jLabel15.setText("SIGN OUT");

        javax.swing.GroupLayout btnLogoutMenuLayout = new javax.swing.GroupLayout(btnLogoutMenu);
        btnLogoutMenu.setLayout(btnLogoutMenuLayout);
        btnLogoutMenuLayout.setHorizontalGroup(
            btnLogoutMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnLogoutMenuLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(icoLogout)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addContainerGap(89, Short.MAX_VALUE))
        );
        btnLogoutMenuLayout.setVerticalGroup(
            btnLogoutMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnLogoutMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnLogoutMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icoLogout)
                    .addComponent(jLabel15))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        sidePane.add(btnLogoutMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, -1, -1));
        sidePane.add(seperatorMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 180, 10));

        backGround.add(sidePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public JLabel getLblHeaderName() {
        return lblHeaderName;
    }

    public void setLblHeaderName(JLabel lblHeaderName) {
        this.lblHeaderName = lblHeaderName;
    }
    
    private void btnHomeMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMenuMouseClicked
        panelView.removeAll();
        panelView.repaint();
        panelView.revalidate();
        btnHomeMenu.setBackground(sidemenu_active_color);
        sidemenu_active = 1;
        panelView.add(panelHomeView);
        panelView.repaint();
        panelView.revalidate();
    }//GEN-LAST:event_btnHomeMenuMouseClicked

    private void btnHomeMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMenuMouseEntered
        if (sidemenu_active != 1) {
            btnHomeMenu.setBackground(sidemenu_entered);
        }
    }//GEN-LAST:event_btnHomeMenuMouseEntered

    private void btnHomeMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMenuMouseExited
        if (sidemenu_active != 1) {
            btnHomeMenu.setBackground(sidemenu_exited);
        }
    }//GEN-LAST:event_btnHomeMenuMouseExited

    private void btnHomeMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMenuMousePressed
       if (sidemenu_active != 1) {
            btnHomeMenu.setBackground(sidemenu_pressed);
        }
    }//GEN-LAST:event_btnHomeMenuMousePressed

    private void btnHomeMenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMenuMouseReleased
        if (sidemenu_active != 1) {
            btnHomeMenu.setBackground(sidemenu_entered);
        }
    }//GEN-LAST:event_btnHomeMenuMouseReleased

    private void btnKartuMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKartuMenuMouseClicked
        panelView.removeAll();
        panelView.repaint();
        panelView.revalidate();
        btnKartuMenu.setBackground(sidemenu_pressed);
        sidemenu_active = 2;
        panelView.add(panelKartuView);
        panelView.repaint();
        panelView.revalidate();
        
    }//GEN-LAST:event_btnKartuMenuMouseClicked

    private void btnKartuMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKartuMenuMouseEntered
        if (sidemenu_active != 2) {
            btnKartuMenu.setBackground(sidemenu_entered);
        }
    }//GEN-LAST:event_btnKartuMenuMouseEntered

    private void btnKartuMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKartuMenuMouseExited
        if (sidemenu_active != 2) {
            btnKartuMenu.setBackground(sidemenu_exited);
        }
    }//GEN-LAST:event_btnKartuMenuMouseExited

    private void btnKartuMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKartuMenuMousePressed
        if (sidemenu_active != 2) {
            btnKartuMenu.setBackground(sidemenu_pressed);
        }
    }//GEN-LAST:event_btnKartuMenuMousePressed

    private void btnKartuMenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKartuMenuMouseReleased
        if (sidemenu_active != 2) {
            btnKartuMenu.setBackground(sidemenu_entered);
        }
    }//GEN-LAST:event_btnKartuMenuMouseReleased

    private void btnPlnPdamMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlnPdamMenuMouseClicked
        panelView.removeAll();
        panelView.repaint();
        panelView.revalidate();
        btnPlnPdamMenu.setBackground(sidemenu_pressed);
        sidemenu_active = 3;
        panelView.add(panelTagihanView);
        panelView.repaint();
        panelView.revalidate();
    }//GEN-LAST:event_btnPlnPdamMenuMouseClicked

    private void btnPlnPdamMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlnPdamMenuMouseEntered
        if (sidemenu_active != 3) {
            btnPlnPdamMenu.setBackground(sidemenu_entered);
        } 
    }//GEN-LAST:event_btnPlnPdamMenuMouseEntered

    private void btnPlnPdamMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlnPdamMenuMouseExited
        if (sidemenu_active != 3) {
            btnPlnPdamMenu.setBackground(sidemenu_exited);
        }
    }//GEN-LAST:event_btnPlnPdamMenuMouseExited

    private void btnPlnPdamMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlnPdamMenuMousePressed
        if (sidemenu_active != 3) {
            btnPlnPdamMenu.setBackground(sidemenu_pressed);
        }
    }//GEN-LAST:event_btnPlnPdamMenuMousePressed

    private void btnPlnPdamMenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlnPdamMenuMouseReleased
        if (sidemenu_active != 3) {
            btnPlnPdamMenu.setBackground(sidemenu_entered);
        }
    }//GEN-LAST:event_btnPlnPdamMenuMouseReleased

    private void btnPulsaMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPulsaMenuMouseClicked
        panelView.removeAll();
        panelView.repaint();
        panelView.revalidate();
        btnPulsaMenu.setBackground(sidemenu_pressed);
        sidemenu_active = 4;
        panelView.add(panelPulsaView);
        panelView.repaint();
        panelView.revalidate();
    }//GEN-LAST:event_btnPulsaMenuMouseClicked

    private void btnPulsaMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPulsaMenuMouseEntered
        if (sidemenu_active != 4) {
            btnPulsaMenu.setBackground(sidemenu_entered);
        }
    }//GEN-LAST:event_btnPulsaMenuMouseEntered

    private void btnPulsaMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPulsaMenuMouseExited
        if (sidemenu_active != 4) {
            btnPulsaMenu.setBackground(sidemenu_exited);
        }
    }//GEN-LAST:event_btnPulsaMenuMouseExited

    private void btnPulsaMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPulsaMenuMousePressed
        if (sidemenu_active != 4) {
            btnPulsaMenu.setBackground(sidemenu_pressed);
        }
    }//GEN-LAST:event_btnPulsaMenuMousePressed

    private void btnPulsaMenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPulsaMenuMouseReleased
        if (sidemenu_active != 4) {
            btnPulsaMenu.setBackground(sidemenu_entered);
        }
    }//GEN-LAST:event_btnPulsaMenuMouseReleased

    private void btnPendapatanMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPendapatanMenuMouseClicked
        panelView.removeAll();
        panelView.repaint();
        panelView.revalidate();
        btnPendapatanMenu.setBackground(sidemenu_pressed);
        sidemenu_active = 5;
        panelView.add(panelPendapatanView);
        panelView.repaint();
        panelView.revalidate();
    }//GEN-LAST:event_btnPendapatanMenuMouseClicked

    private void btnPendapatanMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPendapatanMenuMouseEntered
        if (sidemenu_active != 4) {
            btnPendapatanMenu.setBackground(sidemenu_entered);
        }
    }//GEN-LAST:event_btnPendapatanMenuMouseEntered

    private void btnPendapatanMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPendapatanMenuMouseExited
        if (sidemenu_active != 4) {
            btnPendapatanMenu.setBackground(sidemenu_exited);
        }
    }//GEN-LAST:event_btnPendapatanMenuMouseExited

    private void btnPendapatanMenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPendapatanMenuMouseReleased
        if (sidemenu_active != 4) {
            btnPendapatanMenu.setBackground(sidemenu_entered);
        }
    }//GEN-LAST:event_btnPendapatanMenuMouseReleased

    private void btnPendapatanMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPendapatanMenuMousePressed
        if (sidemenu_active != 4) {
            btnPendapatanMenu.setBackground(sidemenu_pressed);
        }
    }//GEN-LAST:event_btnPendapatanMenuMousePressed

    private void btnAboutMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAboutMenuMouseClicked
        AboutFrame about = new AboutFrame();
        about.setVisible(true);
        
    }//GEN-LAST:event_btnAboutMenuMouseClicked

    private void btnAboutMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAboutMenuMouseEntered
        btnAboutMenu.setBackground(sidemenu_entered);
    }//GEN-LAST:event_btnAboutMenuMouseEntered

    private void btnAboutMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAboutMenuMouseExited
        btnAboutMenu.setBackground(sidemenu_exited);
    }//GEN-LAST:event_btnAboutMenuMouseExited

    private void btnAboutMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAboutMenuMousePressed
        btnAboutMenu.setBackground(sidemenu_entered);
    }//GEN-LAST:event_btnAboutMenuMousePressed

    private void btnAboutMenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAboutMenuMouseReleased
        btnAboutMenu.setBackground(sidemenu_pressed);
    }//GEN-LAST:event_btnAboutMenuMouseReleased

    private void btnLogoutMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMenuMouseClicked
        SigninFrame about = new SigninFrame();
        about.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnLogoutMenuMouseClicked

    private void btnLogoutMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMenuMouseEntered
        btnLogoutMenu.setBackground(sidemenu_entered);
    }//GEN-LAST:event_btnLogoutMenuMouseEntered

    private void btnLogoutMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMenuMouseExited
        btnLogoutMenu.setBackground(sidemenu_exited);
    }//GEN-LAST:event_btnLogoutMenuMouseExited

    private void btnLogoutMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMenuMousePressed
        btnLogoutMenu.setBackground(sidemenu_entered);
    }//GEN-LAST:event_btnLogoutMenuMousePressed

    private void btnLogoutMenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMenuMouseReleased
        btnLogoutMenu.setBackground(sidemenu_pressed);
    }//GEN-LAST:event_btnLogoutMenuMouseReleased

    private void btnReStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReStockActionPerformed

    private void txtJumlahNomorReStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJumlahNomorReStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJumlahNomorReStockActionPerformed

    private void btnSaveReStockPerdanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveReStockPerdanaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveReStockPerdanaActionPerformed

    private void btnBackReStockPerdanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackReStockPerdanaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackReStockPerdanaActionPerformed

    private void btnSubmitReStockPerdanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitReStockPerdanaActionPerformed
        panelView.removeAll();
        panelView.repaint();
        panelView.revalidate();
        
        //add panel
        panelView.add(panelReStockView);
        panelView.repaint();
        panelView.revalidate();
    }//GEN-LAST:event_btnSubmitReStockPerdanaActionPerformed

    private void btnReStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReStockMouseClicked
        panelView.removeAll();
        panelView.repaint();
        panelView.revalidate();
        
        //add panel
        panelView.add(panelReStockView);
        panelView.repaint();
        panelView.revalidate();
    }//GEN-LAST:event_btnReStockMouseClicked

    private void btnStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStockMouseClicked
        panelView.removeAll();
        panelView.repaint();
        panelView.revalidate();
        
        //add panel
        panelView.add(panelStockView);
        panelView.repaint();
        panelView.revalidate();
    }//GEN-LAST:event_btnStockMouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        panelView.removeAll();
        panelView.repaint();
        panelView.revalidate();
        
        //add panel
        panelView.add(panelReStockView);
        panelView.repaint();
        panelView.revalidate();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void btnSubmitReStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitReStockActionPerformed
        panelView.removeAll();
        panelView.repaint();
        panelView.revalidate();
        
        //add panel
        panelView.add(panelStockView);
        panelView.repaint();
        panelView.revalidate();
    }//GEN-LAST:event_btnSubmitReStockActionPerformed

    private void btnSubmitReStockKuotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitReStockKuotaActionPerformed
        panelView.removeAll();
        panelView.repaint();
        panelView.revalidate();
        
        //add panel
        panelView.add(panelStockView);
        panelView.repaint();
        panelView.revalidate();
    }//GEN-LAST:event_btnSubmitReStockKuotaActionPerformed

    private void txtFormNomorPulsaHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFormNomorPulsaHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFormNomorPulsaHomeActionPerformed

    private void btnManageMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageMenuMouseClicked
        panelView.removeAll();
        panelView.repaint();
        panelView.revalidate();
        
        //add panel
        panelView.add(panelManageView);
        panelView.repaint();
        panelView.revalidate();
    }//GEN-LAST:event_btnManageMenuMouseClicked

    private void btnManageMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageMenuMouseEntered
        // TODO add your handling code here:
        btnManageMenu.setBackground(sidemenu_entered);
    }//GEN-LAST:event_btnManageMenuMouseEntered

    private void btnManageMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageMenuMouseExited
        // TODO add your handling code here:
        btnManageMenu.setBackground(sidemenu_exited);
    }//GEN-LAST:event_btnManageMenuMouseExited

    private void btnManageMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageMenuMousePressed
        // TODO add your handling code here:
        btnManageMenu.setBackground(sidemenu_pressed);
    }//GEN-LAST:event_btnManageMenuMousePressed

    private void btnManageMenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageMenuMouseReleased
        // TODO add your handling code here:
        btnManageMenu.setBackground(sidemenu_entered);
    }//GEN-LAST:event_btnManageMenuMouseReleased

    private void btnEmployeeViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmployeeViewMouseClicked
        panelView.removeAll();
        panelView.repaint();
        panelView.revalidate();
        
        //add panel
        panelView.add(panelManageEmployeeView);
        panelView.repaint();
        panelView.revalidate();
    }//GEN-LAST:event_btnEmployeeViewMouseClicked

    public JTable getTblEmployee() {
        return tblEmployee;
    }

    public JTextField getTxtId_Employee() {
        return txtId_Employee;
    }
    
    public JTextField getTxtEmployee_name() {
        return txtEmployee_name;
    }
    
    public JTextField getTxtPassword() {
        return txtPassword;
    }

    public JTextField getTxtRole() {
        return txtRole;
    }

    public JTextField getTxtUsername() {
        return txtUsername;
    }
    
    private void btnFormEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormEmployeeMouseClicked
        // TODO add your handling code here:
        panelView.removeAll();
        panelView.repaint();
        panelView.revalidate();
        
        //add panel
        panelView.add(panelFormEmployeeView);
        panelView.repaint();
        panelView.revalidate();
    }//GEN-LAST:event_btnFormEmployeeMouseClicked

    private void btnFormEmployeeCreateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormEmployeeCreateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFormEmployeeCreateMouseClicked

    private void btnBacktoManageEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBacktoManageEmployeeMouseClicked
        // TODO add your handling code here:
        panelView.removeAll();
        panelView.repaint();
        panelView.revalidate();
        
        //add panel
        panelView.add(panelManageEmployeeView);
        panelView.repaint();
        panelView.revalidate();
    }//GEN-LAST:event_btnBacktoManageEmployeeMouseClicked

    private void btnFormEmployeeCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormEmployeeCreateActionPerformed
        // TODO add your handling code here:
        employeeController.insertEmployee(this);
    }//GEN-LAST:event_btnFormEmployeeCreateActionPerformed

    private void btnFormEmployeeUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormEmployeeUpdateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFormEmployeeUpdateMouseClicked

    private void btnFormEmployeeUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormEmployeeUpdateActionPerformed
        // TODO add your handling code here:
        employeeController.updateEmployee(this);
    }//GEN-LAST:event_btnFormEmployeeUpdateActionPerformed

    private void btnFormEmployeeDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormEmployeeDeleteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFormEmployeeDeleteMouseClicked

    private void btnFormEmployeeDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormEmployeeDeleteActionPerformed
        // TODO add your handling code here:
        employeeController.deleteEmployee(this);
    }//GEN-LAST:event_btnFormEmployeeDeleteActionPerformed

    private void btnFormEmployeeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormEmployeeMouseEntered
        // TODO add your handling code here:
        btnFormEmployee.setBackground(sidemenu_entered);
    }//GEN-LAST:event_btnFormEmployeeMouseEntered

    private void btnFormEmployeeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormEmployeeMouseExited
        // TODO add your handling code here:
        btnFormEmployee.setBackground(sidemenu_exited);
    }//GEN-LAST:event_btnFormEmployeeMouseExited

    private void btnEmployeeViewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmployeeViewMouseEntered
        // TODO add your handling code here:
        btnEmployeeView.setBackground(sidemenu_entered);
    }//GEN-LAST:event_btnEmployeeViewMouseEntered

    private void btnEmployeeViewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmployeeViewMouseExited
        // TODO add your handling code here:
        btnEmployeeView.setBackground(sidemenu_exited);
    }//GEN-LAST:event_btnEmployeeViewMouseExited

    private void btnFormEmployeeResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormEmployeeResetActionPerformed
        // TODO add your handling code here:
        employeeController.resetEmployee(this);
    }//GEN-LAST:event_btnFormEmployeeResetActionPerformed

    private void btnReStockKuotaTagihanAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_btnReStockKuotaTagihanAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReStockKuotaTagihanAncestorAdded

    private void btnReStockKuotaTagihanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReStockKuotaTagihanActionPerformed
        // TODO add your handling code here:
        panelView.removeAll();
        panelView.repaint();
        panelView.revalidate();
        
        //add panel
        panelView.add(paneFormlReStockKuota);
        panelView.repaint();
        panelView.revalidate();       
    }//GEN-LAST:event_btnReStockKuotaTagihanActionPerformed

    private void btnReStockKuotaPulsaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReStockKuotaPulsaActionPerformed
        // TODO add your handling code here:
        panelView.removeAll();
        panelView.repaint();
        panelView.revalidate();
        
        //add panel
        panelView.add(paneFormlReStockKuota);
        panelView.repaint();
        panelView.revalidate();
    }//GEN-LAST:event_btnReStockKuotaPulsaActionPerformed

    private void txtPulsaPendapatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPulsaPendapatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPulsaPendapatanActionPerformed

    public JTable getTblCustomer() {
        return tblCustomer;
    }

    public JTextField getTxtCustomerPhoneNumber() {
        return txtCustomerPhoneNumber;
    }

    public JTextField getTxtCustomerStatus() {
        return txtCustomerStatus;
    }

    public JTextField getTxtCustomer_name() {
        return txtCustomer_name;
    }

    public JTextField getTxtId_customer() {
        return txtId_customer;
    }
    
    private void btnCustomerViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCustomerViewMouseClicked
        // TODO add your handling code here:
        panelView.removeAll();
        panelView.repaint();
        panelView.revalidate();
        
        //add panel
        panelView.add(panelManageCustomerView);
        panelView.repaint();
        panelView.revalidate();
    }//GEN-LAST:event_btnCustomerViewMouseClicked

    private void btnCustomerViewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCustomerViewMouseEntered
        // TODO add your handling code here:
        btnCustomerView.setBackground(sidemenu_entered);
    }//GEN-LAST:event_btnCustomerViewMouseEntered

    private void btnCustomerViewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCustomerViewMouseExited
        // TODO add your handling code here:
        btnCustomerView.setBackground(sidemenu_exited);
    }//GEN-LAST:event_btnCustomerViewMouseExited

    private void btnFormCustomerDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormCustomerDeleteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFormCustomerDeleteMouseClicked

    private void btnFormCustomerDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormCustomerDeleteActionPerformed
        // TODO add your handling code here:
        customerController.deleteCustomer(this);
    }//GEN-LAST:event_btnFormCustomerDeleteActionPerformed

    private void btnFormCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormCustomerMouseClicked
        // TODO add your handling code here:
        panelView.removeAll();
        panelView.repaint();
        panelView.revalidate();
        
        //add panel
        panelView.add(panelFormCustomerView);
        panelView.repaint();
        panelView.revalidate();
    }//GEN-LAST:event_btnFormCustomerMouseClicked

    private void btnFormCustomerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormCustomerMouseEntered
        // TODO add your handling code here:
        btnFormCustomer.setBackground(sidemenu_entered);
    }//GEN-LAST:event_btnFormCustomerMouseEntered

    private void btnFormCustomerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormCustomerMouseExited
        // TODO add your handling code here:
        btnFormCustomer.setBackground(sidemenu_exited);
    }//GEN-LAST:event_btnFormCustomerMouseExited

    private void btnBacktoManageCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBacktoManageCustomerMouseClicked
        // TODO add your handling code here:
        panelView.removeAll();
        panelView.repaint();
        panelView.revalidate();
        
        //add panel
        panelView.add(panelManageCustomerView);
        panelView.repaint();
        panelView.revalidate();
    }//GEN-LAST:event_btnBacktoManageCustomerMouseClicked

    private void btnFormCustomerCreateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormCustomerCreateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFormCustomerCreateMouseClicked

    private void btnFormCustomerCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormCustomerCreateActionPerformed
        // TODO add your handling code here:
        customerController.insertCustomer(this);
    }//GEN-LAST:event_btnFormCustomerCreateActionPerformed

    private void btnFormCustomerUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormCustomerUpdateMouseClicked
        // TODO add your handling code here:
        customerController.updateCustomer(this);
    }//GEN-LAST:event_btnFormCustomerUpdateMouseClicked

    private void btnFormCustomerUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormCustomerUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFormCustomerUpdateActionPerformed

    private void btnFormCustomerResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormCustomerResetActionPerformed
        // TODO add your handling code here:
        customerController.resetCustomer(this);
    }//GEN-LAST:event_btnFormCustomerResetActionPerformed

    private void btnBacktoManageCustomerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBacktoManageCustomerMouseEntered
        // TODO add your handling code here:
        btnBacktoManageCustomer.setBackground(sidemenu_entered);
    }//GEN-LAST:event_btnBacktoManageCustomerMouseEntered

    private void btnBacktoManageCustomerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBacktoManageCustomerMouseExited
        // TODO add your handling code here:
        btnBacktoManageCustomer.setBackground(sidemenu_exited);
    }//GEN-LAST:event_btnBacktoManageCustomerMouseExited

    private void cbBesarPulsaHomePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbBesarPulsaHomePopupMenuWillBecomeInvisible
        String cboxBesarHome = (String)cbBesarPulsaHome.getSelectedItem();
        String cboxBesarHomeValue = cbBesarPulsaHome.getSelectedItem().toString();
        if (cboxBesarHomeValue.equals("5")) {
            txtIsiPulsaHome.setText("7000");
            
        } else if (cboxBesarHomeValue.equals("10")){
            txtIsiPulsaHome.setText("12000");
            
        } else if (cboxBesarHomeValue.equals("20")){
            txtIsiPulsaHome.setText("22000");
            
        } else if (cboxBesarHomeValue.equals("25")){
            txtIsiPulsaHome.setText("25000");
            
        } else if (cboxBesarHomeValue.equals("50")){
            txtIsiPulsaHome.setText("50000");
            
        } else if (cboxBesarHomeValue.equals("100")){
            txtIsiPulsaHome.setText("100000");
        } else {
            txtIsiPulsaHome.setText("100000");
        }
    }//GEN-LAST:event_cbBesarPulsaHomePopupMenuWillBecomeInvisible

    private void cbBesarPulsaHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbBesarPulsaHomeMouseClicked
        
    }//GEN-LAST:event_cbBesarPulsaHomeMouseClicked

    private void btnFormSubmitPulsaHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormSubmitPulsaHomeActionPerformed
        // TODO add your handling code here:
        customerCreditController.insertCustomerCredit(this);
    }//GEN-LAST:event_btnFormSubmitPulsaHomeActionPerformed

    private void txtRestockKuotaProviderNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRestockKuotaProviderNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRestockKuotaProviderNameActionPerformed

    public JTable getTblRestockKuotaPulsa() {
        return tblRestockKuotaPulsa;
    }

    public JTextField getTxtRestockKuotaType() {
        return txtRestockKuotaType;
    }
    
    public JTextField getTxtRestockKuotaBalance_current() {
        return txtRestockKuotaBalance_current;
    }

    public JTextField getTxtRestockKuotaProviderName() {
        return txtRestockKuotaProviderName;
    }
    
    private void btnRestockKuotaSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRestockKuotaSaveMouseClicked
        // TODO add your handling code here:
        creditRestockKuotaController.updateCreditRestockKuota(this);
    }//GEN-LAST:event_btnRestockKuotaSaveMouseClicked

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backGround;
    private javax.swing.JPanel btnAboutMenu;
    private javax.swing.JButton btnBackReStockKuota;
    private javax.swing.JButton btnBackReStockPerdana;
    private javax.swing.JPanel btnBacktoManageCustomer;
    private javax.swing.JPanel btnBacktoManageEmployee;
    private javax.swing.JButton btnCreateTagihan;
    private javax.swing.JPanel btnCustomerView;
    private javax.swing.JButton btnDeleteStock;
    private javax.swing.JButton btnDeleteTagihan;
    private javax.swing.JButton btnEditStock;
    private javax.swing.JButton btnEditTagihan;
    private javax.swing.JPanel btnEmployeeView;
    private javax.swing.JPanel btnFormCustomer;
    private javax.swing.JButton btnFormCustomerCreate;
    private javax.swing.JButton btnFormCustomerDelete;
    private javax.swing.JButton btnFormCustomerReset;
    private javax.swing.JButton btnFormCustomerUpdate;
    private javax.swing.JPanel btnFormEmployee;
    private javax.swing.JButton btnFormEmployeeCreate;
    private javax.swing.JButton btnFormEmployeeDelete;
    private javax.swing.JButton btnFormEmployeeReset;
    private javax.swing.JButton btnFormEmployeeUpdate;
    private javax.swing.JButton btnFormSubmitPulsaHome;
    private javax.swing.JPanel btnHomeMenu;
    private javax.swing.JPanel btnKartuMenu;
    private javax.swing.JPanel btnLogoutMenu;
    private javax.swing.JPanel btnManageMenu;
    private javax.swing.JButton btnNextReStock;
    private javax.swing.JPanel btnPendapatanMenu;
    private javax.swing.JPanel btnPlnPdamMenu;
    private javax.swing.JPanel btnPulsaMenu;
    private javax.swing.JButton btnReStock;
    private javax.swing.JButton btnReStockKuotaPulsa;
    private javax.swing.JButton btnReStockKuotaTagihan;
    private javax.swing.JButton btnRestockKuotaSave;
    private javax.swing.JButton btnSaveReStockKuota;
    private javax.swing.JButton btnSaveReStockPerdana;
    private javax.swing.JButton btnStock;
    private javax.swing.JButton btnSubmitReStock;
    private javax.swing.JButton btnSubmitReStockKuota;
    private javax.swing.JButton btnSubmitReStockPerdana;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbBesarPulsa;
    private javax.swing.JComboBox cbBesarPulsaHome;
    private javax.swing.JComboBox cbFilterJenisStock;
    private javax.swing.JComboBox cbFilterProviderStock;
    private javax.swing.JComboBox cbJenisReStock;
    private javax.swing.JComboBox cbJenisTagihan;
    private javax.swing.JComboBox cbProviderPulsa;
    private javax.swing.JComboBox cbProviderPulsaHome;
    private javax.swing.JComboBox cbProviderReStock;
    private javax.swing.JPanel headView;
    private javax.swing.JLabel icoAbout;
    private javax.swing.JLabel icoHome;
    private javax.swing.JLabel icoKartu;
    private javax.swing.JLabel icoKuota;
    private javax.swing.JLabel icoLogout;
    private javax.swing.JLabel icoManage;
    private javax.swing.JLabel icoPLNPDAM;
    private javax.swing.JLabel icoPendapatan;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollBar jScrollBar2;
    private javax.swing.JScrollBar jScrollBar3;
    private javax.swing.JScrollBar jScrollBar4;
    private javax.swing.JScrollBar jScrollBar5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel lblAppName;
    private javax.swing.JLabel lblEmployee_name;
    private javax.swing.JLabel lblEmployee_name1;
    private javax.swing.JLabel lblFormIdEmployee;
    private javax.swing.JLabel lblFormIdEmployee1;
    private javax.swing.JLabel lblFormPassword;
    private javax.swing.JLabel lblFormUsername;
    private javax.swing.JLabel lblHeaderCustomer;
    private javax.swing.JLabel lblHeaderEmployee;
    private javax.swing.JLabel lblHeaderFormEmployee;
    private javax.swing.JLabel lblHeaderFormEmployee1;
    private javax.swing.JLabel lblHeaderName;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblRole1;
    private javax.swing.JLabel lblRole2;
    private javax.swing.JPanel paneFormlReStockKuota;
    private javax.swing.JPanel panelFormCustomerView;
    private javax.swing.JPanel panelFormEmployeeView;
    private javax.swing.JPanel panelHomeView;
    private javax.swing.JPanel panelKartuView;
    private javax.swing.JPanel panelManageCustomerView;
    private javax.swing.JPanel panelManageEmployeeView;
    private javax.swing.JPanel panelManageView;
    private javax.swing.JPanel panelPendapatanView;
    private javax.swing.JPanel panelPulsaView;
    private javax.swing.JPanel panelReStockKuotaView;
    private javax.swing.JPanel panelReStockPerdanaView;
    private javax.swing.JPanel panelReStockView;
    private javax.swing.JPanel panelStockView;
    private javax.swing.JPanel panelTagihanView;
    private javax.swing.JPanel panelView;
    private javax.swing.JSeparator seperatorMenu;
    private javax.swing.JPanel sidePane;
    private javax.swing.JScrollPane spCustomer;
    private javax.swing.JScrollPane spEmployee;
    private javax.swing.JTable tblCustomer;
    private javax.swing.JTable tblCustomerCredit;
    private javax.swing.JTable tblEmployee;
    private javax.swing.JTable tblReStockPerdana;
    private javax.swing.JTable tblRestockKuotaPulsa;
    private javax.swing.JTable tblStock;
    private javax.swing.JTextField txtCustomerPhoneNumber;
    private javax.swing.JTextField txtCustomerStatus;
    private javax.swing.JTextField txtCustomer_name;
    private javax.swing.JTextField txtEmployee_name;
    private javax.swing.JTextField txtFormNomorPulsaHome;
    private javax.swing.JTextField txtId_Employee;
    private javax.swing.JTextField txtId_customer;
    private javax.swing.JTextField txtIsiPulsaHome;
    private javax.swing.JTextField txtJumlahNomorReStock;
    private javax.swing.JTextField txtKartuKuotaPendapatan;
    private javax.swing.JTextField txtKartuPerdanaPendapatan;
    private javax.swing.JTextField txtPDAMPendapatan;
    private javax.swing.JTextField txtPLNPendapatan;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPengeluaranPendapatan;
    private javax.swing.JTextField txtPulsaPendapatan;
    private javax.swing.JTextField txtRestockKuotaBalance_current;
    private javax.swing.JTextField txtRestockKuotaProviderName;
    private javax.swing.JTextField txtRestockKuotaType;
    private javax.swing.JTextField txtRole;
    private javax.swing.JTextField txtSisaKuota;
    private javax.swing.JLabel txtTotalPendapatan;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    public void loadDatabase() throws SQLException, EmployeeException, CustomerException, CustomerCreditException, CreditRestockKuotaException {
        EmployeeDao employeedao = CreamsDatabase.getEmployeeDao();
        CustomerDao customerdao = CreamsDatabase.getCustomerDao();
        CustomerCreditDao customercreditdao = CreamsDatabase.getCustomerCreditDao();
        CreditRestockKuotaDao creditrestockkuotadao = CreamsDatabase.getCreditRestockKuotaDao();
        
        employeeTableModel.setList(employeedao.selectAllEmployee());
        customerTableModel.setList(customerdao.selectAllCustomer());
        customerCreditTableModel.setList(customercreditdao.selectAllCustomerCredit());
        creditRestockKuotaTableModel.setList(creditrestockkuotadao.selectAllCreditRestockKuota());
    }
    
    @Override
    public void onSignin(EmployeeModel model) {
        
    }
    
    @Override
    public void onChange(EmployeeModel model) {
        txtId_Employee.setText(model.getId_employee() + "");
        txtUsername.setText(model.getUsername());
        txtEmployee_name.setText(model.getEmployee_name());
        txtRole.setText(model.getRole());
    }

    @Override
    public void onInsert(Employee employee) {
        employeeTableModel.add(employee);
    }

    @Override
    public void onUpdate(Employee employee) {
        int index = tblEmployee.getSelectedRow();
        employeeTableModel.set(index, employee);
    }

    @Override
    public void onDelete(Employee employee) {
        int index = tblEmployee.getSelectedRow();
        employeeTableModel.remove(index);
    }

    @Override
    public void onChange(CustomerModel model) {
        txtId_customer.setText(model.getId_customer()+ "");
        txtCustomer_name.setText(model.getCustomer_name());
        txtCustomerPhoneNumber.setText(model.getPhone_number());
        txtCustomerStatus.setText(model.getStatus());
    }

    @Override
    public void onInsert(Customer customer) {
        customerTableModel.add(customer);
    }

    @Override
    public void onUpdate(Customer customer) {
        int index = tblCustomer.getSelectedRow();
        customerTableModel.set(index, customer);
    }
    
    @Override
    public void onDelete(Customer customer) {
        int index = tblCustomer.getSelectedRow();
        customerTableModel.remove(index);
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        try {
            Employee emp_model = employeeTableModel.get(tblEmployee.getSelectedRow());
            txtId_Employee.setText(emp_model.getId_employee() + "");
            txtUsername.setText(emp_model.getUsername());
            txtEmployee_name.setText(emp_model.getEmployee_name());
            txtRole.setText(emp_model.getRole());
        } catch (IndexOutOfBoundsException exception) {
        }
        
        try {
            Customer cus_model = customerTableModel.get(tblCustomer.getSelectedRow());
            txtId_customer.setText(cus_model.getId_customer()+ "");
            txtCustomer_name.setText(cus_model.getCustomer_name());
            txtCustomerPhoneNumber.setText(cus_model.getPhone_number());
            txtCustomerStatus.setText(cus_model.getStatus());
        } catch (IndexOutOfBoundsException exception) {
        }
        
        try {
            CreditRestockKuota cre = creditRestockKuotaTableModel.get(tblRestockKuotaPulsa.getSelectedRow());
            txtRestockKuotaProviderName.setText(cre.getProvider_name());
            txtRestockKuotaBalance_current.setText(cre.getBalance_current() + "");
            txtRestockKuotaType.setText(cre.getType());
        } catch (IndexOutOfBoundsException exception) {
        }
    }

    @Override
    public void onChange(CustomerCreditModel model) {
        txtFormNomorPulsaHome.setText(model.getId_customer_credit()+ "");
    }

    @Override
    public void onInsert(CustomerCredit customerCredit) {
        customerCreditTableModel.add(customerCredit);
    }

    @Override
    public void onChange(CreditRestockKuotaModel model) {
        txtRestockKuotaProviderName.setText(model.getProvider_name());
        txtFormNomorPulsaHome.setText(model.getBalance_current()+ "");
    }

    @Override
    public void onUpdate(CreditRestockKuota creditRestockKuota) {
        int index = tblRestockKuotaPulsa.getSelectedRow();
        creditRestockKuotaTableModel.set(index, creditRestockKuota);
    }
}
