package com.spring.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Service {
    private LuBanService luBanService;

    public Service(){
        System.out.println("service create");
    }

    public void test(){
        System.out.println(luBanService);
    }

    @Autowired
    public void setLuBanService(LuBanService luBanService) {
        this.luBanService = luBanService;
    }
}
