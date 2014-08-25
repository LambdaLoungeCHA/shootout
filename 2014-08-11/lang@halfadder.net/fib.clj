(ns fib
  (:use clojure.test))

(def fib-naive
  (fn fib
    ([n] (fib n 1))
    ([n k]
       (if (< n 2)
         n
         (+ (fib (- n 1))
            (fib (- n 2)))))))

(deftest test-fib
  (is (= (fib-naive 5 3) 19))
  (is (= (fib-naive 9))))
