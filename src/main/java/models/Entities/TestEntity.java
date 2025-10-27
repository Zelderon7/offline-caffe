package models.Entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TestEntity extends PanacheEntity {
//    @Id
//    Integer id;
    String name;
    String email;

    public TestEntity(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public TestEntity() {

    }

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}