package ua.imba;

import ua.imba.domain.Item;
import ua.imba.domain.ItemInOrder;
import ua.imba.domain.Order;
import ua.imba.ejb.CredentialsManagerBean;
import ua.imba.ejb.ItemsManagerBean;
import ua.imba.ejb.OrdersManagerBean;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * Created by tvgur on 28.07.2017.
 */
@Named
@SessionScoped
public class OrderBean implements Serializable {
    private Order order;
    private String name;
    private int quantity;


    @EJB
    private OrdersManagerBean ordersManagerBean;

    @EJB
    private ItemsManagerBean itemsManagerBean;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public void createOrder() {
        if (order == null) {
            order = ordersManagerBean.createOrder();
        }
    }



    public void createItem() {
        itemsManagerBean.createItem(name, quantity);
    }


    public List<Item> getItems() {
        return itemsManagerBean.getItems();
    }

    public void addItem(Item item) {
        if (order == null) {
            return;
        }
        ordersManagerBean.addToOrder(item.getId(), order.getId(), quantity);

    }

    public List<Item> getItemsInOrder() {
        if (order == null) {
            return Collections.emptyList();
        }
        return ordersManagerBean.getItemsInOrder(order.getId());
    }

}