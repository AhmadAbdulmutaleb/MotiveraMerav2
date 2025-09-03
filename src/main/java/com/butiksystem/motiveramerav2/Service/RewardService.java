package com.butiksystem.motiveramerav2.Service;

import com.butiksystem.motiveramerav2.Entity.Reward;
import com.butiksystem.motiveramerav2.Repostory.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardService {

    @Autowired
    private RewardRepository rewardRepository;


    //Hämta alla tillgängliga rewards för student
    public List<Reward> getRewardForStudent(int studentId) {
        return rewardRepository.findByForStudentId(studentId);
    }


}
