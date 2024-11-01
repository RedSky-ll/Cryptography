// this is kotlin version of my cryptography project

const val key = 12 // it should not be Prime
val ch = arrayOf(
    '-', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
    'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', '.', ',', ';', 'A',
    '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
)
val arraySize = ch.size

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
    for (i in 0..<arrayLength)
        if(i == num(element.uppercaseChar()))
            x = i.toLong()
    return Ch(((x+(machineCode * x) + prev)% arraySize).toInt())
}
fun charDecoder(element: Char, past: Int, machineCode: Int, arrayLength: Int): Char{
    var x = 0
    for (i in 0..<arrayLength){
        if((i+machineCode*i+past)%arrayLength == num(element.uppercaseChar())){
            x = i
        }
    }
    return Ch(x).lowercaseChar()
}

fun num(c: Char): Int{
    for (i in ch.indices){
        if(ch[i] == c)
            return i
    }
    return -1
}

fun Ch(num: Int): Char{
    return ch[num]!!
}

