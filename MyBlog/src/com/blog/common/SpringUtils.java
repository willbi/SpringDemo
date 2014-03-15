package com.blog.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;


public class SpringUtils {
    //private static final Logger LOG = Logger.getLogger(SpringUtils.class);

    public String renderView(ViewResolver viewResolver,HttpServletRequest request, ModelAndView mav){
        try {
        	 View view = viewResolver.resolveViewName(mav.getViewName(), Locale.CHINA);
             HttpServletResponse localResponse = new MyHttpServletResponseWrapper(new DummyResponse());

             view.render(mav.getModel(), request, localResponse);

             return localResponse.toString();
        } catch (Exception e) {
            return "³ö´í£º"+e.getMessage();
        }
    }

    public boolean doesViewExist(ViewResolver viewResolver,HttpServletRequest request, String viewName) {
        try {
            if (viewResolver.resolveViewName(viewName, Locale.CHINA) != null) {
                return true;
            }
        } catch (Exception e) {
            //LOG.error(e.getMessage(), e);
        }

        return false;
    }

    static class MyHttpServletResponseWrapper extends HttpServletResponseWrapper {
        private StringWriter sw = new StringWriter();

        public MyHttpServletResponseWrapper(HttpServletResponse response) {
            super(response);
        }

        public PrintWriter getWriter() throws IOException {
            return new PrintWriter(sw);
        }

        public ServletOutputStream getOutputStream() throws IOException {
            throw new UnsupportedOperationException();
        }

        public String toString() {
            return sw.toString();
        }
    }
}
