package buem.lak.model;

import java.time.LocalDateTime;

public class RentLog {
    private String id;
    private String name;
    private String description;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    private Client client;
    private Details details;
    private Rent rent;
    private TradingPoint tradingPoint;
}
