package ouacheter.backend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ouacheter.backend.entities.Message;
import ouacheter.backend.entities.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop,Integer> {
}
