package com.br.subscription;

import com.br.common.OrderQueue;

import java.util.concurrent.Flow;

public class WaiterChefSubscription implements Flow.Subscription {
    private Flow.Subscriber<String> subscriber;
    private boolean cancel;

    public WaiterChefSubscription(Flow.Subscriber<String> subscriber) {
        this.subscriber = subscriber;
        cancel = false;
    }

    @Override
    public void request(long n) {
        int i = 0;
        while (i < n && OrderQueue.getInstance().hasItems() == true && cancel == false) {
            subscriber.onNext(OrderQueue.getInstance().enqueue());
        }
        if (OrderQueue.getInstance().hasItems() == false) {
            subscriber.onComplete();
        }
    }

    @Override
    public void cancel() {
        cancel = true;
    }
}
