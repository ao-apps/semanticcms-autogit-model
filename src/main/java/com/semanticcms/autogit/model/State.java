/*
 * semanticcms-autogit-model - SemanticCMS automatic Git.
 * Copyright (C) 2016, 2022  AO Industries, Inc.
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

/**
 * The states are ordered from least severe to highest.  The overall state
 * is the state of the highest individual change.
 */
public enum State {
  SYNCHRONIZED("Synchronized", "semanticcms-autogit-state-synchronized"),
  UNCOMMITTED_CHANGES("Uncommitted Changes", "semanticcms-autogit-state-uncommitted-changes"),
  UNMERGED("Unmerged", "semanticcms-autogit-state-unmerged"),
  DISABLED("Disabled", "semanticcms-autogit-state-disabled"),
  STARTING("Starting", "semanticcms-autogit-state-starting"),
  TIMEOUT("Timeout", "semanticcms-autogit-state-timeout"),
  PULL_FAILED("Pull Failed", "semanticcms-autogit-state-pull-failed"),
  PUSH_FAILED("Push Failed", "semanticcms-autogit-state-push-failed");

  private final String toString;
  private final String cssClass;

  private State(String toString, String cssClass) {
    this.toString = toString;
    this.cssClass = cssClass;
  }

  @Override
  public String toString() {
    return toString;
  }

  public String getCssClass() {
    return cssClass;
  }
}
