package mvc.controller;

import mvc.model.Message;
import mvc.model.Messages;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ChatController {

    private final Messages messages = new Messages();

  @GetMapping(path= "/chat", produces = "application/html")
  public String chat() {
      return "chat.html";
  }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    @ResponseBody
    public String submit(@ModelAttribute("senderName") String senderName, @ModelAttribute("message") String sentMessage) {
        messages.add(new Message(senderName, sentMessage));
        StringBuilder messagesString = new StringBuilder();
        for (Message message : messages.getMessages()) {
            messagesString.append("<p>").append(message.toString()).append("</p>\n");
        }

        return "<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<html>" +
                "<head>" +
                "<meta charset=\"UTF-8\">" +
                "<title>" +
                "Chattapplikation" +
                "</title>" +
                "</head>" +
                "<body>" +
                "<h2>" +
                "Chattapplikation" +
                "</h2>" +
                "<article>" +
                messagesString +
                "</article>" +
                "<form action=\"/submit\" method=\"post\">" +
                "<input type=\"text\" name=\"senderName\" value=\" Skriv ditt namn här\" checked>" +
                "<input type=\"text\" name=\"message\" value=\"Skriv din text här\" checked>" +
                "<input type=\"submit\" value=\"Skicka\">" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}