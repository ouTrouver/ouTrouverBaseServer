package ouacheter.backend.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ouacheter.backend.entities.Message;
import ouacheter.backend.entities.Message;
import ouacheter.backend.exceptions.MessageNotFoundException;
import ouacheter.backend.exceptions.MessageNotFoundException;
import ouacheter.backend.repositories.MessageRepository;

import java.util.List;
@Service
public class MessageService {
    private ouacheter.backend.repositories.MessageRepository MessageRepository;
    @Autowired
    public MessageService(MessageRepository MessageRepository) {
        this.MessageRepository = MessageRepository;
    }

    public Message addMessage(Message Message) {
        return MessageRepository.save(Message);
    }

    public List<Message> findAllMessages() {
        return MessageRepository.findAll();
    }

    public Message updateMessage(Message Message) {
        return MessageRepository.save(Message);
    }

    public Message findMessageById(int id) {
        return MessageRepository.findById(id)
                .orElseThrow(() -> new MessageNotFoundException(id));
    }

    public void deleteMessage(int id){
        MessageRepository.deleteById(id);
    }






}