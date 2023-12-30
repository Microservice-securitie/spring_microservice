package org.sid.billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController

public class ConsuleConfigRestController {

    @Autowired
    private MyConsuleConfig myConsuleConfig;


    /* @Value("${token.accesTokenTimeOut}")
    private long accesTokenTimeOut;
    @Value("${token.refreshTokenTimeOut}")
    private long refreshTokenTimeOut;*/


    @GetMapping("/myconfig")
    public MyConsuleConfig myConfig(){
        return myConsuleConfig;
    }

}
