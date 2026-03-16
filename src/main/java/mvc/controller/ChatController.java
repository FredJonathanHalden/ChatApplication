package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class ChatController {

    private final ArrayList<String> messages = new ArrayList<>();

  @GetMapping(path= "/chat", produces = "application/html")
  public String chat() {
      return "chat.html";
  }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    @ResponseBody
    public String submit(@ModelAttribute("message") String message) {
        if (messages.size() == 10) {
            messages.remove(0);
        }

        messages.add(message);
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
                "<p>" +
                "Användare skrev: " +
                "</p>" +
                "<p>" +
                messages +
                "</p>" +
                "</article>" +
                "<form action=\"/submit\" method=\"post\">" +
                "<input type=\"text\" name=\"message\" value=\"Skriv din text här\" checked>" +
                "<input type=\"submit\" value=\"Skicka\">" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}