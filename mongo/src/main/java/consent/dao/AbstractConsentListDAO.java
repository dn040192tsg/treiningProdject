package consent.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

public abstract class AbstractConsentListDAO<Entity, DTO, Key> implements AbstractDAO<Entity, DTO> {

    protected MongoRepository<Entity, Key> repository;

    protected AbstractConsentListDAO(MongoRepository<Entity, Key> repository) {
        this.repository = repository;
    }
}
