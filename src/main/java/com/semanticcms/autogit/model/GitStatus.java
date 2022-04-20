/*
 * semanticcms-autogit-model - SemanticCMS automatic Git.
 * Copyright (C) 2016, 2020, 2022  AO Industries, Inc.
 *     support@aoindustries.com
 *     7262 Bull Pen Cir
 *     Mobile, AL 36695
 *
 * This file is part of semanticcms-autogit-model.
 *
 * semanticcms-autogit-model is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * semanticcms-autogit-model is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with semanticcms-autogit-model.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.semanticcms.autogit.model;

// Java 1.8: import java.time.Instant;
import java.util.List;

/**
 * The Git status at a given moment in time.
 */
public class GitStatus {

  // Java 1.8: private final Instant statusTime;
  private final long statusTime;
  private final State state;
  private final List<UncommittedChange> uncommittedChanges;

  /**
   * @param  uncommittedChanges  Must be unmodifiable, no additional defensive copy is performed
   */
  public GitStatus(
    // Java 1.8: Instant statusTime,
    long statusTime,
    State state,
    List<UncommittedChange> uncommittedChanges
  ) {
    this.statusTime = statusTime;
    this.state = state;
    this.uncommittedChanges = uncommittedChanges;
  }

  // Java 1.8: public Instant getStatusTime() {
  public long getStatusTime() {
    return statusTime;
  }

  public State getState() {
    return state;
  }

  @SuppressWarnings("ReturnOfCollectionOrArrayField") // Returning unmodifiable
  public List<UncommittedChange> getUncommittedChanges() {
    return uncommittedChanges;
  }
}
