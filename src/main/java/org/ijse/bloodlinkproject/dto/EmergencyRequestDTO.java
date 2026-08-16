package org.ijse.bloodlinkproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmergencyRequestDTO {

    private Long emergencyRequestId;
    private Long userId;
    private Long bloodTypeId;
    private Long bloodBankId;
    private String patientName;
    private int requiredUnits;
    private String reason;
    private int urgencyLevel;



}
