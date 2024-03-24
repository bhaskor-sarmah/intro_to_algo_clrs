package com.bhaskor.moshHamedaniDsa.stack

import spock.lang.Specification
import spock.lang.Subject

/**
 * Unit tests for {@link BalanceString}
 * 
 * @author bhaskor
 */
class BalanceStringSpec extends Specification{

	@Subject
	BalanceString balanceString

	def setup() {
		balanceString = new BalanceString();
	}

	def "isBalanced() when input string is not balanced, should return false"() {
		given:
		def inputString = "[(2+ 2])"
		
		when:
		def result = balanceString.isBalanced(inputString);
		
		then:
		result == false
		
		when: "Input string starts with a closing brackets"
		result = balanceString.isBalanced(")");
		
		then:
		result == false
	}

	def "isBalanced() when input string is balanced, should return true"() {
		given:
		def inputString = "[(5 + 2)]{2 * 2}{[(1 + 1)(<5 / 2>)]( 6* 2)}"
		
		when:
		def result = balanceString.isBalanced(inputString);
		
		then:
		result == true
		
		when: "Input string is blank"
		result = balanceString.isBalanced("");
		
		then:
		result == true
	}
}
