package org.ijse.bloodlinkproject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ijse.bloodlinkproject.dto.BloodInventoryDTO;
import org.ijse.bloodlinkproject.service.BloodInventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blood-inventory")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class BloodInventoryController {

    private final BloodInventoryService bloodInventoryService;


    // ================= SAVE =================

    @PostMapping("/save")
    public ResponseEntity<String> saveBloodInventory(
            @RequestBody BloodInventoryDTO bloodInventoryDTO) {

        log.info("BloodInventoryController save: {}",
                bloodInventoryDTO);

        try {

            bloodInventoryService.saveBloodInventory(
                    bloodInventoryDTO
            );

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Blood Inventory saved successfully");

        } catch (Exception ex) {

            log.error(
                    "Error while saving Blood Inventory",
                    ex
            );

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ex.getMessage());
        }
    }


    // ================= UPDATE =================

    @PutMapping("/update")
    public ResponseEntity<String> updateBloodInventory(
            @RequestBody BloodInventoryDTO bloodInventoryDTO) {

        log.info("BloodInventoryController update: {}",
                bloodInventoryDTO);

        try {

            bloodInventoryService.updateBloodInventory(
                    bloodInventoryDTO
            );

            return ResponseEntity
                    .ok("Blood Inventory updated successfully");

        } catch (Exception ex) {

            log.error(
                    "Error while updating Blood Inventory",
                    ex
            );

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ex.getMessage());
        }
    }


    // ================= DELETE =================

    @DeleteMapping("/delete/{inventoryId}")
    public ResponseEntity<String> deleteBloodInventory(
            @PathVariable Long inventoryId) {

        log.info(
                "BloodInventoryController delete: {}",
                inventoryId
        );

        try {

            bloodInventoryService.deleteBloodInventory(
                    inventoryId
            );

            return ResponseEntity
                    .ok("Blood Inventory deleted successfully");

        } catch (Exception ex) {

            log.error(
                    "Error while deleting Blood Inventory",
                    ex
            );

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ex.getMessage());
        }
    }


    // ================= GET ONE =================

    @GetMapping("/{inventoryId}")
    public ResponseEntity<BloodInventoryDTO> getBloodInventory(
            @PathVariable Long inventoryId) {

        log.info(
                "BloodInventoryController get: {}",
                inventoryId
        );

        BloodInventoryDTO bloodInventoryDTO =
                bloodInventoryService.getBloodInventory(
                        inventoryId
                );

        return ResponseEntity.ok(
                bloodInventoryDTO
        );
    }


    // ================= GET ALL =================

    @GetMapping("/getAll")
    public ResponseEntity<List<BloodInventoryDTO>>
    getAllBloodInventory() {

        log.info(
                "BloodInventoryController getAll"
        );

        List<BloodInventoryDTO> bloodInventoryList =
                bloodInventoryService.getAllBloodInventory();

        return ResponseEntity.ok(
                bloodInventoryList
        );
    }
}