package com.example.audit.service;

import com.example.audit.domain.Just;
import com.example.audit.dto.JustDTO;
import com.example.audit.dto.UpdateJustDTO;
import com.example.audit.mappers.CustomerMapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
@ComponentScan(basePackages = "com.example.audit")
public class MapperService {

    private final CustomerMapper customerMapper;
    public MapperService(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    public Just mapperJust(JustDTO justDTO) {
        return customerMapper.toModel(justDTO);
    }
    public Just mapperJust(UpdateJustDTO updateJustDTO) {
        return customerMapper.toModel(updateJustDTO);
    }
}
