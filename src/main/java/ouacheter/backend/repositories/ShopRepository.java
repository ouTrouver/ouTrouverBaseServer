package ouacheter.backend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ouacheter.backend.entities.Message;
import ouacheter.backend.entities.Shop;
import ouacheter.backend.entities.User;

import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop,Integer> {
    @Query(
            value = "SELECT * FROM starto.shop u WHERE u.owner_id = ?1",nativeQuery = true)
    List<Shop> getShopsByUser(int id);

}
