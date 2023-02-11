package com.example.userManage.service;

import com.example.userManage.model.manage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class userService {

    private static List<manage> Manage = new ArrayList<>();

    private static int manageCount =0;

    static {
        Manage.add(new manage(++manageCount,"Anushka","Anushka@1234","Allahabad,India","8081009534"));
        Manage.add(new manage(++manageCount,"Prerna","prerna@365","Banglore,India","3478901245"));
        Manage.add(new manage(++manageCount,"Mitali","mitali@pandit13","Delhi,India","9999334210"));
        Manage.add(new manage(++manageCount,"Adhik","adhikMehta@444","Pune,India","5689347612"));
        Manage.add(new manage(++manageCount,"Mayuresh","mayuresh@90","Goa,India","7056234100"));
        Manage.add(new manage(++manageCount,"Nikhil","nikhil@45","Udaipur,India","6671235902"));
    }

    public List<manage> getAllUser() {
        return Manage;
    }

    public void addUser(manage addOne){
        Manage.add(addOne);
    }

    public manage getUserById(int id){
        Predicate<? super manage> predicate = todo -> todo.getId() == id;
        manage manageId = Manage.stream().filter(predicate).findFirst().get();
        return manageId;
    }

    public void deleteUser(int id){
        Predicate<? super manage> predicate = todo -> todo.getId() == id;
        Manage.removeIf(predicate);
    }

    public void updateUserInfo(int id, manage newUser){

        //Step 1 : find todo to be Update
        //Step 2 : update todo

        manage manageNew = getUserById(id);
        manageNew.setId(newUser.getId());
        manageNew.setName(newUser.getName());
        manageNew.setUsername(newUser.getUsername());
        manageNew.setAddress(newUser.getAddress());
        manageNew.setPhoneNum(newUser.getPhoneNum());
    }
}
