package com.taes.r2dbc.repository;

import com.taes.r2dbc.entity.ProductMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public class ProductMapRepository {
    private final DatabaseClient databaseClient;

    @Autowired
    public ProductMapRepository(DatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

    public Flux<ProductMap> getAllProductMap()
    {
        return databaseClient.execute(
                "SELECT p.id product_id, p.product_name, p.product_detail, u.id user_id, u.name user_name" +
                "    , l.id location_id, l.name location_name \n" +
                "FROM PRODUCT_SALE ps \n" +
                "    INNER JOIN PRODUCT p \n" +
                "        ON ps.product_id = p.id\n" +
                "    INNER JOIN USER u\n" +
                "        ON ps.user_id = u.id \n" +
                "    INNER JOIN LOCATION l\n" +
                "        ON ps.location_id = l.id").as(ProductMap.class).fetch().all();

    }
}
