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
    private long bloodTypeId;
    private String bloodGroup;
    private String rh_factory;

    @OneToMany(mappedBy = "bloodType")
    private List<Donation> donations;

}
