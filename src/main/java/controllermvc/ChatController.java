package controllermvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

  @GetMapping(path= "/chat", produces = "application/html")
  public String chat() {
      return "chat.html";
  }
}