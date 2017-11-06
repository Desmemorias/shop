package ua.imba.auth;

import org.apache.commons.lang3.StringUtils;
import ua.imba.auth.domain.ShopUser;
import ua.imba.auth.ejb.AuthenticationManager;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by tvgur on 02.08.2017.
 */
@Named
@SessionScoped
public class AuthBean implements Serializable {
    private ShopUser.Role role;
    private String login;
    private String password;
    private String mail;

    public String getMail() { return mail; }

    public void setMail(String mail) {this.mail = mail; }

    ShopUser.Role getRole() {
        return role;
    }

    private String requestedPage;

    public String getRequestedPage() {
        return requestedPage;
    }

    void setRequestedPage(String requestedPage) {
        this.requestedPage = requestedPage;
    }

    @EJB
    private AuthenticationManager authenticationManager;

    public ShopUser.Role isLoggedIn() {
        return role;
    }

    public void setRole(ShopUser.Role role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public void doLogin() throws IOException {

        if (StringUtils.isEmpty(login) || StringUtils.isEmpty(password)) {
            return;
        }
    role = authenticationManager.login(login, password);
        if(role!=null){
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        }
        else {

        }

    }

    public void doRegister() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("Registration.xhtml");

    }
  public void relocate(){
      try {
          FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
      } catch (IOException e) {
          e.printStackTrace();
      }
  }
}

