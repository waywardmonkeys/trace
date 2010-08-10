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

package com.datafueled.trace.commands

import com.datafueled.trace.core.{Session, Sessions}
import java.util.UUID

class StartSession(val sessionID: UUID, val hostID: UUID, val baseTime: Long, val baseNanos: Long) {
  def execute() {
    Sessions.put(sessionID, new Session(sessionID, hostID, baseTime, baseNanos))
  }
}

