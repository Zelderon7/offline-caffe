package models.Entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "types")
public class GameTypes extends PanacheEntity {

    @NotBlank
    @Column(unique = true)
    @Size(max = 100)
    public String name;

    @Size(max = 500)
    public String description;

    @ManyToMany(mappedBy = "gameTypes")  // ✓ Fixed
    public Set<BoardGames> games = new HashSet<>();  // ✓ Initialize

    public GameTypes() {
    }

    public GameTypes(String name) {
        this.name = name;
        this.description = "";
    }

    public GameTypes(String name, String description) {
        this.name = name;
        this.description = description;
    }
}