package org.ijse.bloodlinkproject.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "donation")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long donationId;
    private LocalDate donationDate;
    private int qty;
    private String status;

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
