package com.harrybwatson.insure.policy.repository;

import com.harrybwatson.insure.policy.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PolicyRepository extends JpaRepository<Policy, Long> {

    Policy findByPolicyId(Long policyId);

}
