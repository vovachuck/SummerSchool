package buem.lak.model;

import java.time.LocalDateTime;

public class TradingPoint {
    private String id;
    private String name;
    private String description;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    private int floor;
    private int square;
    private int pricePerDay;
    private boolean isConditioner;
    private boolean isAvailable;
}
