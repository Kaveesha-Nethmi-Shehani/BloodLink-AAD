package org.ijse.bloodlinkproject.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodBankDTO {
    private Long bloodBankId;
    private String bloodBankName;
    private String bloodBankAddress;
    private String bloodBankLocation;
    private String bloodBankContact;
    private boolean active;
}
