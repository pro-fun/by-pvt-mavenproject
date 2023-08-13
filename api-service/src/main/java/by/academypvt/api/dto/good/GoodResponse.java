package by.academypvt.api.dto.good;


public class GoodResponse{
    private Long id;
    private Type type;
    private String name;
    private Long code;
    private Long price;

    public GoodResponse(Long id, Type type, String name, Long code, Long price) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.code = code;
        this.price = price;
    }
}
