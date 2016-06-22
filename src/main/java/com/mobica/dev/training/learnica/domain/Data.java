package com.mobica.dev.training.learnica.domain;


public class Data
{
   //Any number of final, static fields
   private String name;
   private String dataId;
   private String value;

   //Any number of abstract method declarations\
   public Data(Sting name,String dataId,String value){
     this.name = name;
     this.dataId = dataId;
     this.value = value;

   }

   public String getName(){
     return this.name;
   }
   public void setName(String name){
     this.name = name;
   }

   public String getDataId(){
      return this.dataId;
   }
   public void setDataId(String dataId){
     this.dataId = dataId;
   }
   public String getValue(){
      return this.value;
   }
   public void setValue(String value){
     this.value = value;
   }

}
