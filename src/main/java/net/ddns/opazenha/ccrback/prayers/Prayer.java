package net.ddns.opazenha.ccrback.prayers;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "prayers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Prayer {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "requester_id", insertable = false, updatable = false)
        private Long requesterId;
        
        @Column(name = "prayer_request")
        private String prayerRequest;
        
        private PrayerStatus status;
}
