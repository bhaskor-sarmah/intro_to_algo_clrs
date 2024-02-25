package com.bhaskor.IntroToAlgoClrs.chapter2

import spock.lang.Specification
import spock.lang.Subject

/**
 * Unit test for class {@link AddBinaryIntegers}
 * 
 * @author bhaskor
 */
class AddBinaryIntegersSpec extends Specification {

	@Subject
	def AddBinaryIntegers addBinaryIntegers;

	def setup() {
		addBinaryIntegers = new AddBinaryIntegers();
	}

	def "test addBinaryInterger() with carry [15, 1]"() {
		given:
		int[] firstNumber = [1, 1, 1, 1]  // Binary 15
		int[] secondNumber = [0, 0, 0, 1] // Binary 1
		when:
		def result = addBinaryIntegers.addBinaryInteger(firstNumber, secondNumber)

		then:
		result == [1, 0, 0, 0, 0] // Binary 16
	}

	def "test addBinaryInterger() without carry [2, 5]"() {
		given:
		int[] firstNumber = [0, 0, 1, 0]  // Binary 2
		int[] secondNumber = [0, 1, 0, 1] // Binary 5
		when:
		def result = addBinaryIntegers.addBinaryInteger(firstNumber, secondNumber)

		then:
		result == [0, 0, 1, 1, 1] // Binary 7
	}

	def "test addBinaryInterger() with double carry [15, 11]"() {
		given:
		int[] firstNumber = [1, 1, 1, 1]  // Binary 15
		int[] secondNumber = [1, 0, 1, 1] // Binary 11
		when:
		def result = addBinaryIntegers.addBinaryInteger(firstNumber, secondNumber)

		then:
		result == [1, 1, 0, 1, 0] // Binary 26
	}
}
