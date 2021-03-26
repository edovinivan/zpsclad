/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfwork.zpsclad.forms.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.tfwork.zpsclad.forms.utils.Worker;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author ivan
 * Работа с файлами
 */
public class LoadFiles {

    public LoadFiles() {
    }
    
    List<Worker> ls = new ArrayList<>();
    List<String> errorString = new ArrayList<>();
    
    /**
     * Получить список 
     * @return 
     */    
    public List<Worker> getListWorker()
    {
        return ls;
    }
    
    public List<String> getErrorString()
    {
        return errorString;
    }
    
    /**
     * Загрузить файл с данными из программы hope
     * @param file_name - путь к файлу
     * @return 
     */
    public boolean loadFileHope(String file_name)
    {        
        File filehope = new File(file_name);
                
        try {
            if(!Files.isExecutable(filehope.toPath()))           
                return false;
            
            Files.readAllLines(filehope.toPath(), Charset.forName("cp866"))
                    .stream()
                    .skip(5)
                    .forEach(s-> {
                        String ss[] = s.split("!");
                        if (ss.length > 5) {
                            Worker w = new Worker();
                            w.setKod(getInt(ss[0]));
                            w.setName(ss[1].trim());
                            w.setPicker_pozic_hope(getInt(ss[2]));
                            w.setPicker_standart_hope(getInt(ss[3]));
                            w.setControlor_pozic_hope(getInt(ss[4]));
                            w.setControlor_standart_hope(getInt(ss[5]));
                            if(w.getKod()>0)
                                ls.add(w);
                        }
                    });
        } catch (IOException ex) {
            Logger.getLogger(LoadFiles.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        return true;
    }
    
    
    /**
     * Загрузить файл с данными из программы смарт
     * @param file_name - путь к файлу
     * @return 
     */
    public boolean loadFileSmart(String file_name)
    {        
        File filehope = new File(file_name);
                
        try {
            if(!Files.isExecutable(filehope.toPath()))           
                return false;
            
            Files.readAllLines(filehope.toPath(), Charset.forName("cp1251"))
                    .stream()
                    .skip(1)
                    .forEach(s-> {
                        String ss[] = s.split(";");
                        if (ss.length < 3) {
                            errorString.add(s);
                        } else {
                            String ss1[] = ss[2].split("/");
                            if (ss1.length < 3) {
                                errorString.add(s);
                            } else {
                                
                                //для контролера
                                List<Worker> lw = ls.stream().filter(x -> x.getKod() == getInt(ss1[0])).collect(Collectors.toList());
                                if(!lw.isEmpty()){ // если есть
                                    Worker w = lw.get(0);                                    
                                    w.setControlor_pozic_smart( w.getControlor_pozic_smart() + getInt(ss[1]));
                                    w.setControlor_standart_smart(w.getControlor_standart_smart() + getInt(ss1[2]));
                                    //w.setPicker_pozic_smart(w.getPicker_pozic_smart() + getInt(ss[1]));
                                    //w.setPicker_standart_smart(w.getPicker_standart_smart() + getInt(ss1[2]));                                    
                                } else { // нового создаем
                                    Worker ww = new Worker();
                                    ww.setKod(getInt(ss1[0]));
                                    ww.setControlor_pozic_smart(getInt(ss[1]));
                                    ww.setControlor_standart_smart(getInt(ss1[2]));
                                    ww.setPicker_pozic_smart(0);
                                    ww.setPicker_standart_smart(0);    
                                    if(ww.getKod() > 0) 
                                        ls.add(ww);
                                }
                                
                                // для наборщика
                                lw = ls.stream().filter(x -> x.getKod() == getInt(ss1[1])).collect(Collectors.toList());
                                if(!lw.isEmpty()){ // если есть
                                    Worker w = lw.get(0);                                    
                                    //w.setControlor_pozic_smart( w.getControlor_pozic_smart() + getInt(ss[1]));
                                    //w.setControlor_standart_smart(w.getControlor_standart_smart() + getInt(ss1[2]));
                                    w.setPicker_pozic_smart(w.getPicker_pozic_smart() + getInt(ss[1]));
                                    w.setPicker_standart_smart(w.getPicker_standart_smart() + getInt(ss1[2]));                                    
                                } else { // нового создаем
                                    Worker ww = new Worker();
                                    ww.setKod(getInt(ss1[1]));
                                    ww.setControlor_pozic_smart(0);
                                    ww.setControlor_standart_smart(0);
                                    ww.setPicker_pozic_smart(getInt(ss[1]));
                                    ww.setPicker_standart_smart(getInt(ss1[2]));   
                                    if(ww.getKod() > 0) 
                                        ls.add(ww);
                                }
                    }
                }
                    });
        } catch (IOException ex) {
            Logger.getLogger(LoadFiles.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        return true;
    }
    
    
    
    /**
     * Получить значение
     */
    private Integer getInt(String s) {
        int l;
        try {
            l = Integer.parseInt(s.trim());
        } catch (NumberFormatException e) {
            l = 0;
        }
        return l;
    }
    
}
