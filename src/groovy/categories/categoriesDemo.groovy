package categories

/**
 * Created by ali on 29/7/16.
 */
//=============================================
// Categories
//=============================================
class StringUtils {
    static String truncate(String text, Integer length, Boolean overflow = false) {
        text.take(length) + (overflow ? '...' : '')
    }
}

use(StringUtils) {
    println "Hello! Everyone.".truncate(5)
}
try {
    println "Hi! Ali.".truncate(5)
} catch (MissingMethodException mme) {
    println mme
}

/*class Distance {
    def number

    String toString() {
        println("==========> ${number}")
        "${number}"
    }
}

@Category(Number)
class NumberCategory {
    Distance getMeters() {
        new Distance(number: this + 'm')
    }

    Distance getKiloMeters() {
        new Distance(number: this + 'km')
    }
}

use(NumberCategory) {
    assert 10.kiloMeters.toString() == '10km'
    assert 50.meters.toString() == '50m'
}*/

/*
class FileBinaryCategory {
    def static leftShift(File file, URL url) {
        def input
        def output

        try {
            input = url.openStream()
            output = new BufferedOutputStream(new FileOutputStream(file))
            output << input
        }
        finally {
            input?.close()
            output?.close()
        }
    }
}

File tmpFile = File.createTempFile('temp_', '')
use(FileBinaryCategory) {
    tmpFile << "https://en.wikipedia.org/wiki/Groovy_(programming_language)#/media/File:Groovy-logo.svg".toURL()
}
println(tmpFile)*/