package com.example.buildsrcnew.parse;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Arrays;


public class LifecycleClassParseVisitor extends ClassVisitor {

    private static final String TAG = LifecycleClassParseVisitor.class.getSimpleName();

    private String className,superName;


    public LifecycleClassParseVisitor(ClassVisitor classVisitor) {
        super(Opcodes.ASM5, classVisitor);
    }


    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);

        this.className = name;
        this.superName = superName;

        System.out.println(TAG+"====== className = "+className + " superName = " + superName +"  name = " + name);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {

        System.out.println(TAG+"====== access = "+access + " name = "+name + " descriptor = "+descriptor +
                " signature = "+signature + " exceptions = "+ Arrays.toString(exceptions) + " ========");

        MethodVisitor mv = cv.visitMethod(access, name, descriptor, signature, exceptions);

//        if (superName.equals("com.example.studyproject.plugin.annotation.BaseData")){
            if (name.startsWith("parseData")){
                return new LifecycleMethodParseVisitor(mv,className,name);
            }
//        }
        return mv;
    }

    @Override
    public void visitEnd() {
        super.visitEnd();

    }
}