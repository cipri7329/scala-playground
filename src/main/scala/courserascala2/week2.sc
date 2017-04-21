val level =
   """ST
          |oo
          |oo""".stripMargin

val levelVector = level.split('\n').toVector.map( a => a.toVector)

/**
* The resulting function should return `true` if the position `pos` is
  * a valid position (not a '-' character) inside the terrain described
* by `levelVector`.
  */
def terrainFunction(levelVector: Vector[Vector[Char]]): Pos => Boolean = ???


