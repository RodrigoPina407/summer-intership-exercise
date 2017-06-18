package com.premiumminds.internship.motionblur

import java.util.concurrent.Executors
import concurrent.ExecutionContext
import concurrent.Future
import concurrent.Await
import scala.concurrent.duration._
import scala.math

/**
  * Created by acamilo on 18-04-2016.
  */
trait MotionBlurFactory {
  /**
    * Method to start processing the data
    * @param data matrix of integers
    * @param numberOfWorkers number of threads that should work in parallel
    * @return matrix of integers
    */
  def run(data: Seq[Seq[Int]], numberOfWorkers: Int): Future[Seq[Seq[Int]]]
}
