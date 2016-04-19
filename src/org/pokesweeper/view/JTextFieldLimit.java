package org.pokesweeper.view;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class JTextFieldLimit extends PlainDocument{

	private static final long serialVersionUID = 1L;
	private int limitea;
	
	public JTextFieldLimit(int pLimitea) {
		super();
		this.limitea = pLimitea;
	}
	
	public void insertString( int offset, String  str, AttributeSet attr ) throws BadLocationException {
		if (str == null) return;

		if ((getLength() + str.length()) <= limitea) {
			super.insertString(offset, str, attr);
		}
	}
}
