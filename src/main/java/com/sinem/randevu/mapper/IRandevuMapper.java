package com.sinem.randevu.mapper;

import com.sinem.randevu.dto.response.RandevuListesiResponseDto;
import com.sinem.randevu.repository.entity.Randevu;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRandevuMapper {

    IRandevuMapper INSTANCE = Mappers.getMapper(IRandevuMapper.class);

    RandevuListesiResponseDto randevuToDto(final Randevu randevu);


}
