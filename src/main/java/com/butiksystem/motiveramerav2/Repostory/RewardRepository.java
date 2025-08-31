package com.butiksystem.motiveramerav2.Repostory;

import com.butiksystem.motiveramerav2.Entity.Reward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardRepository extends JpaRepository<Reward, Long> {
}