package ua.imba.auth;

import ua.imba.ejb.CredentialsManagerBean;
import ua.imba.ejb.ItemsManagerBean;
import ua.imba.ejb.OrdersManagerBean;

import javax.ejb.EJB;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class CredentialsBean implements Serializable {

    private String email;
    private String password;

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

    @EJB
    private OrdersManagerBean ordersManagerBean;

    @EJB
    private ItemsManagerBean itemsManagerBean;
    @EJB
    private CredentialsManagerBean credentialsManagerBean;

    public void createCredentials() {
        credentialsManagerBean.createCredentials(email, password);
    }

}
