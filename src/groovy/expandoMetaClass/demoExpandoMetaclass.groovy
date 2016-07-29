package expandoMetaClass

/**
 * Created by ali on 30/7/16.
 */
//=============================================
// Adding/Injecting Methods Using ExpandoMetaClass
//=============================================
Integer.metaClass.getDaysFromNow = { ->
    Calendar today = Calendar.instance
    today.add(Calendar.DAY_OF_MONTH, delegate)
    today.time
}
println 1.daysFromNow

//=============================================
// Adding Static Method Using ExpandoMetaClass
//=============================================
/*
Integer.metaClass.'static'.isEven = { val -> val % 2 == 0 }
println "Is 2 even? " + Integer.isEven(2)
println "Is 3 even? " + Integer.isEven(3)*/

//=============================================
// Using ExpandoMetaClassDSL
//=============================================
/*
Integer.metaClass {
    daysFromNow = { ->
        Calendar today = Calendar.instance
        today.add(Calendar.DAY_OF_MONTH, delegate)
        today.time
    }
    getDaysFromNow = { ->
        Calendar today = Calendar.instance
        today.add(Calendar.DAY_OF_MONTH, delegate)
        today.time
    }
    'static' {
        isEven = { val -> val % 2 == 0 }
    }
    constructor = { Calendar calendar ->
        new Integer(calendar.get(Calendar.DAY_OF_MONTH))
    }
    constructor = { int val ->
        println "Intercepting constructor call"
        constructor = Integer.class.getConstructor(Integer.TYPE)
        constructor.newInstance(val)
    }
}
println 1.daysFromNow()
println 5.daysFromNow
println "Is 2 even? " + Integer.isEven(2)
println "Is 3 even? " + Integer.isEven(3)
println("${new Integer(5)}")
println("${new Integer(Calendar.instance)}")*/
