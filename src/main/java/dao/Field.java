/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

/**
 *
 * @author Alex Christian
 */
public class Field {
    private java.lang.reflect.Field field;
    private boolean isPrimaryKey;
    

    public Field(java.lang.reflect.Field field, boolean isPrimaryKey) {
        this.field = field;
        this.isPrimaryKey = isPrimaryKey;
    }

    public java.lang.reflect.Field getField() {
        return field;
    }

    public boolean isPrimaryKey() {
        return isPrimaryKey;
    }
    
}
