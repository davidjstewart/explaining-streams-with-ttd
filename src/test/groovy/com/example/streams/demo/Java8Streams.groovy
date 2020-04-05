package com.example.streams.demo

import spock.lang.Specification

import java.util.stream.Stream

class Java8Streams extends Specification {

    def "given a chain of intermediate operations then each item is worked fully through the chain in turn"() {
        def list = [1, 2, 3, 4] //size seems irrelevant to final output

        when:
        Stream<List> intermediateStream = list.stream().map({ item ->
            println item
            return item.toString() + " apples"
        }).map({ item ->
            println item
            return item.toString() + " and bananas"
        })

        then:
        intermediateStream.forEach({ item ->
            println item
        })
        //output "what the heck???" lol. Streams be spooky!!!
        //1
        //1 apples
        //1 apples and bananas
        //2
        //2 apples
        //2 apples and bananas
        //3
        //3 apples
        //3 apples and bananas
        //4
        //4 apples
        //4 apples and bananas
    }

    def "given parallel stream then output appears chaotic"() {
        def list = []
        for (int i = 0; i < 1000; i++) list[i] = i

        when:
        Stream<List> intermediateStream = list.parallelStream().map({ item ->
            println item
            return item.toString() + " apples"
        }).map({ item ->
            println item
            return item.toString() + " and bananas"
        })

        then:
        intermediateStream.forEach({ item ->
            println item
        })
    }

    def "given a chained stream then lazy evaluation is used"() {
        println "\nsetup"
        def list = [1, 2]

        when:
        println "start streaming"
        Stream<List> firstIntermediateOperationResult = list.stream().map({ item ->
            println item
            return item.toString() + " apples"
        })

        println "you expected some apples"
        Stream<List> secondIntermediateOperationResult = firstIntermediateOperationResult.map({ item ->
            println item
            return item.toString() + " and bananas"
        })

        then:
        println "you definitely expected some bananas"
        secondIntermediateOperationResult.forEach({ item ->
            println item
        })
        println "i'm last. you guessed this one right. "
        println "because i am not and never will be a JavaScript promise (i.e. non-blocking)"
        println "i just don't run intermediate operations until I see my terminal operation"
        println "side note - remember this when you are considering mixing parent state in my operations, " +
                "i should be functionally pure\n"
    }

    def "given a chained stream when you try to duplicate streams use you'll get an IllegalStateException"() {
        def list = [1, 2]

        when:
        Stream<List> firstIntermediateOperationResult = list.stream().map({ item ->
            println item
            return item.toString() + " apples"
        })
        Stream<List> expectedChaining = firstIntermediateOperationResult.map({ item ->
            println item
            return item.toString() + " and bananas"
        })
        Stream<List> sneakySecondAttemptToChainSameOperation = firstIntermediateOperationResult.map({ item ->
            println item
            return item.toString() + " and carrots"
        })

        then:
        thrown IllegalStateException
    }
}
