(ns user
  (:use clojure.test))

(defn nucleotide
  [dna]
  (reduce (fn [[a c g t] n]
            (case n
              \A [(+ a 1) c g t]
              \C [a (+ c 1) g t]
              \G [a c (+ g 1) t]
              \T [a c g (+ t 1)]))
          [0 0 0 0]
          (seq dna)))

(deftest test-nucleotide
  (is (= (nucleotide
          "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC")
         [20 12 17 21])))
