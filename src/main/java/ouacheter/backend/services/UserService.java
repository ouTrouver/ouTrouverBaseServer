package ouacheter.backend.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ouacheter.backend.entities.User;
import ouacheter.backend.exceptions.UserNotFoundException;
import ouacheter.backend.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    private UserRepository UserRepository;
    @Autowired
    public UserService(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }


    public User addUser(User User) {
        // Verif si le l'adresse Mail est deja disponible ou non
        User stamp  = UserRepository.findByEmail(User.getEmail());
        if(stamp != null ){
            return null;
        }
        else
        return UserRepository.save(User);
    }

    public List<User> findAllUsers() {
        return UserRepository.findAll();
    }

    public User updateUser(User User) {
        System.out.println("id = "+User.getId());
       User u = UserRepository.findById(User.getId()).get();
        System.out.println("id = "+u.getPassword());
       User.setPassword(u.getPassword());
        User.setRegistredDate(u.getRegistredDate());

        return UserRepository.save(User);
    }
    public User getUserByMail(User User) {
       return UserRepository.findByEmail(User.getEmail());
    }
    public User findUserById(int id) {
        return UserRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public void deleteUser(int id){
        UserRepository.deleteById(id);
    }

    public Boolean findUserByLog(User tested){
        User u = UserRepository.findUserByLog(tested.getEmail(),tested.getPassword());
        if(u == null) {
          //  System.out.println(u.toString());
            return false;
        }

        else {
            System.out.println(u.toString());
            return true;
        }
    }

    public void updateResetPasswordToken(String token, String email) throws UserNotFoundException {
        User User = UserRepository.findByEmail(email);
        if (User != null) {
            User.setResetPasswordToken(token);
            UserRepository.save(User);
        } else {
            throw new UserNotFoundException("Could not find any User with the email " + email);
        }
    }

    public User getByResetPasswordToken(String token) {
        return UserRepository.findByResetPasswordToken(token);
    }

    public void updatePassword(User User, String newPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        User.setPassword(encodedPassword);

        User.setResetPasswordToken(null);
        UserRepository.save(User);
    }





}
