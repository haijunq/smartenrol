package smartenrol.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This is the entity class for generic user.
 * @author Haijun
 */
@Entity
@Table(name = "User")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByIdUser", query = "SELECT u FROM User u WHERE u.idUser = :idUser"),
    @NamedQuery(name = "User.findByGivenName", query = "SELECT u FROM User u WHERE u.givenName = :givenName"),
    @NamedQuery(name = "User.findBySurname", query = "SELECT u FROM User u WHERE u.surname = :surname"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByUsertype", query = "SELECT u FROM User u WHERE u.usertype = :usertype"),
    @NamedQuery(name = "User.findByPhone", query = "SELECT u FROM User u WHERE u.phone = :phone"),
    @NamedQuery(name = "User.findByAddr1", query = "SELECT u FROM User u WHERE u.addr1 = :addr1"),
    @NamedQuery(name = "User.findByAddr2", query = "SELECT u FROM User u WHERE u.addr2 = :addr2"),
    @NamedQuery(name = "User.findByPostalCode", query = "SELECT u FROM User u WHERE u.postalCode = :postalCode"),
    @NamedQuery(name = "User.findByCity", query = "SELECT u FROM User u WHERE u.city = :city"),
    @NamedQuery(name = "User.findByLastModified", query = "SELECT u FROM User u WHERE u.lastModified = :lastModified"),
    @NamedQuery(name = "User.findByDateCreated", query = "SELECT u FROM User u WHERE u.dateCreated = :dateCreated"),
    @NamedQuery(name = "User.findByLastModBy", query = "SELECT u FROM User u WHERE u.lastModBy = :lastModBy"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByCountry", query = "SELECT u FROM User u WHERE u.country = :country"),
    @NamedQuery(name = "User.findByProvince", query = "SELECT u FROM User u WHERE u.province = :province")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUser")
    protected Integer idUser;
    @Basic(optional = false)
    @Column(name = "givenName")
    protected String givenName;
    @Basic(optional = false)
    @Column(name = "surname")
    protected String surname;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "usertype")
    protected String usertype;
    @Column(name = "phone")
    private String phone;
    @Column(name = "addr1")
    private String addr1;
    @Column(name = "addr2")
    private String addr2;
    @Column(name = "postalCode")
    private String postalCode;
    @Column(name = "city")
    private String city;
    @Column(name = "lastModified")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp lastModified;
    @Column(name = "dateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp dateCreated;
    @Column(name = "lastModBy")
    private Integer lastModBy;
    @Column(name = "email")
    private String email;
    @Column(name = "country")
    private String country;
    @Column(name = "province")
    private String province;
    
    public enum Type { STUDENT, INSTRUCTOR, ADMINISTRATOR, USER };
    
    public User() {
        
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

    public Timestamp getLastModified() {
        return lastModified;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
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
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
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
