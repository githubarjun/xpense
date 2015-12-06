package com.xpense.transaction.enums;

public enum ContributionType {

	EQUALCONTRIBUTION{
		@Override
		public String toString() {
			return "Equal Contribution";
		}
	},
	
	NONEQUALCONTRIBUTION{
		@Override
		public String toString() {
			return "Non Equal Contribution";
		}
	};
	
}
