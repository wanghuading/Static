package com.sz.learn.agent.custom;
import com.sz.learn.agent.Person;
import com.sz.learn.agent.custom.CustomInvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;
public final class $Proxy0 implements Person {
public CustomInvocationHandler h;
public $Proxy0(CustomInvocationHandler h)  {
        this.h = h;
    }
public final void cook()  {
    try {
        Method m = com.sz.learn.agent.Person.class.getMethod("cook",new Class[]{});
        h.invoke(this, m, (Object[])null);
    } catch (RuntimeException | Error var2) {
        throw var2;
    } catch (Throwable var3) {
        throw new UndeclaredThrowableException(var3);
    }
}
}