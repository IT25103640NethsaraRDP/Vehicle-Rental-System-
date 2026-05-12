package com.rentalsystem.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByApprovedTrue();
    List<Review> findByVehicleId(Long vehicleId);
    List<Review> findByVehicleIdAndApprovedTrue(Long vehicleId);
}
