package org.ijse.bloodlinkproject.controller;

import lombok.RequiredArgsConstructor;
import org.ijse.bloodlinkproject.dto.BloodTypeDTO;
import org.ijse.bloodlinkproject.service.BloodTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/blood-type")
@RequiredArgsConstructor
public class BloodTypeController {

    private final BloodTypeService bloodTypeService;

    // Save Blood Type
    @PostMapping("/save")
    public ResponseEntity<String> saveBloodType(
            @RequestBody BloodTypeDTO bloodTypeDTO) {

        bloodTypeService.saveBloodType(bloodTypeDTO);

        return new ResponseEntity<>(
                "Blood Type Saved Successfully",
                HttpStatus.CREATED
        );
    }

    // Update Blood Type
    @PutMapping("/update")
    public ResponseEntity<String> updateBloodType(
            @RequestBody BloodTypeDTO bloodTypeDTO) {

        bloodTypeService.updateBloodType(bloodTypeDTO);

        return new ResponseEntity<>(
                "Blood Type Updated Successfully",
                HttpStatus.OK
        );
    }

    //Soft Delete Blood Type
    @DeleteMapping("/delete/{bloodTypeId}")
    public ResponseEntity<String> deleteBloodType(
            @PathVariable long bloodTypeId) {

        bloodTypeService.deleteBloodType(bloodTypeId);

        return new ResponseEntity<>(
                "Blood Type Deleted Successfully",
                HttpStatus.OK
        );
    }

    // Get BloodType by ID
    @GetMapping("/{bloodTypeId}")
    public ResponseEntity<BloodTypeDTO> getBloodType(
            @PathVariable long bloodTypeId) {

        BloodTypeDTO bloodTypeDTO =
                bloodTypeService.getBloodType(bloodTypeId);

        return new ResponseEntity<>(
                bloodTypeDTO,
                HttpStatus.OK
        );
    }

    // Get All BloodTypes
    @GetMapping("/all")
    public ResponseEntity<List<BloodTypeDTO>> getAllBloodTypes() {

        List<BloodTypeDTO> bloodTypes =
                bloodTypeService.getAllBloodTypes();

        return new ResponseEntity<>(
                bloodTypes,
                HttpStatus.OK
        );
    }
}