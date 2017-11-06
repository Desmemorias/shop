package ua.imba.ejb;

import ua.imba.auth.domain.Credentials;
import ua.imba.auth.domain.ShopUser;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.io.Serializable;
import static ua.imba.auth.domain.ShopUser.Role.*;

@Stateless
@LocalBean
@Named
public class CredentialsManagerBean implements Serializable {
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

    private String email;
    private String password;

    @PersistenceContext(unitName = "examplePU")
    private EntityManager entityManager;


public void createCredentials (String email, String password) {
    Credentials credentials = new Credentials();
    credentials.setEmail(email);
    credentials.setPassword(password);
    entityManager.persist(credentials);
    ShopUser shopUser = new ShopUser();
    shopUser.setName(email);
    shopUser.setRole(USER);
    shopUser.setCredentials(credentials);
    entityManager.persist(shopUser);


    try {
        FacesContext.getCurrentInstance().getExternalContext().redirect("sucess.xhtml");
    } catch (IOException e) {
        e.printStackTrace();
    }


}

}
