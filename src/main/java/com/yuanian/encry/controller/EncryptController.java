package com.yuanian.encry.controller;

import com.yuanian.encry.utils.AESCoder;
import com.yuanian.encry.utils.UUIDUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhahsh
 * @date 2020/12/7
 */
@RestController
@CrossOrigin
public class EncryptController {

    @RequestMapping(value = "/encrypt",method = RequestMethod.GET)
    public String encryptPassword(@RequestParam String password){
        return AESCoder.encryptPassword(password);
    }

    @RequestMapping(value = "/decrypt",method = RequestMethod.GET)
    public String decryptPassword(@RequestParam String password){
        return AESCoder.decryptPassword(password);
    }

    @RequestMapping(value = "/getUUID",method = RequestMethod.GET)
    public String getUUID(){
        return UUIDUtils.getUUID();
    }
}
