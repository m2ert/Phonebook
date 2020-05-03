package phonebookv3;

import java.util.Hashtable;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PhoneBookMain extends javax.swing.JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private javax.swing.JButton jButton1;
	 private javax.swing.JButton jButton2;
	 private javax.swing.JButton jButton3;
	 private javax.swing.JButton jButton4;
	 private javax.swing.JLabel jLabel1;
	 private javax.swing.JScrollPane jScrollPane1;
	 private static javax.swing.JTable jTable1;
	 private javax.swing.JTextField jTextSearch;
	    
    public PhoneBookMain() {
    	initViews();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ContactsHelper.readPhoneContacts();
        TableInject();
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PhoneBookMain().setVisible(true);
            }
        });
    }

    public static void TableInject() {
    	
        jTable1.removeAll();
        
        List<Contact> AllContacts = ContactsHelper.getAllContacts();
        if (AllContacts != null) {           
            int index = 1;
            String colNames[] = {"ID","Name", "Phone", "Email"};
            DefaultTableModel dtm = new DefaultTableModel(null, colNames);

            for (int i = 0; i < AllContacts.size(); i++) {
                dtm.addRow(new String[4]);
            }
            jTable1.setModel(dtm);
            
            if (AllContacts.size() > 0) {
                int row = 0;
                for (Contact c : AllContacts) {
                    jTable1.setValueAt(Integer.toString(index), row, 0);                                       
                    jTable1.setValueAt(c.getName(), row, 1);
                    jTable1.setValueAt(c.getPhoneNo(), row, 2);                   
                    jTable1.setValueAt(c.getEmailAddress(), row, 3);
                    index++;                   
                    row++;
                }
                jTable1.getColumn("ID").setMaxWidth(30);
                jTable1.getColumn("Name").setMaxWidth(130);
                jTable1.getColumn("Phone").setMaxWidth(110);
                jTable1.getColumn("Email").setMaxWidth(110);
                
            }
        }
    }


    private void initViews() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextSearch = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PhoneBook #Group2");
        setResizable(false);


        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "Phone", "Email"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Add Contact");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Search Contact (Name or Phone Number)");


        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

  
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                ))
                        .addGap(0, 3, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton3)
                        ))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                        
        AddEditForm Form = new AddEditForm();
        Form.setFormMode(true); /* if true == add mode */
        Form.setFormTitle("Create a new contact");
        Form.setVisible(true);
    }                                       

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                        
        int row = jTable1.getSelectedRow(); 
        
        if(row != -1){
        	
        	/* Edit contacts info selected row */
        	
            String name = (String)jTable1.getValueAt(row,1);
            String PhoneNo = (String)jTable1.getValueAt(row,2);
            String email = (String)jTable1.getValueAt(row,3);
           
            Contact C = new Contact();
            C.setEmailAddress(email);
            C.setName(name);
            C.setPhoneNo(PhoneNo);
     
            AddEditForm dlg = new AddEditForm();
            dlg.setFormMode(false); /* edit mode */
            dlg.setFormTitle("Edit contact details");
            dlg.MapTextBox(C);
            dlg.setVisible(true);           
        }
       
               
    }                                       

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                        
         int row = jTable1.getSelectedRow(); 
         
         /* Delete contacts selected row */
         
        if(row != -1){
            String name = (String)jTable1.getValueAt(row,1);
            String PhoneNo = (String)jTable1.getValueAt(row,2);
            String email = (String)jTable1.getValueAt(row,3);
           
            Contact C = new Contact();
            C.setEmailAddress(email);
            C.setName(name);
            C.setPhoneNo(PhoneNo);
           
            if (JOptionPane.showConfirmDialog(null, "Are you sure to delete contact : " + name + "?",
                    "Warning", JOptionPane.OK_CANCEL_OPTION) == 0) { 
                ContactsHelper.deleteContacts(C);
            }
        }
    }                                       

                                    

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {    
    	/* trim method for left-right spaces */
    	String searchValue = jTextSearch.getText().trim();
        	if(searchValue.isEmpty()) {
                ContactsHelper.readPhoneContacts();
        	}else {
        		Hashtable< String, String > hash = new Hashtable< String, String >();
                List<Contact> contacts = ContactsHelper.getAllContacts();
               
                /* List values into HashTable */
                for (Contact c : contacts) {
                	hash.put(c.getName(), c.getPhoneNo());     
                }
                
                /* Search sort for hashtable datas */
                if(hash.containsValue(searchValue)){
                    System.out.println("The Hashtable contains value " + searchValue);
                    
                    List<Contact> searchedContacts = ContactsHelper.searchContact(searchValue);
                    ContactsHelper.setAllContacts(searchedContacts);
                    TableInject();
                    
                }else if(hash.containsKey(searchValue)) {
                	System.out.println("The Hashtable contains key " + searchValue);
                	
                	List<Contact> searchedContacts = ContactsHelper.searchContact(searchValue);
                    ContactsHelper.setAllContacts(searchedContacts);
                    TableInject();
                       
                }else {
                	JOptionPane.showMessageDialog(null, "There is no record registered this name or phone in your contacts!");
                	
                }
        	}
        
    }                                       

}

