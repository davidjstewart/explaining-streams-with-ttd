package com.example.streams.demo.services


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class DummyServiceTest extends Specification {

    @Autowired
    DummyService dummyService

    def "context loads"() {
        expect:
        dummyService
    }
}
