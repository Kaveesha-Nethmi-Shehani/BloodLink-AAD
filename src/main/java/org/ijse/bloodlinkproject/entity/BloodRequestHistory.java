package org.ijse.bloodlinkproject.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ijse.bloodlinkproject.enumiration.BloodRequestStatus;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodRequestHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bloodRequestHistoryId;
    private String remark;
    private LocalDateTime changesAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BloodRequestStatus status;

    @ManyToOne
    @JoinColumn(name = "bloodRequestId", nullable = false)
    private BloodRequest bloodRequest;



}
