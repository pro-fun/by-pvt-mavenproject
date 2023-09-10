package by.academypvt.repository.impl;

import by.academypvt.domain.Good;
import by.academypvt.exception.GoodException;
import by.academypvt.repository.GoodRepository;

import java.util.ArrayList;
import java.util.List;


public class GoodRepositoryImpl extends FileWorker implements GoodRepository {
    private static List<Good> goods = new ArrayList<>();
    public static String PATH = "C:\\Users\\pprof\\by-pvt-mavenproject\\core\\src\\main\\resources\\goods";

    public List<Good> allGoods() {
        Object object = deserializeObject(PATH);
        List<Good> goods = new ArrayList<>();
        if ((object instanceof List<?>)) {
            goods = (List<Good>) object;
        }
        return goods;
    }
    public Good addGood(Good good) {
        goods = allGoods();
        goods.add(good);
        serializeObject(goods, PATH);
        return good;
    }
    public void deleteGood(Long id){
        goods = allGoods();
        Good good = goods.stream().filter(good1 -> good1.getId() == id).findFirst().orElseThrow(() -> new GoodException("Товар с номером" + id + "не найден"));
        goods.remove(good);
        serializeObject(goods, PATH);
    }
    public Good findGoodById(Long id){
        goods = allGoods();
        return  goods.stream().filter(good1 -> good1.getId() == id).findFirst().orElseThrow(() -> new GoodException("Товар с номером" + id + "не найден"));

    }

    @Override
    public Good findGoodByCode(Long code) {
        return null;
    }

    @Override
    public Long findGoodsQuantity(Long goodId) {
        return null;
    }

    @Override
    public void changeGoodsQuantity(Long quantity, Long goodId) {

    }
}
