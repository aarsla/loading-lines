package com.simpastudio.loading.lines.controller;

import com.simpastudio.loading.lines.data.model.Message;
import com.simpastudio.loading.lines.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class MessageController {

    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/message")
    @ResponseBody
    public Message message() {
        return messageService.getMessage();
    }

    @GetMapping("/message/{n}")
    @ResponseBody()
    public Map<String, List<String>> messages(@PathVariable("n") Integer n) {
        List<Message> messages = messageService.getMessages(n <= 50 ? n : 50);

        return new HashMap<String, List<String>>() {{
            put("messages", messages.stream().map(Message::getMessage).collect(Collectors.toList()));
        }};
    }

    @GetMapping("/message/short")
    @ResponseBody
    public Message shortMessage() {
        return messageService.getShortMessage();
    }

    @GetMapping("/message/short/{n}")
    @ResponseBody()
    public Map<String, List<String>> shortMessages(@PathVariable("n") Integer n) {
        List<Message> messages = messageService.getShortMessages(n <= 50 ? n : 50);

        return new HashMap<String, List<String>>() {{
            put("messages", messages.stream().map(Message::getMessage).collect(Collectors.toList()));
        }};
    }

    @GetMapping("/sim")
    @ResponseBody
    public Message simCityMessage() {
        return messageService.getSimCityMessage();
    }

    @GetMapping("/sim/{n}")
    @ResponseBody()
    public Map<String, List<String>> simCityMessages(@PathVariable("n") Integer n) {
        List<Message> messages = messageService.getSimCityMessages(n <= 50 ? n : 50);

        return new HashMap<String, List<String>>() {{
            put("messages", messages.stream().map(Message::getMessage).collect(Collectors.toList()));
        }};
    }
}
