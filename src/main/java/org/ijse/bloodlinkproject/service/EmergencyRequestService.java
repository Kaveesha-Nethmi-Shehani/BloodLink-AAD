package org.ijse.bloodlinkproject.service;

import org.ijse.bloodlinkproject.dto.EmergencyRequestDTO;

import java.util.List;

public interface EmergencyRequestService {

    void saveEmergencyRequest(EmergencyRequestDTO emergencyRequestDTO);
    void updateEmergencyRequest(EmergencyRequestDTO emergencyRequestDTO);
    void deleteEmergencyRequest(Long emergencyRequestId);
    EmergencyRequestDTO getEmergencyRequest(Long emergencyRequestId);
    List<EmergencyRequestDTO> getAllEmergencyRequests();
}