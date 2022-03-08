package cms2;

import java.util.ArrayList;

public class Client 
{
    private String name;
    private String address;
    private String email;
    private String DOB;
    private String Ph;
    private String Gender;
    private String SessionCost;
    private String ACCNumber;
    private String Bio;
    private String PresentingIssue;
    private String Context;
    private ArrayList<Entry> entries;
    // private String internal_id; TO IMPLEMENT

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }
    
    public Entry getEntry(int index)
    {
        return entries.get(index);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Client(String name, String email, String address)
    {
        this.name = name;
        this.email = email;
        this.address = address;
        this.entries = new ArrayList<Entry>();
    }
    
    public ArrayList<Entry> getEntries()
    {
        return this.entries;
    }
    
    public void addEntry(String text, String datetime)
    {
        this.entries.add(new Entry(text, datetime));
    }
    
    public void addEntry(Entry entry)
    {
        this.entries.add(entry);
    }
    
    @Override
    public String toString()
    {
        return "(" + this.name + "," + this.email + "," + this.address + ")";
    }
    
}
