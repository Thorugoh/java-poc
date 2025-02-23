package br.com.thorugoh.events.repository;

import br.com.thorugoh.events.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepo extends CrudRepository<Event, Integer> {
    // JPA reads definition and based on function name it creates the SQL String
    public Event findByPrettyName(String prettyName);
}
