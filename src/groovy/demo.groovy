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
// Adding Constructor Using MetaClass
//=============================================
try {
    println(new Integer(Calendar.instance))
}
catch (e) {
}

Integer.metaClass.constructor << { Calendar calendar ->
    new Integer(calendar.get(Calendar.DATE))
}
println("Today's Date: ${new Integer(Calendar.instance)}")

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
// Categories
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

/*class Distance {
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
}*/

/*
class FileBinaryCategory {
    def static leftShift(File file, URL url) {
        def input
        def output

        try {
            input = url.openStream()
            output = new BufferedOutputStream(new FileOutputStream(file))
            output << input
        }
        finally {
            input?.close()
            output?.close()
        }
    }
}

File tmpFile = File.createTempFile('temp_', '')
use(FileBinaryCategory) {
    tmpFile << "https://en.wikipedia.org/wiki/Groovy_(programming_language)#/media/File:Groovy-logo.svg".toURL()
}
println(tmpFile)*/

//=============================================
// Mixins
//=============================================
/*class SpidermanPower {
    String spiderSense() {
        "Using spider-sense..."
    }
}

class SupermanPower {
    String fly() {
        "Flying..."
    }
}

@Mixin([SpidermanPower])
class Person {}

def person = new Person()
assert person.spiderSense() == "Using spider-sense..."

println("=====> person.spiderSense(): ${person.spiderSense()}")
assert !(person instanceof SpidermanPower)
println("=====> !(person instanceof SpidermanPower): ${!(person instanceof SpidermanPower)}")

Person.mixin SupermanPower

assert person.fly() == "Flying..."
println("=====> person.fly(): ${person.fly()}")

assert !(person instanceof SupermanPower)
println("=====> !(person instanceof SupermanPower): ${!(person instanceof SupermanPower)}")*/

//=============================================
// Traits
//=============================================
/*trait SpidermanPower {
    String spiderSense() {
        "Using spider-sense..."
    }
}

trait SupermanPower {
    String fly() {
        "Flying..."
    }
}

class Person implements SpidermanPower {}

def person = new Person()
assert person.spiderSense() == "Using spider-sense..."
println("=====> person.spiderSense(): ${person.spiderSense()}")
assert person instanceof SpidermanPower
def person2 = person.withTraits SupermanPower
assert person2.fly() == "Flying..."
println("=====> person2.fly(): ${person2.fly()}")
assert person2 instanceof SupermanPower*/

//=============================================
// Check for Methods and Properties
//=============================================
/*
class Person {
    String name
    Integer age

    String sayHi() {
        "Hi, my name is ${name} and I'm ${age}"
    }

    String sayHiTo(String name) {
        "Hi ${name}, how are you?"
    }
}

def p = new Person(name: 'Iván', age: 34)

assert p.respondsTo('sayHi')
assert p.respondsTo('sayHiTo', String)
assert !p.respondsTo('goodbye')

assert p.hasProperty('name')
assert !p.hasProperty('country')*/
