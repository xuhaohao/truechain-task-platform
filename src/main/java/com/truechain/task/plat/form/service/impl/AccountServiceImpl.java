package com.truechain.task.plat.form.service.impl;

import com.truechain.task.plat.form.core.BusinessException;
import com.truechain.task.plat.form.model.entity.AuthUser;
import com.truechain.task.plat.form.repository.AuthUserRepository;
import com.truechain.task.plat.form.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AuthUserRepository userRepository;


    @Override
    public AuthUser register(AuthUser authUser) {
        int count = userRepository.countByUsername(authUser.getUsername());
        if (count > 0) {
            throw new BusinessException("账号已注册");
        }
        //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String password = authUser.getPassword();
        //String realPassword = encoder.encode(password);
        //authUser.setPassword(realPassword);
        return userRepository.save(authUser);
    }

    @Override
    public Map login(String userName, String password) {
        //UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(userName, password);
        //final Authentication authentication = authenticationManager.authenticate(upToken);
        // SecurityContextHolder.getContext().setAuthentication(authentication);
        //final UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
        // final String token = JwtUtil.createToken(userDetails, 10000L);
        Map resultMap = new HashMap();
        //resultMap.put("token", token);
        //resultMap.put("user", userDetails);
        return resultMap;
    }

    @Override
    public String refreshToken(String oldToken) {
        throw new UnsupportedOperationException();
    }
}
