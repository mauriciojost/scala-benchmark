package org.mauritania.scalatest.result

import java.io.{File, FileWriter}

case class Reports(reports: List[Report]) {

  def save() = {
    import scala.sys.process._
    val logs: String = "report"
    val commitId: String = "git rev-parse HEAD".!!.substring(0, 10)
    val f = new File(logs, "after-" + commitId + ".log")
    if (!f.exists()) {
      f.createNewFile()
    }
    new FileWriter(f) {
      reports.foreach{rep =>
        append(rep.generateTable())
        append(rep.generateResultLine())
      }
      close()
    }
    this
  }


}
