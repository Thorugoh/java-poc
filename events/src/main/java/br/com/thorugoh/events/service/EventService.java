package br.com.thorugoh.events.service;

import br.com.thorugoh.events.model.Event;
import br.com.thorugoh.events.repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    // Dependency Injection, creates instance based on EventRepo Crud Interface
    // we will never create a new instance of eventRepo, Spring takes care of this
    @Autowired
    private EventRepo eventRepo;

    public Event addNewEvent(Event event){
        // generate prettyName
        event.setPrettyName(event.getTitle().toLowerCase().replaceAll(" ", "-"));

        return eventRepo.save(event);
    }

    public List<Event> getAllEvents(){
        return (List<Event>)eventRepo.findAll();
    }

    public Event getByPrettyName(String prettyName) {
        return eventRepo.findByPrettyName(prettyName);
    }
}
