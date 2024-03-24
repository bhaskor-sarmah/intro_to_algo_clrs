package com.bhaskor.moshHamedaniDsa.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Exercise: Using stack write a program to find if the brackets in a given
 * String is balanced.
 * 
 * <p>
 * Example:-
 * <p>
 * <code>"[(5 + 2)]{2 * 2}{[(1 + 1)(<5 / 2>)]( 6* 2)}" - isBalanced() true</code>
 * <p>
 * <code>"[(2+ 2])" - isBalanced() false</code>
 * 
 * @author bhaskor
 */
public class BalanceString {

	private static final List<Character> openingBrackets = Arrays.asList('(', '{', '[', '<');
	private static final List<Character> closingBrackets = Arrays.asList(')', '}', ']', '>');

	public boolean isBalanced(String input) {

		Stack<Character> characterStack = new Stack<>();

		for (Character ch : input.toCharArray()) {
			if (isOpeningBracket(ch))
				characterStack.push(ch);
			else if (isCloseBracket(ch)) {
				if (characterStack.isEmpty())
					return false;
				Character openBracketCh = characterStack.pop();
				if (!bracketsMatch(openBracketCh, ch)) {
					return false;
				}
			}
		}

		return true;
	}

	private boolean isOpeningBracket(Character ch) {
		return openingBrackets.contains(ch);
	}

	private boolean isCloseBracket(Character ch) {
		return closingBrackets.contains(ch);
	}

	private boolean bracketsMatch(Character openBracketCh, Character closingBracketCh) {
		return openingBrackets.indexOf(openBracketCh) == closingBrackets.indexOf(closingBracketCh);
	}

}
