import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.FileInputStream;
import java.io.InputStream;

//解析相应的语法树到项目中
public class ExprTree {
    public static void main(String[] args) throws Exception {
        String inputFile = null;

        if (args.length > 0) {
            inputFile = args[0];
        }
        InputStream is = System.in;
        if (inputFile != null) {
            is = new FileInputStream(inputFile);
        }

        ANTLRInputStream input = new ANTLRInputStream(is);//文本流转换为antlr流
        ExprLexer lexer = new ExprLexer(input);//分词
        CommonTokenStream tokens = new CommonTokenStream(lexer);//转换为tokens
        ExprParser parser = new ExprParser(tokens);//对tokens进行解析
        ParseTree tree = parser.prog();//入口开始
        System.out.println(tree.toStringTree(parser));//文本形式打印语法树
    }
}