package models.Entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "genres")
public class GameGenres extends PanacheEntity {
    @Column(unique = true, nullable = false)
    @NotBlank
    @Max(100)
    public String name;
    @Max(500)
    public String description;

    @ManyToMany(mappedBy = "gameGanres")
    public Set<BoardGames> boardGames = new HashSet<>();

    public GameGenres() {
    }

    public GameGenres(String name) {
        this.name = name;
    }

    public GameGenres(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
