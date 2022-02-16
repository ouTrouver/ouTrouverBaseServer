package ouacheter.backend.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Magasin {
    @Id
    private Long id;
    @OneToMany
    private List<Asset> assetsList;

    public List<Asset> getAssetsList() {
        return assetsList;
    }

    public void setAssetsList(List<Asset> assetsList) {
        this.assetsList = assetsList;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
