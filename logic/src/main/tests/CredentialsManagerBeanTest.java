import org.junit.jupiter.api.Test;
import ua.imba.ejb.CredentialsManagerBean;


class CredentialsManagerBeanTest  {

    @Test
    public void test_createCredentials(){
        CredentialsManagerBean credentialsManagerBean = new CredentialsManagerBean();
        credentialsManagerBean.createCredentials("TestMail", "Test Password");
    }

}
