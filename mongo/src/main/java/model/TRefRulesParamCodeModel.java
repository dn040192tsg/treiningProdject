package model;

import com.pb.consensus.dto.directory.DirType;
import com.pb.consensus.dto.directory.TRefRulesParamCodeDTO;
import com.pb.consensus.no.sql.mongo.directory.entity.TRefRulesParamCodeEntity;

public class TRefRulesParamCodeModel extends AbstractMongoModel<TRefRulesParamCodeDTO, TRefRulesParamCodeEntity> {

    @Override
    public String getKey() {
        return DirType.RULES_PARAM_CODE.name();
    }

    @Override
    public TRefRulesParamCodeDTO entityToDTO(TRefRulesParamCodeEntity entity) {
        return TRefRulesParamCodeDTO.builder()
                .purpose(entity.getPurpose())
                .paramCode(entity.getParamCode())
                .additionalStoragePeriod(entity.getAdditionalStoragePeriod())
                .legalBasis(entity.getLegalBasis())
                .permissionRequired(entity.getPermissionRequired())
                .editorLogin(entity.getEditorLogin())
                .state(entity.getState())
                .remark(entity.getRemark())
                .dtm(entity.getDtm())
                .build();
    }

    @Override
    public TRefRulesParamCodeEntity dtoToEntity(TRefRulesParamCodeDTO dto) {
        TRefRulesParamCodeEntity entity = new TRefRulesParamCodeEntity();

        entity.setParamCode(dto.getParamCode());
        entity.setAdditionalStoragePeriod(dto.getAdditionalStoragePeriod());
        entity.setLegalBasis(dto.getLegalBasis());
        entity.setPurpose(dto.getPurpose());
        entity.setPermissionRequired(dto.getPermissionRequired());
        entity.setEditorLogin(dto.getEditorLogin());
        entity.setState(dto.getState());
        entity.setRemark(dto.getRemark());

        entity.setDtm(dto.getDtm());

        return entity;
    }
}


