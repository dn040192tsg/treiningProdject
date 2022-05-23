package consent.repository;

import com.pb.consensus.no.sql.mongo.client.consent.entity.GroupPersonalDataEntity;
import com.pb.consensus.no.sql.mongo.config.db.ClientConsentConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.data.mongodb.repository.MongoRepository;

@ConditionalOnBean(ClientConsentConfig.class)
public interface GroupPersonalDataRepository extends MongoRepository<GroupPersonalDataEntity, Integer> {

}

