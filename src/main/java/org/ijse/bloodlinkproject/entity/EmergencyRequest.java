package org.ijse.bloodlinkproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmergencyRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emergencyRequestId;
    private String patientName;
    private int requiredUnits;
    private String reason;
    private int urgencyLevel;


    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "bloodTypeId", nullable = false)
    private BloodType bloodType;

    @ManyToOne
    @JoinColumn(name = "bloodBankId", nullable = false)
    private BloodBank bloodBank;


}
