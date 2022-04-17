package ouacheter.backend.entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    @CreationTimestamp
    private Timestamp registredDate;
    private String password;
    private String email;
    @Column(name = "reset_password_token")
    private String resetPasswordToken;
    private String phoneNumber;
    private String adress;
    private String website;
    private String instagram;
    public User(String email) {
        this.email = email;
    }

    public User() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumer(String phoneNumer) {
        this.phoneNumber = phoneNumer;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
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


    public Timestamp getRegistredDate() {
        return registredDate;
    }

    public void setRegistredDate(Timestamp registredDate) {
        this.registredDate = registredDate;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", registredDate=" + registredDate +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", resetPasswordToken='" + resetPasswordToken + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", adress='" + adress + '\'' +
                ", website='" + website + '\'' +
                ", instagram='" + instagram + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() && Objects.equals(getFirstname(), user.getFirstname()) && Objects.equals(getLastname(), user.getLastname()) && Objects.equals(getRegistredDate(), user.getRegistredDate()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getResetPasswordToken(), user.getResetPasswordToken()) && Objects.equals(getPhoneNumber(), user.getPhoneNumber()) && Objects.equals(getAdress(), user.getAdress()) && Objects.equals(getWebsite(), user.getWebsite()) && Objects.equals(getInstagram(), user.getInstagram());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstname(), getLastname(), getRegistredDate(), getPassword(), getEmail(), getResetPasswordToken(), getPhoneNumber(), getAdress(), getWebsite(), getInstagram());
    }
}

