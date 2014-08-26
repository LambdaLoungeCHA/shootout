(ns user
  (:use clojure.test))

(defn weproduction
  [months pairs]
  (loop [p 0 w 1 m 1]
    (do (println "wabbit pairs: " w " months: " m)
        (if (= m months)
          w
          (recur w
                 ;; next months population increase will be last
                 ;; months population multiplied by the number of
                 ;; pairs being used
                 (+ (* p pairs) w)
                 (+ m 1))))))

(deftest test-weproduction
  (is (= (weproduction 5 3) 19))
  (is (= (weproduction 6 1) 8)))
