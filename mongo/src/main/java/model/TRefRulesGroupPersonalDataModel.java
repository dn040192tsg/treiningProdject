package model;




public class TRefRulesGroupPersonalDataModel extends AbstractMongoModel<TRefRulesGroupPersonalDataDTO, TRefRulesGroupPersonalDataEntity> {

    @Override
    public String getKey() {
        return DirType.RULES_GROUP_PERSONAL_DATA.name();
    }

    @Override
    public TRefRulesGroupPersonalDataDTO entityToDTO(TRefRulesGroupPersonalDataEntity entity) {
        return TRefRulesGroupPersonalDataDTO.builder()
                .purpose(entity.getPurpose())
                .groupPersonalData(entity.getGroupPersonalData())
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
    public TRefRulesGroupPersonalDataEntity dtoToEntity(TRefRulesGroupPersonalDataDTO dto) {
        TRefRulesGroupPersonalDataEntity entity = new TRefRulesGroupPersonalDataEntity();

        entity.setGroupPersonalData(dto.getGroupPersonalData());
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


