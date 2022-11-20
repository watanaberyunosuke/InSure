package com.harrybwatson.insure.policy.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long policyId;
    private String policyName;

    @ManyToOne(targetEntity = PolicyType.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "policy_type_id")
    private PolicyType policyType;
    private String policyDescription;

    public Policy(String policyName, String policyDescription, PolicyType policyType) {
        this.policyName = policyName;
        this.policyType = policyType;
        this.policyDescription = policyDescription;
    }
}
