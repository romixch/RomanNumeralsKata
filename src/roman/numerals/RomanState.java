/**
 * File Name: RomanState.java
 * 
 * Copyright (c) 2014 BISON Schweiz AG, All Rights Reserved.
 */

package roman.numerals;

/**
 * TODO:peter.zurkirchen Auto-generated comment for class
 * 
 * @author peter.zurkirchen
 */
public enum RomanState {

	Init(0) {
		@Override
		public RomanState getNextState(RomanChar c) {
			switch (c) {
			case I:
			case V:
			case X:
			case L:
			case C:
			case D:
			case M:
				return RomanState.valueOf(String.valueOf(c));
			}
			return INVALID_CHARACTER;
		}
	},

	I_(-1) {
		@Override
		public RomanState getNextState(RomanChar c) {
			switch (c) {
			case V:
			case X:
			case L:
			case C:
			case D:
			case M:
				return RomanState.valueOf(String.valueOf(c));
			case I:
			}
			return INVALID_CHARACTER;
		}
	},

	I(1) {
		@Override
		public RomanState getNextState(RomanChar c) {
			switch (c) {
			case I:
				return II;
			case V:
			case L:
			case X:
			case C:
			case D:
			case M:
				return RomanState.valueOf(String.valueOf(c));
			}
			return INVALID_CHARACTER;
		}
	},

	II(1) {
		@Override
		public RomanState getNextState(RomanChar c) {
			switch (c) {
			case I:
				return III;
			case V:
			case X:
			case L:
			case C:
			case D:
			case M:
				return RomanState.valueOf(String.valueOf(c));
			}
			return INVALID_CHARACTER;
		}
	},

	III(1) {
		@Override
		public RomanState getNextState(RomanChar c) {
			switch (c) {
			case V:
			case X:
			case L:
			case C:
			case D:
			case M:
				return RomanState.valueOf(String.valueOf(c));
			case I:
				return INVALID_REPETITION;
			}
			return INVALID_CHARACTER;
		}
	},

	V(5) {
		@Override
		public RomanState getNextState(RomanChar c) {
			switch (c) {
			case I:
				return I_;
			case C:
			case D:
			case L:
			case X:
			case M:
				return RomanState.valueOf(String.valueOf(c));
			case V:
				return INVALID_REPETITION;
			}
			return INVALID_CHARACTER;
		}
	},

	X(10) {
		@Override
		public RomanState getNextState(RomanChar c) {
			switch (c) {
			case X:
				return XX;
			case I:
				return I_;
			case V:
			case L:
			case C:
			case D:
			case M:
				return RomanState.valueOf(String.valueOf(c));
			}
			return INVALID_CHARACTER;
		}
	},

	X_(-10) {
		@Override
		public RomanState getNextState(RomanChar c) {
			switch (c) {
			case C:
			case D:
			case M:
				return RomanState.valueOf(String.valueOf(c));
			case X:
			case I:
			case L:
			case V:
				return VALID_CHARACTER_AT_WRONG_POSITION;
			}
			return INVALID_CHARACTER;
		}
	},

	XX(10) {
		@Override
		public RomanState getNextState(RomanChar c) {
			switch (c) {
			case X:
				return XXX;
			case I:
			case V:
			case L:
			case C:
			case D:
			case M:
				return RomanState.valueOf(String.valueOf(c));
			}
			return INVALID_CHARACTER;
		}
	},

	XXX(10) {
		@Override
		public RomanState getNextState(RomanChar c) {
			switch (c) {
			case L:
			case C:
			case D:
			case M:
				return RomanState.valueOf(String.valueOf(c));
			case X:
				return INVALID_REPETITION;
			case I:
			case V:
				return VALID_CHARACTER_AT_WRONG_POSITION;
			}
			return INVALID_CHARACTER;
		}
	},

	L(50) {
		@Override
		public RomanState getNextState(RomanChar c) {
			switch (c) {
			case V:
			case X:
				return X_;
			case C:
			case D:
			case M:
				return RomanState.valueOf(String.valueOf(c));
			case L:
				return INVALID_REPETITION;
			case I:
				return VALID_CHARACTER_AT_WRONG_POSITION;
			}
			return INVALID_CHARACTER;
		}
	},

