package demo

import groovy.xml.Entity

/**
 * Created by ali on 28/7/16.
 */
class InterceptionThroughMetaClassDemo {
    void sayHello(String name) {
        println "========> Hello $name"
    }
}
