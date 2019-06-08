package com.ystu.web_first.servlets;

import com.ystu.web_first.Model.Data;
import com.ystu.web_first.Model.Order;
import com.ystu.web_first.spring.SpringConfigContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jerde on 07.04.2017.
 */
public class HelloServlet extends HttpServlet {

    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigContext.class);
    List<Long> ArrayIdGtr = new ArrayList<Long>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.setContentType("text/html");
        //req.setAttribute("todo", "10");

        List list = context.getBean(List.class);
        req.setAttribute("list", list);

        Long id =  (Long) req.getSession().getAttribute("idUser");

        if (id == null) {
            resp.sendRedirect("login");
        }
        else {
            ArrayList<Order> or = new ArrayList<Order>();
            if (req.getSession().getAttribute("ArrayIdGtr2") == null){
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
            else{
                List<Long> KorzAdd=  (List) req.getSession().getAttribute("ArrayIdGtr2");
                req.getSession().setAttribute("ArrayIdGtr2",KorzAdd);
                long id2 = id;
                or.add(new Order(1,id2,12,KorzAdd));
                Data.getInstance().setOrders(or);
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        }
    }

   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List list = context.getBean(List.class);
        req.setAttribute("list", list);

        ArrayList<Order> or = new ArrayList<Order>();
        List<Long> Korz = new ArrayList<Long>();

        Long id =  (Long) req.getSession().getAttribute("idUser");
        long id2 = id;

        Korz = Data.getInstance().getOrderByCustomer(id).getGuitars();

        if (req.getSession().getAttribute("ArrayIdGtr2") == null && Korz.size()==0){
            List<Long> KorzPust = new ArrayList<Long>();
            String name = req.getParameter("button");
            KorzPust.add(Long.parseLong(name));
            req.getSession().setAttribute("ArrayIdGtr2",KorzPust);
            Korz = KorzPust;
        }
        else{
            if (req.getSession().getAttribute("ArrayIdGtr2") == null) {
                List<Long> KorzAdd=Korz;
                String name = req.getParameter("button");
                KorzAdd.add(Long.parseLong(name));
                req.getSession().setAttribute("ArrayIdGtr2",KorzAdd);
                Korz = KorzAdd;
            }
            else{
            List<Long> KorzAdd=  (List) req.getSession().getAttribute("ArrayIdGtr2");
            String name = req.getParameter("button");
            KorzAdd.add(Long.parseLong(name));
            req.getSession().setAttribute("ArrayIdGtr2",KorzAdd);
            Korz = KorzAdd;
            }
        }

        or.add(new Order(1,id2,12,Korz));
        Data.getInstance().setOrders(or);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

}
