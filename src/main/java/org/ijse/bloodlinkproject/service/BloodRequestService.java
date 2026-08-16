package org.ijse.bloodlinkproject.service;

import org.ijse.bloodlinkproject.dto.BloodRequestDTO;

import java.util.List;

public interface BloodRequestService {

    void saveBloodRequest(BloodRequestDTO bloodRequestDTO);
    void updateBloodRequest(BloodRequestDTO bloodRequestDTO);
    void deleteBloodRequest(Long bloodRequestId);
    BloodRequestDTO getBloodRequest(Long bloodRequestId);
    List<BloodRequestDTO> getAllBloodRequests();
}
