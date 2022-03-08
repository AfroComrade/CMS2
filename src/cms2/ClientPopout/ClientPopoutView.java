package cms2.ClientPopout;

import cms2.EntryPopout.EntryPopoutView;
import static java.awt.image.ImageObserver.ERROR;
import static java.awt.image.ImageObserver.WIDTH;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;
import javax.management.modelmbean.ModelMBean;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
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
    private JTextField bioTextField;
    private JTextField issueTextField;
    private JTextField contextTextField;
    
    private JButton done;
    private JButton cancel;
    
    public JTextField getNameField()
    {
        return this.nameTextField;
    }
    
    public JTextField getAddressField()
    {
        return this.addressTextField;
    }
    
    public JTextField getEmailField()
    {
        return this.emailTextField;
    }
    
    public JButton getDone()
    {
        return this.done;
    }
    
    public JButton getCancel()
    {
        return this.cancel;
    }
    
    public ClientPopoutView()
    {
        super();
        setLayout(null);
        
        initializeJStuff();
        
        this.done = new JButton("Done");
        this.done.setLocation(250, 140);
        this.done.setSize(80, 30);
        add(this.done);
        this.done.setEnabled(true);
        
        this.cancel = new JButton("Cancel");
        this.cancel.setLocation(120, 140);
        this.cancel.setSize(80, 30);
        add(this.cancel);
        this.cancel.setEnabled(true);
        
    }
    
    public void initializeJStuff()
    {
        this.xposition = 10;
        this.yposition = 15;
        this.xsize = 75;
        this.ysize = 20;
        
        int yincrement = 40;
        int yincrementbump = yincrement;
        int xincrement = 100;
        
        int xtextbumper = 15;
        
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
                
        datePicker.setLocation(xposition + 65 + 15, yposition - 5);
        datePicker.setSize(xsize + 40, ysize + 10);
        this.add(datePicker);   
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

