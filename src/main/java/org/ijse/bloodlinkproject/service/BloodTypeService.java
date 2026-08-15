package org.ijse.bloodlinkproject.service;

import org.ijse.bloodlinkproject.dto.BloodTypeDTO;

import java.util.List;

public interface BloodTypeService {

    void saveBloodType(BloodTypeDTO bloodTypeDTO);
    void updateBloodType(BloodTypeDTO bloodTypeDTO);
    void deleteBloodType(long bloodTypeId);
    BloodTypeDTO getBloodType(long bloodTypeId);
    List<BloodTypeDTO> getAllBloodTypes();

}
