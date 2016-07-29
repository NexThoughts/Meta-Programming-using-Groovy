package demo

import localASTTransformation.MagicNumber
import spock.lang.Specification

/**
 * Created by ali on 30/7/16.
 */
class LocalASTTransformationSpec extends Specification {
    void 'test magic number'() {
        expect:
        new SomeClass().magicNumber == 42
        new SomeMagicClass().magicNumber == 2112
    }
}

@MagicNumber
class SomeClass {

}

@MagicNumber
class SomeMagicClass {
    int getMagicNumber() {
        2112
    }
}