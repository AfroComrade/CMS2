package cms2.ClientPopout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class ClientPopoutView extends JPanel
{
    private JLabel nameLabel;
    private JLabel addressLabel;
    private JLabel emailLabel;
    
    private JTextField nameEntry;
    private JTextField addressEntry;
    private JTextField emailEntry;
    
    private JButton done;
    private JButton cancel;
    
    
    public JTextField getNameField()
    {
        return this.nameEntry;
    }
    
    public JTextField getAddressField()
    {
        return this.addressEntry;
    }
    
    public JTextField getEmailField()
    {
        return this.emailEntry;
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
        
        this.nameLabel = new JLabel("Full Name:", SwingConstants.RIGHT);
        this.nameLabel.setLocation(15, 15);
        this.nameLabel.setSize(60, 10);
        add(this.nameLabel);
        this.nameLabel.setEnabled(true);
        
        this.nameEntry = new JTextField("");
        this.nameEntry.setLocation(80, 10);
        this.nameEntry.setSize(100, 20);
        add(this.nameEntry);
        this.nameEntry.setEnabled(true);
        
        this.addressLabel = new JLabel("Address:", SwingConstants.RIGHT);
        this.addressLabel.setLocation(15, 45);
        this.addressLabel.setSize(60,10);
        add(this.addressLabel);
        this.addressLabel.setEnabled(true);
        
        this.addressEntry = new JTextField("");
        this.addressEntry.setLocation(80, 40);
        this.addressEntry.setSize(100, 20);
        add(this.addressEntry);
        this.addressEntry.setEnabled(true);
        
        this.emailLabel = new JLabel("Email:", SwingConstants.RIGHT);
        this.emailLabel.setLocation(15, 75);
        this.emailLabel.setSize(60, 10);
        add(this.emailLabel);
        this.emailLabel.setEnabled(true);
        
        this.emailEntry = new JTextField("");
        this.emailEntry.setLocation(80, 70);
        this.emailEntry.setSize(100, 20);
        add(this.emailEntry);
        this.emailEntry.setEnabled(true);
        
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

