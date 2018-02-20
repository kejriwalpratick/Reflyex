/**
 * Created by PRATIK KEJRIWAL on 28-08-2017.
 */
package com.kejriwalpratick.reflyex;

public class flyingObject {
    private String obj;
    private char Fv;
    private String message;
    public flyingObject(String s,char f,String m)
    {
        obj = s;
        Fv = f;
        message = m;
    }
    String getObj()
    {
        return obj;
    }
    char getFv()
    {
        return Fv;
    }
    String getMessage(){ return message;}
}
