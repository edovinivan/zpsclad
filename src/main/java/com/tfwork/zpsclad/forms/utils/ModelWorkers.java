/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfwork.zpsclad.forms.utils;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ivan
 */
public class ModelWorkers extends AbstractTableModel{

    public ModelWorkers() {
        listCol.add("Код");
        listCol.add("Тип");
        listCol.add("ФИО");
        listCol.add("Компл.Позиц");
        listCol.add("Компл.Станд");
        listCol.add("Контр.Позиц");
        listCol.add("Контр.Станд");  // 6        
        listCol.add("Дней");
        listCol.add("Разгр");
        listCol.add("Стаж");
        listCol.add("Премия");  // 10
        listCol.add("Комнаты");
        listCol.add("Штраф");
        listCol.add("Ошибки");
        listCol.add("Удален");
    }

    List<Worker> list;
    List<String> listCol = new ArrayList<>();
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return listCol.size();
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
            
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getKod();
            case 1:
                return list.get(rowIndex).getTip_oplata()==0?"ОКЛ":( list.get(rowIndex).getTip_oplata()==1?"НАБ":"КОНТ");
            case 2:
                return list.get(rowIndex).getName();
            case 3:
                return list.get(rowIndex).getPicker_pozic_hope()+list.get(rowIndex).getPicker_pozic_smart();
            case 4:
                return list.get(rowIndex).getPicker_standart_hope()+list.get(rowIndex).getPicker_standart_smart();
            case 5:
                return list.get(rowIndex).getControlor_pozic_hope()+list.get(rowIndex).getControlor_pozic_smart();
            case 6:
                return list.get(rowIndex).getControlor_standart_hope()+list.get(rowIndex).getControlor_standart_smart();
            case 7:
                return list.get(rowIndex).getWork_day();
            case 8:
                return list.get(rowIndex).getHour_hand();
            case 9:
                return list.get(rowIndex).getStag();
            case 10:
                return list.get(rowIndex).getPrize();
            case 11:
                return list.get(rowIndex).getRoom();
            case 12:
                return list.get(rowIndex).getFine();
            case 13:
                return list.get(rowIndex).getError();           
            case 14:
                return list.get(rowIndex).getDel();               
                
        }
        return null;
    }
    
    /**
     * Заполнить таблицу
     * @param ls 
     */
    public void setData(List<Worker> ls)            
    {
        list = ls;
        fireTableDataChanged();
    }
   
    
    
    
}
