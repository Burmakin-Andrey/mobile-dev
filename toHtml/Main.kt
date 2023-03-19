data class Message(val address: String?, val topic: String?, val surname: String?, val name: String?) {
}

fun Message.toHTML(): String {
    var template : String = ""
    template += "<table> \n"

    address?.let {
        template +=  "\t <tr><td>address</td><td>$it</td></tr> \n"
    }
    topic?.let{
        template += "\t <tr><td>topic</td><td>$it</td></tr> \n"
    }
    surname?.let{
        template += "\t <tr><td>surname</td><td>$it</td></tr> \n"
    }
    name?.let{
        template += "\t <tr><td>name</td><td>$it</td></tr> \n"
    }

    template += "<table>"
    return template
}

fun main() {
    val m = Message("askbill@microsoft.com", null, null, "Daniil")
    println(m.toHTML())
}