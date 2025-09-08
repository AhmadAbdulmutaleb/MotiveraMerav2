package com.butiksystem.motiveramerav2.Repostory;


import com.butiksystem.motiveramerav2.Entity.ParentStudentRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentStudentRepository extends JpaRepository<ParentStudentRelationship, Long> {


}
