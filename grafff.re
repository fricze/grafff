let graph = ref [];

let edge g a => List.append [[a]] g;

graph := edge graph.contents [3, 4];

graph := edge graph.contents [4, 5];

graph := edge graph.contents [5, 9];

graph := edge graph.contents [9, 1];

graph := edge graph.contents [1, 3];

graph := edge graph.contents [5, 8];

let equalWithNth n x el => List.nth el n === x;

let equalWithFirst x el =>
  switch el {
  | [a, b] => a === x
  | _ => false
  };

let equalWithScnd x el =>
  switch el {
  | [a, b] => b === x
  | _ => false
  };

let flip f x y => f y x;

let nthFlip = flip List.nth;

let vertexRelation start show vertex graph =>
  List.filter (equalWithNth start vertex) graph |> List.map (nthFlip show);

let fromVertex = vertexRelation 0 1;

let toVertex = vertexRelation 1 0;

let gg = Hashtbl.create 10;

let hashEdge g a b => {
  let l = [];
  Hashtbl.add g a l;
  Hashtbl.add g a (List.append b l)
};
