package groovyimportbug.broken.java.groovyimportbug;

import groovy.lang.GroovyShell;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.codehaus.groovy.control.customizers.ImportCustomizer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GroovyImportBug {
    @Test
    public void testGroovyImport() {
        CompilerConfiguration configuration = new CompilerConfiguration();
        final ImportCustomizer importCustomizer = new ImportCustomizer();
        importCustomizer.addStaticStars(CustomPrintln.class.getName());
        configuration.addCompilationCustomizers(importCustomizer);
        GroovyShell shell = new GroovyShell(configuration);
        shell.evaluate("println(\"test\")");
        Assertions.assertTrue(CustomPrintln.messages.contains("test"), "Messages does not contain \"test\" " + CustomPrintln.messages);
    }

    public static class CustomPrintln {
        public static List<String> messages = new ArrayList<>();
        public static void println(String message) {
            messages.add(message);
        }
    }
}
