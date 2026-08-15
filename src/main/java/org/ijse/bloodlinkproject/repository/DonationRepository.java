package org.ijse.bloodlinkproject.repository;

import org.ijse.bloodlinkproject.entity.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonationRepository extends JpaRepository<Donation, Long> {

    List<Donation> findByUser_UserId(Long userId);
    List<Donation> findByBloodType_BloodTypeId(Long bloodTypeId);
    List<Donation> findByBloodBank_BloodBankId(Long bloodBankId);

}
