package by.academypvt.api.dto.good;


public class GoodResponse{
    private Long id;
    private Role role;
    private String name;
    private Long code;
    private Long price;

    public GoodResponse(Long id, Role role, String name, Long code, Long price) {
        this.id = id;
        this.role = role;
        this.name = name;
        this.code = code;
        this.price = price;
    }
}
