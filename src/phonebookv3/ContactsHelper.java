package phonebookv3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ContactsHelper {

	    private static List<Contact> AllContacts;
	    private static String MessageStatus;
	    public static final String ContactFileName = "Contacts.txt";

	    
	    public static String getMessageStatus() {
	        return MessageStatus;
	    }

	   
	    public static void setMessageStatus(String aMessageStatus) {
	        MessageStatus = aMessageStatus;
	    }

	    public ContactsHelper() {
	        AllContacts = new ArrayList<Contact>();
	    }
	    
	    public static List<Contact> getAllContacts() {
	        return AllContacts;
	    }

	    public static void setAllContacts(List<Contact> aAllContacts) {
	        AllContacts = aAllContacts;
	    }

	    public static boolean updateContact(String name, String PhoneNo, String emailAdd, String NewStringLine) {
	        BufferedReader br = null;
	        String ReWrite = "";
	        boolean success = false;
	        try {
	            if (new File(ContactFileName).exists()) {
	                br = new BufferedReader(new FileReader(ContactFileName));
	                String line = "";
	                while ((line = br.readLine()) != null) {
	                    if (!"".equals(line)) {
	                        String[] temp = line.split(",");
	                        if (temp[0].equalsIgnoreCase(name) && temp[1].equalsIgnoreCase(PhoneNo)
	                                && temp[2].equalsIgnoreCase(emailAdd)) {
	                            ReWrite += NewStringLine + "\r\n";
	                        } else {
	                            ReWrite += line + "\r\n";
	                        }
	                    }
	                }
	                br.close();

	                if (writeFile(ReWrite)) {
	                    success = true;
	                } else {
	                    success = false;
	                }
	                readPhoneContacts();

	            } else {
	                new File(ContactFileName).createNewFile();
	                readPhoneContacts();
	                success = false;
	            }
	        } catch (FileNotFoundException ex) {
	            MessageStatus = ex.getMessage();
	            success = false;
	        } catch (IOException ex) {
	            MessageStatus = ex.getMessage();
	            success = false;
	        }
	        return success;
	    }
	    

	    public static List<Contact> searchContact(String searchValue) {
	        List<Contact> cnt = new ArrayList<>();
	        BufferedReader br = null;

	        try {
	            if (new File(ContactFileName).exists()) {
	                br = new BufferedReader(new FileReader(ContactFileName));
	                String line = "";
	                while ((line = br.readLine()) != null) {
	                    if (!"".equals(line)) {
	                        String[] temp = line.split(",");
	                        if (temp[0].equalsIgnoreCase(searchValue) || temp[1].equalsIgnoreCase(searchValue)
	                                || temp[2].equalsIgnoreCase(searchValue)) {
	                            Contact c = new Contact();
	                            c.setName(temp[0]);
	                            c.setPhoneNo(temp[1]);
	                            c.setEmailAddress(temp[2]);
	                            cnt.add(c);
	                        }
	                    }
	                }
	            } else {
	                new File(ContactFileName).createNewFile();
	                cnt = searchContact(searchValue);
	            }
	        } catch (FileNotFoundException ex) {
	            JOptionPane.showMessageDialog(null, ex.getMessage());
	        } catch (IOException ex) {
	            JOptionPane.showMessageDialog(null, ex.getMessage());
	        } finally {
	            try {
	                br.close();
	            } catch (IOException ex) {
	                JOptionPane.showMessageDialog(null, ex.getMessage());
	            }
	        }

	        return cnt;
	    }
	    
	    public static void deleteContacts(Contact C) {
	        BufferedReader br = null;
	        String ReWrite = "";
	        try {
	            if (new File(ContactFileName).exists()) {
	                br = new BufferedReader(new FileReader(ContactFileName));
	                String line = "";
	                while ((line = br.readLine()) != null) {
	                    String[] _temp = line.split(",");
	                    if (_temp[0].equalsIgnoreCase(C.getName()) && _temp[1].equalsIgnoreCase(C.getPhoneNo())
	                            && _temp[2].equalsIgnoreCase(C.getEmailAddress())) {
	                    } else {
	                        ReWrite += line + "\r\n";
	                    }
	                }
	                br.close();

	                if (writeFile(ReWrite)) {
	                    JOptionPane.showMessageDialog(null, "Successfully delete contact " + C.getName());
	                } else {
	                    JOptionPane.showMessageDialog(null, "Failed to delete contact " + C.getName());
	                }

	                ContactsHelper.readPhoneContacts();
	                PhoneBookMain.TableInject();

	            } else {
	                new File(ContactFileName).createNewFile();
	                readPhoneContacts();
	            }
	        } catch (FileNotFoundException ex) {
	            JOptionPane.showMessageDialog(null, ex.getMessage());
	        } catch (IOException ex) {
	            JOptionPane.showMessageDialog(null, ex.getMessage());
	        }
	    }

	    protected static boolean writeFile(String TextToWrite) {
	        FileWriter writer = null;
	        boolean successfulWrite = false;
	        try {
	            writer = new FileWriter(ContactFileName);
	            writer.write(TextToWrite);
	            writer.close();
	            successfulWrite = true;
	        } catch (IOException ex) {
	            successfulWrite = false;
	            MessageStatus = ex.getMessage();
	        } finally {
	            try {
	                writer.close();
	            } catch (IOException ex) {
	                MessageStatus = ex.getMessage();
	            }
	        }
	        return successfulWrite;
	    }

	   

	    public static void readPhoneContacts() {
	        BufferedReader br = null;
	        try {
	            if (new File(ContactFileName).exists()) {

	                if (AllContacts == null) {
	                    AllContacts = new ArrayList<>();
	                } else {
	                    AllContacts.clear();
	                }
	                br = new BufferedReader(new FileReader(ContactFileName));
	                /* Read Contacts.txt for listing */
	                new StringBuilder();
	                String line = "";
	                Contact ContactClass = null;
	                while ((line = br.readLine()) != null) {
	                    if (!line.equalsIgnoreCase("")) {
	                        ContactClass = new Contact();
	                        String[] temp = line.split(",");
	                        String tempValue = temp[0];
	                        if (tempValue.equalsIgnoreCase("NULL")) {
	                        	tempValue = "";
	                        }
	                        ContactClass.setName(tempValue);

	                        tempValue = temp[1];
	                        if (tempValue.equalsIgnoreCase("NULL")) {
	                        	tempValue = "";
	                        }
	                        ContactClass.setPhoneNo(tempValue);

	                        tempValue = temp[2];
	                        if (tempValue.equalsIgnoreCase("NULL")) {
	                        	tempValue = "";
	                        }
	                        ContactClass.setEmailAddress(tempValue);
	                        AllContacts.add(ContactClass);
	                    }
	                }
	            } else {
	                new File(ContactFileName).createNewFile();
	                readPhoneContacts();
	            }

	        } catch (NullPointerException | IOException ex) {
	            JOptionPane.showMessageDialog(null, ex.getMessage());
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException ex) {
	                    
	                }
	            }
	        }

	    }

	    public static boolean appendToContactTxt(String appendValue) {
	    	/* Read contact to Contacts.txt */
	        boolean success = false;
	        try {
	            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(ContactFileName, true)));
	            out.println(appendValue);
	            out.close();
	            success = true;
	        } catch (IOException e) {
	            JOptionPane.showMessageDialog(null, e.getMessage());
	        }
	        return success;
	    }
	 
	    
	}

