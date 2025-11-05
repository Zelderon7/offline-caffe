package services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import repository.BoardGamesRepository;

@ApplicationScoped
public class BoardGamesService {
    @Inject
    BoardGamesRepository repository;

    public Integer getCount(){
        return ((int) repository.count());
    }
}
