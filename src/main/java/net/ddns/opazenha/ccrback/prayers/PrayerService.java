package net.ddns.opazenha.ccrback.prayers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PrayerService {
    private final PrayerRepository prayerRepository;

    public PrayerService(PrayerRepository prayerRepository) {
        this.prayerRepository = prayerRepository;
    }

    public ResponseEntity<Object> savePrayer(Prayer prayer) {
        Prayer newPrayer = prayerRepository.save(prayer);
        return ResponseEntity.ok(newPrayer);
    }

    public List<Prayer> getPrayers() {
        return prayerRepository.findAll();
    }

    public List<Prayer> getPrayersByRequesterId(Long requesterId) {
        List<Prayer> prayers = this.prayerRepository.findByRequesterId(requesterId);
        if (prayers.isEmpty()) {
            System.out.println("No prayers found for requester: " + requesterId);
            return null;
        }
        return prayers;
    }
    
    public ResponseEntity<Object> getPrayerById(Long prayerId) {
        Optional<Prayer> prayer = prayerRepository.findById(prayerId);
        if (!prayer.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(prayer);
    }

    public ResponseEntity<Object> updatePrayerStatus(Long prayerId, PrayerStatus status) {
        Optional<Prayer> prayer = prayerRepository.findById(prayerId);
        if (!prayer.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        prayer.get().setStatus(status);
        Prayer updatedPrayer = prayerRepository.save(prayer.get());
        return ResponseEntity.ok(updatedPrayer);
    }

    public ResponseEntity<Object> updatePrayerRequest(Long prayerId, String prayerRequest) {
        Optional<Prayer> prayer = prayerRepository.findById(prayerId);
        if (!prayer.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        prayer.get().setPrayerRequest(prayerRequest);
        Prayer updatedPrayer = prayerRepository.save(prayer.get());
        return ResponseEntity.ok(updatedPrayer);
    }
    
    public ResponseEntity<Object> deletePrayer(Long prayerId) {
        Optional<Prayer> prayer = prayerRepository.findById(prayerId);
        if (!prayer.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        prayerRepository.delete(prayer.get());
        return ResponseEntity.ok().build();
    }

    public Prayer createPrayer(Prayer prayer) {
        return this.prayerRepository.save(prayer);
    }
}
