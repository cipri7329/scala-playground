/**
  * Created by p3700703 on 10/12/16.
  */
object ScalaApp {

  def main(args: Array[String]): Unit = {

    listSample()

  }

  def listSample() : Unit = {

    var list : List[Int] = List(1,2,3,4, 5)

    println(list)

    //append
    val list2 = list :+ 6;

    println(list)
    println(list2)

  }

  def concateStrings(first: String = "a", second: String = "b", third: String = "c"): String = first + second + third

  def string_op2() : Unit = {

    val str = "here|are|more|values|movie1|movie2|movie2|movie3";

    val name = "cipri"
    println(f"name is $name")


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
