package com.example.audit.service;

import com.example.audit.domain.Just;
import com.example.audit.dto.JustDTO;
import com.example.audit.repository.JustRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class JustService {
    private final JustRepository justRepository;

//
public void createJust(JustDTO justDTO) {

    justRepository.save(Just
            .builder()
            .room(justDTO.getRoom())
            .description(justDTO.getDescription())
            .number(justDTO.getNumber())
            .build());
}
}
