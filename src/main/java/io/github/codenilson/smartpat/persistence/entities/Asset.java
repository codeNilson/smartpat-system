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
import jakarta.persistence.Table;

@Entity
@Table(name = "assets")
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID uuid = UUID.randomUUID();

    @Column(unique = true)
    private Long assetCode;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    private Map<String, Object> extraProperties;

    private String administrativeUnit;

    private String locationUnit;

    @Column(nullable = false)
    private final Instant createdAt = Instant.now();

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Ownership ownership;

    public Asset() {
    }

    public Asset(Long assetCode, Category category, Map<String, Object> extraProperties,
            String administrativeUnit,
            String locationUnit,
            Ownership ownership) {
        this.assetCode = assetCode;
        this.category = category;
        this.extraProperties = extraProperties;
        this.administrativeUnit = administrativeUnit;
        this.locationUnit = locationUnit;
        this.ownership = ownership;
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

    public String getAdministrativeUnit() {
        return administrativeUnit;
    }

    public void setAdministrativeUnit(String administrativeUnit) {
        this.administrativeUnit = administrativeUnit;
    }

    public String getLocationUnit() {
        return locationUnit;
    }

    public void setLocationUnit(String locationUnit) {
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

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "id=" + id +
                ", uuid=" + uuid +
                ", assetCode=" + assetCode +
                ", category=" + category +
                ", extraProperties=" + extraProperties +
                ", administrativeUnit='" + administrativeUnit + '\'' +
                ", locationUnit='" + locationUnit + '\'' +
                ", createdAt=" + createdAt +
                ", ownership=" + ownership +
                '}';
    }
}