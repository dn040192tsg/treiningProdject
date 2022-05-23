package consent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class GroupPersonalDataEntity {

    @Id
    private Integer clientID;

    private List<ConsentByGroupPersonalDataEntity> consentByGroupPersonalDataEntityList;
}
