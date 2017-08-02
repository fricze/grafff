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
  | [] => false
  | [a] => a === x
  | [a, b] => a === x
  | _ => false
  };

let equalWithScnd x el =>
  switch el {
  | [] => false
  | [a] => false
  | [a, b] => b === x
  | _ => false
  };

let flip f x y => f y x;

let nthFlip = flip List.nth;

let fromVerticle x g =>
  List.filter (equalWithNth 0 x) g |> List.map (nthFlip 1);

let toVerticle x g =>
  List.filter (equalWithNth 1 x) g |> List.map (nthFlip 0);

let gg = Hashtbl.create 10;

let hashEdge g a b => {
  let l = [];
  Hashtbl.add g a l;
  Hashtbl.add g a (List.append b l)
};
