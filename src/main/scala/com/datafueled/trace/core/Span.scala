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

package com.datafueled.trace.core

import java.util.UUID

class Span(val id: UUID, val parentID: Option[UUID], val startTime: Long, val endTime: Long) {
  var annotations: List[Annotation] = Nil
  var children: List[Span] = Nil

  def duration = endTime - startTime
}

object Span {
  def make(startTime: Long, endTime: Long) = new Span(UUID.randomUUID(), None, startTime, endTime)
  def make(parentID: UUID, startTime: Long, endTime: Long) = new Span(UUID.randomUUID(), Some(parentID), startTime, endTime)
  def make(id: UUID, parentID: UUID, startTime: Long, endTime: Long) = new Span(id, Some(parentID), startTime, endTime)
}

