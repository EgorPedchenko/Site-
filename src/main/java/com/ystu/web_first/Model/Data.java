package com.ystu.web_first.Model;

import com.ystu.web_first.Main;

import java.util.ArrayList;
import java.util.Arrays;

public class Data {
    private static Data data = null;

    public static Data getInstance() {
        if(data == null) {
            data = new Data();
        }
        return data;
    }

    private Data() {
        initData();
    }

    ArrayList<Guitar> guitars = new ArrayList<Guitar>();
    ArrayList<Customer> customers = new ArrayList<Customer>();
    ArrayList<Employee> employees = new ArrayList<Employee>();
    ArrayList<Order> orders = new ArrayList<Order>();

    //получить покупателя по логину и паролю
    public  Customer getCustomerByLogPas(String log, String pass) {
        for (Customer cusLP : customers){
            if ((cusLP.getName().equals(log)) && (cusLP.getPass().equals(pass)) ){
                return cusLP;
            }
        }
        return null;
    }

    //получить id покупателя по логину и паролю
    public  long getIdCustomerByLogPas(String log, String pass) {
        for (Customer cusLP : customers){
            if ((cusLP.getName().equals(log)) && (cusLP.getPass().equals(pass)) ){
                return cusLP.getId();
            }
        }
        return 0;
    }

    //проверка на правильность логина и пароля
    public  boolean getLogin(String log, String pass) {
        for (Customer cusLP : customers){
            if ((cusLP.getName().equals(log)) && (cusLP.getPass().equals(pass))){
                return false;
            }
        }
        return true;
    }

    //добавить нового пользователя
    public String addCustomers(long id,String name, String pass,int age) {
        for (Customer cusLP : customers){
            if ((cusLP.getName().equals(name))){
                return "Такое имя уже существует";
            }
        }
        customers.add(new Customer(id,name,pass, age));
        return "Регистрация прошла успешно";
    }

    //вернуть количество пользователей в БД
    public int getSizeCustomers()
    {
        return customers.size();
    }

    //получить гитары
    public  ArrayList<Guitar> getGuitars() {
        return guitars;
    }

    //получить гитару по ее id
    public  Guitar getGuitarById(long id) {
        for (Guitar guitar : guitars){
            if (guitar.getId() == id){
                return guitar;
            }
        }
        return null;
    }

    //установить заказ
    public  void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    //получить заказ по его id
    public  Order getOrderById(long id) {
        for (Order or : orders){
            if (or.getId() == id){
                return or;
            }
        }
        return new Order();
    }

    //получить заказ по id прользователя
    public  Order getOrderByCustomer(long idCust) {
        for (Order or : orders){
            if (or.getCustomer_id() == idCust){
                return or;
            }
        }
        return new Order();
    }


    public void initData()
    {
        employees.add(new Employee(1,"Andre","pros", 22));
        customers.add(new Customer(2,"Egor","111", 23));
        customers.add(new Customer(2,"Andre","222", 22));


        guitars.add(new Guitar(1,"Выпрыгивающий из тостера хлеб, как причина инфаркта у котиков","5",20000, GuitarType.Magistr));
        guitars.add(new Guitar(2,"Методика приготовления идеального шашлыка","5",60000, GuitarType.Bakalavr));
        guitars.add(new Guitar(3,"Влияние солнечной активности на менструальный цикл уток","5",63000, GuitarType.Doctor));
        guitars.add(new Guitar(4,"Роль топора в произведениях Чехова","5",40000, GuitarType.Magistr));

       // orders.add(new Order(3,1,1, Arrays.asList(1l)));
    }

}
