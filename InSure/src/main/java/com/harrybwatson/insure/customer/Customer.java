package com.harrybwatson.insure.customer;

import com.harrybwatson.insure.user.model.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String customerFname;
    private String customerLname;

    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "The email address is invalid")
    @NotBlank(message = "Email is required")
    private String customerEmail;
    private String customerPhone;
    private String customerAddress;
    private String customerSex;
    private Date customerBirth;
    private String customerEmployment;
    private Double customerRiskRate;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User agentIC;
}
