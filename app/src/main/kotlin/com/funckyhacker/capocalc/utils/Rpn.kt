package com.funckyhacker.capocalc.utils

import android.support.annotation.NonNull
import java.util.*

class Rpn {

    companion object {

        @NonNull
        fun getRpn(formula: String): Deque<String> {

            val resultDeque = ArrayDeque<String>()

            if (formula == "") {
                return resultDeque
            }

            val deque = ArrayDeque<Char>()
            var tempNumber = ""

            formula.forEach {
                when(it){
                    '+', '-' -> {
                        if (tempNumber != "") {
                            resultDeque.addFirst(tempNumber)
                            tempNumber = ""
                        }

                        while (!deque.isEmpty()){
                            val c = deque.first
                            if (c == '*' || c == '/') {
                                resultDeque.addFirst(deque.removeFirst().toString())
                            } else {
                                break
                            }
                        }
                        deque.addFirst(it)
                    }
                    '*', '/' -> {
                        if (tempNumber != "") {
                            resultDeque.addFirst(tempNumber)
                            tempNumber = ""
                        }
                        deque.addFirst(it)
                    }
                    '(' -> deque.addFirst(it)
                    ')' -> {
                        val list = deque.toList()
                        val index = list.indexOf('(')

                        val workDeque = ArrayDeque<Char>()
                        for (i in 0..index) {
                            val c = deque.removeFirst()
                            if (c != '(') {
                                workDeque.addFirst(c)
                            }
                        }
                        if (tempNumber != "") {
                            resultDeque.addFirst(tempNumber)
                            tempNumber = ""
                        }
                        while (!workDeque.isEmpty()) {
                            resultDeque.addFirst(workDeque.removeFirst().toString())
                        }
                    }
                    '0','1','2','3','4','5','6','7','8','9' -> {
                        tempNumber += it
                    }
                }

            }

            if (tempNumber != "") {
                resultDeque.addFirst(tempNumber)
                tempNumber = ""
            }
            while (!deque.isEmpty()) {
                resultDeque.addFirst(deque.removeFirst().toString())
            }

            return resultDeque
        }

        fun calc(rpnDeque: Deque<String>): String{
            val deque = ArrayDeque<String>()

            var x: Int
            var y: Int
            val list = rpnDeque.toList().reversed()

            list.forEach {
                when(it){
                    "+" -> {
                        x = deque.removeFirst().toString().toInt()
                        y = deque.removeFirst().toString().toInt()
                        deque.addFirst((x + y).toString())
                    }
                    "-" -> {
                        x = deque.removeFirst().toString().toInt()
                        y = deque.removeFirst().toString().toInt()
                        deque.addFirst((y - x).toString())
                    }
                    "*" -> {
                        x = deque.removeFirst().toString().toInt()
                        y = deque.removeFirst().toString().toInt()
                        deque.addFirst((x * y).toString())
                    }
                    "/" -> {
                        x = deque.removeFirst().toString().toInt()
                        y = deque.removeFirst().toString().toInt()
                        if (y == 0) {
                            return "Error"
                        }
                        deque.addFirst((x / y).toString())
                    }
                    else -> {
                        deque.addFirst(it.toString())
                    }
                }
            }
            return  deque.removeFirst().toString()
        }
    }
}
