package smartenrol.model;

import java.sql.Timestamp;

/**
 * This is the entity class for generic user.
 * @author Haijun
 */
public class User {
    private int idUser; 
    private String givenName;
    private String surname; 
    private String username; 
    private String password; 
    private String phone; 
    private String addr1;
    private String addr2; 
    private String postCode; 
    private String city; 
    private Timestamp lastModified; 
    private Timestamp dataCreated; 
    private int lastModby; 
    
    public User() {
    }

    public int getIdUser() {
        return idUser;
    }
    
    public String getName() {
        return this.givenName + this.surname;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddr1() {
        return addr1;
    }

    public String getAddr2() {
        return addr2;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCity() {
        return city;
    }

    public Timestamp getLastModified() {
        return lastModified;
    }

    public Timestamp getDataCreated() {
        return dataCreated;
    }

    public int getLastModby() {
        return lastModby;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }

    public void setDataCreated(Timestamp dataCreated) {
        this.dataCreated = dataCreated;
    }

    public void setLastModby(int lastModby) {
        this.lastModby = lastModby;
    }
    

}
