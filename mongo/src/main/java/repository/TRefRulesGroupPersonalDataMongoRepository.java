package repository;

import com.pb.consensus.no.sql.mongo.config.db.DirectoryConfig;
import com.pb.consensus.no.sql.mongo.directory.model.TRefRulesGroupPersonalDataModel;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.data.mongodb.repository.MongoRepository;

@ConditionalOnBean(DirectoryConfig.class)
public interface TRefRulesGroupPersonalDataMongoRepository extends MongoRepository<TRefRulesGroupPersonalDataModel, String> {

}