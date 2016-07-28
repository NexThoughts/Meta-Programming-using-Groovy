package demo

import spock.lang.Specification

/**
 * Created by ali on 28/7/16.
 */
class InvokeMethodDemoSpec extends Specification {
    void 'test for test method'() {
        given:
        def invokeMethodDemo = new InvokeMethodDemo()

        when:
        invokeMethodDemo.test()

        then:
//        'method exists' == invokeMethodDemo.test()
        assert invokeMethodDemo.test() == 'method exists'

    }

    void 'test for invoke method'() {
        given:
        def invokeMethodDemo = new InvokeMethodDemo()

        when:
        invokeMethodDemo.hello()

        then:
//        'called invokeMethod hello []' == invokeMethodDemo.hello()
        assert invokeMethodDemo.hello() == 'called invokeMethod hello []'
    }
}
