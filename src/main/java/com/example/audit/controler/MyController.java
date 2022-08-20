package com.example.audit.controler;

import com.example.audit.domain.Just;
import com.example.audit.dto.JustDTO;
import com.example.audit.dto.UpdateJustDTO;
import com.example.audit.service.JustService;
import com.example.audit.service.MapperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping(value = "/api")
public class MyController {


    public  final  MapperService mapperService;
    public final JustService justService;

    public MyController(MapperService mapperService, JustService justService) {
        this.mapperService = mapperService;
        this.justService = justService;
    }


    private static final Logger log = LoggerFactory.getLogger(MyController.class);

    @RequestMapping(value = "/justdto/create", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public String justDto(@RequestBody JustDTO justDTO) {
        String response = "Added " + new Date();
        log.info("Response => {}",response);
        Just justEntity = mapperService.mapperJust(justDTO);
        justService.createJust(justEntity);
        return response;
    }

    @RequestMapping(value = "/justdto/delete/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public void deleteJustDto (@PathVariable Long id)  {
        Just just = justService.getJustById(id);
        justService.deleteJust(just);
    }

    @RequestMapping(value = "/justdto/update/{id}", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public void updateRoom(@PathVariable Long id,
                           @RequestBody UpdateJustDTO justDto) {
        justService.updateRoom(id, justDto);
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
