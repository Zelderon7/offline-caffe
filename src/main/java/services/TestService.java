package services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import models.Entities.TestEntity;

@ApplicationScoped
public class TestService {
    @Transactional
    public TestEntity createTestEntity(String name, String email) {
        TestEntity testEntity = new TestEntity(name, email);
        testEntity.persist();
        return testEntity;
    }
}
