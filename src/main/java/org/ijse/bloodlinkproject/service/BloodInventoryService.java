package org.ijse.bloodlinkproject.service;

import org.ijse.bloodlinkproject.dto.BloodInventoryDTO;

import java.util.List;

public interface BloodInventoryService {

    void saveBloodInventory(BloodInventoryDTO bloodInventoryDTO);
    void updateBloodInventory(BloodInventoryDTO bloodInventoryDTO);
    void deleteBloodInventory(Long inventoryId);
    BloodInventoryDTO getBloodInventory(Long inventoryId);
    List<BloodInventoryDTO> getAllBloodInventory();


 }
