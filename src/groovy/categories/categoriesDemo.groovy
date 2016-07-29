package categories

/**
 * Created by ali on 29/7/16.
 */
//=============================================
// Categories
//=============================================

// ****** EXAMPLE 1 ******
/*class StringUtils {
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
}*/

// ****** EXAMPLE 2 ******
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

// ****** EXAMPLE 3 ******
/*@Category(String)
class StringUtilAnnotated {
    def toSSN() {
        if (size() == 9) {
            "${this[0..2]}-${this[3..4]}-${this[5..8]}"
        }
    }
}

use(StringUtilAnnotated) {
    println "123456789".toSSN()
    println "12345".toSSN()
}*/

// ****** EXAMPLE 4 ******
/*class FindUtil {
    def static extractOnly(String self, closure) {
        def result = ''
        self.each {
            if (closure(it)) {
                result += it
            }
        }
        result
    }
}

use(FindUtil) {
    println "121254123".extractOnly { it == '4' || it == '5' }
}*/

// ****** EXAMPLE 5 ******
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