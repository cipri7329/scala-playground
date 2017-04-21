trait Generator[+T] {
	self => 	// an alias for "this"

	def generate: T

	def map[S](f: T => S): Generator[S] = new Generator[S]{
		def generate = f(self.generate)
	}

	def flatMap[S](f: T => Generator[S]): Generator[S] = new Generator[S] {
		def generate = f(self.generate).generate
	}
}

// variant 1

val integers = new Generator[Int] {
	val rand = new java.util.Random
	def generate = rand.nextInt()
}


val booleans = new Generator[Boolean] {
	def generate = integers.generate > 0
}

val pairs = new Generator[(Int, Int)]{
	def generate = (integers.generate, integers.generate)
}


// variant 2

val booleans2 = for (x <- integers) yield x > 0

val booleans3 = integers map (x => x > 0)


def pairs2[T, U](t: Generator[T], u: Generator[U]) = for {
	x <- t
	y <- u
} yield (x, y)

def pairs3[T, U](t: Generator[T], u: Generator[U]) = t flatMap (x => u map (y => (x, y)))




def single[T](x: T): Generator[T] = new Generator[T]{
	def generate = x
}

def choose(lo: Int, hi: Int): Generator[Int] = 
	for (x <- integers) yield lo + x % (hi - lo)

def oneOf[T](xs: T*): Generator[T] = 
	for(idx <- choose(0, xs.length)) yield xs(idx)

// oneOf(red, blue, yellow)


// RANDOM LISTS

def lists: Generator[List[Int]] = for {
	isEmpty <- booleans
	list <- if (isEmpty) emptyLists else nonEmptyLists
} yield list

def emptyLists = single(Nil)


def nonEmptyLists = for {
	head <- integers
	tail <- lists
} yield head :: tail



// RANDOM TREES

trait Tree

case class Inner(left: Tree, right: Tree) extends Tree

case class Leaf(x: Int) extends Tree


def leafs: Generator[Leaf] = for {
	x <- integers
} yield Leaf(x)


def inners: Generator[Inner] = for {
	l <- trees
	r <- trees
} yield Inner(l, r)


def trees: Generator[Tree] = for {
	isLeaf <- booleans
	tree <- if (isLeaf) leafs else inners
} yield tree


tree.generate


// Random Test Function

def test[T](g: Generator[T], numTimes: Int = 100)
	(test: T => Boolean): Unit = {
		for (i <- 0 until numTimes){
			val value = g.generate
			assert(test(value), "test failed for " + value)
		}
		println("passed " + numTimes +" tests")
	}

//example usage
test(pairs(lists, lists)){
	case (xs, ys) => (xs ++ ys).length > xs.length
}


//TODO: read about ScalaCheck tool







