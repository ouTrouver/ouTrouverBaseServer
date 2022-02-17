package ouacheter.backend.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class Shop {
    @Id
    private Long id;
    @OneToMany
    private List<Asset> assetsList;
    @OneToOne
    private User owner;

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

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
