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
        (edge 120 8)
        (edge 8 70)))

(defn travel [g v mem]
  (if (and (not (some #{v} mem)) (contains? g v))
    (reduce
     #(flatten (conj %1 %2))
     mem
     (map #(travel g % (conj mem v)) (g v)))
    v))
