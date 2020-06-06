package com.example.buildsrcnew

import com.android.build.api.transform.DirectoryInput
import com.android.build.api.transform.Format
import com.android.build.api.transform.QualifiedContent
import com.android.build.api.transform.Transform
import com.android.build.api.transform.TransformException
import com.android.build.api.transform.TransformInput
import com.android.build.api.transform.TransformInvocation
import com.android.build.api.transform.TransformOutputProvider
import com.android.build.gradle.internal.pipeline.TransformManager
import com.android.utils.FileUtils
import com.example.buildsrcnew.parse.LifecycleClassParseVisitor
import groovy.io.FileType


import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.ClassWriter


class CustomTransform extends Transform{

    @Override
    String getName() {
        println "CustomTransform : getName"
        return "CustomTransform"
    }

    @Override
    Set<QualifiedContent.ContentType> getInputTypes() {
        println "CustomTransform : getInputTypes"
        return TransformManager.CONTENT_CLASS
    }

    @Override
    Set<? super QualifiedContent.Scope> getScopes() {
        println "CustomTransform : getScopes"

        return TransformManager.SCOPE_FULL_PROJECT
    }

    @Override
    boolean isIncremental() {
        return false
    }

    @Override
    void transform(TransformInvocation transformInvocation) throws TransformException, InterruptedException, IOException {
//        super.transform(transformInvocation)

        println "CustomTransform :transform() start ..."

        //获取所有 .class 文件
        Collection<TransformInput> inputCollection = transformInvocation.inputs
        TransformOutputProvider outputProvider = transformInvocation.outputProvider

//        inputCollection.each { TransformInput transformInput ->
//            println("CustomTransform :transform() inputCollection.each ")
//
//            transformInput.directoryInputs.each { DirectoryInput directoryInput ->
//                File dir = directoryInput.file
//
//                println("CustomTransform :transform() transformInput.directoryInputs.each ")
//
//                if (dir) {
//                    println("CustomTransform :transform() transformInput.directoryInputs.each -> dir ")
//
//                    dir.traverse(type: FileType.FILES, nameFilter: ~/.*\.class/) { File file ->
//                        println("find class: " + file.name)  // ④
//                    }
//                }
//
//            }
//        }

        inputCollection.each { TransformInput transformInput ->
            println("CustomTransform :transform() inputCollection.each ")

            transformInput.directoryInputs.each { DirectoryInput directoryInput ->
                File dir = directoryInput.file

                println("CustomTransform :transform() transformInput.directoryInputs.each ")

                if (dir) {
                    println("CustomTransform :transform() transformInput.directoryInputs.each -> dir ")

                    dir.traverse(type: FileType.FILES, nameFilter: ~/.*\.class/) { File file ->
                        println("CustomTransform : find class: " + file.name)

                        //对class文件进行读取与解析
                        ClassReader classReader = new ClassReader(file.bytes)

                        // 对class文件写入
                        ClassWriter classWriter = new ClassWriter(classReader, ClassWriter.COMPUTE_MAXS)

                        //访问class文件相应内容、解析到某一个结构就会通知到 ClassVisitor 内部方法
                        ClassVisitor classVisitor = new LifecycleClassParseVisitor(classWriter)

                        // 依次调用 classVisitor内部方法
                        classReader.accept(classVisitor, ClassReader.EXPAND_FRAMES)

                        byte[] bytes = classWriter.toByteArray()

                        //通过文件流写入方式覆盖掉原先的内容，实现class文件的改写。
                        println("CustomTransform : output path: " + file.path)
                        FileOutputStream fis = new FileOutputStream(file.path)
                        fis.write(bytes)
                        fis.close()

                    }
                }
                def dest = outputProvider.getContentLocation(directoryInput.name, directoryInput.contentTypes,
                        directoryInput.scopes, Format.DIRECTORY)
                FileUtils.copyDirectory(directoryInput.file, dest)


            }

            transformInput.jarInputs.each {
                File destJar = outputProvider.getContentLocation(it.name, it.contentTypes,
                        it.scopes, Format.JAR)
                FileUtils.copyFile(it.file, destJar)
            }
        }
    }
}
