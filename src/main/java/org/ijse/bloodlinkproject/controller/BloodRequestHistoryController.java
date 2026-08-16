package org.ijse.bloodlinkproject.controller;

import lombok.RequiredArgsConstructor;
import org.ijse.bloodlinkproject.dto.BloodRequestHistoryDTO;
import org.ijse.bloodlinkproject.service.BloodRequestHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blood-request-history")
@RequiredArgsConstructor
@CrossOrigin
public class BloodRequestHistoryController {

    private final BloodRequestHistoryService bloodRequestHistoryService;


    // Save Blood Request History
    @PostMapping("/save")
    public ResponseEntity<String> saveBloodRequestHistory(@RequestBody BloodRequestHistoryDTO dto) {

        bloodRequestHistoryService.saveBloodRequestHistory(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Blood Request History saved successfully");
    }


    // Update Blood Request History
    @PutMapping("/update")
    public ResponseEntity<String> updateBloodRequestHistory(@RequestBody BloodRequestHistoryDTO dto) {

        bloodRequestHistoryService.updateBloodRequestHistory(dto);

        return ResponseEntity
                .ok("Blood Request History updated successfully");
    }


    // Delete Blood Request History
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBloodRequestHistory(@PathVariable Long id) {

        bloodRequestHistoryService.deleteBloodRequestHistory(id);

        return ResponseEntity
                .ok("Blood Request History deleted successfully");
    }


    // Get One Blood Request History
    @GetMapping("/{id}")
    public ResponseEntity<BloodRequestHistoryDTO> getBloodRequestHistory(@PathVariable Long id) {

        return ResponseEntity.ok(
                bloodRequestHistoryService
                        .getBloodRequestHistory(id)
        );
    }


    // Get All Blood Request History
    @GetMapping("/all")
    public ResponseEntity<List<BloodRequestHistoryDTO>> getAllBloodRequestHistories() {

        return ResponseEntity.ok(
                bloodRequestHistoryService
                        .getAllBloodRequestHistories()
        );
    }

    // Get History Blood Request ID
    @GetMapping("/request/{bloodRequestId}")
    public ResponseEntity<List<BloodRequestHistoryDTO>> getHistoryByBloodRequestId(@PathVariable Long bloodRequestId) {

        return ResponseEntity.ok(
                bloodRequestHistoryService
                        .getHistoryByBloodRequestId(
                                bloodRequestId
                        )
        );
    }
}