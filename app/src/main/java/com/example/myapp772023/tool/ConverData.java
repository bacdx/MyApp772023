package com.example.myapp772023.tool;

import java.util.ArrayList;

public class ConverData {
    String title;
    //chuoi sau khi cat title
    String converslip1=null;
// neu chi la 1 chuoi
ArrayList<ArrayList<String>> listRs=new ArrayList<>();
ArrayList<String> rs=new ArrayList<>();
    public ConverData(String data){
        setTitle(data);

        if(converslip1.contains(";")){;
            setListdata();
        }else {
            setdata();
        }
    }

    private void setTitle(String data){
         String[] rs=data.split("#");
         converslip1=rs[1];
         title=rs[0];

    }

    public String getTitle() {
        return this.title;
    }

    private void setListdata(){
        ArrayList<ArrayList<String>> rs=new ArrayList<>();

        int countColum=0;
        int countRow=0;
        String[] rs1=converslip1.split(";");
        if(rs1.length<=1){
            return ;
        }else{
            countColum= rs1.length;
            countRow=rs1[0].split(",").length;
            for (int i=0;i<=countColum;i++){
                ArrayList<String> element=new ArrayList<>();
                String[] rs2=rs1[i].split(",");
                for (int j=0;i<=countRow;j++){
                    element.add(rs2[j]);
                }
                rs.add(element);

            }
            listRs=rs;
        }


    }
    public ArrayList<ArrayList<String>> getListData(){
        return this.listRs;
    }

   private void  setdata(){
      String[] a =converslip1.split(",");
      ArrayList<String> list=new ArrayList<>();
      for (int i=0;i<=converslip1.length();i++){
          list.add(a[0]);
      }
      rs=list;
    }
    public  ArrayList<String>getData(){
        return this.rs;
    }
}
