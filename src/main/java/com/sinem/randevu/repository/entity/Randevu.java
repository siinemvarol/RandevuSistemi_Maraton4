package com.sinem.randevu.repository.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tblrandevu")
public class Randevu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ad;
    String telefon;
    String email;
    LocalDate randevuTarihi;
    @Range(min = 9, max = 17)
    Integer randevuSaati;
    Boolean musaitMi;


}
