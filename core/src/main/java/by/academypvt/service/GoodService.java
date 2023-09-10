package by.academypvt.service;

import by.academypvt.api.dto.good.GoodRequest;
import by.academypvt.api.dto.good.GoodResponse;

import java.util.List;

public interface GoodService {
    List<GoodResponse> goodsInfo();
    void addGood(GoodRequest goodRequest);
    void deleteGood(Long id);
    GoodResponse finGoodById(Long id);
    GoodResponse finGoodByCode(Long code);
    boolean checkGoodsQuantity(Long quantity, Long goodId);
    void changeGoodsQuantity(Long quantity,  Long goodId);

}
