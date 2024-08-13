package com.cns.psm.entities;

public enum ProjectStatus {
	PRE(0), START(1), END(2);

	private final int statusCode;

	ProjectStatus(int statusCode) {
		this.statusCode = statusCode;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public static ProjectStatus fromStatusCode(int statusCode) {
		for (ProjectStatus status : values()) {
			if (status.statusCode == statusCode) {
				return status;
			}
		}
		throw new IllegalArgumentException("Invalid status code: " + statusCode);
	}

}
