package ouacheter.backend.services;

import org.springframework.stereotype.Service;
import ouacheter.backend.entities.Asset;
import ouacheter.backend.entities.Asset;
import ouacheter.backend.entities.Message;
import ouacheter.backend.exceptions.AssetNotFoundException;
import ouacheter.backend.repositories.AssetRepository;
import ouacheter.backend.repositories.AssetRepository;

import java.util.List;

@Service
public class AssetService {

    private AssetRepository repository;

    public AssetService(AssetRepository AssetRepository) {
        this.repository = AssetRepository;
    }



    public List<Asset> all() {
        return repository.findAll();
    }

    public Asset newAsset(Asset newAsset) {
        return repository.save(newAsset);
    }


    public Asset one(int id) {

        return repository.findById(id)
                .orElseThrow(() -> new AssetNotFoundException(id));
    }

    public Asset replaceDescription(Asset newDescription, int id) {

        return repository.findById(id)
                .map(Asset -> {
                    Asset.setDescription(newDescription.getDescription());
                    return repository.save(Asset);
                })
                .orElseGet(() -> {
                    newDescription.setId(id);
                    return repository.save(newDescription);
                });
    }

    public void deleteAsset(int id) {
        repository.deleteById(id);
    }


}
