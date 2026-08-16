package org.ijse.bloodlinkproject.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ijse.bloodlinkproject.dto.BloodRequestHistoryDTO;
import org.ijse.bloodlinkproject.entity.BloodRequest;
import org.ijse.bloodlinkproject.entity.BloodRequestHistory;
import org.ijse.bloodlinkproject.repository.BloodRequestHistoryRepository;
import org.ijse.bloodlinkproject.repository.BloodRequestRepository;
import org.ijse.bloodlinkproject.service.BloodRequestHistoryService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BloodRequestHistoryServiceImpl implements BloodRequestHistoryService {

    private final BloodRequestHistoryRepository bloodRequestHistoryRepository;

    private final BloodRequestRepository bloodRequestRepository;


    // SAVE
    @Override
    public void saveBloodRequestHistory(
            BloodRequestHistoryDTO dto) {

        log.info("Saving Blood Request History: {}", dto);

        BloodRequest bloodRequest = bloodRequestRepository.findById(dto.getBloodRequestId()).orElseThrow(() ->
                new RuntimeException("Blood Request not found"));


        BloodRequestHistory history = new BloodRequestHistory();

        history.setBloodRequest(bloodRequest);
        history.setStatus(dto.getStatus());
        history.setRemark(dto.getRemark());


        // Automatically set date/time
        history.setChangesAt(dto.getChangesAt() != null ? dto.getChangesAt() : LocalDateTime.now());

        bloodRequestHistoryRepository.save(history);
    }


    // UPDATE
    @Override
    public void updateBloodRequestHistory(BloodRequestHistoryDTO dto) {

        BloodRequestHistory history = bloodRequestHistoryRepository.findById(dto.getBloodRequestHistoryId()).orElseThrow(() ->
                                new RuntimeException("Blood Request History not found"));

        BloodRequest bloodRequest = bloodRequestRepository.findById(dto.getBloodRequestId()).orElseThrow(() ->
                                new RuntimeException("Blood Request not found"));


        history.setBloodRequest(bloodRequest);
        history.setStatus(dto.getStatus());
        history.setRemark(dto.getRemark());

        if (dto.getChangesAt() != null) {
            history.setChangesAt(dto.getChangesAt());
        }

        bloodRequestHistoryRepository.save(history);
    }


    // DELETE
    @Override
    public void deleteBloodRequestHistory(Long bloodRequestHistoryId) {

        if (!bloodRequestHistoryRepository.existsById(bloodRequestHistoryId)) {
            throw new RuntimeException("Blood Request History not found");
        }

        bloodRequestHistoryRepository.deleteById(bloodRequestHistoryId);
    }


    // GET ONE
    @Override
    public BloodRequestHistoryDTO getBloodRequestHistory(Long bloodRequestHistoryId) {

        BloodRequestHistory history = bloodRequestHistoryRepository.findById(bloodRequestHistoryId).orElseThrow(() ->
                                new RuntimeException("Blood Request History not found"));

        return convertToDTO(history);
    }


    // GET ALL
    @Override
    public List<BloodRequestHistoryDTO> getAllBloodRequestHistories() {

        return bloodRequestHistoryRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    // GET HISTORY  BLOOD REQUEST
    @Override
    public List<BloodRequestHistoryDTO> getHistoryByBloodRequestId(Long bloodRequestId) {

        // Check BloodRequest
        if (!bloodRequestRepository.existsById(bloodRequestId)) {
            throw new RuntimeException("Blood Request not found");
        }


        return bloodRequestHistoryRepository
                .findByBloodRequestBloodRequestId(bloodRequestId)
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    private BloodRequestHistoryDTO convertToDTO(BloodRequestHistory history) {

        BloodRequestHistoryDTO dto = new BloodRequestHistoryDTO();

        dto.setBloodRequestHistoryId(history.getBloodRequestHistoryId());
        dto.setBloodRequestId(history.getBloodRequest().getBloodRequestId());
        dto.setRemark(history.getRemark());
        dto.setChangesAt(history.getChangesAt());
        dto.setStatus(history.getStatus());

        return dto;
    }
}