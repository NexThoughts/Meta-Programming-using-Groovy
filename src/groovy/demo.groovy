/**
 * Created by ali on 28/7/16.
 */

// INTERCEPTION THROUGH META CLASS DEMO
class InterceptionThroughMetaClassDemo {
    void sayHello(String name) {
        println "========> Hello $name"
    }
}

InterceptionThroughMetaClassDemo.metaClass.invokeMethod = { String methodName, Object args ->
    println("Invoking method '$methodName' with args '$args'")
    def method = InterceptionThroughMetaClassDemo.metaClass.getMetaMethod(methodName, args)
    method?.invoke(delegate, args)
}
def demo = new InterceptionThroughMetaClassDemo()
demo.sayHello("ALI")
demo.sayHI("EVERYONE")
demo.anotherMethod()
