package com.atl.edusoftware.data.model

import org.hibernate.validator.constraints.Email
import org.hibernate.validator.constraints.Length
import org.hibernate.validator.constraints.NotEmpty

import javax.persistence.*

@Entity
@Table(name = "user_details")
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    Long id

    @Column(name = "email")
    @Email(message = "Provide a valid Email address")
    @NotEmpty(message = "Please provide an email")
    String email

    @Column(name = "password")
    @Length(min = 8, message = "*Your password must have at least 8 characters")
    @NotEmpty(message = "Provide a password")
    String password

    @Column(name = "first_name")
    @Length(min = 3, max = 10, message = "Provide a name between 3-10 characters")
    @NotEmpty(message = "Please provide your first name")
    String firstName

    @Column(name = "last_name")
    @Length(min = 3, max = 10, message = "Provide a last name between 3-10 characters")
    @NotEmpty(message = "Please provide your last name")
    String lastName

    @Column(name = "active")
    int active

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    Set<Role> roles
}