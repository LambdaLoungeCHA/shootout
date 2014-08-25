(ns fib
  (:use clojure.test))

(defn fib-naive
  ([n] (fib-naive n 1))
  ([n k]
     (cond (< n 1) 0
           (< n 2) 1
           :else
           (+ (fib-naive (- n 1) k)
              (* (fib-naive (- n 2) k)
                 k)))))

(deftest test-fib
  (is (= (for [x (range 1 10)]
           (fib-naive x))
         '(1 1 2 3 5 8 13 21 34)))

  (is (= (for [x (range 1 10)]
           (fib-naive x 3))
         '(1 1 4 7 19 40 97 217 508)))

  (is (= (fib-naive 5 3) 19)))
