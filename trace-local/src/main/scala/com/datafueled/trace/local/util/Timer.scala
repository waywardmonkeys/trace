/*
 * Copyright 2010 Data Fueled
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

import com.datafueled.trace.core.datamodel.Span

class Timer(val parentSpan: Option[Span], val startTime: Long) {
  def stop : Span = {
    if (parentSpan.isDefined) {
      return Span.make(parentSpan.get.id, startTime, System.nanoTime())
    } else {
      return Span.make(startTime, System.nanoTime())
    }
  }
}

object Timer {
  def start = new Timer(None, System.nanoTime())
}
