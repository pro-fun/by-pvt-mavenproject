package by.academypvt.config;

import by.academypvt.connection.PostgresConnection;
import by.academypvt.connection.ProjectConnection;
import by.academypvt.mapper.GoodMapper;
import by.academypvt.mapper.OrderMapper;
import by.academypvt.mapper.UserMapper;
import by.academypvt.repository.BasketRepository;
import by.academypvt.repository.GoodRepository;
import by.academypvt.repository.OrderRepository;
import by.academypvt.repository.UserRepository;
import by.academypvt.repository.impl.GoodRepositoryImpl;
import by.academypvt.repository.impl.UserRepositoryImpl;
import by.academypvt.repository.jdbc.BasketRepositoryJdbc;
import by.academypvt.repository.jdbc.GoodRepositoryJdbc;
import by.academypvt.repository.jdbc.OrderRepositoryJdbc;
import by.academypvt.repository.jdbc.UserRepositoryJdbc;
import by.academypvt.service.BasketService;
import by.academypvt.service.GoodService;
import by.academypvt.service.OrderService;
import by.academypvt.service.UserService;
import by.academypvt.service.impl.BasketServiceImpl;
import by.academypvt.service.impl.GoodServiceImpl;
import by.academypvt.service.impl.OrderServiceImpl;
import by.academypvt.service.impl.UserServiceImpl;

public class ApplicationContext {
    private static ApplicationContext applicationContext;
    private final GoodRepository goodRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final BasketRepository basketRepository;
    private final OrderService orderService;
    private final BasketService basketService;
    private final UserService userService;
    private final GoodService goodService;
    private final GoodMapper goodMapper;
    private final UserMapper userMapper;
    private final OrderMapper orderMapper;
    private final ProjectConnection postgresConnection;
    private ApplicationContext(){
        postgresConnection = new PostgresConnection();
        goodRepository = new GoodRepositoryJdbc(postgresConnection);
        userRepository = new UserRepositoryJdbc(postgresConnection);
        orderRepository = new OrderRepositoryJdbc(postgresConnection);
        basketRepository = new BasketRepositoryJdbc(postgresConnection);
        orderMapper = new OrderMapper();
        userMapper = new UserMapper();
        goodMapper = new GoodMapper();
        userService = new UserServiceImpl(userRepository, userMapper);
        goodService = new GoodServiceImpl(goodRepository, goodMapper);
        orderService = new OrderServiceImpl(orderRepository, orderMapper,basketRepository);
        basketService = new BasketServiceImpl(basketRepository, orderRepository, goodRepository);


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

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

    public BasketRepository getBasketRepository() {
        return basketRepository;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public BasketService getBasketService() {
        return basketService;
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

    public OrderMapper getOrderMapper() {
        return orderMapper;
    }

    public ProjectConnection getPostgresConnection() {
        return postgresConnection;
    }
}


