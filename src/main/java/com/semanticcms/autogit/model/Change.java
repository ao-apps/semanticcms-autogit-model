/*
 * semanticcms-autogit-model - SemanticCMS automatic Git.
 * Copyright (C) 2016  AO Industries, Inc.
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
 * along with semanticcms-autogit-model.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.semanticcms.autogit.model;

/**
 * The type of change a meaning implies
 */
public enum Change {
	Ignored("gitChangeIgnored"),
	Unchanged("gitChangeUnchanged"),
	Added("gitChangeAdded"),
	Modified("gitChangeModified"),
	Deleted("gitChangeDeleted"),
	Unmerged("gitChangeUnmerged");

	private final String cssClass;

	private Change(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getCssClass() {
		return cssClass;
	}
}
