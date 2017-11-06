package ua.imba.auth.ejb;

import org.apache.commons.lang3.StringUtils;
import ua.imba.auth.domain.Credentials;
import ua.imba.auth.domain.ShopUser;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by tvgur on 02.08.2017.
 */

@Stateless
@LocalBean
public class AuthenticationManager {

    @PersistenceContext(unitName = "examplePU")
    private EntityManager entityManager;


    public ShopUser.Role login(String email, String password){
        if(StringUtils.isEmpty(email) || StringUtils.isEmpty(password)) {
            return null;
        }

        Credentials credentials= entityManager.find(Credentials.class, email);
        if(credentials==null) {
            return null;
        }
        if(!password.equals(credentials.getPassword())){
            return null;
        }
        ShopUser shopUser = credentials.getShopUser();

        if(credentials.getShopUser() ==null){return null;}
        return shopUser.getRole();

    }

}
