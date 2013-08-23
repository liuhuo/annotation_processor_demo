package liuhuo.aptdemo;

import javax.annotation.processing.*;
import javax.lang.model.element.*;
import javax.tools.*;
import javax.lang.model.SourceVersion;
import java.util.Set;

@SupportedAnnotationTypes({"liuhuo.aptdemo.PrintMe"})
public class AnnotationProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env) {
	Messager messager = processingEnv.getMessager();
	for (TypeElement te : annotations) {
	    for (Element e : env.getElementsAnnotatedWith(te)) {
		messager.printMessage(Diagnostic.Kind.NOTE,"Printing: " + e.toString());
	    }
	}
	return true;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
	return SourceVersion.latestSupported();
    }
}
