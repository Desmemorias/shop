package ua.imba.auth.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

/**
 * Created by tvgur on 02.08.2017.
 */
@Entity
public class Credentials {
    @Id
    private String email;
    private String password;

    @OneToOne(mappedBy = "credentials")
    private ShopUser shopUser;

    public ShopUser getShopUser() {
        return shopUser;
    }

    public void setShopUser(ShopUser shopUser) {
        this.shopUser = shopUser;
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

}
