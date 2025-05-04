package com.example.stats.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // Find users by status (e.g., "Active", "Inactive", "Banned")
    List<User> findByStatus(String status);



    // Find users who are admins or not
    List<User> findByIsAdmin(String isAdmin);

    // Find user by username (for login or lookup)
    Optional<User> findByUsername(String username);

    // Find user by email (for account recovery or uniqueness check)
    Optional<User> findByEmail(String email);

    // Find all users with a specific role (e.g., "Customer", "Provider")
    List<User> findByRole(String role);

    // Find all users created after a specific date
    List<User> findByCreatedAtAfter(java.util.Date date);

    // Find all users with a specific combination of status and role
    List<User> findByStatusAndRole(String status, String role);

    long countByStatus(String status);

    @Query("SELECT COUNT(u) FROM User u WHERE u.active = true AND MONTH(u.createdAt) = :month")
    int countByActiveAndMonth(@Param("month") int month);

}
