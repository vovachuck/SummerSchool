package buem.lak.model;

import java.time.LocalDateTime;
import java.util.Objects;

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

    public TradingPoint() {
    }

    public TradingPoint(String name, String description, int floor, int square, int pricePerDay, boolean isConditioner, boolean isAvailable) {
        this.name = name;
        this.description = description;
        this.floor = floor;
        this.square = square;
        this.pricePerDay = pricePerDay;
        this.isConditioner = isConditioner;
        this.isAvailable = isAvailable;
    }

    public TradingPoint(String id, String name, String description, LocalDateTime createAt, LocalDateTime updateAt, int floor, int square, int pricePerDay, boolean isConditioner, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.floor = floor;
        this.square = square;
        this.pricePerDay = pricePerDay;
        this.isConditioner = isConditioner;
        this.isAvailable = isAvailable;
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

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public boolean isConditioner() {
        return isConditioner;
    }

    public void setConditioner(boolean conditioner) {
        isConditioner = conditioner;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradingPoint that = (TradingPoint) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "TradingPoint{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", floor=" + floor +
                ", square=" + square +
                ", pricePerDay=" + pricePerDay +
                ", isConditioner=" + isConditioner +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
