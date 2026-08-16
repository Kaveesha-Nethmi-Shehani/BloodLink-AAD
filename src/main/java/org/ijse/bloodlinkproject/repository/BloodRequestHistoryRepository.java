package org.ijse.bloodlinkproject.repository;

import org.ijse.bloodlinkproject.entity.BloodRequestHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BloodRequestHistoryRepository extends JpaRepository<BloodRequestHistory , Long> {

    List<BloodRequestHistory> findByBloodRequestBloodRequestId(Long bloodRequestId);
}
