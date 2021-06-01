package com.cyt.authority.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author Chenyt7
 * @Time 2021/5/22
 * @describe: 权限封装
 **/
public class GrantedAuthorityImpl implements GrantedAuthority {
    private static final long serialVersionUID = 1L;
    private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}