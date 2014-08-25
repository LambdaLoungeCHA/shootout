all: run

mendel:
	rustc mendel.rs

clean:
	rm -f mendel

run: clean mendel
	./mendel 2 2 2

doc:
	rustdoc mendel.rs

test: clean
	rustc --test mendel.rs
	./mendel

bench: test
	./mendel --bench

.PHONY: doc
