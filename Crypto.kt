package com.example.kotlinbasics
// this is kotlin version of my cryptography project

const val key = 12 // it should not be Prime
const val arraySize = 31
fun main() {   

    println()
    println("****--> WELCOME TO MASSAGE ENCODER PROGRAM <--****")
    println("to use app enter one of this numbers: ")

    var state = true
    do { 
        println()
        println("\t1 --> encode text")
        println("\t2 --> decode text")
        println("\t3 --> EXIT")
        val input = readLine()?.toInt()
        when(input){
            1 -> {
                println("enter text you want be coded: ")
                println()
                val s0 = readLine()!!
                print("this is coded text: ")
                println("#${encoder(s0)}#")
                println()
            }
            2 -> {
                println("enter coded text to decode: ")
                println()
                val s0 = readLine()!!
                print("this is your decoded text: \t")
                print("#${decoder(s0)}#")
                println()
            }
            3 -> {
                print("You Have Exited...")
                state = false
            }
            else -> println("please enter a valid number!")

        }


    } while(state)
}
fun encoder(input: String):String{
    var result = ""
    var prevCode = 0
    var temp: Char
    for (element in input){
        temp = charEncoder(element, prevCode, key, arraySize)
        result += temp
        prevCode = num(temp)
    }
    return result
}
fun decoder(input: String):String{
    var result = ""
    var prevCode = 0
    var temp: Char
    for (i in input.indices){
        temp = charDecoder(input[i], prevCode, key, arraySize)
        result += temp
        prevCode = num(input[i])
    }
    return result
}

fun charEncoder(element: Char, prev: Int, machineCode: Int, arrayLength: Int): Char{
    var x: Long = 0
    for (i in 0 until arrayLength)
        if(i == num(element.uppercaseChar()))
            x = i.toLong()
    return Ch(((x+(machineCode * x) + prev)% arraySize).toInt())
}
fun charDecoder(element: Char, past: Int, machineCode: Int, arrayLength: Int): Char{
    var x = 0
    for (i in 0 until arrayLength){
        if((i+machineCode*i+past)%arrayLength == num(element.uppercaseChar())){
            x = i
        }
    }
    return Ch(x).lowercaseChar()
}

fun num(c: Char): Int{
    val ch = arrayOfNulls<Char>(arraySize)
    ch[0] = 'A'
    ch[1] = 'B'
    ch[2] = 'C'
    ch[3] = 'D'
    ch[4] = 'E'
    ch[5] = 'F'
    ch[6] = 'G'
    ch[7] = 'H'
    ch[8] = 'I'
    ch[9] = 'J'
    ch[10] = 'K'
    ch[11] = 'L'
    ch[12] = 'M'
    ch[13] = 'N'
    ch[14] = 'O'
    ch[15] = 'P'
    ch[16] = 'Q'
    ch[17] = 'R'
    ch[18] = 'S'
    ch[19] = 'T'
    ch[20] = 'U'
    ch[21] = 'V'
    ch[22] = 'W'
    ch[23] = 'X'
    ch[24] = 'Y'
    ch[25] = 'Z'
    ch[26] = ' '
    ch[27] = '.'
    ch[28] = ','
    ch[29] = ';'
    ch[30] = '-'
    for (i in ch.indices){
        if(ch[i] == c)
            return i
    }
    return -1
}
fun Ch(num: Int): Char{
    val ch = arrayOfNulls<Char>(arraySize)
    ch[0] = 'A'
    ch[1] = 'B'
    ch[2] = 'C'
    ch[3] = 'D'
    ch[4] = 'E'
    ch[5] = 'F'
    ch[6] = 'G'
    ch[7] = 'H'
    ch[8] = 'I'
    ch[9] = 'J'
    ch[10] = 'K'
    ch[11] = 'L'
    ch[12] = 'M'
    ch[13] = 'N'
    ch[14] = 'O'
    ch[15] = 'P'
    ch[16] = 'Q'
    ch[17] = 'R'
    ch[18] = 'S'
    ch[19] = 'T'
    ch[20] = 'U'
    ch[21] = 'V'
    ch[22] = 'W'
    ch[23] = 'X'
    ch[24] = 'Y'
    ch[25] = 'Z'
    ch[26] = ' '
    ch[27] = '.'
    ch[28] = ','
    ch[29] = ';'
    ch[30] = '-'
    return ch[num]!!
}

