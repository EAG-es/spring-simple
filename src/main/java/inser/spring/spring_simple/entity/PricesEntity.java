package inser.spring.spring_simple.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Prices entity
 */
@Getter
@Setter
@Entity
@Table(name = "prices", indexes = {
        @Index(name = "idx_startDate_productId_brandId", columnList = "startDate, productId, brandId")
})
public class PricesEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_price", nullable = false)
    private Long idPrice;

    @Column(name = "brand_id", nullable = false)
    private Long brandId;

    @Column(name = "start_date", nullable = false)
    private Timestamp startDate;

    @Column(name = "end_date", nullable = false)
    private Timestamp endDate;

    @Column(name = "price_list", nullable = false)
    private Long priceList;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "priority", nullable = false)
    private Integer priority;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "cur", nullable = false, length = 4)
    private String cur;

}