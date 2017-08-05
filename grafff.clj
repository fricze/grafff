(ns grafff.core)

(defn start-with-edge [a b]
  {a (conj nil b)})

(defn add-edge [g a b]
  (update g a #(conj % b)))

(defn edge
  ([a b] (start-with-edge a b))
  ([g a b] (add-edge g a b)))

(def g (->
        (edge 70 100)
        (edge 100 120)
        (edge 100 130)
        (edge 100 140)
        (edge 120 8)
        (edge 8 70)))

(defn travel-1 [g v been-there]
  (cond
    ;; if g doesn't contain v it means node v doesn't
    ;; have any edge going out, so we're just adding
    ;; it to set
    (not (contains? g v)) [v]
    (and
     (contains? g v)
     (not ((into #{} been-there) v)))
    (let [been-there (conj been-there v)] (reduce
                                           #(clojure.set/union %1 %2)
                                           been-there
                                           (map #(travel-1 g % been-there) (g v))))
    (and
     (contains? g v)
     ((into #{} been-there) v)) [v]))

(println "--------------")

(travel-1 g 70 [])
(travel-1 g 70 #{})

;; ->
;; (edge 70 100)
;; (edge 100 120)
;; (edge 100 130)
;; (edge 100 140)
;; (edge 120 8)
;; (edge 8 70)
