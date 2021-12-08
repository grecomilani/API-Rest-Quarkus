package com.greco.service;

import com.greco.entity.Item;
import com.greco.exception.ItemNotFoundException;

import java.util.List;


public interface ItemService {

    Item getItemById(long id) throws ItemNotFoundException;

    List<Item> getAllItems();

    Item updateItem(long id, Item item) throws ItemNotFoundException;

    Item saveItem(Item item);

    void deleteItem(long id) throws ItemNotFoundException;


}
