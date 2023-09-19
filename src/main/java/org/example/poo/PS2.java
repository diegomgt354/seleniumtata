package org.example.poo;


public class PS2 extends  PS3 {

    int a;

    public PS2(int a){
        super(a);
        this.a = a;
    }

    public int increment(){
        return this.a++;
    }

        public int decrement(){
        return this.a--;
        }

}
