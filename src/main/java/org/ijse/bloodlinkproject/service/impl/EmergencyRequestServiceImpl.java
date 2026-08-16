package org.ijse.bloodlinkproject.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ijse.bloodlinkproject.dto.EmergencyRequestDTO;
import org.ijse.bloodlinkproject.entity.BloodBank;
import org.ijse.bloodlinkproject.entity.BloodType;
import org.ijse.bloodlinkproject.entity.EmergencyRequest;
import org.ijse.bloodlinkproject.entity.User;
import org.ijse.bloodlinkproject.repository.BloodBankRepository;
import org.ijse.bloodlinkproject.repository.BloodTypeRepository;
import org.ijse.bloodlinkproject.repository.EmergencyRequestRepository;
import org.ijse.bloodlinkproject.repository.UserRepository;
import org.ijse.bloodlinkproject.service.EmergencyRequestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmergencyRequestServiceImpl implements EmergencyRequestService {

    private final EmergencyRequestRepository emergencyRequestRepository;
    private final UserRepository userRepository;
    private final BloodTypeRepository bloodTypeRepository;
    private final BloodBankRepository bloodBankRepository;


    // SAVE
    @Override
    public void saveEmergencyRequest(EmergencyRequestDTO dto) {
        log.info("Saving Emergency Request: {}", dto);

        User user = userRepository.findById(dto.getUserId()).orElseThrow(() ->
                new RuntimeException("User not found"));

        BloodType bloodType = bloodTypeRepository.findById(dto.getBloodTypeId()).orElseThrow(() ->
                        new RuntimeException("Blood Type not found"));

        BloodBank bloodBank = bloodBankRepository.findById(dto.getBloodBankId()).orElseThrow(() ->
                        new RuntimeException("Blood Bank not found"));


        EmergencyRequest emergencyRequest = new EmergencyRequest();

        emergencyRequest.setUser(user);
        emergencyRequest.setBloodType(bloodType);
        emergencyRequest.setBloodBank(bloodBank);
        emergencyRequest.setPatientName(dto.getPatientName());
        emergencyRequest.setRequiredUnits(dto.getRequiredUnits());
        emergencyRequest.setReason(dto.getReason());
        emergencyRequest.setUrgencyLevel(dto.getUrgencyLevel());

        emergencyRequestRepository.save(emergencyRequest);
    }

    // UPDATE
    @Override
    public void updateEmergencyRequest(EmergencyRequestDTO dto) {

        EmergencyRequest emergencyRequest = emergencyRequestRepository.findById(dto.getEmergencyRequestId()).orElseThrow(() ->
                                new RuntimeException("Emergency Request not found"));

        User user = userRepository.findById(dto.getUserId()).orElseThrow(() ->
                        new RuntimeException("User not found"));

        BloodType bloodType = bloodTypeRepository.findById(dto.getBloodTypeId()).orElseThrow(() ->
                                new RuntimeException("Blood Type not found"));

        BloodBank bloodBank = bloodBankRepository.findById(dto.getBloodBankId()).orElseThrow(() ->
                                new RuntimeException("Blood Bank not found"));

        emergencyRequest.setUser(user);
        emergencyRequest.setBloodType(bloodType);
        emergencyRequest.setBloodBank(bloodBank);
        emergencyRequest.setPatientName(dto.getPatientName());
        emergencyRequest.setRequiredUnits(dto.getRequiredUnits());
        emergencyRequest.setReason(dto.getReason());
        emergencyRequest.setUrgencyLevel(dto.getUrgencyLevel());

        emergencyRequestRepository.save(emergencyRequest);
    }

    // DELETE
    @Override
    public void deleteEmergencyRequest(Long emergencyRequestId) {

        if (!emergencyRequestRepository.existsById(emergencyRequestId)) {
            throw new RuntimeException("Emergency Request not found");
        }

        emergencyRequestRepository.deleteById(emergencyRequestId);
    }


    // GET ONE
    @Override
    public EmergencyRequestDTO getEmergencyRequest(Long emergencyRequestId) {

        EmergencyRequest emergencyRequest = emergencyRequestRepository.findById(emergencyRequestId).orElseThrow(() ->
                                new RuntimeException("Emergency Request not found"));

        return convertToDTO(emergencyRequest);
    }

    // GET ALL
    @Override
    public List<EmergencyRequestDTO> getAllEmergencyRequests() {

        return emergencyRequestRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    private EmergencyRequestDTO convertToDTO(EmergencyRequest emergencyRequest) {

        EmergencyRequestDTO dto = new EmergencyRequestDTO();


        dto.setEmergencyRequestId(emergencyRequest.getEmergencyRequestId());
        dto.setUserId(emergencyRequest.getUser().getUserId());
        dto.setBloodTypeId(emergencyRequest.getBloodType().getBloodTypeId());
        dto.setBloodBankId(emergencyRequest.getBloodBank().getBloodBankId());
        dto.setPatientName(emergencyRequest.getPatientName());
        dto.setRequiredUnits(emergencyRequest.getRequiredUnits());
        dto.setReason(emergencyRequest.getReason());
        dto.setUrgencyLevel(emergencyRequest.getUrgencyLevel());


        return dto;
    }
}