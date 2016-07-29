package demo

/**
 * Created by ali on 29/7/16.
 */
class ClosureDemo {
    void append(String arg) {
        println("append called with: ${arg}")
    }

    void doit() {
        def cl = {
            append 'MetaProgramming Demo by'
            append ' Ali and Gaurav'
        }
//        cl.resolveStrategy = Closure.OWNER_FIRST
//        cl.resolveStrategy = Closure.DELEGATE_FIRST
//        cl.resolveStrategy = Closure.OWNER_ONLY
//        cl.resolveStrategy = Closure.DELEGATE_ONLY
        def sb = new StringBuffer()
        cl.delegate = sb
        cl()
        println("SB: ${sb}")
    }

    static void main(args) {
        new ClosureDemo().doit()
    }
}
