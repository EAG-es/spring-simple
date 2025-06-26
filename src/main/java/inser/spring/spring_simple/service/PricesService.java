package inser.spring.spring_simple.service;

import inser.spring.spring_simple.dto.PricesCheckDto;
import inser.spring.spring_simple.entity.PricesEntity;
import inser.spring.spring_simple.repository.PricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PricesService {

    @Autowired
    public PricesRepository pricesRepository;

    /**
     * Check records with equal condition
     * @param start_date Start date. Format: yyyy-mm-dd HH:mm:ss
     * @param product_id Number of producer id
     * @param brand_id Number of brand id
     * @return A list with the records matching or a string with the error if status != OK
     * @throws Exception In case of unexpected behavior
     */
    public List<PricesCheckDto> check(Timestamp start_date
            , Long product_id
            , Long brand_id) throws Exception {
        List<PricesEntity> pricesEntity_list = pricesRepository.findByStartDateAndProductIdAndBrandId(start_date
                , product_id, brand_id);
        List<PricesCheckDto> pricesCheckDto_list = new ArrayList<>();
        pricesEntity_list.stream().forEach(
                _item ->
                        pricesCheckDto_list.add(new PricesCheckDto(_item)
                )
        );
        return pricesCheckDto_list;
    }

    /**
     * Check records with equal condition for product_id and brand_id and start date greater or equal than start_date
     * @param start_date Start date. Format: yyyy-mm-dd HH:mm:ss
     * @param product_id Number of producer id
     * @param brand_id Number of brand id
     * @return A list with the records matching or a string with the error if status != OK
     * @throws Exception In case of unexpected behavior
     */
    public List<PricesCheckDto> checkFromStartDate(Timestamp start_date
            , Long product_id
            , Long brand_id) throws Exception {
        List<PricesEntity> pricesEntity_list = pricesRepository.findGreaterOrEqualByStartDateAndProductIdAndBrandId(start_date
                , product_id, brand_id);
        List<PricesCheckDto> pricesCheckDto_list = new ArrayList<>();
        pricesEntity_list.stream().forEach(
                _item ->
                        pricesCheckDto_list.add(new PricesCheckDto(_item)
                        )
        );
        return pricesCheckDto_list;
    }
}
