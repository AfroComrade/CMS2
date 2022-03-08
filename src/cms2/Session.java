package cms2;

public class Session 
{
    private String text;
    private String dateTime;

    public String getText() {
        return text;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
    
    
    public Session(String text, String dateTime)
    {
        this.text = text;
        this.dateTime = dateTime;
    }
    
    public String toSave(String delimiter)
    {
        String toSave = "";
        
        for (int i = 0; i < this.text.length(); i++)
        {
            if (this.text.charAt(i) == '\n')
            {
                toSave = toSave.concat("\\n");
            }
            else
            {
                toSave = toSave.concat(this.text.substring(i, i+1));
            }
        }
        
        return this.dateTime + delimiter + toSave;
    }
    
    /*
    
                        Session writeSession = writeClient.getSession(j);
                    
                    String writeString = writeSession.getText();
                    String newString = "";
                    for (int k = 0; k < writeString.length(); k++)
                    {
                        if (writeString.charAt(k) == '\n')
                        {
                            newString = newString.concat("\\n");
                        }
                        else
                        {
                            newString = newString.concat(writeString.substring(k, k+1));
                        }
                    }
                    file.write("#" + writeSession.getDateTime() + " " + newString + System.lineSeparator());
    
    */
}
