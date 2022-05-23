package consent.dao;

public interface AbstractDAO<Entity, DTO> {

    void save(DTO dto);

    Entity dtoToEntity(DTO dto);

    DTO entityToDTO(Entity entity);
}
