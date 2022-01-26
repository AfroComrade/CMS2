package cms2;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;

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
    
    
    public CMSPanel(ClientListModel clientListModel)
    {
        super();
        
        this.clientListModel = clientListModel;
        setLayout(null);
        
        this.clientList = new JList(this.clientListModel.toList());
        
        this.clientListScroll = new JScrollPane(clientList,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.clientListScroll.setLocation(10,30);
        this.clientListScroll.setSize(80, 150);
        add(clientListScroll);
        this.clientListScroll.setEnabled(true);
        
        
        this.entryList = new JList();
        
        this.entryListScroll = new JScrollPane(entryList,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.entryListScroll.setLocation(100,30);
        this.entryListScroll.setSize(80, 150);
        add(entryListScroll);
        this.entryListScroll.setEnabled(false);
        
        this.entryText = new JTextArea("");
        this.entryText.setLocation(190,30);
        this.entryText.setSize(150, 150);
        add(entryText);
        this.entryText.setEnabled(true);
        
        
        this.newClientButton = new JButton("New");
        this.newClientButton.setLocation(10,190);
        this.newClientButton.setSize(60, 20);
        add(newClientButton);
        this.newClientButton.setEnabled(true);
        
        this.newEntryButton = new JButton("New");
        this.newEntryButton.setLocation(100,190);
        this.newEntryButton.setSize(60, 20);
        add(newEntryButton);
        this.newEntryButton.setEnabled(false);
    }
    
    public void update()
    {
        this.clientList.setListData(this.clientListModel.toList());
        this.entryList.setListData(new String[0]);
        this.entryListScroll.setEnabled((this.clientList.getSelectedIndex() > 0));
        this.newEntryButton.setEnabled(this.clientList.getSelectedIndex() > -1);
    }
}