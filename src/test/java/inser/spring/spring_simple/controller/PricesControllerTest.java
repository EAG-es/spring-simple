package inser.spring.spring_simple.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import inser.spring.spring_simple.Spring_simple;
import inser.spring.spring_simple.dto.PricesCheckDto;
import inser.spring.spring_simple.entity.PricesEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;

import static inser.spring.spring_simple.controller.PricesController.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = Spring_simple.class)
@AutoConfigureMockMvc
public class PricesControllerTest {

    @Autowired
    private MockMvc mockMvc;

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

    private PricesEntity pricesEntity;

    @Test
    public void check_greater_or_equal_1_Test() {
        System.out.println("checkgreater_or_equal_1_Test");
        try {
            pricesEntity.setStartDate(Timestamp.valueOf("2020-06-14 10:00:00"));
            String url_tex = k_pricesController_base_url_tex + k_pricesController_check_from_star_date_url_tex;
            MvcResult mvcResult = mockMvc.perform(get(url_tex)
                    .param(k_pricesController_check_start_date, pricesEntity.getStartDate().toString())
                    .param(k_pricesController_check_brand_id, pricesEntity.getBrandId().toString())
                    .param(k_pricesController_check_product_id, pricesEntity.getProductId().toString())
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content()
                            .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                    .andReturn();
            String response_tex = mvcResult.getResponse().getContentAsString();
            List<PricesCheckDto> pricesCheckDto_list;
            ObjectMapper objectMapper = new ObjectMapper();
            pricesCheckDto_list = objectMapper.readValue(response_tex
                    , new TypeReference<List<PricesCheckDto>>() {});
            for (var item: pricesCheckDto_list) {
                assertThat(item.startDate(), greaterThanOrEqualTo(pricesEntity.getStartDate()));
                assertThat(item.brandId(), equalTo(pricesEntity.getBrandId()));
                assertThat(item.productId(), equalTo(pricesEntity.getProductId()));
            }
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void check_greater_or_equal_2_Test() {
        System.out.println("checkgreater_or_equal_2_Test");
        try {
            pricesEntity.setStartDate(Timestamp.valueOf("2020-06-14 16:00:00"));
            String url_tex = k_pricesController_base_url_tex + k_pricesController_check_from_star_date_url_tex;
            MvcResult mvcResult = mockMvc.perform(get(url_tex)
                            .param(k_pricesController_check_start_date, pricesEntity.getStartDate().toString())
                            .param(k_pricesController_check_brand_id, pricesEntity.getBrandId().toString())
                            .param(k_pricesController_check_product_id, pricesEntity.getProductId().toString())
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content()
                            .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                    .andReturn();
            String response_tex = mvcResult.getResponse().getContentAsString();
            List<PricesCheckDto> pricesCheckDto_list;
            ObjectMapper objectMapper = new ObjectMapper();
            pricesCheckDto_list = objectMapper.readValue(response_tex
                    , new TypeReference<List<PricesCheckDto>>() {});
            for (var item: pricesCheckDto_list) {
                assertThat(item.startDate(), greaterThanOrEqualTo(pricesEntity.getStartDate()));
                assertThat(item.brandId(), equalTo(pricesEntity.getBrandId()));
                assertThat(item.productId(), equalTo(pricesEntity.getProductId()));
            }
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void check_greater_or_equal_3_Test() {
        System.out.println("checkgreater_or_equal_3_Test");
        try {
            pricesEntity.setStartDate(Timestamp.valueOf("2020-06-14 21:00:00"));
            String url_tex = k_pricesController_base_url_tex + k_pricesController_check_from_star_date_url_tex;
            MvcResult mvcResult = mockMvc.perform(get(url_tex)
                            .param(k_pricesController_check_start_date, pricesEntity.getStartDate().toString())
                            .param(k_pricesController_check_brand_id, pricesEntity.getBrandId().toString())
                            .param(k_pricesController_check_product_id, pricesEntity.getProductId().toString())
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content()
                            .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                    .andReturn();
            String response_tex = mvcResult.getResponse().getContentAsString();
            List<PricesCheckDto> pricesCheckDto_list;
            ObjectMapper objectMapper = new ObjectMapper();
            pricesCheckDto_list = objectMapper.readValue(response_tex
                    , new TypeReference<List<PricesCheckDto>>() {});
            for (var item: pricesCheckDto_list) {
                assertThat(item.startDate(), greaterThanOrEqualTo(pricesEntity.getStartDate()));
                assertThat(item.brandId(), equalTo(pricesEntity.getBrandId()));
                assertThat(item.productId(), equalTo(pricesEntity.getProductId()));
            }
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void check_greater_or_equal_4_Test() {
        System.out.println("checkgreater_or_equal_4_Test");
        try {
            pricesEntity.setStartDate(Timestamp.valueOf("2020-06-15 10:00:00"));
            String url_tex = k_pricesController_base_url_tex + k_pricesController_check_from_star_date_url_tex;
            MvcResult mvcResult = mockMvc.perform(get(url_tex)
                            .param(k_pricesController_check_start_date, pricesEntity.getStartDate().toString())
                            .param(k_pricesController_check_brand_id, pricesEntity.getBrandId().toString())
                            .param(k_pricesController_check_product_id, pricesEntity.getProductId().toString())
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content()
                            .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                    .andReturn();
            String response_tex = mvcResult.getResponse().getContentAsString();
            List<PricesCheckDto> pricesCheckDto_list;
            ObjectMapper objectMapper = new ObjectMapper();
            pricesCheckDto_list = objectMapper.readValue(response_tex
                    , new TypeReference<List<PricesCheckDto>>() {});
            for (var item: pricesCheckDto_list) {
                assertThat(item.startDate(), greaterThanOrEqualTo(pricesEntity.getStartDate()));
                assertThat(item.brandId(), equalTo(pricesEntity.getBrandId()));
                assertThat(item.productId(), equalTo(pricesEntity.getProductId()));
            }
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void check_greater_or_equal_5_Test() {
        System.out.println("checkgreater_or_equal_5_Test");
        try {
            pricesEntity.setStartDate(Timestamp.valueOf("2020-06-16 21:00:00"));
            String url_tex = k_pricesController_base_url_tex + k_pricesController_check_from_star_date_url_tex;
            ResultActions resultAction = mockMvc.perform(get(url_tex)
                            .param(k_pricesController_check_start_date, pricesEntity.getStartDate().toString())
                            .param(k_pricesController_check_brand_id, pricesEntity.getBrandId().toString())
                            .param(k_pricesController_check_product_id, pricesEntity.getProductId().toString())
                            .contentType(MediaType.APPLICATION_JSON));
            MvcResult mvcResult = resultAction.andReturn();
            assertThat(mvcResult.getResponse().getStatus(), equalTo(HttpStatus.NOT_FOUND.value()));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void checkTest() {
        System.out.println("checkTest");
        try {
            pricesEntity.setStartDate(Timestamp.valueOf("2020-06-14 00:00:00"));
            String url_tex = k_pricesController_base_url_tex + k_pricesController_check_url_tex;
            MvcResult mvcResult = mockMvc.perform(get(url_tex)
                            .param(k_pricesController_check_start_date, pricesEntity.getStartDate().toString())
                            .param(k_pricesController_check_brand_id, pricesEntity.getBrandId().toString())
                            .param(k_pricesController_check_product_id, pricesEntity.getProductId().toString())
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content()
                    .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                    .andReturn();
            String response_tex = mvcResult.getResponse().getContentAsString();
            List<PricesCheckDto> pricesCheckDto_list;
            ObjectMapper objectMapper = new ObjectMapper();
            pricesCheckDto_list = objectMapper.readValue(response_tex
                    , new TypeReference<List<PricesCheckDto>>() {});
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

    @Test
    public void checkFailTest() {
        System.out.println("checkFailTest");
        try {
            String url_tex = k_pricesController_base_url_tex + k_pricesController_check_url_tex;
            ResultActions resultAction = mockMvc.perform(get(url_tex)
                            .param(k_pricesController_check_start_date, pricesEntity.getStartDate().toString())
                            .param(k_pricesController_check_brand_id, "999")
                            .param(k_pricesController_check_product_id, pricesEntity.getProductId().toString())
                            .contentType(MediaType.APPLICATION_JSON));
            MvcResult mvcResult = resultAction.andReturn();
            assertThat(mvcResult.getResponse().getStatus(), equalTo(HttpStatus.NOT_FOUND.value()));
            String response_tex = mvcResult.getResponse().getContentAsString();
            assertThat(response_tex, equalTo(NoSuchElementException.class.getCanonicalName()));
            resultAction.andExpect(status().isNotFound());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
