package by.academypvt.repository;

import by.academypvt.domain.Good;
import by.academypvt.exception.GoodException;

import java.util.ArrayList;
import java.util.List;

public class GoodRepository extends FileWorker {
    private static List<Good> goods = new ArrayList<>();
    public static String PATH = "C:\\Users\\pprof\\HomeworkEnt1\\src\\main\\resources\\goods";

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
    public void deleteGood(Good good){
        goods = allGoods();
        goods.remove(good);
        serializeObject(goods, PATH);
    }
    public Good findGoodById(Long id){
        List<Good> goods = allGoods();
        Good good = (Good)goods.stream().filter(good1 -> good1.getId()==id).findFirst().orElseThrow(()->new GoodException("Товар с номером" + id + "не найден"));
        return good;
    }
}
