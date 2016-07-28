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
class Utils {
}

def utilsInstance = new Utils()

Utils.metaClass.version = "3.0"
utilsInstance.metaClass.released = true

assert utilsInstance.version == "3.0"
assert utilsInstance.released == true
println("utilsInstance.version: $utilsInstance.version")
println("utilsInstance.released: $utilsInstance.released")
