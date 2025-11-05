package services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import models.DTOs.CreateTestRequest;
import models.Entities.TestEntity;

@ApplicationScoped
public class TestService {
    @Transactional
    public Long createTestEntity(CreateTestRequest data) {
        TestEntity testEntity = new TestEntity(data.getName(), data.getEmail());
        testEntity.persist();
        return testEntity.id;
    }
}
