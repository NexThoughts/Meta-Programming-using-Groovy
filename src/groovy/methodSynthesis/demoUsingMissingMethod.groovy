package methodSynthesis

/**
 * Created by ali on 30/7/16.
 */
//******* Example 1 ********
class Person {
    def work() { "working..." }
    def plays = ['Tennis', 'VolleyBall', 'BasketBall']

    def methodMissing(String name, args) {
        System.out.println "methodMissing called for $name"
        def methodInList = plays.find { it == name.split('play')[1] }
        if (methodInList) {
            "playing ${name.split('play')[1]}..."
        } else {
            throw new MissingMethodException(name, Person.class, args)
        }
    }

    /*def methodMissing(String name, args) {
        System.out.println "methodMissing called for $name"
        def methodInList = plays.find { it == name.split('play')[1] }
        if (methodInList) {
            def impl = { Object[] vargs ->
                "playing ${name.split('play')[1]}..."
            }
            Person instance = this
            instance.metaClass."$name" = impl //future calls will use this
            impl(args)
        } else {
            throw new MissingMethodException(name, Person.class, args)
        }
    }*/
}

jack = new Person()
println jack.work()
println jack.playTennis()
println jack.playBasketBall()
println jack.playVolleyBall()
println jack.playTennis()

try {
    jack.playPolitics()
} catch (Exception ex) {
    println "Error: " + ex
}