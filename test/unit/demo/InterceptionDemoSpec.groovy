package demo

import spock.lang.Specification

/**
 * Created by ali on 28/7/16.
 */
class InterceptionDemoSpec extends Specification {
    void 'test for inteceptionDemo definedMethod'() {
        given:
        def interceptionDemo = new InterceptionDemo()

        when:
        interceptionDemo.definedMethod()
        then:
        assert interceptionDemo.definedMethod() == 'definedMethod invokedMethod'
    }

    void 'test for inteceptionDemo notDefinedMethods'() {
        given:
        def interceptionDemo = new InterceptionDemo()

        when:
        interceptionDemo.abcMethod()
        interceptionDemo.testMethod()
        interceptionDemo.someMethod()
        then:
        assert interceptionDemo.abcMethod() == 'abcMethod invokedMethod'
        assert interceptionDemo.testMethod() == 'testMethod invokedMethod'
        assert interceptionDemo.someMethod() == 'someMethod invokedMethod'
    }
}
