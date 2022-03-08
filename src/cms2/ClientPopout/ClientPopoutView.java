package cms2.ClientPopout;

import static java.awt.image.ImageObserver.ERROR;
import static java.awt.image.ImageObserver.WIDTH;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class ClientPopoutView extends JPanel
{
    private int xposition;
    private int yposition;
    private int xsize;
    private int ysize;
    
    private JTextField nameTextField;
    
    private JDatePanelImpl datePanel;
    private JDatePickerImpl datePicker;
    
    private JTextField emailTextField;
    private JTextField addressTextField;
    private JTextField phnumTextField;
    private JTextField genderTextField;
    private JTextField costTextField;
    private JTextField accTextField;
    private JTextPane bioTextField;
    private JTextPane issueTextField;
    private JTextPane contextTextField;
    
    private JButton done;
    private JButton cancel;
    
    public JTextField getNameField()
    {
        return this.nameTextField;
    }
    
    public JDatePickerImpl getDatePicker()
    {
        return this.datePicker;
    }
    
    public JTextField getEmailField()
    {
        return this.emailTextField;
    }
    
    public JTextField getAddressField()
    {
        return this.addressTextField;
    }
    
    public JTextField getphTextField()
    {
        return this.phnumTextField;
    }
    
    public JTextField getGenderTextField()
    {
        return this.genderTextField;
    }
    
    public JTextField getCostTextField()
    {
        return this.costTextField;
    }
    
    public JTextField getAccTextField()
    {
        return this.accTextField;
    }
    
    public JTextPane getBioTextField()
    {
        return this.bioTextField;
    }
    
    public JTextPane getIssueTextField()
    {
        return this.issueTextField;
    }
    
    public JTextPane getContextField()
    {
        return this.contextTextField;
    }
    
    public JButton getDone()
    {
        return this.done;
    }
    
    public JButton getCancel()
    {
        return this.cancel;
    }
    
    public ClientPopoutView(int panelWidth, int panelHeight)
    {
        super();
        setLayout(null);
        
        initializeJStuff(panelWidth, panelHeight);
        
        this.done = new JButton("Done");
        this.done.setLocation( ((panelWidth/5) * 2) - 40, (panelHeight/5) * 4 );
        this.done.setSize(80, 30);
        add(this.done);
        this.done.setEnabled(true);
        
        this.cancel = new JButton("Cancel");
        this.cancel.setLocation(((panelWidth/5) * 3) - 40, (panelHeight/5) * 4);
        this.cancel.setSize(80, 30);
        add(this.cancel);
        this.cancel.setEnabled(true);
        
    }
    
    public void initializeJStuff(int panelWidth, int panelHeight)
    {
        this.xposition = (panelWidth/10) - 50;
        this.yposition = panelHeight/10;
        this.xsize = 100;
        this.ysize = 20;
        
        int yincrement = panelHeight/12;
        int yincrementbump = yincrement;
        int xincrement = panelWidth/3;
        
        int xtextbumper = 40;
        
        initializeLabel("Full Name:", xposition, yposition, xsize, ysize);
        this.nameTextField = initializeTextField(xposition + xtextbumper, yposition, xsize, ysize);
        
        initializeDatePicker(xposition, yposition + yincrement, xsize, ysize);
        yincrement += yincrementbump;
        
        initializeLabel("Email:", xposition, yposition + yincrement, xsize, ysize);
        this.emailTextField = initializeTextField(xposition + xtextbumper, yposition + yincrement, xsize, ysize);
        yincrement += yincrementbump;
        
        initializeLabel("Address:", xposition, yposition + yincrement, xsize, ysize);
        this.addressTextField = initializeTextField(xposition + xtextbumper, yposition + yincrement, xsize, ysize);
        yincrement += yincrementbump;
        
        initializeLabel("Phone Number:", xposition, yposition + yincrement, xsize, ysize);
        this.phnumTextField = initializeTextField(xposition + xtextbumper, yposition + yincrement, xsize, ysize);
        yincrement += yincrementbump;
        
        initializeLabel("Gender:", xposition, yposition + yincrement, xsize, ysize);
        this.genderTextField = initializeTextField(xposition + xtextbumper, yposition + yincrement, xsize, ysize);
        yincrement += yincrementbump;
        
        initializeLabel("Session Cost:", xposition,yposition + yincrement, xsize, ysize);
        this.costTextField = initializeTextField(xposition + xtextbumper, yposition + yincrement, xsize, ysize);
        yincrement += yincrementbump;
        
        initializeLabel("ACC Number:", xposition, yposition + yincrement, xsize, ysize);
        this.accTextField = initializeTextField(xposition + xtextbumper, yposition + yincrement, xsize, ysize);
        yincrement = yincrementbump;
        
        initializeLabel("Bio:", xposition+xincrement, yposition, xsize, ysize);
        this.bioTextField = initialiseTextPane(xposition + xtextbumper +xincrement, yposition, panelWidth/4, panelHeight/8);
        
        initializeLabel("Presenting Issue:", xposition+xincrement, yposition + yincrement + panelHeight/8, xsize, ysize);
        this.issueTextField = initialiseTextPane(xposition + xtextbumper +xincrement, yposition + yincrement + panelHeight/8, panelWidth/4, panelHeight/8);
        yincrement += yincrementbump;
        
        initializeLabel("Context:", xposition+xincrement, yposition + yincrement + panelHeight/4, xsize, ysize);
        this.contextTextField = initialiseTextPane(xposition + xtextbumper +xincrement, yposition + yincrement + panelHeight/4, panelWidth/4, panelHeight/8);
        
        /*
        
    private JTextField genderTextField;
    private JTextField costTextField;
    private JTextField accTextField;
    private JTextField bioTextField;
    private JTextField issueTextField;
    private JTextField contextTextField;
        
        */
    }
    
    public JLabel initializeLabel(String labelString, int xposition, int yposition, int xsize, int ysize)
    {
        JLabel label = new JLabel(labelString, SwingConstants.RIGHT);
        label.setLocation(xposition, yposition);
        label.setSize(xsize, ysize);
        add(label);
        label.setEnabled(true);
        
        return label;
    }
    
    public JTextPane initialiseTextPane(int xposition, int yposition, int xsize, int ysize)
    {
        JTextPane jtextpane = new JTextPane();
        jtextpane.setLocation(xposition + 65, yposition - 5);
        jtextpane.setSize(xsize + 40, ysize + 10);
        add(jtextpane);
        jtextpane.setEnabled(true);   
        
        return jtextpane;
    }
    
    public JTextField initializeTextField(int xposition, int yposition, int xsize, int ysize)
    {
        JTextField jtextfield = new JTextField("");
        jtextfield.setLocation(xposition + 65, yposition - 5);
        jtextfield.setSize(xsize + 40, ysize + 10);
        add(jtextfield);
        jtextfield.setEnabled(true);   
        
        return jtextfield;
    }
        
    public void initializeDatePicker(int xposition, int yposition, int xsize, int ysize)
    {
        UtilDateModel model = new UtilDateModel();
        model.setDate(ERROR, WIDTH, WIDTH);
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        this.datePanel = new JDatePanelImpl(model, p);
        this.datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        
        JLabel dateLabel = initializeLabel("DOB:", xposition, yposition, xsize, ysize);
                
        this.datePicker.setLocation(xposition + 105, yposition - 5);
        this.datePicker.setSize(xsize + 40, ysize + 10);
        this.add(this.datePicker);   
    }
    
    public class DateLabelFormatter extends JFormattedTextField.AbstractFormatter
    {
        private String datePattern = "dd-MM-yyyy";
        private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
        
        @Override
        public Object stringToValue(String text) throws ParseException
        {
            return dateFormatter.parseObject(text);
        }
        
        @Override
        public String valueToString(Object value) throws ParseException
        {
            if (value != null) 
            {
                Calendar cal = (Calendar) value;
                return dateFormatter.format(cal.getTime());
            }
            
            return "";
        }
    }
}

