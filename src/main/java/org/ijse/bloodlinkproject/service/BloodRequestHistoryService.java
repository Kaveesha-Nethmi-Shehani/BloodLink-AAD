package org.ijse.bloodlinkproject.service;

import org.ijse.bloodlinkproject.dto.BloodRequestHistoryDTO;

import java.util.List;

public interface BloodRequestHistoryService {


    void saveBloodRequestHistory(BloodRequestHistoryDTO bloodRequestHistoryDTO);
    void updateBloodRequestHistory(BloodRequestHistoryDTO bloodRequestHistoryDTO);
    void deleteBloodRequestHistory(Long bloodRequestHistoryId);
    BloodRequestHistoryDTO getBloodRequestHistory(Long bloodRequestHistoryId);
    List<BloodRequestHistoryDTO> getAllBloodRequestHistories();
    List<BloodRequestHistoryDTO> getHistoryByBloodRequestId(Long bloodRequestId);
}
