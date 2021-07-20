import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        try{
            // crear un analizador léxico que se alimenta a partir de la entrada (archivo  o consola)
            MySqlLexer lexer;
            if (args.length>0)
                lexer = new MySqlLexer(CharStreams.fromFileName(args[0]));
            else
                lexer = new MySqlLexer(CharStreams.fromStream(System.in));
            // Identificar al analizador léxico como fuente de tokens para el sintactico
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            // Crear el objeto correspondiente al analizador sintáctico que se alimenta a partir del buffer de tokens
            MySqlParser parser = new MySqlParser(tokens);
            ParseTree tree = parser.root(); // Iniciar el analisis sintáctico en la regla inicial: r
            //System.out.println(tree.toStringTree(parser)); // imprime el arbol al estilo LISP

            // Create a generic parse tree walker that can trigger callbacks
            ParseTreeWalker walker = new ParseTreeWalker();
            // Walk the tree created during the parse, trigger callbacks
            walker.walk(new Documentador(), tree);
            System.out.println(); // print a \n after translation

        } catch (Exception e){
            System.err.println("Error (Test): " + e);
        }
    }
}