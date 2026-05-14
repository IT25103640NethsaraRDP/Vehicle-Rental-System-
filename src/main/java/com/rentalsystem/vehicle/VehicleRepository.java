package com.rentalsystem.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    
    @Query("SELECT v FROM Vehicle v WHERE LOWER(v.brand) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(v.model) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Vehicle> searchByBrandOrModel(String keyword);
    
    List<Vehicle> findByAvailableTrue();
}
