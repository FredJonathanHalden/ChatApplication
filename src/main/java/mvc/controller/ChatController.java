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

        int y = 30 + 30 * messages.getNumberOfMessages();
        return "<!DOCTYPE html>" +
                "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:th=\"http://www.w3.org/1999/xhtml\">" +
                "<head>" +
                "<link href=\"../../css/chat.css\" th:href=\"@{/css/chat.css}\" rel=\"stylesheet\" type=\"text/css\">" +
                "<meta charset=\"UTF-8\">" +
                "<title>" +
                "Chattapplikation" +
                "</title>" +
                "</head>" +
                "<body>" +
                "<h2>" +
                "Chattapplikation" +
                "</h2>" +
                "<svg xmlns=\"http://www.w3.org/2000/svg\">" +
                "<rect/>" +
                messages.toHtmlSvgTextString() +
                "<circle cx=\"30\" cy=\"" + y + "\" r=\"1\" style=\"fill:black;\">\n" +
                "</circle>\n" +
                "<circle cx=\"35\" cy=\"" + y + "\" r=\"1\" style=\"fill:black;\">\n" +
                "</circle>\n" +
                "<circle class=\"dot\" cx=\"40\" cy=\"" + y + "\" r=\"1\">\n" +
                "<animate attributeName=\"fill\" values=\"black;white;black\" dur=\"2s\" repeatCount=\"indefinite\" />\n" +
                "</circle>" +
                "</svg>" +
                "<form action=\"/submit\" method=\"post\">" +
                "<label>" +
                "Namn: " +
                "<br/>" +
                "<input type=\"text\" name=\"senderName\" value=" + senderName + ">" +
                "</label>" +
                "<br/>" +
                "<label for=\"message\">" +
                "Meddelande: " +
                "<br/>" +
                "</label>" +
                "<textarea id=\"message\" name=\"message\"></textarea>" +
                "<input type=\"submit\" value=\"Skicka\">" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}