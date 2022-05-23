package model;

import com.pb.consensus.dto.directory.DirType;
import com.pb.consensus.dto.directory.TRefPurposeDTO;
import com.pb.consensus.no.sql.mongo.directory.entity.TRefPurposeEntity;

public class TRefPurposeModel extends AbstractMongoModel<TRefPurposeDTO, TRefPurposeEntity> {

    @Override
    public String getKey() {
        return DirType.PURPOSE.name();
    }

    @Override
    public TRefPurposeDTO entityToDTO(TRefPurposeEntity entity) {
        return TRefPurposeDTO.builder()
                .purpose(entity.getPurpose())
                .description(entity.getDescription())
                .editorLogin(entity.getEditorLogin())
                .state(entity.getState())
                .remark(entity.getRemark())
                .dtm(entity.getDtm())
                .build();
    }

    @Override
    public TRefPurposeEntity dtoToEntity(TRefPurposeDTO dto) {
        TRefPurposeEntity entity = new TRefPurposeEntity();

        entity.setPurpose(dto.getPurpose());
        entity.setDescription(dto.getDescription());
        entity.setEditorLogin(dto.getEditorLogin());
        entity.setState(dto.getState());
        entity.setRemark(dto.getRemark());

        entity.setDtm(dto.getDtm());

        return entity;
    }
}

