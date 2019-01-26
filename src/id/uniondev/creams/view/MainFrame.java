/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.view;

import id.uniondev.creams.controller.CustomerController;
import id.uniondev.creams.controller.EmployeeController;
import id.uniondev.creams.controller.CustomerCreditController;
import id.uniondev.creams.controller.CreditRestockController;
import id.uniondev.creams.controller.CustomerBillController;
import id.uniondev.creams.controller.IncomeController;
import id.uniondev.creams.controller.ProviderController;
import id.uniondev.creams.database.CreamsDatabase;
import id.uniondev.creams.entity.CreditRestock;
import id.uniondev.creams.entity.CustomerBill;
import id.uniondev.creams.entity.Customer;
import id.uniondev.creams.entity.Employee;
import id.uniondev.creams.entity.CustomerCredit;
import id.uniondev.creams.entity.Income;
import id.uniondev.creams.entity.Provider;
import id.uniondev.creams.error.CreditRestockException;
import id.uniondev.creams.error.CustomerBillException;
import id.uniondev.creams.error.CustomerCreditException;
import id.uniondev.creams.error.CustomerException;
import id.uniondev.creams.error.EmployeeException;
import id.uniondev.creams.error.IncomeException;
import id.uniondev.creams.error.ProviderException;
import id.uniondev.creams.event.CustomerCreditListener;
import id.uniondev.creams.event.CustomerBillListener;
import id.uniondev.creams.event.CustomerListener;
import id.uniondev.creams.event.EmployeeListener;
import id.uniondev.creams.event.CreditRestockListener;
import id.uniondev.creams.event.IncomeListener;
import id.uniondev.creams.event.ProviderListener;
import id.uniondev.creams.model.CreditRestockKuotaTableModel;
import id.uniondev.creams.model.CustomerModel;
import id.uniondev.creams.model.CustomerTableModel;
import id.uniondev.creams.model.EmployeeModel;
import id.uniondev.creams.model.EmployeeTableModel;
import id.uniondev.creams.model.CustomerCreditModel;
import id.uniondev.creams.model.CustomerCreditTableModel;
import id.uniondev.creams.model.CustomerBillModel;
import id.uniondev.creams.model.CustomerBillTableModel;
import id.uniondev.creams.model.IncomeModel;
import id.uniondev.creams.model.IncomeTableModel;
import id.uniondev.creams.model.CreditRestockModel;
import id.uniondev.creams.model.CreditRestockPerdanaTableModel;
import id.uniondev.creams.model.CreditRestockTableModel;
import id.uniondev.creams.model.ProviderModel;
import id.uniondev.creams.model.ProviderTableModel;
import id.uniondev.creams.service.CustomerDao;
import id.uniondev.creams.service.EmployeeDao;
import id.uniondev.creams.service.CustomerBillDao;
import id.uniondev.creams.service.CustomerCreditDao;
import id.uniondev.creams.service.CreditRestockDao;
import id.uniondev.creams.service.IncomeDao;
import id.uniondev.creams.service.ProviderDao;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JPanel;


/**
 *
 * @author UnionDev
 */
public class MainFrame extends javax.swing.JFrame implements EmployeeListener, CustomerListener, CustomerCreditListener, CreditRestockListener, CustomerBillListener, IncomeListener, ProviderListener, ListSelectionListener {

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
    private CreditRestockTableModel creditRestockTableModel;
    private CreditRestockKuotaTableModel creditRestockKuotaTableModel;
    private CreditRestockPerdanaTableModel creditRestockPerdanaTableModel;
    private CustomerBillTableModel customerBillTableModel;
    private IncomeTableModel incomeTableModel;
    private ProviderTableModel providerTableModel;
    
    private EmployeeModel employeeModel;
    private CustomerModel customerModel;
    private CustomerCreditModel customerCreditModel;
    private CreditRestockModel creditRestockModel;
    private CustomerBillModel customerBillModel;
    private IncomeModel incomeModel;
    private ProviderModel providerModel;
    
    private EmployeeController employeeController;
    private CustomerController customerController;
    private CustomerCreditController customerCreditController;
    private CreditRestockController creditRestockController;
    private CustomerBillController customerBillController;
    private IncomeController incomeController;
    private ProviderController providerController;
    
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
        
        creditRestockTableModel = new CreditRestockTableModel();
        creditRestockKuotaTableModel = new CreditRestockKuotaTableModel();
        creditRestockPerdanaTableModel = new CreditRestockPerdanaTableModel();
        creditRestockModel = new CreditRestockModel();
        creditRestockModel.setListener(this);
        creditRestockController = new CreditRestockController();
        creditRestockController.setModel(creditRestockModel);
        
        customerBillTableModel = new CustomerBillTableModel();
        customerBillModel = new CustomerBillModel();
        customerBillModel.setListener(this);
        customerBillController = new CustomerBillController();
        customerBillController.setModel(customerBillModel);
        
        incomeTableModel = new IncomeTableModel();
        incomeModel = new IncomeModel();
        incomeModel.setListener(this);
        incomeController = new IncomeController();
        incomeController.setModel(incomeModel);
        
        providerTableModel = new ProviderTableModel();
        providerModel = new ProviderModel();
        providerModel.setListener(this);
        providerController = new ProviderController();
        providerController.setModel(providerModel);
        
        initComponents();
        setSidemenu_active(0);
        
        tblEmployee.getSelectionModel().addListSelectionListener(this);
        tblEmployee.setModel(employeeTableModel);
        
        tblCustomer.getSelectionModel().addListSelectionListener(this);
        tblCustomer.setModel(customerTableModel);
        
        tblCustomerCredit.getSelectionModel().addListSelectionListener(this);
        tblCustomerCredit.setModel(customerCreditTableModel);
        
        tblRestockPulsa.getSelectionModel().addListSelectionListener(this);
        tblRestockPulsa.setModel(creditRestockTableModel);
        
        tblRestockKuotaView.getSelectionModel().addListSelectionListener(this);
        tblRestockKuotaView.setModel(creditRestockKuotaTableModel);
        
        tblStock.getSelectionModel().addListSelectionListener(this);
        tblStock.setModel(creditRestockPerdanaTableModel);
        
        tblCustomerBill.getSelectionModel().addListSelectionListener(this);
        tblCustomerBill.setModel(customerBillTableModel);
        
        tblPendapatan.getSelectionModel().addListSelectionListener(this);
        tblPendapatan.setModel(incomeTableModel);
        
