/*
 * Licensed to Metamarkets Group Inc. (Metamarkets) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. Metamarkets licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.druid.query.lookup;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Strings;

public class LookupConfig
{

  @JsonProperty
  private final String snapshotWorkingDir;

  /**
   * @param snapshotWorkingDir working directory to store lookups snapshot file, passing null or empty string will disable the snapshot utility
   */
  @JsonCreator
  public LookupConfig(
      @JsonProperty("snapshotWorkingDir") String snapshotWorkingDir
  )
  {
    this.snapshotWorkingDir = Strings.nullToEmpty(snapshotWorkingDir);
  }

  public String getSnapshotWorkingDir()
  {
    return snapshotWorkingDir;
  }


  @Override
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if (!(o instanceof LookupConfig)) {
      return false;
    }

    LookupConfig that = (LookupConfig) o;

    return getSnapshotWorkingDir().equals(that.getSnapshotWorkingDir());

  }

}