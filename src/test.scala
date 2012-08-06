package com.ayosec.tryneo

import org.neo4j.kernel.EmbeddedGraphDatabase

object test {

  def main(args: Array[String]) {
    val db = new EmbeddedGraphDatabase(args(0))

    var n = 0
    val nodeIterator = db.getAllNodes.iterator
    while(nodeIterator.hasNext) {
      nodeIterator.next
      n += 1
    }
    println(n + " nodes")

    db.shutdown
  }

}
