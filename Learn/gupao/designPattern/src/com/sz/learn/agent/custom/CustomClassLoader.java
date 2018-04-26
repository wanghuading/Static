package com.sz.learn.agent.custom;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author whd
 * @Date 2018/4/26 17:03
 * @Description
 **/
public class CustomClassLoader extends ClassLoader{
    private File classPathFile;

    public CustomClassLoader() {
        String classPath = CustomClassLoader.class.getResource("").getPath();
        classPathFile = new File(classPath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        FileInputStream fis = null;
        ByteOutputStream bos = null;
        try {
            String className = CustomClassLoader.class.getPackage().getName() + "." + name;

            if (classPathFile != null && classPathFile.exists()) {
                File classFile = new File(classPathFile, name.replaceAll("\\.", "/") + ".class");
                if (classFile != null && classFile.exists()) {
                    fis = new FileInputStream(classFile);
                    bos = new ByteOutputStream();

                    int len = 0;
                    byte[] bytes = new byte[1024];

                    while ((len = fis.read(bytes)) != -1) {
                        bos.write(bytes, 0 , len);
                    }
                    return defineClass(className, bos.getBytes(),0, bos.size());
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
