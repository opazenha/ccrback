package net.ddns.opazenha.ccrback.events;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventsService {

    @Autowired
    private final EventsRepository eventsRepository;

    public EventsService(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    public List<Events> getAllEvents() {
        return eventsRepository.findAll();
    }

    public Events getEventById(Long id) {
        return eventsRepository.findById(id).orElse(null);
    }

    public Events createEvent(Events event) {
        return eventsRepository.save(event);
    }

    public Events updateEvent(Long id, Events event) {
        return eventsRepository.save(event);
    }

    public void deleteEvent(Long id) {
        eventsRepository.deleteById(id);
    }

    public List<Events> getEventsByName(String name) {
        return eventsRepository.findByName(name);
    }

}
