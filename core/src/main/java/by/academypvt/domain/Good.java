package by.academypvt.domain;
import by.academypvt.api.dto.good.Type;

import java.io.Serializable;
import java.util.Objects;

public class Good implements Serializable {
    private static final long serialVersionUID = -7994607932307928487L;
    private Long id;
    private Type type;
    private String name;
    private Long code;
    private Long price;
    private int quantity;

    public Good(Long id, Type type, String name, Long code, Long price, Integer quantity) {
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

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", code=" + code +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return quantity == good.quantity && Objects.equals(id, good.id) && type == good.type && Objects.equals(name, good.name) && Objects.equals(code, good.code) && Objects.equals(price, good.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, name, code, price, quantity);
    }
}
