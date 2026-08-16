package org.ijse.bloodlinkproject.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ijse.bloodlinkproject.enumiration.BloodRequestStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodRequestHistoryDTO {
    private Long bloodRequestHistoryId;
    private Long bloodRequestId;
    private String remark;
    private LocalDateTime changesAt;
    private BloodRequestStatus status;


}
