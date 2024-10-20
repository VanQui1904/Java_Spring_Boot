package com.example.Cua_Hang_Oto.repository;

import com.example.Cua_Hang_Oto.entity.TestDrive;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestDriveRepository extends JpaRepository<TestDrive, Long> {
//    List<TestDrive> findByCustomer_id(Long customerId);
}
