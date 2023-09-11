package by.academypvt.domain;

public class Basket {
    private Long id;
    private Long productId;
    private Long orderId;
    private Long count;

    public Basket(Long id, Long productId, Long orderId, Long count) {
        this.id = id;
        this.productId = productId;
        this.orderId = orderId;
        this.count = count;
    }

    public Basket() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", productId=" + productId +
                ", orderId=" + orderId +
                ", count=" + count +
                '}';
    }
}
