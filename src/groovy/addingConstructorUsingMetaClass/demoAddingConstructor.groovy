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