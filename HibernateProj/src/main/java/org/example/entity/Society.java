package org.example.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Society")
public class Society {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;

    @OneToMany
    private List<Building> buildings;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

    public Society() {
    }

    public Society(String name, String address, List<Building> buildings) {
        this.name = name;
        this.address = address;
        this.buildings = buildings;
    }

    @Override
    public String toString() {
        return "Society{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", buildings=" + buildings +
                '}';
    }
}
