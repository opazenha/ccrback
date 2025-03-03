package net.ddns.opazenha.ccrback.prayers;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrayerRepository extends JpaRepository<Prayer, Long> {
    List<Prayer> findByRequesterId(Long requesterId);
}
