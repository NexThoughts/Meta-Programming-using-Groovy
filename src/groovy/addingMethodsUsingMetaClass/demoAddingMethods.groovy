package addingMethodsUsingMetaClass

/**
 * Created by ali on 29/7/16.
 */
//=============================================
// Adding Methods Using MetaClass
//=============================================
class StringUtils {
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
println(chuckIpsum.truncateDemo(20, true))

//=============================================
// Adding/Injecting Methods Using ExpandoMetaClass
//=============================================
/*
Integer.metaClass.getDaysFromNow = { ->
    Calendar today = Calendar.instance
    today.add(Calendar.DAY_OF_MONTH, delegate)
    today.time
}
println 1.daysFromNow*/
