package org.ijse.bloodlinkproject.controller;

import lombok.RequiredArgsConstructor;
import org.ijse.bloodlinkproject.dto.BloodRequestDTO;
import org.ijse.bloodlinkproject.service.BloodRequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blood-request")
@RequiredArgsConstructor
@CrossOrigin
public class BloodRequestController {

    private final BloodRequestService bloodRequestService;

    // SAVE
    @PostMapping("/save")
    public ResponseEntity<String> saveBloodRequest(@RequestBody BloodRequestDTO dto) {

        bloodRequestService.saveBloodRequest(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Blood Request saved successfully");
    }


    // UPDATE
    @PutMapping("/update")
    public ResponseEntity<String> updateBloodRequest(@RequestBody BloodRequestDTO dto) {

        bloodRequestService.updateBloodRequest(dto);

        return ResponseEntity.ok("Blood Request updated successfully");
    }


    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBloodRequest(@PathVariable Long id) {

        bloodRequestService.deleteBloodRequest(id);

        return ResponseEntity.ok("Blood Request deleted successfully");
    }


    // GET ONE
    @GetMapping("/{id}")
    public ResponseEntity<BloodRequestDTO> getBloodRequest(
            @PathVariable Long id) {

        return ResponseEntity.ok(bloodRequestService.getBloodRequest(id)
        );
    }

    // GET ALL
    @GetMapping("/all")
    public ResponseEntity<List<BloodRequestDTO>> getAllBloodRequests() {

        return ResponseEntity.ok(bloodRequestService.getAllBloodRequests()
        );
    }
}