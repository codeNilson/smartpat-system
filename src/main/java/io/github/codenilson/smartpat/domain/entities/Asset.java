package io.github.codenilson.smartpat.domain.entities;

import java.util.Map;

public class Asset {

    private Long id;
    private Long assetCode;
    private Category category;
    private Map<String, Object> extraProperties;
    private String administrativeUnit;
    private String locationUnit;

    public Asset() {
    }

    public Asset(Long id, Long assetCode, Category category, Map<String, Object> extraProperties,
            String administrativeUnit,
            String locationUnit) {
        this.id = id;
        this.assetCode = assetCode;
        this.category = category;
        this.extraProperties = extraProperties;
        this.administrativeUnit = administrativeUnit;
        this.locationUnit = locationUnit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
