package com.sinem.randevu.controller;

import com.sinem.randevu.dto.response.BosRandevuResponseDto;
import com.sinem.randevu.dto.response.RandevuListesiResponseDto;
import com.sinem.randevu.repository.entity.Randevu;
import com.sinem.randevu.service.RandevuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/randevu")
@RequiredArgsConstructor
public class RandevuController {
    private final RandevuService randevuService;

    @GetMapping("/randevuolustur")
    public void randevuOlustur(String ad, String telefon, String email, LocalDate randevuTarihi, Integer randevuSaati) {
        Randevu randevu = Randevu.builder()
                .ad(ad)
                .telefon(telefon)
                .email(email)
                .randevuTarihi(randevuTarihi)
                .randevuSaati(randevuSaati)
                .musaitMi(false)
                .build();
        randevuService.save(randevu);
    }

    @GetMapping("/randevulistesi")
    public ResponseEntity<List<RandevuListesiResponseDto>> randevuListesi() {
        List<Randevu> randevuList = randevuService.findAll();
        List<RandevuListesiResponseDto> result = new ArrayList<>();
        randevuList.forEach(randevu -> {
            RandevuListesiResponseDto dto = RandevuListesiResponseDto
                    .builder()
                    .id(randevu.getId())
                    .ad(randevu.getAd())
                    .randevuTarihi(randevu.getRandevuTarihi())
                    .randevuSaati(randevu.getRandevuSaati())
                    .build();
            result.add(dto);
        });
        return ResponseEntity.ok(result);
    }

    @GetMapping("/bosrandevusaatleri")
    public ResponseEntity<List<BosRandevuResponseDto>> bosRandevuSaatleri(LocalDate arananTarih) {
        List<Randevu> arananTarihtekiRandevuList = randevuService.findAllByRandevuTarihi(arananTarih);
        List<BosRandevuResponseDto> result = new ArrayList<>();

        int saat = 9;
        boolean check = false;

        while (saat < 18){
            for (Randevu doluRandevu:arananTarihtekiRandevuList) {
                if(doluRandevu.getRandevuSaati().equals(saat)){
                    check = true;
                }
            }
            if(!check){
                BosRandevuResponseDto dto = BosRandevuResponseDto
                        .builder()
                        .randevuTarihi(arananTarih)
                        .randevuSaati(saat)
                        .build();
                result.add(dto);
            }
            saat++;
            check = false;
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/randevuiptal")
    public void randevuIptal(Long id) {
        randevuService.deleteById(id);
    }

}
