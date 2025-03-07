package net.ddns.opazenha.ccrback.events;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepository extends JpaRepository<Events, Long> {
    List<Events> findByName(String name);
}
