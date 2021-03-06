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

package com.datafueled.trace.core.attributes

import scala.collection.mutable.HashMap

trait HasAttributes {
  private val attributes = HashMap[Symbol, Attribute[_]]()

  def getAttribute(attributeName: Attribute[_]) : Option[Attribute[_]] = {
    attributes.get(attributeName.name)
  }

  def getAttributeValue[A <: Attribute[_]](implicit type2attr: (() => A)) : Option[A#ValueType] = {
    val a = getAttribute(type2attr())
    if (a.isDefined) {
      Some(a.get.value)
    } else {
      None
    }
  }

  def getAttributeValue[A <: Attribute[_]](defaultValue: A#ValueType)(implicit type2attr: (() => A)) : A#ValueType = {
    val a = getAttribute(type2attr())
    if (a.isDefined) {
      a.get.value
    } else {
      defaultValue
    }
  }
}

