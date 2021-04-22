/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfwork.zpsclad.forms.utils;

import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

/**
 *
 * @author ivan
 * Коэффициенты для расчета
 */
@Data
public class SetupKoefficient {

    
    /**
     * месяц расчета
     */
    Integer work_mont;
    
    /** 
     * год расчета      
     */
    Integer work_yar;
    
    /**
     * количество рабочих дней
     */
    Integer work_day;
    
    /**
     * Коэффициент комплектовщик за комнаты
     */
    Integer picker_room;
    
    /**
     * Коэффициент контролер за комнаты
     */
    Integer controlor_room;
    
    /**
     * коэффициент комплектовщик - позиции
     */
    BigDecimal picker_pozic;
    
    /**
     * коэффициент комплектовщик - стандарты
     */ 
    BigDecimal picker_standart;
    
    /**
     * коэффициент контролер - позиции
     */
    BigDecimal controlor_pozic;
    
    /**
     * коэффициент контролер - стандарты
     */
    BigDecimal controlor_standart;
    
    /**
     * коэффициент дня
     */
    Integer koef_day;
    
    /**
     * коэффициент сделки
     */ 
    Integer koef_work;    

    /**
     * Разрешенные коды сотрудников
     */
    List<Integer> lsGutKod;
    
    
    
}
