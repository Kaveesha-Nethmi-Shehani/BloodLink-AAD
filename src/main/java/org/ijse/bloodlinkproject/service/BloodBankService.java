package org.ijse.bloodlinkproject.service;

import org.ijse.bloodlinkproject.dto.BloodBankDTO;

import java.util.List;

public interface BloodBankService {
    void saveBloodBank(BloodBankDTO bloodBankDTO);
    void updateBloodBank(BloodBankDTO bloodBankDTO);
    void deleteBloodBankById(Long id);
    BloodBankDTO getBloodBankBy(Long bloodBankId);
    List<BloodBankDTO> getAllBloodBanks();


}
