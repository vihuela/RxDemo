package worldgo.rxoperator.utils;

import java.lang.reflect.Method;

/**
 * @author ricky.yao on 2016/7/14.
 */
public class Event {
    //要执行方法的对象
    private Class object;
    //要执行的方法名称
    private String methodName;
    //要执行方法的参数
    private Object[] params;
    //要执行方法的参数类型
    private Class[] paramTypes;

    public String getMethodName() {
        return methodName;
    }

    public Object[] getParams() {
        return params;
    }

    public Class[] getParamTypes() {
        return paramTypes;
    }

    public Event() {

    }

    public Event(Class object, String methodName, Object[] args) {
        this.object = object;
        this.methodName = methodName;
        this.params = args;
        if (args != null) contractParamTypes(this.params);
    }

    //根据参数数组生成参数类型数组
    private void contractParamTypes(Object[] params) {
        this.paramTypes = new Class[params.length];
        for (int i = 0; i < params.length; i++) {
            this.paramTypes[i] = params[i].getClass();
        }
    }


    public Class getObject() {
        return object;
    }


    /**
     * 根据该对象的方法名，方法参数，利用反射机制，执行该方法
     *
     * @throws Exception
     */
    public void invoke() throws Exception {

        Object o = object.newInstance();
        Method method = o.getClass().getMethod(this.getMethodName(), this.getParamTypes());
        if (null == method) {
            return;
        }
        method.invoke(o, this.getParams());
    }
}
