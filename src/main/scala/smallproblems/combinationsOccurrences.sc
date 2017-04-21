//import forcomp.Anagrams.Occurrences
package small-problems;

/** A word is simply a `String`. */
type Word = String

/** A sentence is a `List` of words. */
type Sentence = List[Word]


/** `Occurrences` is a `List` of pairs of characters and positive integers saying
  *  how often the character appears.
  *  This list is sorted alphabetically w.r.t. to the character in each pair.
  *  All characters in the occurrence list are lowercase.
  *
  *  Any list of pairs of lowercase characters and their frequency which is not sorted
  *  is **not** an occurrence list.
  *
  *  Note: If the frequency of some character is zero, then that character should not be
  *  in the list.
  */
type Occurrences = List[(Char, Int)]

/** Returns the list of all subsets of the occurrence list.
  *  This includes the occurrence itself, i.e. `List(('k', 1), ('o', 1))`
  *  is a subset of `List(('k', 1), ('o', 1))`.
  *  It also include the empty subset `List()`.
  *
  *  Example: the subsets of the occurrence list `List(('a', 2), ('b', 2))` are:
  *
  *    List(
  *      List(),
  *      List(('a', 1)),
  *      List(('a', 2)),
  *      List(('b', 1)),
  *      List(('a', 1), ('b', 1)),
  *      List(('a', 2), ('b', 1)),
  *      List(('b', 2)),
  *      List(('a', 1), ('b', 2)),
  *      List(('a', 2), ('b', 2))
  *    )
  *
  *  Note that the order of the occurrence list subsets does not matter -- the subsets
  *  in the example above could have been displayed in some other order.
  */

val oc1 = List(('a', 2), ('b', 2))


def simpleSublist( p: (Char, Int)) : Set[(Char, Int)] = p match {
  case (char, ratio) =>
    if (ratio == 0) Set.empty
    else
      (for {
        i <- 1 to ratio
      } yield (char, i)).toSet
}

val sub1 = simpleSublist(oc1.head)
val sub2 = simpleSublist(('a', 0))

//def recursiveSublist(occurrences: Occurrences): List[Occurrences] = {
//
//  def recursiveSublist1(occurrences: Occurrences): List[Occurrences] = {
//    for {
//      ab: (Char, Int) <- occurrences
//      list1 <- simpleSublist(ab)
//      list2 <- recursiveSublist1(occurrences.tail)
//    } yield List(list1) :: List(list2)
//  }
//
//  recursiveSublist1(occurrences)
//}
//
//val test1 = recursiveSublist(oc1)


def combinations2(occurrences: Occurrences): List[Occurrences] =
  occurrences match {
    case List() => List(List())
    case head :: tail => {
      val tailCombinations = combinations2(tail)
      tailCombinations ++
        (for {
          o <- tailCombinations
          i <- 1 to head._2
        } yield (head._1, i) :: o)
    }
  }

val test2 = combinations2(oc1)

/** Returns the list of all subsets of the occurrence list.
  *  Example: the subsets of the occurrence list `List(('a', 2), ('b', 2))` are:
  *
  *    List(
  *      List(),
  *      List(('a', 1)),
  *      List(('a', 2)),
  *      List(('b', 1)),
  *      List(('a', 1), ('b', 1)),
  *      List(('a', 2), ('b', 1)),
  *      List(('b', 2)),
  *      List(('a', 1), ('b', 2)),
  *      List(('a', 2), ('b', 2))
  *    )
  */

val n = 5
val pairs1 = for {
  i <- 1 until n
  j <- 1 until i
} yield (i, j)

