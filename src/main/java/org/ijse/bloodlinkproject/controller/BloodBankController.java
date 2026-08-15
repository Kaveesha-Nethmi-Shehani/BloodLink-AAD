package org.ijse.bloodlinkproject.controller;

import lombok.RequiredArgsConstructor;
import org.ijse.bloodlinkproject.dto.BloodBankDTO;
import org.ijse.bloodlinkproject.service.BloodBankService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blood-bank")
@RequiredArgsConstructor
public class BloodBankController {

    private final BloodBankService bloodBankService;

    //SAVE BLOOD BANK
    @PostMapping("/save")
    public ResponseEntity<String> saveBloodBank(
            @RequestBody BloodBankDTO bloodBankDTO) {

        bloodBankService.saveBloodBank(bloodBankDTO);

        return new ResponseEntity<>(
                "Blood Bank Saved Successfully",
                HttpStatus.CREATED
        );
    }

    // UPDATE BLOOD BANK
    @PutMapping("/update")
    public ResponseEntity<String> updateBloodBank(
            @RequestBody BloodBankDTO bloodBankDTO) {

        bloodBankService.updateBloodBank(bloodBankDTO);

        return new ResponseEntity<>(
                "Blood Bank Updated Successfully",
                HttpStatus.OK
        );
    }

    // DELETE / DEACTIVATE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBloodBank(
            @PathVariable Long id) {

        bloodBankService.deleteBloodBankById(id);

        return new ResponseEntity<>(
                "Blood Bank Deactivated Successfully",
                HttpStatus.OK
        );
    }

    //GET ONE BLOOD BANK
    @GetMapping("/{bloodBankId}")
    public ResponseEntity<BloodBankDTO> getBloodBank(
            @PathVariable Long bloodBankId) {

        BloodBankDTO bloodBankDTO =
                bloodBankService.getBloodBankBy(bloodBankId);

        return new ResponseEntity<>(
                bloodBankDTO,
                HttpStatus.OK
        );
    }

    // GET ALL BLOOD BANKS
    @GetMapping("/all")
    public ResponseEntity<List<BloodBankDTO>> getAllBloodBanks() {

        List<BloodBankDTO> bloodBanks =
                bloodBankService.getAllBloodBanks();

        return new ResponseEntity<>(
                bloodBanks,
                HttpStatus.OK
        );
    }
}