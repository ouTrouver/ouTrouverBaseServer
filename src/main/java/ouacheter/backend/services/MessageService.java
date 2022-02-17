package ouacheter.backend.services;


import org.springframework.stereotype.Service;
import ouacheter.backend.entities.Message;
import ouacheter.backend.exceptions.MessageNotFoundException;
import ouacheter.backend.repositories.MessageRepository;

import java.util.List;

@Service
public class MessageService {
    private MessageRepository repository;

    public MessageService(MessageRepository messageRepository) {
        this.repository = messageRepository;
    }



    public List<Message> all() {
        return repository.findAll();
    }

    public Message newMessage(Message newMessage) {
        return repository.save(newMessage);
    }


    public Message one(int id) {

        return repository.findById(id)
                .orElseThrow(() -> new MessageNotFoundException(id));
    }


    public Message replaceMessage( Message newMessage, int id) {

        return repository.findById(id)
                .map(message -> {
                    message.setContent(newMessage.getContent());
                    return repository.save(message);
                })
                .orElseGet(() -> {
                    newMessage.setId(id);
                    return repository.save(newMessage);
                });
    }


    public void deleteMessage(int id) {
        repository.deleteById(id);
    }


}
