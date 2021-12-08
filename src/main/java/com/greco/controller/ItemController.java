package com.greco.controller;

import com.greco.dto.ItemDTOInput;
import com.greco.entity.Item;
import com.greco.exception.ItemNotFoundException;
import com.greco.exceptionhandler.ExceptionHandler;
import com.greco.service.ItemService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@RequestScoped
@Path("/items")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemController {

    private final ItemService itemService;

    @Inject
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GET
    @Operation(summary = "Gets items", description = "Lists all available items")
    @APIResponses(value = @APIResponse(responseCode = "200", description = "Success",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Item.class))))
    public List<Item> getItems() {
        return itemService.getAllItems();
    }


    @GET
    @Path("/{id}")
    @Operation(summary = "Gets a item", description = "Retrieves a item by id")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Success",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Item.class))),
            @APIResponse(responseCode = "404", description = "Item not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionHandler.ErrorResponseBody.class)))
    })
    public Item getItem(@PathParam("id") long id) throws ItemNotFoundException {
        return itemService.getItemById(id);
    }

    @POST
    @Operation(summary = "Adds a item", description = "Creates a item and persists into database")
    @APIResponses(value = @APIResponse(responseCode = "200", description = "Success",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Item.class))))
    public Item createItem(@Valid ItemDTOInput itemDTOInput) {
        return itemService.saveItem(itemDTOInput.toItem());
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Updates a item", description = "Updates an existing item by id")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Success",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Item.class))),
            @APIResponse(responseCode = "404", description = "Item not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionHandler.ErrorResponseBody.class)))
    })
    public Item updateItem(@PathParam("id") int id, @Valid ItemDTOInput itemDTOInput) throws ItemNotFoundException {
        return itemService.updateItem(id, itemDTOInput.toItem());
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Deletes a Item", description = "Deletes a Item by id")
    @APIResponses(value = {
            @APIResponse(responseCode = "204", description = "Success"),
            @APIResponse(responseCode = "404", description = "Item not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionHandler.ErrorResponseBody.class)))
    })
    public Response deleteItem(@PathParam("id") long id) throws ItemNotFoundException {
        itemService.deleteItem(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }


}