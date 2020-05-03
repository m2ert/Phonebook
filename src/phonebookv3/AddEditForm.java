package phonebookv3;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class AddEditForm extends javax.swing.JFrame {

    
	private static final long serialVersionUID = 1L;
	
	private boolean formMode; // true for add, false for edit
	private String formTitle;
    private Contact editContactDetails;
    private javax.swing.JTextField JTextName;
    private javax.swing.JTextField JTextPhone;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextEmail;

   
    
    public AddEditForm() {
    	initViews();      
    }
   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddEditForm().setVisible(true);
            }
        });
    }
    
    
    public boolean isFormMode() {
        return formMode;
    }

    public void setFormMode(boolean formMode) {
        this.formMode = formMode;
    }
    
    public void setFormTitle(String formTitle) {
        this.formTitle = formTitle;
    }
    
    public String getFormTitle() {
        return formTitle;
    }



    public Contact getEditContactDetails() {
        return editContactDetails;
    }

    public void setEditContactDetails(Contact editContactDetails) {
        this.editContactDetails = editContactDetails;
    }


    public void MapTextBox(Contact c){
        if(c != null){
        	jLabel1.setText("Edit contact details");
            JTextName.setText(c.getName());
            JTextPhone.setText(c.getPhoneNo());
            jTextEmail.setText(c.getEmailAddress()); 
            editContactDetails = c;
        }
    }
   

    private void initViews() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JTextName = new javax.swing.JTextField();
        JTextPhone = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Create a new contact");
       
        
        
        jLabel2.setText("Name");
        jLabel3.setText("Phone");
        jLabel4.setText("Email");
        jButton1.setText("Save");
        jButton2.setText("Cancel");

        
        JTextPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTextPhoneKeyPressed(evt);
            }
        });

       
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

      
     javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(JTextPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(JTextName, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
            
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTextName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTextPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                )
        );

        pack();
        setLocationRelativeTo(null);
    }                

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                        
        dispose();
    }                                       

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                        
        String Name = JTextName.getText();
        String Phone = JTextPhone.getText();
        String Email = jTextEmail.getText();
        String buildContact = "";
        
        
        String email_regex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$"; 
        Pattern emailPat = Pattern.compile(email_regex); 
       
        String phone_regex = "05[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]";
        Pattern phonePat = Pattern.compile(phone_regex); 

        if(!Name.isEmpty()){
            buildContact += Name + ",";
        }else {
        	JOptionPane.showMessageDialog(null,"Please enter a valid name");
        	buildContact += "NULL" + ",";
        }
       
        if(!Phone.isEmpty() && phonePat.matcher(Phone).matches()){
            buildContact += Phone + ",";
            
        }else {
        	JOptionPane.showMessageDialog(null,"Please enter a valid phone number (05..)");
        	buildContact += "NULL" + ",";
        }
       
        if(!Email.isEmpty() && emailPat.matcher(Email).matches()){
            buildContact += Email + ",";
        }else {
        	JOptionPane.showMessageDialog(null,"Please enter a valid e-mail address");
        	buildContact += "NULL";
        }
        
        	System.out.println(buildContact);
        	
        buildContact = buildContact.substring(0,buildContact.length() -1);
       
        if(formMode){
            if(ContactsHelper.appendToContactTxt(buildContact + "\r\n")){
                JOptionPane.showMessageDialog(null,"Successfully add contact : " + Name);               
                ContactsHelper.readPhoneContacts(); 
                PhoneBookMain.TableInject();
                dispose();
            }else{
                JOptionPane.showMessageDialog(null,"Failed to add contact : " + Name);
            } 
        }else{
            if(ContactsHelper.updateContact(editContactDetails.getName(),
                    editContactDetails.getPhoneNo(),
                    editContactDetails.getEmailAddress(), buildContact)){
                JOptionPane.showMessageDialog(null,"Successfully update contact : " + Name);
                ContactsHelper.readPhoneContacts(); 
                PhoneBookMain.TableInject();
                dispose();
            }else{
                JOptionPane.showMessageDialog(null,"Failed to update contact : " + Name);
            }               
        }
       
    }                                       

    private void JTextPhoneKeyPressed(java.awt.event.KeyEvent evt) {                                     
        if(JTextPhone.getText().length() == 12){
            JTextPhone.setText(JTextPhone.getText().substring(0,JTextPhone.getText().length() -1));
        }
    }                                    

  
  
	

}
