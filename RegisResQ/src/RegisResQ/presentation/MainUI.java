/* Program will provide system for managing animals under care of an animal 
 * rescue shelter. Allows users to log new received animals and inspect records 
 * of existing animals already under care.
 *
 */
package RegisResQ.presentation;

import RegisResQ.application.*;
import RegisResQ.persistence.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import java.util.*;
import javax.swing.JFrame;

/** MainUI { MainUI class builds GUI for RegisResQ application using Java Swing 
 *
 * @author Anthony Kritikos
 * @version 1, Programming Assignment 6 (Implement Use Cases Part 2)
 */

public class MainUI extends javax.swing.JFrame {
     // Private variable declarations
        private List<Animal> animals = null;
        private AnimalTableModel model = new AnimalTableModel();
        private int selectedRow = -1;
        private final Dao database = new AnimalDao();

    /**
     * Constructor creates new form MainUI
     */
    public MainUI() {
        // Default Java Swing code for initializing components
        initComponents();
        
        // Initializes animals ArrayList w/ contents of the database.
        animals = database.getAll();
        
        // Initializes animals list in AnimalTableModel.
        model.setAnimals(animals);
        
        // Connects JTable to AnimalTableModel.
        animalsTable.setModel(model);
        
        // Indicates that the table model has updated and updates display.
        model.fireTableDataChanged();
        
        // Enable entire row in the JTable to be selected when a record is 
        // clicked, instead of just one cell of the table
        animalsTable.setColumnSelectionAllowed(false);
        animalsTable.setRowSelectionAllowed(true);
        
        /**
        * Inserts data for selected database record into associated GUI field.
        */
        animalsTable.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt){
                // Class variables
                int row;
                String date;
                // Assignment instructs to create these date variables, but they
                // seem to not be in use yet
                String month;
                String day;
                String year;
                
                row = animalsTable.rowAtPoint(evt.getPoint());

                // Set text/values for each field in the table
                if(row >= 0){
                    
                    selectedRow = row;
                    breedTextField.setText(model.getValueAt(row, 1).toString());
                    nameTextField.setText(model.getValueAt(row, 2).toString());
                    date = model.getValueAt(row, 4).toString();
                    yearTextField.setText(date.split("-")[0]);
                    monthTextField.setText(date.split("-")[1]);
                    dayTextField.setText(date.split("-")[2]);
                    
                    // Sets combo dropdown menu to match selected animal type
                    if(model.getValueAt(row, 0).toString().equalsIgnoreCase("Dog")){
                        animalTypeCombo.setSelectedIndex(1);
                    }else{
                        animalTypeCombo.setSelectedIndex(0);
                    }
                    
                    // Sets combo dropdown menu to match selected sterilization
                    if(model.getValueAt(row, 3).toString().equalsIgnoreCase("True")){
                        sterilizedCombo.setSelectedIndex(0);
                    }else{
                        sterilizedCombo.setSelectedIndex(1);
                    }                  
                    
                }
                
            }
            
        });
        
        // Enables auto sorting of table contents
        animalsTable.setAutoCreateRowSorter(true);
        
        // Set column widths
        animalsTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        animalsTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        animalsTable.getColumnModel().getColumn(2).setPreferredWidth(50);
        animalsTable.getColumnModel().getColumn(3).setPreferredWidth(50);
        animalsTable.getColumnModel().getColumn(4).setPreferredWidth(50);
        
        // Set keyboard shortcuts for GUI 
        nameLabel.setDisplayedMnemonic('n');
        nameLabel.setLabelFor(nameTextField);
        breedLabel.setDisplayedMnemonic('b');
        breedLabel.setLabelFor(breedTextField);
        arrivalLabel.setDisplayedMnemonic('r');
        arrivalLabel.setLabelFor(monthTextField);
        animalTypeLabel.setDisplayedMnemonic('t');
        animalTypeLabel.setLabelFor(animalTypeCombo);
        sterilizedLabel.setDisplayedMnemonic('s');
        sterilizedLabel.setLabelFor(sterilizedCombo);
        fileMenu.setMnemonic('f');
        exitMenuItem.setMnemonic('x');
        dateClearButton.setMnemonic('c');
        addButton.setMnemonic('a');
        modifyButton.setMnemonic('m');
        deleteButton.setMnemonic('d');
        exitButton.setMnemonic('x');
        
        /**
        * Selects all default text for overwriting when month box is selected
        */
        monthTextField.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            
            if (monthTextField.getText().equals("MM") ) // Default text is MM
                monthTextField.selectAll(); // Select all text
            
        }
        
        /**
        * Refills default text if left blank
        */
        @Override
        public void focusLost(FocusEvent arg0) {
            
            // If left blank, reverts text back to MM
            if (monthTextField.getText().equals("") ) 
                monthTextField.setText("MM");
            
        }
        
        });
        
        /**
        * Selects all default text for overwriting when day box is selected
        */
        dayTextField.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            
            if (dayTextField.getText().equals("DD") ) // Default text is DD
                dayTextField.selectAll(); // Select all text
            
        }
        
        /**
        * Refills default text if left blank
        */
        @Override
        public void focusLost(FocusEvent arg0) {
            
            // If left blank, reverts text back to DD
            if (dayTextField.getText().equals("") ) 
                dayTextField.setText("DD");
            
        }
        
        });
        
        /**
        * Selects all default text for overwriting when year box is selected
        */
        yearTextField.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            
            if (yearTextField.getText().equals("YYYY") ) // Default text is YYYY
                yearTextField.selectAll(); // Select all text
            
        }
        
        /**
        * Refills default text if left blank
        */
        @Override
        public void focusLost(FocusEvent arg0) {
            
            /// If left blank, reverts text back to YYYY
            if (yearTextField.getText().equals("") ) 
                yearTextField.setText("YYYY");
            
        }
        
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tableScrollPane = new javax.swing.JScrollPane();
        animalsTable = new javax.swing.JTable();
        nameLabel = new javax.swing.JLabel();
        breedLabel = new javax.swing.JLabel();
        arrivalLabel = new javax.swing.JLabel();
        animalTypeLabel = new javax.swing.JLabel();
        sterilizedLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        breedTextField = new javax.swing.JTextField();
        monthTextField = new javax.swing.JTextField();
        dayTextField = new javax.swing.JTextField();
        yearTextField = new javax.swing.JTextField();
        animalTypeCombo = new javax.swing.JComboBox<>();
        sterilizedCombo = new javax.swing.JComboBox<>();
        addButton = new javax.swing.JButton();
        modifyButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        dateClearButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Regis ResQ");

        tableScrollPane.setBorder(null);
        tableScrollPane.setForeground(new java.awt.Color(245, 246, 247));

        animalsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Type", "Breed", "Name", "Sterilized", "Arrived"
            }
        ));
        animalsTable.setFillsViewportHeight(true);
        tableScrollPane.setViewportView(animalsTable);

        nameLabel.setText("Name");

        breedLabel.setText("Breed");

        arrivalLabel.setText("Arrival Date");

        animalTypeLabel.setText("Type of Animal");

        sterilizedLabel.setText("Spayed/Neutered");

        monthTextField.setText("MM");

        dayTextField.setText("DD");

        yearTextField.setText("YYYY");

        animalTypeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cat", "Dog" }));

        sterilizedCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        modifyButton.setText("Modify");
        modifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        dateClearButton.setText("Clear");
        dateClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateClearButtonActionPerformed(evt);
            }
        });

        menuBar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        fileMenu.setText("File");

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(animalTypeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sterilizedLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(arrivalLabel)
                                    .addComponent(breedLabel)
                                    .addComponent(nameLabel))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameTextField)
                            .addComponent(breedTextField)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(animalTypeCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sterilizedCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(monthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yearTextField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(modifyButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(breedLabel)
                    .addComponent(breedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(monthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(yearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dateClearButton))
                    .addComponent(arrivalLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(animalTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(animalTypeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sterilizedCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sterilizedLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(exitButton)
                        .addComponent(modifyButton)
                        .addComponent(addButton))
                    .addComponent(deleteButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Adds new entry from user input to GUI table and database
     */
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        Animal a;
        String date = null;
        Boolean sterilizedValue = null;
        
        date = yearTextField.getText() + "-" + monthTextField.getText() + 
                "-" + dayTextField.getText();      

        // Will be true if string is Yes, and false if string is No
        sterilizedValue = sterilizedCombo.getSelectedItem().toString().equals("Yes");           
        
        // Creates dog/cat with input information
        if(animalTypeCombo.getSelectedItem().toString().equalsIgnoreCase("Dog")){
            a = new Dog(breedTextField.getText(), nameTextField.getText(), 
                    sterilizedValue, date);
        }else{
            a = new Cat(breedTextField.getText(), nameTextField.getText(), 
                    sterilizedValue, date);
        }
        
        // Checks if Animal object is valid and returns if not
        if(a.validate() == false){
            JOptionPane.showMessageDialog(new JFrame(), 
                    "Error while validating Animal! Check input.", "Dialog", 
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Checks if Animal was properly added to database and returns if not
        if(database.add(a) == false){
            JOptionPane.showMessageDialog(new JFrame(), 
                    "Error while adding Animal to database!", "Dialog", 
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Updates animal list, model, and GUI
        animals.add(a);
        selectedRow = -1;
        model.setAnimals(animals);
        model.fireTableDataChanged();
        
        // Reset all fields to empty or defaults
        nameTextField.setText("");
        breedTextField.setText("");
        monthTextField.setText("MM");
        dayTextField.setText("DD");
        yearTextField.setText("YYYY");
        animalTypeCombo.setSelectedIndex(0);
        sterilizedCombo.setSelectedIndex(0);      
    }//GEN-LAST:event_addButtonActionPerformed

    /**
     * Modifies existing entry from user input to GUI table and database
     */
    private void modifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyButtonActionPerformed
        // Assignment algo states to include this prior to defining variables
        if(selectedRow < 0){
            return;
        }
        
        // Local method variables
        Animal a = null;
        String date = null;
        Boolean sterilizedValue = null;
        
        // Selects entry that will be modified and gets current field values
        a = animals.get(selectedRow);
        a.setBreed(breedTextField.getText());
        a.setName(nameTextField.getText());
        date = yearTextField.getText() + "-" + monthTextField.getText() + "-" + 
                dayTextField.getText();       
        sterilizedValue = sterilizedCombo.getSelectedItem().toString().equalsIgnoreCase("Yes");
        
        a.setDateArrived(date);
        a.setSterilized(sterilizedValue);
        
        if(a.validate() == false){
            JOptionPane.showMessageDialog(new JFrame(), 
                    "Error while modifying Animal! Check input.", "Dialog", 
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(database.update(a) == false){
            JOptionPane.showMessageDialog(new JFrame(), 
                    "Error while modifying database!", "Dialog", 
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Updates GUI
        selectedRow = -1;
        model.fireTableDataChanged();
        
        // Reset all fields to empty or defaults
        nameTextField.setText("");
        breedTextField.setText("");
        monthTextField.setText("MM");
        dayTextField.setText("DD");
        yearTextField.setText("YYYY");
        animalTypeCombo.setSelectedIndex(0);
        sterilizedCombo.setSelectedIndex(0);  
    }//GEN-LAST:event_modifyButtonActionPerformed

    /**
     * Deletes entry selected by user from GUI table and database
     */
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // Assignment algo states to include this prior to defining variables
        if(selectedRow < 0){
            return;
        }
        
        // Local method variables
        int selectedOption;
        Animal a; 
        
        // Selects entry that will be deleted 
        a = animals.get(selectedRow);
        
        // Prompts user to confirm deletion
        selectedOption = JOptionPane.showConfirmDialog(null, 
                "Delete the selected row?", 
                "Yes/No", JOptionPane.YES_NO_OPTION);
        
        // Executes deletion once user selects yes
        if(selectedOption == JOptionPane.YES_OPTION){
            // Deletes entry from database and updates GUI 
            animals.remove(selectedRow);
            model.fireTableDataChanged();
            database.delete(a);
            selectedRow = -1;
            
            // Reset all fields to empty or defaults
            nameTextField.setText("");
            breedTextField.setText("");
            monthTextField.setText("MM");
            dayTextField.setText("DD");
            yearTextField.setText("YYYY");
            animalTypeCombo.setSelectedIndex(0);
            sterilizedCombo.setSelectedIndex(0); 
        }
        
    }//GEN-LAST:event_deleteButtonActionPerformed

    /**
     * Exits program when exit button is selected
     */
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    /**
     * Exits program when File menu exit button is selected
     */
    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    /**
     * Clears all text from input fields and resets them to default
     */
    private void dateClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateClearButtonActionPerformed
        
        // Reset all fields to empty or defaults
        nameTextField.setText("");
        breedTextField.setText("");
        monthTextField.setText("MM");
        dayTextField.setText("DD");
        yearTextField.setText("YYYY");
        animalTypeCombo.setSelectedIndex(0);
        sterilizedCombo.setSelectedIndex(0); 
        
    }//GEN-LAST:event_dateClearButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JComboBox<String> animalTypeCombo;
    private javax.swing.JLabel animalTypeLabel;
    private javax.swing.JTable animalsTable;
    private javax.swing.JLabel arrivalLabel;
    private javax.swing.JLabel breedLabel;
    private javax.swing.JTextField breedTextField;
    private javax.swing.JButton dateClearButton;
    private javax.swing.JTextField dayTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton modifyButton;
    private javax.swing.JTextField monthTextField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JComboBox<String> sterilizedCombo;
    private javax.swing.JLabel sterilizedLabel;
    private javax.swing.JScrollPane tableScrollPane;
    private javax.swing.JTextField yearTextField;
    // End of variables declaration//GEN-END:variables
}
