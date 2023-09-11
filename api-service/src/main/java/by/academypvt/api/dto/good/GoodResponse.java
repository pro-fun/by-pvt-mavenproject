package by.academypvt.api.dto.good;


public class GoodResponse{
    private Long id;
    private Type type;
    private String name;
    private Long code;
    private Long price;
    private int quantity;

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

    @Override
    public String toString() {
        return "GoodResponse{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", code=" + code +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
