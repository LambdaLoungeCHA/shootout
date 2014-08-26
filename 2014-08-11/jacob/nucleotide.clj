(ns user
  (:use clojure.test))

(defn count-DNA
  [dna-string]
  (loop [v [0 0 0 0] s dna-string]
    (if (empty? s)
      v
      (let [l (str (first s))
            f (fn [i] (assoc v i (inc (v i))))]
        (cond (= l "A")
              (recur (f 0) (rest s))
              (= l "C")
              (recur (f 1) (rest s))
              (= l "G")
              (recur (f 2) (rest s))
              (= l "T")
              (recur (f 3) (rest s))
              :else
              "Error; non dna sequence letter in string")))))

(defn count-DNA2
  [dna-string]
  (let [{a \A c \C g \G t \T} (frequencies dna-string)]
    [a c g t]))

(deftest test-nucleotide
  (is (= (count-DNA "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC")
         [20 12 17 21]))
  (is (= (count-DNA2 "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC")
         [20 12 17 21])))
