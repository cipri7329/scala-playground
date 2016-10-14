/**
  * Created by p3700703 on 10/12/16.
  */
object ScalaApp {

  def main(args: Array[String]): Unit = {

//    this.string_op1(args)

    val name = "cipri"
    println(f"name is $name")

    println(concateStrings("x", "y", "z"))
    println(concateStrings("x", "y"))
    println(concateStrings("x"))

  }


  def concateStrings(first: String = "a", second: String = "b", third: String = "c"): String = first + second + third

  def string_op2() : Unit = {

    val str = "here|are|more|values|movie1|movie2|movie2|movie3";


    println(str);
    println()
    val arraySplit = str.split('|')

    arraySplit.foreach(x => print(x + " "))

    val elements = arraySplit.toList

    println()
    println(elements)

    println(str.split('|').toList)
  }

  def string_op1(args:Array[String]) : Unit = {

    val str = "here|are|more|values|";


    println(str);
    println()
    val arraySplit = str.split('|')

    arraySplit.foreach(x => print(x + " "))

    val elements = arraySplit.toList

    println()
    println(elements)

    println(str.split('|').toList)
  }

}
