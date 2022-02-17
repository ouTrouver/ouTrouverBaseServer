package ouacheter.backend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ouacheter.backend.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
