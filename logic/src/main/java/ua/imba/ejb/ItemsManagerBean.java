package ua.imba.ejb;

import ua.imba.domain.Item;
import ua.imba.domain.ItemInOrder;
import ua.imba.domain.Order;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by tvgur on 28.07.2017.
 */
@Stateless
@LocalBean
public class ItemsManagerBean {
    @PersistenceContext(unitName = "examplePU")
    private EntityManager entityManager;

    public Item createItem(String name, int quantity){
        Item item = new Item();
        item.setName(name);
        item.setQuantity(quantity);
        entityManager.persist(item);
        return item;

    }

    public Item removeItem(Item item){
        Item removed = entityManager.find(Item.class, item.getId());
        entityManager.remove(removed);
        return item;
    }
    public List<Item> getItems(){
     TypedQuery<Item> query = entityManager.createQuery("select c from Item c", Item.class);
     return query.getResultList();

    }
}

