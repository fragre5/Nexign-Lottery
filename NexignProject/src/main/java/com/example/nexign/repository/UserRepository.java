package com.example.nexign.repository;

import com.example.nexign.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(
            value = "SELECT participants.id FROM participants", nativeQuery = true
    )
    List<Long> findAll_Id();

    @Modifying
    @Query(value = "INSERT INTO winners values(:id, :first_name,:age, :city)", nativeQuery = true)
    @Transactional
    void saveWinner(Long id, String first_name, int age, String city);
}