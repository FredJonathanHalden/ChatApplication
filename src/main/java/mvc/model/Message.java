package mvc.model;

import java.util.Date;

public class Message {

    private final Date sentDate = new Date();
    private final String userName;
    private final String message;

    public Message(String senderName, String sentMessage) {
        userName = senderName;
        message = sentMessage;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public String getUserName() {
        return userName;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return userName + " sent " + "[" + sentDate + "] " + message;
    }
}
