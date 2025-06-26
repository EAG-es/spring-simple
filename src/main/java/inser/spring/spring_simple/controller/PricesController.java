package inser.spring.spring_simple.controller;

import inser.spring.spring_simple.dto.PricesCheckDto;
import inser.spring.spring_simple.service.PricesService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(PricesController.k_pricesController_base_url_tex)
public class PricesController {
    public static final String k_pricesController_base_url_tex = "/public/prices";
    public static final String k_pricesController_check_url_tex = "/check";
    public static final String k_pricesController_check_from_star_date_url_tex = "/check_from_start_date";
    public static final String k_pricesController_check_start_date = "start_date";
    public static final String k_pricesController_check_product_id = "product_id";
    public static final String k_pricesController_check_brand_id = "brand_id";

    public final PricesService pricesService;

    public PricesController(PricesService pricesService) {
        this.pricesService = pricesService;
    }

    /**
     * NoSuchElementException exception management. Set statut to NOT_FOUND
     * @param e Exception object
     * @return An error message
     */
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String send_not_found_exception_handler(NoSuchElementException e) {
        return e.getMessage();
    }

    /**
     * Exception management. Set status to INTERNAL_SERVER_ERROR
     * @param e Exception object
     * @return An error message
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String generic_exception_handler(Exception e) {
        return e.getMessage();
    }

    /**
     * Check records with equal condition
     * @param start_date Start date. Format: yyyy-mm-dd HH:mm:ss
     * @param product_id Number of producer id
     * @param brand_id Number of brand id
     * @return A list with the records matching or a string with the error if status != OK
     * @throws Exception if Not found or any other errors
     */
    @GetMapping(k_pricesController_check_url_tex)
    public List<PricesCheckDto> check(@RequestParam(k_pricesController_check_start_date) Timestamp start_date
            , @RequestParam(k_pricesController_check_product_id) Long product_id
            , @RequestParam(k_pricesController_check_brand_id) Long brand_id) throws Exception {
        List<PricesCheckDto> pricesEntity_list;
        pricesEntity_list = pricesService.check(start_date, product_id, brand_id);
        if (pricesEntity_list.isEmpty()) {
            throw new NoSuchElementException(NoSuchElementException.class.getCanonicalName());
        }
        return pricesEntity_list;
    }

    /**
     * Check records with equal condition for product_id and brand_id and start date greater or equal than start_date
     * @param start_date Start date. Format: yyyy-mm-dd HH:mm:ss
     * @param product_id Number of producer id
     * @param brand_id Number of brand id
     * @return A list with the records matching or a string with the error if status != OK
     * @throws Exception if Not found or any other errors
     */
    @GetMapping(k_pricesController_check_from_star_date_url_tex)
    public List<PricesCheckDto> checkFromStartDate(@RequestParam(k_pricesController_check_start_date) Timestamp start_date
            , @RequestParam(k_pricesController_check_product_id) Long product_id
            , @RequestParam(k_pricesController_check_brand_id) Long brand_id) throws Exception {
        List<PricesCheckDto> pricesEntity_list;
        pricesEntity_list = pricesService.checkFromStartDate(start_date, product_id, brand_id);
        if (pricesEntity_list.isEmpty()) {
            throw new NoSuchElementException(NoSuchElementException.class.getCanonicalName());
        }
        return pricesEntity_list;
    }

}
