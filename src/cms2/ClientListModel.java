package cms2;

import java.util.ArrayList;

public class ClientListModel 
{
    private ArrayList<Client> clients;

    public Client getClient(int index)
    {
        return clients.get(index);
    }
    
    public ArrayList<Client> getClients() {
        return clients;
    }
    
    public ClientListModel()
    {
        this.clients = new ArrayList<Client>();
    }
    
    public void addEntry(String name, String text, String datetime)
    {
        for (int i = 0; i < clients.size(); i++)
        {
            if (name.equals(clients.get(i).getName()))
            {
                this.clients.get(i).addSessions(text, datetime);
            }
        }
    }
    
    public ArrayList<Session> getEntries(int index)
    {
        return clients.get(index).getSessions();
    }
    
    public String[] getDateTimeList(int index)
    {
        int displaysize = this.clients.get(index).getSessions().size();
        String[] displaylist = new String[displaysize];
        
        for (int i = 0; i < displaysize; i++)
        {
            displaylist[i] = clients.get(index).getSessions().get(i).getDateTime();
        }
        
        return displaylist;
    }
    
    public String[] toList()
    {
        String[] displayList = new String[this.clients.size()];

        for (int i = 0; i < displayList.length; i++) 
        {
            displayList[i] = this.clients.get(i).getName();
        }

        return displayList;
    }
    
    public void addClient(String name, String DOB, String email, String address, String ph, String gender, String sessionCost, String accNumber, String bio, String presentingIssue, String context)
    {
        this.clients.add(new Client(name, DOB, email, address, ph, gender, sessionCost, accNumber, bio, presentingIssue, context));
    }
    
    public void addClient(Client client)
    {
        this.clients.add(client);
    }
}
