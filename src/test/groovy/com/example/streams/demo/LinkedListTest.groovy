package com.example.streams.demo

import spock.lang.Specification

class LinkedListTest extends Specification {
    def "add items to linkedlist"() {
        setup:
        LinkedList list = new LinkedList()

        when:
        list.insert(1)
        list.insert(2)
        list.insert(3)

        then:
        list.get(position) == result

        where:
        position | result
        0        | 1
        1        | 2
        2        | 3
    }
}
