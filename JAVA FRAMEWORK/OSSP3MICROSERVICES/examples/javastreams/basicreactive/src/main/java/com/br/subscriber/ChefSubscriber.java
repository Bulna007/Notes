package com.br.subscriber;

import java.util.concurrent.Flow;

public class ChefSubscriber implements Flow.Subscriber<String> {
    private Flow.Subscription subscription;
    private boolean busy;
    private final int max_items = 5;
    private int n_items;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        this.busy = false;
        this.n_items = 0;
    }

    @Override
    public void onNext(String item) {
        try {
            busy = true;
            System.out.println("received the item: " + item);
            System.out.println("preparing the food...");
            // business logic
            Thread.sleep(1000L);
            System.out.println("prepared!");
            busy = false;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("error while preparing the food : " + throwable.getMessage());
        busy = false;
    }

    @Override
    public void onComplete() {
        System.out.println("Good bye!");
    }

    public void accept() {
        while (n_items < max_items) {
            if (!busy) {
                subscription.request(1);
                n_items++;
            }
        }
    }
}












