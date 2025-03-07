package net.ddns.opazenha.ccrback.newsletter;

import java.util.Optional;
import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsletterRepository extends JpaRepository<Newsletter, Long> {
    Optional<Newsletter> findByDate(Date date);
}
