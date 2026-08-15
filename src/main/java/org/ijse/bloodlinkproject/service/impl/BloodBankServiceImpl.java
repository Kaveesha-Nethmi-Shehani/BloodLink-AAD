package org.ijse.bloodlinkproject.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ijse.bloodlinkproject.dto.BloodBankDTO;
import org.ijse.bloodlinkproject.dto.BloodTypeDTO;
import org.ijse.bloodlinkproject.entity.BloodBank;
import org.ijse.bloodlinkproject.entity.BloodType;
import org.ijse.bloodlinkproject.repository.BloodBankRepository;
import org.ijse.bloodlinkproject.service.BloodBankService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class BloodBankServiceImpl implements BloodBankService {

 private final BloodBankRepository bloodBankRepository;

 @Override
 public void saveBloodBank(BloodBankDTO bloodBankDTO) {
  log.info("saveBloodBank({})", bloodBankDTO);
  try {
   BloodBank bloodBank = new BloodBank();
   bloodBank.setBloodBankName(bloodBankDTO.getBloodBankName());
   bloodBank.setBloodBankContact(bloodBankDTO.getBloodBankContact());
   bloodBank.setBloodBankAddress(bloodBankDTO.getBloodBankAddress());
   bloodBank.setBloodBankLocation(bloodBankDTO.getBloodBankLocation());
   bloodBank.setActive(true);
   bloodBankRepository.save(bloodBank);

  } catch (Exception e) {
   log.error("saveBloodBank({})", bloodBankDTO);
   throw e;
  }
 }

 @Override
 public void updateBloodBank(BloodBankDTO bloodBankDTO) {
  log.info("updateBloodBank({})", bloodBankDTO);

  try {
   Optional<BloodBank> optionalBloodBank = bloodBankRepository.findById(bloodBankDTO.getBloodBankId());
   if (optionalBloodBank.isEmpty()) {
    throw new RuntimeException("bloodBank not found");
   }
   BloodBank bloodBank = optionalBloodBank.get();
   bloodBank.setBloodBankName(bloodBankDTO.getBloodBankName());
   bloodBank.setBloodBankContact(bloodBankDTO.getBloodBankContact());
   bloodBank.setBloodBankAddress(bloodBankDTO.getBloodBankAddress());
   bloodBank.setBloodBankLocation(bloodBankDTO.getBloodBankLocation());
   bloodBankRepository.save(bloodBank);

  } catch (Exception e) {
   log.error("updateBloodBank({})", bloodBankDTO);
   throw e;
  }

 }

 @Override
 public void deleteBloodBankById(Long id) {
  log.info("deleteBloodBankById({})", id);

  try {
   Optional<BloodBank> optionalBloodBank = bloodBankRepository.findById(id);
   if (optionalBloodBank.isEmpty()) {
    throw new RuntimeException("bloodBank not found");
   }
   BloodBank bloodBank = optionalBloodBank.get();
   bloodBank.setActive(false);
   bloodBankRepository.save(bloodBank);

  } catch (Exception e) {
   log.error("deleteBloodBankById({})", id);
   throw e;
  }
 }

 @Override
 public BloodBankDTO getBloodBankBy(Long bloodBankId) {
  log.info("getBloodBank({})", bloodBankId);
  try {
   Optional<BloodBank> bloodBank = bloodBankRepository.findById(bloodBankId);
   if (bloodBank.isEmpty()) {
    log.error("Sorry, related bloodBank is not found");
    throw new RuntimeException("Sorry, related bloodBank is not found");
   }
   BloodBank bloodBank1 = bloodBank.get();

   return new BloodBankDTO(
           bloodBank1.getBloodBankId(),
           bloodBank1.getBloodBankName(),
           bloodBank1.getBloodBankAddress(),
           bloodBank1.getBloodBankLocation(),
           bloodBank1.getBloodBankContact(),
           bloodBank1.isActive());

  } catch (Exception e) {
   log.error("bloodTypeServiceImpl({})", bloodBankId);
   throw e;
  }
 }

 @Override
 public List<BloodBankDTO> getAllBloodBanks() {
  log.info("getAllBloodBank()");
  try {
   List<BloodBankDTO> responseList = new ArrayList<>();
   List<BloodBank> bloodBanks = bloodBankRepository.findAll();

   for (BloodBank bloodBank : bloodBanks) {
    BloodBankDTO bloodBankDTO = new BloodBankDTO();
    bloodBankDTO.setBloodBankId(bloodBank.getBloodBankId());
    bloodBankDTO.setBloodBankName(bloodBank.getBloodBankName());
    bloodBankDTO.setBloodBankContact(bloodBank.getBloodBankContact());
    bloodBankDTO.setBloodBankAddress(bloodBank.getBloodBankAddress());
    bloodBankDTO.setBloodBankLocation(bloodBank.getBloodBankLocation());
    responseList.add(bloodBankDTO);
   }
   return responseList;

  } catch (Exception e) {
   log.error("bloodBankServiceImpl({})", bloodBankRepository);
   throw e;
  }
 }
}
