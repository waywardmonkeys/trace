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

package com.datafueled.trace.core

import com.datafueled.trace.core.attributes._
import java.util.UUID

class Annotation protected(val id: UUID, val timestamp: Long) extends HasAttributes {
  override def getAttribute[A <: Attribute[_]](implicit type2attr: (() => A)) : Option[Attribute[_]] = {
    type2attr() match {
      case x : TimeStamp => Some(new TimeStamp(timestamp))
      case _ => super.getAttribute[A](type2attr)
    }
  }
}

object Annotation {
  def make(timestamp: Long) = new Annotation(UUID.randomUUID(), timestamp)
}

