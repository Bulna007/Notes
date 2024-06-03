package com.wb.flux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FluxTest {
    public static void main(String[] args) {
        //createBasicFlux();
        //createFromArrayFlux();
        //createFromIteratableFlux();
        //createFromStreamFlux();
        //map();
        //flatMap();
        distinct();
    }

    private static void createBasicFlux() {
        Flux<String> stringFlux = Flux.just("item1", "item2", "item3");
        stringFlux.subscribe(item -> {
            System.out.println(item);
        });
    }

    private static void createFromArrayFlux() {
        Flux<String> stringFlux = Flux.fromArray(new String[]{"arrayitem1", "arrayitem2", "arrayitem3"});
        stringFlux.subscribe(item -> {
            System.out.println(item);
        });
    }

    private static void createFromIteratableFlux() {
        List<String> l = Arrays.asList(new String[]{"listitem1", "listitem2", "listitem3"});
        Flux<String> stringFlux = Flux.fromIterable(l);

        stringFlux.log().subscribe(litem -> {
            System.out.println(litem);
        });
    }

    private static void createFromStreamFlux() {
        Stream<Integer> integerStream = List.of(10, 20, 30, 40, 50, 60).stream();
        Flux<Integer> integerFlux = Flux.fromStream(integerStream);
        integerFlux.subscribe(integer -> {
            System.out.println(integer);
        });
    }

    private static void map() {
        Stream<Integer> integerStream = List.of(10, 20, 30, 40, 50).stream();
        Flux<Integer> integerFlux = Flux.fromStream(integerStream);

        Flux<Integer> mapIntegerFlux = integerFlux.map(n -> n * 10);
        mapIntegerFlux.subscribe(System.out::println);
    }

    private static void flatMap() {
        final Integer[][] numbers = new Integer[][]{{10, 20}, {30, 40}, {50, 60}};
        Flux<Integer> indexFlux = Flux.just(0, 1, 2);

        Mono<Integer> monoSum = indexFlux.flatMap(index -> {
            return Flux.fromArray(numbers[index]);
        }).reduce(0, (total, n) -> {
                    total = total + n;
                    return total;

                }
        );
        monoSum.subscribe(System.out::println);
    }

    private static void distinct() {
        Stream<Integer> integerStream = List.of(20, 22, 8, 6, 5, 11, 22, 20, 11).stream();
        Flux<Integer> integerFlux = Flux.fromStream(integerStream);

        integerFlux.distinct().sort().filter(n -> n % 2 == 0).subscribe(System.out::println);
    }

}









