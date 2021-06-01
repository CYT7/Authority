package com.cyt.authority.security;

import com.cyt.authority.utils.PasswordEncoder;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Chenyt7
 * @Time 2021/5/22
 * @describe: 身份验证提供者
 **/
public class JwtAuthenticationProvider extends DaoAuthenticationProvider {
    public JwtAuthenticationProvider(UserDetailsService userDetailsService) {
        setUserDetailsService(userDetailsService);
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException {
        if (authentication.getCredentials() == null) {
            logger.debug("身份验证失败：未提供凭据");
            throw new BadCredentialsException(messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "错误的凭据"));
        }
        String presentedPassword = authentication.getCredentials().toString();
        String salt = ((JwtUserDetails) userDetails).getSalt();
        //覆写密码验证逻辑
        if (!new PasswordEncoder(salt).matches(userDetails.getPassword(), presentedPassword)) {
            logger.debug("身份验证失败：密码与存储值不匹配");
            throw new BadCredentialsException(messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "错误的凭据"));
        }
    }
}