/**
 * Created by ali on 28/7/16.
 */

//=============================================
// INTERCEPTION THROUGH META CLASS DEMO
//=============================================
/*class InterceptionThroughMetaClassDemo {
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
demo.anotherMethod()*/

//=============================================
// Adding Methods Using MetaClass
//=============================================
/*class StringUtils {
    static String truncate(String text, Integer length, Boolean overflow = false) {
        text.take(length) + (overflow ? '...' : '')
    }
}

String chuckIpsum = "If you can see Chuck Norris, he can see you.\
If you can not see Chuck Norris you may be only seconds away from death"
println StringUtils.truncate(chuckIpsum, 72)
println StringUtils.truncate(chuckIpsum, 72, true)

String.metaClass.truncateDemo = { Integer length, Boolean overflow = false ->
    println "truncate string upto length $length"
    delegate.take(length) + (overflow ? '...' : '')
}
assert chuckIpsum.truncateDemo(20, true) == StringUtils.truncate(chuckIpsum, 20, true)
println(chuckIpsum.truncateDemo(20, true))*/

//=============================================
// Adding Properties Using MetaClass
//=============================================
/*class Utils {
}

def utilsInstance = new Utils()

Utils.metaClass.version = "3.0"
utilsInstance.metaClass.released = true

assert utilsInstance.version == "3.0"
assert utilsInstance.released == true
println("utilsInstance.version: $utilsInstance.version")
println("utilsInstance.released: $utilsInstance.released")*/

//=============================================
// Overriding Methods Using MetaClass
//=============================================
/*// Integer
assert '15' == 15.toString()
Integer.metaClass.toString = {
    delegate == 15 ?
            'The answer to life, the universe and everything' :
            String.valueOf(delegate)
}
assert 15.toString() == 'The answer to life, the universe and everything'
assert 100.toString() == '100'
println("15.toString(): ${15.toString()}")
println("100.toString(): ${100.toString()}")

// Boolean
assert false.toBoolean() == false
Boolean.metaClass.toBoolean = { !delegate }
assert false.toBoolean() == true
println("false.toBoolean(): ${false.toBoolean()}")*/

//=============================================
// Overriding Methods Using MetaClass
//=============================================
/*class StringUtils {
    static String truncate(String text, Integer length, Boolean overflow = false) {
        text.take(length) + (overflow ? '...' : '')
    }
}

use(StringUtils) {
    println "Hello! Everyone.".truncate(5)
}
try {
    println "Hi! Ali.".truncate(5)
} catch (MissingMethodException mme) {
    println mme
}*/

class Distance {
    def number

    String toString() {
        println("==========> ${number}")
        "${number}"
    }
}

@Category(Number)
class NumberCategory {
    Distance getMeters() {
        new Distance(number: this + 'm')
    }

    Distance getKiloMeters() {
        new Distance(number: this + 'km')
    }
}

use(NumberCategory) {
    assert 10.kiloMeters.toString() == '10km'
    assert 50.meters.toString() == '50m'
}
