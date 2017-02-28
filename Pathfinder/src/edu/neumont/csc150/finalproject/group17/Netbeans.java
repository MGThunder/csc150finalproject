package edu.neumont.csc150.finalproject.group17;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Netbeans extends javax.swing.JFrame {

    public Netbeans() {
        initComponents();
    }
    
    JComboBox characterClass = new JComboBox<>();
    JLabel classLabel = new JLabel();
    JTextField classLevel = new JTextField();
    JLabel levelLabel = new JLabel();

    @SuppressWarnings("unchecked")                      
    private void initComponents() {

        Container = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        characterNameLabel = new javax.swing.JLabel();
        characterName = new javax.swing.JTextField();
        alignment = new javax.swing.JTextField();
        alignmentLabel = new javax.swing.JLabel();
        playerName = new javax.swing.JTextField();
        playerNameLabel = new javax.swing.JLabel();
        multiClassLabel = new javax.swing.JLabel();
        multiclassAmount = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(2600, 1500));

        Container.setBackground(new java.awt.Color(50, 50, 255));
        Container.setForeground(new java.awt.Color(0, 0, 255));

        Title.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        Title.setText("Pathfinder Character Sheet");

        characterNameLabel.setText("Character Name");

        characterName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                characterNameActionPerformed(evt);
            }
        });

        alignment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alignmentActionPerformed(evt);
            }
        });

        alignmentLabel.setText("Alignment");

        playerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerNameActionPerformed(evt);
            }
        });

        playerNameLabel.setText("Player Name");

        multiClassLabel.setText("<html>Amount of<br>Classes</html>");

        multiclassAmount.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        multiclassAmount.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                multiclassAmountPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout ContainerLayout = new javax.swing.GroupLayout(Container);
        Container.setLayout(ContainerLayout);
        ContainerLayout.setHorizontalGroup(
            ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContainerLayout.createSequentialGroup()
                .addGroup(ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContainerLayout.createSequentialGroup()
                        .addGap(439, 439, 439)
                        .addComponent(characterNameLabel)
                        .addGap(304, 304, 304)
                        .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContainerLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ContainerLayout.createSequentialGroup()
                                .addComponent(characterName, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(ContainerLayout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(alignment, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(playerName, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(ContainerLayout.createSequentialGroup()
                                        .addGap(222, 222, 222)
                                        .addComponent(alignmentLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(playerNameLabel)
                                        .addGap(368, 368, 368))))
                            .addGroup(ContainerLayout.createSequentialGroup()
                                .addGroup(ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(multiClassLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(multiclassAmount, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(1, 1, 1)))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        ContainerLayout.setVerticalGroup(
            ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(characterNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(alignmentLabel)
                        .addComponent(playerNameLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(characterName, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(alignment)
                    .addComponent(playerName))
                .addGap(61, 61, 61)
                .addComponent(multiClassLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(multiclassAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1080, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(Container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(9, 9, 9))
        );

        pack();
    }                    

    private void characterNameActionPerformed(java.awt.event.ActionEvent evt) {                                              
       
    }                                             

    private void alignmentActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
    }                                         

    private void playerNameActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
    }                                          

    private void multiclassAmountPropertyChange(java.beans.PropertyChangeEvent evt) {                                                
        JComboBox sourceGetter;
        String selectedGetter;
        int amount = 0;
        sourceGetter = (JComboBox)evt.getSource();
        selectedGetter = String.valueOf(sourceGetter.getSelectedItem());
        String amountString = selectedGetter;
        try {
            amount = Integer.parseInt(amountString);
        } catch (Exception e) {
            
        }
        
        for (int i = 0; i < amount; i++) {
        characterClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Wizard" }));
        classLabel.setText("Character Class");
        levelLabel.setText("Class Level");
        }
    }                                               


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Netbeans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Netbeans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Netbeans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Netbeans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Netbeans().setVisible(true);
            }
        });
    }
                    
    private javax.swing.JPanel Container;
    private javax.swing.JLabel Title;
    private javax.swing.JTextField alignment;
    private javax.swing.JLabel alignmentLabel;
    private javax.swing.JTextField characterName;
    private javax.swing.JLabel characterNameLabel;
    private javax.swing.JLabel multiClassLabel;
    private javax.swing.JComboBox<String> multiclassAmount;
    private javax.swing.JTextField playerName;
    private javax.swing.JLabel playerNameLabel;         
}