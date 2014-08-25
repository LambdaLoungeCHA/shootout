//! # Mendels First Law #
//!
//! This implementation is bare-bones. The math was worked out on
//! paper and transcribed into the `mendel` function.
//!
//! Overall, implementing the algorithm was very easy. Simple Rust
//! like this is easy to write. Overall, it feels alot like writing
//! slightly "modernize" C++.
//!
//! Tooling is easy to use, compiler warnings and errors are very
//! helpful. Having a markdown-based documentation generator is very
//! nice. Benchmarking is nice!
//!
//! It took a while to figure out how to parse command-line arguments
//! to floating point numbers. It took a little more time to figure
//! out why passing `args[1]` to `to_f64` didn't work (i.e. needed
//! borrowed pointers). It also took some time to get rid of the
//! dead-code warning after adding a unit test.
//!
//! See also: [Mendel's First Law](http://rosalind.info/problems/iprb/)

extern crate test;

use std::os;
use test::Bencher;


/// Given three positive integers k, m, and n, representing a
/// population containing k+m+n organisms: k individuals are
/// homozygous dominant for a factor, m are heterozygous, and n are
/// homozygous recessive.
///
/// Return the probability that two randomly selected mating organisms
/// will produce an individual possessing a dominant allele (and thus
/// displaying the dominant phenotype). Assume that any two organisms
/// can mate.

pub fn mendel(k: f64, m: f64, n: f64) -> f64 {

    // Let `p` be the total population.
    let p = k + m + n;

    return
        // Pr(X = HomozygousDominant)
        k/p +

        // Pr(X = HomozygousRecessive), Pr(Y = HomozygousDominant)
        (n/p)*(k/(p-1.0)) +

        // Pr(X = HomozygousRecessive), Pr(Y = Heterozygous), Pr(A = Dominant)
        (n/p)*(m/(p-1.0))*0.5 +

        // Pr(X = Heterozygous), Pr(Y = HomozygousDominant)
        (m/p)*(k/(p-1.0)) +

        // Pr(X = Heterozygous), Pr(Y = Heterozygous), Pr(A != Recessive and B != Recessive)
        (m/p)*((m-1.0)/(p-1.0))*0.75 +

        // Pr(X = Heterozygous), Pr(Y = Recessive), Pr(A = Dominant)
        (m/p)*(n/(p-1.0))*0.5
}

// Unit tests are attributed with `test`. They aren't compiled by
// default. Do `rustc --test` to compile them.

#[test]
fn test_mendel() {
    assert!(mendel(2.0, 2.0, 2.0) - 0.783333 < 0.00001)
}

#[bench]
fn bench_mendel(b: &mut Bencher) -> () {
    b.iter(|| {
        mendel(2.0, 2.0, 2.0)
    })
}


/// Command line arguments are String objects. To parse them, use
/// `from_str`, which takes a string slice. The `from_str` method
/// returns an `Option` enumeration (like Haskell's Maybe). It must be
/// unwrapped to extract the value.

fn to_f64(str: &String) -> f64 {
    return from_str::<f64>(str.as_slice()).unwrap()
}


/// Compiling with tests produces a dead-code warning for `main`, so
/// disable the warnings.

#[allow(dead_code)]
fn main() {
    let args = os::args();

    // The parameters k, m, and n are given from the command line.
    let k = to_f64(&args[1]);
    let m = to_f64(&args[2]);
    let n = to_f64(&args[3]);

    println!("{0}", mendel(k, m, n));
}
