package com.butiksystem.motiveramerav2.Repostory;

import com.butiksystem.motiveramerav2.Entity.Reward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RewardRepository extends JpaRepository<Reward, Long> {
    List<Reward> findByForStudentId(int studentId);
    List<Reward> findByCreatedByParentId(int forParent);
    List<Reward> findByClaimedTrue();
    Optional<Reward> findById(int id);



}