let graph = ref [];

let edge g a => List.append [[a]] g;

graph := edge graph.contents [3, 4];

graph := edge graph.contents [4, 5];

graph := edge graph.contents [5, 9];

graph := edge graph.contents [9, 1];

graph := edge graph.contents [1, 3];

graph := edge graph.contents [5, 8];

/* switch el { */
/* | [] => false */
/* | [a, b] => a === x */
/* | [a, b, ...rest] => false */
/* }; */
let equalWithNth n x el => List.nth el n === x;

let filterTo = equalWithNth 1;

let filterFrom = equalWithNth 0;

/* switch el { */
/* | [] => false */
/* | [a, b] => b === x */
/* | [a, b, ...rest] => false */
/* }; */
let flip f x y => f y x;

let fromVerticle x g =>
  List.filter (filterFrom x) g |> List.map (flip List.nth 1);

let toVerticle x g =>
  List.filter (filterTo x) g |> List.map (flip List.nth 0);

let gg = Hashtbl.create 10;

let hashEdge g a b => {
  let l = [];
  Hashtbl.add g a l;
  Hashtbl.add g a (List.append b l)
};
