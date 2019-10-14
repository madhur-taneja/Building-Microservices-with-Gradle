package io.trpspringmicroservices.moviecatalogservice.resources;

import io.trpspringmicroservices.moviecatalogservice.models.CatalogItem;

import java.util.Collections;
import java.util.List;

public class MovieCatalogResource
{
    public List<CatalogItem> getCatalog(String userId) {
        return Collections.singletonList(
                new CatalogItem("Snowden", "I know you're watching", 5)
        );
    }
}
