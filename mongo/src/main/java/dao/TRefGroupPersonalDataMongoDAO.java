package dao;

import com.pb.consensus.dto.directory.TRefGroupPersonalDataDTO;
import com.pb.consensus.no.sql.mongo.directory.model.AbstractMongoModel;
import com.pb.consensus.no.sql.mongo.directory.model.TRefGroupPersonalDataModel;
import com.pb.consensus.no.sql.mongo.directory.repository.TRefGroupPersonalDataMongoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@AllArgsConstructor
public class TRefGroupPersonalDataMongoDAO implements DirectoryDAO<TRefGroupPersonalDataDTO> {

    private final TRefGroupPersonalDataMongoRepository repository;

    @Override
    public List<TRefGroupPersonalDataDTO> getDirectory() {
        return repository.findById(new TRefGroupPersonalDataModel().getKey())
                .map(AbstractMongoModel::toDTOs)
                .orElse(Collections.emptyList());
    }

    @Override
    public void putDirectory(List<TRefGroupPersonalDataDTO> directory) {
        TRefGroupPersonalDataModel model = new TRefGroupPersonalDataModel();
        model.toEntities(directory);
        repository.save(model);
    }
}
