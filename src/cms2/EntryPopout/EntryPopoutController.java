package cms2.EntryPopout;

import cms2.Session;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class EntryPopoutController extends JFrame
{
    private EntryPopoutView view;

    private Session entry;
    public boolean created;
    
    public Session getEntry()
    {
        return this.entry;
    }
    
    public boolean isCreated()
    {
        return this.created;
    }
    
    public EntryPopoutController()
    {
        super("New Entry");
        created = false;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize((int)(screenSize.getWidth() / 3),(int)(screenSize.getHeight() / 2));
        setResizable(false);
        
        this.view = new EntryPopoutView();
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
                String date = view.getDatePickerImpl().getJFormattedTextField().getText();
                String text = view.getTextField().getText();
                entry = new Session(text, date);
                created = true;
                setVisible(false);
                dispose();
            }
        });
    }
}
