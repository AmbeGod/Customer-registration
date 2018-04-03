
package customeregistration;

import java.awt.*;
import javax.swing.*;


public class RegPage extends JFrame{
    
   private ImageIcon icon = new ImageIcon("src//customer.png");
   public JLabel pic = new JLabel(icon);
   
    
    
    
    private JLabel namelbl = new JLabel("Name                              ");
    private JTextField nametxt = new JTextField(20);
    
    private JLabel surnamelbl = new JLabel("Surname                        ");
    private JTextField surnametxt = new JTextField(20);
    
    private JLabel usernamelbl = new JLabel("Customer Username: ");
    private JTextField usernametxt = new JTextField(20);
    
    private JLabel genderlbl = new JLabel("Gender:                                                         ");
    private JRadioButton gendermale = new JRadioButton("Male");
    private JRadioButton genderfemale = new JRadioButton("Female");
    private ButtonGroup gender = new ButtonGroup();
    
    private JLabel addresslbl = new JLabel("Address                     ");
    private JTextField addresstxt = new JTextField(20);
    
    private JLabel citylbl = new JLabel("City                              ");
    private JTextField citytxt = new JTextField(20);
    
    private JLabel countrylbl = new JLabel("Country                      ");
    private JTextField countrytxt = new JTextField(20);
    
    private JLabel phnolbl = new JLabel("Phone Number         ");
    private JTextField phnotxt = new JTextField(20);
    
    private JLabel emaillbl = new JLabel("Email                           ");
    private JTextField emailtxt = new JTextField(20);
    
    private JLabel doblbl = new JLabel("Date of Birth                       ");
    String [] day = {"dd","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16"
                    ,"17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    String [] month = {"mm","January","February","March","April","May","June","July","August"
                        ,"September","October","November","December"};
    String [] year = {"yy","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000"
                        ,"2001","2002","2003","2004","2005","2006","2007","2008"};
    private JComboBox dayCombo = new JComboBox(day);
    private JComboBox monthCombo = new JComboBox(month);
    private JComboBox yearCombo = new JComboBox(year);
    
    private JLabel stolbl = new JLabel("State of Origin            ");
     private JTextField stotxt = new JTextField(20);
     
    private JLabel biolbl = new JLabel("BioGraphy  ");
    private JTextArea biotxt = new JTextArea(8,32);
    
    private JLabel maidenlbl = new JLabel("Maiden Name              ");
    private JTextField maidentxt = new JTextField(20);
     
    private JLabel passlbl = new JLabel("Passport Number      ");
    private JTextField passtxt = new JTextField(20);
    
    private JLabel occupationlbl = new JLabel("Occupation                ");
    private JTextField occupationtxt = new JTextField(20);
    
    
    private JPanel  panel = new JPanel();
   
    JButton submitbtn = new JButton("Submit");
    JButton clearbtn = new JButton("Clear");
    
    
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
        add(biotxt);
        
        
        
        panel.add(clearbtn);
        panel.add(submitbtn);
        
       
        add("North", panel);

        
    }
    
    
    public static void main(String[] args) {

        new RegPage();
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
