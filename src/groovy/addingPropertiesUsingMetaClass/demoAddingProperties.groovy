package addingPropertiesUsingMetaClass

/**
 * Created by ali on 29/7/16.
 */
//=============================================
// Adding Properties Using MetaClass
//=============================================
class Utils {
}

def utilsInstance = new Utils()

Utils.metaClass.version = "3.0"
utilsInstance.metaClass.released = true

assert utilsInstance.version == "3.0"
assert utilsInstance.released == true
println("utilsInstance.version: $utilsInstance.version")
println("utilsInstance.released: $utilsInstance.released")