package addingConstructorUsingMetaClass

/**
 * Created by ali on 29/7/16.
 */
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
// Adding Static Method Using ExpandoMetaClass
//=============================================
/*
Integer.metaClass.'static'.isEven = { val -> val % 2 == 0 }
println "Is 2 even? " + Integer.isEven(2)
println "Is 3 even? " + Integer.isEven(3)*/
