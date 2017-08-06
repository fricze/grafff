(ns grafff.core)

(defn start-with-edge [a b]
  {a (conj nil b)})

(defn add-edge [g a b]
  (update g a #(conj % b)))

(defn edge
  ([a b] (start-with-edge a b))
  ([g a b] (add-edge g a b)))

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

(travel-1 g 70 [])
(travel-1 g 70 #{})

(defn nodes [g]
  (into
   #{}
   (concat
    (keys g)
    (reduce concat [] (vals g)) )))

(nodes g)

(defn edges [g]
  (apply concat
         (map-indexed
          (fn [i [a b]] (map (fn [x] [a x]) b))
          g)))

(edges g)

(defn successors [g v]
  (g v))

(successors g 100)

(defn predecessors [g v]
  (map first (filter (fn [[a b]] (some #{v} b)) g)))

(predecessors g 8)

(defn -parent [parent g]
  (ffirst
   (filter (fn [[_ b]] (some #{parent} b)) g)))

(defn path [v1 v2 g]
  (loop [parent (-parent v2 g)
         p (conj nil v2)]
    (if (= v1 parent)
      (conj p parent)
      (recur (-parent parent g) (conj p parent)))))

(path 70 130 g)

(def g (->
        (edge 70 100)
        (edge 100 120)
        (edge 100 130)
        (edge 100 140)
        (edge 120 8)
        (edge 140 8)
        (edge 130 8)
        (edge 8 70)))

(defn graph [& rest]
  (reduce (fn [g [a b]] (edge g a b)) {} rest))

(graph [70 100] [100 120] [100 130] [130 8] [8 70])
