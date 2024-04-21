package com.example.spring.service;

import com.example.spring.entity.Staff;
import com.example.spring.entity.Trainer;
import com.example.spring.repository.ClientRepository;
import com.example.spring.repository.StaffRepository;
import com.example.spring.repository.TrainerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The StaffServiceImpl class implements the StaffService interface.
 * It provides methods to manage Staff entities by interacting with the StaffRepository.
 */
@Service
public class StaffServiceImpl implements StaffService {

    private StaffRepository staffRepository;
    private ClientRepository clientRepository;
    private TrainerRepository trainerRepository;

    public StaffServiceImpl(StaffRepository staffRepository, ClientRepository clientRepository, TrainerRepository trainerRepository) {
        this.clientRepository=clientRepository;
        this.staffRepository=staffRepository;
        this.trainerRepository=trainerRepository;
    }

    @Override
    public Staff createStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public Staff getStaffById(int staffId) {
        Optional<Staff> optionalStaff = staffRepository.findById(staffId);
        return optionalStaff.orElse(null);
    }

    @Override
    public List<Staff> getAllStaffs() {
        return staffRepository.findAll();
    }

    @Override
    public Staff updateStaff(Staff staff) {
        Staff existingStaff = staffRepository.findById(staff.getId()).orElse(null);
        if (existingStaff != null) {
            existingStaff.setName(staff.getName());
            existingStaff.setAge(staff.getAge());
            return staffRepository.save(existingStaff);
        }
        return null;
    }

    @Override
    public void deleteStaff(int staffId) {
        staffRepository.deleteById(staffId);
    }

    @Override
    public void deleteTrainer(int trainerId) {
        if(trainerRepository.existsById(trainerId)){

            trainerRepository.deleteById(trainerId);
        }
    }

    @Override
    public void deleteClient(int clientId) {
        if(clientRepository.existsById(clientId)){
            clientRepository.deleteById(clientId);
        }

    }
}
