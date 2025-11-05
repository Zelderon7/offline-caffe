package models.Entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "board_games")
public class BoardGames extends PanacheEntity {

    @NotBlank
    @Column(unique = true, nullable = false)
    @Size(min = 1, max = 150)
    public String name;

    @Size(max = 500)
    public String description;

    @Size(max = 100)
    public String author;

    @Size(max = 100)
    public String designer;

    @Size(max = 100)
    public String publisher;

    @NotNull
    @Min(1800)
    @Max(2025)
    public Integer releaseYear;

    @NotNull
    @Min(1)
    @Max(100)
    public Integer minPlayers;

    @NotNull
    @Min(1)
    @Max(100)
    public Integer maxPlayers;

    @NotNull
    @Min(1)
    @Max(120)
    public Integer setupDuration;

    @NotNull
    @Min(5)
    @Max(480)
    public Integer playDuration;

    @NotNull
    @Min(1)
    @Max(100)
    public Integer difficultyLevel;

    public Boolean isAvailable;

    @ManyToMany
    @JoinTable(
            name = "game_types",
            joinColumns = @JoinColumn(name = "board_game_id"),
            inverseJoinColumns = @JoinColumn(name = "game_type_id")
    )
    public Set<GameTypes> gameTypes = new HashSet<>();  // ✓ Initialize

    @ManyToMany
    @JoinTable(
            name = "game_genres"
    )
    public Set<GameGenres> gameGanres = new HashSet<>();
}