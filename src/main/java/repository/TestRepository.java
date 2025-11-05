package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import models.Entities.TestEntity;

@ApplicationScoped
public class TestRepository implements PanacheRepository<TestEntity> {

}
