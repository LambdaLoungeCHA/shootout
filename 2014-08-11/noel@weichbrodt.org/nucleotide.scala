package org.noelweichbrodt.nucleotide

object Nucleotide {

	def length(dna:String):(Int,Int,Int,Int) = {
		return (dna.count('A'==),dna.count('C'==),dna.count('G'==),dna.count('T'==))
	}

	def test1():Boolean = {
		var input = "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC"
		var expected = (20, 12, 17, 21)
		var actual = length(input)
		return actual == expected
	}

	def test2():Boolean = {
		var input = "GGTATTTTAATTTATAGT"
		var expected = (5, 0, 3, 10)
		var actual = length(input)
		return actual == expected
	}

}