package com.example.audit.service;

import com.example.audit.domain.Just;
import com.example.audit.dto.JustDTO;
import com.example.audit.dto.UpdateJustDTO;
import com.example.audit.repository.JustRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class JustService {
    private final JustRepository justRepository;
    public  final  MapperService mapperService;

public void createJust(Just just) {
//version 2 how to use Builder or Mapper(mapstruct)
/*    justRepository.save(Just
            .builder()
            .room(justDTO.getRoom())
            .description(justDTO.getDescription())
            .number(justDTO.getNumber())
            .build());*/
    justRepository.save(just);
}

    public void deleteJust(Just just) {
        justRepository.delete(just);
    }

    public Just getJustById(long id) {
        Just byId = justRepository.getById(id);
        return byId;
    }

    public void updateRoom(long id, UpdateJustDTO updateJustDTO) {
        Just just = getJustById(id);
        Just entityJust = mapperService.mapperJust(updateJustDTO);
        just.setRoom(entityJust.getRoom());
        just.setNumber(entityJust.getNumber());
        just.setDescription(entityJust.getDescription());
        justRepository.save(just);
    }
}
