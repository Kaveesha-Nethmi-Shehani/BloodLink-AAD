package org.ijse.bloodlinkproject.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ijse.bloodlinkproject.dto.UserDTO;
import org.ijse.bloodlinkproject.entity.User;
import org.ijse.bloodlinkproject.enumiration.Status;
import org.ijse.bloodlinkproject.repository.UserRepository;
import org.ijse.bloodlinkproject.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void userSave(UserDTO userDTO) {
        log.info("UserServiceImpl userSave({})", userDTO);
        try {
            User user = new User();
            user.setUsername(userDTO.getUsername());
            user.setUserEmail(userDTO.getUserEmail());
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            user.setPhoneNumber(userDTO.getPhoneNumber());
            user.setUserAddress(userDTO.getUserAddress());
            user.setUserRole(userDTO.getUserRole());
            userRepository.save(user);
        } catch (Exception e) {
            log.error("UserServiceImpl userSave({})", userDTO);
            throw e;
        }
    }

    @Override
    public UserDTO getUserDetails(String username, String password) {
        log.info("UserServiceImpl getUserDetails({}, {})", username, password);
        try {
            Optional<User> user = userRepository.findByUsername(username);
            if (user.isEmpty()) {
                log.error("UserServiceImpl getUserDetails({}, {})", username, password);
                throw new RuntimeException("User not found");
            }

            User userDetails = user.get();

            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new RuntimeException("Invalid password");
            }

            return new UserDTO(
                    userDetails.getUserId(),
                    userDetails.getUsername(),
                    userDetails.getUserEmail(),
                    userDetails.getPassword(),
                    userDetails.getPhoneNumber(),
                    userDetails.getUserAddress(),
                    userDetails.getUserRole(),
                    userDetails.getDataStatus());

        } catch (Exception e) {
            log.error("UserServiceImpl getUserDetails({}, {})", username, password);
            throw e;
        }
    }

    @Override
    public List<UserDTO> getAllUsers() {
        log.info("UserServiceImpl getAllUsers()");
        try{
            List<UserDTO> responseList = new ArrayList<>();
            List<User> users = userRepository.findAll();
            for (User user : users) {
                UserDTO userDTO = new UserDTO();
                userDTO.setUserId(user.getUserId());
                userDTO.setUsername(user.getUsername());
                userDTO.setUserEmail(user.getUserEmail());
                userDTO.setPassword(user.getPassword());
                userDTO.setPhoneNumber(user.getPhoneNumber());
                userDTO.setUserAddress(user.getUserAddress());

                userDTO.setDataStatus(Status.Active)  ;
                 responseList.add(userDTO);
            }

            return responseList;
        }catch (Exception e){
            log.error("UserServiceImpl getAllUsers()");
            throw e;
        }

    }



    @Override
    public void deleteUser(long userId) {

        log.info("Deleting user: {}", userId);

        try {

            Optional<User> optionalUser = userRepository.findById(userId);

            if (optionalUser.isEmpty()) {
                throw new RuntimeException("User not found");
            }

            User user = optionalUser.get();
            user.setDataStatus(Status.Inactive);

            userRepository.save(user);

        } catch (Exception e) {

            log.error("Deleting User: {}", userId, e);
            throw e;
        }
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        log.info("Update User: {}", userDTO);

        try {
            Optional<User> optionalUser = userRepository.findById(userDTO.getUserId());
            if (optionalUser.isEmpty()) {
                throw new RuntimeException("User not found");

            }
            User user = optionalUser.get();
            user.setUsername(userDTO.getUsername());
            user.setUserEmail(userDTO.getUserEmail());
            user.setPhoneNumber(userDTO.getPhoneNumber());
            user.setUserAddress(userDTO.getUserAddress());
            user.setUserRole(userDTO.getUserRole());
            userRepository.save(user);


        } catch (Exception e) {
            log.error("Update User: {}", userDTO, e);
            throw e;
        }
    }
}




