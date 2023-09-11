package by.academypvt.repository;

import by.academypvt.domain.Good;

import java.util.List;

public interface GoodRepository {
    List<Good> allGoods();
    Good addGood(Good good);
    void deleteGood(Long goodId);
    Good findGoodById(Long id);
    Good findGoodByCode(Long code);
    Long findGoodsQuantity(Long goodId);
    void changeGoodsQuantity(Long quantity, Long goodId);
}
