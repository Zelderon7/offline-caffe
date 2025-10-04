package models;

// ==================== FILM_ACTOR COMPOSITE KEY ====================

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
class FilmActorId implements Serializable {

    @Column(name = "actor_id")
    private Short actorId;

    @Column(name = "film_id")
    private Short filmId;

    // ==================== CONSTRUCTORS ====================

    public FilmActorId() {
    }

    public FilmActorId(Short actorId, Short filmId) {
        this.actorId = actorId;
        this.filmId = filmId;
    }

    // ==================== GETTERS & SETTERS ====================

    public Short getActorId() {
        return actorId;
    }

    public void setActorId(Short actorId) {
        this.actorId = actorId;
    }

    public Short getFilmId() {
        return filmId;
    }

    public void setFilmId(Short filmId) {
        this.filmId = filmId;
    }

    // ==================== EQUALS & HASHCODE ====================
    // CRITICAL: Must implement equals() and hashCode() for composite keys

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FilmActorId)) return false;
        FilmActorId that = (FilmActorId) o;
        return Objects.equals(actorId, that.actorId) &&
                Objects.equals(filmId, that.filmId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, filmId);
    }
}
