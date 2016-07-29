package interceptionThroughMetaClass
/**
 * Created by ali on 28/7/16.
 */

//=============================================
// INTERCEPTION THROUGH META CLASS DEMO
//=============================================
//*********** Example 1 *************
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

//*********** Example 2 *************
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

//*********** Example 3 *************
/*
class Car {
    def check() { System.out.println "check called..." }

    def start() { System.out.println "start called..." }

    def drive() { System.out.println "drive called..." }
}

Car.metaClass.invokeMethod = { String name, args ->
    System.out.print("Call to $name intercepted... ")
    if (name != 'check') {
        System.out.print("running filter... ")
        Car.metaClass.getMetaMethod('check').invoke(delegate, null)
    }
    def validMethod = Car.metaClass.getMetaMethod(name, args)
    if (validMethod != null) {
        validMethod.invoke(delegate, args)
    } else {
        Car.metaClass.invokeMissingMethod(delegate, name, args)
    }
}
car = new Car()
car.start()
car.drive()
car.check()*/