	C_(-100) {
		@Override
		public RomanState getNextState(RomanChar c) {
			switch (c) {
			case M:
				return RomanState.valueOf(String.valueOf(c));
			case I:
			case V:
			case X:
			case L:
			case C:
			case D:
				return VALID_CHARACTER_AT_WRONG_POSITION;
			}
			return INVALID_CHARACTER;
		}
	},

	C(100) {
		@Override
		public RomanState getNextState(RomanChar c) {
			switch (c) {
			case C:
				return CC;
			case V:
			case L:
			case X:
				return X_;
			case D:
			case M:
				return RomanState.valueOf(String.valueOf(c));
			case I:
				return VALID_CHARACTER_AT_WRONG_POSITION;
			}
			return INVALID_CHARACTER;
		}
	},

	CC(100) {
		@Override
		public RomanState getNextState(RomanChar c) {
			switch (c) {
			case C:
				return CCC;
			case I:
				return VALID_CHARACTER_AT_WRONG_POSITION;
			case X:
			case V:
			case L:
			case D:
			case M:
				return RomanState.valueOf(String.valueOf(c));
			}
			return INVALID_CHARACTER;
		}
	},

	CCC(100) {
		@Override
		public RomanState getNextState(RomanChar c) {
			switch (c) {
			case D:
			case M:
				return RomanState.valueOf(String.valueOf(c));
			case C:
				return INVALID_REPETITION;
			case I:
			case V:
			case X:
			case L:
				return VALID_CHARACTER_AT_WRONG_POSITION;
			}
			return INVALID_CHARACTER;
		}
	},

	D(500) {
		@Override
		public RomanState getNextState(RomanChar c) {
			switch (c) {
			case M:
				return RomanState.valueOf(String.valueOf(c));
			case C:
				return C_;
			case D:
				return INVALID_REPETITION;
			case I:
			case V:
			case X:
			case L:
				return VALID_CHARACTER_AT_WRONG_POSITION;
			}
			return INVALID_CHARACTER;
		}
	},

	M(1000) {
		@Override
		public RomanState getNextState(RomanChar c) {
			switch (c) {
			case M:
				return MM;
			case C:
				return C_;
			case V:
			case L:
			case D:
				return RomanState.valueOf(String.valueOf(c));
			case X:
			case I:
				return VALID_CHARACTER_AT_WRONG_POSITION;
			}
			return INVALID_CHARACTER;
		}
	},

	MM(1000) {
		@Override
		public RomanState getNextState(RomanChar c) {
			switch (c) {
			case M:
				return MMM;
			case V:
			case L:
			case C:
			case D:
				return RomanState.valueOf(String.valueOf(c));
			case X:
			case I:
				return VALID_CHARACTER_AT_WRONG_POSITION;
			}
			return INVALID_CHARACTER;
		}
	},

	MMM(1000) {
		@Override
		public RomanState getNextState(RomanChar c) {
			switch (c) {
			case V:
			case L:
			case C:
			case D:
				return RomanState.valueOf(String.valueOf(c));
			case M:
				return INVALID_REPETITION;
			case X:
			case I:
				return VALID_CHARACTER_AT_WRONG_POSITION;
			}
			return INVALID_CHARACTER;
		}
	},

	VALID_CHARACTER_AT_WRONG_POSITION(0), INVALID_CHARACTER(0), INVALID_REPETITION(0);

	private final int value;

	private RomanState(int value) {
		this.value = value;
	}

	public RomanState transitFromRightToLeft(char c) {
		RomanChar romanChar = RomanChar.valueOf(String.valueOf(c));
		RomanState state = getNextState(romanChar);
		switch (state) {
		case VALID_CHARACTER_AT_WRONG_POSITION:
			throw new IllegalArgumentException(c + " can never be substracted from " + this.name());
		case INVALID_CHARACTER:
			throw new IllegalArgumentException("Digit " + c + " is not a valid Roman digit");
		case INVALID_REPETITION:
			throw new IllegalArgumentException(c + " repeated too many times.");
		default:
		}
		return state;
	}

	public RomanState getNextState(RomanChar c) {
		return null;
	}

	public int getValue() {
		return value;
	}
}
