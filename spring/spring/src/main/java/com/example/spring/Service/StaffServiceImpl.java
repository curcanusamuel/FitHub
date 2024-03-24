package com.example.spring.Service;

import com.example.spring.Entity.Staff;
import com.example.spring.Repository.StaffRepository;

import java.util.List;
import java.util.Optional;

/**
 * The StaffServiceImpl class implements the StaffService interface.
 * It provides methods to manage Staff entities by interacting with the StaffRepository.
 */
public class StaffServiceImpl implements StaffService {

    private StaffRepository staffRepository;

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
            existingStaff.setClientId(staff.getClientId());
            existingStaff.setTrainerId(staff.getTrainerId());
            return staffRepository.save(existingStaff);
        }
        return null;
    }

    @Override
    public void deleteStaff(int staffId) {
        staffRepository.deleteById(staffId);
    }
}
