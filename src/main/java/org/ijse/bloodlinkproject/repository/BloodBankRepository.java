package org.ijse.bloodlinkproject.repository;

import org.ijse.bloodlinkproject.entity.BloodBank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodBankRepository extends JpaRepository<BloodBank, Long> {
}
