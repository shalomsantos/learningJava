package com.shalom.learning.service;

import com.shalom.learning.dto.GenderDto;
import com.shalom.learning.entity.Gender;
import com.shalom.learning.repository.GenderRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderService
{
    @Autowired
    private GenderRespository genderRespository;

    public List<Gender> all() { return genderRespository.findAll(); }

    public Gender create(GenderDto genderDto)
    {
        Gender gender = Gender.builder()
                .nome(genderDto.getNome())
                .descricao(genderDto.getDescricao())
                .build();
        return genderRespository.save(gender);
    }
}
