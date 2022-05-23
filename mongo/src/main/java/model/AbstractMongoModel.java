package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Document
@AllArgsConstructor
public abstract class AbstractMongoModel<DTO, Entity> implements MongoModel<DTO, Entity> {

    @Id
    private String key;

    private List<Entity> entities;

    public AbstractMongoModel() {
        key = getKey();
        entities = new ArrayList<>();
    }

    @Override
    public List<DTO> toDTOs() {
        return entities.stream().map(this::entityToDTO).collect(Collectors.toList());
    }

    @Override
    public void toEntities(List<DTO> dto) {
        dto.stream().map(this::dtoToEntity).forEach(entities::add);
    }
}
