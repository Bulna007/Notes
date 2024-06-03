package com.br.publisher;

import com.br.common.OrderQueue;
import com.br.subscription.WaiterChefSubscription;

import java.util.concurrent.Flow;

public class WaiterPublisher implements Flow.Publisher {

    @Override
    public void subscribe(Flow.Subscriber subscriber) {
        subscriber.onSubscribe(new WaiterChefSubscription(subscriber));
    }

    public void receive(String item) {
        OrderQueue.getInstance().add(item);
    }
}
