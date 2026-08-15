package org.ijse.bloodlinkproject.controller;

import lombok.RequiredArgsConstructor;
import org.ijse.bloodlinkproject.dto.DonationDTO;
import org.ijse.bloodlinkproject.service.DonationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donation")
@RequiredArgsConstructor
@CrossOrigin
public class DonationController {

    private final DonationService donationService;


    // =========================
    // SAVE DONATION
    // =========================

    @PostMapping("/save")
    public ResponseEntity<String> saveDonation(
            @RequestBody DonationDTO donationDTO
    ) {

        donationService.saveDonation(donationDTO);

        return new ResponseEntity<>(
                "Donation saved successfully",
                HttpStatus.CREATED
        );
    }


    // =========================
    // UPDATE DONATION
    // =========================

    @PutMapping("/update")
    public ResponseEntity<String> updateDonation(
            @RequestBody DonationDTO donationDTO
    ) {

        donationService.updateDonation(donationDTO);

        return new ResponseEntity<>(
                "Donation updated successfully",
                HttpStatus.OK
        );
    }


    // =========================
    // DELETE DONATION
    // =========================

    @DeleteMapping("/delete/{donationId}")
    public ResponseEntity<String> deleteDonation(
            @PathVariable Long donationId
    ) {

        donationService.deleteDonation(donationId);

        return new ResponseEntity<>(
                "Donation deleted successfully",
                HttpStatus.OK
        );
    }


    // =========================
    // GET DONATION BY ID
    // =========================

    @GetMapping("/{donationId}")
    public ResponseEntity<DonationDTO> getDonation(
            @PathVariable Long donationId
    ) {

        DonationDTO donation =
                donationService.getDonation(donationId);

        return new ResponseEntity<>(
                donation,
                HttpStatus.OK
        );
    }


    // =========================
    // GET ALL DONATIONS
    // =========================

    @GetMapping("/all")
    public ResponseEntity<List<DonationDTO>> getAllDonations() {

        List<DonationDTO> donations =
                donationService.getAllDonations();

        return new ResponseEntity<>(
                donations,
                HttpStatus.OK
        );
    }


    // =========================
    // GET DONATIONS BY USER
    // =========================

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<DonationDTO>> getDonationsByUser(
            @PathVariable Long userId
    ) {

        List<DonationDTO> donations =
                donationService.getDonationsByUser(userId);

        return new ResponseEntity<>(
                donations,
                HttpStatus.OK
        );
    }


    // =========================
    // GET DONATIONS BY BLOOD TYPE
    // =========================

    @GetMapping("/blood-type/{bloodTypeId}")
    public ResponseEntity<List<DonationDTO>> getDonationsByBloodType(
            @PathVariable Long bloodTypeId
    ) {

        List<DonationDTO> donations =
                donationService.getDonationsByBloodType(
                        bloodTypeId
                );

        return new ResponseEntity<>(
                donations,
                HttpStatus.OK
        );
    }


    // =========================
    // GET DONATIONS BY BLOOD BANK
    // =========================

    @GetMapping("/blood-bank/{bloodBankId}")
    public ResponseEntity<List<DonationDTO>> getDonationsByBloodBank(
            @PathVariable Long bloodBankId
    ) {

        List<DonationDTO> donations =
                donationService.getDonationsByBloodBank(
                        bloodBankId
                );

        return new ResponseEntity<>(
                donations,
                HttpStatus.OK
        );
    }
}