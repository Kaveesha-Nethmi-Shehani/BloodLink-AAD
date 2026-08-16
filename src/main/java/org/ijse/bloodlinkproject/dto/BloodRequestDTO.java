package org.ijse.bloodlinkproject.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ijse.bloodlinkproject.enumiration.BloodRequestStatus;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodRequestDTO {
    private Long bloodRequestId;
    private Long userId;
    private Long bloodBankId;
    private Long bloodTypeId;
    private int requiredUnit;
    private LocalDate requiredDate;
    private String reason;
    private BloodRequestStatus status;
}
