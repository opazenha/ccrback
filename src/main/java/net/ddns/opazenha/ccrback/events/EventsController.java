package net.ddns.opazenha.ccrback.events;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/v1/events")
public class EventsController {

    @Autowired
    private final EventsService eventsService;

    public EventsController(EventsService eventsService) {
        this.eventsService = eventsService;
    }

    @GetMapping("/")
    public List<Events> getAllEvents() {
        return eventsService.getAllEvents();
    }

    @GetMapping("/{id}")
    public Events getEventById(@PathVariable Long id) {
        return eventsService.getEventById(id);
    }

    @PostMapping("/")
    public Events createEvent(@RequestBody Events event) {
        return eventsService.createEvent(event);
    }

    @PutMapping("/{id}")
    public Events updateEvent(@PathVariable Long id, @RequestBody Events event) {
        return eventsService.updateEvent(id, event);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventsService.deleteEvent(id);
    }

    @GetMapping("/name/{name}")
    public List<Events> getEventsByName(@PathVariable String name) {
        return eventsService.getEventsByName(name);
    }
}
