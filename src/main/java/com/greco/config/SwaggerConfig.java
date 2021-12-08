package com.greco.config;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(
        tags = {
                @Tag(name = "item", description = "Item CRUD operations."),
        },
        info = @Info(
                title = "Item Crud API with Quarkus",
                version = "0.0.1",
                contact = @Contact(
                        name = "Greco Milani",
                        url = "http://*******.com/**",
                        email = "*****@******.com"),
                license = @License(
                        name = "MIT",
                        url = "https://opensource.org/licenses/MIT"))
)
public class SwaggerConfig extends Application {

}