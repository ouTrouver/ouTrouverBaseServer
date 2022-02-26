package ouacheter.backend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ouacheter.backend.entities.Asset;
import ouacheter.backend.entities.Asset;
import ouacheter.backend.services.AssetService;
import ouacheter.backend.services.AssetService;

import java.util.List;

@RestController
@RequestMapping("/Asset")
public class AssetController {
    private final AssetService AssetService;

    public AssetController(AssetService AssetService) {
        this.AssetService = AssetService;
    }



    @GetMapping("/all")
    public ResponseEntity<List<Asset>> getAllAssets () {
        List<Asset> Assets = AssetService.findAllAssets();
        return new ResponseEntity<>(Assets, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Asset> getAssetById (@PathVariable("id") int id) {
        Asset Asset = AssetService.findAssetById(id);
        return new ResponseEntity<>(Asset, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Asset> addAsset(@RequestBody Asset Asset) {
        Asset newAsset = AssetService.addAsset(Asset);
        return new ResponseEntity<>(newAsset, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Asset> updateAsset(@RequestBody Asset Asset) {
        Asset updateAsset = AssetService.updateAsset(Asset);
        return new ResponseEntity<>(updateAsset, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAsset(@PathVariable("id") int id) {
        AssetService.deleteAsset(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
