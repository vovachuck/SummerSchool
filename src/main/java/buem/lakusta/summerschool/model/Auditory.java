package buem.lakusta.summerschool.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Auditory {
    private String id;
    private String name;
    private int capacity;
    private AuditoryType type;
    private boolean hasProjector;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Auditory(String name, int capacity, AuditoryType type, boolean hasProjector, String description) {
        this.name = name;
        this.capacity = capacity;
        this.type = type;
        this.hasProjector = hasProjector;
        this.description = description;
    }

    public Auditory(String id, String name, int capacity, AuditoryType type, boolean hasProjector, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.type = type;
        this.hasProjector = hasProjector;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public AuditoryType getType() {
        return type;
    }

    public void setType(AuditoryType type) {
        this.type = type;
    }

    public boolean isHasProjector() {
        return hasProjector;
    }

    public void setHasProjector(boolean hasProjector) {
        this.hasProjector = hasProjector;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auditory auditory = (Auditory) o;
        return getId().equals(auditory.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Auditory{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", type=" + type +
                ", hasProjector=" + hasProjector +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
