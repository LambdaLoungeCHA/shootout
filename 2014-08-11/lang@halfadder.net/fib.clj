(ns fib
  (:use clojure.test))

(defn fib-naive
  [n k]
  (if (> n 2)
    (+ (fib-naive (- n 1) k)
       (* (fib-naive (- n 2) k)
          k))
    1))

(defn fib-memo
  ([n k]
     (fib-memo n k 1 0))
  ([n k n1 n2]
     (if (> n 1)
       (fib-memo (- n 1)
                 k
                 (+ n1
                    (* n2 k))
                 n1)
       n1)))

(deftest test-fib
  (is (= (for [x (range 1 10)]
           (fib-naive x 1))
         '(1 1 2 3 5 8 13 21 34)))

  (is (= (for [x (range 1 10)]
           (fib-memo x 1))
         '(1 1 2 3 5 8 13 21 34)))

  (is (= (for [x (range 1 10)]
           (fib-naive x 3))
         '(1 1 4 7 19 40 97 217 508)))

  (is (= (for [x (range 1 10)]
           (fib-memo x 3))
         '(1 1 4 7 19 40 97 217 508)))

  (is (= (fib-naive 5 3) 19))
  (is (= (fib-memo 5 3) 19)))
