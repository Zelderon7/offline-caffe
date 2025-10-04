package models;

// ==================== FILM_ACTOR ENTITY ====================

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "film_actor")
class FilmActor {

    @EmbeddedId
    private FilmActorId id = new FilmActorId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("actorId")
    @JoinColumn(name = "actor_id", nullable = false)
    private Actor actor;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("filmId")
    @JoinColumn(name = "film_id", nullable = false)
    private Film film;

    @NotNull
    @Column(name = "last_update", nullable = false, updatable = false, insertable = false)
    private LocalDateTime lastUpdate;

    // ==================== CONSTRUCTORS ====================

    public FilmActor() {
    }

    public FilmActor(Actor actor, Film film) {
        this.actor = actor;
        this.film = film;
        this.id = new FilmActorId(actor.getId(), film.getId());
    }

    // ==================== GETTERS & SETTERS ====================

    public FilmActorId getId() {
        return id;
    }

    public void setId(FilmActorId id) {
        this.id = id;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
        this.id.setActorId(actor.getId());
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
        this.id.setFilmId(film.getId());
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    // ==================== EQUALS & HASHCODE ====================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FilmActor)) return false;
        FilmActor that = (FilmActor) o;
        return Objects.equals(actor, that.actor) &&
                Objects.equals(film, that.film);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actor, film);
    }

    @Override
    public String toString() {
        return "FilmActor{" +
                "actorId=" + id.getActorId() +
                ", filmId=" + id.getFilmId() +
                '}';
    }
}