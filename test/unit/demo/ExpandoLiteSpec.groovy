package demo

import spock.lang.Specification

/**
 * Created by ali on 25/7/16.
 */
class ExpandoLiteSpec extends Specification {

    void 'test property access'() {
        given:
        def ex = new ExpandoLite()

        when:
        ex.companyName = 'Nexthoughts'

        then:
        'Nexthoughts' == ex.companyName
    }

    void 'test method invocation'() {
        given:
        def ex = new ExpandoLite()

        when:
        ex.addNumbers = { a, b, c ->
            return a + b + c
        }

        then:
        ex.addNumbers(6, 4, 5) == 15
    }
}
