package org.ijse.bloodlinkproject.entity;

 import jakarta.persistence.*;
 import lombok.AllArgsConstructor;
 import lombok.Data;
 import lombok.NoArgsConstructor;
 import org.ijse.bloodlinkproject.enumiration.Status;
 import org.ijse.bloodlinkproject.enumiration.UserRole;

 import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
 public class User {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long userId;
     private String username;
     private String userEmail;
     private String password;
     private String phoneNumber;
     private String userAddress;


     @Enumerated(EnumType.STRING)
     private UserRole userRole;

     @Enumerated(EnumType.STRING)
     private Status dataStatus;

     //User-Donation
     @OneToMany(mappedBy = "user")
     private List<Donation> donations;

     //User-BloodRequest
    @OneToMany(mappedBy = "user")
    private List<BloodRequest> bloodRequests;

    //User-EmergencyRequest
    @OneToMany(mappedBy = "user")
    private List<EmergencyRequest> emergencyRequests;


 }