/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfwork.zpsclad.forms.utils;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.tfwork.zpsclad.forms.utils.Worker;
import com.tfwork.zpsclad.forms.utils.SetupKoefficient;
import java.util.List;

/**
 *
 * @author ivan
 * Сохранение и чтение данных из файла
 */
public class RWJsonFile {

    public RWJsonFile() {
    }
      
    /**
     * Сохранить данные в файл
     * @param nameFile - файл
     * @param sk - настройки
     * @param lw - список работников
     * @return 
     */
    public boolean writeSetupToFile(String nameFile, SetupKoefficient sk, List<Worker> lw)
    {
        try(FileWriter fw = new FileWriter(nameFile)){            
            Gson gson = new Gson();            
            // сохраним настройки
            gson.toJson(sk, fw);                
            fw.write("\n");
            
            if (!lw.isEmpty()) {
                lw.forEach(s -> {
                    try {
                        gson.toJson(s, fw);
                        fw.write("\n");
                    } catch (IOException ex) {
                        Logger.getLogger(RWJsonFile.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            }
        } catch (IOException ex) {
            Logger.getLogger(RWJsonFile.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }        
        return true;
    }
    
    
    
    
}
