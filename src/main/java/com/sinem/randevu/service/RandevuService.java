package com.sinem.randevu.service;

import com.sinem.randevu.exceptions.ErrorType;
import com.sinem.randevu.exceptions.RandevuException;
import com.sinem.randevu.repository.IRandevuRepository;
import com.sinem.randevu.repository.entity.Randevu;
import com.sinem.randevu.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RandevuService extends ServiceManager<Randevu, Long> {
    private final IRandevuRepository randevuRepository;

    public RandevuService(IRandevuRepository randevuRepository) {
        super(randevuRepository);
        this.randevuRepository = randevuRepository;
    }

    public Randevu save(Randevu randevu) {
        List<Randevu> butunRandevular = randevuRepository.findAll();
        for (Randevu mevcutRandevu : butunRandevular) {
            if (randevu.getRandevuTarihi().isEqual(mevcutRandevu.getRandevuTarihi())) {
                if (randevu.getRandevuSaati() == mevcutRandevu.getRandevuSaati()) {
                    throw new RandevuException(ErrorType.RANDEVU_DOLU);
                }
            }
        }
        if (randevu.getRandevuTarihi().isBefore(LocalDate.now())) {
            throw new RandevuException(ErrorType.GECERSIZ_TARIH);
        }
        if(randevu.getRandevuSaati() < 9 || randevu.getRandevuSaati() > 17){
            throw new RandevuException(ErrorType.GECERSIZ_SAAT);
        }
        return randevuRepository.save(randevu);
    }


  public List<Randevu> findAllByRandevuTarihi(LocalDate arananTarih) {
        return randevuRepository.findAllByRandevuTarihi(arananTarih);
    }


}
