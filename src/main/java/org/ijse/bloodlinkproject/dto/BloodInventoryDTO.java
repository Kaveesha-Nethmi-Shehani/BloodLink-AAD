package org.ijse.bloodlinkproject.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ijse.bloodlinkproject.enumiration.InventoryStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodInventoryDTO {

    private Long inventoryId;
    private Long bloodBankId;
    private Long bloodTypeId;
    private int availableUnit;
    private LocalDateTime lastUpdate;
    private InventoryStatus status;


}
