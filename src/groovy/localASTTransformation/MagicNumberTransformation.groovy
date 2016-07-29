package localASTTransformation

import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.ClassHelper
import org.codehaus.groovy.ast.ClassNode
import org.codehaus.groovy.ast.MethodNode
import org.codehaus.groovy.ast.Parameter
import org.codehaus.groovy.ast.expr.ConstantExpression
import org.codehaus.groovy.ast.stmt.ReturnStatement
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation

import java.lang.reflect.Modifier

/**
 * Created by ali on 30/7/16.
 */
@GroovyASTTransformation(phase = CompilePhase.CANONICALIZATION)
class MagicNumberTransformation implements ASTTransformation {
    @Override
    void visit(ASTNode[] astNodes, SourceUnit sourceUnit) {
        ClassNode node = astNodes[1]
        def method = node.getMethod('getMagicNumber', new Parameter[0])
        if (method == null) {
            def rs = new ReturnStatement(new ConstantExpression(42))
            def newMethod = new MethodNode('getMagicNumber', Modifier.PUBLIC, ClassHelper.make(Integer), new Parameter[0], null, rs)
            node.addMethod(newMethod)
        }

    }
}
