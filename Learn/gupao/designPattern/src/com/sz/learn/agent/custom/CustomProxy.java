package com.sz.learn.agent.custom;


import com.sz.learn.agent.Chef;
import com.sz.learn.agent.Person;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @Author whd
 * @Date 2018/4/26 17:01
 * @Description
 **/
public class CustomProxy {
    /**
      * @Author whd
      * @Date 2018/4/26 17:12
      * @Param [loader, interfaces, h]
      * @Return java.lang.Object
      * @Description 生成代理类文件，并返回代理类实例
      **/
    public static Object newProxyInstance(CustomClassLoader loader,
                                          Class<?>[] interfaces,
                                          CustomInvocationHandler h) {
        try {
            // 生成代理类文件(.java)
            String proxyStr = generateSrc(interfaces);

            String filePath = CustomProxy.class.getResource("").getPath();
            File customProxyFile = new File("D:\\Source\\learn\\code\\GitHub\\Static\\Learn\\gupao\\designPattern\\src\\com\\sz\\learn\\agent\\custom\\$Proxy0.java");
//            File customProxyFile = new File("E:\\$Proxy0.java");
            FileOutputStream fos = new FileOutputStream(customProxyFile);
            fos.write(proxyStr.getBytes());
            fos.flush();
            fos.close();

            // 编译java文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable it = manager.getJavaFileObjects(customProxyFile);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, it);
            task.call();
            manager.close();

            //将编译生成的class文件加载到jvm
            Class proxyClass = loader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(CustomInvocationHandler.class);

            //返回字节码重组以后的新的代理对象
            return c.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("package com.sz.learn.agent.custom;" + LINE_BREAK);
        sb.append("import com.sz.learn.agent.Person;" + LINE_BREAK);
        sb.append("import com.sz.learn.agent.custom.CustomInvocationHandler;"+LINE_BREAK);
        sb.append("import java.lang.reflect.Method;"+LINE_BREAK);
        sb.append("import java.lang.reflect.Proxy;"+LINE_BREAK);
        sb.append("import java.lang.reflect.UndeclaredThrowableException;"+LINE_BREAK);
        sb.append("public final class $Proxy0 implements Person {"+LINE_BREAK);

        sb.append("public CustomInvocationHandler h;" + LINE_BREAK);
        sb.append("public $Proxy0(CustomInvocationHandler h)  {" + LINE_BREAK);
        sb.append("        this.h = h;" + LINE_BREAK);
        sb.append("    }"+LINE_BREAK);

        for (Method method : interfaces[0].getMethods()) {
            sb.append("public final void "+ method.getName() +"()  {"+LINE_BREAK);
            sb.append("    try {"+LINE_BREAK);
            sb.append("        Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + method.getName() + "\",new Class[]{});" + LINE_BREAK);
            sb.append("        h.invoke(this, m, (Object[])null);"+LINE_BREAK);
            sb.append("    } catch (RuntimeException | Error var2) {"+LINE_BREAK);
            sb.append("        throw var2;"+LINE_BREAK);
            sb.append("    } catch (Throwable var3) {"+LINE_BREAK);
            sb.append("        throw new UndeclaredThrowableException(var3);"+LINE_BREAK);
            sb.append("    }"+LINE_BREAK);
            sb.append("}"+LINE_BREAK);
        }

        sb.append("}");
        return sb.toString();
    }

    private static final String LINE_BREAK = "\r\n";
}
