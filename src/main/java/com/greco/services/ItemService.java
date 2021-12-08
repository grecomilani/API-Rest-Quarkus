package com.greco.services;

import com.greco.dto.ItemDTOInput;
import com.greco.entities.Item;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ItemService {

    public List<Item> listItems() {
        return Item.listAll();

    }

    @Transactional
    public void addItem(ItemDTOInput itemDTOInput) {
        Item item = new Item();
        item.name = itemDTOInput.getName();
        item.quantity = itemDTOInput.getQuantity();
        item.price = itemDTOInput.getPrice();
        item.currency = itemDTOInput.getCurrency();
        item.persist();

    }

}
