package br.com.thorugoh.events.controller;

import br.com.thorugoh.events.dto.ErrorMessage;
import br.com.thorugoh.events.dto.SubscriptionResponse;
import br.com.thorugoh.events.exception.EventNotFoundException;
import br.com.thorugoh.events.exception.SubscriptionConflictException;
import br.com.thorugoh.events.model.Subscription;
import br.com.thorugoh.events.model.User;
import br.com.thorugoh.events.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscriptionController {
    @Autowired
    private SubscriptionService service;

    @PostMapping("/subscription/{prettyName}")
    public ResponseEntity<?> createSubscription(@PathVariable String prettyName, @RequestBody User subscriber){
        try {

            SubscriptionResponse res = service.createNewSubscription(prettyName, subscriber);
            if(res != null){
                return ResponseEntity.ok(res);
            }
        }catch (EventNotFoundException ex) {
            return ResponseEntity.status(404).body(new ErrorMessage(ex.getMessage()));
        }catch (SubscriptionConflictException ex) {
            return ResponseEntity.status(409).body(new ErrorMessage(ex.getMessage()));
        }
        return ResponseEntity.badRequest().build();
    }

}
