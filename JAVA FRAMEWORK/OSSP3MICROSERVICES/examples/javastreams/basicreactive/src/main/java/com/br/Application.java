package com.br;

import com.br.publisher.WaiterPublisher;
import com.br.subscriber.ChefSubscriber;

public class Application {
    public static void main(String[] args) {
        ChefSubscriber subscriber = new ChefSubscriber();

        WaiterPublisher publisher = new WaiterPublisher();
        publisher.receive("chicken biryani");
        publisher.receive("chilli mushroom");
        publisher.receive("Vegetarian Thali");
        publisher.receive("Egg Biryani");
        publisher.receive("Apricat Delight");
        publisher.receive("Soya Chaap");


        publisher.subscribe(subscriber);
        subscriber.accept();
    }
}
