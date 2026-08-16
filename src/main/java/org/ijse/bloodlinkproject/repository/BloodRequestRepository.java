package org.ijse.bloodlinkproject.repository;

import org.ijse.bloodlinkproject.entity.BloodRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodRequestRepository extends JpaRepository<BloodRequest, Long> {
}
