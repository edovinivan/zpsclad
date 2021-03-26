/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfwork.zpsclad.forms.utils;

import lombok.Data;

/**
 *
 * @author ivan
 * Класс работник
 */
@Data
public class Worker {
       
    /**
     * код
     */ 
    int kod;
    /**
     * фио
     */
    String name;
    
    /**
     * кол-во стандартов из hope для контролера      
     */
    int controlor_standart_hope;
    
    /**кол-во позиций из hope для контролера*/
    int controlor_pozic_hope;
    
    /**кол-во стандартов из hope для наборщика    */
    int picker_standart_hope;
    
    /**кол-во позиций из hope для наборщика*/
    int picker_pozic_hope;    
    
    int controlor_standart_smart;
    int controlor_pozic_smart;
    int picker_standart_smart;
    int picker_pozic_smart;
    
    /** дней отработано*/
    int work_day;
    
    /**часов разгрузки*/
    int hour_hand;
    
    /**стаж*/
    int stag;
    
    /**премия*/
    int prize;
    
    /**за комнаты*/
    int room;
    
    /**штраф*/
    int fine;
    
    /**ошибки*/
    int error;
    
    /**оклад*/
    int salary;
    
    /** тип оплаты сотрудника
    // 1 - оклад
    // 2 - наборщик
    // 3 - контролер*/
    int tip_oplata;    
    
    /** дата начала работы месяц*/
    int start_mont;
    
    /** дата начала работы год*/
    int start_yar;
    
    /**удален*/
    int del;    
    
}
