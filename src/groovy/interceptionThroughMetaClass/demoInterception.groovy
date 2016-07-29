package interceptionThroughMetaClass
/**
 * Created by ali on 28/7/16.
 */

//=============================================
// INTERCEPTION THROUGH META CLASS DEMO
//=============================================
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
def demoAddingMethods = new InterceptionThroughMetaClassDemo()
demoAddingMethods.sayHello("ALI")
demoAddingMethods.sayHI("EVERYONE")
demoAddingMethods.anotherMethod()

/*
Integer.metaClass.invokeMethod = { String name, args ->
    System.out.println("Call to $name intercepted on $delegate... ")
    def validMethod = Integer.metaClass.getMetaMethod(name, args)
    if (validMethod == null) {
        Integer.metaClass.invokeMissingMethod(delegate, name, args)
    } else {
        System.out.println("running pre-filter... ")
        result = validMethod.invoke(delegate, args) // Remove this for around-advice
        System.out.println("running post-filter... ")
        result
    }
}
println 5.floatValue()
println 6.intValue()
try {
    println 7.empty()
} catch (Exception ex) {
    println ex
}*/
