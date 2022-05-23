package model;

import java.util.List;

public interface MongoModel<DTO, Entity> {

    String getKey();

    List<DTO> toDTOs();

    void toEntities(List<DTO> dto);

    DTO entityToDTO(Entity entity);

    Entity dtoToEntity(DTO dto);
}