        tblProvider.getSelectionModel().addListSelectionListener(this);
        tblProvider.setModel(providerTableModel);
    }

    public int getSidemenu_active() {
        return sidemenu_active;
    }

    public void setSidemenu_active(int sidemenu_active) {
        btnHomeMenu.setBackground(sidemenu_exited);
        btnPulsaMenu.setBackground(sidemenu_exited);
        btnPlnPdamMenu.setBackground(sidemenu_exited);
        btnKartuMenu.setBackground(sidemenu_exited);
        btnPendapatanMenu.setBackground(sidemenu_exited);
        btnManageMenu.setBackground(sidemenu_exited);
        switch(sidemenu_active) {
            case 1 : 
                btnHomeMenu.setBackground(sidemenu_active_color);
                break;
            case 2 : 
                btnPulsaMenu.setBackground(sidemenu_active_color);
                break;
            case 3 : 
                btnPlnPdamMenu.setBackground(sidemenu_active_color);
                break;
            case 4 : 
                btnKartuMenu.setBackground(sidemenu_active_color);
                break;
            case 5 : 
                btnPendapatanMenu.setBackground(sidemenu_active_color);
                break;
            case 6 : 
                btnManageMenu.setBackground(sidemenu_active_color);
                break;
            default :
                break;
        }
        this.sidemenu_active = sidemenu_active;
    }
    
    public JPanel getBtnPendapatanMenu() {
        return btnPendapatanMenu;
    }
    
    public JPanel getBtnManageMenu() {
        return btnManageMenu;
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
        tblRestockPulsa = new javax.swing.JTable();
        btnReStockKuotaPulsa = new javax.swing.JButton();
        cbProviderPulsa = new javax.swing.JComboBox();
        cbBesarPulsa = new javax.swing.JComboBox();
        paneFormReStockKuota = new javax.swing.JPanel();
        btnRestockKuotaSave = new javax.swing.JButton();
        txtRestockBalance_current = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtRestockProviderName = new javax.swing.JTextField();
        txtRestockType = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        panelReStockPerdanaView = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblReStockPerdana = new javax.swing.JTable();
        btnSaveReStockPerdana = new javax.swing.JButton();
        btnBackReStockPerdana = new javax.swing.JButton();
        btnSubmitReStockPerdana = new javax.swing.JButton();
        jScrollBar1 = new javax.swing.JScrollBar();
        panelReStockKuotaView = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRestockKuotaView = new javax.swing.JTable();
        jScrollBar2 = new javax.swing.JScrollBar();
        btnBackReStockKuota = new javax.swing.JButton();
        btnSaveReStockKuota = new javax.swing.JButton();
        btnSubmitReStockKuota = new javax.swing.JButton();
        panelStockView = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblStock = new javax.swing.JTable();
        jScrollBar3 = new javax.swing.JScrollBar();
        jButton9 = new javax.swing.JButton();
        cbFilterProviderStock = new javax.swing.JComboBox();
        cbFilterJenisStock = new javax.swing.JComboBox();
        panelTagihanView = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCustomerBill = new javax.swing.JTable();
        cbJenisTagihan = new javax.swing.JComboBox();
        jScrollBar4 = new javax.swing.JScrollBar();
        btnDeleteTagihan = new javax.swing.JButton();
        btnFormCustomer1 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        panelFormTagihanView = new javax.swing.JPanel();
        lblHeaderFormTagihan = new javax.swing.JLabel();
        txtFormCustomerBillId_customer_bill = new javax.swing.JTextField();
        lblIdPelangganTagihan = new javax.swing.JLabel();
        txtFormCustomerBillCustomer_number = new javax.swing.JTextField();
        txtFormCustomerBillCustomer_name = new javax.swing.JTextField();
        txtFormCustomerBillType = new javax.swing.JTextField();
        lblNoPelangganTagihan = new javax.swing.JLabel();
        lblNamaPelangganTagihan = new javax.swing.JLabel();
        lblJenis = new javax.swing.JLabel();
        txtFormCustomerBillBalance = new javax.swing.JTextField();
        lblBalancePembayaran = new javax.swing.JLabel();
        btnFormCustomerBillCreate = new javax.swing.JButton();
        btnFormCustomerBillUpdate = new javax.swing.JButton();
        btnFormCustomerBillKembali = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        cbJenisPembayaran = new javax.swing.JComboBox<>();
        btnFormCustomerBillReset = new javax.swing.JButton();
        panelFormPendapatanView = new javax.swing.JPanel();
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
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtPendapatanCreditPerdana = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnPendapatanSave = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        txtPendapatanOutcome = new javax.swing.JTextField();
        txtPendapatanPDAM = new javax.swing.JTextField();
        txtPendapatanPLN = new javax.swing.JTextField();
        txtPendapatanCreditKuota = new javax.swing.JTextField();
        txtPendapatanCredit = new javax.swing.JTextField();
        txtPendapatanTotal = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        txtPendapatanId_income = new javax.swing.JTextField();
        panelPendapatanView = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblPendapatan = new javax.swing.JTable();
        lblHeaderCustomer1 = new javax.swing.JLabel();
        btnFormPendapatan = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        panelManageView = new javax.swing.JPanel();
        btnEmployeeView = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnCustomerView = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        btnProviderView = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
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
        panelFormCustomerView1 = new javax.swing.JPanel();
        lblHeaderFormEmployee2 = new javax.swing.JLabel();
        lblFormIdEmployee2 = new javax.swing.JLabel();
        txtId_customer1 = new javax.swing.JTextField();
        lblEmployee_name2 = new javax.swing.JLabel();
        txtCustomer_name1 = new javax.swing.JTextField();
        lblRole3 = new javax.swing.JLabel();
        txtCustomerPhoneNumber1 = new javax.swing.JTextField();
        btnBacktoManageCustomer1 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        btnFormCustomerCreate1 = new javax.swing.JButton();
        btnFormCustomerUpdate1 = new javax.swing.JButton();
        btnFormCustomerReset1 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        txtCustomerStatus1 = new javax.swing.JTextField();
        lblRole4 = new javax.swing.JLabel();
        panelManageProviderView = new javax.swing.JPanel();
        lblHeaderCustomer2 = new javax.swing.JLabel();
        btnFormProviderDelete = new javax.swing.JButton();
        spCustomer1 = new javax.swing.JScrollPane();
        tblProvider = new javax.swing.JTable();
        btnFormProvider = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        panelFormProviderView = new javax.swing.JPanel();
        lblHeaderFormEmployee3 = new javax.swing.JLabel();
        lblFormIdEmployee3 = new javax.swing.JLabel();
        txtFormProviderId_provider = new javax.swing.JTextField();
        lblEmployee_name3 = new javax.swing.JLabel();
        txtFormProviderProvider_name = new javax.swing.JTextField();
        btnBacktoManageProvider = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        btnFormProviderCreate = new javax.swing.JButton();
        btnFormProviderUpdate = new javax.swing.JButton();
        btnFormProviderReset = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
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
        setResizable(false);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
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

        tblRestockPulsa.setBackground(new java.awt.Color(0, 0, 0));
        tblRestockPulsa.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tblRestockPulsa.setForeground(new java.awt.Color(240, 240, 240));
        tblRestockPulsa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"TELKOMSEL", null, null},
                {"TRI", null, null},
                {"INDOSAT", null, null},
                {"XL", null, null},
                {"AXIS", null, null},
                {"SMARTFREN", null, null}
            },
            new String [] {
                "PROVIDER", "KUOTA", "TYPE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tblRestockPulsa);

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
                        .addGap(18, 18, 18)
                        .addGroup(panelPulsaViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPulsaViewLayout.createSequentialGroup()
                                .addGap(0, 47, Short.MAX_VALUE)
                                .addComponent(btnReStockKuotaPulsa, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
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
                .addContainerGap(95, Short.MAX_VALUE))
        );

        panelView.add(panelPulsaView, "card5");

        paneFormReStockKuota.setBackground(new java.awt.Color(0, 0, 0));

        btnRestockKuotaSave.setText("Save");
        btnRestockKuotaSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRestockKuotaSaveMouseClicked(evt);
            }
        });
        btnRestockKuotaSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestockKuotaSaveActionPerformed(evt);
            }
        });

        txtRestockBalance_current.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("KARTU PROVIDER");

        txtRestockProviderName.setEditable(false);
        txtRestockProviderName.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtRestockProviderName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRestockProviderNameActionPerformed(evt);
            }
        });

        txtRestockType.setEditable(false);
        txtRestockType.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Type");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Provider");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Balance");

        javax.swing.GroupLayout paneFormReStockKuotaLayout = new javax.swing.GroupLayout(paneFormReStockKuota);
        paneFormReStockKuota.setLayout(paneFormReStockKuotaLayout);
        paneFormReStockKuotaLayout.setHorizontalGroup(
            paneFormReStockKuotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneFormReStockKuotaLayout.createSequentialGroup()
                .addGroup(paneFormReStockKuotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneFormReStockKuotaLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel13))
                    .addGroup(paneFormReStockKuotaLayout.createSequentialGroup()
                        .addGroup(paneFormReStockKuotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paneFormReStockKuotaLayout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jLabel16))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneFormReStockKuotaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(paneFormReStockKuotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(18, 18, 18)
                        .addGroup(paneFormReStockKuotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtRestockProviderName, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                            .addComponent(txtRestockBalance_current)
                            .addComponent(txtRestockType)
                            .addComponent(btnRestockKuotaSave, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(281, Short.MAX_VALUE))
        );
        paneFormReStockKuotaLayout.setVerticalGroup(
            paneFormReStockKuotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneFormReStockKuotaLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel13)
                .addGap(84, 84, 84)
                .addGroup(paneFormReStockKuotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRestockProviderName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneFormReStockKuotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRestockBalance_current, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneFormReStockKuotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRestockType, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(btnRestockKuotaSave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        panelView.add(paneFormReStockKuota, "card11");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(btnSubmitReStockPerdana)
                .addContainerGap())
        );

        panelView.add(panelReStockPerdanaView, "card8");

        panelReStockKuotaView.setBackground(new java.awt.Color(0, 0, 0));

        tblRestockKuotaView.setBackground(new java.awt.Color(0, 0, 0));
        tblRestockKuotaView.setForeground(new java.awt.Color(240, 240, 240));
        tblRestockKuotaView.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblRestockKuotaView);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelReStockKuotaViewLayout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(panelReStockKuotaViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelReStockKuotaViewLayout.createSequentialGroup()
                        .addComponent(btnBackReStockKuota, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnSaveReStockKuota, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelReStockKuotaViewLayout.createSequentialGroup()
                        .addGroup(panelReStockKuotaViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSubmitReStockKuota, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelReStockKuotaViewLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(61, 61, 61))))
        );
        panelReStockKuotaViewLayout.setVerticalGroup(
            panelReStockKuotaViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReStockKuotaViewLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelReStockKuotaViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelReStockKuotaViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveReStockKuota)
                    .addComponent(btnBackReStockKuota))
                .addGap(14, 14, 14)
                .addComponent(btnSubmitReStockKuota)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelView.add(panelReStockKuotaView, "card9");

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

        javax.swing.GroupLayout panelStockViewLayout = new javax.swing.GroupLayout(panelStockView);
        panelStockView.setLayout(panelStockViewLayout);
        panelStockViewLayout.setHorizontalGroup(
            panelStockViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStockViewLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelStockViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelStockViewLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9)
                .addGap(22, 22, 22))
        );

        panelView.add(panelStockView, "card10");

        panelTagihanView.setBackground(new java.awt.Color(0, 0, 0));

        tblCustomerBill.setBackground(new java.awt.Color(0, 0, 0));
        tblCustomerBill.setForeground(new java.awt.Color(240, 240, 240));
        tblCustomerBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tblCustomerBill);

        cbJenisTagihan.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cbJenisTagihan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--JENIS--", "PLN", "PDAM" }));

        btnDeleteTagihan.setText("HAPUS");
        btnDeleteTagihan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteTagihanActionPerformed(evt);
            }
        });

        btnFormCustomer1.setBackground(new java.awt.Color(153, 0, 153));
        btnFormCustomer1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFormCustomer1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFormCustomer1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFormCustomer1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFormCustomer1MouseExited(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Form");

        javax.swing.GroupLayout btnFormCustomer1Layout = new javax.swing.GroupLayout(btnFormCustomer1);
        btnFormCustomer1.setLayout(btnFormCustomer1Layout);
        btnFormCustomer1Layout.setHorizontalGroup(
            btnFormCustomer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnFormCustomer1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel55)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        btnFormCustomer1Layout.setVerticalGroup(
            btnFormCustomer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel55, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelTagihanViewLayout = new javax.swing.GroupLayout(panelTagihanView);
        panelTagihanView.setLayout(panelTagihanViewLayout);
        panelTagihanViewLayout.setHorizontalGroup(
            panelTagihanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTagihanViewLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(panelTagihanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbJenisTagihan, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelTagihanViewLayout.createSequentialGroup()
                        .addGroup(panelTagihanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelTagihanViewLayout.createSequentialGroup()
                                .addComponent(btnFormCustomer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDeleteTagihan, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollBar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
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
                    .addComponent(btnDeleteTagihan)
                    .addComponent(btnFormCustomer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        panelView.add(panelTagihanView, "card4");

        panelFormTagihanView.setBackground(new java.awt.Color(0, 0, 0));

        lblHeaderFormTagihan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblHeaderFormTagihan.setForeground(new java.awt.Color(255, 255, 255));
        lblHeaderFormTagihan.setText("FORM PLN/PDAM");

        txtFormCustomerBillId_customer_bill.setEditable(false);

        lblIdPelangganTagihan.setForeground(new java.awt.Color(255, 255, 255));
        lblIdPelangganTagihan.setText("ID");

        txtFormCustomerBillType.setEditable(false);

        lblNoPelangganTagihan.setForeground(new java.awt.Color(255, 255, 255));
        lblNoPelangganTagihan.setText("PLN/PDAM Number");

        lblNamaPelangganTagihan.setForeground(new java.awt.Color(255, 255, 255));
        lblNamaPelangganTagihan.setText("Customer Name");

        lblJenis.setForeground(new java.awt.Color(255, 255, 255));
        lblJenis.setText("Type");

        lblBalancePembayaran.setForeground(new java.awt.Color(255, 255, 255));
        lblBalancePembayaran.setText("Balance");

        btnFormCustomerBillCreate.setText("Create");
        btnFormCustomerBillCreate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFormCustomerBillCreateMouseClicked(evt);
            }
        });
        btnFormCustomerBillCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormCustomerBillCreateActionPerformed(evt);
            }
        });

        btnFormCustomerBillUpdate.setText("Update");
        btnFormCustomerBillUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormCustomerBillUpdateActionPerformed(evt);
            }
        });

        btnFormCustomerBillKembali.setBackground(new java.awt.Color(153, 0, 153));
        btnFormCustomerBillKembali.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFormCustomerBillKembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFormCustomerBillKembaliMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFormCustomerBillKembaliMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFormCustomerBillKembaliMouseExited(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Kembali");

        javax.swing.GroupLayout btnFormCustomerBillKembaliLayout = new javax.swing.GroupLayout(btnFormCustomerBillKembali);
        btnFormCustomerBillKembali.setLayout(btnFormCustomerBillKembaliLayout);
        btnFormCustomerBillKembaliLayout.setHorizontalGroup(
            btnFormCustomerBillKembaliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 74, Short.MAX_VALUE)
            .addGroup(btnFormCustomerBillKembaliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnFormCustomerBillKembaliLayout.createSequentialGroup()
                    .addGap(0, 13, Short.MAX_VALUE)
                    .addComponent(jLabel49)
                    .addGap(0, 13, Short.MAX_VALUE)))
        );
        btnFormCustomerBillKembaliLayout.setVerticalGroup(
            btnFormCustomerBillKembaliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
            .addGroup(btnFormCustomerBillKembaliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnFormCustomerBillKembaliLayout.createSequentialGroup()
                    .addGap(0, 7, Short.MAX_VALUE)
                    .addComponent(jLabel49)
                    .addGap(0, 8, Short.MAX_VALUE)))
        );

        cbJenisPembayaran.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--TYPE--", "PLN", "PDAM" }));
        cbJenisPembayaran.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbJenisPembayaranPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        btnFormCustomerBillReset.setText("Reset");
        btnFormCustomerBillReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormCustomerBillResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFormTagihanViewLayout = new javax.swing.GroupLayout(panelFormTagihanView);
        panelFormTagihanView.setLayout(panelFormTagihanViewLayout);
        panelFormTagihanViewLayout.setHorizontalGroup(
            panelFormTagihanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormTagihanViewLayout.createSequentialGroup()
                .addGroup(panelFormTagihanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormTagihanViewLayout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addGroup(panelFormTagihanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelFormTagihanViewLayout.createSequentialGroup()
                                .addComponent(lblIdPelangganTagihan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtFormCustomerBillId_customer_bill, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelFormTagihanViewLayout.createSequentialGroup()
                                .addComponent(lblNoPelangganTagihan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                .addComponent(txtFormCustomerBillCustomer_number, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelFormTagihanViewLayout.createSequentialGroup()
                                .addComponent(lblBalancePembayaran)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtFormCustomerBillBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelFormTagihanViewLayout.createSequentialGroup()
                                .addComponent(btnFormCustomerBillReset)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnFormCustomerBillUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFormCustomerBillCreate))
                            .addGroup(panelFormTagihanViewLayout.createSequentialGroup()
                                .addGroup(panelFormTagihanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNamaPelangganTagihan)
                                    .addComponent(lblJenis))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelFormTagihanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelFormTagihanViewLayout.createSequentialGroup()
                                        .addComponent(cbJenisPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFormCustomerBillType, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtFormCustomerBillCustomer_name, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnFormCustomerBillKembali, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelFormTagihanViewLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(lblHeaderFormTagihan)))
                .addContainerGap(178, Short.MAX_VALUE))
        );
        panelFormTagihanViewLayout.setVerticalGroup(
            panelFormTagihanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormTagihanViewLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblHeaderFormTagihan)
                .addGap(26, 26, 26)
                .addComponent(btnFormCustomerBillKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelFormTagihanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFormCustomerBillId_customer_bill, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdPelangganTagihan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormTagihanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFormCustomerBillCustomer_number, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNoPelangganTagihan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormTagihanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFormCustomerBillCustomer_name, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNamaPelangganTagihan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormTagihanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbJenisPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelFormTagihanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFormCustomerBillType, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblJenis)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormTagihanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFormCustomerBillBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBalancePembayaran))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormTagihanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelFormTagihanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnFormCustomerBillUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(btnFormCustomerBillReset, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                    .addComponent(btnFormCustomerBillCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        panelView.add(panelFormTagihanView, "card17");

        panelFormPendapatanView.setBackground(new java.awt.Color(0, 0, 0));

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

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(240, 240, 240));
        jLabel33.setText("Rp");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(240, 240, 240));
        jLabel34.setText("Rp");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(240, 240, 240));
        jLabel35.setText("Rp");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(240, 240, 240));
        jLabel36.setText("Rp");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(240, 240, 240));
        jLabel38.setText("Rp");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(240, 240, 240));
        jLabel40.setText("Rp");

        txtPendapatanCreditPerdana.setEditable(false);
        txtPendapatanCreditPerdana.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(240, 240, 240));
        jLabel41.setText("TOTAL");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(240, 240, 240));
        jLabel42.setText(":");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(240, 240, 240));
        jLabel14.setText("*Ketik total pengeluaran");

        btnPendapatanSave.setBackground(new java.awt.Color(92, 0, 122));
        btnPendapatanSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPendapatanSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPendapatanSaveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPendapatanSaveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPendapatanSaveMouseExited(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Save");

        javax.swing.GroupLayout btnPendapatanSaveLayout = new javax.swing.GroupLayout(btnPendapatanSave);
        btnPendapatanSave.setLayout(btnPendapatanSaveLayout);
        btnPendapatanSaveLayout.setHorizontalGroup(
            btnPendapatanSaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPendapatanSaveLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel43)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        btnPendapatanSaveLayout.setVerticalGroup(
            btnPendapatanSaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPendapatanSaveLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtPendapatanOutcome.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        txtPendapatanPDAM.setEditable(false);
        txtPendapatanPDAM.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        txtPendapatanPLN.setEditable(false);
        txtPendapatanPLN.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        txtPendapatanCreditKuota.setEditable(false);
        txtPendapatanCreditKuota.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        txtPendapatanCredit.setEditable(false);
        txtPendapatanCredit.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        txtPendapatanTotal.setEditable(false);

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("PENDAPATAN");

        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(240, 240, 240));
        jLabel45.setText("Rp");

        txtPendapatanId_income.setEditable(false);

        javax.swing.GroupLayout panelFormPendapatanViewLayout = new javax.swing.GroupLayout(panelFormPendapatanView);
        panelFormPendapatanView.setLayout(panelFormPendapatanViewLayout);
        panelFormPendapatanViewLayout.setHorizontalGroup(
            panelFormPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormPendapatanViewLayout.createSequentialGroup()
                .addGroup(panelFormPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormPendapatanViewLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelFormPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelFormPendapatanViewLayout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addGap(427, 427, 427))
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelFormPendapatanViewLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(panelFormPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormPendapatanViewLayout.createSequentialGroup()
                                .addGroup(panelFormPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelFormPendapatanViewLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtPendapatanTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelFormPendapatanViewLayout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnPendapatanSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(24, 24, 24))
                            .addGroup(panelFormPendapatanViewLayout.createSequentialGroup()
                                .addGroup(panelFormPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelFormPendapatanViewLayout.createSequentialGroup()
                                        .addGroup(panelFormPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(195, 195, 195)
                                        .addGroup(panelFormPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(panelFormPendapatanViewLayout.createSequentialGroup()
                                                .addGroup(panelFormPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(44, 44, 44)
                                                .addGroup(panelFormPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(panelFormPendapatanViewLayout.createSequentialGroup()
                                                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtPendapatanCreditKuota, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(panelFormPendapatanViewLayout.createSequentialGroup()
                                                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtPendapatanPDAM))
                                                    .addGroup(panelFormPendapatanViewLayout.createSequentialGroup()
                                                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtPendapatanPLN, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(panelFormPendapatanViewLayout.createSequentialGroup()
                                                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtPendapatanCreditPerdana, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(panelFormPendapatanViewLayout.createSequentialGroup()
                                                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addGroup(panelFormPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(txtPendapatanCredit, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtPendapatanId_income, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                            .addGroup(panelFormPendapatanViewLayout.createSequentialGroup()
                                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(44, 44, 44)
                                                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtPendapatanOutcome))
                                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel44))
                                .addGap(0, 105, Short.MAX_VALUE)))))
                .addGap(24, 24, 24))
        );
        panelFormPendapatanViewLayout.setVerticalGroup(
            panelFormPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormPendapatanViewLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panelFormPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(txtPendapatanId_income, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelFormPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(txtPendapatanCredit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelFormPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel31)
                        .addComponent(jLabel34)
                        .addComponent(txtPendapatanCreditKuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelFormPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel30)
                        .addComponent(jLabel35)
                        .addComponent(txtPendapatanCreditPerdana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(14, 14, 14)
                .addGroup(panelFormPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel28)
                    .addComponent(jLabel36)
                    .addComponent(txtPendapatanPLN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(panelFormPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel38)
                    .addComponent(jLabel29)
                    .addComponent(txtPendapatanPDAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelFormPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelFormPendapatanViewLayout.createSequentialGroup()
                        .addComponent(txtPendapatanOutcome, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                        .addGap(2, 2, 2))
                    .addGroup(panelFormPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel37)
                        .addComponent(jLabel40)
                        .addComponent(jLabel39)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(panelFormPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormPendapatanViewLayout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(panelFormPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41)
                            .addComponent(jLabel42)
                            .addComponent(txtPendapatanTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45))
                        .addGap(42, 42, 42)
                        .addComponent(jLabel14))
                    .addComponent(btnPendapatanSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        panelView.add(panelFormPendapatanView, "card6");

        panelPendapatanView.setBackground(new java.awt.Color(0, 0, 0));

        tblPendapatan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(tblPendapatan);

        lblHeaderCustomer1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblHeaderCustomer1.setForeground(new java.awt.Color(240, 240, 240));
        lblHeaderCustomer1.setText("DATA PENDAPATAN");

        btnFormPendapatan.setBackground(new java.awt.Color(153, 0, 153));
        btnFormPendapatan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFormPendapatan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFormPendapatanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFormPendapatanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFormPendapatanMouseExited(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("Form");

        javax.swing.GroupLayout btnFormPendapatanLayout = new javax.swing.GroupLayout(btnFormPendapatan);
        btnFormPendapatan.setLayout(btnFormPendapatanLayout);
        btnFormPendapatanLayout.setHorizontalGroup(
            btnFormPendapatanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnFormPendapatanLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel57)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        btnFormPendapatanLayout.setVerticalGroup(
            btnFormPendapatanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel57, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelPendapatanViewLayout = new javax.swing.GroupLayout(panelPendapatanView);
        panelPendapatanView.setLayout(panelPendapatanViewLayout);
        panelPendapatanViewLayout.setHorizontalGroup(
            panelPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPendapatanViewLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panelPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFormPendapatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHeaderCustomer1)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        panelPendapatanViewLayout.setVerticalGroup(
            panelPendapatanViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPendapatanViewLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblHeaderCustomer1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnFormPendapatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        panelView.add(panelPendapatanView, "card16");

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

        btnProviderView.setBackground(new java.awt.Color(153, 0, 153));
        btnProviderView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProviderView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProviderViewMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProviderViewMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProviderViewMouseExited(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Provider");

        javax.swing.GroupLayout btnProviderViewLayout = new javax.swing.GroupLayout(btnProviderView);
        btnProviderView.setLayout(btnProviderViewLayout);
        btnProviderViewLayout.setHorizontalGroup(
            btnProviderViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnProviderViewLayout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jLabel46)
                .addGap(54, 54, 54))
        );
        btnProviderViewLayout.setVerticalGroup(
            btnProviderViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnProviderViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelManageViewLayout = new javax.swing.GroupLayout(panelManageView);
        panelManageView.setLayout(panelManageViewLayout);
        panelManageViewLayout.setHorizontalGroup(
            panelManageViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelManageViewLayout.createSequentialGroup()
                .addGroup(panelManageViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelManageViewLayout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(btnEmployeeView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125)
                        .addComponent(btnCustomerView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelManageViewLayout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(btnProviderView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 181, Short.MAX_VALUE))
        );
        panelManageViewLayout.setVerticalGroup(
            panelManageViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelManageViewLayout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addGroup(panelManageViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEmployeeView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCustomerView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addComponent(btnProviderView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
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
                .addContainerGap(28, Short.MAX_VALUE)
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
                .addContainerGap(64, Short.MAX_VALUE))
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
                .addContainerGap(28, Short.MAX_VALUE)
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

        panelFormCustomerView1.setBackground(new java.awt.Color(0, 0, 0));

        lblHeaderFormEmployee2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblHeaderFormEmployee2.setForeground(new java.awt.Color(240, 240, 240));
        lblHeaderFormEmployee2.setText("FORM CUSTOMER");

        lblFormIdEmployee2.setForeground(new java.awt.Color(255, 255, 255));
        lblFormIdEmployee2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFormIdEmployee2.setText("ID");

        txtId_customer1.setEditable(false);

        lblEmployee_name2.setForeground(new java.awt.Color(255, 255, 255));
        lblEmployee_name2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmployee_name2.setText("Full Name");

        lblRole3.setForeground(new java.awt.Color(255, 255, 255));
        lblRole3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRole3.setText("Phone Num.");

        btnBacktoManageCustomer1.setBackground(new java.awt.Color(153, 0, 153));
        btnBacktoManageCustomer1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBacktoManageCustomer1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBacktoManageCustomer1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBacktoManageCustomer1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBacktoManageCustomer1MouseExited(evt);
            }
        });

        jLabel56.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("Back");

        javax.swing.GroupLayout btnBacktoManageCustomer1Layout = new javax.swing.GroupLayout(btnBacktoManageCustomer1);
        btnBacktoManageCustomer1.setLayout(btnBacktoManageCustomer1Layout);
        btnBacktoManageCustomer1Layout.setHorizontalGroup(
            btnBacktoManageCustomer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBacktoManageCustomer1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel56)
                .addGap(29, 29, 29))
        );
        btnBacktoManageCustomer1Layout.setVerticalGroup(
            btnBacktoManageCustomer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnBacktoManageCustomer1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel56)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnFormCustomerCreate1.setText("Create");
        btnFormCustomerCreate1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFormCustomerCreate1MouseClicked(evt);
            }
        });
        btnFormCustomerCreate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormCustomerCreate1ActionPerformed(evt);
            }
        });

        btnFormCustomerUpdate1.setText("Update");
        btnFormCustomerUpdate1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFormCustomerUpdate1MouseClicked(evt);
            }
        });
        btnFormCustomerUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormCustomerUpdate1ActionPerformed(evt);
            }
        });

        btnFormCustomerReset1.setText("Reset");
        btnFormCustomerReset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormCustomerReset1ActionPerformed(evt);
            }
        });

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lblRole4.setForeground(new java.awt.Color(255, 255, 255));
        lblRole4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRole4.setText("Status");

        javax.swing.GroupLayout panelFormCustomerView1Layout = new javax.swing.GroupLayout(panelFormCustomerView1);
        panelFormCustomerView1.setLayout(panelFormCustomerView1Layout);
        panelFormCustomerView1Layout.setHorizontalGroup(
            panelFormCustomerView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormCustomerView1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(panelFormCustomerView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormCustomerView1Layout.createSequentialGroup()
                        .addGroup(panelFormCustomerView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBacktoManageCustomer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHeaderFormEmployee2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelFormCustomerView1Layout.createSequentialGroup()
                        .addGroup(panelFormCustomerView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFormCustomerView1Layout.createSequentialGroup()
                                .addComponent(lblFormIdEmployee2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormCustomerView1Layout.createSequentialGroup()
                                .addGroup(panelFormCustomerView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(panelFormCustomerView1Layout.createSequentialGroup()
                                        .addComponent(lblEmployee_name2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10))
                                    .addComponent(lblRole3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblRole4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)))
                        .addGroup(panelFormCustomerView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId_customer1)
                            .addGroup(panelFormCustomerView1Layout.createSequentialGroup()
                                .addComponent(btnFormCustomerReset1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(262, 262, 262)
                                .addComponent(btnFormCustomerCreate1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFormCustomerUpdate1, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                            .addComponent(txtCustomerPhoneNumber1)
                            .addComponent(txtCustomer_name1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCustomerStatus1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(32, 32, 32))
        );
        panelFormCustomerView1Layout.setVerticalGroup(
            panelFormCustomerView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormCustomerView1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblHeaderFormEmployee2)
                .addGap(26, 26, 26)
                .addComponent(btnBacktoManageCustomer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(panelFormCustomerView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId_customer1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFormIdEmployee2))
                .addGap(18, 18, 18)
                .addGroup(panelFormCustomerView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCustomer_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmployee_name2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormCustomerView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCustomerPhoneNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRole3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormCustomerView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCustomerStatus1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRole4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(panelFormCustomerView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormCustomerView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnFormCustomerCreate1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFormCustomerUpdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFormCustomerReset1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

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
            .addGroup(panelFormCustomerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelFormCustomerViewLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelFormCustomerView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addGroup(panelFormCustomerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormCustomerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnFormCustomerCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFormCustomerUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFormCustomerReset, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
            .addGroup(panelFormCustomerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelFormCustomerViewLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelFormCustomerView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        panelView.add(panelFormCustomerView, "card13");

        panelManageProviderView.setBackground(new java.awt.Color(0, 0, 0));

        lblHeaderCustomer2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblHeaderCustomer2.setForeground(new java.awt.Color(240, 240, 240));
        lblHeaderCustomer2.setText("DATA PROVIDER");

        btnFormProviderDelete.setText("Delete");
        btnFormProviderDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFormProviderDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFormProviderDeleteMouseClicked(evt);
            }
        });
        btnFormProviderDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormProviderDeleteActionPerformed(evt);
            }
        });

        tblProvider.setBackground(new java.awt.Color(0, 0, 0));
        tblProvider.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tblProvider.setForeground(new java.awt.Color(240, 240, 240));
        tblProvider.setModel(new javax.swing.table.DefaultTableModel(
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
        spCustomer1.setViewportView(tblProvider);

        btnFormProvider.setBackground(new java.awt.Color(153, 0, 153));
        btnFormProvider.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFormProvider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFormProviderMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFormProviderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFormProviderMouseExited(evt);
            }
        });

        jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("Form");

        javax.swing.GroupLayout btnFormProviderLayout = new javax.swing.GroupLayout(btnFormProvider);
        btnFormProvider.setLayout(btnFormProviderLayout);
        btnFormProviderLayout.setHorizontalGroup(
            btnFormProviderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnFormProviderLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel58)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        btnFormProviderLayout.setVerticalGroup(
            btnFormProviderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel58, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelManageProviderViewLayout = new javax.swing.GroupLayout(panelManageProviderView);
        panelManageProviderView.setLayout(panelManageProviderViewLayout);
        panelManageProviderViewLayout.setHorizontalGroup(
            panelManageProviderViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelManageProviderViewLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panelManageProviderViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFormProvider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spCustomer1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHeaderCustomer2)
                    .addComponent(btnFormProviderDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        panelManageProviderViewLayout.setVerticalGroup(
            panelManageProviderViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelManageProviderViewLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(lblHeaderCustomer2)
                .addGap(18, 18, 18)
                .addComponent(btnFormProvider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spCustomer1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFormProviderDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        panelView.add(panelManageProviderView, "card11");

        panelFormProviderView.setBackground(new java.awt.Color(0, 0, 0));

        lblHeaderFormEmployee3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblHeaderFormEmployee3.setForeground(new java.awt.Color(240, 240, 240));
        lblHeaderFormEmployee3.setText("FORM PROVIDER");

        lblFormIdEmployee3.setForeground(new java.awt.Color(255, 255, 255));
        lblFormIdEmployee3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFormIdEmployee3.setText("ID");

        txtFormProviderId_provider.setEditable(false);

        lblEmployee_name3.setForeground(new java.awt.Color(255, 255, 255));
        lblEmployee_name3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmployee_name3.setText("Provider Name");

        btnBacktoManageProvider.setBackground(new java.awt.Color(153, 0, 153));
        btnBacktoManageProvider.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBacktoManageProvider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBacktoManageProviderMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBacktoManageProviderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBacktoManageProviderMouseExited(evt);
            }
        });

        jLabel59.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("Back");

        javax.swing.GroupLayout btnBacktoManageProviderLayout = new javax.swing.GroupLayout(btnBacktoManageProvider);
        btnBacktoManageProvider.setLayout(btnBacktoManageProviderLayout);
        btnBacktoManageProviderLayout.setHorizontalGroup(
            btnBacktoManageProviderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBacktoManageProviderLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel59)
                .addGap(29, 29, 29))
        );
        btnBacktoManageProviderLayout.setVerticalGroup(
            btnBacktoManageProviderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnBacktoManageProviderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel59)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnFormProviderCreate.setText("Create");
        btnFormProviderCreate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFormProviderCreateMouseClicked(evt);
            }
        });
        btnFormProviderCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormProviderCreateActionPerformed(evt);
            }
        });

        btnFormProviderUpdate.setText("Update");
        btnFormProviderUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFormProviderUpdateMouseClicked(evt);
            }
        });
        btnFormProviderUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormProviderUpdateActionPerformed(evt);
            }
        });

        btnFormProviderReset.setText("Reset");
        btnFormProviderReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormProviderResetActionPerformed(evt);
            }
        });

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout panelFormProviderViewLayout = new javax.swing.GroupLayout(panelFormProviderView);
        panelFormProviderView.setLayout(panelFormProviderViewLayout);
        panelFormProviderViewLayout.setHorizontalGroup(
            panelFormProviderViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormProviderViewLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panelFormProviderViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormProviderViewLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblHeaderFormEmployee3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelFormProviderViewLayout.createSequentialGroup()
                        .addGroup(panelFormProviderViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFormProviderViewLayout.createSequentialGroup()
                                .addComponent(btnBacktoManageProvider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 621, Short.MAX_VALUE))
                            .addGroup(panelFormProviderViewLayout.createSequentialGroup()
                                .addGroup(panelFormProviderViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEmployee_name3)
                                    .addGroup(panelFormProviderViewLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(lblFormIdEmployee3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(panelFormProviderViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFormProviderId_provider)
                                    .addGroup(panelFormProviderViewLayout.createSequentialGroup()
                                        .addComponent(btnFormProviderReset, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(262, 262, 262)
                                        .addComponent(btnFormProviderCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnFormProviderUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                                    .addComponent(txtFormProviderProvider_name, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(32, 32, 32))))
        );
        panelFormProviderViewLayout.setVerticalGroup(
            panelFormProviderViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormProviderViewLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblHeaderFormEmployee3)
                .addGap(18, 18, 18)
                .addComponent(btnBacktoManageProvider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addGroup(panelFormProviderViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFormProviderId_provider, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFormIdEmployee3))
                .addGap(18, 18, 18)
                .addGroup(panelFormProviderViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFormProviderProvider_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmployee_name3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addGroup(panelFormProviderViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormProviderViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnFormProviderCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFormProviderUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFormProviderReset, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        panelView.add(panelFormProviderView, "card13");

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
        setSidemenu_active(1);
        panelView.add(panelHomeView);
        panelView.repaint();
        panelView.revalidate();
    }//GEN-LAST:event_btnHomeMenuMouseClicked

    private void btnHomeMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMenuMouseEntered
        if (getSidemenu_active() != 1) {
            btnHomeMenu.setBackground(sidemenu_entered);
        }
    }//GEN-LAST:event_btnHomeMenuMouseEntered

    private void btnHomeMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMenuMouseExited
        if (getSidemenu_active() != 1) {
            btnHomeMenu.setBackground(sidemenu_exited);
        }
    }//GEN-LAST:event_btnHomeMenuMouseExited

    private void btnHomeMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMenuMousePressed
       if (getSidemenu_active() != 1) {
            btnHomeMenu.setBackground(sidemenu_pressed);
        }
    }//GEN-LAST:event_btnHomeMenuMousePressed

    private void btnHomeMenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMenuMouseReleased
        if (getSidemenu_active() != 1) {
            btnHomeMenu.setBackground(sidemenu_entered);
        }
    }//GEN-LAST:event_btnHomeMenuMouseReleased

    private void btnKartuMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKartuMenuMouseClicked
        panelView.removeAll();
        panelView.repaint();
        panelView.revalidate();
        btnKartuMenu.setBackground(sidemenu_pressed);
        setSidemenu_active(4);
        panelView.add(panelStockView);
        panelView.repaint();
        panelView.revalidate();
        
    }//GEN-LAST:event_btnKartuMenuMouseClicked

    private void btnKartuMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKartuMenuMouseEntered
        if (getSidemenu_active() != 4) {
            btnKartuMenu.setBackground(sidemenu_entered);
        }
    }//GEN-LAST:event_btnKartuMenuMouseEntered

    private void btnKartuMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKartuMenuMouseExited
        if (getSidemenu_active() != 4) {
            btnKartuMenu.setBackground(sidemenu_exited);
        }
    }//GEN-LAST:event_btnKartuMenuMouseExited

    private void btnKartuMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKartuMenuMousePressed
        if (getSidemenu_active() != 4) {
            btnKartuMenu.setBackground(sidemenu_pressed);
        }
    }//GEN-LAST:event_btnKartuMenuMousePressed

    private void btnKartuMenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKartuMenuMouseReleased
        if (getSidemenu_active() != 4) {
            btnKartuMenu.setBackground(sidemenu_entered);
        }
    }//GEN-LAST:event_btnKartuMenuMouseReleased

    private void btnPlnPdamMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlnPdamMenuMouseClicked
        panelView.removeAll();
        panelView.repaint();
        panelView.revalidate();
        btnPlnPdamMenu.setBackground(sidemenu_pressed);
        setSidemenu_active(3);
        panelView.add(panelTagihanView);
        panelView.repaint();
        panelView.revalidate();
    }//GEN-LAST:event_btnPlnPdamMenuMouseClicked

    private void btnPlnPdamMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlnPdamMenuMouseEntered
        if (getSidemenu_active() != 3) {
            btnPlnPdamMenu.setBackground(sidemenu_entered);
        } 
    }//GEN-LAST:event_btnPlnPdamMenuMouseEntered

    private void btnPlnPdamMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlnPdamMenuMouseExited
        if (getSidemenu_active() != 3) {
            btnPlnPdamMenu.setBackground(sidemenu_exited);
        }
    }//GEN-LAST:event_btnPlnPdamMenuMouseExited

    private void btnPlnPdamMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlnPdamMenuMousePressed
        if (getSidemenu_active() != 3) {
            btnPlnPdamMenu.setBackground(sidemenu_pressed);
        }
    }//GEN-LAST:event_btnPlnPdamMenuMousePressed

    private void btnPlnPdamMenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlnPdamMenuMouseReleased
        if (getSidemenu_active() != 3) {
            btnPlnPdamMenu.setBackground(sidemenu_entered);
        }
    }//GEN-LAST:event_btnPlnPdamMenuMouseReleased

    private void btnPulsaMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPulsaMenuMouseClicked
        panelView.removeAll();
        panelView.repaint();
        panelView.revalidate();
        btnPulsaMenu.setBackground(sidemenu_pressed);
        setSidemenu_active(2);
        panelView.add(panelPulsaView);
        panelView.repaint();
        panelView.revalidate();
    }//GEN-LAST:event_btnPulsaMenuMouseClicked

    private void btnPulsaMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPulsaMenuMouseEntered
        if (getSidemenu_active() != 2) {
            btnPulsaMenu.setBackground(sidemenu_entered);
        }
    }//GEN-LAST:event_btnPulsaMenuMouseEntered

    private void btnPulsaMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPulsaMenuMouseExited
        if (getSidemenu_active() != 2) {
            btnPulsaMenu.setBackground(sidemenu_exited);
        }
    }//GEN-LAST:event_btnPulsaMenuMouseExited

    private void btnPulsaMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPulsaMenuMousePressed
        if (getSidemenu_active() != 2) {
            btnPulsaMenu.setBackground(sidemenu_pressed);
        }
    }//GEN-LAST:event_btnPulsaMenuMousePressed

    private void btnPulsaMenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPulsaMenuMouseReleased
        if (getSidemenu_active() != 2) {
            btnPulsaMenu.setBackground(sidemenu_entered);
        }
    }//GEN-LAST:event_btnPulsaMenuMouseReleased

    private void btnPendapatanMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPendapatanMenuMouseClicked
        panelView.removeAll();
        panelView.repaint();
        panelView.revalidate();
        btnPendapatanMenu.setBackground(sidemenu_pressed);
        setSidemenu_active(5);
        panelView.add(panelPendapatanView);
        panelView.repaint();
        panelView.revalidate();
    }//GEN-LAST:event_btnPendapatanMenuMouseClicked

    private void btnPendapatanMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPendapatanMenuMouseEntered
        if (getSidemenu_active() != 5) {
            btnPendapatanMenu.setBackground(sidemenu_entered);
        }
    }//GEN-LAST:event_btnPendapatanMenuMouseEntered

    private void btnPendapatanMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPendapatanMenuMouseExited
        if (getSidemenu_active() != 5) {
            btnPendapatanMenu.setBackground(sidemenu_exited);
        }
    }//GEN-LAST:event_btnPendapatanMenuMouseExited

    private void btnPendapatanMenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPendapatanMenuMouseReleased
        if (getSidemenu_active() != 5) {
            btnPendapatanMenu.setBackground(sidemenu_entered);
        }
    }//GEN-LAST:event_btnPendapatanMenuMouseReleased

    private void btnPendapatanMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPendapatanMenuMousePressed
        if (getSidemenu_active() != 5) {
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
        panelView.add(panelReStockKuotaView);
        panelView.repaint();
        panelView.revalidate();
    }//GEN-LAST:event_btnSubmitReStockPerdanaActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        panelView.removeAll();
        panelView.repaint();
        panelView.revalidate();
        
        //add panel
        panelView.add(panelReStockKuotaView);
        panelView.repaint();
        panelView.revalidate();
    }//GEN-LAST:event_jButton9ActionPerformed

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
        setSidemenu_active(6);
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

    private void btnReStockKuotaPulsaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReStockKuotaPulsaActionPerformed
        // TODO add your handling code here:
        panelView.removeAll();
        panelView.repaint();
        panelView.revalidate();
        
        //add panel
        panelView.add(paneFormReStockKuota);
        panelView.repaint();
        panelView.revalidate();
    }//GEN-LAST:event_btnReStockKuotaPulsaActionPerformed

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

    private void txtRestockProviderNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRestockProviderNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRestockProviderNameActionPerformed

    public JTable getTblRestockPulsa() {
        return tblRestockPulsa;
    }

    public void setTblRestockPulsa(JTable tblRestockPulsa) {
        this.tblRestockPulsa = tblRestockPulsa;
    }

    public JTextField getTxtRestockBalance_current() {
        return txtRestockBalance_current;
    }

    public void setTxtRestockBalance_current(JTextField txtRestockBalance_current) {
        this.txtRestockBalance_current = txtRestockBalance_current;
    }

    public JTextField getTxtRestockProviderName() {
        return txtRestockProviderName;
    }

    public void setTxtRestockProviderName(JTextField txtRestockProviderName) {
        this.txtRestockProviderName = txtRestockProviderName;
    }

    public JTextField getTxtRestockType() {
        return txtRestockType;
    }

    public void setTxtRestockType(JTextField txtRestockType) {
        this.txtRestockType = txtRestockType;
    }
    
    private void btnRestockKuotaSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRestockKuotaSaveMouseClicked
        // TODO add your handling code here:
        creditRestockController.updateCreditRestock(this);
    }//GEN-LAST:event_btnRestockKuotaSaveMouseClicked

    private void btnFormCustomer1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormCustomer1MouseClicked
        // TODO add your handling code here:
        panelView.removeAll();
        panelView.repaint();
        panelView.revalidate();
        
        //add panel
        panelView.add(panelFormTagihanView);
        panelView.repaint();
        panelView.revalidate();
    }//GEN-LAST:event_btnFormCustomer1MouseClicked

    private void btnFormCustomer1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormCustomer1MouseEntered
        // TODO add your handling code here:
        btnFormCustomer1.setBackground(sidemenu_entered);
    }//GEN-LAST:event_btnFormCustomer1MouseEntered

    private void btnFormCustomer1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormCustomer1MouseExited
        // TODO add your handling code here:
        btnFormCustomer1.setBackground(sidemenu_exited);
    }//GEN-LAST:event_btnFormCustomer1MouseExited

    private void btnBacktoManageCustomer1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBacktoManageCustomer1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBacktoManageCustomer1MouseClicked

    private void btnBacktoManageCustomer1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBacktoManageCustomer1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBacktoManageCustomer1MouseEntered

    private void btnBacktoManageCustomer1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBacktoManageCustomer1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBacktoManageCustomer1MouseExited

    private void btnFormCustomerCreate1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormCustomerCreate1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFormCustomerCreate1MouseClicked

    private void btnFormCustomerCreate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormCustomerCreate1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFormCustomerCreate1ActionPerformed

    private void btnFormCustomerUpdate1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormCustomerUpdate1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFormCustomerUpdate1MouseClicked

    private void btnFormCustomerUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormCustomerUpdate1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFormCustomerUpdate1ActionPerformed

    private void btnFormCustomerReset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormCustomerReset1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFormCustomerReset1ActionPerformed

    private void btnFormCustomerBillKembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormCustomerBillKembaliMouseClicked
        // TODO add your handling code here:
        panelView.removeAll();
        panelView.repaint();
        panelView.revalidate();
        
        //add panel
        panelView.add(panelTagihanView);
        panelView.repaint();
        panelView.revalidate();
    }//GEN-LAST:event_btnFormCustomerBillKembaliMouseClicked

    private void btnFormCustomerBillKembaliMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormCustomerBillKembaliMouseEntered
        // TODO add your handling code here:
        btnFormCustomerBillKembali.setBackground(sidemenu_entered);
    }//GEN-LAST:event_btnFormCustomerBillKembaliMouseEntered

    private void btnFormCustomerBillKembaliMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormCustomerBillKembaliMouseExited
        // TODO add your handling code here:
        btnFormCustomerBillKembali.setBackground(sidemenu_exited);
    }//GEN-LAST:event_btnFormCustomerBillKembaliMouseExited

    private void btnFormCustomerBillCreateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormCustomerBillCreateMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnFormCustomerBillCreateMouseClicked

    public JTable getTblCustomerBill() {
        return tblCustomerBill;
    }

    public JTextField getTxtFormCustomerBillBalance() {
        return txtFormCustomerBillBalance;
    }

    public JTextField getTxtFormCustomerBillCustomer_name() {
        return txtFormCustomerBillCustomer_name;
    }

    public JTextField getTxtFormCustomerBillCustomer_number() {
        return txtFormCustomerBillCustomer_number;
    }

    public JTextField getTxtFormCustomerBillId_customer_bill() {
        return txtFormCustomerBillId_customer_bill;
    }
    
    public JTextField getTxtFormCustomerBillType() {
        return txtFormCustomerBillType;
    }
    
    private void btnFormCustomerBillCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormCustomerBillCreateActionPerformed
        // TODO add your handling code here:
        customerBillController.insertCustomerBill(this);
    }//GEN-LAST:event_btnFormCustomerBillCreateActionPerformed

    private void btnFormCustomerBillUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormCustomerBillUpdateActionPerformed
        // TODO add your handling code here:
        customerBillController.updateCustomerBill(this);
    }//GEN-LAST:event_btnFormCustomerBillUpdateActionPerformed

    private void btnDeleteTagihanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteTagihanActionPerformed
        // TODO add your handling code here:
        customerBillController.deleteCustomerBill(this);
    }//GEN-LAST:event_btnDeleteTagihanActionPerformed

    private void cbJenisPembayaranPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbJenisPembayaranPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        String cboxJenisPembayaran = (String)cbJenisPembayaran.getSelectedItem();
        String cboxJenisPembayaranValue = cbJenisPembayaran.getSelectedItem().toString();
        if (cboxJenisPembayaranValue.equals("PLN")) {
            txtFormCustomerBillType.setText("PLN");
        } else if (cboxJenisPembayaranValue.equals("PDAM")) {
            txtFormCustomerBillType.setText("PDAM");
        } else {
            txtIsiPulsaHome.setText("");
        }
    }//GEN-LAST:event_cbJenisPembayaranPopupMenuWillBecomeInvisible

    private void btnFormCustomerBillResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormCustomerBillResetActionPerformed
        // TODO add your handling code here:
        customerBillController.resetCustomerBill(this);
    }//GEN-LAST:event_btnFormCustomerBillResetActionPerformed

    private void btnRestockKuotaSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestockKuotaSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRestockKuotaSaveActionPerformed

    private void btnPendapatanSaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPendapatanSaveMouseEntered
        // TODO add your handling code here:
        btnPendapatanSave.setBackground(sidemenu_entered);
    }//GEN-LAST:event_btnPendapatanSaveMouseEntered

    private void btnPendapatanSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPendapatanSaveMouseExited
        // TODO add your handling code here:
        btnPendapatanSave.setBackground(sidemenu_exited);
    }//GEN-LAST:event_btnPendapatanSaveMouseExited

    public JTable getTblPendapatan() {
        return tblPendapatan;
    }
    
    public JTextField getTxtPendapatanId_income() {
        return txtPendapatanId_income;
    }
    
    public JTextField getTxtPendapatanCreditKuota() {
        return txtPendapatanCreditKuota;
    }

    public JTextField getTxtPendapatanCreditPerdana() {
        return txtPendapatanCreditPerdana;
    }

    public JTextField getTxtPendapatanOutcome() {
        return txtPendapatanOutcome;
    }

    public JTextField getTxtPendapatanPDAM() {
        return txtPendapatanPDAM;
    }

    public JTextField getTxtPendapatanPLN() {
        return txtPendapatanPLN;
    }

    public JTextField getTxtPendapatanCredit() {
        return txtPendapatanCredit;
    }
    
    public JTextField getTxtPendapatanTotal() {
        return txtPendapatanTotal;
    }
    
    private void btnPendapatanSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPendapatanSaveMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPendapatanSaveMouseClicked

    private void btnFormPendapatanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormPendapatanMouseClicked
        // TODO add your handling code here:
        panelView.removeAll();
        panelView.repaint();
        panelView.revalidate();
        
        //add panel
        panelView.add(panelFormPendapatanView);
        panelView.repaint();
        panelView.revalidate();
    }//GEN-LAST:event_btnFormPendapatanMouseClicked

    private void btnFormPendapatanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormPendapatanMouseEntered
        // TODO add your handling code here:
        btnFormPendapatan.setBackground(sidemenu_entered);
    }//GEN-LAST:event_btnFormPendapatanMouseEntered

    private void btnFormPendapatanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormPendapatanMouseExited
        // TODO add your handling code here:
        btnFormPendapatan.setBackground(sidemenu_exited);
    }//GEN-LAST:event_btnFormPendapatanMouseExited

    private void btnFormProviderDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormProviderDeleteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFormProviderDeleteMouseClicked

    private void btnFormProviderDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormProviderDeleteActionPerformed
        // TODO add your handling code here:
        providerController.deleteProvider(this);
    }//GEN-LAST:event_btnFormProviderDeleteActionPerformed

    private void btnFormProviderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormProviderMouseClicked
        // TODO add your handling code here:
        panelView.removeAll();
        panelView.repaint();
        panelView.revalidate();
        
        //add panel
        panelView.add(panelFormProviderView);
        panelView.repaint();
        panelView.revalidate();
    }//GEN-LAST:event_btnFormProviderMouseClicked

    private void btnFormProviderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormProviderMouseEntered
        // TODO add your handling code here:
        btnFormProvider.setBackground(sidemenu_entered);
    }//GEN-LAST:event_btnFormProviderMouseEntered

    private void btnFormProviderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormProviderMouseExited
        // TODO add your handling code here:
        btnFormProvider.setBackground(sidemenu_exited);
    }//GEN-LAST:event_btnFormProviderMouseExited

    private void btnBacktoManageProviderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBacktoManageProviderMouseClicked
        // TODO add your handling code here:
        panelView.removeAll();
        panelView.repaint();
        panelView.revalidate();
        
        //add panel
        panelView.add(panelManageProviderView);
        panelView.repaint();
        panelView.revalidate();
    }//GEN-LAST:event_btnBacktoManageProviderMouseClicked

    private void btnBacktoManageProviderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBacktoManageProviderMouseEntered
        // TODO add your handling code here:
        btnBacktoManageProvider.setBackground(sidemenu_entered);
    }//GEN-LAST:event_btnBacktoManageProviderMouseEntered

    private void btnBacktoManageProviderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBacktoManageProviderMouseExited
        // TODO add your handling code here:
        btnBacktoManageProvider.setBackground(sidemenu_exited);
    }//GEN-LAST:event_btnBacktoManageProviderMouseExited

    private void btnFormProviderCreateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormProviderCreateMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnFormProviderCreateMouseClicked

    public JTable getTblProvider() {
        return tblProvider;
    }

    public JTextField getTxtFormProviderId_provider() {
        return txtFormProviderId_provider;
    }
    
    public JTextField getTxtFormProviderProvider_name() {
        return txtFormProviderProvider_name;
    }
    
    private void btnFormProviderCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormProviderCreateActionPerformed
        // TODO add your handling code here:
        providerController.insertProvider(this);
    }//GEN-LAST:event_btnFormProviderCreateActionPerformed

    private void btnFormProviderUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormProviderUpdateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFormProviderUpdateMouseClicked

    private void btnFormProviderUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormProviderUpdateActionPerformed
        // TODO add your handling code here:
        providerController.updateProvider(this);
    }//GEN-LAST:event_btnFormProviderUpdateActionPerformed

    private void btnFormProviderResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormProviderResetActionPerformed
        // TODO add your handling code here:
        providerController.resetProvider(this);
    }//GEN-LAST:event_btnFormProviderResetActionPerformed

    private void btnProviderViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProviderViewMouseClicked
        // TODO add your handling code here:
        panelView.removeAll();
        panelView.repaint();
        panelView.revalidate();
        
        //add panel
        panelView.add(panelManageProviderView);
        panelView.repaint();
        panelView.revalidate();
    }//GEN-LAST:event_btnProviderViewMouseClicked

    private void btnProviderViewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProviderViewMouseEntered
        // TODO add your handling code here:
        btnProviderView.setBackground(sidemenu_entered);
    }//GEN-LAST:event_btnProviderViewMouseEntered

    private void btnProviderViewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProviderViewMouseExited
        // TODO add your handling code here:
        btnProviderView.setBackground(sidemenu_exited);
    }//GEN-LAST:event_btnProviderViewMouseExited

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
    private javax.swing.JPanel btnBacktoManageCustomer1;
    private javax.swing.JPanel btnBacktoManageEmployee;
    private javax.swing.JPanel btnBacktoManageProvider;
    private javax.swing.JPanel btnCustomerView;
    private javax.swing.JButton btnDeleteTagihan;
    private javax.swing.JPanel btnEmployeeView;
    private javax.swing.JPanel btnFormCustomer;
    private javax.swing.JPanel btnFormCustomer1;
    private javax.swing.JButton btnFormCustomerBillCreate;
    private javax.swing.JPanel btnFormCustomerBillKembali;
    private javax.swing.JButton btnFormCustomerBillReset;
    private javax.swing.JButton btnFormCustomerBillUpdate;
    private javax.swing.JButton btnFormCustomerCreate;
    private javax.swing.JButton btnFormCustomerCreate1;
    private javax.swing.JButton btnFormCustomerDelete;
    private javax.swing.JButton btnFormCustomerReset;
    private javax.swing.JButton btnFormCustomerReset1;
    private javax.swing.JButton btnFormCustomerUpdate;
    private javax.swing.JButton btnFormCustomerUpdate1;
    private javax.swing.JPanel btnFormEmployee;
    private javax.swing.JButton btnFormEmployeeCreate;
    private javax.swing.JButton btnFormEmployeeDelete;
    private javax.swing.JButton btnFormEmployeeReset;
    private javax.swing.JButton btnFormEmployeeUpdate;
    private javax.swing.JPanel btnFormPendapatan;
    private javax.swing.JPanel btnFormProvider;
    private javax.swing.JButton btnFormProviderCreate;
    private javax.swing.JButton btnFormProviderDelete;
    private javax.swing.JButton btnFormProviderReset;
    private javax.swing.JButton btnFormProviderUpdate;
    private javax.swing.JButton btnFormSubmitPulsaHome;
    private javax.swing.JPanel btnHomeMenu;
    private javax.swing.JPanel btnKartuMenu;
    private javax.swing.JPanel btnLogoutMenu;
    private javax.swing.JPanel btnManageMenu;
    private javax.swing.JPanel btnPendapatanMenu;
    private javax.swing.JPanel btnPendapatanSave;
    private javax.swing.JPanel btnPlnPdamMenu;
    private javax.swing.JPanel btnProviderView;
    private javax.swing.JPanel btnPulsaMenu;
    private javax.swing.JButton btnReStockKuotaPulsa;
    private javax.swing.JButton btnRestockKuotaSave;
    private javax.swing.JButton btnSaveReStockKuota;
    private javax.swing.JButton btnSaveReStockPerdana;
    private javax.swing.JButton btnSubmitReStockKuota;
    private javax.swing.JButton btnSubmitReStockPerdana;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbBesarPulsa;
    private javax.swing.JComboBox cbBesarPulsaHome;
    private javax.swing.JComboBox cbFilterJenisStock;
    private javax.swing.JComboBox cbFilterProviderStock;
    private javax.swing.JComboBox<String> cbJenisPembayaran;
    private javax.swing.JComboBox cbJenisTagihan;
    private javax.swing.JComboBox cbProviderPulsa;
    private javax.swing.JComboBox cbProviderPulsaHome;
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
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
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
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lblAppName;
    private javax.swing.JLabel lblBalancePembayaran;
    private javax.swing.JLabel lblEmployee_name;
    private javax.swing.JLabel lblEmployee_name1;
    private javax.swing.JLabel lblEmployee_name2;
    private javax.swing.JLabel lblEmployee_name3;
    private javax.swing.JLabel lblFormIdEmployee;
    private javax.swing.JLabel lblFormIdEmployee1;
    private javax.swing.JLabel lblFormIdEmployee2;
    private javax.swing.JLabel lblFormIdEmployee3;
    private javax.swing.JLabel lblFormPassword;
    private javax.swing.JLabel lblFormUsername;
    private javax.swing.JLabel lblHeaderCustomer;
    private javax.swing.JLabel lblHeaderCustomer1;
    private javax.swing.JLabel lblHeaderCustomer2;
    private javax.swing.JLabel lblHeaderEmployee;
    private javax.swing.JLabel lblHeaderFormEmployee;
    private javax.swing.JLabel lblHeaderFormEmployee1;
    private javax.swing.JLabel lblHeaderFormEmployee2;
    private javax.swing.JLabel lblHeaderFormEmployee3;
    private javax.swing.JLabel lblHeaderFormTagihan;
    private javax.swing.JLabel lblHeaderName;
    private javax.swing.JLabel lblIdPelangganTagihan;
    private javax.swing.JLabel lblJenis;
    private javax.swing.JLabel lblNamaPelangganTagihan;
    private javax.swing.JLabel lblNoPelangganTagihan;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblRole1;
    private javax.swing.JLabel lblRole2;
    private javax.swing.JLabel lblRole3;
    private javax.swing.JLabel lblRole4;
    private javax.swing.JPanel paneFormReStockKuota;
    private javax.swing.JPanel panelFormCustomerView;
    private javax.swing.JPanel panelFormCustomerView1;
    private javax.swing.JPanel panelFormEmployeeView;
    private javax.swing.JPanel panelFormPendapatanView;
    private javax.swing.JPanel panelFormProviderView;
    private javax.swing.JPanel panelFormTagihanView;
    private javax.swing.JPanel panelHomeView;
    private javax.swing.JPanel panelManageCustomerView;
    private javax.swing.JPanel panelManageEmployeeView;
    private javax.swing.JPanel panelManageProviderView;
    private javax.swing.JPanel panelManageView;
    private javax.swing.JPanel panelPendapatanView;
    private javax.swing.JPanel panelPulsaView;
    private javax.swing.JPanel panelReStockKuotaView;
    private javax.swing.JPanel panelReStockPerdanaView;
    private javax.swing.JPanel panelStockView;
    private javax.swing.JPanel panelTagihanView;
    private javax.swing.JPanel panelView;
    private javax.swing.JSeparator seperatorMenu;
    private javax.swing.JPanel sidePane;
    private javax.swing.JScrollPane spCustomer;
    private javax.swing.JScrollPane spCustomer1;
    private javax.swing.JScrollPane spEmployee;
    private javax.swing.JTable tblCustomer;
    private javax.swing.JTable tblCustomerBill;
    private javax.swing.JTable tblCustomerCredit;
    private javax.swing.JTable tblEmployee;
    private javax.swing.JTable tblPendapatan;
    private javax.swing.JTable tblProvider;
    private javax.swing.JTable tblReStockPerdana;
    private javax.swing.JTable tblRestockKuotaView;
    private javax.swing.JTable tblRestockPulsa;
    private javax.swing.JTable tblStock;
    private javax.swing.JTextField txtCustomerPhoneNumber;
    private javax.swing.JTextField txtCustomerPhoneNumber1;
    private javax.swing.JTextField txtCustomerStatus;
    private javax.swing.JTextField txtCustomerStatus1;
    private javax.swing.JTextField txtCustomer_name;
    private javax.swing.JTextField txtCustomer_name1;
    private javax.swing.JTextField txtEmployee_name;
    private javax.swing.JTextField txtFormCustomerBillBalance;
    private javax.swing.JTextField txtFormCustomerBillCustomer_name;
    private javax.swing.JTextField txtFormCustomerBillCustomer_number;
    private javax.swing.JTextField txtFormCustomerBillId_customer_bill;
    private javax.swing.JTextField txtFormCustomerBillType;
    private javax.swing.JTextField txtFormNomorPulsaHome;
    private javax.swing.JTextField txtFormProviderId_provider;
    private javax.swing.JTextField txtFormProviderProvider_name;
    private javax.swing.JTextField txtId_Employee;
    private javax.swing.JTextField txtId_customer;
    private javax.swing.JTextField txtId_customer1;
    private javax.swing.JTextField txtIsiPulsaHome;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPendapatanCredit;
    private javax.swing.JTextField txtPendapatanCreditKuota;
    private javax.swing.JTextField txtPendapatanCreditPerdana;
    private javax.swing.JTextField txtPendapatanId_income;
    private javax.swing.JTextField txtPendapatanOutcome;
    private javax.swing.JTextField txtPendapatanPDAM;
    private javax.swing.JTextField txtPendapatanPLN;
    private javax.swing.JTextField txtPendapatanTotal;
    private javax.swing.JTextField txtRestockBalance_current;
    private javax.swing.JTextField txtRestockProviderName;
    private javax.swing.JTextField txtRestockType;
    private javax.swing.JTextField txtRole;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    public void loadDatabase() throws SQLException, EmployeeException, CustomerException, CustomerCreditException, CustomerBillException, CreditRestockException, IncomeException, ProviderException {
        EmployeeDao employeedao = CreamsDatabase.getEmployeeDao();
        CustomerDao customerdao = CreamsDatabase.getCustomerDao();
        CustomerCreditDao customercreditdao = CreamsDatabase.getCustomerCreditDao();
        CreditRestockDao creditrestockdao = CreamsDatabase.getCreditRestockDao();
        CustomerBillDao customerbilldao = CreamsDatabase.getCustomerBillDao();
        IncomeDao incomedao = CreamsDatabase.getIncomeDao();
        ProviderDao providerdao = CreamsDatabase.getProviderDao();
        
        employeeTableModel.setList(employeedao.selectAllEmployee());
        customerTableModel.setList(customerdao.selectAllCustomer());
        customerCreditTableModel.setList(customercreditdao.selectAllCustomerCredit());
        creditRestockTableModel.setList(creditrestockdao.selectAllCreditRestock());
        creditRestockKuotaTableModel.setList(creditrestockdao.selectAllKuota());
        creditRestockPerdanaTableModel.setList(creditrestockdao.selectAllPerdana());
        customerBillTableModel.setList(customerbilldao.selectAllCustomerBill());
        incomeTableModel.setList(incomedao.selectAllIncome());
        providerTableModel.setList(providerdao.selectAllIProvider());
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
            CreditRestock cre = creditRestockTableModel.get(tblRestockPulsa.getSelectedRow());
            txtRestockProviderName.setText(cre.getProvider_name());
            txtRestockBalance_current.setText(cre.getBalance_current() + "");
            txtRestockType.setText(cre.getType());
        } catch (IndexOutOfBoundsException exception) {
        }
        
        try {
            CustomerBill cusbill = customerBillTableModel.get(tblCustomerBill.getSelectedRow());
            txtFormCustomerBillId_customer_bill.setText(cusbill.getId_customer_bill()+ "");
            txtFormCustomerBillCustomer_number.setText(cusbill.getCustomer_number()+ "");
            txtFormCustomerBillCustomer_name.setText(cusbill.getCustomer_name());
            txtFormCustomerBillType.setText(cusbill.getType());
            txtFormCustomerBillBalance.setText(cusbill.getBalance()+"");
            
        } catch (IndexOutOfBoundsException exception) {
        }
        
        try {
            Income inc = incomeTableModel.get(tblPendapatan.getSelectedRow());
            txtPendapatanId_income.setText(inc.getId_income()+ "");
            txtPendapatanCredit.setText(inc.getCredit()+ "");
            txtPendapatanCreditPerdana.setText(inc.getCredit_perdana()+ "");
            txtPendapatanCreditKuota.setText(inc.getCredit_kuota()+ "");
            txtPendapatanPLN.setText(inc.getPln()+"");
            txtPendapatanPDAM.setText(inc.getPdam()+"");
            txtPendapatanOutcome.setText(inc.getOutcome()+"");
            txtPendapatanTotal.setText(inc.getTotal()+"");
            
        } catch (IndexOutOfBoundsException exception) {
        }
        
        try {
            Provider pro = providerTableModel.get(tblProvider.getSelectedRow());
            txtFormProviderId_provider.setText(pro.getId_provider()+ "");
            txtFormProviderProvider_name.setText(pro.getProvider_name()+ "");
            
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
    public void onChange(CreditRestockModel model) {
        txtRestockProviderName.setText(model.getProvider_name());
        txtFormNomorPulsaHome.setText(model.getBalance_current()+ "");
    }

    @Override
    public void onUpdate(CreditRestock creditRestock) {
        int index = tblRestockPulsa.getSelectedRow();
        creditRestockTableModel.set(index, creditRestock);
    }

    @Override
    public void onChange(CustomerBillModel model) {
        txtFormCustomerBillId_customer_bill.setText(model.getId_customer_bill()+ "");
        txtFormCustomerBillCustomer_number.setText(model.getCustomer_number());
        txtFormCustomerBillCustomer_name.setText(model.getCustomer_name());
        txtFormCustomerBillType.setText(model.getType());
        txtFormCustomerBillBalance.setText(model.getBalance()+"");
    }

    @Override
    public void onInsert(CustomerBill customerBill) {
        customerBillTableModel.add(customerBill);
    }

    @Override
    public void onUpdate(CustomerBill customerBill) {
        int index = tblCustomerBill.getSelectedRow();
        customerBillTableModel.set(index, customerBill);
    }

    @Override
    public void onDelete(CustomerBill customerBill) {
        int index = tblCustomerBill.getSelectedRow();
        customerBillTableModel.remove(index);
    }

    @Override
    public void onChange(IncomeModel model) {
        txtPendapatanId_income.setText(model.getId_income()+ "");
        txtPendapatanCredit.setText(model.getCredit()+ "");
        txtPendapatanCreditPerdana.setText(model.getCredit_perdana()+ "");
        txtPendapatanCreditKuota.setText(model.getCredit_kuota()+ "");
        txtPendapatanPLN.setText(model.getPln()+"");
        txtPendapatanPDAM.setText(model.getPdam()+"");
        txtPendapatanOutcome.setText(model.getOutcome()+"");
        txtPendapatanTotal.setText(model.getTotal()+"");
    }

    @Override
    public void onInsert(Income income) {
        incomeTableModel.add(income);
    }

    @Override
    public void onUpdate(Income income) {
        int index = tblPendapatan.getSelectedRow();
        incomeTableModel.set(index, income);
    }

    @Override
    public void onDelete(Income income) {
        int index = tblPendapatan.getSelectedRow();
        incomeTableModel.remove(index);
    }

    @Override
    public void onChange(ProviderModel model) {
        txtFormProviderId_provider.setText(model.getId_provider()+ "");
        txtFormProviderProvider_name.setText(model.getProvider_name());
    }

    @Override
    public void onInsert(Provider provider) {
        providerTableModel.add(provider);
    }

    @Override
    public void onUpdate(Provider provider) {
        int index = tblProvider.getSelectedRow();
        providerTableModel.set(index, provider);
    }

    @Override
    public void onDelete(Provider provider) {
        int index = tblProvider.getSelectedRow();
        providerTableModel.remove(index);
    }
}
