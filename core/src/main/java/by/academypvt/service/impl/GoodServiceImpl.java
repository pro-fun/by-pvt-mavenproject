package by.academypvt.service.impl;

import by.academypvt.mapper.GoodMapper;
import by.academypvt.repository.GoodRepository;
import by.academypvt.service.GoodService;

public class GoodServiceImpl implements GoodService {
    private GoodRepository goodRepository;
    private GoodMapper goodMapper;

    public GoodServiceImpl(GoodRepository goodRepository, GoodMapper goodMapper) {
        this.goodRepository = goodRepository;
        this.goodMapper = goodMapper;
    }
}
