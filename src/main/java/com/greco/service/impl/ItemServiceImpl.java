package com.greco.service.impl;

import com.greco.dto.ItemDTOInput;
import com.greco.entity.Item;
import com.greco.exception.ItemNotFoundException;
import com.greco.repository.ItemRepository;
import com.greco.service.ItemService;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Inject
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item getItemById(long id) throws ItemNotFoundException {
        return itemRepository.findByIdOptional(id).orElseThrow(() -> new ItemNotFoundException("There item doesn't exist"));
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.listAll(Sort.ascending("id"));
    }

    @Transactional
    @Override
    public Item updateItem(long id, Item item) throws ItemNotFoundException {
        Item existingItem = getItemById(id);
        existingItem.setName(item.name);
        existingItem.setQuantity(item.quantity);
        existingItem.setPrice(item.price);
        existingItem.setCurrency(item.currency);
        itemRepository.persist(existingItem);
        return existingItem;
    }

    @Override
    @Transactional
    public Item saveItem(Item item) {
        itemRepository.persistAndFlush(item);
        return item;
    }
    @Transactional
    @Override
    public void deleteItem(long id) throws ItemNotFoundException {
        itemRepository.delete(getItemById(id));
    }
}
