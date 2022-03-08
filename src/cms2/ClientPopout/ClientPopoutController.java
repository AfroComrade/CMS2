package cms2.ClientPopout;

import cms2.Client;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class ClientPopoutController extends JFrame
{
    private ClientPopoutView view;

    private Client client;
    public boolean created;
    
    public Client getClient()
    {
        return this.client;
    }
    
    public boolean isCreated()
    {
        return this.created;
    }
    
    public ClientPopoutController()
    {
        super("New Client");
        created = false;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int panelWidth = (int)screenSize.getWidth() / 2;
        int panelHeight = (int)(screenSize.getHeight() / 2);
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(panelWidth,panelHeight);
        setResizable(false);
        
        this.view = new ClientPopoutView(panelWidth,panelHeight);
        add(this.view);
        
        cancelButtonCheck();
        doneButtonCheck();
    }
    
    public void cancelButtonCheck()
    {
        this.view.getCancel().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                dispose();
            }
        }
        );
    }
    
    public void doneButtonCheck()
    {
        this.view.getDone().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String name = view.getNameField().getText();
                String DOB = view.getDatePicker().getJFormattedTextField().getText();
                String email = view.getEmailField().getText();
                String address = view.getAddressField().getText();
                String phNum = view.getphTextField().getText();
                String gender = view.getGenderTextField().getText();
                String cost = view.getCostTextField().getText();
                String acc = view.getAccTextField().getText();
                String bio = view.getBioTextField().getText();
                String issue = view.getIssueTextField().getText();
                String context = view.getContextField().getText();
                
                client = new Client(name, DOB, email, address, phNum, gender, cost, acc, bio, issue, context);
                created = true;
                setVisible(false);
                dispose();
            }
        });
    }
}
