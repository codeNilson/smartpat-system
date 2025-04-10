package io.github.codenilson.smartpat.entities;

import java.util.Map;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column(unique = true)
    private Long assetCode;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    private Map<String, Object> extraProperties;

    private String administrativeUnit;

    private String locationUnit;

    // private String property;

    

    public Asset() {
    }

    public Asset(Long assetCode, Category category, Map<String, Object> extraProperties, String administrativeUnit,
            String locationUnit) {
        this.assetCode = assetCode;
        this.category = category;
        this.extraProperties = extraProperties;
        this.administrativeUnit = administrativeUnit;
        this.locationUnit = locationUnit;
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

    // public String getProperty() {
    // return property;
    // }

    // public void setProperty(String property) {

    // this.property = property;
    // }

    @Override
    public String toString() {
        return "Asset{" +
                "id=" + id +
                ", assetCode=" + assetCode +
                ", category=" + category +
                ", extraProperties=" + extraProperties +
                ", administrativeUnit='" + administrativeUnit + '\'' +
                ", locationUnit='" + locationUnit + '\'' +
                '}';
    }
}