package overridingMethodsUsingMetaClass

/**
 * Created by ali on 29/7/16.
 */
//=============================================
// Overriding Methods Using MetaClass
//=============================================
// Integer
assert '15' == 15.toString()
Integer.metaClass.toString = {
    delegate == 15 ?
            'The answer to life, the universe and everything' :
            String.valueOf(delegate)
}
assert 15.toString() == 'The answer to life, the universe and everything'
assert 100.toString() == '100'
println("15.toString(): ${15.toString()}")
println("100.toString(): ${100.toString()}")

// Boolean
assert false.toBoolean() == false
Boolean.metaClass.toBoolean = { !delegate }
assert false.toBoolean() == true
println("false.toBoolean(): ${false.toBoolean()}")