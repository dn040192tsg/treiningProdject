package consent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsentByParamCodeEntity {

    private String legalBasis;
    private Integer purpose;
    private String paramCode;
    private String paramValue;
    private String sysID;
    private String editorLogin;
    private String state;
    private String remark;

    private Timestamp dtm;
}
