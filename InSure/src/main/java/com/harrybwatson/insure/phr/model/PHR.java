package com.harrybwatson.insure.phr.model;

import com.harrybwatson.insure.customer.Customer;
import com.harrybwatson.insure.policy.model.Policy;
import com.harrybwatson.insure.user.model.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class PHR {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phr_id", nullable = false)
    private Long phrId;


    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(targetEntity = Policy.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "policy_id")
    private Policy policy;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "agent_id")
    private User user;

    private Date since;
    private Date till;
    private BigDecimal premium;
    private String remarks;
}
