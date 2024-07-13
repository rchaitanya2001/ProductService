package org.example.productservice;

import java.util.Date;

/**
 * Projection for {@link org.example.productservice.Models.Product}
 */
public interface ProductInfo {
    Long getId();

    Date getCreateAt();

    Date getUpdatedAt();
}