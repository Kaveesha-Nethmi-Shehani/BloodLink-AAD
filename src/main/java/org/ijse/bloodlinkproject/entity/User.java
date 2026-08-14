 /*
package org.ijse.bloodlinkproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userFullName;
    private String userEmail;
    private String userPassword;
    private String userPhoneNumber;
    private String userAddress;


    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
*/

 package org.ijse.bloodlinkproject.entity;

 import jakarta.persistence.*;
 import lombok.AllArgsConstructor;
 import lombok.Data;
 import lombok.NoArgsConstructor;
 import org.ijse.bloodlinkproject.enumiration.Status;
 import org.ijse.bloodlinkproject.enumiration.UserRole;

 @Data
 @AllArgsConstructor
 @NoArgsConstructor
 @Entity
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


 }