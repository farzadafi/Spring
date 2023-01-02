package com.example.spring_security.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "users")
public class User extends Base<Integer> implements UserDetails {

    @Column(unique = true)
    private String username;

    private String password;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    @ToString.Exclude
    private Set<Role> roles;

    private boolean isEnabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getPermissionAuthority(); //for permission base system
        //return getRoleAuthority();     //for role base system
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Transient
    public List<SimpleGrantedAuthority> getPermissionAuthority() {
        List<SimpleGrantedAuthority> permissionNameList = new ArrayList<>();
        this.getRoles()
                .forEach(role -> role
                        .getPermissions()
                        .forEach(permission -> permissionNameList
                                .add(new SimpleGrantedAuthority(permission.getName()))));
        return permissionNameList;
    }

    @Transient
    public List<SimpleGrantedAuthority> getRoleAuthority() {
        List<SimpleGrantedAuthority> roleNameList = new ArrayList<>();
        this.getRoles()
                .forEach(role -> roleNameList
                        .add(new SimpleGrantedAuthority(role.getName())));
        return roleNameList;
    }
}
