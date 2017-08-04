(ns grafff.core)

(defn start-with-edge [a b]
  {a (conj nil b)})

(defn add-edge [g a b]
  (update g a #(conj % b)))

(defn edge
  ([a b] (start-with-edge a b))
  ([g a b] (add-edge g a b)))

(->
 (edge :vertex 90)
 (edge :vertex 80)
 (edge :vertex 70))
