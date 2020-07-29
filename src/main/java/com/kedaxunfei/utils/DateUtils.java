package com.kedaxunfei.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static Date StringTODate (String date){
        Date date1=null;
       try{
           String pattern="yyyy-MM-dd HH:mm:ss";
           DateFormat dateFormat=   new SimpleDateFormat(pattern);
           date1= dateFormat.parse(date);
       }catch (ParseException o){
           o.printStackTrace();
       }
         return date1;
    }



}
