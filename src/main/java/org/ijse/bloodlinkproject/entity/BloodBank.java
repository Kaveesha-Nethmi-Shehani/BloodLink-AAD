package org.ijse.bloodlinkproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BloodBank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bloodBankId;
    private String bloodBankName;
    private String bloodBankLocation;
    private String bloodBankContact;
    private String bloodBankAddress;

    //SP
    private boolean active = true;

    @OneToMany(mappedBy = "bloodBank")
    private List<Donation> donations;

    @OneToMany(mappedBy = "bloodBank")
    private List<BloodInventory> bloodInventory;

}
