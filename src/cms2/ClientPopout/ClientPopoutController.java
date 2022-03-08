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
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize((int)(screenSize.getWidth() / 3),(int)(screenSize.getHeight() / 3));
        setResizable(false);
        
        this.view = new ClientPopoutView();
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
                String address = view.getAddressField().getText();
                String email = view.getEmailField().getText();
                client = new Client(name, address, email);
                created = true;
                setVisible(false);
                dispose();
            }
        });
    }
}
