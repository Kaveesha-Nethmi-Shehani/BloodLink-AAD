package org.ijse.bloodlinkproject.service;

 import org.ijse.bloodlinkproject.dto.UserDTO;

 import java.util.List;

public interface UserService {
    void userSave(UserDTO userDTO);
    UserDTO getUserDetails(String username, String password);
    List<UserDTO> getAllUsers();
    void deleteUser(long userId);
    void updateUser(UserDTO userDTO);

}
