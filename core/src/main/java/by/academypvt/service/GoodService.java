package by.academypvt.service;

import by.academypvt.api.dto.good.GoodRequest;
import by.academypvt.api.dto.good.GoodResponse;
import by.academypvt.api.dto.user.UserResponse;

import java.util.List;

public interface GoodService {
    List<GoodResponse> goodsInfo();
    void addGood(GoodRequest goodRequest);
    void deleteGood(Long id);
    GoodResponse finGoodById(Long id);
}
