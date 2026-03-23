package mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import mvc.model.Message;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class ChatController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping(path="/chat", produces="application/html")
    public String chat(HttpServletRequest request, Model model) {
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        if (inputFlashMap != null) {
            String senderName = (String) inputFlashMap.get("senderName");
            model.addAttribute("senderName", senderName);
        } else {
            model.addAttribute("senderName", "Write your name here...");
        }
        return "chat.html";
    }

    @GetMapping(path="/chat-response", produces="application/html")
    public String chatResponse(Model model) {
        int y = 20;
        String htmlCode = "";
        for (Message foundMessage : messageRepository.findAll()) {
            htmlCode += "<p x=30 y=" + y + " style=\"max-width:100%;height:auto;\">" + foundMessage + "</p>";
            y += 20;
        }
        model.addAttribute("messages", htmlCode);

        return "chat-response.html";
    }

    @PostMapping(path="/add-message") // Map ONLY POST Requests
    public String addNewMessage (RedirectAttributes redirectAttributes, @ModelAttribute("senderName") String senderName, @ModelAttribute("text") String text) {
        redirectAttributes.addFlashAttribute("senderName", senderName);

        Message message = new Message();
        message.setSenderName(senderName);
        message.setText(text);
        messageRepository.save(message);

        return "redirect:/chat";
    }

    @GetMapping(path="/messages", produces = "application/json")
    public @ResponseBody Iterable<Message> getAllMessages() {
        // This returns a JSON or XML with the messages
        return messageRepository.findAll();
    }
}