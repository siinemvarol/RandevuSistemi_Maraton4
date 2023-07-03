package com.sinem.randevu.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BosRandevuResponseDto {
    LocalDate randevuTarihi;
    Integer randevuSaati;
}
