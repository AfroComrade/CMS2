package cms2;

public class Entry 
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
    
    
    public Entry(String text, String dateTime)
    {
        this.text = text;
        this.dateTime = dateTime;
    }
}
