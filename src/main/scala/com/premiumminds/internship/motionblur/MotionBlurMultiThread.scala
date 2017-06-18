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
object MotionBlurMultiThread extends MotionBlurFactory {
  /**
    * Method to start processing the data, this one should work in parallel
    * @param data matrix of integers
    * @param numberOfWorkers number of threads that should work in parallel
    * @return matrix of integers
    */
  override def run(data: Seq[Seq[Int]], numberOfWorkers: Int):Future[Seq[Seq[Int]]] = {
    
    
     var tempData : Float= 0
     var count = 1
 
     
	   implicit val executionContext = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(numberOfWorkers))
	   
	
	def calculo(): Seq[Seq[Int]]={
       
   val R = (0 until data.length).par.map { i =>
  (0 until data(0).length).par.map { j =>

    val tempList = List(Some(data(i)(j)), boundVer(i - 1, j), boundVer(i, j - 1), boundVer(i + 1, j)).flatten
    math.ceil(tempList.sum / tempList.length).toInt
  }.seq
}.seq
    return R
   }
   
    def boundVer(i:Int, j:Int): Option[Int] ={
      
      if((i<0)|| (j<0) || (i>data.length-1))
        None
        
      else{
		   Some(data(i)(j))
        }
      
      }
    
	val future:Future[Seq[Seq[Int]]] = Future{ calculo }
    return future

	  }
 
    
  }
