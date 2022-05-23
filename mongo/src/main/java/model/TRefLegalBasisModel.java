package model;

import com.pb.consensus.dto.directory.DirType;
import com.pb.consensus.dto.directory.TRefLegalBasisDTO;
import com.pb.consensus.no.sql.mongo.directory.entity.TRefLegalBasisEntity;

public class TRefLegalBasisModel extends AbstractMongoModel<TRefLegalBasisDTO, TRefLegalBasisEntity> {

    @Override
    public String getKey() {
        return DirType.LEGAL_BASIS.name();
    }

    @Override
    public TRefLegalBasisDTO entityToDTO(TRefLegalBasisEntity entity) {
        return TRefLegalBasisDTO.builder()
                .legalBasis(entity.getLegalBasis())
                .description(entity.getDescription())
                .editorLogin(entity.getEditorLogin())
                .state(entity.getState())
                .remark(entity.getRemark())
                .dtm(entity.getDtm())
                .build();
    }

    @Override
    public TRefLegalBasisEntity dtoToEntity(TRefLegalBasisDTO dto) {
        TRefLegalBasisEntity entity = new TRefLegalBasisEntity();

        entity.setLegalBasis(dto.getLegalBasis());
        entity.setDescription(dto.getDescription());
        entity.setEditorLogin(dto.getEditorLogin());
        entity.setState(dto.getState());
        entity.setRemark(dto.getRemark());

        entity.setDtm(dto.getDtm());

        return entity;
    }
}
