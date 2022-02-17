package ouacheter.backend.controllers;


import org.springframework.web.bind.annotation.*;
import ouacheter.backend.entities.Message;
import ouacheter.backend.services.MessageService;

import java.util.List;

@RestController
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }


    @GetMapping("/messages")
    List<Message> all() {
        return messageService.all();
    }
    @PostMapping("/messages")
    Message newMessage(@RequestBody Message newMessage) {
        return messageService.newMessage(newMessage);
    }

    // Single item

    @GetMapping("/message/{id}")
    Message one(@PathVariable int id) {

        return messageService.one(id);

    }

    @PutMapping("/message/{id}")
    Message replaceMessage(@RequestBody Message newMessage, @PathVariable int id) {

        return messageService.replaceMessage(newMessage,id);

    }

    @DeleteMapping("/message/{id}")
    void deleteMessage(@PathVariable int id) {
        messageService.deleteMessage(id);
    }
}
