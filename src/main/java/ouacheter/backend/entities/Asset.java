package ouacheter.backend.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Asset {
    @Id
    private int id;
    private String coordonates;
    private String name;
    @OneToOne
    private User owner;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCoordonates() {
        return coordonates;
    }

    public void setCoordonates(String coordonates) {
        this.coordonates = coordonates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public int getId() {
        return id;
    }
}
