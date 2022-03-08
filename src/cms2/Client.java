package cms2;

import java.util.ArrayList;

public class Client 
{
    private String name;
    private String address;
    private String email;
    private String DOB;
    private String phNum;
    private String gender;
    private String sessionCost;
    private String accNumber;
    private String bio;
    private String presentingIssue;
    private String context;
    private ArrayList<Session> sessions;
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
    
    public Session getSession(int index)
    {
        return sessions.get(index);
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
    
    public Client(String name, String DOB, String email, String address, String ph, String gender, String sessionCost, String accNumber, String bio, String presentingIssue, String context)
    {
        this.name = name;
        this.DOB = DOB;
        this.email = email;
        this.address = address;
        this.phNum = ph;
        this.gender = gender;
        this.sessionCost = sessionCost;
        this.accNumber = accNumber;
        this.bio = bio;
        this.presentingIssue = presentingIssue;
        this.context = context;
        this.sessions = new ArrayList<Session>();
    }
    
    public ArrayList<Session> getSessions()
    {
        return this.sessions;
    }
    
    public void addSessions(String text, String datetime)
    {
        this.sessions.add(new Session(text, datetime));
    }
    
    public void addSession(Session entry)
    {
        this.sessions.add(entry);
    }
    
    @Override
    public String toString()
    {
        return "(" + this.name + "," + this.email + "," + this.address + ")";
    }
    
    public String toSave(String delimiter)
    {
        return this.name + delimiter + this.DOB + delimiter + this.email + delimiter + this.address + delimiter + this.phNum + delimiter + this.gender + delimiter + this.sessionCost + delimiter + this.accNumber + delimiter + this.bio + delimiter + this.presentingIssue + delimiter + this.context;
    }
    
}
