package org.ijse.bloodlinkproject.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ijse.bloodlinkproject.dto.BloodTypeDTO;
import org.ijse.bloodlinkproject.entity.BloodType;
import org.ijse.bloodlinkproject.repository.BloodTypeRepository;
import org.ijse.bloodlinkproject.service.BloodTypeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class BloodTypeServiceImpl implements BloodTypeService {
    private final BloodTypeRepository bloodTypeRepository;

    @Override
    public void saveBloodType(BloodTypeDTO bloodTypeDTO) {
        log.info("saveBloodType({})", bloodTypeDTO);
        try {
            BloodType bloodType = new BloodType();
            bloodType.setBloodGroup(bloodTypeDTO.getBloodTypeGroup());
            bloodType.setRh_factory(bloodTypeDTO.getRh_factory());
            //New BloodType is Active
            bloodType.setActive(true);
            bloodTypeRepository.save(bloodType);

        } catch (Exception e) {
            log.error("bloodTypeServiceImpl({})", bloodTypeDTO);
            throw e;
        }
    }

    @Override
    public void updateBloodType(BloodTypeDTO bloodTypeDTO) {
        log.info("updateBloodType({})", bloodTypeDTO);
        try {
            Optional<BloodType> optionalBloodType = bloodTypeRepository.findById(bloodTypeDTO.getBloodTypeId());
            if (optionalBloodType.isEmpty()) {
                throw new RuntimeException("Sorry, related bloodType is not found");
            }

            BloodType bloodType = optionalBloodType.get();
            bloodType.setBloodGroup(bloodTypeDTO.getBloodTypeGroup());
            bloodType.setRh_factory(bloodTypeDTO.getRh_factory());
            bloodTypeRepository.save(bloodType);


        } catch (Exception e) {
            log.error("bloodTypeServiceImpl({})", bloodTypeDTO);
            throw e;
        }
    }

    @Override
    public void deleteBloodType(long bloodTypeId) {
        log.info("deleteBloodType({})", bloodTypeId);

        try {
            Optional<BloodType> optionalBloodType = bloodTypeRepository.findById(bloodTypeId);
            if (optionalBloodType.isEmpty()) {
                throw new RuntimeException("Sorry, related bloodType is not found");
            }
            BloodType bloodType = optionalBloodType.get();
            //SP Delete
            bloodType.setActive(false);
            bloodTypeRepository.save(bloodType);


        } catch (Exception e) {
            log.error("bloodTypeServiceImpl({})", bloodTypeId);
            throw e;
        }
    }

    @Override
    public BloodTypeDTO getBloodType(long bloodTypeId) {
        log.info("getBloodType({})", bloodTypeId);
        try {
            Optional<BloodType> bloodType = bloodTypeRepository.findById(bloodTypeId);
            if (bloodType.isEmpty()) {
                log.error("Sorry, related bloodType is not found");
                throw new RuntimeException("Sorry, related bloodType is not found");
            }
            BloodType bloodType1 = bloodType.get();

            return new BloodTypeDTO(
                    bloodType1.getBloodTypeId(),
                    bloodType1.getBloodGroup(),
                    bloodType1.getRh_factory(),
                    bloodType1.isActive());

        } catch (Exception e) {
            log.error("bloodTypeServiceImpl({})", bloodTypeId);
            throw e;
        }
    }

    @Override
    public List<BloodTypeDTO> getAllBloodTypes() {
        log.info("getAllBloodTypes()");
        try {
            List<BloodTypeDTO> responseList = new ArrayList<>();
            List<BloodType> bloodTypes = bloodTypeRepository.findAll();

            for (BloodType bloodType : bloodTypes) {
                BloodTypeDTO bloodTypeDTO = new BloodTypeDTO();
                bloodTypeDTO.setBloodTypeId(bloodType.getBloodTypeId());
                bloodTypeDTO.setBloodTypeGroup(bloodType.getBloodGroup());
                bloodTypeDTO.setRh_factory(bloodType.getRh_factory());
                bloodTypeDTO.setActive(bloodType.isActive());
                responseList.add(bloodTypeDTO);
            }
            return responseList;

        } catch (Exception e) {
            log.error("bloodTypeServiceImpl({})", bloodTypeRepository);
            throw e;
        }
    }
}




