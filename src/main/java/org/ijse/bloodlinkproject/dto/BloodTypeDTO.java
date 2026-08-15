package org.ijse.bloodlinkproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BloodTypeDTO {
    private long bloodTypeId;
    private String bloodTypeGroup;
    private String rh_factory;

    //SP
    private boolean active;

}
