package by.academypvt.service.impl;

import by.academypvt.repository.GoodRepository;
import by.academypvt.service.GoodService;

public class GoodServiceImpl implements GoodService {
    private GoodRepository goodRepository;

    public GoodServiceImpl(GoodRepository goodRepository) {
        this.goodRepository = goodRepository;
    }
}
