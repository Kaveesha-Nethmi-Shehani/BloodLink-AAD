package org.ijse.bloodlinkproject.service;

import org.ijse.bloodlinkproject.dto.DonationDTO;

import java.util.List;

public interface DonationService {
    void saveDonation(DonationDTO donationDTO);

    void updateDonation(DonationDTO donationDTO);

    void deleteDonation(Long donationId);

    DonationDTO getDonation(Long donationId);

    List<DonationDTO> getAllDonations();

    List<DonationDTO> getDonationsByUser(Long userId);

    List<DonationDTO> getDonationsByBloodType(Long bloodTypeId);

    List<DonationDTO> getDonationsByBloodBank(Long bloodBankId);
}
