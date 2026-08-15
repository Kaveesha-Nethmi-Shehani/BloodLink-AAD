package org.ijse.bloodlinkproject.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ijse.bloodlinkproject.enumiration.InventoryStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class BloodInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;
    private int availableUnit;
    private LocalDateTime lastUpdate;


    @Enumerated(EnumType.STRING)
    private InventoryStatus status;

    @ManyToOne
    @JoinColumn(name = "bloodTypeId", nullable = false)
    private BloodType bloodType;

    @ManyToOne
    @JoinColumn(name = "bloodBankId", nullable = false)
    private BloodBank bloodBank;


}
