package ouacheter.backend.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ouacheter.backend.entities.Message;
import ouacheter.backend.entities.Message;
import ouacheter.backend.services.MessageService;
import ouacheter.backend.services.MessageService;

import java.util.List;

@RestController
@RequestMapping("/Message")
public class MessageController {
    private final MessageService MessageService;

    public MessageController(MessageService MessageService) {
        this.MessageService = MessageService;
    }



    @GetMapping("/all")
    public ResponseEntity<List<Message>> getAllMessages () {
        List<Message> Messages = MessageService.findAllMessages();
        return new ResponseEntity<>(Messages, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Message> getMessageById (@PathVariable("id") int id) {
        Message Message = MessageService.findMessageById(id);
        return new ResponseEntity<>(Message, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Message> addMessage(@RequestBody Message Message) {
        Message newMessage = MessageService.addMessage(Message);
        return new ResponseEntity<>(newMessage, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Message> updateMessage(@RequestBody Message Message) {
        Message updateMessage = MessageService.updateMessage(Message);
        return new ResponseEntity<>(updateMessage, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMessage(@PathVariable("id") int id) {
        MessageService.deleteMessage(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
