package io.github.codenilson.smartpat.persistence.entities;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

import io.github.codenilson.smartpat.persistence.valueobjects.Ownership;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "assets")
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID uuid;

    @Column(unique = true)
    private Long assetCode;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "extra_properties")
    private Map<String, Object> extraProperties;

    @ManyToOne
    @JoinColumn(name = "location_unit_id")
    private LocationUnit locationUnit;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Ownership ownership;

    @Column(name = "image_path")
    private String imagePath;

    @Column(nullable = false, name = "created_at")
    private Instant createdAt;

    public Asset() {
    }

    public Asset(Long assetCode,
            Category category,
            Map<String, Object> extraProperties,
            LocationUnit locationUnit,
            Ownership ownership,
            String imagePath) {
        this.assetCode = assetCode;
        this.category = category;
        this.extraProperties = extraProperties;
        this.locationUnit = locationUnit;
        this.ownership = ownership;
        this.imagePath = imagePath;
    }

    public Long getId() {
        return id;
    }

    public Long getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(Long assetCode) {
        this.assetCode = assetCode;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Map<String, Object> getExtraProperties() {
        return extraProperties;
    }

    public void setExtraProperties(Map<String, Object> extraProperties) {
        this.extraProperties = extraProperties;
    }

    public LocationUnit getLocationUnit() {
        return locationUnit;
    }

    public void setLocationUnit(LocationUnit locationUnit) {
        this.locationUnit = locationUnit;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Ownership getOwnership() {
        return ownership;
    }

    public void setOwnership(Ownership ownership) {
        this.ownership = ownership;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public UUID getUuid() {
        return uuid;
    }

    @PrePersist
    public void prePersist() {
        uuid = UUID.randomUUID();
        createdAt = Instant.now();
    }

    @Override
    public String toString() {
        return "Asset{" +
                "id=" + id +
                ", uuid=" + uuid +
                ", assetCode=" + assetCode +
                ", category=" + category +
                ", extraProperties=" + extraProperties +
                ", locationUnit=" + locationUnit +
                ", ownership=" + ownership +
                ", imagePath='" + imagePath + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}