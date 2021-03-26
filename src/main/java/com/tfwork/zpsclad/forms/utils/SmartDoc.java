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
 */
@Data
public class SmartDoc {
    /**
     * Код
     */
    int kod;
    /**
     *   Контролер стандарт
     */
    int controlor_standart;
    /**
     * Контролер позиций
     */
    int controlor_pozic;
    /**
     * Наборщик стандарт
     */
    int picker_standart;
    /**
     * Наборщик позиций
     */
    int picker_pozic;    
}
