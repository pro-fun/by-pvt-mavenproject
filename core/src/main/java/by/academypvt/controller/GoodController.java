package by.academypvt.controller;

import by.academypvt.service.GoodService;
import by.academypvt.service.impl.GoodServiceImpl;
import by.academypvt.service.impl.UserServiceImpl;

public class GoodController implements GoodService {
    private final GoodServiceImpl goodService;

    public GoodController(GoodServiceImpl goodService) {

        this.goodService = goodService;
    }

}
