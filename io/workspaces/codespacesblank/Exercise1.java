package io.workspaces.codespacesblank;

import java.io.StringWriter;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream

        StreamSources.intNumbersStream().forEach((e) -> System.out.println(e));

        // method reference..
        // StreamSources.intNumbersStream().forEach(System.out::println);

        // Print numbers from intNumbersStream that are less than 5

        StreamSources.intNumbersStream().filter((e) -> e < 5).forEach(System.out::println);

        // Print the second and third numbers in intNumbersStream that's greater than 5

        StreamSources.intNumbersStream().filter(e -> e > 5)
                .skip(0)
                .limit(2)
                .forEach(System.out::println);

        // Print the first number in intNumbersStream that's greater than 5.
        // If nothing is found, print -1

        Integer value = StreamSources.intNumbersStream().filter(e -> e > 5).findFirst().orElse(-1);
        System.out.println(value);

        // Print first names of all users in userStream
        StreamSources.userStream().map(user -> user.getFirstName()).forEach(u -> System.out.println(u));

        // Print first names in userStream for users that have IDs from number stream

        StreamSources.intNumbersStream()
                .flatMap(num -> StreamSources.userStream().filter(user -> user.getId() == num))
                .map(u -> u.getFirstName())
                .forEach(System.out::println);
        ;
        ;

    }
}