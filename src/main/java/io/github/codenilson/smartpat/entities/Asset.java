package io.github.codenilson.smartpat.entities;

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
    private Long inventoryId;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    private String administrativeUnit;

    private String locationUnit;

    // private String property;

    public Asset(Long inventoryId, Category category, String administrativeUnit, String locationUnit) {
        this.inventoryId = inventoryId;
        this.category = category;
        this.administrativeUnit = administrativeUnit;
        this.locationUnit = locationUnit;
    }

    public Asset() {
    }

    public Long getId() {
        return id;
    }

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Asset other = (Asset) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Asset [id=" + id + ", inventoryId=" + inventoryId + ", category=" + category + ", administrativeUnit="
                + administrativeUnit + ", locationUnit=" + locationUnit + "]";
    }

}
