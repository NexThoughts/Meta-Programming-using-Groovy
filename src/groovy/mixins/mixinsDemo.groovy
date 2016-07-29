package mixins

/**
 * Created by ali on 29/7/16.
 */
//=============================================
// Mixins
//=============================================
class SpidermanPower {
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
println("=====> !(person instanceof SupermanPower): ${!(person instanceof SupermanPower)}")