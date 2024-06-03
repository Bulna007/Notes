package com.bcs.security.beans;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class UserDetailsImpl implements UserDetails {
    private int systemUserId;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private String status;

    public UserDetailsImpl(int systemUserId, String username, String password, String role, String status) {
        this.systemUserId = systemUserId;
        this.username = username;
        this.password = password;
        this.authorities = Arrays.asList(new GrantedAuthority[]{new SimpleGrantedAuthority(role)});
        this.status = status;
    }

    public int getSystemUserId() {
        return systemUserId;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !status.equals("E");
    }

    @Override
    public boolean isAccountNonLocked() {
        return !status.equals("L");
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return status.equals("A");
    }


}
