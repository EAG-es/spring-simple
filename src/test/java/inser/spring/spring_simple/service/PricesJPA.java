package inser.spring.spring_simple.service;

import inser.spring.spring_simple.dto.PricesCheckDto;
import inser.spring.spring_simple.entity.PricesEntity;
import inser.spring.spring_simple.repository.PricesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.fail;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PricesJPA {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PricesRepository pricesRepository;

    private PricesEntity pricesEntity;

    @BeforeEach
    public void setUp() {
        pricesEntity = new PricesEntity();
        pricesEntity.setBrandId(1L);
        pricesEntity.setStartDate(Timestamp.valueOf("2020-06-14 00:00:00"));
        pricesEntity.setEndDate(Timestamp.valueOf("2020-12-31 23:59:59"));
        pricesEntity.setPriceList(1L);
        pricesEntity.setProductId(35455L);
        pricesEntity.setPriority(0);
        pricesEntity.setPrice(BigDecimal.valueOf(35.50));
        pricesEntity.setCur("EUR");
    }

    @Test
    public void checkTest() {
        System.out.println("checkTest");
        try {
            List<PricesEntity> found_list = pricesRepository.findByStartDateAndProductIdAndBrandId(pricesEntity.getStartDate()
                    , pricesEntity.getProductId(), pricesEntity.getBrandId());
            PricesCheckDto pricesCheckDto = new PricesCheckDto(found_list.get(0));
            assertThat(pricesCheckDto.brandId(), equalTo(pricesEntity.getBrandId()));
            assertThat(pricesCheckDto.price().doubleValue(), equalTo(pricesEntity.getPrice().doubleValue()));
            assertThat(pricesCheckDto.priceList(), equalTo(pricesEntity.getPriceList()));
            assertThat(pricesCheckDto.productId(), equalTo(pricesEntity.getProductId()));
            assertThat(pricesCheckDto.startDate(), equalTo(pricesEntity.getStartDate()));
            assertThat(pricesCheckDto.endDate(), equalTo(pricesEntity.getEndDate()));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
