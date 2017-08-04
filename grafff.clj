(ns grafff.core)

(defn start-with-edge [a b]
  {a (conj nil b)})

(defn add-edge [g a b]
  (update g a #(conj % b)))

(defn edge
  ([a b] (start-with-edge a b))
  ([g a b] (add-edge g a b)))

(def g (->
 (edge :vertex 90)
 (edge :vertex 80)
 (edge :vertex 70)

 (edge 70 100)
 (edge 100 120)
 (edge 120 4)
 (edge 120 6)
 (edge 120 8)))

(defn travel [g v mem]
  (if (contains? g v)
    (reduce
     #(flatten (conj %1 %2))
     (conj mem v)
     (map #(travel g % mem) (g v)))
    v))
