package br.com.thorugoh.events.repository;

import br.com.thorugoh.events.model.Event;
import br.com.thorugoh.events.model.Subscription;
import br.com.thorugoh.events.model.User;
import org.springframework.data.repository.CrudRepository;

public interface SubscriptionRepo extends CrudRepository<Subscription, Integer> {
    public Subscription findByEventAndSubscriber(Event evt, User user);
}
