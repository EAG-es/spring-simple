package inser.spring.spring_simple.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import inser.spring.spring_simple.dto.PricesCheckDto;
import inser.spring.spring_simple.entity.PricesEntity;
import inser.spring.spring_simple.repository.PricesRepository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(SpringExtension.class)
public class PricesServiceTest {
    @Autowired
    private PricesService pricesService;

    @MockitoBean
    private PricesRepository pricesRepository;

    List<PricesEntity> pricesEntities_list = new ArrayList<>();
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

        pricesEntities_list.add(pricesEntity);
        Mockito.when(pricesRepository.findByStartDateAndProductIdAndBrandId(pricesEntity.getStartDate()
                , pricesEntity.getProductId(), pricesEntity.getBrandId()))
                .thenReturn(pricesEntities_list);
    }
    @TestConfiguration
    static class PricesServiceTestContextConfiguration {
        @Bean
        public PricesService pricesService() {
            return new PricesService();
        }
    }

    @Test
    public void checkTest() {
        System.out.println("checkTest");
        try {
            List<PricesCheckDto> pricesCheckDto_list = pricesService.check(pricesEntity.getStartDate()
                    , pricesEntity.getProductId(), pricesEntity.getBrandId());

            assertThat(pricesCheckDto_list.get(0).brandId(), equalTo(pricesEntity.getBrandId()));
            assertThat(pricesCheckDto_list.get(0).price().doubleValue(), equalTo(pricesEntity.getPrice().doubleValue()));
            assertThat(pricesCheckDto_list.get(0).priceList(), equalTo(pricesEntity.getPriceList()));
            assertThat(pricesCheckDto_list.get(0).productId(), equalTo(pricesEntity.getProductId()));
            assertThat(pricesCheckDto_list.get(0).startDate(), equalTo(pricesEntity.getStartDate()));
            assertThat(pricesCheckDto_list.get(0).endDate(), equalTo(pricesEntity.getEndDate()));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
