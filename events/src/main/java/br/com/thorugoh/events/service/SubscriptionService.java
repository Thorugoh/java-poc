package br.com.thorugoh.events.service;

import br.com.thorugoh.events.dto.SubscriptionRakingByUser;
import br.com.thorugoh.events.dto.SubscriptionRankingItem;
import br.com.thorugoh.events.dto.SubscriptionResponse;
import br.com.thorugoh.events.exception.EventNotFoundException;
import br.com.thorugoh.events.exception.SubscriptionConflictException;
import br.com.thorugoh.events.exception.UserIndicatorNotFoundException;
import br.com.thorugoh.events.model.Event;
import br.com.thorugoh.events.model.Subscription;
import br.com.thorugoh.events.model.User;
import br.com.thorugoh.events.repository.EventRepo;
import br.com.thorugoh.events.repository.SubscriptionRepo;
import br.com.thorugoh.events.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class SubscriptionService {
    @Autowired
    private EventRepo evtRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private SubscriptionRepo subRepo;

    public SubscriptionResponse createNewSubscription(String eventName, User user, Integer userId){
        // get event by name
        Event evt = evtRepo.findByPrettyName(eventName);
        if(evt == null ) {
            throw  new EventNotFoundException("Event " + eventName + " does not exists");
        }

        User userRec = userRepo.findByEmail(user.getEmail());
        if(userRec == null) {
            userRec = userRepo.save(user);
        }

        User indicator = null;
        if(userId != null){
            indicator = userRepo.findById(userId).orElse(null);
            if(indicator == null){
                throw new UserIndicatorNotFoundException("User indicator does not exist");
            }
        }

        Subscription subs = new Subscription();
        subs.setEvent(evt);
        subs.setSubscriber(userRec);
        subs.setIndication(indicator);

        Subscription tmpSub = subRepo.findByEventAndSubscriber(evt, userRec);
        if(tmpSub != null){
            throw new SubscriptionConflictException("There is already a subscription for user " + userRec.getName() + " on event " + evt.getTitle());
        }

        Subscription res = subRepo.save(subs);
        return new SubscriptionResponse(res.getSubscriptionNumber(), "https://codecraft.com/"+res.getEvent().getPrettyName()+"/"+res.getSubscriber().getId());
    }

    public List<SubscriptionRankingItem> getCompleteRanking(String prettyName){
        Event evt = evtRepo.findByPrettyName(prettyName);
        if(evt == null) {
            throw new EventNotFoundException("Event ranking does not exist");
        }

        return subRepo.generateRanking(evt.getEventId());
    }

    public SubscriptionRakingByUser getRankingByUser(String prettyName, Integer userId) {
        List<SubscriptionRankingItem> ranking = getCompleteRanking(prettyName);

        SubscriptionRankingItem item = ranking.stream().filter(i -> i.userId()
                .equals(userId)).findFirst().orElse(null);
        if(item == null) {
            throw new UserIndicatorNotFoundException("There is no subscription under this user");
        }
        Integer position = IntStream.range(0, ranking.size())
                .filter(pos -> ranking.get(pos).userId().equals(userId))
                .findFirst().getAsInt();

        return new SubscriptionRakingByUser(item, position + 1);
    }



}
