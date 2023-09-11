package by.academypvt.api.dto.order;

public class OrderRequest {
    private Long id;
    private Long userId;
    private Double cost;
    private State state;

    public OrderRequest(Long id, Long userId, Double cost, State state) {
        this.id = id;
        this.userId = userId;
        this.cost = cost;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "id=" + id +
                ", userId=" + userId +
                ", cost=" + cost +
                ", state=" + state +
                '}';
    }
}
