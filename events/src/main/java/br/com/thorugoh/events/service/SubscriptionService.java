package br.com.thorugoh.events.service;

import br.com.thorugoh.events.model.Event;
import br.com.thorugoh.events.model.Subscription;
import br.com.thorugoh.events.model.User;
import br.com.thorugoh.events.repository.EventRepo;
import br.com.thorugoh.events.repository.SubscriptionRepo;
import br.com.thorugoh.events.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {
    @Autowired
    private EventRepo evtRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private SubscriptionRepo subRepo;

    public Subscription createNewSubscription(String eventName, User user){
        // get event by name
        Event evt = evtRepo.findByPrettyName(eventName);
        user = userRepo.save(user);

        Subscription subs = new Subscription();
        subs.setEvent(evt);
        subs.setSubscriber(user);

        Subscription res = subRepo.save(subs);
        return res;
    }
}
