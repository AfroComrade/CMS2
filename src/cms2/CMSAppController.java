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

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

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
        
        File f = new File("savedfileinfo.txt");
        if (f.exists() && !f.isDirectory())
        {
            eventLoad(f);
        }
        
        this.view = new CMSPanel(clientListModel);
        add(view);
        

        clientListSelectionCheck();
        entryListSelectionCheck();
        newClientButton();
        newEntryButton();
        
        listenWindowClose();
        
        view.update();
    }
    
    public void listenWindowClose()
    {
        this.addWindowListener(new WindowAdapter() 
        {
            @Override
            public void windowClosing(WindowEvent E)
            {
                eventSave();
            }       
        });
    }
    
    public void eventSave() // This handles saving all the clients + entries to file savedfileinfo.txt
    {
        try {
            FileWriter file = new FileWriter("savedfileinfo.txt");
            for (int i = 0; i < clientListModel.getClients().size(); i++)
            {
                Client writeClient = clientListModel.getClient(i);
                file.write("Index: " + i + System.lineSeparator());
                file.write("Client:" + writeClient.toString()+ System.lineSeparator());
                file.write("     " + System.lineSeparator());
                for (int j = 0; j < writeClient.getEntries().size(); j++)
                {
                    Entry writeEntry = writeClient.getEntry(j);
                    file.write(writeEntry.getDateTime() + writeEntry.getText() + System.lineSeparator());
                }
                file.write("\nEOC" + System.lineSeparator() + System.lineSeparator() + System.lineSeparator());
            }
            file.close();
        } catch (IOException e) {
            System.out.println("File writing error occurred");
            e.printStackTrace();
        }
    }

    public void eventLoad(File f) // Load all clients an entries from savedfileinfo.txt
    {
        try{
            Scanner myReader = new Scanner(f);
            String lastClient = "";
            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                if ((data.length() >= 6) && data.substring(0, 6).equals("Client"))
                {
                    String clientName = data.substring(8, data.indexOf(','));
                    String secondString = data.substring(data.indexOf(',') + 1);
                    String clientEmail = secondString.substring(0, secondString.indexOf(','));
                    String clientAddress = secondString.substring(secondString.indexOf(',') + 1, secondString.length() - 1);
                    this.clientListModel.addClient(clientName, clientEmail, clientAddress);
                    lastClient = clientName;
                }
                else if ((data.length() >= 8 ) && data.charAt(2) == ('/') && data.charAt(5) == ('/'))
                {
                    String date = data.substring(0, 8);
                    String text = data.substring(8);
                    this.clientListModel.addEntry(lastClient, text, date);
                    this.clientListModel.getEntries(0);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Load failed");
        }
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
