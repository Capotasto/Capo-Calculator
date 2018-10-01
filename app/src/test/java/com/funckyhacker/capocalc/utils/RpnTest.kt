package com.funckyhacker.capocalc.utils

import org.junit.Test

class RpnTest {
    
    @Test
    fun testGetRpn(){
        //("a+(b*c)") == "abc*+")
        val deque1 = Rpn.getRpn("123+(23*2)")
        assert(deque1.size == 5)
        assert(deque1.removeFirst() == "+")
        assert(deque1.removeFirst() == "*")
        assert(deque1.removeFirst() == "2")
        assert(deque1.removeFirst() == "23")
        assert(deque1.removeFirst() == "123")

        //(a+b)*c -> ab+c*
        val deque2 = Rpn.getRpn("(123+23)*2")
        assert(deque2.size == 5)
        assert(deque2.removeFirst() == "*")
        assert(deque2.removeFirst() == "2")
        assert(deque2.removeFirst() == "+")
        assert(deque2.removeFirst() == "23")
        assert(deque2.removeFirst() == "123")

        //a*b+c*d+e*f -> ab*cd*ef*++
        val deque3 = Rpn.getRpn("10*10+10*10+10*10")
        assert(deque3.size == 11)
        assert(deque3.removeFirst() == "+")
        assert(deque3.removeFirst() == "+")
        assert(deque3.removeFirst() == "*")
        assert(deque3.removeFirst() == "10")
        assert(deque3.removeFirst() == "10")
        assert(deque3.removeFirst() == "*")
        assert(deque3.removeFirst() == "10")
        assert(deque3.removeFirst() == "10")
        assert(deque3.removeFirst() == "*")
        assert(deque3.removeFirst() == "10")
        assert(deque3.removeFirst() == "10")

        //((a+b)*(c+d)+e)*f -> ab+cd+*e+f*
        val deque4 = Rpn.getRpn("((10+10)*(10+10)+10)*10")
        assert(deque4.size == 11)
        assert(deque4.removeFirst() == "*")
        assert(deque4.removeFirst() == "10")
        assert(deque4.removeFirst() == "+")
        assert(deque4.removeFirst() == "10")
        assert(deque4.removeFirst() == "*")
        assert(deque4.removeFirst() == "+")
        assert(deque4.removeFirst() == "10")
        assert(deque4.removeFirst() == "10")
        assert(deque4.removeFirst() == "+")
        assert(deque4.removeFirst() == "10")
        assert(deque4.removeFirst() == "10")
    }

    @Test
    fun testCalc(){
        val deque1 = Rpn.getRpn("123+(23*2)")
        assert(Rpn.calc(deque1) == 169.toString())

        val deque2 = Rpn.getRpn("(123+23)*2")
        assert(Rpn.calc(deque2) == 292.toString())

        val deque3 = Rpn.getRpn("10*10+10*10+10*10")
        assert(Rpn.calc(deque3) == 300.toString())

        val deque4 = Rpn.getRpn("((10+10)*(10+10)+10)*10")
        assert(Rpn.calc(deque4) == 4100.toString())

    }
}
