package org.ijse.bloodlinkproject.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ijse.bloodlinkproject.enumiration.BloodRequestStatus;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class BloodRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bloodRequestId;
    private int requiredUnit;
    private LocalDate requiredDate;
    private String reason;


    @Enumerated(EnumType.STRING)
    private BloodRequestStatus status;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "bloodTypeId", nullable = false)
    private BloodType  bloodType;

    @ManyToOne
    @JoinColumn(name = "bloodBankId", nullable = false)
    private BloodBank bloodBank;

    // BloodRequest One to many BloodRequestHistory
    @OneToMany(mappedBy = "bloodRequest")
    private List<BloodRequestHistory> bloodRequestHistory;

}





