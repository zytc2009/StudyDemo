package com.example.buildsrcnew;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Arrays;



public class LifecycleClassVisitor extends ClassVisitor {

    private static final String TAG = "com.example.buildsrcnew.LifecycleClassVisitor";

    private String className,superName;


    public LifecycleClassVisitor(ClassVisitor classVisitor) {
        super(Opcodes.ASM5, classVisitor);
    }


    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);

        this.className = name;
        this.superName = superName;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {

        System.out.println(TAG+"====== access = "+access + " name = "+name + " descriptor = "+descriptor +
                " signature = "+signature + " exceptions = "+ Arrays.toString(exceptions) + " ========");

        MethodVisitor mv = cv.visitMethod(access, name, descriptor, signature, exceptions);

        if (superName.equals("androidx/appcompat/app/AppCompatActivity")){
            if (name.startsWith("onCreate")){
                return new LifecycleMethodVisitor(mv,className,name);
            }
        }
        return mv;
    }

    @Override
    public void visitEnd() {
        super.visitEnd();

    }
}