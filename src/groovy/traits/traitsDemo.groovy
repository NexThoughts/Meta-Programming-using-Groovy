package traits

/**
 * Created by ali on 29/7/16.
 */
//=============================================
// Traits
//=============================================
trait SpidermanPower {
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
assert person2 instanceof SupermanPower