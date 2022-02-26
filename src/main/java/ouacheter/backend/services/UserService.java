package ouacheter.backend.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ouacheter.backend.entities.User;
import ouacheter.backend.exceptions.UserNotFoundException;
import ouacheter.backend.repositories.UserRepository;


import java.util.List;

@Service
public class UserService {
    private UserRepository UserRepository;
    @Autowired
    public UserService(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    public User addUser(User User) {
        return UserRepository.save(User);
    }

    public List<User> findAllUsers() {
        return UserRepository.findAll();
    }

    public User updateUser(User User) {
        return UserRepository.save(User);
    }

    public User findUserById(int id) {
        return UserRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public void deleteUser(int id){
        UserRepository.deleteById(id);
    }






}
