package ua.imba.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by tvgur on 28.07.2017.
 */
@Entity
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int quantity;

@OneToMany(fetch = FetchType.EAGER, mappedBy = "item")
private List<ItemInOrder> itemInOrders;

    public List<ItemInOrder> getItemInOrders() {
        return itemInOrders;
    }

    public void setItemInOrders(List<ItemInOrder> itemInOrders) {
        this.itemInOrders = itemInOrders;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
}
