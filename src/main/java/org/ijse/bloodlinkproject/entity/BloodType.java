package org.ijse.bloodlinkproject.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
 public class BloodType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bloodTypeId;
    private String bloodGroup;
    private String rh_factory;

    //SP
    private boolean active = true;

    @OneToMany(mappedBy = "bloodType")
    private List<Donation> donations;

}
