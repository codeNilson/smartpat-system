package io.github.codenilson.smartpat.persistence.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "location_unit")
public class LocationUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "administrative_unit_id", nullable = false)
    private AdministrativeUnit administrativeUnit;

    @OneToMany(mappedBy = "locationUnit")
    private List<Asset> assets = new ArrayList<>();

    public LocationUnit() {
    }

    public LocationUnit(String name, AdministrativeUnit administrativeUnit) {
        this.name = name;
        this.administrativeUnit = administrativeUnit;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AdministrativeUnit getAdministrativeUnit() {
        return administrativeUnit;
    }

    public void setAdministrativeUnit(AdministrativeUnit administrativeUnit) {
        this.administrativeUnit = administrativeUnit;
    }

}
