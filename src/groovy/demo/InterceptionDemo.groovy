package demo

/**
 * Created by ali on 28/7/16.
 */
class InterceptionDemo implements GroovyInterceptable {
    def definedMethod() {}

    def invokeMethod(String name, Object args) {
        "$name invokedMethod"
    }
}
