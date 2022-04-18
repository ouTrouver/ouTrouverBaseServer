package ouacheter.backend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ouacheter.backend.entities.Shop;
import ouacheter.backend.entities.Shop;
import ouacheter.backend.services.ShopService;
import ouacheter.backend.services.ShopService;

import java.util.List;
@RestController
@RequestMapping("/Shop")
public class ShopController {
    private final ShopService ShopService;

    public ShopController(ShopService ShopService) {
        this.ShopService = ShopService;
    }



    @GetMapping("/all")
    public ResponseEntity<List<Shop>> getAllShops () {
        List<Shop> Shops = ShopService.findAllShops();
        return new ResponseEntity<>(Shops, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Shop> getShopById (@PathVariable("id") int id) {
        Shop Shop = ShopService.findShopById(id);
        return new ResponseEntity<>(Shop, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Shop> addShop(@RequestBody Shop Shop) {
        Shop newShop = ShopService.addShop(Shop);
        return new ResponseEntity<>(newShop, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Shop> updateShop(@RequestBody Shop Shop) {
        Shop updateShop = ShopService.updateShop(Shop);
        return new ResponseEntity<>(updateShop, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteShop(@PathVariable("id") int id) {
        ShopService.deleteShop(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
