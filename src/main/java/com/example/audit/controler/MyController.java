package com.example.audit.controler;

import com.example.audit.dto.JustDTO;
import com.example.audit.service.JustService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/api")
public class MyController {

    public final JustService justService;

    public MyController(JustService justService) {
        this.justService = justService;
    }


    private static final Logger log = LoggerFactory.getLogger(MyController.class);


    @RequestMapping(value = "/justdto", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public String justDto(@RequestBody JustDTO justDTO) {
        String response = "Hello World AA! " + new Date();
        log.info("Response => {}",response);
        justService.createJust(justDTO);
        return response;
    }




    @GetMapping(value = "/check")
    public String check() {
        //Original String
        String string = "hello world";

        //Convert to byte[]
        byte[] bytes = string.getBytes();


        //Convert back to String
        String s = new String(bytes);

        //Check converted string against original String
        System.out.println("Decoded String : " + s);
        return s;
    }
}
