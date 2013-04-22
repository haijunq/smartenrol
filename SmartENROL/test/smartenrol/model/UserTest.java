/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aishwarya
 */
public class UserTest {

    @Test
    public void testGetIdUser() {
        User instance = new User();
        assertNull(instance.getIdUser());
    }

    @Test
    public void testSetIdUser() {
        Integer idUser = Integer.SIZE;
        User instance = new User();
        instance.setIdUser(idUser);
        assertEquals(idUser, instance.getIdUser());
    }

    @Test
    public void testGetGivenName() {
        User instance = new User();
        assertNull(instance.getGivenName());
    }

    @Test
    public void testSetGivenName() {
        String givenName = "sample test";
        User instance = new User();
        instance.setGivenName(givenName);
        assertEquals(givenName, instance.getGivenName());
    }

    @Test
    public void testGetSurname() {
        User instance = new User();
        assertNull(instance.getSurname());
    }

    @Test
    public void testSetSurname() {
        String surname = "sample name";
        User instance = new User();
        instance.setSurname(surname);
        assertEquals(surname, instance.getSurname());
    }

    @Test
    public void testGetUsername() {
        User instance = new User();
        assertNull(instance.getUsername());
    }

    @Test
    public void testSetUsername() {
        String username = "Hi User";
        User instance = new User();
        instance.setUsername(username);
        assertEquals(username, instance.getUsername());
    }

    @Test
    public void testGetPassword() {
        User instance = new User();
        assertNull(instance.getPassword());
    }

    @Test
    public void testSetPassword() {
        String password = "password";
        User instance = new User();
        instance.setPassword(password);
        assertEquals(password, instance.getPassword());
    }

    @Test
    public void testSetUsertype() {
        String usertype = "Instructor";
        User instance = new User();
        instance.setUsertype(usertype);
        assertNotNull(instance.getUsertype());
    }

    @Test
    public void testGetPhone() {
        User instance = new User();
        assertNull(instance.getPhone());
    }

    @Test
    public void testSetPhone() {
        String phone = "1234567890";
        User instance = new User();
        instance.setPhone(phone);
        assertEquals(phone, instance.getPhone());
    }

    @Test
    public void testGetAddr1() {
        User instance = new User();
        assertNull(instance.getAddr1());
    }

    @Test
    public void testSetAddr1() {
        String addr1 = "Address 1";
        User instance = new User();
        instance.setAddr1(addr1);
        assertEquals(addr1, instance.getAddr1());
    }

    @Test
    public void testGetAddr2() {
        User instance = new User();
        assertNull(instance.getAddr2());
    }

    @Test
    public void testSetAddr2() {
        String addr2 = "Address 2";
        User instance = new User();
        instance.setAddr2(addr2);
        assertEquals(addr2, instance.getAddr2());
    }

    @Test
    public void testGetPostalCode() {
        User instance = new User();
        assertNull(instance.getPostalCode());
    }

    @Test
    public void testSetPostalCode() {
        String postalCode = "postalCode";
        User instance = new User();
        instance.setPostalCode(postalCode);
        assertEquals(postalCode, instance.getPostalCode());
    }

    @Test
    public void testGetCity() {
        User instance = new User();
        assertNull(instance.getCity());
    }

    @Test
    public void testSetCity() {
        String city = "city";
        User instance = new User();
        instance.setCity(city);
        assertEquals(city, instance.getCity());
    }

    @Test
    public void testGetLastModified() {
        User instance = new User();
        assertNull(instance.getLastModified());
    }

    @Test
    public void testGetDateCreated() {
        User instance = new User();
        assertNull(instance.getDateCreated());
    }

    @Test
    public void testGetLastModBy() {
        User instance = new User();
        assertNull(instance.getLastModBy());
    }

    @Test
    public void testGetEmail() {
        User instance = new User();
        assertNull(instance.getEmail());
    }

    @Test
    public void testSetEmail() {
        String email = "sample@sample.com";
        User instance = new User();
        instance.setEmail(email);
        assertEquals(email, instance.getEmail());
    }

    @Test
    public void testGetCountry() {
        User instance = new User();
        assertNull(instance.getCountry());
    }

    @Test
    public void testSetCountry() {
        String country = "Country";
        User instance = new User();
        instance.setCountry(country);
        assertEquals(country, instance.getCountry());
    }

    @Test
    public void testGetProvince() {
        User instance = new User();
        assertNull(instance.getProvince());
    }

    @Test
    public void testSetProvince() {
        String province = "province";
        User instance = new User();
        instance.setProvince(province);
        assertEquals(province, instance.getProvince());
    }

    @Test
    public void testHashCode() {
        User instance = new User();
        assertNotNull(instance.hashCode());
    }

    @Test
    public void testToString() {
        User instance = new User();
        instance.setIdUser(Integer.SIZE);
        String expResult = "smartenrol.model.User[ idUser=32 ]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}