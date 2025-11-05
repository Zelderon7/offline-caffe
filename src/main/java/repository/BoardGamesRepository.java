package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import models.Entities.BoardGames;

@ApplicationScoped
public class BoardGamesRepository implements PanacheRepository<BoardGames> {
}
