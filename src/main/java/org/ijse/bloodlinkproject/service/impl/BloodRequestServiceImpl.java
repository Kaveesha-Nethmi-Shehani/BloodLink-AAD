package org.ijse.bloodlinkproject.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ijse.bloodlinkproject.dto.BloodRequestDTO;
import org.ijse.bloodlinkproject.entity.BloodBank;
import org.ijse.bloodlinkproject.entity.BloodRequest;
import org.ijse.bloodlinkproject.entity.BloodType;
import org.ijse.bloodlinkproject.entity.User;
import org.ijse.bloodlinkproject.enumiration.BloodRequestStatus;
import org.ijse.bloodlinkproject.repository.BloodBankRepository;
import org.ijse.bloodlinkproject.repository.BloodRequestRepository;
import org.ijse.bloodlinkproject.repository.BloodTypeRepository;
import org.ijse.bloodlinkproject.repository.UserRepository;
import org.ijse.bloodlinkproject.service.BloodRequestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BloodRequestServiceImpl implements BloodRequestService {

    private final BloodRequestRepository bloodRequestRepository;
    private final UserRepository userRepository;
    private final BloodTypeRepository bloodTypeRepository;
    private final BloodBankRepository bloodBankRepository;


    @Override
    public void saveBloodRequest(BloodRequestDTO dto) {
        log.info("Saving Blood Request: {}", dto);

        User user = userRepository.findById(dto.getUserId()).orElseThrow(() ->
                        new RuntimeException("User not found"));

        BloodType bloodType = bloodTypeRepository.findById(dto.getBloodTypeId()).orElseThrow(() ->
                        new RuntimeException("Blood Type not found"));

        BloodBank bloodBank = bloodBankRepository.findById(dto.getBloodBankId()).orElseThrow(() ->
                        new RuntimeException("Blood Bank not found"));


        BloodRequest bloodRequest = new BloodRequest();

        bloodRequest.setUser(user);
        bloodRequest.setBloodType(bloodType);
        bloodRequest.setBloodBank(bloodBank);
        bloodRequest.setRequiredUnit(dto.getRequiredUnit());
        bloodRequest.setRequiredDate(dto.getRequiredDate());
        bloodRequest.setReason(dto.getReason());

        // User save note create status manually
        bloodRequest.setStatus(BloodRequestStatus.PENDING);
        bloodRequestRepository.save(bloodRequest);
    }


    @Override
    public void updateBloodRequest(BloodRequestDTO dto) {

        BloodRequest bloodRequest = bloodRequestRepository.findById(dto.getBloodRequestId()).orElseThrow(() ->
                                new RuntimeException("Blood Request not found"));

        User user = userRepository.findById(dto.getUserId()).orElseThrow(() ->
                        new RuntimeException("User not found"));

        BloodType bloodType = bloodTypeRepository.findById(dto.getBloodTypeId()).orElseThrow(() ->
                                new RuntimeException("Blood Type not found"));

        BloodBank bloodBank = bloodBankRepository.findById(dto.getBloodBankId()).orElseThrow(() ->
                                new RuntimeException("Blood Bank not found"));


        bloodRequest.setUser(user);
        bloodRequest.setBloodType(bloodType);
        bloodRequest.setBloodBank(bloodBank);

        bloodRequest.setRequiredUnit(dto.getRequiredUnit());
        bloodRequest.setRequiredDate(dto.getRequiredDate());
        bloodRequest.setReason(dto.getReason());
        bloodRequest.setStatus(dto.getStatus());


        bloodRequestRepository.save(bloodRequest);
    }


    @Override
    public void deleteBloodRequest(Long bloodRequestId) {

        if (!bloodRequestRepository.existsById(bloodRequestId)) {
            throw new RuntimeException("Blood Request not found");
        }

        bloodRequestRepository.deleteById(bloodRequestId);
    }

    @Override
    public BloodRequestDTO getBloodRequest(Long bloodRequestId) {

        BloodRequest bloodRequest = bloodRequestRepository.findById(bloodRequestId).orElseThrow(() ->
                new RuntimeException("Blood Request not found"));


        return convertToDTO(bloodRequest);
    }


    @Override
    public List<BloodRequestDTO> getAllBloodRequests() {
        return bloodRequestRepository.findAll().stream().map(this::convertToDTO).toList();
    }

    private BloodRequestDTO convertToDTO(BloodRequest bloodRequest) {

        BloodRequestDTO dto = new BloodRequestDTO();

        dto.setBloodRequestId(bloodRequest.getBloodRequestId());
        dto.setUserId(bloodRequest.getUser().getUserId());
        dto.setBloodTypeId(bloodRequest.getBloodType().getBloodTypeId());
        dto.setBloodBankId(bloodRequest.getBloodBank().getBloodBankId());
        dto.setRequiredUnit(bloodRequest.getRequiredUnit());
        dto.setRequiredDate(bloodRequest.getRequiredDate());
        dto.setReason(bloodRequest.getReason());
        dto.setStatus(bloodRequest.getStatus());

        return dto;
    }
}