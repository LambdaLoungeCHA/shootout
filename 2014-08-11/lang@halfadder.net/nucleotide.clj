(ns nucleotide
  (:use clojure.test))

(defn nucleotide-reduce
  [dna]
  (reduce (fn [[a c g t] n]
            (case n
              \A [(+ a 1) c g t]
              \C [a (+ c 1) g t]
              \G [a c (+ g 1) t]
              \T [a c g (+ t 1)]))
          [0 0 0 0]
          (seq dna)))

(defn nucleotide-iterate
  [dna]
  (let [end (count dna)]
    (loop [a 0 c 0 g 0 t 0 idx 0]
      (if (>= idx end)
        [a c g t]
        (case (.charAt dna idx)
          \A (recur (+ a 1) c g t (+ idx 1))
          \C (recur a (+ c 1) g t (+ idx 1))
          \G (recur a c (+ g 1) t (+ idx 1))
          \T (recur a c g (+ t 1) (+ idx 1)))))))

(deftest test-nucleotide
  (is (= (nucleotide-reduce
          "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC")
         [20 12 17 21]))

  (is (= (nucleotide-iterate
          "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC")
         [20 12 17 21])))
