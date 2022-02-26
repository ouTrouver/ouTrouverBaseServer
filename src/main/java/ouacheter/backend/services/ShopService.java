package ouacheter.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ouacheter.backend.entities.Asset;
import ouacheter.backend.entities.Shop;
import ouacheter.backend.entities.Shop;
import ouacheter.backend.exceptions.ShopNotFoundException;
import ouacheter.backend.exceptions.ShopNotFoundException;
import ouacheter.backend.repositories.ShopRepository;
import ouacheter.backend.repositories.ShopRepository;

import java.util.List;
@Service
public class ShopService {
    private ouacheter.backend.repositories.ShopRepository ShopRepository;
    @Autowired
    public ShopService(ShopRepository ShopRepository) {
        this.ShopRepository = ShopRepository;
    }

    public Shop addShop(Shop Shop) {
        return ShopRepository.save(Shop);
    }

    public List<Shop> findAllShops() {
        return ShopRepository.findAll();
    }

    public Shop updateShop(Shop Shop) {
        return ShopRepository.save(Shop);
    }

    public Shop findShopById(int id) {
        return ShopRepository.findById(id)
                .orElseThrow(() -> new ShopNotFoundException(id));
    }

    public void deleteShop(int id){
        ShopRepository.deleteById(id);
    }






}
