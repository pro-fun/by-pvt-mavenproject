package by.academypvt.config;

import by.academypvt.mapper.GoodMapper;
import by.academypvt.mapper.UserMapper;
import by.academypvt.repository.GoodRepository;
import by.academypvt.repository.UserRepository;
import by.academypvt.service.GoodService;
import by.academypvt.service.UserService;
import by.academypvt.service.impl.GoodServiceImpl;
import by.academypvt.service.impl.UserServiceImpl;

public class ApplicationContext {
    private static ApplicationContext applicationContext;
    private final GoodRepository goodRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final GoodService goodService;
    private final GoodMapper goodMapper;
    private final UserMapper userMapper;
    private ApplicationContext(){
        goodRepository = new GoodRepository();
        userRepository = new UserRepository();
        userMapper = new UserMapper();
        userService = new UserServiceImpl(userRepository, userMapper);
        goodMapper = new GoodMapper();
        goodService = new GoodServiceImpl(goodRepository, goodMapper);
        }
        public static ApplicationContext getInstance(){
        if(applicationContext==null){
            applicationContext = new ApplicationContext();
        }
        return applicationContext;
        }

    public GoodRepository getGoodRepository() {
        return goodRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public UserService getUserService() {
        return userService;
    }

    public GoodService getGoodService() {
        return goodService;
    }

    public GoodMapper getGoodMapper() {
        return goodMapper;
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }
}


