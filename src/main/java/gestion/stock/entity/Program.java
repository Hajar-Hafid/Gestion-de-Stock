package gestion.stock.entity;

import java.util.List;

public class Program {
    public static void main(String[] args){
        UserDataAccess userDataAccess=new UserDataAccess();
        //List<User> list= userDataAccess.getAll();
        //List<User> list= userDataAccess.getUserByType("admin");
        //for(User usr:list){
          //  System.out.println(usr);
       // }
        IUserDAO udao =new UserDAOImpl();


        System.out.println("----------getOne()");
        User usr1=udao.getOne(20231);
        if(usr1!=null)
        System.out.println(usr1);
        else
            System.out.println("user non existant");

        System.out.println("----------getAll(s)");
        List<User> list2=udao.getAll("adm");
        for( User usr2:list2){
            System.out.println(usr2);
        }
        System.out.println("----------delete(20231)");
        udao.delete(20231);

        System.out.println("----------add()");
        User usraj=new User(20233,"qhsbs@gmail.com","hsdgvb","admin");
        udao.add(usraj);

        System.out.println("----------getAll()");

        List<User> list=udao.getAll();
        for( User usr:list){
            System.out.println(usr);
        }




    }
}
