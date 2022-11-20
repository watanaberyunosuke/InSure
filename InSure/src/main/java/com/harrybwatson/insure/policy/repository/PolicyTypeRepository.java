package com.harrybwatson.insure.policy.repository;

import com.harrybwatson.insure.policy.model.PolicyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface PolicyTypeRepository extends JpaRepository<PolicyType, Long> {


    PolicyType findByPolicyTypeId(Long policyTypeId);
}
