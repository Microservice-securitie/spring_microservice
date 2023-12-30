package org.sid.billing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class ConsuleConfigRestController {
    @Value("${token.accesTokenTimeOut}")
    private long accesTokenTimeOut;
    @Value("${token.refreshTokenTimeOut}")
    private long refreshTokenTimeOut;


    @GetMapping("/myconfig")
    public Map<String,Object> myConfig(){
        return Map.of("accesTokenTimeOut",accesTokenTimeOut,"refreshTokenTimeOut",refreshTokenTimeOut);  //key.value
    }

}
