package com.ryan.springbootvue.service.token.imp;

import com.ryan.springbootvue.mathUtil.RSA;
import com.ryan.springbootvue.service.token.GenAndVerTokenService;
import org.springframework.stereotype.Service;

/**
 * @Author Ryan
 * @Date 2020/4/22 20:22
 * version 1.0
 */
@Service
public class GenAndVerTokenImp implements GenAndVerTokenService {
    @Override
    public String genToken(String source) throws Exception {
        return RSA.encrypt(source,PUBLIC_KEY);
    }

    @Override
    public String verToken(String cryptograph) throws Exception {
        return null;
    }
}
