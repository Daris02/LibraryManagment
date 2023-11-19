package com.prog.services;

import java.util.List;
import java.util.UUID;

import com.prog.model.Subscriber;
import com.prog.repository.SubscriberCrudOperations;

public class SubscriberService {
    private SubscriberCrudOperations subscriberCrudOp = new SubscriberCrudOperations();
    
    public Subscriber getSubscriberById(String id) {
        return subscriberCrudOp.getById(id);
    }

    public List<Subscriber> getAllSubscribers() {
        return subscriberCrudOp.findAll();
    }

    public Subscriber saveSubscriber(Subscriber subscriber) {
        subscriber.setId(UUID.randomUUID().toString());

        return subscriberCrudOp.save(subscriber);
    }

    public List<Subscriber> saveAllSubscribers(List<Subscriber> subscribers) {
        for (Subscriber subscriber : subscribers) {
            subscriber.setId(UUID.randomUUID().toString());
        }

        return subscriberCrudOp.saveAll(subscribers);
    }

    public Subscriber deleSubscriber(Subscriber subscriber) {
        Subscriber toDelete = getSubscriberById(subscriber.getId());
        if (toDelete == null) {
            System.out.println("Subscriber not exist");
            return null;
        }
        return subscriberCrudOp.delete(subscriber);
    }
    
}
