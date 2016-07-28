package demo

/**
 * Created by ali on 28/7/16.
 */
class InvokeMethodDemo {
    def invokeMethod(String name, Object args) {
        return "called invokeMethod $name $args"
    }

    def test() {
        return 'method exists'
    }

    def adas() {
        def invokeMethodDemo = new InvokeMethodDemo()
        assert invokeMethodDemo.test() == 'method exists'
        assert invokeMethodDemo.hello() == 'called invokeMethod hello []'
    }
}
