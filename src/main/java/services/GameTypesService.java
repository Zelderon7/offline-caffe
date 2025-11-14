package services;

import jakarta.enterprise.context.ApplicationScoped;
import models.Entities.GameTypes;

import java.util.Optional;

@ApplicationScoped
public class GameTypesService {

    public GameTypes create(final GameTypes data) {
        GameTypes newGameType = new GameTypes(data.name, data.description);
        newGameType.persist();
        return newGameType;
    }
}
