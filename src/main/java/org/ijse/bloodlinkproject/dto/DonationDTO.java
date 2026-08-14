package org.ijse.bloodlinkproject.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationDTO {
    private long donationId;
    private long userId;
    private long bloodTypeId;
    private long bloodBankId;
    private LocalDate donationDate;
    private int qty;
    private String Status;
}
