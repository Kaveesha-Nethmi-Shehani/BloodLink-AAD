package org.ijse.bloodlinkproject.controller;

import lombok.RequiredArgsConstructor;
import org.ijse.bloodlinkproject.dto.AuthDTO;
import org.ijse.bloodlinkproject.dto.CommonResponse;
import org.ijse.bloodlinkproject.dto.UserDTO;
import org.ijse.bloodlinkproject.dto.UserDataDTO;
import org.ijse.bloodlinkproject.security.JwtUtil;
import org.ijse.bloodlinkproject.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {
    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping(value = "register", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse registerUser(@RequestBody UserDTO userDTO){
        userService.userSave(userDTO);
        return new CommonResponse(200,"success");
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse loginUser(@RequestBody AuthDTO authDTO){
        UserDTO userDTO = userService.getUserDetails(authDTO.getUsername(), authDTO.getPassword());
        String token = jwtUtil.generateToken(userDTO);

        UserDataDTO  userDataDTO = new UserDataDTO();
        userDataDTO.setUserId(userDTO.getUserId());
        userDataDTO.setToken(token);

        return new CommonResponse(0,userDataDTO,"Login successfully");
    }

    @GetMapping("/all")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping(value = "/{userId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse deleteUser(@PathVariable long userId) {
        userService.deleteUser(userId);
        return new CommonResponse(0, "USER DELETED");
    }

    @PutMapping(value = "/update-user",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse updateUser(@RequestBody UserDTO userDTO){
        userService.updateUser(userDTO);
        return new CommonResponse(0,"USER UPDATED");
    }

}
