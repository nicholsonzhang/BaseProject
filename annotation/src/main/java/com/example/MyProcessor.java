package com.example;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;

/**
 * Created by user on 2017/8/14.
 */

@AutoService(Processor.class)
public class MyProcessor extends AbstractProcessor {
    private Messager mMessager;
    private Filer mFiler;
    @Override
    public synchronized void init(ProcessingEnvironment env) {
        super.init(env);
        mMessager = env.getMessager();
        mFiler = env.getFiler();
        env.getTypeUtils();//处理TypeMirror的工具类
        env.getElementUtils();//处理Element的工具类

    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> types = new LinkedHashSet<>();
        for (Class<? extends Annotation> annotation :getSupportedAnnotations()){
            types.add(annotation.getCanonicalName());
        }
        return types;
    }



    private Set<Class<? extends Annotation>> getSupportedAnnotations(){
        Set<Class<? extends Annotation>> annotations = new LinkedHashSet<>();
        annotations.add(Auto.class);
        annotations.add(Auto1.class);

        return annotations;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.RELEASE_7;
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment env) {

//        Set<? extends Element> auto = env.getElementsAnnotatedWith(Auto.class);
//        for (TypeElement te : set){
//            for (Element element : env.getElementsAnnotatedWith(te)){
//                mMessager.printMessage(Diagnostic.Kind.ERROR,"printing:"+element.toString());
//            }
//        }

        for (TypeElement te:set){

            for (Element element: env.getElementsAnnotatedWith(te)){
                element.getEnclosedElements();//返回此元素直接封装的子元素集
                element.getEnclosingElement();//返回封装此元素的最里层的元素

            }
        }


//        generateMethod();

        return true;
    }

    private void generateMethod() {
        FieldSpec fieldSpec = FieldSpec.builder(String.class,"name")
                .addModifiers(Modifier.PRIVATE)
                .initializer("$S","zyy")
                .build();
        MethodSpec constructorMethod = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC).build();
        MethodSpec methodSpec = MethodSpec.methodBuilder("hellos")
                .addModifiers(Modifier.PUBLIC)
                .build();
        TypeSpec typeSpec = TypeSpec.classBuilder("MyHello")
                .addModifiers(Modifier.PUBLIC,Modifier.ABSTRACT)
                .addMethod(methodSpec)
                .addField(fieldSpec)
                .addMethod(constructorMethod)
                .build();
        JavaFile javaFile = JavaFile.builder("com.user.base",typeSpec).build();
        try {
            javaFile.writeTo(mFiler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
