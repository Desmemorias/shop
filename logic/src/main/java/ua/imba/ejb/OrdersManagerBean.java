package ua.imba.ejb;

import ua.imba.domain.Item;
import ua.imba.domain.ItemInOrder;
import ua.imba.domain.Order;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tvgur on 28.07.2017.
 */
@Stateless
@LocalBean
public class OrdersManagerBean {
    @PersistenceContext(unitName = "examplePU")
    private EntityManager entityManager;

    public Order createOrder ()
    {
    Order order = new Order();
    entityManager.persist(order);
    return order;
    }



public boolean addToOrder(long itemId, long orderId, int quantity){
    Item item = entityManager.find(Item.class, itemId);
            if(item==null){return false;}
    Order order = entityManager.find(Order.class, orderId);
    if(order==null){return false;}

    ItemInOrder itemInOrder = new ItemInOrder();
    itemInOrder.setOrder(order);
    itemInOrder.setItem(item);
    itemInOrder.setQuantity(quantity);
    entityManager.persist(itemInOrder);

    return true;

}
    public boolean RemoveFromOrder(long itemId, long orderId, int quantity){
        Item item = entityManager.find(Item.class, itemId);
        if(item==null){return false;}
        Order order = entityManager.find(Order.class, orderId);
        if(order==null){return false;}

        ItemInOrder itemInOrder = new ItemInOrder();
        itemInOrder.setOrder(order);
        itemInOrder.setItem(item);
        itemInOrder.setQuantity(quantity);
        entityManager.remove(itemInOrder);
        return true;
    }


public List<Item> getItemsInOrder(long orderId)
{
    Order order = entityManager.find(Order.class, orderId);
    if(order==null){return Collections.emptyList();}
    List<ItemInOrder> itemsInOrders = order.getItemInOrders();
    List<Item> result = new ArrayList<>();
    for(ItemInOrder itemInOrder: itemsInOrders){result.add(itemInOrder.getItem());
    }
return result;
}


}
