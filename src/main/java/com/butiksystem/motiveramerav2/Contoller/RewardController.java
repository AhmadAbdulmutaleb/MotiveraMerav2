package com.butiksystem.motiveramerav2.Contoller;

import com.butiksystem.motiveramerav2.Entity.Reward;
import com.butiksystem.motiveramerav2.Service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rewards")
public class RewardController {

    @Autowired
    private RewardService rewardService;


    @GetMapping("/student/{studentId}")
    public List<Reward> getRewardsByStudentId(@PathVariable int studentId) {
        return rewardService.getRewardForStudent(studentId);
    }

}
