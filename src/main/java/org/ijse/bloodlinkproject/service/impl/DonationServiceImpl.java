package org.ijse.bloodlinkproject.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ijse.bloodlinkproject.dto.DonationDTO;
import org.ijse.bloodlinkproject.entity.BloodBank;
import org.ijse.bloodlinkproject.entity.BloodType;
import org.ijse.bloodlinkproject.entity.Donation;
import org.ijse.bloodlinkproject.entity.User;
import org.ijse.bloodlinkproject.repository.BloodBankRepository;
import org.ijse.bloodlinkproject.repository.BloodTypeRepository;
import org.ijse.bloodlinkproject.repository.DonationRepository;
import org.ijse.bloodlinkproject.repository.UserRepository;
import org.ijse.bloodlinkproject.service.BloodTypeService;
import org.ijse.bloodlinkproject.service.DonationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service

public class DonationServiceImpl implements DonationService {
    private final DonationRepository donationRepository;
    private final UserRepository userRepository;
    private final BloodTypeRepository bloodTypeRepository;
    private final BloodBankRepository bloodBankRepository;

    @Override
    public void saveDonation(DonationDTO donationDTO) {
        log.info("Saving Donation:{}",donationDTO);

             try{
                  User user = userRepository.findById(donationDTO.getUserId()).orElseThrow(()->
                          new RuntimeException("User not found"));
                  BloodType  bloodType = bloodTypeRepository.findById(donationDTO.getBloodTypeId()).orElseThrow(()->
                          new RuntimeException("BloodType not found"));
                  BloodBank bloodBank = bloodBankRepository.findById(donationDTO.getBloodBankId()).orElseThrow(()->
                          new RuntimeException("BloodBank not found"));

                  Donation donation = new Donation();
                  donation.setUser(user);
                  donation.setBloodType(bloodType);
                  donation.setBloodBank(bloodBank);
                  donation.setDonationDate(donationDTO.getDonationDate());
                  donation.setQty(donationDTO.getQty());
                  donation.setStatus(donationDTO.getStatus());

                  donationRepository.save(donation);
                  log.info("Donation saved successfully");

              }catch(Exception ex){
                  log.error("Error saving Donation:{}",donationDTO);
                  throw new RuntimeException("Failed to save donation");
              }

    }

    @Override
    public void updateDonation(DonationDTO donationDTO) {
        log.info("Updating Donation:{}",donationDTO);
        try{
            Donation donation = donationRepository.findById(donationDTO.getDonationId()).orElseThrow(()->
                    new RuntimeException("Donation not found"));
            User user = userRepository.findById(donationDTO.getUserId()).orElseThrow(()->
                    new RuntimeException("User not found"));
            BloodType bloodType = bloodTypeRepository.findById(donationDTO.getBloodTypeId()).orElseThrow(() ->
                    new RuntimeException("BloodType not found"));
            BloodBank bloodBank =  bloodBankRepository.findById(donationDTO.getBloodBankId()).orElseThrow(()->
                    new RuntimeException("BloodBank not found"));

            donation.setBloodType(bloodType);
            donation.setUser(user);
            donation.setBloodBank(bloodBank);
            donation.setDonationDate(donationDTO.getDonationDate());
            donation.setQty(donationDTO.getQty());
            donation.setStatus(donationDTO.getStatus());
            donationRepository.save(donation);
            log.info("Donation saved successfully");


        }catch(Exception e){
            log.error("Error saving Donation:{}",donationDTO);
            throw new RuntimeException("Failed to update donation");
        }

    }

    @Override
    public void deleteDonation(Long donationId) {
        log.info("Deleting Donation: {}", donationId);

        if (!donationRepository.existsById(donationId)) {
            throw new RuntimeException("Donation not found");
        }

        donationRepository.deleteById(donationId);
        log.info("Donation deleted successfully");
    }



    @Override
    public DonationDTO getDonation(Long donationId) {
        Donation donation =
                donationRepository
                        .findById(donationId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Donation not found"
                                ));

        DonationDTO dto = new DonationDTO();

        dto.setDonationId(donation.getDonationId());
        dto.setUserId(donation.getUser().getUserId());
        dto.setBloodTypeId(donation.getBloodType().getBloodTypeId());
        dto.setBloodBankId(donation.getBloodBank().getBloodBankId());
        dto.setDonationDate(donation.getDonationDate());
        dto.setQty(donation.getQty());
        dto.setStatus(donation.getStatus());

        return dto;
    }

    @Override
    public List<DonationDTO> getAllDonations() {
        return donationRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    private DonationDTO convertToDTO(Donation donation) {

        DonationDTO dto = new DonationDTO();

        dto.setDonationId(donation.getDonationId());
        dto.setUserId(donation.getUser().getUserId());
        dto.setBloodTypeId(donation.getBloodType().getBloodTypeId());
        dto.setBloodBankId(donation.getBloodBank().getBloodBankId());
        dto.setDonationDate(donation.getDonationDate());
        dto.setQty(donation.getQty());
        dto.setStatus(donation.getStatus());

        return convertToDTO(donation);
    }




    @Override
    public List<DonationDTO> getDonationsByUser(Long userId) {
        return donationRepository
                .findByUser_UserId(userId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DonationDTO> getDonationsByBloodType(Long bloodTypeId) {
        return donationRepository
                .findByBloodType_BloodTypeId(
                        bloodTypeId
                )
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DonationDTO> getDonationsByBloodBank(Long bloodBankId) {
        return donationRepository
                .findByBloodBank_BloodBankId(
                        bloodBankId
                )
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
