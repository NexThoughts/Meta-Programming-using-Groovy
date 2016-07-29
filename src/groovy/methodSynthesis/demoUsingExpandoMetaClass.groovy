package methodSynthesis

/**
 * Created by ali on 30/7/16.
 */
class User {
    def work() { "working..." }
}

User.metaClass.methodMissing = { String name, args ->
    def plays = ['Tennis', 'VolleyBall', 'BasketBall']
    System.out.println "methodMissing called for $name"
    def methodInList = plays.find { it == name.split('play')[1] }
    if (methodInList) {
        def impl = { Object[] vargs ->
            "playing ${name.split('play')[1]}..."
        }
        User.metaClass."$name" = impl //future calls will use this
        impl(args)
    } else {
        throw new MissingMethodException(name, User.class, args)
    }
}
jack = new User()
println jack.work()
println jack.playTennis()
println jack.playTennis()
println jack.playBasketBall()
println jack.playVolleyBall()
println jack.playTennis()
println jack.playBasketBall()

try {
    jack.playPolitics()
} catch (ex) {
    println ex
}