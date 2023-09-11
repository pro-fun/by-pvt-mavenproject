package by.academypvt.service.impl;

import by.academypvt.api.dto.good.GoodRequest;
import by.academypvt.api.dto.good.GoodResponse;
import by.academypvt.mapper.GoodMapper;
import by.academypvt.repository.GoodRepository;
import by.academypvt.service.GoodService;

import java.util.List;
import java.util.stream.Collectors;

public class GoodServiceImpl implements GoodService {
    private GoodRepository goodRepositoryImpl;
    private GoodMapper goodMapper;

    public GoodServiceImpl(GoodRepository goodRepositoryImpl, GoodMapper goodMapper) {
        this.goodRepositoryImpl = goodRepositoryImpl;
        this.goodMapper = goodMapper;
    }

    @Override
    public List<GoodResponse> goodsInfo() {
        return goodRepositoryImpl.allGoods().stream().map(goodMapper::mapFromGood).collect(Collectors.toList());
    }

    @Override
    public void addGood(GoodRequest goodRequest) {
        var good = goodMapper.mapToGood(goodRequest);
        goodRepositoryImpl.addGood(good);
    }

    public void deleteGood(Long id) {
        goodRepositoryImpl.deleteGood(id);
    }

    @Override
    public GoodResponse finGoodById(Long id) {
        var good = goodRepositoryImpl.findGoodById(id);
        if (good == null){
            return null;
        } else return goodMapper.mapFromGood(good);
    }

    @Override
    public GoodResponse finGoodByCode(Long code) {
        return goodMapper.mapFromGood(goodRepositoryImpl.findGoodByCode(code));
    }

    @Override
    public boolean checkGoodsQuantity(Long quantity, Long goodId) {

        Long neededQuantity = goodRepositoryImpl.findGoodsQuantity(goodId);
        if (neededQuantity >= quantity) {
            return true;
        } else return false;
    }

    @Override
    public void changeGoodsQuantity(Long quantity, Long goodId) {
        Long neededQuantity = goodRepositoryImpl.findGoodsQuantity(goodId) - quantity;
        goodRepositoryImpl.changeGoodsQuantity(neededQuantity, goodId);

    }
}
