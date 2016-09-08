package org.mauritania.minibenchmark.reporting

case class VersusReportRow(
  algNameA: String,
  algNameB: String,
  durationA: Long,
  durationB: Long,
  ratio: Double
) {
  override def toString(): String = {
    this.productIterator.mkString(",")
  }
}

