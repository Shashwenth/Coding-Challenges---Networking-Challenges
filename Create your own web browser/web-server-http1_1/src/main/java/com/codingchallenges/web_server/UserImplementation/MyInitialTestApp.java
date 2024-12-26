package com.codingchallenges.web_server.UserImplementation;

import java.util.ArrayList;
import java.util.List;

import com.codingchallenges.web_server.ConfigurationMapper.JsonParser;
import com.codingchallenges.web_server.EndPoints.AddEndPoints;
import com.codingchallenges.web_server.RequestMapping.MainTrieGetter;

public class MyInitialTestApp {

    

    public MyInitialTestApp(){

    }

    private List<String> register(String FunctionName){
        List<String> response=new ArrayList<>();
        MyInitialTestApp myInitialTestApp=new MyInitialTestApp();
        response.add(myInitialTestApp.getClass().getName());
        response.add(FunctionName);
        return response;
    }

    public String getName(){
        return "Shashwenth";
    }


    public int getAge(){
        return 10;
    }

    public String setName(String ReqDataAsString){
        JsonParser<UserEntity> userParser = new JsonParser<>(UserEntity.class);
        UserEntity userEntity = userParser.parseFromString(ReqDataAsString);
        userParser.printEntity(userEntity);
        return "Added Successfully";
    }

    public void initialize(String path, String FunctionName, String Method){
        List<String> classAndMethod=register(FunctionName);
        AddEndPoints addEndPoints=new AddEndPoints(MainTrieGetter.getRoot());
        addEndPoints.BackendAddEndpoint(path, path, Method, classAndMethod);
    }


}