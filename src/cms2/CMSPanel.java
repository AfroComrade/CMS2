package cms2;

import java.awt.Color;
import java.awt.Point;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;


public class CMSPanel extends JPanel
{
    private JList clientList;
    private ClientListModel clientListModel;
    private JScrollPane clientListScroll;
    
    private JList entryList;
    private JScrollPane entryListScroll;
    
    private JTextArea entryText;
    private JButton newClientButton;
    private JButton newEntryButton;
    
    private int[] clientPos;
    private int[] entryPos;
    
    public JButton getNewEntryButton()
    {
        return this.newEntryButton;
    }
    
    public JButton getNewClientButton()
    {
        return this.newClientButton;
    }
    
    public JTextArea getEntryText()
    {
        return this.entryText;
    }
    
    public JList getEntryList()
    {
        return this.entryList;
    }
    
    public JList getClientList()
    {
        return this.clientList;
    }
    
    public ClientListModel getClientListModel()
    {
        return this.clientListModel;
    }
    
    public JScrollPane getEntryListScroll()
    {
        return this.entryListScroll;
    }
    
    private void createClientUI(int[] clientPos)
    {
        JLabel clientTitle = new JLabel("Clients:");
        clientTitle.setLocation(clientPos[0] + 1, clientPos[1]);
        clientTitle.setSize(60,20);
        add(clientTitle);
        
        this.clientList = new JList(this.clientListModel.toList());
        
        this.clientListScroll = new JScrollPane(clientList,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.clientListScroll.setLocation(clientPos[0],clientPos[1]+22);
        this.clientListScroll.setSize(80, 150);
        add(clientListScroll);
        this.clientListScroll.setEnabled(true);
        
        this.newClientButton = new JButton("New");
        this.newClientButton.setLocation(clientPos[0]+1,clientPos[1]+180);
        this.newClientButton.setSize(76, 20);
        add(newClientButton);
        this.newClientButton.setEnabled(true);
    }
    
    private void createEntryUI(int[] entryPos)
    {
        JLabel entryTitle = new JLabel("Entries:");
        entryTitle.setLocation(entryPos[0]+1, entryPos[1]);
        entryTitle.setSize(60,20);
        add(entryTitle);
        
        this.entryList = new JList();
        
        this.entryListScroll = new JScrollPane(entryList,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.entryListScroll.setLocation(entryPos[0],entryPos[1]+22);
        this.entryListScroll.setSize(80, 150);
        add(entryListScroll);
        this.entryListScroll.setEnabled(false);

        this.newEntryButton = new JButton("New");
        this.newEntryButton.setLocation(entryPos[0]+1,entryPos[1]+180);
        this.newEntryButton.setSize(60, 20);
        add(newEntryButton);
        this.newEntryButton.setEnabled(false);
    }
    
    private void createJournalUI(int[] clientPos)
    {
        JLabel journalTitle = new JLabel("Journal Entry:");
        journalTitle.setLocation(clientPos[0] + 130, clientPos[1]);
        journalTitle.setSize(80,20);
        add(journalTitle);
        
        this.entryText = new JTextArea("");
        this.entryText.setLocation(clientPos[0] + 130,clientPos[1] +22);
        this.entryText.setSize(300, 435);
        this.entryText.setWrapStyleWord(true);
        this.entryText.setLineWrap(true);
        add(entryText);
        this.entryText.setEnabled(false);
    }
    
    private void createArrowUI(int[] clientPos)
    {
        JLabel arrow = new JLabel ("V");
        arrow.setLocation(clientPos[0]+35, clientPos[1]+220);
        arrow.setSize(20,20);
        add(arrow);
    }
    
    public CMSPanel(ClientListModel clientListModel)
    {
        super();
        
        this.clientListModel = clientListModel;
        setLayout(null);
        
        this.clientPos = new int[]{15, 10};
        createClientUI(clientPos);
        
        this.entryPos = new int[]{clientPos[0], clientPos[1] + 260};
        createEntryUI(entryPos);
        
        createArrowUI(clientPos);
        createJournalUI(clientPos);
    }
    
    public void update()
    {
        this.clientList.setListData(this.clientListModel.toList());
        this.entryList.setListData(new String[0]);
        this.entryListScroll.setEnabled((this.clientList.getSelectedIndex() > 0));
        this.newEntryButton.setEnabled(this.clientList.getSelectedIndex() > -1);
    }
}
