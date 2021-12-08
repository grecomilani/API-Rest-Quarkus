package com.greco;

import com.greco.dto.ItemDTOInput;
import com.greco.entities.Item;
import com.greco.services.ItemService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/items")
public class ItemResource {


    @Inject
    ItemService itemService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Item> list(){
        return itemService.listItems();
    }


    @POST
    public void addItem(ItemDTOInput itemDTOInput){
        itemService.addItem(itemDTOInput);
    }


}