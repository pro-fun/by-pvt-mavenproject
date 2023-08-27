package by.academypvt.service.impl;

import by.academypvt.api.dto.good.GoodRequest;
import by.academypvt.api.dto.good.GoodResponse;
import by.academypvt.domain.Good;
import by.academypvt.mapper.GoodMapper;
import by.academypvt.repository.GoodRepository;
import by.academypvt.service.GoodService;

import java.util.List;
import java.util.stream.Collectors;

public class GoodServiceImpl implements GoodService {
    private GoodRepository goodRepository;
    private GoodMapper goodMapper;

    public GoodServiceImpl(GoodRepository goodRepository, GoodMapper goodMapper) {
        this.goodRepository = goodRepository;
        this.goodMapper = goodMapper;
    }

    @Override
    public List<GoodResponse> goodsInfo() {
        return goodRepository.allGoods().stream().map(goodMapper::mapFromGood).collect(Collectors.toList());
    }

    @Override
    public void addGood(GoodRequest goodRequest) {
        List<Good> goods = goodRepository.allGoods();
        var good = goodMapper.mapToGood(goodRequest);
        goodRepository.addGood(good);
    }
    public void deleteGood(Long id){
        var good = goodRepository.findGoodById(id);
        goodRepository.deleteGood(good);
    }

    @Override
    public GoodResponse finGoodById(Long id) {
        return goodMapper.mapFromGood(goodRepository.findGoodById(id));
    }
}
