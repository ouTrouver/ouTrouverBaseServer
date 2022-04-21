package ouacheter.backend.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany
    private List<Asset> assetsList;
    @OneToOne
    private User owner;
    private String shop_name;
    private float latitude;
    private float longitude;
    private String description;

    public String getShop_name() {
        return shop_name;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public void setId(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }
}
