package net.ddns.opazenha.ccrback.newsletter;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class NewsletterService {
    private final NewsletterRepository newsletterRepository;

    public NewsletterService(NewsletterRepository newsletterRepository) {
        this.newsletterRepository = newsletterRepository;
    }

    public List<Newsletter> getAllNewsletters() {
        return newsletterRepository.findAll();
    }

    public Newsletter getNewsletterById(Long id) {
        return newsletterRepository.findById(id).orElse(null);
    }

    public Newsletter createNewsletter(Newsletter newsletter) {
        return newsletterRepository.save(newsletter);
    }

    public Newsletter updateNewsletter(Long id, Newsletter newsletter) {
        return newsletterRepository.save(newsletter);
    }

    public void deleteNewsletter(Long id) {
        newsletterRepository.deleteById(id);
    }

    public Newsletter getNewsletterByDate(Date date) {
        return newsletterRepository.findByDate(date).orElse(null);
    }
}
