/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfwork.zpsclad.forms.utils;

import java.util.List;

/**
 *
 * @author ivan
 */
public class WorkExecute {

    public WorkExecute() {
    }
    
    /**
     * Выполнить прасчет
     * @param listWorker - список сотрудников
     * @param setupKoefficient - настройки
     * @return 
     */
    public boolean RunExecute(List<Worker> listWorker, SetupKoefficient setupKoefficient)
    {
        //выполнить расет
        listWorker.stream()
                .filter(t-> {return t.getDel()==0;})
                .forEach(x->{
                   System.out.println("->" + x.getName()); 
                });
        return true;
    }
    
}
