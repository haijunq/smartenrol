package smartenrol.model;

import org.joda.time.DateTime;

/**
 * This is the entity class for generic user.
 * @author Haijun
 */

public class User{

    protected Integer idUser;
    protected String givenName;
    protected String surname;
    private String username;
    private String password;
    protected String usertype;
    private String phone;
    private String addr1;
    private String addr2;
    private String postalCode;
    private String city;
    private DateTime lastModified;
    private DateTime dateCreated;
    private Integer lastModBy;
    private String email;
    private String country;
    private String province;
    
    public enum Type { STUDENT, INSTRUCTOR, ADMINISTRATOR, USER };
    
    public User() {
        this.idUser = 0;
        this.givenName = "";
        this.surname = "";
        this.username = "";
        this.password = "";
        this.usertype = "Student";
    }
    
    public User(Integer idUser) {
        this.idUser = idUser;
    }

    public User(Integer idUser, String givenName, String surname, String username, String password, String usertype) {
        this.idUser = idUser;
        this.givenName = givenName;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.usertype = usertype;
    }

    public User(Integer idUser, String givenName, String surname) {
        this.idUser = idUser;
        this.givenName = givenName;
        this.surname = surname;
    }

    public User(Integer idUser, String givenName, String surname, String usertype) {
        this.idUser = idUser;
        this.givenName = givenName;
        this.surname = surname;
        this.usertype = usertype;
    }

    
    
    public String getFullName() {
        return givenName + " " + surname;
    }
    
    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Type getUsertype() {
        switch (this.usertype) {
            case "Instructor":
                return Type.INSTRUCTOR;
            case "Administrator":
                return Type.ADMINISTRATOR;
            case "Student":
                return Type.STUDENT;
            default:
                return Type.USER;
        }
    }
    
    public boolean isStudent()
    {
        return (this.usertype.equalsIgnoreCase("student"));
    }
    
    public boolean isAdministrator()
    {
        return (this.usertype.equalsIgnoreCase("administrator"));
    }
    
    
    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public DateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(DateTime lastModified) {
        this.lastModified = lastModified;
    }

    public DateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(DateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Integer getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(Integer lastModBy) {
        this.lastModBy = lastModBy;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smartenrol.model.User[ idUser=" + idUser + " ]";
    }
    

}
