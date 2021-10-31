/*
 * semanticcms-autogit-model - SemanticCMS automatic Git.
 * Copyright (C) 2016, 2020  AO Industries, Inc.
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
 * From man git-status
 */
public enum Meaning {
	// Uncommitted changes
	Modified("Modified", State.UNCOMMITTED_CHANGES, Change.Modified),
	Deleted("Deleted", State.UNCOMMITTED_CHANGES, Change.Deleted),
	UpdatedInIndex("Updated in index", State.UNCOMMITTED_CHANGES, Change.Modified),
	AddedToIndex("Added to index", State.UNCOMMITTED_CHANGES, Change.Added),
	DeletedFromIndex("Deleted from index", State.UNCOMMITTED_CHANGES, Change.Deleted),
	RenamedInIndex("Renamed in index", State.UNCOMMITTED_CHANGES, Change.Modified),
	CopiedInIndex("Copied in index", State.UNCOMMITTED_CHANGES, Change.Added),
	IndexAndWorkingTreeMatches("Index and working tree matches", State.UNCOMMITTED_CHANGES, Change.Modified),
	WorkTreeChangedSinceIndex("Work tree changed since index", State.UNCOMMITTED_CHANGES, Change.Modified),
	DeletedInWorkTree("Deleted in work tree", State.UNCOMMITTED_CHANGES, Change.Deleted),
	// Unmerged
	UnmergedBothDeleted("Unmerged, both deleted", State.UNMERGED, Change.Unmerged),
	UnmergedAddedByUs("Unmerged, added by us", State.UNMERGED, Change.Unmerged),
	UnmergedDeletedByThem("Unmerged, deleted by them", State.UNMERGED, Change.Unmerged),
	UnmergedAddedByThem("Unmerged, added by them", State.UNMERGED, Change.Unmerged),
	UnmergedDeletedByUs("Unmerged, deleted by us", State.UNMERGED, Change.Unmerged),
	UnmergedBothAdded("Unmerged, both added", State.UNMERGED, Change.Unmerged),
	UnmergedBothModified("Unmerged, both modified", State.UNMERGED, Change.Unmerged),
	// Others
	Untracked("Untracked", State.UNCOMMITTED_CHANGES, Change.Added),
	Ignored("Ignored", State.SYNCHRONIZED, Change.Ignored);

	private final String toString;
	private final State state;
	private final Change change;

	private Meaning(String toString, State state, Change change) {
		this.toString = toString;
		this.state = state;
		this.change = change;
	}

	@Override
	public String toString() {
		return toString;
	}

	public State getState() {
		return state;
	}

	public Change getChange() {
		return change;
	}

	static Meaning getMeaning(char x, char y) {
		//           [MD]   not updated
		if(x==' ' && y=='M') return Modified;
		if(x==' ' && y=='D') return Deleted;

		// M        [ MD]   updated in index
		if(x=='M' && (y==' ' || y=='M' || y=='D')) return UpdatedInIndex;

		// A        [ MD]   added to index
		if(x=='A' && (y==' ' || y=='M' || y=='D')) return AddedToIndex;

		// D         [ M]   deleted from index
		if(x=='D' && (y==' ' || y=='M')) return DeletedFromIndex;

		// R        [ MD]   renamed in index
		if(x=='R' && (y==' ' || y=='M' || y=='D')) return RenamedInIndex;

		// C        [ MD]   copied in index
		if(x=='C' && (y==' ' || y=='M' || y=='D')) return CopiedInIndex;

		// [MARC]           index and work tree matches
		if((x=='M' || x=='A' || x=='R' || x=='C') && y==' ') return IndexAndWorkingTreeMatches;

		// [ MARC]     M    work tree changed since index
		if((x==' ' || x=='M' || x=='A' || x=='R' || x=='C') && y=='M') return WorkTreeChangedSinceIndex;

		// [ MARC]     D    deleted in work tree
		if((x==' ' || x=='M' || x=='A' || x=='R' || x=='C') && y=='D') return DeletedInWorkTree;

		// D           D    unmerged, both deleted
		if(x=='D' && y=='D') return UnmergedBothDeleted;

		// A           U    unmerged, added by us
		if(x=='A' && y=='U') return UnmergedAddedByUs;

		// U           D    unmerged, deleted by them
		if(x=='U' && y=='D') return UnmergedDeletedByThem;

		// U           A    unmerged, added by them
		if(x=='U' && y=='A') return UnmergedAddedByThem;

		// D           U    unmerged, deleted by us
		if(x=='D' && y=='U') return UnmergedDeletedByUs;

		// A           A    unmerged, both added
		if(x=='A' && y=='A') return UnmergedBothAdded;

		// U           U    unmerged, both modified
		if(x=='U' && y=='U') return UnmergedBothModified;

		// ?           ?    untracked
		if(x=='?' && y=='?') return Untracked;

		// !           !    ignored
		if(x=='!' && y=='!') return Ignored;

		throw new IllegalArgumentException("Unexpected combination of 'x' and 'y': '" + x + "' and '" + y + '\'');
	}
}
