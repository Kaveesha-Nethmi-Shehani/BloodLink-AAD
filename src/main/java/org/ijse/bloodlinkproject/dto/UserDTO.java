package org.ijse.bloodlinkproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ijse.bloodlinkproject.enumiration.Status;
import org.ijse.bloodlinkproject.enumiration.UserRole;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long userId;
    private String username;
    private String userEmail;
    private String password;
    private String phoneNumber;
    private String userAddress;
    private UserRole userRole;
    private Status datastatus;
}
