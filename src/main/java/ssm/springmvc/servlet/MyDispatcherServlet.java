package ssm.springmvc.servlet;

import lombok.extern.slf4j.Slf4j;
import ssm.spring.InitBean;
import ssm.springmvc.Binding;
import ssm.springmvc.Handler;
import ssm.springmvc.MyModelAndView;
import ssm.springmvc.ViewResolver;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static ssm.springmvc.BindingRequestAndModel.bindingRequestAndModel;

/**
 * Created by Yien on 2018/12/21.
 */
@WebServlet(name = "MyDispatcherServlet")
@Slf4j
/*前端控制器*/
public class MyDispatcherServlet extends HttpServlet {

    /**
     * 初始化servlet，将bean容器和HandlerMapping放到servlet的全局变量中
     */
    @Override
    public void init() {
        InitBean initBean = new InitBean();
        initBean.initBeans();
        //根据bean容器中注册的bean获得HandlerMapping
        /*url-method*/
        /*通过注解的bean 找到controll 在找requestMapping注解 -》绑定url-method*/
        Map<String, Method> bindingRequestMapping = Handler.bindingRequestMapping(initBean.beanContainerMap);
//        bindingRequestMapping.forEach((key,value)->{
//
//        });
        ServletContext servletContext = this.getServletContext();
        /*bean Map*/
        servletContext.setAttribute("beanContainerMap", initBean.beanContainerMap);
        /*handlerMapping HandlerMapping处理器映射器*/
        servletContext.setAttribute("bindingRequestMapping", bindingRequestMapping);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            doDispatch(request, response);
        } catch (Exception e) {
            log.error("控制器处理异常");
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
    //接收到请求后转发到相应的方法上
    private void doDispatch(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException, InstantiationException {
        ServletContext servletContext = this.getServletContext();
        //获取扫描controller注解后url和方法绑定的mapping，也就是handlerMapping
        Map<String, Method> bindingRequestMapping =
                (Map<String, Method>) servletContext.getAttribute("bindingRequestMapping");
        //获取实例化的bean容器
        Map<String, Object> beanContainerMap = (Map<String, Object>) servletContext.getAttribute("beanContainerMap");
        String url = request.getServletPath();
        Set<Map.Entry<String, Method>> entries = bindingRequestMapping.entrySet();
        /*获取请求的参数*/
        List<Object> resultParameters = Binding.bingdingMethodParamters(bindingRequestMapping, request);
        /*遍历handlerMapping*/
        for (Map.Entry<String, Method> entry :
                entries) {
            if (url.equals(entry.getKey())) {
                /*根据url找到具体的method 也就是handler:源码是用HandlerAdapter处理器适配器。 HandlerAdapter经过适配调用具体的处理器(Controller，也叫后端控制器)。*/
                Method method = entry.getValue();
                /*方法的返回类型*/
                Class<?> returnType = method.getReturnType();
                    //如果返回值是MyModelAndView，开始绑定
                if ("MyModelAndView".equals(returnType.getSimpleName())){
                    Object object = beanContainerMap.get(method.getDeclaringClass().getName());
                    //获取springmvc.xml中配置的视图解析器
                    ViewResolver viewResolver = (ViewResolver) beanContainerMap.get("ssm.springmvc.ViewResolver");
                    /*获取视图解析器前缀*/
                    String prefix = viewResolver.getPrefix();
                    /*获取视图解析器后缀*/
                    String suffix = viewResolver.getSuffix();
                    /*通过反射调用绑定的方法*/
                    MyModelAndView myModelAndView = (MyModelAndView) method.invoke(object, resultParameters.toArray());
                    //将request和model中的数据绑定
                    bindingRequestAndModel(myModelAndView,request);
                    /*获取返回的视图名称*/
                    String returnViewName = myModelAndView.getView();
                    //返回的路径
                    String resultAddress = prefix + returnViewName + suffix;
                    System.out.println(resultAddress);
                    try {
                      //  request.setAttribute("test","testModel");
                        request.getRequestDispatcher(resultAddress).forward(request,response);
                    } catch (ServletException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }



}
