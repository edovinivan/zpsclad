/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfwork.zpsclad.forms.utils;


import com.google.gson.Gson;
import org.json.simple.JSONObject;

/**
 *
 * @author ivan
 */
public class JsonUtil {

    public JsonUtil() {
    }
    
    /**
     * Получить из объекта JSON
     * @param work - объект
     * @return 
     */
    public JSONObject toJsonOfWorker(Worker work)
    {
        Gson gson = new Gson();
        gson.toJson(work);        
return new  JSONObject();
    }
    
    /**
     * Получить объект Worker из JSON 
     * @param jw - 
     * @return 
     */
    public Worker createWorkerOfJson(JSONObject jw)
    {
        Worker worker = new Worker();
        return worker;
        //worker.setControlor_pozic_hope(Integer.parseInt((String) jw.get("controlor_pozic_hope")));
    }
}
