package AppGraphic;

import Enum.Etat;
import Enum.Type_sem;
import static Enum.Type_sem.AM;
import Tables.Conferenciers;
import Tables.*;
import com.sun.org.apache.bcel.internal.generic.*;
import java.awt.print.PrinterException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;
import sun.security.timestamp.TSRequest;

public class GestionSeminaire extends javax.swing.JFrame {

    DefaultTableModel dt;
    private int indice;
    private int idSeminaire;

    public GestionSeminaire() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jMenuItem9 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSeminaire = new javax.swing.JTable();
        btnPremier = new javax.swing.JButton();
        btnPrecedent = new javax.swing.JButton();
        btnSuivant = new javax.swing.JButton();
        btnSeminaireAConfirme = new javax.swing.JButton();
        btnAjouter = new javax.swing.JButton();
        btnModifier = new javax.swing.JButton();
        btnSupprimer = new javax.swing.JButton();
        btnRechercher = new javax.swing.JButton();
        btnAfficher = new javax.swing.JButton();
        txtRechercher = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTheme = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTarif = new javax.swing.JTextField();
        jComboBoxIDAnim = new javax.swing.JComboBox<>();
        jComboBoxType = new javax.swing.JComboBox<>();
        jComboBoxEtat = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jRadioButtonNon = new javax.swing.JRadioButton();
        jRadioButtonOui = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        txtdate = new javax.swing.JTextField();
        txtnbmax = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxIDPrest = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxIDSalle = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 2), new java.awt.Dimension(0, 2), new java.awt.Dimension(32767, 2));
        jButton1 = new javax.swing.JButton();
        btnConfirme = new javax.swing.JButton();
        btnAnnuler = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabelReservation = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabelRecette = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabelDepese = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        labelmaxrp = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        labelmaxdp = new javax.swing.JLabel();
        labelmindp = new javax.swing.JLabel();
        labelminrp = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenuItem9.setText("jMenuItem9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Projet BD - Gestion Séminaire");
        setBackground(new java.awt.Color(50, 69, 153));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTableSeminaire.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableSeminaire.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSeminaireMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableSeminaire);

        btnPremier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/v1s.png"))); // NOI18N
        btnPremier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPremierActionPerformed(evt);
            }
        });

        btnPrecedent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/v1m.png"))); // NOI18N
        btnPrecedent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrecedentActionPerformed(evt);
            }
        });

        btnSuivant.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/aAnnuler.png"))); // NOI18N
        btnSuivant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuivantActionPerformed(evt);
            }
        });

        btnSeminaireAConfirme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/aConf.png"))); // NOI18N
        btnSeminaireAConfirme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeminaireAConfirmeActionPerformed(evt);
            }
        });

        btnAjouter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ajoute.png"))); // NOI18N
        btnAjouter.setText("Ajouter");
        btnAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterActionPerformed(evt);
            }
        });

        btnModifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/modifi.png"))); // NOI18N
        btnModifier.setText("Modifier");
        btnModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierActionPerformed(evt);
            }
        });

        btnSupprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/supprim.png"))); // NOI18N
        btnSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerActionPerformed(evt);
            }
        });

        btnRechercher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/recherch.png"))); // NOI18N
        btnRechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechercherActionPerformed(evt);
            }
        });

        btnAfficher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/afficher.png"))); // NOI18N
        btnAfficher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAfficherActionPerformed(evt);
            }
        });

        jLabel6.setText("Rechercher par ID :");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Les informations :"));

        jLabel1.setText("Id Animateur :");

        jLabel2.setText("Theme :");

        jLabel3.setText("Type :");

        jLabel4.setText("Déjeuner :");

        jLabel5.setText("Date :");

        txtTarif.setToolTipText("");

        jLabel7.setText("Etat :");

        buttonGroup1.add(jRadioButtonNon);
        jRadioButtonNon.setSelected(true);
        jRadioButtonNon.setText("non");

        buttonGroup1.add(jRadioButtonOui);
        jRadioButtonOui.setText("oui");

        jLabel8.setText("Tarif");

        txtdate.setText("Exemple : 15-12-2018");
        txtdate.setToolTipText("");

        txtnbmax.setToolTipText("");
        txtnbmax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnbmaxActionPerformed(evt);
            }
        });

        jLabel9.setText("Nbmax Participants");

        jComboBoxIDPrest.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxIDPrestItemStateChanged(evt);
            }
        });
        jComboBoxIDPrest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxIDPrestActionPerformed(evt);
            }
        });

        jLabel10.setText("Id Prestataire :");

        jLabel11.setText("Id Salle :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(68, 68, 68)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jRadioButtonOui)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonNon)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxIDAnim, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtdate, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBoxEtat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxIDSalle, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(80, 80, 80)
                        .addComponent(txtTheme))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(45, 45, 45)
                        .addComponent(jComboBoxIDPrest, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 112, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTarif)
                            .addComponent(txtnbmax))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jComboBoxIDPrest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxIDSalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxIDAnim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTheme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jRadioButtonOui)
                    .addComponent(jRadioButtonNon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTarif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtnbmax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBoxEtat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Devices-Print-icon.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnConfirme.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        btnConfirme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/conf.png"))); // NOI18N
        btnConfirme.setEnabled(false);
        btnConfirme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmeActionPerformed(evt);
            }
        });

        btnAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/x.png"))); // NOI18N
        btnAnnuler.setEnabled(false);
        btnAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnnulerActionPerformed(evt);
            }
        });

        jLabelReservation.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelReservation.setText("00");

        jLabel12.setText("Nombre de réservation  =");

        jLabel13.setText("Recettes réalisées         =");

        jLabelRecette.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelRecette.setText("00");

        jLabel14.setText("Dépenses réalisées        =");

        jLabelDepese.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelDepese.setText("00");

        jLabel15.setText("Max Recettes prévues  =");

        jLabel16.setText("Min Recettes  prévues  =");

        labelmaxrp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelmaxrp.setText("00");

        jLabel17.setText("Max Dépenses prévues  =");

        jLabel18.setText("Min Dépenses prévues  =");

        labelmaxdp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelmaxdp.setText("00");

        labelmindp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelmindp.setText("00");

        labelminrp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelminrp.setText("00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelReservation)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDepese)
                            .addComponent(jLabelRecette))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelmaxrp)
                            .addComponent(labelminrp))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelmaxdp)
                            .addComponent(labelmindp))))
                .addGap(22, 22, 22))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(labelmindp)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabelReservation))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelmaxrp)
                                    .addComponent(jLabel17)
                                    .addComponent(labelmaxdp)))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(jLabelRecette)))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabelDepese)
                            .addComponent(jLabel16)
                            .addComponent(labelminrp))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 21, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConfirme, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addGap(79, 79, 79)
                                    .addComponent(txtRechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnRechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnAfficher, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(94, 94, 94)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPremier, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPrecedent, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(btnSuivant, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btnSeminaireAConfirme, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(btnAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnConfirme, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnPremier, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSuivant, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnPrecedent, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSeminaireAConfirme, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(filler1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnAfficher, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(btnRechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtRechercher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jMenu4.setText("File");

        jMenuItem6.setText("Gestion Séminaire");
        jMenuItem6.setEnabled(false);
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuItem4.setText("Gestion Activités");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuItem5.setText("Gestion Conférencier");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuItem12.setText("Gestion Presentation");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem12);

        jMenuItem7.setText("Gestion Prestataire");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuItem8.setText("Gestion Salles");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuItem3.setText("Gestion Participant");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuItem11.setText("Gestion Réservations");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem11);

        jMenuItem10.setText("Gestion Animateur");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem10);
        jMenu4.add(jSeparator1);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Quitter");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuBar2.add(jMenu4);

        jMenu5.setText("A propos");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("A propos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem2);

        jMenuBar2.add(jMenu5);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void listBox() throws Exception {
        jComboBoxEtat.addItem("");
        jComboBoxEtat.addItem("annulé");
        jComboBoxEtat.addItem("confirmé");

        jComboBoxType.addItem("");
        jComboBoxType.addItem("AM");
        jComboBoxType.addItem("PM");
        jComboBoxType.addItem("JR");

        jComboBoxIDAnim.setModel(new DefaultComboBoxModel(new Animateur().afficherIdAnimateurs().toArray()));
        jComboBoxIDPrest.setModel(new DefaultComboBoxModel(new Prestataires().afficherIdPrestatair().toArray()));
        jComboBoxIDSalle.setModel(new DefaultComboBoxModel(new Salle().afficherIdSalle((Integer) jComboBoxIDPrest.getSelectedItem()).toArray()));

    }

    public void AfficherSeminaire() throws Exception {
        //---------afficher la liste
        new Seminaire().afficherToutSeminaire(dt);
    }

    public void AfficherNbInscrit(int i) throws Exception {
        int count = 0;
        count = new Reservation().nbReservations(i);
        if (count == -1) {
            JOptionPane.showMessageDialog(null, "Aucune Séminaire trouvé", "InfoBox: " + "titleBar", JOptionPane.INFORMATION_MESSAGE);
        } else {
            jLabelReservation.setText(Integer.toString(count));
        }
    }

    public void AfficherRecetteReel(int i) throws Exception {
        int count = 0;
        count = new Seminaire().recettes_realisees(i);
        if (count == -1) {
            JOptionPane.showMessageDialog(null, "Aucaune Séminiare trouvé", "InfoBox: " + "titleBar", JOptionPane.INFORMATION_MESSAGE);
        } else {
            jLabelRecette.setText(Integer.toString(count));
        }
    }

    public void MaxDepensesPrevues(int i) throws Exception {
        int count = 0;
        count = new Seminaire().max_depenses_prevues(i);
        if (count == -1) {
            JOptionPane.showMessageDialog(null, "Aucun Séminaire trouvé", "InfoBox: " + "titleBar", JOptionPane.INFORMATION_MESSAGE);
        } else {
            labelmaxdp.setText(Integer.toString(count));
        }
    }

    public void MaxRecettesPrevues(int i) throws Exception {
        int count = 0;
        count = new Seminaire().max_recettes_prevues(i);
        if (count == -1) {
            JOptionPane.showMessageDialog(null, "Aucun Séminaire trouvé", "InfoBox: " + "titleBar", JOptionPane.INFORMATION_MESSAGE);
        } else {
            labelmaxrp.setText(Integer.toString(count));
        }
    }

    public void MinDepensesPrevues(int i) throws Exception {
        int count = 0;
        count = new Seminaire().min_depenses_prevues(i);
        if (count == -1) {
            JOptionPane.showMessageDialog(null, "Aucun Séminaire trouvé", "InfoBox: " + "titleBar", JOptionPane.INFORMATION_MESSAGE);
        } else {
            labelmindp.setText(Integer.toString(count));
        }
    }

    public void MinRecettesPrevues(int i) throws Exception {
        int count = 0;
        count = new Seminaire().min_recettes_prevues(i);
        if (count == -1) {
            JOptionPane.showMessageDialog(null, "Aucun Séminaire trouvé", "InfoBox: " + "titleBar", JOptionPane.INFORMATION_MESSAGE);
        } else {
            labelminrp.setText(Integer.toString(count));
        }
    }

    public void AfficherDepenseReel(int i) throws Exception {
        int count = 0;
        count = new Seminaire().depenses_realisees(i);
        if (count == -1) {
            JOptionPane.showMessageDialog(null, "Aucaune Séminiare trouvé", "InfoBox: " + "titleBar", JOptionPane.INFORMATION_MESSAGE);
        } else {
            jLabelDepese.setText(Integer.toString(count));
        }
    }

    public void tableModel() throws Exception {
        Statement stmt;
        //---------Remplir le table   

        dt = new DefaultTableModel();
        dt.addColumn("ID Séminaire");
        dt.addColumn("Théme");
        dt.addColumn("Type");
        dt.addColumn("Déjeuner");
        dt.addColumn("Tarif");
        dt.addColumn("Nombre Max");
        dt.addColumn("Date");
        dt.addColumn("Etat");
        //---------coper le table a  TableStg
        jTableSeminaire.setModel(dt);
    }
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            tableModel();
            AfficherSeminaire();
            listBox();
        } catch (Exception ex) {
            Logger.getLogger(GestionConferenciers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnSuivantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuivantActionPerformed

    }//GEN-LAST:event_btnSuivantActionPerformed
    boolean isUnsem = false;
    private void btnPremierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPremierActionPerformed
        try {
            int i;
            i = new Seminaire().vision_semaine(dt);
            if (i != 0) {
                isUnsem = true;
                tableModel();
                new Seminaire().vision_semaine(dt);
                
            } else {
                JOptionPane.showMessageDialog(null, "Aucun Séminaire trouvé", "InfoBox: " + "titleBar", JOptionPane.INFORMATION_MESSAGE);
                tableModel();
                AfficherSeminaire();
            }

        } catch (Exception ex) {
            Logger.getLogger(GestionActivites.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPremierActionPerformed

    private void btnPrecedentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrecedentActionPerformed
try {
            int i;
            i = new Seminaire().vision_semaine1mois(dt);
            if (i != 0) {
                tableModel();
                new Seminaire().vision_semaine1mois(dt);
            } else {
                JOptionPane.showMessageDialog(null, "Aucun Séminaire trouvé", "InfoBox: " + "titleBar", JOptionPane.INFORMATION_MESSAGE);
                tableModel();
                AfficherSeminaire();
            }

        } catch (Exception ex) {
            Logger.getLogger(GestionActivites.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPrecedentActionPerformed

    private void btnSeminaireAConfirmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeminaireAConfirmeActionPerformed
        try {
            int i;
            i = new Seminaire().afficherToutSeminaireConfirme(dt);
            if (i != 0) {
                tableModel();
                new Seminaire().afficherToutSeminaireConfirme(dt);
            } else {
                JOptionPane.showMessageDialog(null, "Aucune Séminaire trouvé", "InfoBox: " + "titleBar", JOptionPane.INFORMATION_MESSAGE);
                tableModel();
                AfficherSeminaire();
            }

        } catch (Exception ex) {
            Logger.getLogger(GestionActivites.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSeminaireAConfirmeActionPerformed

    private void jTableSeminaireMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSeminaireMouseClicked
        try {
            
            indice = jTableSeminaire.getSelectedRow();
            btnAnnuler.setEnabled(true);
            btnConfirme.setEnabled(true);
            idSeminaire = (Integer) dt.getValueAt(indice, 0);
            
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur de click \n" + e.getMessage());
        }
    }//GEN-LAST:event_jTableSeminaireMouseClicked

    private void btnAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterActionPerformed
        try {
//            String dej = null;
//
//            if (jRadioButtonOui.isSelected()) {
//                dej = "oui";
//            } else {
//                dej = "non";
//            }
//            JOptionPane.showMessageDialog(null, "dej : " + dej, "InfoBox: " + "titleBar", JOptionPane.INFORMATION_MESSAGE);
//
//            //
////            JOptionPane.showMessageDialog(null, "ok", "InfoBox: " + "titleBar", JOptionPane.INFORMATION_MESSAGE);
//            Date date1 = new SimpleDateFormat("dd-MM-yy").parse(this.txtdate.getText());
//            //Seminaire s = new Seminaire(0, (Integer) this.jComboBoxIDAnim.getSelectedItem(), this.txtTheme.getText(), jRadioButtonOui.isSelected(), date1);
//            JOptionPane.showMessageDialog(null, "dej : " + jRadioButtonOui.isSelected(), "InfoBox: " + "titleBar", JOptionPane.INFORMATION_MESSAGE);
////            Type_sem t = Type_sem.JR
////            jComboBoxType.getSelectedItem()    Type
//             // Seminaire s = Seminaire(0,(Integer)jComboBoxIDPrest.getSelectedItem(),(Integer)jComboBoxIDSalle.getSelectedItem(), (Integer)jComboBoxIDAnim.getSelectedItem(), txtTheme.getText(), Integer.parseInt(txtnbmax.getText()), jComboBoxType.getSelectedItem().toString(),txtdate.getText(),dej,Integer.parseInt(txtTarif.getText()),jComboBoxEtat.getSelectedItem().toString());
//                                         
//              
////Seminaire s = new Seminaire(0, (Integer) this.jComboBoxIDAnim.getSelectedItem(), this.txtTheme.getText(), jComboBoxType.getSelectedItem().toString(), dej,date1);
//
//            int i;
//            i = s.ajouter_seminaire_sans_programme(s);
//            if (i == 1) {
//                JOptionPane.showMessageDialog(null, "Séminiare ajoutée", "InfoBox: " + "titleBar", JOptionPane.INFORMATION_MESSAGE);
//                tableModel();
//                AfficherSeminaire();
//            } else {
//                JOptionPane.showMessageDialog(null, "Erreur d'ajouter une Séminiare ", "InfoBox: " + "titleBar", JOptionPane.INFORMATION_MESSAGE);
//            }

        } catch (Exception ex) {
            Logger.getLogger(GestionActivites.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAjouterActionPerformed

    private void btnModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierActionPerformed

    }//GEN-LAST:event_btnModifierActionPerformed


    private void btnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerActionPerformed

    }//GEN-LAST:event_btnSupprimerActionPerformed

    private void btnAfficherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAfficherActionPerformed
        try {
            tableModel();
            AfficherSeminaire();
        } catch (Exception ex) {
            Logger.getLogger(GestionSeminaire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAfficherActionPerformed

    private void btnRechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRechercherActionPerformed
        try {
            int i;
            i = new Seminaire().afficherSeminaire(dt, Integer.parseInt(txtRechercher.getText()));
            if (i != 0) {
                tableModel();
                new Seminaire().afficherSeminaire(dt, Integer.parseInt(txtRechercher.getText()));

                AfficherNbInscrit(Integer.parseInt(txtRechercher.getText()));
                AfficherRecetteReel(Integer.parseInt(txtRechercher.getText()));
                AfficherDepenseReel(Integer.parseInt(txtRechercher.getText()));
                MaxDepensesPrevues(Integer.parseInt(txtRechercher.getText()));
                MinDepensesPrevues(Integer.parseInt(txtRechercher.getText()));
                MaxRecettesPrevues(Integer.parseInt(txtRechercher.getText()));
                MinRecettesPrevues(Integer.parseInt(txtRechercher.getText()));
                
                //JOptionPane.showMessageDialog(null, new Seminaire().bilan_budgetaire(idSeminaire), "InfoBox: " + "titleBar", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "Aucaune activité trouvé", "InfoBox: " + "titleBar", JOptionPane.INFORMATION_MESSAGE);
                txtRechercher.setText("00");
                txtRechercher.setText("00");
                txtRechercher.setText("00");
                txtRechercher.setText("00");
                txtRechercher.setText("00");
                txtRechercher.setText("00");
                txtRechercher.setText("00");
            }

        } catch (Exception ex) {
            Logger.getLogger(GestionSeminaire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRechercherActionPerformed


    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Apropos a = new Apropos();
        a.setVisible(true);
        this.hide();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        GestionSeminaire a = new GestionSeminaire();
        a.setVisible(true);
        this.hide();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        GestionActivites a;
        try {
            a = new GestionActivites();
            a.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(GestionParticipants.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.hide();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        GestionConferenciers a = new GestionConferenciers();
        a.setVisible(true);
        this.hide();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        GestionPresentations a = new GestionPresentations();
        a.setVisible(true);
        this.hide();

    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        GestionPrestataire a = new GestionPrestataire();
        a.setVisible(true);
        this.hide();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        GestionPresentations a = new GestionPresentations();
        a.setVisible(true);
        this.hide();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        GestionParticipants a;
        try {
            a = new GestionParticipants();
            a.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(GestionConferenciers.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.hide();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        GestionReservations a = new GestionReservations();
        a.setVisible(true);
        this.hide();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        GestionAnimateurs a = new GestionAnimateurs();
        a.setVisible(true);
        this.hide();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void btnConfirmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfirmeActionPerformed

    private void btnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnulerActionPerformed
        try {
            int i;
            int nbInscrit = new Reservation().nbReservations(idSeminaire);
            int nbMax = new Seminaire().nbmaxPart(idSeminaire);
            JOptionPane.showMessageDialog(null, "ID Semai " + idSeminaire + "nbInscrit :" + nbInscrit + "nbMAx :" + nbMax, "InfoBox: " + "titleBar", JOptionPane.INFORMATION_MESSAGE);
            if (nbInscrit < nbMax / 2) {
                i = new Seminaire().annuler_seminaire(idSeminaire);
                if (i == 1) {
                    JOptionPane.showMessageDialog(null, "Séminaire ajouté", "InfoBox: " + "titleBar", JOptionPane.INFORMATION_MESSAGE);
                    tableModel();
                    AfficherSeminaire();
                } else {
                    JOptionPane.showMessageDialog(null, "Erreur d'annuler Séminaire ", "InfoBox: " + "titleBar", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Impossible d'annuler Séminiare ", "InfoBox: " + "titleBar", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            Logger.getLogger(GestionActivites.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAnnulerActionPerformed

    private void txtnbmaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnbmaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnbmaxActionPerformed

    private void jComboBoxIDPrestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxIDPrestActionPerformed
        if (jComboBoxIDPrest.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(null, "Selectionne un ID Presetatire svp!", "InfoBox: " + "titleBar", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                jComboBoxIDSalle.setModel(new DefaultComboBoxModel(new Salle().afficherIdSalle((Integer) jComboBoxIDPrest.getSelectedItem()).toArray()));
            } catch (Exception ex) {
                Logger.getLogger(GestionSeminaire.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboBoxIDPrestActionPerformed

    private void jComboBoxIDPrestItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxIDPrestItemStateChanged

    }//GEN-LAST:event_jComboBoxIDPrestItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestionSeminaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionSeminaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionSeminaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionSeminaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionSeminaire().setVisible(true);
            }
        });
    }

// <editor-fold defaultstate="collapsed" desc="Variables declaration">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAfficher;
    private javax.swing.JButton btnAjouter;
    private javax.swing.JButton btnAnnuler;
    private javax.swing.JButton btnConfirme;
    private javax.swing.JButton btnModifier;
    private javax.swing.JButton btnPrecedent;
    private javax.swing.JButton btnPremier;
    private javax.swing.JButton btnRechercher;
    private javax.swing.JButton btnSeminaireAConfirme;
    private javax.swing.JButton btnSuivant;
    private javax.swing.JButton btnSupprimer;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxEtat;
    private javax.swing.JComboBox<String> jComboBoxIDAnim;
    private javax.swing.JComboBox<String> jComboBoxIDPrest;
    private javax.swing.JComboBox<String> jComboBoxIDSalle;
    private javax.swing.JComboBox<String> jComboBoxType;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelDepese;
    private javax.swing.JLabel jLabelRecette;
    private javax.swing.JLabel jLabelReservation;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButtonNon;
    private javax.swing.JRadioButton jRadioButtonOui;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTableSeminaire;
    private javax.swing.JLabel labelmaxdp;
    private javax.swing.JLabel labelmaxrp;
    private javax.swing.JLabel labelmindp;
    private javax.swing.JLabel labelminrp;
    private javax.swing.JTextField txtRechercher;
    private javax.swing.JTextField txtTarif;
    private javax.swing.JTextField txtTheme;
    private javax.swing.JTextField txtdate;
    private javax.swing.JTextField txtnbmax;
    // End of variables declaration//GEN-END:variables

}
