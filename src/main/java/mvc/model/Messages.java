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
}
