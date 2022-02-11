package cms2.EntryPopout;

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
import javax.swing.SwingConstants;

import javax.swing.JTextArea;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class EntryPopoutView extends JPanel
{
    private JLabel textLabel;
    private JLabel dateLabel;
    
    private JTextArea textEntry;
    private JTextField dateEntry;
    
    private JButton done;
    private JButton cancel;
    
    
    private JDatePanelImpl datePanel;
    private JDatePickerImpl datePicker;
    
    public JDatePickerImpl getDatePickerImpl()
    {
        return this.datePicker;
    }
    
    public JTextArea getTextField()
    {
        return this.textEntry;
    }
    
    public JTextField getDateField()
    {
        return this.dateEntry;
    }
    
    public JButton getDone()
    {
        return this.done;
    }
    
    public JButton getCancel()
    {
        return this.cancel;
    }
    
    public EntryPopoutView()
    {
        super();
        setLayout(null);
        
        this.dateLabel = new JLabel("Date:", SwingConstants.RIGHT);
        this.dateLabel.setLocation(15, 15);
        this.dateLabel.setSize(60, 10);
        add(this.dateLabel);
        this.dateLabel.setEnabled(true);
        
        /*
        this.dateEntry = new JTextField("");
        this.dateEntry.setLocation(80, 10);
        this.dateEntry.setSize(100, 20);
        add(this.dateEntry);
        this.dateEntry.setEnabled(true);*/
        
        this.textLabel = new JLabel("Entry:", SwingConstants.RIGHT);
        this.textLabel.setLocation(15, 45);
        this.textLabel.setSize(60,10);
        add(this.textLabel);
        this.textLabel.setEnabled(true);
        
        this.textEntry = new JTextArea("");
        this.textEntry.setLocation(80, 40);
        this.textEntry.setSize(200, 300);
        this.textEntry.setWrapStyleWord(true);
        this.textEntry.setLineWrap(true);
        add(this.textEntry);
        this.textEntry.setEnabled(true);
        
        this.cancel = new JButton("Cancel");
        this.cancel.setLocation(80, 360);
        this.cancel.setSize(80, 20);
        add(this.cancel);
        this.cancel.setEnabled(true);
        
        this.done = new JButton("Done");
        this.done.setLocation(210, 360);
        this.done.setSize(80, 20);
        add(this.done);
        this.done.setEnabled(true);
        
        UtilDateModel model = new UtilDateModel();
        model.setDate(ERROR, WIDTH, WIDTH);
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        this.datePanel = new JDatePanelImpl(model, p);
        this.datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        
        datePicker.setLocation(80, 10);
        datePicker.setSize(150, 25);
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

