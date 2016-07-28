package demo

/**
 * Created by ali on 25/7/16.
 */
class ExpandoLite {

    protected dynamicPropMap = [:]

    void setProperty(String propName, val) {
        dynamicPropMap[propName] = val
    }

    def getProperty(String propName) {
        dynamicPropMap[propName]
    }

    def methodMissing(String methodName, args) {
        def prop = dynamicPropMap[methodName]
        if (prop instanceof Closure) {
            return prop(*args)
        }
    }
}
