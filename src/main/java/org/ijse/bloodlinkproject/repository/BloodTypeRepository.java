package org.ijse.bloodlinkproject.repository;

import org.ijse.bloodlinkproject.entity.BloodType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BloodTypeRepository extends JpaRepository<BloodType, Long> {




}
