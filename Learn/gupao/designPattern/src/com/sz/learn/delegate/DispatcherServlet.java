package com.sz.learn.delegate;

import com.sz.learn.delegate.controllers.MemberAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author whd
 * @Date 2018/4/27 22:56
 * @Description 委派模式，DispatcherServlet相当于Boss角色，分配员工任务
 **/
public class DispatcherServlet {

    private List<Handler> handlers = new ArrayList<>();

    DispatcherServlet() {
        Class<?> member = MemberAction.class;
        try {
            handlers.add(new Handler()
                    .setController(member.newInstance())
                    .setMethod(member.getMethod("getMemberById", new Class[]{String.class}))
                    .setUrl("/web/getMemberById.json")
            );
            // 另外两个就不写了
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doService(HttpServletRequest request, HttpServletResponse response) {
        doDispatch(request, response);
    }

    public void doDispatch(HttpServletRequest request, HttpServletResponse response) {
        // 按照j2ee的规则，一个url对应一个serlvet，url由浏览器输入
        // 取得请求的地址
        String uri = request.getRequestURI();
        // 根据url找到对应的处理器
        Handler handler = null;
        for (Handler h : handlers) {
            if (uri.equals(h.getUrl())) {
                handler = h;
                break;
            }
        }
        // 将任务分配給具体的方法
        Object object = null;
        try {
            object = handler.getMethod().invoke(handler.getController(), request.getParameter("mid"));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // 将执行结果通过response返回
//        response.getWriter().write();
    }


    class Handler {
        private Object controller;
        private Method method;
        private String url;

        public Object getController() {
            return controller;
        }

        public Handler setController(Object controller) {
            this.controller = controller;
            return this;
        }

        public Method getMethod() {
            return method;
        }

        public Handler setMethod(Method method) {
            this.method = method;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Handler setUrl(String url) {
            this.url = url;
            return this;
        }
    }
}
