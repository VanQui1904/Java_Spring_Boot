package com.example.Cua_Hang_Oto.repository;

import com.example.Cua_Hang_Oto.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsernameAndAccountPassword(String username, String accountPassword);

    // Tìm tài khoản theo username (để kiểm tra khi đăng ký)
    Optional<Account> findByUsername(String username);
    Optional<Account> findByEmail(String email);
}
