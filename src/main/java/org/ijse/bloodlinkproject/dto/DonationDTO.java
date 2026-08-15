package org.ijse.bloodlinkproject.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationDTO {
    private Long donationId;
    private Long userId;
    private Long bloodTypeId;
    private Long bloodBankId;
    private LocalDate donationDate;
    private int qty;
    private String Status;
}
