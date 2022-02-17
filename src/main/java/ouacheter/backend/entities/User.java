package ouacheter.backend.entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    private String name;
    private String role;
    @CreationTimestamp
    private Timestamp registredDate;
    private String password;
    private String email;

    public User(int id, String name, String role, Timestamp registredDate, String password, String email) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.registredDate = registredDate;
        this.password = password;
        this.email = email;
    }

    public User(String name, String role, Timestamp registredDate, String password, String email) {
        this.name = name;
        this.role = role;
        this.registredDate = registredDate;
        this.password = password;
        this.email = email;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getRegistredDate() {
        return registredDate;
    }

    public void setRegistredDate(Timestamp registredDate) {
        this.registredDate = registredDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() && Objects.equals(getName(), user.getName()) && Objects.equals(getRole(), user.getRole()) && Objects.equals(getRegistredDate(), user.getRegistredDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getRole(), getRegistredDate());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", registredDate=" + registredDate +
                '}';
    }


}
