package ouacheter.backend.services;

import org.springframework.stereotype.Service;
import ouacheter.backend.entities.Asset;
import ouacheter.backend.entities.Shop;
import ouacheter.backend.exceptions.ShopNotFoundException;
import ouacheter.backend.repositories.ShopRepository;

import java.util.List;

@Service
public class ShopService {

    private ShopRepository repository;

    public ShopService(ShopRepository ShopRepository) {
        this.repository = ShopRepository;
    }



    public List<Shop> all() {
        return repository.findAll();
    }

    public Shop newShop(Shop newShop) {
        return repository.save(newShop);
    }


    public Shop one(int id) {

        return repository.findById(id)
                .orElseThrow(() -> new ShopNotFoundException(id));
    }
    public Shop replaceDescription(Shop newDescription, int id) {

        return repository.findById(id)
                .map(Shop -> {
                    Shop.setDescription(newDescription.getDescription());
                    return repository.save(Shop);
                })
                .orElseGet(() -> {
                    newDescription.setId(id);
                    return repository.save(newDescription);
                });
    }

    public void deleteShop(int id) {
        repository.deleteById(id);
    }


}
