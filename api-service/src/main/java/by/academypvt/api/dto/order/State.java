package by.academypvt.api.dto.order;

public enum State {
    INCOMPLETED("Формируется"),
    WAITING_FOR_DEPART("Ожидает отпраки"),
    ON_THE_WAY("В пути"),
    DONE("Доставлен");


    private String name;
    State(String name) {this.name = name;}
}
