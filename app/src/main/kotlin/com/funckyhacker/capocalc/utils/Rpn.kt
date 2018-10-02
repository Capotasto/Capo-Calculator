package com.funckyhacker.capocalc.utils

import android.support.annotation.NonNull
import java.math.BigDecimal
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

            formula.forEachIndexed { index, it ->
                when(it){
                    '+', '-' -> {
                        if(index == 0) {
                            tempNumber = it.toString()
                            return@forEachIndexed
                        }

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
                    '0','1','2','3','4','5','6','7','8','9', '.' -> {
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

            var x: Double
            var y: Double
            val list = rpnDeque.toList().reversed()

            list.forEach {
                when(it){
                    "+" -> {
                        x = deque.removeFirst().toString().toDouble()
                        y = deque.removeFirst().toString().toDouble()
                        deque.addFirst(format(x + y))
                    }
                    "-" -> {
                        x = deque.removeFirst().toString().toDouble()
                        y = deque.removeFirst().toString().toDouble()
                        deque.addFirst(format(y - x))
                    }
                    "*" -> {
                        x = deque.removeFirst().toString().toDouble()
                        y = deque.removeFirst().toString().toDouble()
                        deque.addFirst(format(x * y))
                    }
                    "/" -> {
                        x = deque.removeFirst().toString().toDouble()
                        y = deque.removeFirst().toString().toDouble()
                        if (y == 0.0) {
                            return "Error"
                        }
                        deque.addFirst(format(x / y))
                    }
                    else -> {
                        deque.addFirst(it.toString())
                    }
                }
            }
            return  deque.removeFirst().toString()
        }

        private fun format(number: Double): String {
            val bigDecimal = BigDecimal(number)
            if (bigDecimal.stripTrailingZeros().scale() <= 0) {
                return bigDecimal.stripTrailingZeros().toInt().toString()
            }
            return number.toString()
        }
    }
}
