package org.ijse.bloodlinkproject.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ijse.bloodlinkproject.dto.BloodInventoryDTO;
 import org.ijse.bloodlinkproject.entity.BloodBank;
import org.ijse.bloodlinkproject.entity.BloodInventory;
import org.ijse.bloodlinkproject.entity.BloodType;
import org.ijse.bloodlinkproject.repository.BloodBankRepository;
import org.ijse.bloodlinkproject.repository.BloodInventoryRepository;
import org.ijse.bloodlinkproject.repository.BloodTypeRepository;
import org.ijse.bloodlinkproject.service.BloodInventoryService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class BloodInventoryServiceImpl implements BloodInventoryService {

    private final BloodInventoryRepository bloodInventoryRepository;
    private final BloodTypeRepository bloodTypeRepository;
    private final BloodBankRepository bloodBankRepository;

    @Override
    public void saveBloodInventory(BloodInventoryDTO bloodInventoryDTO) {
        log.info("saveBloodInventory");
        try {
            BloodBank bloodBank = bloodBankRepository.findById(bloodInventoryDTO.getBloodBankId()).orElseThrow(() ->
                    new RuntimeException("Blood Bank not found"));

            BloodType bloodType = bloodTypeRepository.findById(bloodInventoryDTO.getBloodTypeId()).orElseThrow(() ->
                    new RuntimeException("Blood Type not found"));

            BloodInventory bloodInventory = new BloodInventory();

            bloodInventory.setAvailableUnit(bloodInventoryDTO.getAvailableUnit());
            bloodInventory.setLastUpdate(LocalDateTime.now());
            bloodInventory.setStatus(bloodInventoryDTO.getStatus());
            bloodInventory.setBloodBank(bloodBank);
            bloodInventory.setBloodType(bloodType);

            bloodInventoryRepository.save(bloodInventory);
            log.info("Blood Inventory saved successfully");

        } catch (Exception ex) {
            log.error("saveBloodInventory Exception");
            throw new RuntimeException("saveBloodInventory Exception");
        }
    }

    @Override
    public void updateBloodInventory(BloodInventoryDTO bloodInventoryDTO) {
        log.info("updateBloodInventory");
        try {
            BloodBank bloodBank = bloodBankRepository.findById(bloodInventoryDTO.getBloodBankId()).orElseThrow(() ->
                    new RuntimeException("Blood Bank not found"));

            BloodType bloodType = bloodTypeRepository.findById(bloodInventoryDTO.getBloodTypeId()).orElseThrow(() ->
                    new RuntimeException("Blood Type not found"));

            BloodInventory bloodInventory = bloodInventoryRepository.findById(bloodInventoryDTO.getInventoryId()).orElseThrow(() ->
                    new RuntimeException("Blood Type not found"));

            bloodInventory.setAvailableUnit(bloodInventoryDTO.getAvailableUnit());
            bloodInventory.setLastUpdate(LocalDateTime.now());
            bloodInventory.setStatus(bloodInventoryDTO.getStatus());
            bloodInventory.setBloodBank(bloodBank);
            bloodInventory.setBloodType(bloodType);

            bloodInventoryRepository.save(bloodInventory);
            log.info("Blood Inventory saved successfully");


        } catch (Exception ex) {
            log.error("updateBloodInventory Exception");
            throw new RuntimeException("updateBloodInventory Exception");
        }

    }

    @Override
    public void deleteBloodInventory(Long inventoryId) {
        log.info("Delete Blood Inventory: {}", inventoryId);

        try {

            if (!bloodInventoryRepository.existsById(inventoryId)) {
                throw new RuntimeException("Blood Inventory not found");
            }

            bloodInventoryRepository.deleteById(inventoryId);
            log.info("Blood Inventory deleted successfully");

        } catch (Exception e) {
            log.error("Error while deleting Blood Inventory", e);
            throw new RuntimeException("Failed to delete blood inventory");
        }
    }

    @Override
    public BloodInventoryDTO getBloodInventory(Long inventoryId) {
        log.info("Get Blood Inventory: {}", inventoryId);

        BloodInventory bloodInventory = bloodInventoryRepository.findById(inventoryId).orElseThrow(() ->
                new RuntimeException("Blood Inventory not found"));

        return convertToDTO(bloodInventory);
    }

    private BloodInventoryDTO convertToDTO(BloodInventory bloodInventory) {

        BloodInventoryDTO dto = new BloodInventoryDTO();

        dto.setInventoryId(bloodInventory.getInventoryId());
        dto.setAvailableUnit(bloodInventory.getAvailableUnit());
        dto.setLastUpdate(bloodInventory.getLastUpdate());
        dto.setStatus(bloodInventory.getStatus());
        dto.setBloodTypeId(bloodInventory.getBloodType().getBloodTypeId());
        dto.setBloodBankId(bloodInventory.getBloodBank().getBloodBankId());

         return dto;
    }


    @Override
    public List<BloodInventoryDTO> getAllBloodInventory() {
        log.info("Get all Blood Inventory");

        List<BloodInventory> inventories = bloodInventoryRepository.findAll();

        return inventories.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

}

