package ouacheter.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ouacheter.backend.entities.Asset;
import ouacheter.backend.entities.Asset;
import ouacheter.backend.entities.Message;
import ouacheter.backend.entities.Asset;
import ouacheter.backend.exceptions.AssetNotFoundException;
import ouacheter.backend.exceptions.AssetNotFoundException;
import ouacheter.backend.repositories.AssetRepository;
import ouacheter.backend.repositories.AssetRepository;
import ouacheter.backend.repositories.AssetRepository;

import java.util.List;
@Service
public class AssetService {
    private ouacheter.backend.repositories.AssetRepository AssetRepository;
    @Autowired
    public AssetService(AssetRepository AssetRepository) {
        this.AssetRepository = AssetRepository;
    }

    public Asset addAsset(Asset Asset) {
        return AssetRepository.save(Asset);
    }

    public List<Asset> findAllAssets() {
        return AssetRepository.findAll();
    }

    public Asset updateAsset(Asset Asset) {
        return AssetRepository.save(Asset);
    }

    public Asset findAssetById(int id) {
        return AssetRepository.findById(id)
                .orElseThrow(() -> new AssetNotFoundException(id));
    }

    public void deleteAsset(int id){
        AssetRepository.deleteById(id);
    }






}