package ouacheter.backend.services;


import org.springframework.stereotype.Service;
import ouacheter.backend.entities.User;
import ouacheter.backend.exceptions.UserNotFoundException;
import ouacheter.backend.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    private UserRepository repository;

    public UserService(UserRepository userRepository) {
        this.repository = userRepository;
    }



    public List<User> all() {
        return repository.findAll();
    }

    public User newUser(User newUser) {
        return repository.save(newUser);
    }


    public User one(int id) {

        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }


    public User replaceUser( User newUser, int id) {

        return repository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setRole(newUser.getRole());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });
    }


    public void deleteUser(int id) {
        repository.deleteById(id);
    }


}
