/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfwork.zpsclad.forms.utils;

import java.math.BigDecimal;
import lombok.Data;
import lombok.ToString;
import org.json.simple.JSONObject;

/**
 *
 * @author ivan
 * Коэффициенты для расчета
 */
@Data
public class SetupKoefficient {

    
    // месяц расчета
    Integer work_mont;
    
    // год расчета
    Integer work_yar;
    
    //количество рабочих дней
    Integer work_day;
    
    //Коэффициент комплектовщик за комнаты
    Integer picker_room;
    
    //Коэффициент контролер за комнаты
    Integer controlor_room;
    
    //коэффициент комплектовщик - позиции
    BigDecimal picker_pozic;
    
    //коэффициент комплектовщик - стандарты
    BigDecimal picker_standart;
    
    //коэффициент контролер - позиции
    BigDecimal controlor_pozic;
    
    //коэффициент контролер - стандарты
    BigDecimal controlor_standart;
    
    // коэффициент дня
    Integer koef_day;
    
    // коэффициент сделки
    Integer koef_work;    

    /**
     * Получить JSONObject из объекта
     * @return 
     */
    /*public JSONObject toJSON()
    {
        JSONObject js = new JSONObject();
        js.put("work_mont", this.getWork_mont());
        js.put("work_yar", this.getWork_yar());
        js.put("work_day", this.getWork_day());
        js.put("picker_room", this.getPicker_room());
        js.put("controlor_room", this.getControlor_room());
        js.put("picker_pozic", this.getPicker_pozic());
        js.put("picker_standart", this.getPicker_standart());
        js.put("controlor_pozic", this.getControlor_pozic());
        js.put("controlor_standart", this.getControlor_standart());
        js.put("koef_day", this.getKoef_day());
        js.put("koef_work", this.getKoef_work());        
        return js;
    }*/
    
}
