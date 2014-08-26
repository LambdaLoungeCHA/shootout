var nucleotide = {

	length: function(dna) {
		var dna_array = dna.split('');
		return [dna_array.filter(function(e) { return e == 'A'; }).length, 
				dna_array.filter(function(e) { return e == 'C'; }).length,
				dna_array.filter(function(e) { return e == 'G'; }).length,
				dna_array.filter(function(e) { return e == 'T'; }).length];					
	}, 

	test1: function() {
		var input = 'AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC';
		var expected = [20, 12, 17, 21];
		var actual = this.length(input);
		return (actual[0] === expected[0] && actual[1] === expected[1] && actual[2] === expected[2] && actual[3] === expected[3]);
	},

	test2: function() {
		var input = 'GGTATTTTAATTTATAGT';
		var expected = [5, 0, 3, 10];
		var actual = this.length(input);
		return (actual[0] === expected[0] && actual[1] === expected[1] && actual[2] === expected[2] && actual[3] === expected[3]);
	}
}