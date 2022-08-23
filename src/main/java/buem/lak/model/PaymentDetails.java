package buem.lak.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class PaymentDetails {
    @Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String iban;
    private String cardNumber;
    private String securityCode;
    private LocalDateTime expirationDate;

    public PaymentDetails() {
    }

    public PaymentDetails(String name, String description, String iban, String cardNumber, String securityCode, LocalDateTime expirationDate) {
        this.name = name;
        this.description = description;
        this.iban = iban;
        this.cardNumber = cardNumber;
        this.securityCode = securityCode;
        this.expirationDate = expirationDate;
    }

    public PaymentDetails(String id, String name, String description, LocalDateTime createdAt, LocalDateTime updatedAt, String iban, String cardNumber, String securityCode, LocalDateTime expirationDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.iban = iban;
        this.cardNumber = cardNumber;
        this.securityCode = securityCode;
        this.expirationDate = expirationDate;
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

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentDetails that = (PaymentDetails) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "PaymentDetails{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createAt=" + createdAt +
                ", updateAt=" + updatedAt +
                ", iban='" + iban + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", securityCode='" + securityCode + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                '}';
    }
}
