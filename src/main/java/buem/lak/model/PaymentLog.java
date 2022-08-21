package buem.lak.model;

import java.time.LocalDateTime;

public class PaymentLog {
    private String id;
    private String name;
    private String description;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    private Client client;
    private Payment payment;
}
