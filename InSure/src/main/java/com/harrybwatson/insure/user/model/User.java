package com.harrybwatson.insure.user.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Objects;

/**
 * This is the agent/admin model
 * Note that the login features are handled by Spring Security at security package
 */
@Entity
@ToString
@RequiredArgsConstructor
@Getter
@Setter
@Table(name = "user",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_email", "user_id"})})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    private String userFname;
    private String userLname;

    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "The email address is invalid")
    @NotBlank(message = "Email is required")
    @Column(name = "user_email", nullable = false)
    private String userEmail;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "The user type is required")
    private UserType userType;

    private String userPassword;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return userId != null && Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
