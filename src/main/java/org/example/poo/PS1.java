package org.example.poo;

import org.testng.annotations.Test;

public class PS1 extends  PS{

    @Test
    public void runMensajes(){
        PS2 ps2 = new PS2(4);
        System.out.println(ps2.increment());
        System.out.println(ps2.decrement());
        System.out.println(ps2.multiplicarx3());
        System.out.println(ps2.multiplicarx2());
        mensajes();
    }
}
