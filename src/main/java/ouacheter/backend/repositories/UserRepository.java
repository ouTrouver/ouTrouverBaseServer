package ouacheter.backend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ouacheter.backend.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(
            value = "SELECT * FROM starto.user u WHERE u.email = ?1 and u.password = ?2",
            nativeQuery = true)
    User findUserByLog(String email, String password);

    @Query(value = "SELECT * FROM starto.user u WHERE u.email = ?1", nativeQuery = true)
    User findByEmail(String email);

    public User findByResetPasswordToken(String token);

    @Query(value = "UPDATE starto.user u WHERE u.id = ?1 SET ", nativeQuery = true)
    User updateUser(int id);
}
