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

package object attributes {
  class ClassName(initialValue: String = "") extends StringAttribute(initialValue) {
    val name = Symbol("ClassName")
  }
  object ClassName extends ClassName
  implicit def type2attr4ClassName() = ClassName

  class Duration(initialValue: Long = 0) extends LongAttribute(initialValue) {
    val name = Symbol("Duration")
  }
  object Duration extends Duration
  implicit def type2attr4Duration() = Duration

  class EndNanos(initialValue: Long = 0) extends LongAttribute(initialValue) {
    val name = Symbol("EndNanos")
  }
  object EndNanos extends EndNanos
  implicit def type2attr4EndNanos() = EndNanos

  class StartNanos(initialValue: Long = 0) extends LongAttribute(initialValue) {
    val name = Symbol("StartNanos")
  }
  object StartNanos extends StartNanos
  implicit def type2attr4StartNanos() = StartNanos

  class Text(initialValue: String = "") extends StringAttribute(initialValue) {
    val name = Symbol("Text")
  }
  object Text extends Text
  implicit def type2attr4Text() = Text

  class TimeStamp(initialValue: Long = 0) extends LongAttribute(initialValue) {
    val name = Symbol("TimeStamp")
  }
  object TimeStamp extends TimeStamp
  implicit def type2attr4TimeStamp() = TimeStamp
}

