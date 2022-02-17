package ouacheter.backend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ouacheter.backend.entities.Message;

@Repository
public interface MessageRepository  extends JpaRepository<Message,Integer> {
}
