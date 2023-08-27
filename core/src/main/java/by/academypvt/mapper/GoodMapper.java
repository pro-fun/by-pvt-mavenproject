package by.academypvt.mapper;

import by.academypvt.api.dto.good.GoodRequest;
import by.academypvt.api.dto.good.GoodResponse;
import by.academypvt.api.dto.user.UserResponse;
import by.academypvt.domain.Good;
import by.academypvt.domain.User;

public class GoodMapper {
    public Good mapToGood(GoodRequest goodRequest) {
        Good good = new Good(goodRequest.getId(), goodRequest.getType(), goodRequest.getName(), goodRequest.getCode(), goodRequest.getPrice(), goodRequest.getQuantity());
      return good;
    }

    public GoodResponse mapFromGood(Good good){
        GoodResponse goodResponse = new GoodResponse();
        goodResponse.setCode(good.getCode());
        goodResponse.setId(good.getId());
        goodResponse.setType(good.getType());
        goodResponse.setPrice(good.getPrice());
        goodResponse.setName(good.getName());
        goodResponse.setQuantity(good.getQuantity());
        return goodResponse;
    }
}
