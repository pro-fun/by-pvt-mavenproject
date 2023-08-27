package by.academypvt.api.dto.good;


import by.academypvt.api.dto.user.Role;

public class GoodRequest {
    private Long id;
    private Type type;
    private String name;
    private Long code;
    private Long price;
    private int quantity;

    public GoodRequest(Long id, Type type, String name, Long code, Long price, Integer quantity) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.code = code;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
