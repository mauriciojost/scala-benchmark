package org.mauritania.minibenchmark.reporting

import java.io.File
import sys.process._

object ReportFile {

  val LogsDirectory: String = "report"

  def reportFile() = {
    val commitId: String = "git rev-parse HEAD".!!.substring(0, 10)
    new File(LogsDirectory, "after-" + commitId + ".log")
  }

}
