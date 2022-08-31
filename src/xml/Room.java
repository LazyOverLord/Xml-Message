package xml;

import java.io.IOException;
import java.io.OutputStream;
import org.jdom2.CDATA;
import org.jdom2.Comment;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


public class Room {

    private String userName;
    private String roomName;
    private String roomStyle;
    private Document roomXml;


    public Room(String roomName,String userName,String roomStyle){

        this.roomName = roomName;
        this.userName = userName;
        this.roomStyle = roomStyle;
    }

    public void createRoom() throws IOException{

        // Creating xml chatroom document
        this.roomXml = new Document();

        this.roomXml.setRootElement(new Element("ROOM"));

        // Creating the basic room information elements
        Element roomName = new Element("NAME");
        roomName.setText(this.roomName);

        Element roomStyle = new Element("STYLE");
        roomStyle.setText(this.roomStyle);

        // Creating user data holder
        Element userNames = new Element("USERS");
        Element user = new Element(this.userName);
        userNames.addContent(user);

        // Creating messages holder

        Element mess = new Element("MESSAGES");

        Element head = new Element("HEAD");

        String[] testMessages = {"Sutton page rocks a lot","Connor stinks a lot"};

        for(String item: testMessages){

            Element m = new Element(this.userName);
            m.setText(item);
            mess.addContent(m);
        }


        // Adding all elements to root element

        Element[] items = {roomName,userNames,mess,head};

        for(int i = 0; i < items.length; i++){

            this.roomXml.getRootElement().addContent(items[i]);
        }

        
        XMLOutputter xmlOutputter = new XMLOutputter();

        // pretty print
        xmlOutputter.setFormat(Format.getPrettyFormat());
        xmlOutputter.output(this.roomXml,System.out);

        
    }


    





    
}
