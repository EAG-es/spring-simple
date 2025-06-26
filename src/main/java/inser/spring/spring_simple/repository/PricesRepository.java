package inser.spring.spring_simple.repository;

import inser.spring.spring_simple.entity.PricesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Prices repository with two method added
 */
@Repository
public interface PricesRepository extends JpaRepository<PricesEntity, Integer> {

    /**
     * JPA Query method for equal condition
     * @param startDate start_date field
     * @param productId product_id field
     * @param brandId brand_id field
     * @return a list with the records matching the query
     */
    List<PricesEntity> findByStartDateAndProductIdAndBrandId(Timestamp startDate
            , Long productId
            , Long brandId);

    /**
     * Annotated Query method for equal condition
     * @param startDate start_date field
     * @param productId product_id field
     * @param brandId brand_id field
     * @return a list with the records matching the query
     */
    @Query(nativeQuery = true, value = "SELECT *" +
            " FROM prices" +
            " WHERE start_date >= :startDate AND product_id = :productId AND brand_id = :brandId")
    List<PricesEntity> findGreaterOrEqualByStartDateAndProductIdAndBrandId(Timestamp startDate
            , Long productId
            , Long brandId);

}
