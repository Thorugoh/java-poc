package br.com.thorugoh.events.repository;

import br.com.thorugoh.events.model.Subscription;
import org.springframework.data.repository.CrudRepository;

public interface SubscriptionRepo extends CrudRepository<Subscription, Integer> {
}
