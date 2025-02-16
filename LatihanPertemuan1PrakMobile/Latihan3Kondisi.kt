fun main() {
    var umur: Int = 25 
     if (umur >= 18) {
   		println("Anda sudah Dewasa")
	} else {
     	println("Anda belum Dewasa")
 	}
}



fun main() {
    when (umur) {
        0..17 -> println("Anda masih anak-anak")
        else -> println("Anda sudah dewasa")
    }
}