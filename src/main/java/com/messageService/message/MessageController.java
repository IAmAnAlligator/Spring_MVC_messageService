package com.messageService.message;

import com.messageService.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MessageController {

    @Autowired
    private MessageServiceImpl messageServiceImpl;

    private final User user = new User();

    @RequestMapping("/")
    public String signInPage(@ModelAttribute("userRegInfo") User user) {
        return "signIn";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("message") Message message,
                           @ModelAttribute("userRegInfo") User user) {

        this.user.setName(user.getName());

        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String indexPage(Model model) {
        Message message = new Message();
        model.addAttribute("message", message);
        model.addAttribute("messagesList", messageServiceImpl.getMessages());

        return "index";
    }

    @GetMapping("/deleteMessage")
    public String delete() {
        if (messageServiceImpl.getMessages().size() == 0) {
            return "redirect:/index";
        }

        messageServiceImpl.deleteMessage();
        return "redirect:/index";
    }

    @PostMapping("/saveMessage")
    public String save(@ModelAttribute("message") Message message) {

        if (message.getText().isEmpty()) {
            return "redirect:/index";
        }

        message.setSender(user.getName());
        messageServiceImpl.save(message);

        return "redirect:/index";
    }

    @GetMapping("/findMessages")
    public String find(Model model, @RequestParam(value = "sender", required = false) String sender) {
        if (sender.isBlank()) {
            return "redirect:/index";
        }

        model.addAttribute("foundMessagesList", messageServiceImpl.findMessagesBySender(sender));

        if (messageServiceImpl.findMessagesBySender(sender).size() == 0) {
            return "noResult";
        }

        return "result";
    }


}
