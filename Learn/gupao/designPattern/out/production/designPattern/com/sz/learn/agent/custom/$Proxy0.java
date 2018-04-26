package com.sz.learn.agent.custom;
import com.sz.learn.agent.custom.Person;
import com.sz.learn.agent.custom.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;
public final class $Proxy0 implements Person {
public CustomInvocationHandler h;
public $Proxy0(CustomInvocationHandler h)  {
        this.h = h;
    }
public final void com.sz.learn.agent.Person  {
    try {
        h.invoke(this, m3, (Object[])null);
    } catch (RuntimeException | Error var2) {
        throw var2;
    } catch (Throwable var3) {
        throw new UndeclaredThrowableException(var3);
    }
}
}