
package customeregistration;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class RegPage extends JFrame implements ActionListener{
    
   private final ImageIcon icon = new ImageIcon("src//customer.png");
   public JLabel pic = new JLabel(icon);
   
    
    
    
    private final JLabel namelbl = new JLabel("Name                              ");
    private final JTextField nametxt = new JTextField(20);
    
    private final JLabel surnamelbl = new JLabel("Surname                        ");
    private final JTextField surnametxt = new JTextField(20);
    
    private final JLabel usernamelbl = new JLabel("Username                     ");
    private final JTextField usernametxt = new JTextField(20);
    
    private final JLabel genderlbl = new JLabel("Gender:                                                         ");
    private final JRadioButton gendermale = new JRadioButton("Male");
    private final JRadioButton genderfemale = new JRadioButton("Female");
    private final ButtonGroup gender = new ButtonGroup();
    
    private final JLabel addresslbl = new JLabel("Address                     ");
    private final JTextField addresstxt = new JTextField(20);
    
    private final JLabel citylbl = new JLabel("City                              ");
    private final JTextField citytxt = new JTextField(20);
    
    private final JLabel countrylbl = new JLabel("Country                      ");
    private final JTextField countrytxt = new JTextField(20);
    
    private final JLabel phnolbl = new JLabel("Phone Number         ");
    private final JTextField phnotxt = new JTextField(20);
    
    private final JLabel emaillbl = new JLabel("Email                           ");
    private final JTextField emailtxt = new JTextField(20);
    
    private final JLabel doblbl = new JLabel("Date of Birth                       ");
    String [] days = {" ","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16"
                    ,"17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    String [] months = {" ","January","February","March","April","May","June","July","August"
                        ,"September","October","November","December"};
    String [] years = {" ","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000"
                        ,"2001","2002","2003","2004","2005","2006","2007","2008"};
    private final JComboBox dayCombo = new JComboBox(days);
    private final JComboBox monthCombo = new JComboBox(months);
    private final JComboBox yearCombo = new JComboBox(years);
    
    private final JLabel stolbl = new JLabel("State of Origin            ");
    private final JTextField stotxt = new JTextField(20);
     
    private final JLabel biolbl = new JLabel("BioGraphy  ");
    private final JTextArea biotxt = new JTextArea(8,32);
    private final JScrollPane pane = new JScrollPane(biotxt);
    
    private final JLabel maidenlbl = new JLabel("Maiden Name              ");
    private final JTextField maidentxt = new JTextField(20);
     
    private final JLabel passlbl = new JLabel("Passport Number      ");
    private final JTextField passtxt = new JTextField(20);
    
    private final JLabel occupationlbl = new JLabel("Occupation                ");
    private final JTextField occupationtxt = new JTextField(20);
    
    
    private final JPanel  panel = new JPanel();
   
    JButton submitbtn = new JButton("Submit");
    JButton clearbtn = new JButton("Clear");
    
    DBConnect conn = new DBConnect();
    RegPage(){
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocation(350,0);
        setSize(380,750);
        setResizable(false);
      
        
        gender.add(gendermale);
        gender.add(genderfemale);
        
        add(pic);
        
        
        add(namelbl);
        add(nametxt);
        
        add(surnamelbl);
        add(surnametxt);
        
        add(usernamelbl);
        add(usernametxt);
        
        add(genderlbl);
        add(gendermale);
        add(genderfemale);
        
        add(addresslbl);
        add(addresstxt);
        
        add(citylbl);
        add(citytxt);
        
        add(countrylbl);
        add(countrytxt);
        
        add(phnolbl);
        add(phnotxt);
        
        add(emaillbl);
        add(emailtxt);
        
        add(doblbl);
        add(dayCombo);
        add(monthCombo);
        add(yearCombo);
        
        add(stolbl);
        add(stotxt);
        
        add(maidenlbl);
        add(maidentxt);
        
        add(passlbl);
        add(passtxt);
        
        add(occupationlbl);
        add(occupationtxt);
        
        add(biolbl);
        add(pane);
        
        
        
        panel.add(clearbtn);
        panel.add(submitbtn);
        
       
        add("North", panel);
        
        submitbtn.addActionListener(this);
        clearbtn.addActionListener(this);
        //nametxt.addKeyListener(new TextFieldListener());
        //surnametxt.addKeyListener(new TextFieldListener());
    }
    
   
    
    
    public static void main(String[] args) {

       RegPage regPage = new RegPage();
    }
    
    
     
    
    
   @Override
    public void actionPerformed(ActionEvent ee){
        
        if (ee.getSource() == submitbtn && validateFields()== true)
        {
           String genders ;
           int dy,yr;
           String mnth ;
           String name = nametxt.getText();
           String surname = surnametxt.getText();
           String username = usernametxt.getText();
           String address = addresstxt.getText();
           String city = citytxt.getText();
           String country = countrytxt.getText();
           String phone = phnotxt.getText();
           String email = emailtxt.getText();
           String storigin = stotxt.getText();
           String maiden = maidentxt.getText();
           String passport = passtxt.getText();
           String occupation = occupationtxt.getText();
           String biography = biotxt.getText();
           if (gendermale.isSelected()){
               genders = "Male";
           }
           else 
               genders = "Female";
           
           dy = Integer.parseInt(dayCombo.getSelectedItem().toString());
           yr = Integer.parseInt(yearCombo.getSelectedItem().toString());
           mnth = monthCombo.getSelectedItem().toString();
                    
            conn.connect();
            
            boolean details = conn.check_username(username);
            {
                if (details == true){
                    JOptionPane.showMessageDialog(null, "Username already Exist, please enter a new username");
                }
                else{
                    
                conn.connect();
            boolean reg = conn.Register(name, surname, username , genders, address , city, country,
                    phone, email, dy, mnth ,yr, storigin, maiden, passport, occupation, biography);
            {
                if (reg == true){
                
                JOptionPane.showMessageDialog(null, "Successfully Registered");
                dispose();
            }
            else
                JOptionPane.showMessageDialog(null, "Error Occured");

            }
        }
            }
        }
        
        else if (ee.getSource() == clearbtn){
           nametxt.setText("");
           surnametxt.setText("");
           usernametxt.setText("");
           addresstxt.setText("");
           citytxt.setText("");
           countrytxt.setText("");
           phnotxt.setText("");
           emailtxt.setText("");
           stotxt.setText("");
           maidentxt.setText("");
           passtxt.setText("");
           occupationtxt.setText("");
           biotxt.setText("");
           gender.clearSelection();
           dayCombo.setSelectedIndex(0);
           monthCombo.setSelectedIndex(0);
           yearCombo.setSelectedIndex(0);
           
        }
    }
    
 public boolean validateFields()
    {
        boolean control = true;
        if(nametxt.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Fill in your Name", "Name Error", JOptionPane.ERROR_MESSAGE);
            control=  false;
        }
        else if  (surnametxt.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Fill in your Surname", "Surname Error", JOptionPane.ERROR_MESSAGE);
            control=  false;
        }  
        else if  (usernametxt.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Fill in your Username", "Username Error", JOptionPane.ERROR_MESSAGE);
            control=  false;
        } 
        else if ((gendermale.isSelected() == false) && (genderfemale.isSelected() == false)){
            JOptionPane.showMessageDialog(null, "Please select your gender", "Gender Error", JOptionPane.ERROR_MESSAGE);
            control=  false;
            
        }
        else if  (addresstxt.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Fill in your Address", "Address Error", JOptionPane.ERROR_MESSAGE);
            control=  false;
        } 
        else if  (citytxt.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Fill in your City", "City Error", JOptionPane.ERROR_MESSAGE);
            control=  false;
        } 
        else if  (countrytxt.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Fill in your Country", "Country Error", JOptionPane.ERROR_MESSAGE);
            control=  false;
        } 
        else if  (phnotxt.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Fill in your Phone No", "Phone No Error", JOptionPane.ERROR_MESSAGE);
            control=  false;
        } 
        else if  (emailtxt.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Fill in your Email Address", "E-mail Error", JOptionPane.ERROR_MESSAGE);
            control=  false;
        } 
        else if  ((dayCombo.getSelectedIndex() == 0) || (monthCombo.getSelectedIndex() == 0) || (yearCombo.getSelectedIndex() == 0)){ 
            JOptionPane.showMessageDialog(null, "Please Fill in your Date of Birth Correctly", "DOB Error", JOptionPane.ERROR_MESSAGE);
            control=  false;
        } 
        else if  (stotxt.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Fill in your State of Origin", "Stage of origin Error", JOptionPane.ERROR_MESSAGE);
            control=  false;
        } 
        else if  (maidentxt.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Fill in your Maiden Name", "Maiden name Error", JOptionPane.ERROR_MESSAGE);
            control=  false;
        } 
        else if  (passtxt.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Fill in your Passport Number", "Passport Error", JOptionPane.ERROR_MESSAGE);
            control=  false;
        } 
        else if  (occupationtxt.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Fill in your Occupation", "Occupation Error", JOptionPane.ERROR_MESSAGE);
            control=  false;
        } 
        else if  (biotxt.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please tell us a bit about you", "Biography Error", JOptionPane.ERROR_MESSAGE);
            control=  false;
        } 
        
        
        
        return control;
    }
    
    
  

     
}
