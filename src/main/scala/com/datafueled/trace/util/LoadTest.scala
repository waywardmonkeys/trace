/*
 * Copyright 2009 Data Fueled
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.datafueled.trace.util

import java.util.concurrent.CountDownLatch
import scala.collection.mutable.ListBuffer

package object loadtest {
  def repeat[R](iterationCount: Int, threadCount: Int = 1)(f: => R) {
    if (threadCount == 1) {
      repeatTimes(iterationCount)(f)
    } else {
      repeatTimesWithThreads(iterationCount, threadCount)(f)
    }
  }

  def repeatTimes[R](iterationCount: Int)(f: => R) {
    for (i <- 1 to iterationCount) {
    }
  }

  def repeatTimesWithThreads[R](iterationCount: Int, threadCount: Int)(f: => R) {
    val iterationCounter = new CountDownLatch(iterationCount * threadCount)
    val threads = new ListBuffer[Thread]()
    for (i <- 1 to threadCount) {
      threads += new Thread {
        override def run() {
          repeatTimes(iterationCount)(f)
          iterationCounter.countDown()
        }
      }
    }

    threads.foreach(thread => thread.start())
    threads.foreach(thread => thread.join())
    iterationCounter.await()
  }
}

