/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jairi
 */
public class test {
    public static void main(String[] args) {
        String data = "4& hola1 &6& hola2 &9& hola3 &8& hola4 &7& hola5 &";
        Object[] datas = data.split("&");
        int it = datas.length;
        for(int i = 0; i<it;i+=2){
            int op = Integer.valueOf((String) datas[i]);
            System.out.println("op: " + op);
        }
    }
}
