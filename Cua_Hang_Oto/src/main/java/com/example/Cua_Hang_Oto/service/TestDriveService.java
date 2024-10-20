package com.example.Cua_Hang_Oto.service;


import com.example.Cua_Hang_Oto.entity.TestDrive;
import com.example.Cua_Hang_Oto.repository.TestDriveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestDriveService {


    @Autowired
    private TestDriveRepository testDriveScheduleRepository;

    public List<TestDrive> findAll() {
        return testDriveScheduleRepository.findAll();
    }

    public TestDrive saveTestDriveSchedule(TestDrive testDriveSchedule) {
        return testDriveScheduleRepository.save(testDriveSchedule);
    }

//    public List<TestDrive> getTestDriveSchedulesByCustomerId(Long customerId) {
//        return testDriveScheduleRepository.findByCustomerId(customerId);
//    }

    public Optional<TestDrive> getTestDriveScheduleById(Long id) {
        return testDriveScheduleRepository.findById(id);
    }

    public void deleteTestDriveSchedule(Long id) {
        testDriveScheduleRepository.deleteById(id);
    }
    public TestDrive confirmTestDriveSchedule(Long id) {
        TestDrive testDrive = testDriveScheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Test drive not found"));
        testDrive.setStatus("confirmed"); // Cập nhật trạng thái
        return testDriveScheduleRepository.save(testDrive);
    }

    public TestDrive cancelTestDriveSchedule(Long id) {
        TestDrive testDrive = testDriveScheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Test drive not found"));
        testDrive.setStatus("canceled"); // Cập nhật trạng thái
        return testDriveScheduleRepository.save(testDrive);
    }
}
