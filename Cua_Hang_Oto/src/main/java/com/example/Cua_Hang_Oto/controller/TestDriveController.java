package com.example.Cua_Hang_Oto.controller;

import com.example.Cua_Hang_Oto.entity.TestDrive;
import com.example.Cua_Hang_Oto.service.TestDriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/testDrive")
@CrossOrigin(origins = {"http://localhost:4200"})
public class TestDriveController {
    @Autowired
    private TestDriveService testDriveScheduleService;

    @GetMapping("/getTD")
    public List<TestDrive> getTD() {
        return testDriveScheduleService.findAll();
    }

    @PostMapping("/schedule")
    public ResponseEntity<TestDrive> scheduleTestDrive(@RequestBody TestDrive testDrive) {
        TestDrive savedSchedule = testDriveScheduleService.saveTestDriveSchedule(testDrive);
        return ResponseEntity.ok(savedSchedule);
    }

    @PutMapping("/confirm/{id}")
    public ResponseEntity<TestDrive> confirmTestDrive(@PathVariable Long id) {
        TestDrive updatedTestDrive = testDriveScheduleService.confirmTestDriveSchedule(id);
        return ResponseEntity.ok(updatedTestDrive);
    }

    @PutMapping("/cancel/{id}")
    public ResponseEntity<TestDrive> cancelTestDrive(@PathVariable Long id) {
        TestDrive updatedTestDrive = testDriveScheduleService.cancelTestDriveSchedule(id);
        return ResponseEntity.ok(updatedTestDrive);
    }

//    @GetMapping("/customer/{customerId}")
//    public List<TestDrive> getTestDrivesByCustomerId(@PathVariable Long customerId) {
//        return testDriveScheduleService.getTestDriveSchedulesByCustomerId(customerId);
//    }


}
