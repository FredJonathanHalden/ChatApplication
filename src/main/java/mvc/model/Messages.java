package mvc.model;

import java.util.ArrayList;

public class Messages {

    private final ArrayList<Message> messages;

    public Messages() {
        messages = new ArrayList<>();
    }

    public void add(Message message) {
        if (messages.size() == 10) {
            messages.remove(0);
        }

        messages.add(message);
    }

    public void remove() {
        messages.remove(0);
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Message message : messages) {
            result.append(message.toString()).append(",\n");
        }
        return result.toString();
    }

    public int getNumberOfMessages() {
        return messages.size();
    }

    public String toHtmlSvgTextString() {
        StringBuilder messagesString = new StringBuilder();
        if (messages.size() > 1) {
            int y = 30;
            for (Message message : messages) {
                messagesString.append("<text x=\"30px\" y=\"").append(y).append("px\">");
                messagesString.append(message.toString());
                messagesString.append("</text>");
                y += 30;
            }
        } else {
            messagesString.append("<text x=\"30px\" y=\"30px\">");
            messagesString.append(messages.get(0).toString());
            messagesString.append("</text>");
        }
        return messagesString.toString();
    }
}
