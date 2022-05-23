package consent.repository;

import com.pb.consensus.no.sql.mongo.client.consent.entity.ParamCodeDataEntity;
import com.pb.consensus.no.sql.mongo.config.db.ClientConsentConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.data.mongodb.repository.MongoRepository;

@ConditionalOnBean(ClientConsentConfig.class)
public interface ParamCodeDataRepository extends MongoRepository<ParamCodeDataEntity, Integer> {

}