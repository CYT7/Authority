package com.cyt.authority.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;

/**
 * @author Chenyt7
 * @date  2021/5/22
 * @describe 自定义令牌对象
 **/
public class JwtAuthenticatioToken extends UsernamePasswordAuthenticationToken {
    private static final long serialVersionUID = 1L;
    private String token;

    public JwtAuthenticatioToken(Object principal, Object credentials){
        super(principal, credentials);
    }

    public JwtAuthenticatioToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities, String token) {
        super(principal, credentials, authorities);
        this.token = token;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}