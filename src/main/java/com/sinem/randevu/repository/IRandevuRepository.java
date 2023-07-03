package com.sinem.randevu.repository;

import com.sinem.randevu.repository.entity.Randevu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IRandevuRepository extends JpaRepository<Randevu, Long> {

    List<Randevu> findAllByRandevuTarihi(LocalDate arananTarih);
}
