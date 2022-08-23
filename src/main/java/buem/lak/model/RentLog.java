package buem.lak.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class RentLog {
    @Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

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

    public RentLog(String id, String name, String description, LocalDateTime createdAt, LocalDateTime updatedAt, Client client, PaymentDetails paymentDetails, Rent rent, TradingPoint tradingPoint) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
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
                ", createAt=" + createdAt +
                ", updateAt=" + updatedAt +
                ", client=" + client +
                ", paymentDetails=" + paymentDetails +
                ", rent=" + rent +
                ", tradingPoint=" + tradingPoint +
                '}';
    }
}
