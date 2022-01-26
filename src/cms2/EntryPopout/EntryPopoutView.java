package cms2.EntryPopout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class EntryPopoutView extends JPanel
{
    private JLabel textLabel;
    private JLabel dateLabel;
    
    private JTextField textEntry;
    private JTextField dateEntry;
    
    private JButton done;
    private JButton cancel;
    
    
    public JTextField getTextField()
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
        
        this.dateEntry = new JTextField("");
        this.dateEntry.setLocation(80, 10);
        this.dateEntry.setSize(100, 20);
        add(this.dateEntry);
        this.dateEntry.setEnabled(true);
        
        this.textLabel = new JLabel("Entry:", SwingConstants.RIGHT);
        this.textLabel.setLocation(15, 45);
        this.textLabel.setSize(60,10);
        add(this.textLabel);
        this.textLabel.setEnabled(true);
        
        this.textEntry = new JTextField("");
        this.textEntry.setLocation(80, 40);
        this.textEntry.setSize(100, 20);
        add(this.textEntry);
        this.textEntry.setEnabled(true);
        
        this.done = new JButton("Done");
        this.done.setLocation(250, 140);
        this.done.setSize(80, 20);
        add(this.done);
        this.done.setEnabled(true);
        
        this.cancel = new JButton("Cancel");
        this.cancel.setLocation(120, 140);
        this.cancel.setSize(80, 20);
        add(this.cancel);
        this.cancel.setEnabled(true);
        
    }
}
