package br.com.thorugoh.events.controller;

import br.com.thorugoh.events.dto.ErrorMessage;
import br.com.thorugoh.events.dto.SubscriptionResponse;
import br.com.thorugoh.events.exception.EventNotFoundException;
import br.com.thorugoh.events.exception.SubscriptionConflictException;
import br.com.thorugoh.events.exception.UserIndicatorNotFoundException;
import br.com.thorugoh.events.model.Event;
import br.com.thorugoh.events.model.Subscription;
import br.com.thorugoh.events.model.User;
import br.com.thorugoh.events.service.SubscriptionService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SubscriptionController {
    @Autowired
    private SubscriptionService service;

    @PostMapping({"/subscription/{prettyName}", "/subscription/{prettyName}/{userId}"})
    public ResponseEntity<?> createSubscription(@PathVariable String prettyName,
                                                @RequestBody User subscriber,
                                                @PathVariable(required = false) Integer userId){
        try {

            SubscriptionResponse res = service.createNewSubscription(prettyName, subscriber, userId);
            if(res != null){
                return ResponseEntity.ok(res);
            }
        }catch (EventNotFoundException | UserIndicatorNotFoundException ex) {
            return ResponseEntity.status(404).body(new ErrorMessage(ex.getMessage()));
        }catch (SubscriptionConflictException ex) {
            return ResponseEntity.status(409).body(new ErrorMessage(ex.getMessage()));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/subscription/{prettyName}/ranking")
    public ResponseEntity<?> generateRankingByEvent(@PathVariable String prettyName) {
        try {
            return ResponseEntity.ok(service.getCompleteRanking(prettyName).subList(0, 3));
        }catch (EventNotFoundException ex){
            return ResponseEntity.status(404).body(new ErrorMessage(ex.getMessage()));
        }
    }

    @GetMapping("/subscription/{prettyName}/ranking/{userId}")
    public ResponseEntity<?> generateRankingByEventAndUser(@PathVariable String prettyName, @PathVariable Integer userId){
        try {
            return ResponseEntity.ok(service.getRankingByUser(prettyName, userId));
        }catch(Exception ex) {
            return ResponseEntity.status(404).body(new ErrorMessage(ex.getMessage()));
        }
    }

}
