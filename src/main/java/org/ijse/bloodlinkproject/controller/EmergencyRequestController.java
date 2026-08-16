package org.ijse.bloodlinkproject.controller;

import lombok.RequiredArgsConstructor;
import org.ijse.bloodlinkproject.dto.EmergencyRequestDTO;
import org.ijse.bloodlinkproject.service.EmergencyRequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emergency-request")
@RequiredArgsConstructor
@CrossOrigin
public class EmergencyRequestController {

    private final EmergencyRequestService emergencyRequestService;


    // SAVE
    @PostMapping("/save")
    public ResponseEntity<String> saveEmergencyRequest(
            @RequestBody EmergencyRequestDTO dto) {

        emergencyRequestService
                .saveEmergencyRequest(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Emergency Request saved successfully");
    }


    // UPDATE
    @PutMapping("/update")
    public ResponseEntity<String> updateEmergencyRequest(
            @RequestBody EmergencyRequestDTO dto) {

        emergencyRequestService
                .updateEmergencyRequest(dto);

        return ResponseEntity.ok(
                "Emergency Request updated successfully"
        );
    }


    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmergencyRequest(
            @PathVariable Long id) {

        emergencyRequestService
                .deleteEmergencyRequest(id);

        return ResponseEntity.ok(
                "Emergency Request deleted successfully"
        );
    }


    // GET ONE
    @GetMapping("/{id}")
    public ResponseEntity<EmergencyRequestDTO>
    getEmergencyRequest(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                emergencyRequestService
                        .getEmergencyRequest(id)
        );
    }


    // GET ALL
    @GetMapping("/all")
    public ResponseEntity<List<EmergencyRequestDTO>>
    getAllEmergencyRequests() {

        return ResponseEntity.ok(
                emergencyRequestService
                        .getAllEmergencyRequests()
        );
    }
}