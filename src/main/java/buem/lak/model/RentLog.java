package buem.lak.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class RentLog {
    private String id;
    private String name;
    private String description;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    private Client client;
    private PaymentDetails paymentDetails;
    private Rent rent;
    private TradingPoint tradingPoint;

    public RentLog() {
    }

    public RentLog(String name, String description, Client client, PaymentDetails paymentDetails, Rent rent, TradingPoint tradingPoint) {
        this.name = name;
        this.description = description;
        this.client = client;
        this.paymentDetails = paymentDetails;
        this.rent = rent;
        this.tradingPoint = tradingPoint;
    }

    public RentLog(String id, String name, String description, LocalDateTime createAt, LocalDateTime updateAt, Client client, PaymentDetails paymentDetails, Rent rent, TradingPoint tradingPoint) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.client = client;
        this.paymentDetails = paymentDetails;
        this.rent = rent;
        this.tradingPoint = tradingPoint;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public TradingPoint getTradingPoint() {
        return tradingPoint;
    }

    public void setTradingPoint(TradingPoint tradingPoint) {
        this.tradingPoint = tradingPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentLog rentLog = (RentLog) o;
        return getId().equals(rentLog.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "RentLog{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", client=" + client +
                ", paymentDetails=" + paymentDetails +
                ", rent=" + rent +
                ", tradingPoint=" + tradingPoint +
                '}';
    }
}
