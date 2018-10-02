// See Gaddis, Starting out with C++, Early Objects, Ninth Edition, Chapter 17.

fun displayList(l: List<*>) = l.forEach { print("$it ") }

val list = listOf(2.5, 7.9, 12.6)
println(list.joinToString(" "))

val range = (1..5)
val squareList = range.map { k -> k * k }
val cubeList = range.map { it * it * it }

var otherList = squareList
print("Result of the copy constructor is: ")
displayList(otherList); println()

otherList = cubeList
print("Result of assignment is: ")
displayList(otherList); println()
