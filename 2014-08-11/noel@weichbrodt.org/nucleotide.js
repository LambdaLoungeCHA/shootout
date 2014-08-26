var nucleotide = {

	length: function(dna) {
		var dna_array = dna.split('');
		return {
			a: dna_array.filter(function(e) { return e == 'A'; }).length,
			c: dna_array.filter(function(e) { return e == 'C'; }).length,
			g: dna_array.filter(function(e) { return e == 'G'; }).length,
			t: dna_array.filter(function(e) { return e == 'T'; }).length
		}						
	}, 

	test1: function() {
		var input = 'AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC';
		var expected = {a:20, c:12, g:17, t:21};
		var actual = this.length(input);
		return (actual.a === expected.a && actual.c === expected.c && actual.g === expected.g && actual.t === expected.t);
	},

	test2: function() {
		var input = 'GGTATTTTAATTTATAGT';
		var expected = {a:5, c:0, g:3, t:10};
		var actual = this.length(input);
		return (actual.a === expected.a && actual.c === expected.c && actual.g === expected.g && actual.t === expected.t);
	}
}