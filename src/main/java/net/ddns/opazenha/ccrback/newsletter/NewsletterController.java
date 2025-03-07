package net.ddns.opazenha.ccrback.newsletter;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.sql.Date;
import java.util.List;

@RestController
public class NewsletterController {
    private final NewsletterService newsletterService;

    public NewsletterController(NewsletterService newsletterService) {
        this.newsletterService = newsletterService;
    }

    @GetMapping("/newsletters")
    public List<Newsletter> getAllNewsletters() {
        return newsletterService.getAllNewsletters();
    }

    @GetMapping("/newsletters/{id}")
    public Newsletter getNewsletterById(@PathVariable Long id) {
        return newsletterService.getNewsletterById(id);
    }

    @PostMapping("/newsletters")
    public Newsletter createNewsletter(@RequestBody Newsletter newsletter) {
        return newsletterService.createNewsletter(newsletter);
    }

    @PutMapping("/newsletters/{id}")
    public Newsletter updateNewsletter(@PathVariable Long id, @RequestBody Newsletter newsletter) {
        return newsletterService.updateNewsletter(id, newsletter);
    }

    @DeleteMapping("/newsletters/{id}")
    public void deleteNewsletter(@PathVariable Long id) {
        newsletterService.deleteNewsletter(id);
    }

    @GetMapping("/newsletters/{date}")
    public Newsletter getNewsletterByDate(@PathVariable Date date) {
        return newsletterService.getNewsletterByDate(date);
    }
}
