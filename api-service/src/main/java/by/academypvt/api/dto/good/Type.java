package by.academypvt.api.dto.good;

public enum Type {

    PHONES("Мобильные телефоны"),
    NOTEBOOKS("Ноутбуки"),
    TV("Телевизоры"),
    PLAYSTATION("Игровые приставки");


    private String name;
    Type(String name) {this.name = name;}
}
