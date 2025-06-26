package inser.spring.spring_simple.dto;

import inser.spring.spring_simple.entity.PricesEntity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * DTO class to transfer only the information requested
 */
public record PricesCheckDto (
    Long productId,
    Long brandId,
    Long priceList,
    Timestamp startDate,
    Timestamp endDate,
    BigDecimal price
) {

    public PricesCheckDto(PricesEntity pricesEntity) {
        this(pricesEntity.getProductId()
                , pricesEntity.getBrandId()
                , pricesEntity.getPriceList()
                , pricesEntity.getStartDate()
                , pricesEntity.getEndDate()
                , pricesEntity.getPrice());
    }
}
