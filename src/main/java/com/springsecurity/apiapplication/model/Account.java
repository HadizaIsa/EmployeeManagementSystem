package com.springsecurity.apiapplication.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private boolean enabled = true;

    private boolean credentialsexpired = false;

    private boolean expired = false;

    private boolean locked = false;

    @ManyToMany(fetch = EAGER, cascade = ALL)
    @JoinTable(
        name = "AccountRole",
        joinColumns = @JoinColumn(name = "accountId", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "roleId", referencedColumnName = "id")
    )
    private Set<Role> roles;

}
