import org.junit.Assert;
import org.junit.Test;
import ua.imba.domain.Item;
import ua.imba.ejb.ItemsManagerBean;


public class test_ItemsManagerBean{
   private ItemsManagerBean itemsManagerBean;
   private Item expected;
   private Item real;




    @Test
    public void test_createItem(){
       ItemsManagerBean itemsManagerBean = new ItemsManagerBean();
       expected = new Item();
       Item real = itemsManagerBean.createItem("99", 66);
       Assert.assertEquals(expected.getClass(), real.getClass());

    }
}
