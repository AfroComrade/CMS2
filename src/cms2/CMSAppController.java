package cms2;
package cms2.ClientPopout;

import cms2.ClientPopout.ClientPopoutController;
import cms2.EntryPopout.EntryPopoutController;

import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CMSAppController extends JFrame
{
    private ClientListModel clientListModel;
    private CMSPanel view;
    
    public CMSAppController(String title)
    {
        super(title);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize((int)(screenSize.getWidth() / 1.5),(int)(screenSize.getHeight() / 1.5));
        setResizable(true);
        
        clientListModel = new ClientListModel();
        clientListModel.addClient("Yeran", "email@email.com", "21 address road");
        clientListModel.addClient("Ash", "ashemail@email.com", "22 ashaddress lane");
        
        clientListModel.addEntry("Yeran", "Managed to get him to stop eating crayons, could do with a more nutritious diet", "10/10/10");
        clientListModel.addEntry("Yeran", "Second Entry coz YOLO", "11/11/11");
        clientListModel.addEntry("Ash", "Fixed his car", "12/12/12");
        
        this.view = new CMSPanel(clientListModel);
        add(view);
        

        clientListSelectionCheck();
        entryListSelectionCheck();
        newClientButton();
        newEntryButton();
        
        
        
        view.update();
    }
    
    
    public void newClientButton()
    {
        this.view.getNewClientButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                eventHandleNewClient();
            }
        });
    }
    
    public void newEntryButton()
    {
        this.view.getNewEntryButton().addActionListener(new ActionListener()
        {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               eventHandleNewEntry();
           }
        });
    }
    
    public void eventHandleNewClient()
    {
        ClientPopoutController popout2 = new ClientPopoutController();
        popout2.setVisible(true);
        
        popout2.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosed(WindowEvent e)
            {
                if (popout2.isCreated())
                {
                    System.out.println(popout2.getClient());
                    clientListModel.addClient(popout2.getClient());
                    view.update();
                }
            }
        }
        
        );
    }
    
    public void eventHandleNewEntry()
    {
        EntryPopoutController popout = new EntryPopoutController();
        popout.setVisible(true);
        
        popout.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosed(WindowEvent e)
            {
                System.out.println("Detected entry window close");
                if (popout.isCreated())
                {
                    System.out.println(popout.getEntry());
                    view.getClientListModel().getClient(view.getClientList().getSelectedIndex()).addEntry(popout.getEntry());
                    view.update();
                }
        }
        });
    }
    
    public void clientListSelectionCheck()
    {
        this.view.getClientList().addListSelectionListener(new ListSelectionListener()
        {
            public void valueChanged(ListSelectionEvent e)
            {
                if (e.getValueIsAdjusting())
                {
                    //System.out.println("List changed, received value: " + view.getClientList().getSelectedIndex());
                    view.getEntryList().setListData(
                            view.getClientListModel().getDateTimeList(
                                    view.getClientList().getSelectedIndex()));
                    view.getEntryListScroll().setEnabled(true);
                    view.getNewEntryButton().setEnabled(true);
                }

            }
        });
    }
    
    public void entryListSelectionCheck()
    {
        this.view.getEntryList().addListSelectionListener(new ListSelectionListener()
        {
            public void valueChanged(ListSelectionEvent e)
            {
                if (e.getValueIsAdjusting())
                {
                    String rawText = view.getClientListModel().getClient(view.getClientList().getSelectedIndex()).getEntries().get(view.getEntryList().getSelectedIndex()).getText();
                    String formattedText = rawText;
                    
                    for (int i = 26; i < formattedText.length(); i += 27)
                    {
                        if (formattedText.charAt(i) == ' ')
                        {
                            i++;
                        }

                        formattedText = formattedText.substring(0, i) + "\n" + formattedText.substring(i);
                    }
                    
                    view.getEntryText().setText(formattedText);
                }
            }
        }
        );
    }
    
    public static void main(String[] args)
    {
        CMSAppController app = new CMSAppController("Client Management Software");
        app.setVisible(true);
    }
}
